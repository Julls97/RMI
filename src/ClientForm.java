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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!textField1.getText().isEmpty()) {
                textArea1.setText(textField1.getText());
            }
        }
    }


}