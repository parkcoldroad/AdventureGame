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
public class PlayerSkillFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private Image img1,img2,img3,img4,img5,img6 = null;

	public PlayerSkillFrame() {

		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f1 = new File("image/energyball.jfif");
		File f2 = new File("image/flameclaw.png");
		File f3 = new File("image/magicmirror.png");
		File f4 = new File("image/drainHp.jfif");
		File f5 = new File("image/xcaliber.jfif");
		File f6 = new File("image/back2.png");
		
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
		
		

		JButton energyballBtn = new JButton("");
		energyballBtn.setIcon(new ImageIcon(img1));
		energyballBtn.setBounds(52, 84, 79, 79);
		energyballBtn.setActionCommand("energyball");
		energyballBtn.addActionListener(this.actionListener);
		contentPane.add(energyballBtn);

		JButton flameclawBtn = new JButton("");
		flameclawBtn.setIcon(new ImageIcon(img2));
		flameclawBtn.setBounds(52, 196, 85, 79);
		flameclawBtn.setActionCommand("flameclaw");
		flameclawBtn.addActionListener(this.actionListener);
		contentPane.add(flameclawBtn);

		JButton magicmirrorBtn = new JButton("");
		magicmirrorBtn.setIcon(new ImageIcon(img3));
		magicmirrorBtn.setBounds(52, 298, 79, 79);
		magicmirrorBtn.setActionCommand("magicmirror");
		magicmirrorBtn.addActionListener(this.actionListener);
		contentPane.add(magicmirrorBtn);

		JButton drainhpBtn = new JButton("");
		drainhpBtn.setIcon(new ImageIcon(img4));
		drainhpBtn.setBounds(52, 406, 79, 70);
		drainhpBtn.setActionCommand("drainhp");
		drainhpBtn.addActionListener(this.actionListener);
		contentPane.add(drainhpBtn);

		JButton justiceofswordBtn = new JButton("");
		justiceofswordBtn.setIcon(new ImageIcon(img5));
		justiceofswordBtn.setBounds(52, 507, 79, 79);
		justiceofswordBtn.setActionCommand("justiceofsword");
		justiceofswordBtn.addActionListener(this.actionListener);
		contentPane.add(justiceofswordBtn);

		JButton backBtn = new JButton("back");
		backBtn.setIcon(new ImageIcon(img6));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel_1 = new JLabel(
				"<html> EnergyBall  <br> 설명: 공격력의 2배의 데미지를 입힌다. (mp 10소비) <br> 속성: water </html>");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(158, 94, 555, 69);

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(
				"<html> FlameClaw  <br> 설명: 공격력의 0~3배의 데미지를 입힌다. (mp 10소비) <br> 속성: fire </html> ");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(158, 196, 432, 79);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel(
				"<html> MagicMirror <br> 설명: 50% 확률로 상대 공격을 방어하고 상대 공격력만큼 데미지를 입힌다.(mp5소비) <br> 속성: white </html>");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(158, 298, 621, 79);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel(
				"<html> DrainHp  <br>설명: 50%의 확률로 몬스터의 공격력만큼 Hp를 회복한다(mp 5소비) <br> 속성: leaf </html>");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(158, 406, 555, 70);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_5 = new JLabel(
				"<html> JusticeOfSword  <br> 설명: 100%의 확률로 몬스터가 사망한다.(즉사)(mp 100소비) <br> 속성: fire</html>");
		lblNewLabel_1_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(161, 507, 488, 79);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_2 = new JLabel("PlayerSkill");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(313, 10, 199, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel playerlevellabel = new JLabel(
				"플레이어 레벨: " + Charcter.playerlevel );
		playerlevellabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		playerlevellabel.setBounds(633, 613, 176, 51);
		contentPane.add(playerlevellabel);
	}

	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "energyball") {
				JOptionPane.showMessageDialog(null, "<html> 에너지 볼 <br> 물 속성의 에너지를 날린다. 필요 플레이어 레벨 : 1 </html>", 
						"에너지 볼", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "flameclaw") {
				JOptionPane.showMessageDialog(null, "<html> 플레임 클로 <br> 불 속성의 손톱으로 할퀴기를 한다. 필요 플레이어 레벨 : 2 </html>", 
						"플레임 클로", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "magicmirror") {
				JOptionPane.showMessageDialog(null, "<html> 매직 미러<br> 마법의 거울을 소환해 확률적으로 적의 공격을 반사한다. 필요 플레이어 레벨 : 3 </html>", 
						"매직미러", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getActionCommand() == "drainhp") {
				JOptionPane.showMessageDialog(null, "<html> 드레인 Hp <br> 풀 속성의 힘으로 상대의 공격력만큼 자신의 hp를 회복시킨다. 필요 플레이어 레벨 : 4 </html>", 
						"드레인 Hp", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getActionCommand() == "justiceofsword") {
				JOptionPane.showMessageDialog(null, "<html> 정의의 검 <br> 불 속성의 힘으로 적을 섬멸시킨다. 필요 플레이어 레벨 : 5 </html>", 
						"정의의 검", JOptionPane.INFORMATION_MESSAGE);
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
