import javax.swing.*;
import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.Format;
import java.util.Date;
import java.util.List;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        ClientForm form = new ClientForm();
        form.pack();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setScreenSettings(form);

        String host = (args.length < 1) ? null : args[0];
        try {
//            Registry registry = LocateRegistry.getRegistry(host);
            Registry registry = LocateRegistry.getRegistry(host, 13000);

//            IAddition stub = (IAddition) registry.lookup("Addition");
            IMessageContainer msgCont = (IMessageContainer) registry.lookup("MessageContainer");

//            String response = String.valueOf(stub.sub(10, 20));

//            Message newMsg = new Message("title1", "hi", "usr1");
//            String response = String.valueOf(msgCont.addMessage(newMsg));

//            System.out.println("response: " + response);


        while (true) {
            var msg = msgCont.getAllMessages();

            StringBuilder result = new StringBuilder();
            if (msg != null) {
                msg.forEach((x)-> {
                    try {
                        result.append(FormatMessage(x));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                });
            }
            result.toString();

//            String format = FormatMessage(msg);
            form.getTextArea1().setText(String.valueOf(result));

        }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static String FormatMessage(IMessage msg) throws RemoteException {
        return FormatMessage(msg.getTitle(), msg.getText(), msg.getLogin(), msg.getTime());
    }

    private static String FormatMessage(String title, String text, String login, String time) {
        return String.format("%s\t%s\n%s\n%s", login, time, title, text);
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