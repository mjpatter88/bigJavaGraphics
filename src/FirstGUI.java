import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael on 1/28/14.
 */
public class FirstGUI
{


    public static void main(String args[])
    {
        final double[] balance = {new Double("10000.00")};

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setTitle("Investment");

        JButton button = new JButton("Add Interest");
        final JLabel label = new JLabel("Balance: " + balance[0]);
        JPanel panel = new JPanel();

        class AddInterestListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                balance[0] = balance[0] * 1.10;
                label.setText("Balance: " + balance[0]);
            }
        }
        ActionListener list = new AddInterestListener();
        button.addActionListener(list);

        panel.add(button);
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }
}
