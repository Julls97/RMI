import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;

public class Message implements IMessage{
    private String title;
    private String text;
    private String login;
    private Date time;

    public Message(String title, String text, String user) {
        this.title = title;
        this.text = text;
        this.login = user;
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
    public String getLogin() throws RemoteException {
        return login;
    }

    @Override
    public String getTime() throws RemoteException {
        Time tm = new Time(this.time.getTime());
        return tm.toString();
    }
}
