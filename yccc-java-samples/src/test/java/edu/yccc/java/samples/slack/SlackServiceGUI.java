package edu.yccc.java.samples.slack;
/**
 * Slack Messenger GUI - Project 3 -- the meat is in the button Actions
 * 
 * 
 * @author alexMcMahon
 *
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SlackServiceGUI {

	private JFrame frmSlackMessenger;
	private JTextField usernameField;
	private JComboBox<String> channelBox;
	private JTextArea messageArea;
	private String username;
	private String channel;
	private String message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlackServiceGUI window = new SlackServiceGUI();
					window.frmSlackMessenger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SlackServiceGUI() {
		initialize();
	}
	public void getContent() {
		username = usernameField.getText();
		channel = (String) channelBox.getSelectedItem();
		message = messageArea.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlackMessenger = new JFrame();
		frmSlackMessenger.setTitle("Slack Messenger");
		frmSlackMessenger.setBounds(100, 100, 650, 503);
		frmSlackMessenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlackMessenger.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Californian FB", Font.BOLD, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(70, 11, 202, 40);
		frmSlackMessenger.getContentPane().add(lblUsername);
		
		JLabel lblChannel = new JLabel("Channel");
		lblChannel.setFont(new Font("Californian FB", Font.BOLD, 18));
		lblChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChannel.setBounds(322, 11, 302, 40);
		frmSlackMessenger.getContentPane().add(lblChannel);
		
		usernameField = new JTextField();
		usernameField.setBounds(46, 48, 266, 33);
		frmSlackMessenger.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		channelBox = new JComboBox<String>();
		channelBox.setBounds(348, 48, 248, 33);
		frmSlackMessenger.getContentPane().add(channelBox);
		channelBox.setEditable(true);
		channelBox.addItem("#computersaretalking");
		channelBox.addItem("#general");
		channelBox.addItem("#integration");
		channelBox.addItem("enter Channel Name");
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Californian FB", Font.BOLD, 18));
		lblMessage.setBounds(46, 105, 266, 40);
		frmSlackMessenger.getContentPane().add(lblMessage);
		
		messageArea = new JTextArea();
		messageArea.setBounds(46, 144, 550, 241);
		frmSlackMessenger.getContentPane().add(messageArea);
		//JButton: Inheritance & interface! extends AbstractButton & implements accessible
		JButton btnSend = new JButton("Send"); 
		btnSend.addActionListener(new ActionListener() { //What? ActionListener is an interface!
			public void actionPerformed(ActionEvent arg0) {//interface method
				getContent(); //get input text
				frmSlackMessenger.setVisible(false);
				System.out.println("Success: Username: " + username + "  Channel: " +channel + "  Message: " 
				+ message + ".\n");
				printQuestions();
				SlackMessengerApp go = new SlackMessengerApp();
				go.testSendMessage(username, channel, message); //send message thru SlackService
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSend.setBounds(473, 396, 120, 57);
		frmSlackMessenger.getContentPane().add(btnSend);
	}
	public void printQuestions() {
		System.out.println("What is Mavan?");
		System.out.println("Maven is a build automation tool, with the following objectives:\n"
				+ "Making the build process easy\r\n" + 
				"Providing a uniform build system\r\n" + 
				"Providing quality project information\r\n" + 
				"Providing guidelines for best practices development\r\n" + 
				"Allowing transparent migration to new features\n");
		System.out.println("What is a jar file?");
		System.out.println("JAR stands for Java Archive.  A JAR file allows Java runtimes to \"efficiently \n"
				+ "deploy an entire application, including its classes and their associated resources, in \n"
				+ "a single request,\" where elements may be compressed to save time.");
	}
}
