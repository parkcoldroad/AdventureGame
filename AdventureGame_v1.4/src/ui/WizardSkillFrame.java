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
import sound.Sound;

@SuppressWarnings("serial")
public class WizardSkillFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private Image img1,img2,img3,img4 = null;
	
	public WizardSkillFrame() {

		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/wizard.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		File f1 = new File("image/firedemon.jfif");
		File f2 = new File("image/waterhole2.png");
		File f3 = new File("image/moonforest.jpg");
		File f4 = new File("image/back2.png");
		
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		

		JButton firedemonBtn = new JButton("");
		firedemonBtn.setIcon(new ImageIcon(img1));
		firedemonBtn.setBounds(46, 126, 79, 69);
		firedemonBtn.setActionCommand("firedemon");
		firedemonBtn.addActionListener(this.actionListener);
		contentPane.add(firedemonBtn);

		JButton wateringholeBtn = new JButton("");
		wateringholeBtn.setIcon(new ImageIcon(img2));
		wateringholeBtn.setBounds(46, 278, 79, 69);
		wateringholeBtn.setActionCommand("wateringhole");
		wateringholeBtn.addActionListener(this.actionListener);
		contentPane.add(wateringholeBtn);

		JButton moonforestBtn = new JButton("");
		moonforestBtn.setIcon(new ImageIcon(img3));
		moonforestBtn.setBounds(46, 434, 79, 69);
		moonforestBtn.setActionCommand("moonforest");
		moonforestBtn.addActionListener(this.actionListener);
		contentPane.add(moonforestBtn);

		JButton backBtn = new JButton("back");
		backBtn.setIcon(new ImageIcon(img4));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel_1 = new JLabel(
				"<html> FireDemon  <br> 설명: 공격력의 1~5배의 데미지를 입힌다. (mp 10소비) <br> 속성: fire </html>");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(158, 126, 555, 69);

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(
				"<html> WateringHole  <br> 설명: 공격력의 2~4배의 데미지를 입힌다. (mp 10소비) <br> 속성: water </html> ");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(158, 268, 432, 79);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel(
				"<html> MoonForest <br> 설명: 공격력의 2배만큼 데미지를 입힌 후 입힌 데미지 만큼 체력회복을 한다. (mp10소비) <br> 속성: leaf </html>");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(151, 424, 658, 79);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("WizardSkill");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(292, 10, 220, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel playerlevellabel = new JLabel(
				"마법사 레벨: " + Charcter.wizardlevel );
		playerlevellabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		playerlevellabel.setBounds(633, 613, 176, 51);
		contentPane.add(playerlevellabel);

	}

	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "firedemon") {
				JOptionPane.showMessageDialog(null, "<html>파이어 데몬<br> 악마의 힘이 담긴 운석을 소환하여 공격한다. 필요 마법사 레벨 : 1 </html>",
						"파이어 데몬", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "wateringhole") {
				JOptionPane.showMessageDialog(null, "<html> 워터링 홀 <br> 깊이를 알 수 없는 물바다를 만들어 공격한다. 필요 마법사 레벨 : 2 </html>",
						"워터링 홀", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "moonforest") {
				JOptionPane.showMessageDialog(null, "<html> 문 포레스트<br> 달밤의 숲의 기운을 받아 체력을 회복한다. 필요 마법사 레벨 : 3 </html>",
						"문 포레스트", JOptionPane.INFORMATION_MESSAGE);

			} else if (e.getActionCommand() == "back") {
				Sound sound = new Sound();
				sound.playSound("sound/effectsound/backbutton.wav", 1.0f, false);
				
				SkillFrame skillframe = new SkillFrame();
				skillframe.setVisible(true);
				dispose();
			}

		}
	}
}
