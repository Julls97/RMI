import java.rmi.RemoteException;
import java.util.Date;

public interface IMessage {
    String getText() throws RemoteException;
    String getTitle() throws RemoteException;
    String getLogin() throws RemoteException;
    String getTime() throws RemoteException;
}
