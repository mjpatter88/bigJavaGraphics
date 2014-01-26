import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 1/26/14.
 */
public class RectangleApplet extends JApplet
{
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle rect = new Rectangle(5,10,20,30);
        g2.draw(rect);

        for(int i=0; i<10; i++)
        {
            rect.translate(15, 15);
            g2.draw(rect);
        }
    }
}
