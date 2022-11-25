package src.Infrastructure;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input extends JPanel {

    JTextField textField;
    JLabel label;

    public Input(int x, int y, Window window, String label) {
        this.setLayout(null);
        this.setBounds(x, y, window.getWidth(), 60);
        this.textField = new JTextField();
        this.textField.setBounds(120, 0, this.getWidth() / 2, 60);
        this.label = new JLabel(label);
        this.label.setBounds(30, 0, 90, 60);
        this.add(this.label);
        this.add(this.textField);
    }

    /**
     * @return the textField
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * @param textField the textField to set
     */
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

}
