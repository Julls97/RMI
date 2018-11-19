import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MessageContainer implements IMessageContainer {

    List<IMessage> messages;
    List<User> users = new ArrayList<>();

    @Override
    public void addMessage(Message message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<IMessage> getAllMessages() throws RemoteException {
        return messages;
    }

    @Override
    public void addUser(User user) throws RemoteException {
        users.add(user);
    }

    public MessageContainer() {
        messages = new ArrayList<IMessage>();
    }


}
