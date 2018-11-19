import java.rmi.RemoteException;

public class Addition implements IAddition {
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    public int sub(int a, int b) throws RemoteException {
        return a-b;
    }
}