/**
 * Created by sion_rees on 05/12/2016.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ChatGUI {
    String m_windowName = "Conversation";
    ChatGUI m_chatGUI;
    JFrame m_newFrame = new JFrame(m_windowName);
    JButton m_sendMessage;
    JTextField m_messageBox;
    JTextArea m_chatBox;
    JFrame m_preFrame;
    String  m_username = "Sion";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChatGUI chatGUI = new ChatGUI();
                chatGUI.display();
                chatGUI.loadConv();
            }
        });
    }

    public static void loadConv() {
        //load messages into conv
    }

    public void display() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        m_messageBox = new JTextField(30);
        m_messageBox.requestFocusInWindow();
        m_messageBox.addKeyListener(new EnterPress());


        m_sendMessage = new JButton("Send Message");
        m_sendMessage.addActionListener(new sendMessageButtonListener());


        m_chatBox = new JTextArea();
        m_chatBox.setEditable(false);
        m_chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        m_chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(m_chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(m_messageBox, left);
        southPanel.add(m_sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        m_newFrame.add(mainPanel);
        m_newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_newFrame.setSize(300, 600);
        m_newFrame.setVisible(true);
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            postToScreen();
        }
    }
    class EnterPress implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                postToScreen();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void postToScreen(){
        if (m_messageBox.getText().length() < 1) {
            // do nothing
        } else {
            //Send message to be saved too!!!
            m_chatBox.append("<" + m_username + ">:  " + m_messageBox.getText()
                    + "\n");
            m_messageBox.setText("");
        }
        m_messageBox.requestFocusInWindow();
    }


    //Testing out class in class
    //Trying to add messages to chatGUI EXPERIMENT
    public class LoadMessages {
        private ArrayList<Message> messageQueue;

        public LoadMessages() {
            messageQueue = new ArrayList<>();
        }

        public void addMessage(Message mess) {
            messageQueue.add(messageQueue.size(), mess);
        }

        public Message getMessage() {
            Message mess = messageQueue.get(0);
            messageQueue.remove(0);
            return mess;
        }
    }
}


