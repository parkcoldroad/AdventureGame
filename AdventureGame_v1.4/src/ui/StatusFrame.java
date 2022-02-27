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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adventure.Charcter;
import adventure.Inventory;
import adventure.Property;
import sound.Sound;

@SuppressWarnings("serial")
public class StatusFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private static int money;
	private static String name;
	private static String jobname;
	private static String property;

	private int playerlevel;
	private int joblevel;
	private int jobattack;
	private int jobhp;
	private int jobmp;

	Inventory inventory = new Inventory();
	Charcter charcter = new Charcter();
	Property prop = new Property();

	public StatusFrame(String playername) {
		jobname = charcter.getJob();
		charcter.jobSetProperty(jobname);

		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		actionListener = new ActionHandler();
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/status2.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		JButton backBtn = new JButton("back");
		backBtn.setIcon(new ImageIcon("image/back2.png"));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel = new JLabel("Status");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel.setBounds(356, 0, 121, 59);
		contentPane.add(lblNewLabel);

		name = playername;
		JLabel lblNewLabel_1 = new JLabel("이름: " + name);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(36, 79, 441, 59);
		contentPane.add(lblNewLabel_1);

		playerlevel = charcter.getPlayerlevel();
		JLabel lblNewLabel_2 = new JLabel("플레이어 레벨: " + playerlevel);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(36, 159, 337, 45);
		contentPane.add(lblNewLabel_2);

		jobname = charcter.getJob();
		JLabel lblNewLabel_3 = new JLabel("직업: " + jobname);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(36, 226, 366, 39);
		contentPane.add(lblNewLabel_3);

		joblevel = charcter.getJobLevel(jobname);
		JLabel lblNewLabel_4 = new JLabel("직업 레벨: " + joblevel);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(35, 293, 457, 30);
		contentPane.add(lblNewLabel_4);

		jobattack = charcter.jobSetAttack(jobname);
		JLabel attacklabel = new JLabel("공격력: " + jobattack);
		attacklabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		attacklabel.setBounds(36, 352, 366, 30);
		contentPane.add(attacklabel);

		jobhp = charcter.jobSetHp(jobname);
		JLabel lblNewLabel_6 = new JLabel("HP: " + jobhp);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(36, 413, 337, 30);
		contentPane.add(lblNewLabel_6);

		jobmp = charcter.jobSetMp(jobname);
		JLabel lblNewLabel_7 = new JLabel("MP: " + jobmp);
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lblNewLabel_7.setBounds(36, 464, 295, 39);
		contentPane.add(lblNewLabel_7);

		property = prop.getJobProperty();
		JLabel propertylabel = new JLabel("캐릭터 속성: " + property);
		propertylabel.setForeground(Color.BLACK);
		propertylabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		propertylabel.setBounds(36, 513, 337, 39);
		contentPane.add(propertylabel);

	}

	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "potion") {
				inventory.confirmPotion();
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
