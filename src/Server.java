import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public List<IMessage> messages = new ArrayList<IMessage>();

    public Server() {

    }
    public static void main(String[] argv) {
        try {
            AdditionImplementation impl = new AdditionImplementation();
            AdditionInterface stub = (AdditionInterface) UnicastRemoteObject.exportObject(impl, 0);
            Registry registry = LocateRegistry.createRegistry(13000);
            registry.bind("Addition", stub);
            System.err.println("Server ready");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}