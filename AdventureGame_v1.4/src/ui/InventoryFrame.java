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
import sound.Sound;

@SuppressWarnings("serial")
public class InventoryFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private static int money;
	private Image img1,img2,img3,img4,img5,img6 = null;
	Sound sound = new Sound();
	
	public InventoryFrame(int money2) {
		money = money2;
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		File f = new File("image/inventory.jfif");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		actionListener = new ActionHandler();
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f1 = new File("image/potion.png");
		File f2 = new File("image/weapon.png");
		File f3 = new File("image/armor2.png");
		File f4 = new File("image/magicarmor.png");
		File f5 = new File("image/back2.png");
		File f6 = new File("image/coin2.png");
		
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			img5 = ImageIO.read(f5);
			img6 = ImageIO.read(f6);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		

		JButton potionbtn = new JButton("");
		potionbtn.setIcon(new ImageIcon(img1));
		potionbtn.setBounds(113, 52, 79, 79);
		potionbtn.setActionCommand("potion");
		potionbtn.addActionListener(this.actionListener);
		contentPane.add(potionbtn);

		JButton weaponbtn = new JButton("");
		weaponbtn.setIcon(new ImageIcon(img2));
		weaponbtn.setBounds(614, 52, 79, 79);
		weaponbtn.setActionCommand("weapon");
		weaponbtn.addActionListener(this.actionListener);
		contentPane.add(weaponbtn);

		JButton armorbtn = new JButton("");
		armorbtn.setIcon(new ImageIcon(img3));
		armorbtn.setBounds(113, 467, 69, 73);
		armorbtn.setActionCommand("suit");
		armorbtn.addActionListener(this.actionListener);
		contentPane.add(armorbtn);

		JButton magicarmorbtn = new JButton("");
		magicarmorbtn.setIcon(new ImageIcon(img4));
		magicarmorbtn.setBounds(614, 461, 79, 79);
		magicarmorbtn.setActionCommand("magicsuit");
		magicarmorbtn.addActionListener(this.actionListener);
		contentPane.add(magicarmorbtn);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(img5));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);


		JButton coinBtn = new JButton("");
		coinBtn.setIcon(new ImageIcon(img6));
		coinBtn.setBounds(740, 575, 69, 79);
		coinBtn.setActionCommand("coin");
		coinBtn.addActionListener(this.actionListener);
		contentPane.add(coinBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel.setBounds(332, 0, 188, 59);
		contentPane.add(lblNewLabel);

	}

	private class ActionHandler implements ActionListener {
		Inventory inventory = new Inventory();

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "potion") {
				inventory.confirmPotion();
			} else if (e.getActionCommand() == "weapon") {
				inventory.confirmWeapon();
			} else if (e.getActionCommand() == "suit") {
				inventory.confirmSuit();
			} else if (e.getActionCommand() == "magicsuit") {
				inventory.confirmMagicSuit();
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
