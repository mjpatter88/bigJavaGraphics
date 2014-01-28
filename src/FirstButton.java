import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael on 1/27/14.
 */
public class FirstButton
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        JButton but = new JButton("Click me!");
        frame.add(but);

        class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Button Pressed!");
            }
        }

        ActionListener al = new ButtonListener();
        but.addActionListener(al);

        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
