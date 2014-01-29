import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Michael on 1/28/14.
 */
public class ClickingRectangle extends JComponent
{
    private Rectangle box;
    private static final int BOX_X = 5;
    private static final int BOX_Y = 5;
    private static final int BOX_WIDTH = 20;
    private static final int BOX_HEIGHT = 30;

    public ClickingRectangle()
    {
        box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(box);
    }

    public void moveBox(int x, int y)
    {
        box.setLocation(x, y);
        repaint();  //Use this instead of calling "paintComponent" directly
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Moving Rectangle");
        frame.setSize(400, 300);
        final ClickingRectangle rect = new ClickingRectangle();
        frame.add(rect);
        frame.setVisible(true);

        class MouseControl implements MouseListener
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                rect.moveBox(x, y);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        }
        MouseListener mc = new MouseControl();
        rect.addMouseListener(mc);
    }
}
