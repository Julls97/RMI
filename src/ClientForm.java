import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientForm extends JFrame {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;

    public ClientForm() {
        this.getContentPane().add(panel1);
        this.button1.addActionListener(new ButtonListener());
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!textField2.getText().isEmpty()) {
                textArea1.setText(textField1.getText() + "\n" + textField2.getText() + "\n\n");
            }
        }
    }


}