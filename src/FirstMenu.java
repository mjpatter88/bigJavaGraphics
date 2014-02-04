import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class FirstMenu extends JFrame
{
    private JLabel sampleField;
    private String fontName;
    private int fontSize;
    private int fontStyle;

    public FirstMenu()
    {
        // Construct the sample text
        sampleField = new JLabel("Michael Patterson");
        sampleField.setHorizontalAlignment(JLabel.CENTER);
        add(sampleField, BorderLayout.CENTER);

        // Construct the menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createFontMenu());

        fontName = "Serif";
        fontSize = 24;
        fontStyle = Font.PLAIN;

        setSampleFont();
    }
    
    private JMenu createFileMenu()
    {
        JMenu menu = new JMenu("File");
        menu.add(createFileExitItem());
        return menu;
    }

    private JMenuItem createFileExitItem()
    {
        JMenuItem item = new JMenuItem("Exit");
        class MenuItemListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }

    private JMenu createFontMenu()
    {
        JMenu menu = new JMenu("Font");
        menu.add(createFaceMenu());
        menu.add(createSizeMenu());
        menu.add(createStyleMenu());
        return menu;
    }

    private JMenu createFaceMenu()
    {
        JMenu menu = new JMenu("Face");
        menu.add(createFaceItem("Serif"));
        menu.add(createFaceItem("SansSerif"));
        menu.add(createFaceItem("Monospaced"));
        return menu;
    }

    private JMenuItem createFaceItem(final String name)
    {
        JMenuItem item = new JMenuItem(name);
        class MenuItemListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                fontName = name;
                setSampleFont();
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }

    private JMenu createSizeMenu()
    {
        JMenu menu = new JMenu("Size");
        menu.add(createSizeItem("Smaller", -1));
        menu.add(createSizeItem("Larger", 1));
        return menu;
    }

    private JMenuItem createSizeItem(String name, final int ds)
    {
        JMenuItem item = new JMenuItem(name);
        class MenuItemListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                fontSize = fontSize + ds;
                setSampleFont();
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }

    private JMenu createStyleMenu()
    {
        JMenu menu = new JMenu("Style");
        menu.add(createStyleItem("Plain", Font.PLAIN));
        menu.add(createStyleItem("Bold", Font.BOLD));
        menu.add(createStyleItem("Italic", Font.ITALIC));
        menu.add(createStyleItem("Bold Italic", Font.BOLD + Font.ITALIC));
        return menu;
    }

    private JMenuItem createStyleItem(String name, final int style)
    {
        JMenuItem item = new JMenuItem(name);
        class MenuItemListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                fontStyle = style;
                setSampleFont();
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;

    }

    private void setSampleFont()
    {
        Font f = new Font(fontName, fontStyle, fontSize);
        sampleField.setFont(f);
        sampleField.repaint();
    }

    public static void main(String args[])
    {
        JFrame frame = new FirstMenu();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First Menu");
        frame.setVisible(true);
    }
}
