import javax.swing.*;
import java.awt.*;

public class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(5,10, 20, 30);
        g2.draw(box);
        for(int i=0; i<10; i++)
        {
            box.translate(15, 15);
            g2.draw(box);
        }
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setTitle("Two Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectangleComponent rects = new RectangleComponent();
        frame.add(rects);
        frame.setVisible(true);
    }
}