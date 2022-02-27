package ui;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adventure.Charcter;
import adventure.Inventory;
import adventure.Property;
import sound.Sound;

@SuppressWarnings("serial")
public class SkillFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private static int money;
	private Image img1,img2,img3 = null;

	Inventory inventory = new Inventory();
	Charcter charcter = new Charcter();
	Property prop = new Property();

	public SkillFrame() {

		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		actionListener = new ActionHandler();
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/skillimage.jpg");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		

		File f1 = new File("image/human.png");
		File f2 = new File("image/jobskill2.png");
		File f3 = new File("image/back2.png");
		
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		
		JButton playerskillBtn = new JButton("");
		playerskillBtn.setIcon(new ImageIcon(img1));
		playerskillBtn.setBounds(120, 179, 151, 241);
		playerskillBtn.setActionCommand("playerskill");
		playerskillBtn.addActionListener(this.actionListener);
		contentPane.add(playerskillBtn);

		JButton jobskillBtn = new JButton("");
		jobskillBtn.setIcon(new ImageIcon(img2));
		jobskillBtn.setBounds(501, 179, 241, 241);
		jobskillBtn.setActionCommand("jobskill");
		jobskillBtn.addActionListener(this.actionListener);
		contentPane.add(jobskillBtn);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(img3));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel = new JLabel("Skill");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel.setBounds(356, 0, 121, 59);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("플레이어 스킬");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(120, 437, 159, 30);
		contentPane.add(lblNewLabel_4);

		JLabel attacklabel = new JLabel("직업 스킬");
		attacklabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		attacklabel.setBounds(571, 437, 107, 30);
		contentPane.add(attacklabel);

	}

	private class ActionHandler implements ActionListener {
		String job = charcter.getJob();

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "playerskill") {
				PlayerSkillFrame playerskillframe = new PlayerSkillFrame();
				playerskillframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "jobskill") {
				if (job.equals("warrior")) {
					WarriorSkillFrame warriorskillframe = new WarriorSkillFrame();
					warriorskillframe.setVisible(true);
					dispose();
				} else if (job.equals("archer")) {
					ArcherSkillFrame archerskillframe = new ArcherSkillFrame();
					archerskillframe.setVisible(true);
					dispose();
				} else if (job.equals("wizard")) {
					WizardSkillFrame wizardskillframe = new WizardSkillFrame();
					wizardskillframe.setVisible(true);
					dispose();
				}else if(job.equals("player")) {
					JOptionPane.showMessageDialog(null, "전직을 하지 않으셨습니다. ", 
							"미전직", JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (e.getActionCommand() == "back") {
				Sound sound = new Sound();
				sound.playSound("sound/effectsound/backbutton.wav", 1.0f, false);
				
				money = inventory.getMoney();
				SelectionFrame selectionframe = new SelectionFrame(money);
				selectionframe.setVisible(true);
				dispose();
			}

		}

	}
}
