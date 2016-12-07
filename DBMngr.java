import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sion_rees on 07/12/2016.
 */
public class DBMngr {

    public static class LoadMessages{
        public static ArrayList<Message> getMessMYSQL(Integer sender, Integer reciver){
            ArrayList<Message> prevMess = new ArrayList<>();
            try{
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/skypatawe","root", "" );
                Statement selectStmt = myConn.createStatement();
                ResultSet sndrRslt = selectStmt.executeQuery("select * from messages where senderId ="+sender+" AND reciverId="+reciver+";");
                while(sndrRslt.next()){
                    Message loadMess = new Message(sndrRslt.getString("messageBlock")
                            ,sndrRslt.getString("messageType"), sndrRslt.getInt("sender"), sndrRslt.getInt("reciverId")
                            ,sndrRslt.getString("timeOfMessage"), sndrRslt.getString("senderName"), sndrRslt.getInt("messageId"));
                    prevMess.add(loadMess);
                }
                ResultSet recRslt = selectStmt.executeQuery("select * from messages where senderId ="+reciver+" AND reciverId="+sender+";");
                while(recRslt.next()){
                    Message loadMess = new Message(recRslt.getString("messageBlock")
                            ,recRslt.getString("messageType"), recRslt.getInt("sender"), recRslt.getInt("reciverId")
                            ,recRslt.getString("timeOfMessage"), recRslt.getString("senderName"), recRslt.getInt("messageId"));
                    prevMess.add(loadMess);
                }

            }catch(Exception exc){
                exc.printStackTrace();
            }
            return orderMess(prevMess);
        }
    }

    private static ArrayList<Message> orderMess(ArrayList<Message> messArray){
            Collections.sort(messArray, (Message m1, Message m2) -> m1.getDateOfMessage().compareTo(m2.getDateOfMessage()));
            return messArray;


    }

}

