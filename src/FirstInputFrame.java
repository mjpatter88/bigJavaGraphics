import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael on 1/29/14.
 */
public class FirstInputFrame extends JFrame
{
    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private JLabel resultLabel;
    private JPanel panel;
    private Account account;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    public FirstInputFrame()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Interest Input");
        account = new Account(INITIAL_BALANCE);

        panel = new JPanel();

        rateLabel = new JLabel("Interest Rate: ");
        rateField = new JTextField(10);
        rateField.setText("" + DEFAULT_RATE);
        button = new JButton("Add Interest");
        resultLabel = new JLabel("Balance: " + account.getBalance());

        ActionListener list = new InterestListener();
        button.addActionListener(list);

        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        panel.add(resultLabel);
        add(panel);
        setVisible(true);
    }

    private class InterestListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            double rate = Double.parseDouble(rateField.getText())/100;
            account.setBalance(account.getBalance() + (account.getBalance()* rate));
            resultLabel.setText("Balance: " + account.getBalance());
        }
    }

    private class Account
    {
        private double balance;

        Account(double startingBalance)
        {
            balance = startingBalance;
        }

        double getBalance()
        {
            return balance;
        }

        void setBalance(double newBalance)
        {
            balance = newBalance;
        }
    }

    public static void main(String args[])
    {
        JFrame frame = new FirstInputFrame();
    }
}
