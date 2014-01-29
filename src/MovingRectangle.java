import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael on 1/28/14.
 */
public class MovingRectangle extends JComponent
{
    private Rectangle box;
    private static final int BOX_X = 5;
    private static final int BOX_Y = 5;
    private static final int BOX_WIDTH = 20;
    private static final int BOX_HEIGHT = 30;

    public MovingRectangle()
    {
        box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(box);
    }

    public void moveBox(int dx, int dy)
    {
        box.translate(dx, dy);
        repaint();  //Use this instead of calling "paintComponent" directly
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Moving Rectangle");
        frame.setSize(400, 300);
        final MovingRectangle rect = new MovingRectangle();
        frame.add(rect);
        frame.setVisible(true);

        class Animator implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rect.moveBox(1, 1);
            }
        }
        Animator anim = new Animator();
        Timer t = new Timer(10, anim);
        t.start();
    }
}
