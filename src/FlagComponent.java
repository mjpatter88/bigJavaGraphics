import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Michael on 1/27/14.
 */
public class FlagComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle leftRectangle = new Rectangle(100, 100, 30, 60);
        Rectangle rightRectangle = new Rectangle(160, 100, 30, 60);

        Line2D.Double topLine = new Line2D.Double(130, 100, 160, 100);
        Line2D.Double bottomLine = new Line2D.Double(130, 160, 160, 160);

        g2.setColor(Color.GREEN);
        g2.fill(leftRectangle);
        g2.setColor(Color.RED);
        g2.fill(rightRectangle);
        g2.setColor(Color.BLACK);
        g2.draw(topLine);
        g2.draw(bottomLine);
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setTitle("Flags");

        FlagComponent flag = new FlagComponent();
        frame.add(flag);
        frame.setVisible(true);
    }
}
