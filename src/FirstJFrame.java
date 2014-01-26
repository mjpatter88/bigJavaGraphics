/**
 * Created by Michael on 1/26/14.
 */

import javax.swing.JFrame;

public class FirstJFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("First JFrame Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
