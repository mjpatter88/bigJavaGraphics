import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class FontViewer extends JFrame
{
	public FontViewer()
	{
        sampleField = new JLabel("Michael Patterson");
        add(sampleField, BorderLayout.CENTER);
        
        createControlPanel();
        setSampleFont();
	} 

    private void createControlPanel()
    {
        JPanel fontNamePanel = createComboBox();
        JPanel sizeGroupPanel = createCheckBoxes();
        JPanel styleGroupPanel = createRadioButtons();

        //Arrange panels
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));
        controlPanel.add(fontNamePanel);
        controlPanel.add(sizeGroupPanel);
        controlPanel.add(styleGroupPanel);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private JPanel createComboBox()
    {
        fontNameCombo = new JComboBox();
        fontNameCombo.addItem("Serif");
        fontNameCombo.addItem("SansSerif");
        fontNameCombo.addItem("Monospaced");
        fontNameCombo.setEditable(true);
        
        JPanel panel = new JPanel();
        panel.add(fontNameCombo);
        return panel;
    }

    private JPanel createCheckBoxes()
    {
        italicCheckBox = new JCheckBox("Italic");

        boldCheckBox = new JCheckBox("Bold");

        JPanel panel = new JPanel();
        panel.add(italicCheckBox);
        panel.add(boldCheckBox);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
        return panel;
    }

    private JPanel createRadioButtons()
    {
        smallButton = new JRadioButton("Small");

        mediumButton = new JRadioButton("Medium");

        largeButton = new JRadioButton("Large");
        largeButton.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(smallButton);
        group.add(mediumButton);
        group.add(largeButton);

        JPanel panel = new JPanel();
        panel.add(smallButton);
        panel.add(mediumButton);
        panel.add(largeButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        return panel;
    }

    private void setSampleFont()
    {
        String fontName = (String) fontNameCombo.getSelectedItem();

        int style = 0;
        if(italicCheckBox.isSelected())
        {
            style = style + Font.ITALIC;
        }
        if(boldCheckBox.isSelected())
        {
            style = style + Font.BOLD;
        }
        
        int size = 0;
        if(smallButton.isSelected())
        {
            size = 24;
        }
        if(mediumButton.isSelected())
        {
            size = 36;
        }
        if(largeButton.isSelected())
        {
            size = 48;
        }

        sampleField.setFont(new Font(fontName, style, size));
        sampleField.repaint();
    }

	public static void main(String args[])
	{
        JFrame frame = new FontViewer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,300);
        frame.setTitle("Font Viewer");
        frame.setVisible(true);
	}

    private JLabel sampleField;
    private JCheckBox italicCheckBox;
    private JCheckBox boldCheckBox;
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;
    private JComboBox fontNameCombo;

    private ActionListener listener;
}
