import java.util.ArrayList;

/**
 * Created by sion_rees on 29/11/2016.
 */
import java.util.Date;

public class Message {
    private static int m_messageIdGen= 0;
    private Integer m_messageId;
    protected String m_messageBlock;
    protected String m_messageType;
    private Integer m_sender;
    private Integer m_recipient;
    private String m_dateTime;
    private String m_senderName;

    //Message constructor
    public Message(String messageBlock, String messageType, Integer sender,
                   Integer recipient, String dateTime, String senderName){
        this.m_messageBlock = messageBlock;
        this.m_messageType = messageType;
        this.m_sender = sender;
        this.m_recipient = recipient;
        this.m_senderName = senderName;
        this.m_dateTime = dateTime;
        this.m_messageId = m_messageIdGen;
        m_messageIdGen +=1;
    }
    public Message(String messageBlock, String messageType, Integer sender,
                   Integer recipient, String dateTime, String senderName, int messageId){
        this.m_messageBlock = messageBlock;
        this.m_messageType = messageType;
        this.m_sender = sender;
        this.m_recipient = recipient;
        this.m_senderName = senderName;
        this.m_dateTime = dateTime;
        this.m_messageId = messageId;
    }

    public int getMessageId() {
        return m_messageId;
    }

    public String getMessageBlock() {
        return m_messageBlock;
    }

    public String getMessageType() {
        return m_messageType;
    }

    public void setMessageType(String messageType) {
        this.m_messageType = messageType;
    }

    public Integer getSender() {
        return m_sender;
    }

    public Integer getRecipient() {
        return m_recipient;
    }

    public String getDateOfMessage() {
        return m_dateTime;
    }

    public String getSenderName() {
        return m_senderName;
    }
}
