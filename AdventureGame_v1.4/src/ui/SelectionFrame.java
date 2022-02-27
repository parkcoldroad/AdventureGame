package ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adventure.Inventory;
import sound.Sound;

@SuppressWarnings("serial")
public class SelectionFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private static String name;
	private static int money;
	private static int round = 1;
	private static int random = 0;
	private static int round1clear = 0;
	private Image img1,img2,img3,img4,img5 = null;
	private static boolean isBattled = false;

	File file = new File("log.txt");
	Inventory inventory = new Inventory();
	Sound sound = new Sound();

	public SelectionFrame(int money2) {
		money=money2;
		inventory.setMoney(money);
		
		EnterFrame enterframe = new EnterFrame(money);
		name = enterframe.getName();
		
		if(isBattled==true) {//배틀을 끝내고 나올때만 bgm다시재생 평소에 상점,스텟,인벤토리때는 bgm계속 유지하기 위해서
			isBattled = false; 
			sound.stopBgm();
			sound.playBgm("sound/bgm/forest.wav", 4.0f, true);
		}
		
		
		if (money < 0) {
			sound.playSound("sound/effectsound/gameover.wav", 1.0f, false);
			JOptionPane.showMessageDialog(null, "돈이 없습니다.. 게임오버", "게임오버", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		if (money >= 100 && round1clear == 0) {
			sound.playSound("sound/effectsound/gamewin.wav", 1.0f, false);
			JOptionPane.showMessageDialog(null, "축하드립니다! 돈을 100이상 모으셨습니다. 다음 지역으로 넘어갑니다.", 
					"다음 라운드", JOptionPane.INFORMATION_MESSAGE);
			round1clear = 1;
			round = round + 1;
		}

		if (money >= 300 && round1clear == 1) {
			sound.playSound("sound/effectsound/victory.wav", 1.0f, false);
			JOptionPane.showMessageDialog(null, "축하드립니다!!! 게임을 클리어하셨습니다.", "게임 클리어!", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		if (round == 1) {
			random = (int) ((Math.random() * 3) + 1);
		} else if (round == 2) {
			random = (int) ((Math.random() * 3) + 2);
			// Math.random()*(최대값-최소값+1)+최소값
		}

		
		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 677);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/adventure.jfif");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		JLabel lblNewLabel = new JLabel(name + "님의 모험이 시작되셨습니다. 선택지를 골라주세요.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(109, 10, 582, 52);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("Store");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(84, 258, 50, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Inventory");
		lblNewLabel_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(615, 285, 95, 25);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Status");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(84, 587, 61, 25);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Skill");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(599, 572, 50, 15);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Battle");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(347, 424, 50, 15);
		contentPane.add(lblNewLabel_10);
		
		File f1 = new File("image/store2.png");
		File f2 = new File("image/inventory.jfif");
		File f3 = new File("image/status2.png");
		File f4 = new File("image/skill2.png");
		File f5 = new File("image/battle.png");
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			img5 = ImageIO.read(f5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		

		JButton storebtn = new JButton("");
		storebtn.setIcon(new ImageIcon(img1));
		storebtn.setBounds(34, 89, 147, 159);
		storebtn.setActionCommand("store");
		storebtn.addActionListener(this.actionListener);
		contentPane.add(storebtn);

		JButton inventorybtn = new JButton("");
		inventorybtn.setIcon(new ImageIcon(img2));
		inventorybtn.setBounds(533, 67, 207, 208);
		inventorybtn.setActionCommand("inventory");
		inventorybtn.addActionListener(this.actionListener);
		contentPane.add(inventorybtn);

		JButton statusbtn = new JButton("");
		statusbtn.setIcon(new ImageIcon(img3));
		statusbtn.setBounds(12, 369, 207, 208);
		statusbtn.setActionCommand("status");
		statusbtn.addActionListener(this.actionListener);
		contentPane.add(statusbtn);

		JButton skillbtn = new JButton("");
		skillbtn.setIcon(new ImageIcon(img4));
		skillbtn.setBounds(518, 419, 232, 117);
		skillbtn.setActionCommand("skill");
		skillbtn.addActionListener(this.actionListener);
		contentPane.add(skillbtn);

		JButton battlebtn = new JButton("");
		battlebtn.setIcon(new ImageIcon(img5));
		battlebtn.setBounds(280, 213, 200, 187);
		battlebtn.setActionCommand("battle");
		battlebtn.addActionListener(this.actionListener);
		contentPane.add(battlebtn);
	}

	@SuppressWarnings("unused")
	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "store") {
				StoreFrame storeframe = new StoreFrame(money);
				storeframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "inventory") {
				sound.playSound("sound/effectsound/openinventory.wav", 1.0f, false);
				InventoryFrame inventoryframe = new InventoryFrame(money);
				inventoryframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "status") {
				StatusFrame statusframe = new StatusFrame(name);
				statusframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "skill") {
				SkillFrame skillframe= new SkillFrame();
				skillframe.setVisible(true);
				dispose();
			} else if (e.getActionCommand() == "battle") {
				BattleFrame battleframe = new BattleFrame(money,random);
				battleframe.setVisible(true);
				isBattled = true;
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sound.stopBgm();
				sound.playBgm("sound/bgm/battle.wav", 0.1f, true);
				dispose();
			}

		}
	}

}
