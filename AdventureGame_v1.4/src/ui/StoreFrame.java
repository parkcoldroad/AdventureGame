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

import adventure.Inventory;
import adventure.Store;
import sound.Sound;

@SuppressWarnings("serial")
public class StoreFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private static int money;
	private Image img1,img2,img3,img4,img5,img6,img7,img8,img9 = null;
	Sound sound = new Sound();
	
	public StoreFrame(int money2) {
		money = money2;

		actionListener = new ActionHandler();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/store2.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		

		JLabel lblNewLabel = new JLabel("<html> 어서오세요. 여기는 포션과 무기,갑옷을 파는 상점입니다.  <br>"
				+ "또한 레벨업 역시 상점에서 할 수 있습니다.  <br> 포션은 개당 10골드, 무기는 30골드, 갑옷은 20골드, 마법갑옷은 25골드, 레벨업은 레벨업 할 때마다 30골드씩 필요합니다. <br>"
				+ "그리고 레벨2이상찍은 플레이어는 전직할 수 있습니다.  <br> (전사,궁수,마법사) 각각 전사는 불속성, 궁수는 풀속성, 마법사는 물속성을 기본적으로 가지고 있습니다.  <br>"
				+ "직업은 한번 선택하면 바꿀수 없지만 전직을 해도 기본 플레이어 스킬은 사용할 수 있습니다. </html>");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 22, 821, 242);
		contentPane.add(lblNewLabel);

		
		File f1 = new File("image/potion.png");
		File f2 = new File("image/weapon.png");
		File f3 = new File("image/armor2.png");
		File f4 = new File("image/magicarmor.png");
		File f5 = new File("image/levelup.jfif");
		File f6 = new File("image/changejob.jpg");
		File f7 = new File("image/joblevelup.jfif");
		File f8 = new File("image/coin2.png");
		File f9 = new File("image/back2.png");
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		
		JButton potionbtn = new JButton("");
		potionbtn.setIcon(new ImageIcon(img1));
		potionbtn.setBounds(32, 284, 79, 79);
		potionbtn.setActionCommand("potion");
		potionbtn.addActionListener(this.actionListener);
		contentPane.add(potionbtn);

		JButton weaponbtn = new JButton("");
		weaponbtn.setIcon(new ImageIcon(img2));
		weaponbtn.setBounds(207, 284, 79, 79);
		weaponbtn.setActionCommand("weapon");
		weaponbtn.addActionListener(this.actionListener);
		contentPane.add(weaponbtn);

		JButton armorbtn = new JButton("");
		armorbtn.setIcon(new ImageIcon(img3));
		armorbtn.setBounds(406, 284, 69, 79);
		armorbtn.setActionCommand("suit");
		armorbtn.addActionListener(this.actionListener);
		contentPane.add(armorbtn);

		JButton magicarmorbtn = new JButton("");
		magicarmorbtn.setIcon(new ImageIcon(img4));
		magicarmorbtn.setBounds(628, 284, 79, 79);
		magicarmorbtn.setActionCommand("magicsuit");
		magicarmorbtn.addActionListener(this.actionListener);
		contentPane.add(magicarmorbtn);

		JButton levelupbtn = new JButton("");
		levelupbtn.setIcon(new ImageIcon(img5));
		levelupbtn.setBounds(154, 464, 79, 89);
		levelupbtn.setActionCommand("levelup");
		levelupbtn.addActionListener(this.actionListener);
		contentPane.add(levelupbtn);

		JButton changejobbtn = new JButton("");
		changejobbtn.setIcon(new ImageIcon(img6));
		changejobbtn.setBounds(361, 464, 79, 79);
		changejobbtn.setActionCommand("changejob");
		changejobbtn.addActionListener(this.actionListener);
		contentPane.add(changejobbtn);

		JButton joblevelupbtn = new JButton("");
		joblevelupbtn.setIcon(new ImageIcon(img7));
		joblevelupbtn.setBounds(588, 474, 79, 69);
		joblevelupbtn.setActionCommand("joblevelup");
		joblevelupbtn.addActionListener(this.actionListener);
		contentPane.add(joblevelupbtn);

		JButton coinBtn = new JButton("");
		coinBtn.setIcon(new ImageIcon(img8));
		coinBtn.setBounds(720, 10, 69, 79);
		coinBtn.setActionCommand("coin");
		coinBtn.addActionListener(this.actionListener);
		contentPane.add(coinBtn);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(img9));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel_1 = new JLabel("potion");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(42, 373, 69, 15);

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("weapon");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(224, 373, 69, 15);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("suit");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(417, 376, 69, 15);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("magicsuit");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(628, 373, 93, 33);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("levelup");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(164, 563, 69, 33);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("changejob");
		lblNewLabel_1_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(361, 563, 104, 33);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("joblevelup");
		lblNewLabel_1_6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(588, 563, 93, 33);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2 = new JLabel("Store");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(358, 10, 117, 42);
		contentPane.add(lblNewLabel_2);

	}

	private class ActionHandler implements ActionListener {
		Store store = new Store();
		Inventory inventory = new Inventory();

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "potion") {
				money = inventory.getMoney();
				store.buyPortion(money);
			} else if (e.getActionCommand() == "weapon") {
				money = inventory.getMoney();
				store.buyWeapon(money);
			} else if (e.getActionCommand() == "suit") {
				money = inventory.getMoney();
				store.buySuit(money);
			} else if (e.getActionCommand() == "magicsuit") {
				money = inventory.getMoney();
				store.buymagicSuit(money);
			} else if (e.getActionCommand() == "levelup") {
				money = inventory.getMoney();
				store.buyLevel(money);
			} else if (e.getActionCommand() == "changejob") {
				money = inventory.getMoney();
				store.changeJob(money);
			} else if (e.getActionCommand() == "joblevelup") {
				money = inventory.getMoney();
				store.buyJoblevel(money);
			} else if (e.getActionCommand() == "coin") {
				sound.playSound("sound/effectsound/coin.wav", 1.0f, false);
				inventory.confirmMoney();
			} else if (e.getActionCommand() == "back") {
				
				sound.playSound("sound/effectsound/backbutton.wav", 1.0f, false);
				
				money = inventory.getMoney();
				SelectionFrame selectionframe = new SelectionFrame(money);
				selectionframe.setVisible(true);
				dispose();
			}

		}
	}
}
