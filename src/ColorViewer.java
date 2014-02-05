import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ColorViewer extends JFrame
{
    private JPanel colorPanel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    public ColorViewer()
    {
        colorPanel = new JPanel();

        add(colorPanel, BorderLayout.CENTER);
        createControlPanel();
        setSampleColor();
    }

    public void createControlPanel()
    {
        class ColorListener implements ChangeListener
        {
            public void stateChanged(ChangeEvent e)
            {
                setSampleColor();
            }
        }

        ChangeListener listener = new ColorListener();
        
        redSlider = new JSlider(0, 255, 255);
        redSlider.addChangeListener(listener);
        greenSlider = new JSlider(0, 255, 255);
        greenSlider.addChangeListener(listener);
        blueSlider = new JSlider(0, 255, 255);
        blueSlider.addChangeListener(listener);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        controlPanel.add(new JLabel("Red"));
        controlPanel.add(redSlider);
        controlPanel.add(new JLabel("Green"));
        controlPanel.add(greenSlider);
        controlPanel.add(new JLabel("Blue"));
        controlPanel.add(blueSlider);

        add(controlPanel, BorderLayout.SOUTH);
    }

    public void setSampleColor()
    {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();

        colorPanel.setBackground(new Color(red, green, blue));
        colorPanel.repaint();
    }

    public static void main(String args[])
    {
        JFrame frame = new ColorViewer();
        frame.setSize(600, 700);
        frame.setTitle("Color Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
