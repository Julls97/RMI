import javax.swing.*;
import java.rmi.RemoteException;
import java.util.Date;

public class Message implements IMessage{
    private String title;
    private String text;
    private String user;
    private Date date;

    @Override
    public String getText() throws RemoteException {
        return text;
    }

    @Override
    public String getTitle() throws RemoteException {
        return title;
    }

    @Override
    public String getUser() throws RemoteException {
        return user;
    }

    @Override
    public Date getDate() throws RemoteException {
        return date;
    }

    public Message(String title, String text, String user, Date date) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.date = date;
    }
}
