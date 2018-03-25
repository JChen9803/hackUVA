import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SobrietyTest extends JFrame {
    
    Email email = new Email("cpbx29@gmail.com", "test", "test");
    Timer trackerTimer;
    int time;
    
    int submitCounter = 0;
    
    //Frames and Panels
    private JFrame frame;
    private JPanel problemPanel;
    private JPanel buttons;
    private JPanel replacer;
    
    //Buttons and Fields n stuff
    //problem panel
    JTextField answer;
    JButton submit;
    private JButton startStop;
    private JTextField location;
    private JButton enterLocation;
    private JComboBox<String> times;
    private JLabel fail;
    private JLabel timeLabel;
    private JLabel noResponse;
    private JLabel recipient;
    private JTextField inputEmail;
    private JLabel locationMarker;
    private JLabel every;
    private JLabel minutes;
    private JLabel namee;
    private JTextField name;
    private JLabel thanks;
    private JLabel thanks2;
    
    private JLabel instructionsAnswer;
    private JLabel instructionsAnswer2;
    private JLabel instructionsAnswer3;
    private JLabel questionLabel;
    private String question;
    private String correctAnswer;
    
    private JLabel incorrectAnswerLabel;
    private JLabel correctAnswerLabel;
    
    String[] timesAvailable = {" 1 "," 20 "," 25 "," 30 "," 35 "," 40 "," 45 "," 50 "," 55 "," 60 "};
    
    public static void main(String[] args) {
        new SobrietyTest();
    }
    
    public SobrietyTest() {
        frame = new JFrame();
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        frame.setSize(width/3, height-120);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2,0));

        
        //Setting the frames..
        problemPanel = new JPanel();
        buttons = new JPanel();
        
        
        //setLayout
        problemPanel.setLayout(new FlowLayout());
        buttons.setLayout(new FlowLayout());
        
        Dimension panell = new Dimension(width/3, (height-120)/3);
        problemPanel.setPreferredSize(panell);
        
        //Adding...
        frame.add(problemPanel, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.SOUTH);
        
        
        //Colors
        
        Color text = Color.decode("#272F2E");
        Color background = Color.decode("#DBF9FB");
        
        //Fonts
        Font basic = new Font("Palatino", Font.BOLD, 20);
        Font basic2 = new Font("Palatino", Font.BOLD, 10);
        
        //Buttons and textFields and what not
        startStop = new JButton("Start Sobriety Tracker!");
        location = new JTextField("<Location>");
        JLabel locationMarker = new JLabel("My location is/will be: ");
        enterLocation = new JButton("Enter Locaton");
        timeLabel = new JLabel("How often should we check in on you? ");
        times = new JComboBox<String>(timesAvailable);
        recipient = new JLabel("Who do you want us to email if you need help?");
        inputEmail = new JTextField("<Recipient Email>");
        minutes = new JLabel("minute(s).");
        name = new JTextField("<Name>");
        every = new JLabel("Check in every ");
        namee = new JLabel("What is your name?");

        
        //buttons/fields
        instructionsAnswer = new JLabel("Answer the question below.");
        instructionsAnswer2 = new JLabel("If you fail 5 times or take longer than 10 minutes to respond,");
        instructionsAnswer3 = new JLabel("Your selected person will be notified of your situation");
        answer = new JTextField("<Answer>");
        submit = new JButton("Submit Answer");
        
        problemPanel.add(instructionsAnswer);
        problemPanel.add(answer);
        problemPanel.add(submit);
        answer.setVisible(false);
        submit.setVisible(false);
        
        
        //Setting the font
        startStop.setFont(basic);
        location.setFont(basic);
        locationMarker.setFont(basic);
        enterLocation.setFont(basic);
        timeLabel.setFont(basic);
        times.setFont(basic);
        recipient.setFont(basic);
        inputEmail.setFont(basic);
        minutes.setFont(basic);
        every.setFont(basic);
        namee.setFont(basic);
        name.setFont(basic);
        instructionsAnswer.setFont(basic2);
        instructionsAnswer2.setFont(basic2);
        instructionsAnswer3.setFont(basic2);
        
        //Setting Colors...
        buttons.setBackground(background);
        problemPanel.setBackground(background);
        frame.getContentPane().setBackground(background);
        
        startStop.setForeground(text);
        
        //adding...
        Dimension full = new Dimension(width/3, height/18);
        Dimension half = new Dimension(width/6, height/25);
        Dimension text2 = new Dimension(width/3, height/18);
        startStop.setPreferredSize(full);
        //location.setPreferredSize(half);
        //locationMarker.setPreferredSize(half);
        inputEmail.setPreferredSize(half);
        name.setPreferredSize(half);
        problemPanel.setPreferredSize(panell);
        location.setPreferredSize(half);
        
        //problem panel
        
        
        //adding action listeners
        startStop.addActionListener(new StartTrackerListener());
        submit.addActionListener(new SubmitListener());
        
        problemPanel.add(instructionsAnswer2);
        problemPanel.add(instructionsAnswer3);
        
        //buttons
        buttons.add(locationMarker);
        buttons.add(location);
        buttons.add(timeLabel);
        buttons.add(every);
        buttons.add(times);
        buttons.add(minutes);
        buttons.add(recipient);
        buttons.add(inputEmail);
        buttons.add(namee);
        buttons.add(name);
        buttons.add(startStop);
        
        
        
        frame.setVisible(true);
    }
    
    private class StartTrackerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            time = Integer.parseInt(times.getSelectedItem().toString().trim()) * 60000;
            buttons.removeAll();
            
            
            thanks = new JLabel("Thank you! We Will check on you in " + (time/60000) + " minute(s).");
            thanks2 = new JLabel("Be Safe!");
            Font basic = new Font("Palatino", Font.BOLD, 20);
            Font basic2 = new Font("Palatino", Font.BOLD, 50);
            thanks2.setFont(basic2);
            thanks.setFont(basic);
            //thanks.setPreferredSize(200,200);
            buttons.add(thanks);
            buttons.add(thanks2);
            
            buttons.validate();
            buttons.repaint();
            
            trackerTimer.schedule(new showQuestionTask(), time);
        }
    }

    private class SubmitListener implements ActionListener {
    
        public void actionPerformed(ActionEvent e){
            Boolean bool = true;
            while (bool){
                String enteredAnswer = answer.getText().trim();
                if (enteredAnswer == correctAnswer){
                    incorrectAnswerLabel.setVisible(false);
                    questionLabel.setVisible(false);
                    submit.setVisible(false);
                    trackerTimer.schedule(new showQuestionTask(), time);
                    bool = false;
                }       
                else{
                    incorrectAnswerLabel.setVisible(true);
                    answer.setText("");
                }
            }
        }
    }
    
    class showQuestionTask extends TimerTask {

        public void run() {
            submit.setVisible(true);
            questionLabel.setVisible(true);
            answer.setVisible(true);
        }
    }
    
    class sendEmailTask extends TimerTask {
        
        public void run() {
            try {
                email.send();
            } 
            catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}
