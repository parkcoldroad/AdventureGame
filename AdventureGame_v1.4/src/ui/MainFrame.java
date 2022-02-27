package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sound.Sound;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Image img = null;
	private ActionListener actionListener;
	private static int money = 200;

	/**
	 * this.setLocationRelativeTo(null); gui를 화면 정중앙에 띄워주는 메소드 주의점은 화면의 크기를 맞춰주는
	 * setSize나 setBounds 메소드 아래에다가 써야 실행된다.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainframe = new MainFrame();
					mainframe.setVisible(true);

					Sound sound = new Sound();
					sound.playBgm("sound/bgm/enterforest.wav", 1.0f, true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setTitle("Adventure Game");
		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 390);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		File f = new File("image/adventure.jfif");
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		setIconImage(img);


		JLabel imagelabel = new JLabel(new ImageIcon(img));
		imagelabel.setBounds(90, 42, 274, 211);
		contentPane.add(imagelabel);

		JButton startbtn = new JButton("Start");
		startbtn.setForeground(Color.BLUE);
		startbtn.setActionCommand("start");
		startbtn.addActionListener(this.actionListener);
		startbtn.setBounds(175, 275, 91, 23);
		startbtn.setBackground(Color.white);
		contentPane.add(startbtn);

		JButton exitbtn = new JButton("Exit");
		exitbtn.setForeground(Color.RED);
		exitbtn.setBounds(175, 308, 91, 23);
		exitbtn.setActionCommand("exit");
		exitbtn.addActionListener(this.actionListener);
		exitbtn.setBackground(Color.white);
		contentPane.add(exitbtn);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 426, 333);
		contentPane.add(panel);
				panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Adventure Game");
				lblNewLabel.setBounds(102, 10, 232, 41);
				panel.add(lblNewLabel);
				lblNewLabel.setForeground(Color.RED);
				lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
				
				JLabel lblNewLabel_1 = new JLabel("made by coldroad");
				lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 13));
				lblNewLabel_1.setForeground(Color.BLUE);
				lblNewLabel_1.setBounds(305, 318, 121, 15);
				panel.add(lblNewLabel_1);
	}

	@SuppressWarnings("unused")
	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "start") {
				EnterFrame enterframe = new EnterFrame(money);
				enterframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "exit") {
				System.exit(0);
			}

		}
	}
}
