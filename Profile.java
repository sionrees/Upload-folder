import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


/**
 * Created by sion_rees on 05/12/2016.
 */
public class Profile {
    private String m_userName;
    private String m_firstName;
    private String m_lastName;
    private String m_phoneNum;
    private Date dateAndTime;
    private String m_city;
    private String m_lastOnline;
    private ArrayList<Profile> m_contacts;
    private File m_profileImage;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Profile(String m_userName, String m_firstName, String m_lastName, String m_phoneNum, String m_city) {
        this.m_userName = m_userName;
        this.m_firstName = m_firstName;
        this.m_lastName = m_lastName;
        this.m_phoneNum = m_phoneNum;
        this.dateAndTime = new Date();
        this.m_city = m_city;
        m_contacts = new ArrayList<>();


    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getM_userName() {
        return m_userName;
    }

    public void setM_userName(String m_userName) {
        this.m_userName = m_userName;
    }

    public String getM_firstName() {
        return m_firstName;
    }

    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getM_phoneNum() {
        return m_phoneNum;
    }

    public void setM_phoneNum(String m_phoneNum) {
        this.m_phoneNum = m_phoneNum;
    }


    public String getM_city() {
        return m_city;
    }

    public void setM_city(String m_city) {
        this.m_city = m_city;
    }

    public String getM_lastOnline() {
        return m_lastOnline;
    }

    public void setM_lastOnline(String m_lastOnline) {
        this.m_lastOnline = m_lastOnline;
    }

    public ArrayList<Profile> getM_contacts() {
        return m_contacts;
    }

    public void setM_contacts(ArrayList<Profile> m_contacts) {
        this.m_contacts = m_contacts;
    }

    public File getM_profileImage() {
        return m_profileImage;
    }

    public void setM_profileImage(File m_profileImage) {
        this.m_profileImage = m_profileImage;
    }
}
