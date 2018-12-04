import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationDialog extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	
	public RegistrationDialog() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});
	}
	
	private void onOK() {
		if ((textField1.getText().length() >= 3) && isValidEmailAddress(textField2.getText())) {
			User user = new User(textField1.getText(), textField2.getText());
			Client.setUser(user);
			dispose();
		} else {
			textField3.setText("Illegal input. Try again.");
		}
	}
	
	private boolean isValidEmailAddress(String email) {
		Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email);
		return  matcher.find();
	}
}
