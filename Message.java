import java.util.ArrayList;

/**
 * Created by sion_rees on 29/11/2016.
 */
public class Message {
    private final int MAX_NUMBER_OF_DESCRIPTION = 100;
    protected String description;
    protected String messageType;
    private Profile sender;
    private ArrayList<Profile> recipient;
    private String dateOfMessage;
    private String timeOfMessage;

    //Message constructor
    public Message (String description, String messageType, Profile sender,
                    ArrayList<Profile> recipient,String dateOfMessage, String timeOfMessage){
        this.description = description;
        this.messageType = messageType;
        this.sender = sender;
        this.recipient = recipient;
        this.dateOfMessage = dateOfMessage;
        this.timeOfMessage = timeOfMessage;
    }

    public String getDescription() {
        return description;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Profile getSender() {
        return sender;
    }

    public ArrayList<Profile> getRecipient() {
        return recipient;
    }

    public String getDateOfMessage() {
        return dateOfMessage;
    }

    public void setDateOfMessage(String dateOfMessage) {
        this.dateOfMessage = dateOfMessage;
    }

    public String getTimeOfMessage() {
        return timeOfMessage;
    }

    public void setTimeOfMessage(String timeOfMessage) {
        this.timeOfMessage = timeOfMessage;
    }

}
