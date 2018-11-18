import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
//            Registry registry = LocateRegistry.getRegistry(host);
            Registry registry = LocateRegistry.getRegistry(host, 13000);
            AdditionInterface stub = (AdditionInterface) registry.lookup("Addition");
            String response = String.valueOf(stub.sub(10, 20));
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}