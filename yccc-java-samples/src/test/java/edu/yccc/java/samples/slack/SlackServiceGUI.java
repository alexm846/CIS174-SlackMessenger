package edu.yccc.java.samples.slack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Slack Messenger GUI 
 * 
 * 
 * @author aMcMahon
 *
 */

public class SlackServiceGUI {

	private JFrame frmSlackService;
	private JTextField usernameField;
	private JTextField channelField;
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
					window.frmSlackService.setVisible(true);
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
		channel = channelField.getText();
		message = messageArea.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlackService = new JFrame();
		frmSlackService.setTitle("Slack Service");
		frmSlackService.setBounds(100, 100, 450, 483);
		frmSlackService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlackService.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(10, 11, 89, 24);
		frmSlackService.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(88, 13, 214, 24);
		frmSlackService.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		
		JLabel lblChannel = new JLabel("Channel:");
		lblChannel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChannel.setBounds(10, 57, 89, 24);
		frmSlackService.getContentPane().add(lblChannel);
		
		channelField = new JTextField();
		channelField.setBounds(88, 59, 214, 24);
		frmSlackService.getContentPane().add(channelField);
		channelField.setColumns(10);
		
		
		JLabel lblMessasge = new JLabel("Message:");
		lblMessasge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessasge.setBounds(10, 107, 81, 24);
		frmSlackService.getContentPane().add(lblMessasge);
		
		messageArea = new JTextArea();
		messageArea.setLineWrap(true);
		messageArea.setBounds(10, 142, 414, 231);
		frmSlackService.getContentPane().add(messageArea);
		
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getContent(); //get input text
				frmSlackService.setVisible(false);
				System.out.println(username + " " + channel + " " + message);
				SlackMessengerApp go = new SlackMessengerApp();
				go.testSendMessage(username, channel, message); //send message thru SlackService
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(320, 383, 89, 50);
		frmSlackService.getContentPane().add(btnSend);
	}
	
	



}
