import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;

public class Message implements IMessage, Serializable {
    private String title;
    private String text;
    private User user;
    private Date time;

    public Message(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    @Override
    public String getText() throws RemoteException {
        return text;
    }

    @Override
    public String getTitle() throws RemoteException {
        return title;
    }

    @Override
    public User getUser() throws RemoteException {
        return user;
    }

    @Override
    public String getTime() throws RemoteException {
        Time tm = new Time(this.time.getTime());
        return tm.toString();
    }
}
