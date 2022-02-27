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
public class ArcherSkillFrame extends JFrame {
	private ActionListener actionListener;
	private JPanel contentPane;
	private Image img1,img2,img3,img4 = null;

	public ArcherSkillFrame() {

		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File f = new File("image/archer.png");
		try {
			Image img = ImageIO.read(f);
			setIconImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		File f1 = new File("image/bomb.jfif");
		File f2 = new File("image/coldslit.jfif");
		File f3 = new File("image/sharpeyes2.png");
		File f4 = new File("image/back2.png");
		
		try {
			img1 = ImageIO.read(f1);
			img2 = ImageIO.read(f2);
			img3 = ImageIO.read(f3);
			img4 = ImageIO.read(f4);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		

		JButton bombshotBtn = new JButton("");
		bombshotBtn.setIcon(new ImageIcon(img1));
		bombshotBtn.setBounds(46, 126, 79, 69);
		bombshotBtn.setActionCommand("bombshot");
		bombshotBtn.addActionListener(this.actionListener);
		contentPane.add(bombshotBtn);

		JButton coldslitBtn = new JButton("");
		coldslitBtn.setIcon(new ImageIcon(img2));
		coldslitBtn.setBounds(46, 278, 79, 69);
		coldslitBtn.setActionCommand("coldslit");
		coldslitBtn.addActionListener(this.actionListener);
		contentPane.add(coldslitBtn);

		JButton sharpeyesBtn = new JButton("");
		sharpeyesBtn.setIcon(new ImageIcon(img3));
		sharpeyesBtn.setBounds(46, 434, 79, 69);
		sharpeyesBtn.setActionCommand("sharpeyes");
		sharpeyesBtn.addActionListener(this.actionListener);
		contentPane.add(sharpeyesBtn);

		JButton backBtn = new JButton("back");
		backBtn.setIcon(new ImageIcon(img4));
		backBtn.setBounds(0, 605, 63, 59);
		backBtn.setActionCommand("back");
		backBtn.addActionListener(this.actionListener);
		contentPane.add(backBtn);

		JLabel lblNewLabel_1 = new JLabel(
				"<html> Bombshot  <br> 설명: 공격력의 2배의 데미지를 입힌다. (mp 10소비) <br> 속성: fire </html>");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(158, 126, 555, 69);

		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(
				"<html> ColdSlit  <br> 설명: 공격력의 3배의 데미지를 입힌다. (mp 10소비) <br> 속성: water </html> ");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(158, 268, 432, 79);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel(
				"<html> SharpEyes <br> 설명: 공격력의 2배의 데미지를 입히고 자신의 공격력을 10 증가시킨다. <br> (몬스터와 싸우는 턴까지) (mp10소비) <br> 속성: leaf </html>");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(151, 424, 658, 94);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("ArcherSkill");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(292, 10, 220, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel playerlevellabel = new JLabel(
				"궁수 레벨: " + Charcter.archerlevel );
		playerlevellabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		playerlevellabel.setBounds(633, 613, 176, 51);
		contentPane.add(playerlevellabel);

	}

	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "bombshot") {
				JOptionPane.showMessageDialog(null, "<html>붐 샷<br> 불 속성의 폭발하는 화살을 날려 공격한다. 필요 궁수 레벨 : 1 </html>",
						"봄 샷", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "coldslit") {
				JOptionPane.showMessageDialog(null, "<html> 콜드 슬릿 <br> 물 속성의 날카로운 얼음조각을 날려 공격한다. 필요 궁수 레벨 : 2 </html>",
						"콜드 슬릿", JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand() == "sharpeyes") {
				JOptionPane.showMessageDialog(null, "<html> 샤프 아이즈<br> 정신을 집중하여 자신의 공격력을 높이고 풀 속성의 공격을 한다. 필요 궁수 레벨 : 3 </html>",
						"샤프 아이즈", JOptionPane.INFORMATION_MESSAGE);

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
