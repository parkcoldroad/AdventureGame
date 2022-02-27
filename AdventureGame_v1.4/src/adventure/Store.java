package adventure;

import javax.swing.JOptionPane;

import sound.Sound;

//ctrl + h 이후 file search에서 바꾸고싶은 문자열 relplace로 한번에 변경가능
public class Store {
	private String Nredportion = "redportion";
	private String Nblueportion = "blueportion";
	@SuppressWarnings("unused")
	private int redportion = 0;
	@SuppressWarnings("unused")
	private int blueportion = 0;

	private String jobname;
	private String job;
	private String selectionresult = "";

	private String jobselection;
	private int storemoney = 0;
	private static int playerlevel = 0;
	private static int level1up = 0;
	private static int level2up = 0;
	private static int level3up = 0;
	private static int level4up = 0;
	private static int level5up = 0;
	private static int maxlevel = 5;

	private static int getwarrior = 0;
	private static int getwizard = 0;
	private static int getarcher = 0;

	private static int warriorlevel = 0;
	private static int wrlevel1up = 0;
	private static int wrlevel2up = 0;
	private static int wrlevel3up = 0;

	private static int archerlevel = 0;
	private static int arlevel1up = 0;
	private static int arlevel2up = 0;
	private static int arlevel3up = 0;

	private static int wizardlevel = 0;
	private static int wilevel1up = 0;
	private static int wilevel2up = 0;
	private static int wilevel3up = 0;

//	JOptionPane.showMessageDialog(null, "취소하셨습니다.", "취소",JOptionPane.INFORMATION_MESSAGE);

	Charcter charcter = new Charcter();
	Inventory inven = new Inventory();
	Sound sound = new Sound();

	public void buyJoblevel(int storemoney2) {
		
		job = charcter.getJob();
		int joblevel = charcter.getJobLevel(job);

		if (wrlevel3up == 1 || arlevel3up == 1 || wilevel3up == 1) {
			JOptionPane.showMessageDialog(null, "최종레벨에 도달하셨습니다.", "최종레벨 도달", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "직업 레벨업은 1업당 30골드이고 레벨이 올라갈 때마다 30골드의 추가비용이 발생합니다.", "직업레벨 레벨업",
				JOptionPane.INFORMATION_MESSAGE);

		selectionresult = JOptionPane.showInputDialog(
				"(레벨업을 하시겠습니까? 필요한 직업레벨을 입력해주십시오 (1~3레벨까지), 아니면 아무거나 눌러주세요.)" + " 현재 직업: " + job + " 레벨: " + joblevel);

		if (job.equals("warrior")) {
			warriorlevel = charcter.getJobLevel(job);
			if (selectionresult.equals("1")) {
				if (wrlevel1up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "전사레벨1이 되셨습니다. 축하드립니다!", "전사1레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWarriorLevelUp(warriorlevel);
					inven.setMoney(storemoney2);
					wrlevel1up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("2")) {
				if (wrlevel1up == 1 && wrlevel2up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "전사레벨2가 되셨습니다. 축하드립니다!", "전사2레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWarriorLevelUp(warriorlevel);
					inven.setMoney(storemoney2);
					wrlevel2up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("3")) {
				if (wrlevel1up == 1 && wrlevel2up == 1 && wrlevel3up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "전사레벨3이 되셨습니다. 축하드립니다!", "전사3레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWarriorLevelUp(warriorlevel);
					inven.setMoney(storemoney2);
					wrlevel3up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
					inven.setMoney(storemoney2);
				}

			}

			else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다. 상점을 나갑니다.", "잘못된 입력",
						JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		} else if (job.equals("archer")) {
			archerlevel = charcter.getJobLevel(job);
			if (selectionresult.equals("1")) {
				if (arlevel1up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "궁수레벨1이 되셨습니다. 축하드립니다!", "궁수1레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetArcherLevelUp(archerlevel);
					inven.setMoney(storemoney2);
					arlevel1up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("2")) {
				if (arlevel1up == 1 && arlevel2up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "궁수레벨2가 되셨습니다. 축하드립니다!", "궁수2레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetArcherLevelUp(archerlevel);
					inven.setMoney(storemoney2);
					arlevel2up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("3")) {
				if (arlevel1up == 1 && arlevel2up == 1 && arlevel3up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "궁수레벨3이 되셨습니다. 축하드립니다!", "궁수3레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetArcherLevelUp(archerlevel);
					inven.setMoney(storemoney2);
					arlevel3up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다. 상점을 나갑니다.", "잘못된 입력",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (job.equals("wizard")) {
			wizardlevel = charcter.getJobLevel(job);
			if (selectionresult.equals("1")) {
				if (wilevel1up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "마법사레벨1이 되셨습니다. 축하드립니다!", "마법사1레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWizardLevelUp(wizardlevel);
					inven.setMoney(storemoney2);
					wilevel1up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("2")) {
				if (wilevel1up == 1 && wilevel2up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "마법사레벨2가 되셨습니다. 축하드립니다!", "마법사2레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWizardLevelUp(wizardlevel);
					inven.setMoney(storemoney2);
					wilevel2up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("3")) {
				if (wilevel1up == 1 && wilevel2up == 1 && wilevel3up == 0 && storemoney2 > 30) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "마법사레벨3이 되셨습니다. 축하드립니다!", "마법사3레벨 업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetWizardLevelUp(wizardlevel);
					inven.setMoney(storemoney2);
					wilevel3up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "레벨 부족, 이미 달성한 레벨이거나 돈이 부족합니다.", "레벨부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다. 상점을 나갑니다.", "잘못된 입력",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "전직을 하시지 않았습니다.", "미전직", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
		}

	}

	public void changeJob(int storemoney2) {

		playerlevel = charcter.getPlayerlevel();
		if (getwarrior == 1 || getarcher == 1 || getwizard == 1) {
			JOptionPane.showMessageDialog(null, "이미 전직을 하셨습니다.", "전직완료", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
			return;
		}
		if (playerlevel < 2) {
			JOptionPane.showMessageDialog(null, "플레이어 레벨이 부족하여 전직할 수 없습니다. 상점을 나갑니다.", "레벨부족",
					JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
			return;

		} else if (playerlevel >= 2 && storemoney2>30) {
			JOptionPane.showMessageDialog(null, "레벨 2이상이므로 전직 가능합니다. 전직 비용은 30골드 입니다.", "전직",
					JOptionPane.INFORMATION_MESSAGE);
			jobselection = JOptionPane.showInputDialog("\"전사로 전직하고 싶으시면 1, 궁수면 2, 마법사면 3을 눌러주세요.\"");

			if (jobselection.equals("1")) {
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				jobname = "warrior";// 전사
				storemoney2 = storemoney2 - 30;
				charcter.warriorSetLevel(warriorlevel);
				inven.setMoney(storemoney2);
				charcter.setJob(jobname);
				getwarrior = 1;
				JOptionPane.showMessageDialog(null, "전사가 되셨습니다. 축하드립니다!", "전사전직", JOptionPane.INFORMATION_MESSAGE);
			} else if (jobselection.equals("2")) {
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				jobname = "archer";// 궁수
				storemoney2 = storemoney2 - 30;
				charcter.archerSetLevel(archerlevel);
				inven.setMoney(storemoney2);
				charcter.setJob(jobname);
				getarcher = 1;
				JOptionPane.showMessageDialog(null, "궁수가 되셨습니다. 축하드립니다!", "궁수전직", JOptionPane.INFORMATION_MESSAGE);
			} else if (jobselection.equals("3")) {
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				jobname = "wizard";// 마법사
				storemoney2 = storemoney2 - 30;
				charcter.wizardSetLevel(wizardlevel);
				inven.setMoney(storemoney2);
				charcter.setJob(jobname);
				getwizard = 1;

				JOptionPane.showMessageDialog(null, "마법사가 되셨습니다. 축하드립니다!", "마법사전직", JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				JOptionPane.showMessageDialog(null, "잘못된 선택입니다. 상점을 나갑니다.", "잘못된 선택", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		}
		else {
			JOptionPane.showMessageDialog(null, "돈이 부족하여 전직을 할 수 없습니다.", "전직비용 부족",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void buyLevel(int storemoney2) {

		
		playerlevel = charcter.getPlayerlevel();
		selectionresult = JOptionPane
				.showInputDialog("<html> 레벨업을 하시겠습니까? 필요한 레벨을 입력해주십시오 (1~4레벨까지), 아니면 아무거나 눌러주세요. <br>"
						+ "레벨업은 1업당 30골드이고 레벨이 올라갈 때마다 30골드의 추가비용이 발생합니다. <br> " + "현재 플레이어 레벨" + playerlevel
						+ "</html>");

		if (playerlevel == maxlevel) {
			JOptionPane.showMessageDialog(null, "이미 만렙을 달성하셨습니다.", "만렙달성", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (storemoney2 <= 30) {
			JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "골드 부족", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
		} else if (storemoney2 > 30) {

			if (selectionresult.equals("1")) {
				if (storemoney2 >= 30 && level1up == 0) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "레벨 1이 되셨습니다. 축하드립니다!", "플레이어 레벨 1업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetLevelUp(playerlevel);
					inven.setMoney(storemoney2);
					level1up = 1;
					return;
				} else {
					JOptionPane.showMessageDialog(null, "골드 또는 이미 달성한 레벨이거나 레벨이 부족합니다.", "골드 또는 달성한 레벨 부족",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} else if (selectionresult.equals("2")) {
				if (storemoney2 >= 30 && level1up == 1 && level2up == 0) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "레벨 2가 되셨습니다. 축하드립니다!", "플레이어 레벨 2업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetLevelUp(playerlevel);
					inven.setMoney(storemoney2);
					level2up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "골드 또는 이미 달성한 레벨이거나 레벨이 부족합니다.", "골드 또는 달성한 레벨 부족",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (selectionresult.equals("3")) {

				if (storemoney2 >= 30 && level1up == 1 && level2up == 1 && level3up == 0) {
					sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "레벨 3이 되셨습니다. 축하드립니다!", "플레이어 레벨 3업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetLevelUp(playerlevel);
					inven.setMoney(storemoney2);
					level3up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "골드 또는 이미 달성한 레벨이거나 레벨이 부족합니다.", "골드 또는 달성한 레벨 부족",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (selectionresult.equals("4")) {
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				if (storemoney2 >= 30 && level1up == 1 && level2up == 1 && level3up == 1 && level4up == 0) {
					JOptionPane.showMessageDialog(null, "레벨 4가 되셨습니다. 축하드립니다!", "플레이어 레벨 4업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetLevelUp(playerlevel);
					inven.setMoney(storemoney2);
					level4up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "골드 또는 이미 달성한 레벨이거나 레벨이 부족합니다.", "골드 또는 달성한 레벨 부족",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (selectionresult.equals("5")) {
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				if (storemoney2 >= 30 && level1up == 1 && level2up == 1 && level3up == 1 && level4up == 1
						&& level5up == 0) {
					JOptionPane.showMessageDialog(null, "레벨 5가 되셨습니다. 축하드립니다!", "플레이어 레벨 5업",
							JOptionPane.INFORMATION_MESSAGE);
					storemoney2 = storemoney2 - 30;
					charcter.playerSetLevelUp(playerlevel);
					inven.setMoney(storemoney2);
					level5up = 1;
				} else {
					JOptionPane.showMessageDialog(null, "골드 또는 이미 달성한 레벨이거나 레벨이 부족합니다.", "골드 또는 달성한 레벨 부족",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
//			else if (result.equals(null)) {
//				JOptionPane.showMessageDialog(null, "취소하셨습니다.", "취소", JOptionPane.INFORMATION_MESSAGE);
//
//			} 
			else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "상점으로 돌아갑니다.", "상점 복귀", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void buyPortion(int storemoney2) {

		selectionresult = JOptionPane.showInputDialog("<html> 레드포션은 hp를 10올려주고 , 블루포션은 mp를 10올려줍니다. <br>"
				+ "레드 포션을 사시려면 1,블루포션은 2, 취소하시려면 3번을 눌러주세요 </html>");

		if (storemoney2 <= 10) {
			JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "골드부족", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
		} else if (storemoney2 > 10) {

			if (selectionresult.equals("1")) {
				redportion = inven.getRedportion();
				inven.setPortion(Nredportion);
				storemoney = storemoney2 - 10;
				inven.setMoney(storemoney);
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				
				JOptionPane.showMessageDialog(null, "레드 포션 구매를 완료하였습니다. 현재 남은 돈은" + storemoney + "입니다", "레드 포션 구매 완료",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				blueportion = inven.getBlueportion();
				inven.setPortion(Nblueportion);
				storemoney = storemoney2 - 10;
				inven.setMoney(storemoney);
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				
				JOptionPane.showMessageDialog(null, "블루 포션 구매를 완료하였습니다. 현재 남은 돈은" + storemoney + "입니다", "블루 포션 구매 완료",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("3")) {
				JOptionPane.showMessageDialog(null, "포션 구입을 취소하셨습니다.", "포션 구매 취소", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못 입력", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "상점으로 돌아갑니다.", "상점 귀환", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	@SuppressWarnings("unused")
	public void buyWeapon(int storemoney2) {
		int wearingweapon = 0;
		int haveweapon = 0;
		selectionresult = JOptionPane.showInputDialog("무기를 구입하시겠습니까? 구입은 1, 취소는 2번을 눌러주세요.");
		String weapon = "엑스칼리버";
		wearingweapon = inven.getWearingWeapon();
		haveweapon = inven.getHaveWeapon();
		if (wearingweapon == 1) {
			JOptionPane.showMessageDialog(null, "이미 무기를 착용하고 있습니다. 상점을 나갑니다.", "이미 무기 착용",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (haveweapon == 1) {
			JOptionPane.showMessageDialog(null, "이미 무기를 소유하고 있습니다. 상점을 나갑니다.", "이미 무기 소유",
					JOptionPane.INFORMATION_MESSAGE);
			inven.setWeapon(weapon);
			return;
		}
		if (storemoney2 <= 30) {
			JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "골드 부족", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);
		} else if (storemoney2 > 30) {

			if (selectionresult.equals("1")) {
				JOptionPane.showMessageDialog(null, "무기 구입을 완료하였습니다. 인벤토리에서 확인가능 합니다.", "무기 구입 완료",
						JOptionPane.INFORMATION_MESSAGE);
				inven.setWeapon(weapon);
				storemoney = storemoney2 - 30;
				inven.setMoney(storemoney);
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				
				JOptionPane.showMessageDialog(null, "현재 남은 돈은" + storemoney + "입니다", "무기 구입 후 남은 돈",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "무기 구입을 취소하였습니다.", "무기 구입 취소", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못 입력", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "상점으로 돌아갑니다.", "상점 귀환", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney);
		}
	}

	public void buySuit(int storemoney2) {
		int wearingsuit = 0;
		int havesuit = 0;

		String Suit = "워모그의갑옷";
		String result = JOptionPane.showInputDialog("갑옷을 구입하시겠습니까? 구입은 1, 취소는 2번을 눌러주세요.");
		wearingsuit = inven.getWearingSuit();
		havesuit = inven.getHaveSuit();

		if (wearingsuit == 1) {
			JOptionPane.showMessageDialog(null, "이미 갑옷을 착용하고 있습니다.", "이미 갑옷 착용", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (havesuit == 1) {
			JOptionPane.showMessageDialog(null, "이미 갑옷을 소유하고 있습니다.", "이미 갑옷 소유", JOptionPane.INFORMATION_MESSAGE);
			inven.setSuit(Suit);
			return;
		}
		if (storemoney2 <= 20) {
			JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "골드 부족", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);

		} else if (storemoney2 > 20) {

			if (result.equals("1")) {
				JOptionPane.showMessageDialog(null, "갑옷 구입을 완료하였습니다. 인벤토리에서 확인가능 합니다.", "갑옷 구입 완료",
						JOptionPane.INFORMATION_MESSAGE);
				inven.setSuit(Suit);
				storemoney = storemoney2 - 20;
				inven.setMoney(storemoney);
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				
				JOptionPane.showMessageDialog(null, "현재 남은 돈은" + storemoney + "입니다", "갑옷 구입 후 남은 돈",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (result.equals("2") || result.equals(null)) {
				JOptionPane.showMessageDialog(null, "갑옷 구입을 취소하였습니다.", "갑옷 구입 취소", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못 입력", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "상점으로 돌아갑니다.", "상점 귀환", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney);

		}
	}

	public void buymagicSuit(int storemoney2) {
		int wearingmagicsuit = 0;
		int havemagicsuit = 0;

		selectionresult = JOptionPane.showInputDialog("마법갑옷을 구입하시겠습니까? 구입은 1, 취소는 2번을 눌러주세요.");
		String magicSuit = "하이네스의갑옷";
		wearingmagicsuit = inven.getWearingmagicSuit();
		havemagicsuit = inven.getHavemagicSuit();
		if (wearingmagicsuit == 1) {
			JOptionPane.showMessageDialog(null, "이미 마법갑옷을 착용하고 있습니다. ", "이미 마법갑옷 착용", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney);
			return;
		}
		if (havemagicsuit == 1) {
			JOptionPane.showMessageDialog(null, "이미 마법갑옷을 소유하고 있습니다. .", "이미 마법갑옷 소유", JOptionPane.INFORMATION_MESSAGE);
			inven.setMagicsuit(magicSuit);
			inven.setMoney(storemoney);
			return;
		}
		if (storemoney2 <= 25) {
			JOptionPane.showMessageDialog(null, "골드가 부족합니다.", "골드 부족", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney2);

		} else if (storemoney2 > 25) {

			if (selectionresult.equals("1")) {
				JOptionPane.showMessageDialog(null, "마법갑옷 구입을 완료하였습니다. 인벤토리에서 확인가능 합니다.", "마법갑옷 구입 완료",
						JOptionPane.INFORMATION_MESSAGE);
				inven.setMagicsuit(magicSuit);
				storemoney = storemoney2 - 25;
				inven.setMoney(storemoney);
				sound.playSound("sound/effectsound/levelup.wav", 1.0f, false);
				
				JOptionPane.showMessageDialog(null, "현재 남은 돈은" + storemoney + "입니다", "갑옷 구입 후 남은 돈",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "마법갑옷 구입을 취소하였습니다.", "마법갑옷 구입 취소", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못 입력", JOptionPane.INFORMATION_MESSAGE);
				inven.setMoney(storemoney2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "상점으로 돌아갑니다.", "상점 귀환", JOptionPane.INFORMATION_MESSAGE);
			inven.setMoney(storemoney);

		}
	}
}
