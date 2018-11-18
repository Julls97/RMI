import java.rmi.RemoteException;
import java.util.List;

public class MessageContainer implements IMessageContainer {
    @Override
    public void addMessage(Message message) throws RemoteException {

    }

    @Override
    public List<IMessage> getAllMessages() throws RemoteException {
        return null;
    }
}
