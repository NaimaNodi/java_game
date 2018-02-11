package mygame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MiniStart {

	private JFrame frame;
	private JLabel lblWelcomTo;
	private JLabel lblMinionsQuest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniStart window = new MiniStart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiniStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnGoMinion = new JButton("Go Minion!!");
		btnGoMinion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinionsQuest mini = new MinionsQuest();
				mini.NewScreen();
			}
		});
		btnGoMinion.setBackground(new Color(255, 204, 255));
		btnGoMinion.setFont(new Font("Aharoni", Font.BOLD, 18));
		frame.getContentPane().add(btnGoMinion, BorderLayout.SOUTH);
		
		lblWelcomTo = new JLabel("Welcom To");
		lblWelcomTo.setForeground(Color.BLUE);
		lblWelcomTo.setBackground(Color.PINK);
		lblWelcomTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomTo.setFont(new Font("Aharoni", Font.BOLD, 30));
		frame.getContentPane().add(lblWelcomTo, BorderLayout.NORTH);
		
		lblMinionsQuest = new JLabel("MINION's QUEST!!");
		lblMinionsQuest.setForeground(Color.MAGENTA);
		lblMinionsQuest.setBackground(Color.LIGHT_GRAY);
		lblMinionsQuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinionsQuest.setFont(new Font("Algerian", Font.BOLD, 42));
		frame.getContentPane().add(lblMinionsQuest, BorderLayout.CENTER);
	}

}
