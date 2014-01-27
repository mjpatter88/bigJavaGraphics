import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 1/27/14.
 */
public class CarComponent extends JComponent
{

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Car car1 = new Car(0, 0);

        int x = getWidth() - 60;
        int y = getHeight() - 30;
        Car car2 = new Car(x, y);

        car1.draw(g2);
        car2.draw(g2);
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cars");
        frame.setSize(300, 400);

        CarComponent cars = new CarComponent();
        frame.add(cars);
        frame.setVisible(true);
    }
}
