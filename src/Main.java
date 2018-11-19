import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        ClientForm form = new ClientForm();
        form.pack();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setScreenSettings(form);
    }

    private static void setScreenSettings(ClientForm form) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        form.setSize(screenWidth / 2, screenHeight / 2);
        form.setLocation(screenWidth / 4, screenHeight / 4);
        form.setVisible(true);
    }
}
