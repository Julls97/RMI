import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server() {
    }
    public static void main(String[] argv) {
        try {
            AdditionImplementation impl = new AdditionImplementation();
            AdditionInterface stub = (AdditionInterface)
                    UnicastRemoteObject.exportObject(impl, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Addition", stub);
            System.err.println("Server ready");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}