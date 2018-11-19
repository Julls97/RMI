import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server {
    
    public static void main(String[] argv) {
        try {
//            Addition impl = new Addition();
//            IAddition stub = (IAddition) UnicastRemoteObject.exportObject(impl, 0);
//            Registry registry1 = LocateRegistry.createRegistry(13000);
//            registry1.bind("Addition", stub);

            IMessageContainer msg = (IMessageContainer) UnicastRemoteObject.exportObject(new MessageContainer(), 0);
            Registry registry = LocateRegistry.createRegistry(13000);
            registry.bind("MessageContainer", msg); 

            System.err.println("Server ready");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}