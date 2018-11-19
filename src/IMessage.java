import java.rmi.RemoteException;

public interface IMessage {
    String getText() throws RemoteException;
    String getTitle() throws RemoteException;
    User getUser() throws RemoteException;
    String getTime() throws RemoteException;
}
