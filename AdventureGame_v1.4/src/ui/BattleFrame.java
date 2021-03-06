package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import adventure.Charcter;
import adventure.Gamemain;
import adventure.Inventory;
import adventure.Battlelog;
import adventure.Property;
import adventure.Skill;
import sound.Sound;

@SuppressWarnings("serial")
public class BattleFrame extends JFrame {

	Charcter charcter = new Charcter();
	Skill skill = new Skill();
	Inventory inventory = new Inventory();
	Random rand = new Random();

	private ActionListener actionListener;
	private static int money;
	private static String monsterproperty;
	private static String monstername;

	private static int difficulty;
	@SuppressWarnings("unused")
	private static int round = 1;
	private static int random = 0;
	@SuppressWarnings("unused")
	private static int round1clear = 0;
	private Image img1, img2, img3, img4, img5, img6, img7, img8, img9, img10 = null;

	File file = new File("log.txt");
	BufferedImage img = null;
	Gamemain gamemain = new Gamemain();
	JPanel battleskillpanel;
	JPanel itempanel;
	JPanel playerstatuspanel;
	JPanel monsterstatuspanel;
	JPanel logpanel;

	JLabel playerstatuslabel;
	JLabel monsterstauslabel;
	JLabel iteminfo;

	public BattleFrame(int money2, int random2) {
		actionListener = new ActionHandler();
		money = money2;
		random = random2;

		difficulty = charcter.monsterSetDifficulty(random);
		skill.Setdifficulty(difficulty);
		monstername = charcter.monsterSetname(difficulty);
		monsterproperty = charcter.monsterSetProperty(difficulty);
		gamemain.initialize();

		setIconImage(Toolkit.getDefaultToolkit().getImage("image/battlefield.png"));
		setTitle("battle");

		try {
			img = ImageIO.read(new File("image/battlefield.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "????????? ???????????? ??????");

		}

		JLabel lblNewLabel = new JLabel("?????? ??????");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("?????? ??????", Font.PLAIN, 13));
		lblNewLabel.setBounds(52, 201, 61, 15);
		getContentPane().add(lblNewLabel);

		File f = new File("image/battle.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		File f1 = new File("image/propertyrelation.png");
		File f2 = new File("image/fightplayer.png");
		File f3 = new File("image/warrior.png");
		File f4 = new File("image/archer.png");
		File f5 = new File("image/wizard.png");
		File f6 = new File("image/balrok.png");
		File f7 = new File("image/mushmom.jpeg");
		File f8 = new File("image/kingslime.png");
		File f9 = new File("image/leonking.png");
		File f10 = new File("image/back2.png");

		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			img5 = ImageIO.read(f5);
			img6 = ImageIO.read(f6);
			img7 = ImageIO.read(f7);
			img8 = ImageIO.read(f8);
			img9 = ImageIO.read(f9);
			img10 = ImageIO.read(f10);

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		JButton logBtn = new JButton("log");
		logBtn.setBackground(new Color(0, 139, 139));
		logBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		logBtn.setForeground(new Color(255, 99, 71));
		logBtn.setBounds(359, 10, 71, 37);
		logBtn.setActionCommand("log");
		logBtn.addActionListener(this.actionListener);
		getContentPane().add(logBtn);

		JButton propertyrelationshipBtn = new JButton("");
		propertyrelationshipBtn.setIcon(new ImageIcon(img1));
		propertyrelationshipBtn.setBounds(32, 226, 100, 100);
		propertyrelationshipBtn.setActionCommand("propertyrelation");
		propertyrelationshipBtn.addActionListener(this.actionListener);
		getContentPane().add(propertyrelationshipBtn);

		JButton autoplayBtn = new JButton("?????? ??????");
		autoplayBtn.setBackground(new Color(0, 139, 139));
		autoplayBtn.setForeground(new Color(255, 99, 71));
		autoplayBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		autoplayBtn.setBounds(23, 10, 132, 42);
		autoplayBtn.setActionCommand("autoplay");
		autoplayBtn.addActionListener(this.actionListener);
		getContentPane().add(autoplayBtn);

		JButton playerattackBtn = new JButton("?????? ??????");
		playerattackBtn.setBackground(new Color(0, 139, 139));
		playerattackBtn.setForeground(new Color(255, 99, 71));
		playerattackBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		playerattackBtn.setBounds(167, 536, 128, 42);
		playerattackBtn.setActionCommand("playerattack");
		playerattackBtn.addActionListener(this.actionListener);
		getContentPane().add(playerattackBtn);

		JButton skillattackBtn = new JButton("?????? ??????");
		skillattackBtn.setBackground(new Color(0, 139, 139));
		skillattackBtn.setForeground(new Color(255, 99, 71));
		skillattackBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		skillattackBtn.setBounds(489, 536, 128, 42);
		skillattackBtn.setActionCommand("skillattack");
		skillattackBtn.addActionListener(this.actionListener);
		getContentPane().add(skillattackBtn);

		JButton itemBtn = new JButton("?????????");
		itemBtn.setBackground(new Color(0, 139, 139));
		itemBtn.setForeground(new Color(255, 99, 71));
		itemBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		itemBtn.setBounds(167, 618, 128, 42);
		itemBtn.setActionCommand("item");
		itemBtn.addActionListener(this.actionListener);
		getContentPane().add(itemBtn);

		JButton runawayBtn = new JButton("????????????");
		runawayBtn.setBackground(new Color(0, 139, 139));
		runawayBtn.setForeground(new Color(255, 99, 71));
		runawayBtn.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		runawayBtn.setBounds(489, 618, 128, 42);
		runawayBtn.setActionCommand("runaway");
		runawayBtn.addActionListener(this.actionListener);
		getContentPane().add(runawayBtn);

		JButton playerappear = new JButton("");
		String jobname = charcter.getJob();
		if (jobname.equals("player")) {
			playerappear.setIcon(new ImageIcon(img2));
		} else if (jobname.equals("warrior")) {
			playerappear.setIcon(new ImageIcon(img3));
		} else if (jobname.equals("archer")) {
			playerappear.setIcon(new ImageIcon(img4));
		} else if (jobname.equals("wizard")) {
			playerappear.setIcon(new ImageIcon(img5));
		}

		playerappear.setBounds(151, 362, 100, 120);
		getContentPane().add(playerappear);

		monstername = charcter.monsterGetname();
		JButton monsterapprear = new JButton("");
		if (monstername.equals("???????????????")) {
			monsterapprear.setIcon(new ImageIcon(img6));
		} else if (monstername.equals("?????????")) {
			monsterapprear.setIcon(new ImageIcon(img7));
		} else if (monstername.equals("????????????")) {
			monsterapprear.setIcon(new ImageIcon(img8));
		} else if (monstername.equals("?????????")) {
			monsterapprear.setIcon(new ImageIcon(img9));
		}
		monsterapprear.setBounds(497, 130, 150, 150);
		getContentPane().add(monsterapprear);

		// ??????????????? ?????? ??????
		battleskillpanel = new JPanel();
		battleskillpanel.setBounds(167, 57, 318, 249);
		battleskillpanel.setVisible(false);
		getContentPane().add(battleskillpanel);
		battleskillpanel.setLayout(null);

		JLabel askskilllabel = new JLabel("?????? ????????? ?????????????????????????");
		askskilllabel.setBounds(29, 10, 277, 25);
		askskilllabel.setForeground(Color.BLUE);
		askskilllabel.setFont(new Font("?????? ??????", Font.PLAIN, 19));
		battleskillpanel.add(askskilllabel);

		JLabel information = new JLabel("<html> ???????????? ??????: " + Charcter.playerlevel + "<br>??????: " + Charcter.jobname
				+ "<br>  ?????? ??????: " + charcter.getJobLevel((Charcter.jobname)) + "</html>");
		information.setBounds(12, 148, 167, 91);
		information.setForeground(Color.BLACK);
		information.setFont(new Font("?????? ??????", Font.PLAIN, 19));
		battleskillpanel.add(information);

		JButton playerskillBtn = new JButton("<html> ???????????? <br> ?????? </html>");
		playerskillBtn.setFont(new Font("?????? ??????", Font.PLAIN, 14));
		playerskillBtn.setBounds(32, 72, 103, 66);
		playerskillBtn.setActionCommand("playerskill");
		playerskillBtn.addActionListener(this.actionListener);
		battleskillpanel.add(playerskillBtn);

		JButton jobskillBtn = new JButton("?????? ??????");
		jobskillBtn.setFont(new Font("??????", Font.PLAIN, 14));
		jobskillBtn.setBounds(170, 72, 103, 66);
		jobskillBtn.setActionCommand("jobskill");
		jobskillBtn.addActionListener(this.actionListener);
		battleskillpanel.add(jobskillBtn);

		JButton skillbackBtn = new JButton("");
		skillbackBtn.setIcon(new ImageIcon(img10));
		skillbackBtn.setActionCommand("skillback");
		skillbackBtn.addActionListener(this.actionListener);
		skillbackBtn.setBounds(248, 183, 70, 66);
		battleskillpanel.add(skillbackBtn);

		// ??????????????? ???????????????

		itempanel = new JPanel();
		itempanel.setBounds(415, 316, 311, 210);
		itempanel.setVisible(false);
		getContentPane().add(itempanel);
		itempanel.setLayout(null);

		JLabel askitemlabel = new JLabel("?????? ????????? ?????????????????????????");
		askitemlabel.setBounds(20, 5, 271, 26);
		askitemlabel.setForeground(Color.RED);
		askitemlabel.setFont(new Font("?????? ??????", Font.PLAIN, 19));
		itempanel.add(askitemlabel);

		JButton redpotionBtn = new JButton("???????????? ??????");
		redpotionBtn.setFont(new Font("?????? ??????", Font.PLAIN, 13));
		redpotionBtn.setBounds(20, 67, 127, 52);
		redpotionBtn.setActionCommand("useredpotion");
		redpotionBtn.addActionListener(this.actionListener);
		itempanel.add(redpotionBtn);

		JButton bluepotionBtn = new JButton("???????????? ??????");
		bluepotionBtn.setFont(new Font("?????? ??????", Font.PLAIN, 13));
		bluepotionBtn.setBounds(170, 67, 129, 52);
		bluepotionBtn.setActionCommand("usebluepotion");
		bluepotionBtn.addActionListener(this.actionListener);
		itempanel.add(bluepotionBtn);

		JButton itembackBtn = new JButton("");
		itembackBtn.setIcon(new ImageIcon(img10));
		itembackBtn.setActionCommand("itemback");
		itembackBtn.addActionListener(this.actionListener);
		itembackBtn.setBounds(246, 148, 65, 62);
		itempanel.add(itembackBtn);

		iteminfo = new JLabel("<html>?????? HP:" + Gamemain.jobhp + " / ???????????? ??????: " + Inventory.redportion + "<br>?????? MP:"
				+ Gamemain.jobmp + " / ???????????? ??????: " + Inventory.blueportion + "</html>");
		iteminfo.setBounds(0, 148, 245, 52);
		iteminfo.setForeground(Color.BLACK);
		iteminfo.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		itempanel.add(iteminfo);

		// ???????????? ?????? ??????
		playerstatuspanel = new JPanel();
		playerstatuspanel.setBackground(new Color(255, 250, 205));
		playerstatuspanel.setBounds(12, 362, 132, 120);
		playerstatuspanel.setVisible(true);
		getContentPane().add(playerstatuspanel);
		playerstatuspanel.setLayout(null);

		playerstatuslabel = new JLabel("<html>" + EnterFrame.name + " <br>HP:  " + Gamemain.jobhp + " <br>MP:  "
				+ Gamemain.jobmp + "<br> ATK: " + Gamemain.jobattack);
		playerstatuslabel.setBounds(12, 0, 92, 120);
		playerstatuspanel.add(playerstatuslabel);
		playerstatuslabel.setForeground(Color.BLACK);
		playerstatuslabel.setFont(new Font("?????? ??????", Font.BOLD, 20));

		// ????????? ?????? ??????
		monsterstatuspanel = new JPanel();
		monsterstatuspanel.setBackground(new Color(255, 250, 205));
		monsterstatuspanel.setBounds(653, 145, 121, 120);
		monsterstatuspanel.setVisible(true);
		getContentPane().add(monsterstatuspanel);
		monsterstatuspanel.setLayout(null);

		monsterstauslabel = new JLabel("<html>" + monstername + "<br>HP: " + Gamemain.monsterhp + "</html>");
		monsterstauslabel.setBounds(12, 10, 110, 100);
		monsterstatuspanel.add(monsterstauslabel);
		monsterstauslabel.setFont(new Font("?????? ??????", Font.BOLD, 20));

		JOptionPane.showMessageDialog(null,
				"??????" + difficulty + " ????????? " + "(" + monsterproperty + ")" + " ?????? " + monstername + "??? ?????????????????????.",
				"????????? ??????", JOptionPane.WARNING_MESSAGE);

		Contentpane contentpane = new Contentpane();
		contentpane.setLocation(0, 0);
		contentpane.setSize(790, 690);
		contentpane.setLayout(null);

		getContentPane().setLayout(null);

		setBounds(0, 0, 800, 725);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().add(contentpane);

		JOptionPane.showMessageDialog(null,
				"<html>?????????????????? ?????? ????????? ?????? ????????? ??????????????? ?????????????????? ?????? ????????? ???????????????. <br>"
						+ "????????? ??????????????? ???????????? 2?????? ???????????? ????????? ????????? ?????? ??? ????????????. ?????????????????? ?????? ???????????? ????????????. <br> "
						+ "???????????? ???????????? (????????? + ???????????????(+,- ?????????)??? ???????????????. <br>"
						+ "???????????? ?????? ??? ?????? ???????????? ?????? ???????????? ????????? ?????? ??? ?????? ???????????? ?????? ?????? ?????????. <br>"
						+ "?????? 0?????? ?????? ?????????????????? ?????? 300????????? ???????????? ?????? ??????????????????.</html>",
				"?????? ???", JOptionPane.INFORMATION_MESSAGE);

	}

	private void refresh() {
		playerstatuslabel.setText("");
		playerstatuslabel = new JLabel("<html>" + EnterFrame.name + " <br>HP:  " + Gamemain.jobhp + " <br>MP:  "
				+ Gamemain.jobmp + "<br> ATK: " + Gamemain.jobattack);
		playerstatuslabel.setBounds(12, 0, 92, 120);
		playerstatuspanel.add(playerstatuslabel);
		playerstatuslabel.setForeground(Color.BLACK);
		playerstatuslabel.setFont(new Font("?????? ??????", Font.BOLD, 20));
		playerstatuspanel.add(playerstatuslabel);

		monsterstauslabel.setText("");
		monsterstauslabel = new JLabel("<html>" + monstername + "<br>HP: " + Gamemain.monsterhp + "</html>");
		monsterstauslabel.setBounds(12, 10, 110, 100);
		monsterstatuspanel.add(monsterstauslabel);
		monsterstauslabel.setFont(new Font("?????? ??????", Font.BOLD, 20));
		monsterstatuspanel.add(monsterstauslabel);

		iteminfo.setText("");
		iteminfo = new JLabel("<html>?????? HP:" + Gamemain.jobhp + " / ???????????? ??????: " + Inventory.redportion + "<br>?????? MP:"
				+ Gamemain.jobmp + " / ???????????? ??????: " + Inventory.blueportion + "</html>");
		iteminfo.setBounds(12, 148, 222, 52);
		iteminfo.setForeground(Color.BLACK);
		iteminfo.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		itempanel.add(iteminfo);

	}

	@SuppressWarnings("unused")
	private class ActionHandler implements ActionListener {
		Sound sound = new Sound();
		String job = charcter.getJob();

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "autoplay") {
				gamemain.autoplay(money);
				dispose();
				money = inventory.getMoney();
				SelectionFrame selectionframe = new SelectionFrame(money);
				selectionframe.setVisible(true);

				// ??????????????? ?????? ?????? ???
			} else if (e.getActionCommand() == "playerattack") {

				money = inventory.getMoney(); // ???????????? ????????? ???????????? ???????????? ??????
				gamemain.playerAttack(money);

				refresh();

				if (Gamemain.gamevictory == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				} else if (Gamemain.gamelose == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				}

				// ??????????????? ????????? ????????? ???
			} else if (e.getActionCommand() == "skillattack") {
				battleskillpanel.setVisible(true); // JPanel??? ????????? ????????? ??????

			} else if (e.getActionCommand() == "playerskill") {
				gamemain.useplayerSkill(money);
				battleskillpanel.setVisible(false);

				refresh();
				if (Gamemain.gamevictory == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				} else if (Gamemain.gamelose == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				}
			} else if (e.getActionCommand() == "jobskill") {

				gamemain.usejobskill(money);
				battleskillpanel.setVisible(false);
				refresh();
				if (Gamemain.gamevictory == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				} else if (Gamemain.gamelose == 1) {
					dispose();
					money = inventory.getMoney();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				}
			} else if (e.getActionCommand() == "skillback") {
				battleskillpanel.setVisible(false);
			}

			// ????????? ??????
			else if (e.getActionCommand() == "item") {
				refresh();
				itempanel.setVisible(true);
			}

			else if (e.getActionCommand() == "useredpotion") {
				gamemain.useRedPotion();
				itempanel.setVisible(false);
				refresh();
			} else if (e.getActionCommand() == "usebluepotion") {
				gamemain.useBluePotion();
				itempanel.setVisible(false);
				refresh();
			} else if (e.getActionCommand() == "itemback") {
				itempanel.setVisible(false);

			} else if (e.getActionCommand() == "log") {
				BufferedWriter writer;

				final String html = "<html><body style='width: %1spx'>%1s"; // log ????????????
				Battlelog log = new Battlelog();
				List<String> list = log.readLog();
				
				JOptionPane.showMessageDialog(null, String.format(html, 350, list), "?????? ??????",
						JOptionPane.INFORMATION_MESSAGE);
				
				try {
					writer = new BufferedWriter(new FileWriter(file));
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else if (e.getActionCommand() == "runaway") {
				if (rand.nextInt(10) < 5) {
					JOptionPane.showMessageDialog(null, "????????? ????????????!", "?????? ??????", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "??????????????? ?????????????????????. ??????????????? ?????? ???????????????.", "?????? ??????",
							JOptionPane.INFORMATION_MESSAGE);
					gamemain.monsterAttack(money);

					if (Gamemain.gamelose == 1) {
						dispose();
						money = inventory.getMoney();
						SelectionFrame selectionframe = new SelectionFrame(money);
						selectionframe.setVisible(true);
					}
				}

			} else if (e.getActionCommand() == "propertyrelation") {
				JOptionPane.showMessageDialog(
						null, EnterFrame.name + "?????? ????????? " + Property.jobproperty + "?????? " + Charcter.monsterName
								+ "??? ????????? " + Property.monsterproperty + "?????????.",
						"?????? ??????", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	private class Contentpane extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

	}
}
