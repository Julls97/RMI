import java.rmi.RemoteException;
import java.util.List;

public interface IMessageContainer {
    void addMessage(Message message) throws RemoteException;
    List<IMessage> getAllMessages() throws RemoteException;
}
