import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MessageContainer implements IMessageContainer {

    public List<IMessage> messages = new ArrayList<IMessage>();


    @Override
    public void addMessage(Message message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<IMessage> getAllMessages() throws RemoteException {
        return messages;
    }

    public MessageContainer() {
        messages = new ArrayList<IMessage>();
    }
}
