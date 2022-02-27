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
public class WarriorSkillFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private Image img1,img2,img3,img4 = null;

	public WarriorSkillFrame() {

		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/warrior.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		
		File f1 = new File("image/argonslash.png");
		File f2 = new File("image/waterslash2.jpg");
		File f3 = new File("image/leaftornado2.jfif");
		File f4 = new File("image/back2.png");
		
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		JButton argonslashBtn = new JButton("");
		argonslashBtn.setIcon(new ImageIcon(img1));
		argonslashBtn.setBounds(46, 126, 79, 69);
		argonslashBtn.setActionCommand("argondrive");
		argonslashBtn.addActionListener(this.actionListener);
		contentPane.add(argonslashBtn);

		JButton waterslashBtn = new JButton("");
		waterslashBtn.setIcon(new ImageIcon(img2));
		waterslashBtn.setBounds(46, 278, 79, 69);
		waterslashBtn.setActionCommand("hydroslash");
		waterslashBtn.addActionListener(this.actionListener);
		contentPane.add(waterslashBtn);

		JButton leaftornadoBtn = new JButton("");
		leaftornadoBtn.setIcon(new ImageIcon(img3));
		leaftornadoBtn.setBounds(46, 434, 79, 69);
		leaftornadoBtn.setActionCommand("leaftornado");
		leaftornadoBtn.addActionListener(this.actionListener);
		contentPane.add(leaftornadoBtn);

		JButton backBtn = new JButton("back");
		backBtn.setIcon(new ImageIcon(img4));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel_1 = new JLabel(
				"<html> ArgonDrive  <br> 설명: 공격력의 3배의 데미지를 입힌다. (mp 10소비) <br> 속성: fire </html>");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(158, 126, 555, 69);

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(
				"<html> HydroSlash  <br> 설명: 공격력의 2~4배의 데미지를 입힌다. (mp 10소비) <br> 속성: water </html> ");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(158, 268, 432, 79);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel(
				"<html> LeafTornado <br> 설명: 공격력의 1~3배 데미지를 입히고 입힌 데미지만큼 hp회복. (mp10소비) <br> 속성: leaf </html>");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(161, 424, 621, 79);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("WarriorSkill");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(292, 10, 220, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel playerlevellabel = new JLabel(
				"전사 레벨: " + Charcter.warriorlevel );
		playerlevellabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		playerlevellabel.setBounds(633, 613, 176, 51);
		contentPane.add(playerlevellabel);

	}

	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "argondrive") {
				JOptionPane.showMessageDialog(null, "<html> 아르곤 드라이브 <br> 불 속성의 검격을 날리며 돌진한다. 필요 전사 레벨 : 1 </html>",
						"에너지 볼", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "hydroslash") {
				JOptionPane.showMessageDialog(null, "<html> 하이드로 슬래쉬 <br> 물 속성의 검으로 빠르게 벤다. 필요 전사 레벨 : 2 </html>",
						"플레임 클로", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "leaftornado") {
				JOptionPane.showMessageDialog(null, "<html> 리프 토네이도<br> 풀 속성의 검으로 토네이도를 만들어 공격한다. 필요 전사 레벨 : 3 </html>",
						"매직미러", JOptionPane.INFORMATION_MESSAGE);

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
