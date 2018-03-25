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

public class hackGUI extends JFrame {
	
	Email Email = new Email("cpbx29@gmail.com", "test", "test");
	Timer trackerTimer;
	int time;
	
	//Frames and Panels
	private JFrame frame;
	private JPanel problemPanel;
	private JPanel buttons;
	
	//Buttons and Fields n stuff
	private JButton startStop;
	private JTextField location;
	private JButton enterLocation;
	private JComboBox times;
	private JLabel fail;
	private JLabel timeLabel;
	private JLabel noResponse;
	private JLabel recipient;
	private JTextField inputEmail;
	
	String[] timesAvailable = {" 1 "," 20 "," 25 "," 30 "," 35 "," 40 "," 45 "," 50 "," 55 "," 60 "};
	
	public static void main(String[] args) {
		new hackGUI();
	}
	
	public hackGUI() {
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
		
		problemPanel.setBackground(Color.BLUE);
		buttons.setBackground(Color.RED);
		Color text = Color.decode("#272F2E");
		Color background = Color.decode("#88BDBC");
		
		//Fonts
		Font basic = new Font("Palatino", Font.BOLD, 20);
        
		//Buttons and textFields and what not
		startStop = new JButton("Start Sobreity Tracker!");
		location = new JTextField("<Location>");
		JLabel locationMarker = new JLabel("My location is/will be: ");
		enterLocation = new JButton("Enter Locaton");
		timeLabel = new JLabel("How often should we check in on you? ");
		times = new JComboBox(timesAvailable);
		recipient = new JLabel("Who do you want us to email if you need help?");
		inputEmail = new JTextField("<Recipient Email>");
		JLabel minutes = new JLabel("minute(s).");
		JTextField name = new JTextField("<Name>");
		JLabel every = new JLabel("Check in every ");
		JLabel namee = new JLabel("What is your name?");
		
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
		
		//Setting Colors...
		buttons.setBackground(background);
		problemPanel.setBackground(background);
		
		startStop.setForeground(text);
		
		//adding...
		Dimension full = new Dimension(width/3, height/18);
		Dimension half = new Dimension(width/6, height/25);
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
			
			trackerTimer = new Timer();
			trackerTimer.schedule(new EmailTask(), time);
		}
	}
	
	class EmailTask extends TimerTask {

		public void run() {
			try {
				Email.send();
				System.out.println("Email sent");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	}

}




















