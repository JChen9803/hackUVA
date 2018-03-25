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

public class PuzzlesforSafety extends JFrame {
	String message = "";
	Email email;
	Timer trackerTimer = new Timer();
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
	JButton retry;
	
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
	
	private boolean emailSend = false;

	private JLabel incorrectAnswerLabel = new JLabel("Sorry that answer is not correct, try again.");
	private JLabel correctAnswerLabel = new JLabel("     Correct!     ");
	private JLabel attemptsRemaining = new JLabel();
	private int attempts = 5;

	String[] timesAvailable = {" 0 "," 1 "," 20 "," 25 "," 30 "," 35 "," 40 "," 45 "," 50 "," 55 "," 60 "};

	public static void main(String[] args) {
		new PuzzlesforSafety();
	}

	public PuzzlesforSafety() {
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
		Font basic2 = new Font("Palatino", Font.BOLD, 15);
		Font basic3 = new Font("Times New Roman", Font.BOLD, 18);

		//Buttons and textFields and what not
		startStop = new JButton("Start Sobriety Tracker!");
		location = new JTextField("<Location>");
		locationMarker = new JLabel("My location is/will be: ");
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
		instructionsAnswer3 = new JLabel("your selected person will be notified of your situation.");
		answer = new JTextField(7);
		submit = new JButton("Submit Answer");
		retry = new JButton("Try Again");

		problemPanel.add(instructionsAnswer);
		problemPanel.add(answer);
		problemPanel.add(submit);
		answer.setVisible(false);
		submit.setVisible(false);
		retry.setVisible(false);


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
		retry.addActionListener(new retryListener());

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

		instructionsAnswer.setVisible(false);
		instructionsAnswer2.setVisible(false);
		instructionsAnswer3.setVisible(false);

		incorrectAnswerLabel.setFont(basic3);
		incorrectAnswerLabel.setForeground(Color.RED);
		problemPanel.add(incorrectAnswerLabel);
		incorrectAnswerLabel.setVisible(false);
		
		correctAnswerLabel.setFont(basic3);
		correctAnswerLabel.setForeground(Color.GREEN);
		problemPanel.add(correctAnswerLabel);
		correctAnswerLabel.setVisible(false);
		
		attemptsRemaining.setFont(basic3);
		problemPanel.add(attemptsRemaining);
		attemptsRemaining.setVisible(false);

		frame.setVisible(true);
	}

	private class StartTrackerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
			time = Integer.parseInt(times.getSelectedItem().toString().trim()) * 60000;
			buttons.removeAll();
			//problemPanel.removeAll();


			thanks = new JLabel("Thank you! We Will check on you in " + (time/60000) + " minute(s).");
			thanks2 = new JLabel("Be Safe!");
			Font basic = new Font("Palatino", Font.BOLD, 20);
			Font basic2 = new Font("Palatino", Font.BOLD, 50);
			thanks2.setFont(basic2);
			thanks.setFont(basic);
			
			

			instructionsAnswer.setVisible(true);
			answer.setVisible(true);
			submit.setVisible(true);
			
			buttons.add(thanks);
			buttons.add(thanks2);

			buttons.validate();
			buttons.repaint();

			trackerTimer.schedule(new showQuestionTask(), time);
		}
	}

	private class SubmitListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			String enteredAnswer = answer.getText().trim();

			if (enteredAnswer.equals(correctAnswer)) {
				attemptsRemaining.setVisible(false);
				incorrectAnswerLabel.setVisible(false);
				correctAnswerLabel.setVisible(true);
			}
			else {
				answer.setText("");
				if (attempts > 1) {
					incorrectAnswerLabel.setVisible(true);
					attempts --;
					attemptsRemaining.setText("Attempts Remaining: " + attempts);
					attemptsRemaining.setVisible(true);
					if (attempts == 1) {
						incorrectAnswerLabel.setText("   Warning: This is Your Last Attempt!   ");
					}
				}
				else {
					
					try {
						message = (name.getText().trim() + " has indicated to contact you if they do not respond correctly or in a timely manner to a safety prompt. They have set their location at/to " + (location.getText().trim()) + ". Please check up on " + (name.getText().trim()) + ".");
						System.out.println(message);
						System.out.println(inputEmail.getText().toString().trim());
						Email email = new Email(inputEmail.getText().toString().trim(), "Puzzles for Safety: Automated Message", message);
						email.send();
						questionLabel.setText("Email Sent!");
						
						problemPanel.removeAll();
						problemPanel.add(retry);
						retry.setVisible(true);
						problemPanel.validate();
						problemPanel.repaint();
						
						attempts --;
						attemptsRemaining.setText("Attempts Remaining: " + attempts);
					} catch (MessagingException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	private class retryListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			problemPanel.removeAll();
			buttons.removeAll();
			
			problemPanel.add(instructionsAnswer);
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
			
			problemPanel.validate();
			problemPanel.repaint();
			buttons.validate();
			buttons.repaint();
			
		}
		
	}

	class showQuestionTask extends TimerTask {

		public void run() {
			instructionsAnswer.setVisible(true);
			instructionsAnswer2.setVisible(true);
			instructionsAnswer3.setVisible(true);
			submit.setVisible(true);
			answer.setVisible(true);
			
			Questions q1 = new Questions("easy");
			question = q1.getQuestion();
			correctAnswer = q1.getAnswer();
			
			buttons.removeAll();
			
			questionLabel = new JLabel();
			questionLabel.setText(question);
			Font basic = new Font("Palatino", Font.BOLD, 50);
			questionLabel.setFont(basic);
			buttons.add(questionLabel);
			
			buttons.validate();
			buttons.repaint();
			
			questionLabel.setVisible(true);
			
			Timer sendEmail = new Timer();
			sendEmail.schedule(new sendEmailTask(), 10 * 60000);
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