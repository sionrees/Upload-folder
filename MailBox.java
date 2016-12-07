/**
 * Created by sion_rees on 29/11/2016.
 */
import java.sql.*;
import java.util.ArrayList;

public class MailBox{
    private ArrayList<Message> m_messageQueue;

    public MailBox(){
        m_messageQueue = new ArrayList<Message>();
    }


    public void notifyCurrentUser(){
        //TODO send notification to mainGUI that new mail for them has arrived
    }

    // In uml this method is called updateNewMessages
    public void updateMessages(Integer user, Integer reciver){
         // TODO Request the loading of messages that are relevant to the current
         // user and the currently selected recipient.
    }

    //In uml called forwardNewContactRequestToMainGU
    public void handelContactReq(){
        //TODO send notification and reference to MainGUI
    }

    public void queueNewMessage(Message mess){
        //!!!tests required to tell if there is problem with indexes here!!!
        this.m_messageQueue.add((m_messageQueue.size()-1), mess);
    }

    //TODO needs testing!!!
    public void sendToSave(){
        //Runs until the message queue is empty
        while(!m_messageQueue.isEmpty()){
            //removes first message
            Message message = this.m_messageQueue.get(0);
            this.m_messageQueue.remove(0);
            //Chop out data from message
            Integer senderId = message.getSender();
            int messageId = message.getMessageId();
            String messageBlock = message.getMessageBlock();
            String messageType = message.getMessageType();
            Integer reciver = message.getRecipient();
            String dateTime = message.getDateOfMessage();

            //Loops through recivers sending the message


            try{
                //get connection
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/skypatawe","root", "" );
                //create statment
                Statement myStmt = myConn.createStatement();
                //prepare statment
                String pstmt = "insert into messages (messageId, messageBlock, messageType, senderId, reciverId, timeOfMessage) values (?,?,?,?,?,?)";

                //Adds chopped out data into the insert statment, then executes
                PreparedStatement statement = myConn.prepareStatement(pstmt);
                statement.setInt(1,messageId);
                statement.setString(2,messageBlock);
                statement.setString(3, messageType);
                statement.setInt(4, senderId);
                statement.setInt(5, reciver);
                statement.setString(6, dateTime);
                statement.executeUpdate();

            }
            catch (Exception exc){
                exc.printStackTrace();
            }


        }
    }


    public boolean isEmpty(){
        return this.m_messageQueue.isEmpty();
    }


}

