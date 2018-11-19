import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMessageContainer extends Remote {
    void addMessage(Message message) throws RemoteException;
    List<IMessage> getAllMessages() throws RemoteException;
}
