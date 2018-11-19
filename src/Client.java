import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {

    static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Client.user = user;
    }

    private static List<IMessage> orderStorage = new ArrayList<>();

    public static void addOrder(IMessage msg) {
        orderStorage.add(msg);
    }


     public static void main(String[] args) {
        ClientForm form = new ClientForm();
//        form.pack();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String host = (args.length < 1) ? null : args[0];
        try {
            RegistrationDialog registration = new RegistrationDialog();
            registration.pack();
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension screenSize = tk.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;
            registration.setLocation(screenWidth / 4, screenHeight / 4);
            registration.setVisible(true);
            while (user == null) Thread.onSpinWait();


            setScreenSettings(form);


            Registry registry = LocateRegistry.getRegistry(host, 13000);
            IMessageContainer messageContainer = (IMessageContainer) registry.lookup("MessageContainer");

            messageContainer.addUser(user);

            while (true) {
                var msg = messageContainer.getAllMessages();

                if (!orderStorage.isEmpty()) {
                    messageContainer.addMessage((Message) orderStorage.get(0));
                    orderStorage.remove(0);
                }
                StringBuilder result = new StringBuilder();
                if (msg != null) {
                    msg.forEach((x) -> {
                        try {
                            result.append(formatMessage(x));
                        } catch (RemoteException e) {
                            System.err.println("Client exception: " + e.toString());
//                            e.printStackTrace();
                        }
                    });
                }
                result.toString();
                form.getTextArea1().setText(String.valueOf(result));
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
//            e.printStackTrace();
        }
    }

    private static String formatMessage(IMessage msg) throws RemoteException {
        return formatMessage(msg.getTitle(), msg.getText(), msg.getUser().name, msg.getTime());
    }

    private static String formatMessage(String title, String text, String login, String time) {
        return String.format("%s\t%s\n%s\n%s\n", login, time, title, text);
    }

    private static void setScreenSettings(JFrame form) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        form.setSize(screenWidth / 2, screenHeight / 2);
        form.setLocation(screenWidth / 4, screenHeight / 4);
        form.setVisible(true);
    }
}