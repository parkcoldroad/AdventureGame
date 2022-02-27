package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import sound.Sound;

@SuppressWarnings("serial")
public class EnterFrame extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Image img, img2 = null;
	private ActionListener actionListener;
	private JTextField idtext;
	public static String name;
	private static int money;

	public EnterFrame(int money2) {
		money = money2;

		actionListener = new ActionHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 390);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
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
		
		

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 426, 333);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Adventure Game에 오신걸 환영합니다!!");
		lblNewLabel_1.setBounds(59, 10, 329, 36);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("지금부터 당신의 모험이 시작됩니다.");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 57, 299, 34);
		panel.add(lblNewLabel);

		idtext = new JTextField();
		idtext.setBounds(152, 229, 129, 21);
		panel.add(idtext);
		idtext.setColumns(10);
		idtext.registerKeyboardAction(this.actionListener, "gamestart", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);

		JLabel lblNewLabel_2 = new JLabel("이름: ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(103, 230, 44, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("당신의 이름을 입력해주세요.");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(99, 204, 222, 15);
		panel.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("시작하기");
		btnNewButton.setFont(new Font("바탕", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setActionCommand("gamestart");
		btnNewButton.addActionListener(this.actionListener);
		btnNewButton.setBounds(169, 260, 101, 23);
		panel.add(btnNewButton);
	}

	@SuppressWarnings("unused")
	private class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "gamestart") {

				String playername = idtext.getText();
				if (playername.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요!", "이름을 입력해주세요.", JOptionPane.INFORMATION_MESSAGE);
				} else {
					setName(playername);
					StatusFrame statusframe = new StatusFrame(playername);
					SelectionFrame selectionframe = new SelectionFrame(money);
					selectionframe.setVisible(true);
					
					Sound sound= new Sound();
					sound.stopBgm();
					sound.playBgm("sound/bgm/forest.wav", 1.0f, true);
					dispose();
				}

			}

		}
	}

	public String getName() {
		return name;
	}

	public void setName(String playername) {
		name = playername;
	}

}
