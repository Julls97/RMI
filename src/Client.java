import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
//            Registry registry = LocateRegistry.getRegistry(host);
            Registry registry = LocateRegistry.getRegistry(host, 13000);

//            IAddition stub = (IAddition) registry.lookup("Addition");
            IMessageContainer msgCont = (IMessageContainer) registry.lookup("MessageContainer");

//            String response = String.valueOf(stub.sub(10, 20));

            Date date = new Date();
            Message newMsg = new Message("title1", "hi", "usr1", date);
//            String response = String.valueOf(msgCont.addMessage(newMsg));

//            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}