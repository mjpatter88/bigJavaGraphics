import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Created by Michael on 1/26/14.
 */
public class FaceArt extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D.Double head = new Ellipse2D.Double(5, 5, 100, 150);
        g2.draw(head);

        g2.drawString("Hello, World!", 20, 170);

        Line2D.Double eye1 = new Line2D.Double(30, 50, 45, 70);
        g2.draw(eye1);

        Line2D.Double eye2 = new Line2D.Double(80, 50, 65, 70);
        g2.draw(eye2);

        g2.setColor(Color.RED);
        Line2D.Double mouth = new Line2D.Double(35, 120, 75, 120);
        g2.draw(mouth);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setTitle("Face Drawing");

        JComponent face = new FaceArt();
        frame.add(face);
        frame.setVisible(true);
    }
}
