package adventure;

import javax.swing.JOptionPane;

import sound.Sound;
import ui.EnterFrame;

public class Gamemain {
	public static int monsterhp;
	private static int monsterattack = 0;
	private static int money;

	private static String monstername;
	private static String jobname;
	private String usepotion;

	public static int jobhp;
	public static int jobmp;
	public static int jobattack;

	private int plusrandomdamage;
	private int minusrandomdamage;

	private int difficulty;
	private int auto = 0;
	private int turncount = 0;
	private int reward = 0;
	private int redpotion = 0;
	private int bluepotion = 0;
	private int skilldamage = 0;
	private int playerlevel = 0;
	private int warriorlevel = 0;
	private int archerlevel = 0;
	private int wizardlevel = 0;
	private int mirrorsuccess = 0;
	private int hpsuccess = 0;

	public static int gamevictory = 0;
	public static int gamelose = 0;
	// ctrl + alt + 방향키 =행 복사, alt + 방향키 =행 옮기기

	Charcter charcter = new Charcter();
	Inventory inventory = new Inventory();
	Skill skill = new Skill();
	Sound sound = new Sound();
	Battlelog battlelog = new Battlelog();
	Property prop = new Property();

	public void victorygame() {
		gamevictory = 1;
	}

	public void losegame() {
		gamelose = 1;
	}

	public void initialize() {

		auto = 0;
		gamevictory = 0;
		gamelose = 0;

		difficulty = charcter.monsterGetDifficulty();
		monstername = charcter.monsterGetname();
		monsterhp = charcter.monsterSetHp(difficulty);

		reward = charcter.getReward(difficulty);

		jobname = charcter.getJob();
		charcter.jobSetProperty(jobname);// 직업별로 속성할당

		jobhp = charcter.jobSetHp(jobname);
		jobmp = charcter.jobSetMp(jobname);
		jobattack = charcter.jobSetAttack(jobname);// hp,mp,공격력 할당

	}

	public void useplayerSkill(int money2) {
		money = money2;
		int damage = 0;
		Skill.Personskill personskill = skill.new Personskill();

		String personskillkey = JOptionPane.showInputDialog("<html> 어떤 스킬을 사용하시겠습니까? <br> "
				+ "q:에너지볼(물) (공격력의 2배 데미지 mp10소비) <br>" + "w:플레임클로(불) (공격력의 0~3배 데미지 mp10소비) <br>"
				+ "e:매직미러(무) (50% 확률로 데미지를 반사 mp5소비) <br>" + "r:드레인Hp(풀) (50 % 확률로 몬스터의 공격력만큼 hp를 회복 mp5소비) <br>"
				+ "p:정의의검(불)(몬스터의 체력만큼 데미지를 줌 mp100소비) </html>");

		playerlevel = charcter.getPlayerlevel();
		// 직업별 레벨 변수 받아오기
		if (personskillkey.equals("q") && playerlevel >= 1) {
			if (jobmp < 10) {
				JOptionPane.showMessageDialog(null,
						"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
						JOptionPane.INFORMATION_MESSAGE);

				playerAttack(money);
			} else if (jobmp >= 10) {
				jobmp = jobmp - 10;
				damage = personskill.energyBall(playerlevel);
				sound.playSound("sound/effectsound/energyball.wav", 5.0f, false);
				playerskillAttack(damage);
			}

		} else if (personskillkey.equals("w") & playerlevel >= 2) {
			if (jobmp < 10) {
				JOptionPane.showMessageDialog(null,
						"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
						JOptionPane.INFORMATION_MESSAGE);
				playerAttack(money);
			} else if (jobmp >= 10) {
				jobmp = jobmp - 10;
				damage = personskill.flameClaw(playerlevel);
				sound.playSound("sound/effectsound/flameclaw.wav", 5.0f, false);
				playerskillAttack(damage);
			}

		} else if (personskillkey.equals("e") & playerlevel >= 3) {
			if (jobmp < 5) {
				JOptionPane.showMessageDialog(null,
						"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
						JOptionPane.INFORMATION_MESSAGE);
				playerAttack(money);
			} else if (jobmp >= 5) {
				jobmp = jobmp - 5;
				damage = personskill.magicMirror(playerlevel);
				sound.playSound("sound/effectsound/magicmirror.wav", 5.0f, false);
				if (damage == 0) {
					mirrorsuccess = 0;
					JOptionPane.showMessageDialog(null,
							"<html>매직 미러가 실패하였습니다. 턴을 종료합니다. <br>" + "남은 mp" + jobmp + "</html>", "매직 미러 실패",
							JOptionPane.INFORMATION_MESSAGE);
					monsterAttack(money);

				} else {
					mirrorsuccess = 1;
					playerskillAttack(damage);
				}
			}

		} else if (personskillkey.equals("r") & playerlevel >= 4) {
			if (jobmp < 5) {
				JOptionPane.showMessageDialog(null,
						"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
						JOptionPane.INFORMATION_MESSAGE);
				playerAttack(money);
			} else if (jobmp >= 5) {
				jobmp = jobmp - 5;
				damage = personskill.drainYourHp(playerlevel);
				sound.playSound("sound/effectsound/drainHp.wav", 5.0f, false);
				if (damage == 0) {
					hpsuccess = 0;
					JOptionPane.showMessageDialog(null,
							"<html>드레인Hp가 실패하였습니다. 턴을 종료합니다. <br>" + "남은 mp" + jobmp + "</html>", "드레인 hp 실패",
							JOptionPane.INFORMATION_MESSAGE);
					monsterAttack(money);
				} else {
					hpsuccess = 1;
					jobhp = jobhp + damage;

					JOptionPane.showMessageDialog(null,
							"<html>드레인Hp가 성공하여 몬스터의 공격력이 체력으로 전환되고 턴을 종료합니다. <br>" + "남은 mp" + jobmp
									+ "<br>데미지를 받아 전환된 체력: " + damage + "현재체력 : " + jobhp + "</html>",
							"드레인 hp 성공", JOptionPane.INFORMATION_MESSAGE);
					monsterAttack(money);
				}

			}

		} else if (personskillkey.equals("p") & playerlevel >= 5) {
			if (jobmp < 100) {
				JOptionPane.showMessageDialog(null,
						"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
						JOptionPane.INFORMATION_MESSAGE);
				playerAttack(money);
			} else if (jobmp >= 100) {
				jobmp = jobmp - 100;
				damage = personskill.swordOfJustice(playerlevel);
				sound.playSound("sound/effectsound/xcaliber.wav", 5.0f, false);
				playerskillAttack(damage);
			}
		} else {
			JOptionPane.showMessageDialog(null, "레벨이 부족하거나 잘못된 키를 입력하셨습니다.", "잘못된 키 입력",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void usejobskill(int money2) {
		money = money2;
		jobname = charcter.getJob();
		if (jobname.equals("player")) {
			JOptionPane.showMessageDialog(null, "전직을 하지 않으셨습니다. ", "미전직", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		Skill.Warriorskill warriorskill = skill.new Warriorskill();
		Skill.Archerskill archerskill = skill.new Archerskill();
		Skill.Wizardskill wizardskill = skill.new Wizardskill();

		int damage = 0;

		if (jobname.equals("warrior")) {
			warriorlevel = charcter.getJobLevel(jobname);

			String warriorkey = JOptionPane.showInputDialog("<html> 어떤 스킬을 사용하시겠습니까? <br> "
					+ "a:아르곤 드라이브(불) (공격력의 3배 데미지 mp10소비) <br>" + "s:하이드로 슬래쉬(물) (공격력의 2~4배 데미지 mp10소비) <br>"
					+ "d:리프 토네이도(풀) (공격력의 1~3배 데미지를 입히고 입힌데미지만큼 체력회복 mp10소비) </html>");

			if (warriorkey.equals("a") && warriorlevel >= 1) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = warriorskill.argonDrive(warriorlevel);
					sound.playSound("sound/effectsound/argonslash.wav", 5.0f, false);
					playerskillAttack(damage);
				}

			} else if (warriorkey.equals("s") && warriorlevel >= 2) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = warriorskill.hydroSlash(warriorlevel);
					sound.playSound("sound/effectsound/hydroslash.wav", 5.0f, false);
					playerskillAttack(damage);
				}

			} else if (warriorkey.equals("d") && warriorlevel >= 3) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = warriorskill.leafTornado(warriorlevel);
					sound.playSound("sound/effectsound/leaftornado.wav", 5.0f, false);
					jobhp = jobhp + damage;
					playerskillAttack(damage);
					JOptionPane.showMessageDialog(null, "입힌 데미지" + damage + "만큼 체력이 회복되었습니다.", "리프 토네이도 사용",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "레벨이 부족하거나 잘못된 키를 입력하셨습니다.", "잘못된 키 입력",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (jobname.equals("archer")) {
			archerlevel = charcter.getJobLevel(jobname);
			String archerkey = JOptionPane.showInputDialog("<html> 어떤 스킬을 사용하시겠습니까? <br> "
					+ "a:봄 샷(불) (공격력의 2배 데미지 mp10소비) <br>" + "s:콜드 슬릿(물) (공격력의 3배 데미지 mp10소비) <br>"
					+ "d:샤프 아이즈(풀) (공격력의 2배의 데미지를 입히고 자신의 공격력 +10(몬스터와 싸우는 턴까지만) mp10소비) </html>");

			if (archerkey.equals("a") && archerlevel >= 1) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = archerskill.bombShoot(archerlevel);
					sound.playSound("sound/effectsound/bombshoot.wav", 6.0f, false);
					playerskillAttack(damage);
				}

			} else if (archerkey.equals("s") && archerlevel >= 2) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = archerskill.coldSlit(archerlevel);
					sound.playSound("sound/effectsound/coldslit.wav", 5.0f, false);
					playerskillAttack(damage);
				}

			} else if (archerkey.equals("d") && archerlevel >= 3) {
				if (jobmp < 10) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 10) {
					jobmp = jobmp - 10;
					damage = archerskill.sharpEyes(archerlevel);// 공증가 버프
					sound.playSound("sound/effectsound/sharpeyes.wav", 5.0f, false);
					playerskillAttack(damage);
					jobattack = jobattack + 10;
					JOptionPane.showMessageDialog(null, "몬스터와의 싸움동안 공격력이 10 증가합니다.", "샤프 아이즈 사용",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "레벨이 부족하거나 잘못된 키를 입력하셨습니다.", "잘못된 키 입력",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (jobname.equals("wizard")) {
			wizardlevel = charcter.getJobLevel(jobname);

			String wizardkey = (JOptionPane.showInputDialog("<html> 어떤 스킬을 사용하시겠습니까? <br> "
					+ "a:파이어 데몬(불) (공격력의 1~5배 데미지 mp15소비) <br>" + "s:워터링 홀(물) (공격력의 2~4배 데미지 mp15소비) <br>"
					+ "d:문 포레스트(풀) (공격력의 2배만큼 공격후 입힌 데미지만큼 체력회복 mp15소비) </html>"));

			if (wizardkey.equals("a") && wizardlevel >= 1) {
				if (jobmp < 15) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 15) {
					jobmp = jobmp - 15;
					damage = wizardskill.fireDemon(wizardlevel);
					sound.playSound("sound/effectsound/firedemon.wav", 6.0f, false);
					playerskillAttack(damage);
				}

			} else if (wizardkey.equals("s") && wizardlevel >= 2) {
				if (jobmp < 15) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 15) {
					jobmp = jobmp - 15;
					damage = wizardskill.wateringHole(wizardlevel);
					sound.playSound("sound/effectsound/wateringhole.wav", 6.0f, false);
					playerskillAttack(damage);
				}

			} else if (wizardkey.equals("d") && wizardlevel >= 3) {
				if (jobmp < 15) {
					JOptionPane.showMessageDialog(null,
							"<html>마나가 부족하여 스킬을 사용할 수 없습니다. <br>" + "자동으로 일반 공격으로 전환됩니다.</html>", "마나 부족",
							JOptionPane.INFORMATION_MESSAGE);
					playerAttack(money);
				} else if (jobmp >= 15) {
					jobmp = jobmp - 15;
					damage = wizardskill.moonForest(wizardlevel);// 체력 증가 버프
					sound.playSound("sound/effectsound/moonforest.wav", 5.0f, false);
					jobhp = jobhp + damage;
					playerskillAttack(damage);
				}

			} else {
				JOptionPane.showMessageDialog(null, "레벨이 부족하거나 잘못된 키를 입력하셨습니다.", "잘못된 키 입력",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "잘못된 접근입니다.", "잘못된 접근(jobskill)", JOptionPane.INFORMATION_MESSAGE);
		}

		if (monsterhp <= 0) {
			victorygame();
			return;
		}

		if (jobhp <= 0) {
			losegame();
			return;
		}
	}

	public void useRedPotion() {
		redpotion = inventory.getRedportion();
		usepotion = JOptionPane.showInputDialog("레드 포션을 사용하시겠습니까? 하시려면 1,아니면 2번을 눌러주세요.");

		if (usepotion.equals("1")) {// 레드포션 사용
			if (redpotion <= 0) {
				JOptionPane.showMessageDialog(null, "레드포션이 없습니다.", "레드포션 부족", JOptionPane.INFORMATION_MESSAGE);
			} else if (redpotion > 0) {
				sound.playSound("sound/effectsound/getpotion.wav", 5.0f, false);
				jobhp = jobhp + 10;
				inventory.useRedPortion();
				JOptionPane.showMessageDialog(null, jobname + "의 hp 10이 회복되었습니다.", "레드포션 사용",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (usepotion.equals("2")) {
			JOptionPane.showMessageDialog(null, "레드포션 사용을 취소합니다.", "레드포션 사용취소", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void useBluePotion() {
		bluepotion = inventory.getBlueportion();
		usepotion = JOptionPane.showInputDialog("블루 포션을 사용하시겠습니까? 하시려면 1,아니면 2번을 눌러주세요.");

		if (usepotion.equals("1")) {// 블루포션 사용
			if (bluepotion <= 0) {
				JOptionPane.showMessageDialog(null, "블루포션이 없습니다.", "블루포션 부족", JOptionPane.INFORMATION_MESSAGE);
			}

			else if (bluepotion > 0) {
				sound.playSound("sound/effectsound/getpotion.wav", 5.0f, false);
				jobmp = jobmp + 10;
				inventory.useBluePortion();
				JOptionPane.showMessageDialog(null, jobname + "의 mp 10이 회복되었습니다.", "블루포션 사용",
						JOptionPane.INFORMATION_MESSAGE);

			}

		} else if (usepotion.equals("2")) {
			JOptionPane.showMessageDialog(null, "블루포션 사용을 취소합니다.", "블루포션 사용취소", JOptionPane.INFORMATION_MESSAGE);
		}

		else {
			JOptionPane.showMessageDialog(null, "잘못된 키를 누르셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void autoplay(int money2) {
		// 자동전투
		money = money2;
		auto = 1;
		jobname = charcter.getJob();
		inventory.setMoney(money);
		while (true) {
			jobattack = charcter.jobSetAttack(jobname);
			monsterattack = charcter.monsterSetAttack(difficulty);

			playerAttack(money);
			if (monsterhp <= 0) {
				inventory.setMoney(money);
				break;
			}

			monsterAttack(money);

			if (jobhp <= 0) {
				inventory.setMoney(money);
				break;
			}
		}

	}

	public void playerskillAttack(int damage) {// 플레이어가 스킬로 공격
		skilldamage = damage;
		Inventory inventory = new Inventory();

		monsterhp = monsterhp - skilldamage;
		turncount = turncount + 1;

		JOptionPane
				.showMessageDialog(null,
						"<html>" + EnterFrame.name + "가 " + monstername + "에게 준 데미지는" + skilldamage + "<br>"
								+ monstername + "의 남은 hp" + monsterhp + "</html>",
						"몬스터에게 준 데미지", JOptionPane.INFORMATION_MESSAGE);

		if (monsterhp <= 0) {
			sound.playSound("sound/effectsound/gamewin.wav", 1.0f, false);
			money = money + Math.abs(monsterhp) + reward;
			JOptionPane.showMessageDialog(null,
					"<html> 승리! 정비에 들어갑니다. <br>" + "돈" + Math.abs(monsterhp) + "를 얻었따!<br>" + monstername + "을 잡은 추가 돈을"
							+ reward + "더 얻었다.<br>" + "당신의 현재 돈은 " + money + "입니다</html>",
					"전투 승리", JOptionPane.INFORMATION_MESSAGE);
			inventory.setMoney(money);
			victorygame();
			return;
		}

		monsterAttack(money);

		/*
		 * 어차피 monsterattack후에 판별하니까 여기선 쓸모없음. if (money < 0) {
		 * JOptionPane.showMessageDialog(null, "돈이 없습니다.. 게임오버..", "게임오버",
		 * JOptionPane.INFORMATION_MESSAGE); System.exit(0); } if (jobhp <= 0) {
		 * System.out.println("\n패배.."); money = money - Math.abs(jobhp); turncount = 0;
		 * JOptionPane.showMessageDialog(null, "<html> 패배! 정비에 들어갑니다. <br>" + "돈" +
		 * Math.abs(jobhp) + "를 잃었다!<br>" + "당신의 현재 돈은 " + money + "입니다</html>",
		 * "전투 패배", JOptionPane.INFORMATION_MESSAGE); inventory.setMoney(money);
		 * losegame(); return;
		 * 
		 * }
		 */

	}

	public void playerAttack(int money2) {// 그냥 떄림
		Inventory inventory = new Inventory();
		jobname = charcter.getJob();
		String result = prop.comparePlayerAttackProperty();
		money = money2;

		sound.playSound("sound/effectsound/playerattack.wav", 1.0f, false);

		int damage = jobattack;

		plusrandomdamage = (int) ((Math.random() * 5) + 3);
		minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;
		turncount = turncount + 1;

		damage = damage + plusrandomdamage + minusrandomdamage;

		if (result.equals("없음")) {
			battlelog.writeLog("플레이어: 속성이 같거나 무속성이므로 속성 데미지는 없습니다. 입힌 데미지 : " + jobattack + "\n");
		} else if (result.equals("추가")) {
			damage = damage * 2;
			battlelog.writeLog("플레이어: 속성이 유리하므로 데미지가 2배가 됩니다. 입힌 데미지: " + jobattack + "\n");
		} else if (result.equals("반감")) {
			damage = damage / 2;
			battlelog.writeLog("플레이어: 속성이 불리하므로 데미지가 반감됩니다. 입힌 데미지: " + jobattack + "\n");
		} else {
			System.out.println("(스킬) 잘못된 접근입니다.");
		}

		monsterhp = monsterhp - damage;

		JOptionPane
				.showMessageDialog(
						null, "<html>" + EnterFrame.name + "가 " + monstername + "에게 준 데미지는" + damage + "<br>"
								+ monstername + "의 남은 hp" + monsterhp + "</html>",
						"몬스터에게 준 데미지", JOptionPane.INFORMATION_MESSAGE);

		if (monsterhp <= 0) {
			sound.playSound("sound/effectsound/gamewin.wav", 1.0f, false);
			money = money + Math.abs(monsterhp) + reward;
			turncount = 0;
			JOptionPane.showMessageDialog(null,
					"<html> 승리! 정비에 들어갑니다. <br>" + "돈" + Math.abs(monsterhp) + "를 얻었따!<br>" + monstername + "을 잡은 추가 돈을"
							+ reward + "더 얻었다.<br>" + "당신의 현재 돈은 " + money + "입니다</html>",
					"전투 승리", JOptionPane.INFORMATION_MESSAGE);
			inventory.setMoney(money);
			victorygame();
			return;
		}

		if (auto == 0) {
			monsterAttack(money);
		}

		if (money < 0) {
			sound.playSound("sound/effectsound/gameover.wav", 1.0f, false);
			JOptionPane.showMessageDialog(null, "돈이 없습니다.. 게임오버..", "게임오버", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}

	public void monsterAttack(int money2) {// 몬스터가 때림
		// 직업별 체력 추가
		String result = prop.compareMonsterAttackProperty();
		monsterattack = charcter.monsterSetAttack(difficulty);
		money = money2;

		sound.playSound("sound/effectsound/monsterattack.wav", 1.0f, false);

		Inventory inventory = new Inventory();
		jobname = charcter.getJob();
		if (mirrorsuccess == 1) {
			JOptionPane.showMessageDialog(null, "매직미러 발동으로 인해서 플레이어에게 데미지를 입히지 못합니다.", "매직 미러 발동",
					JOptionPane.INFORMATION_MESSAGE);
			mirrorsuccess = 0;
			return;
		} else if (hpsuccess == 1) {
			JOptionPane.showMessageDialog(null, "드레인Hp 발동으로 몬스터의 공격력이 플레이어의 hp가 됩니다.", "드레인Hp 발동",
					JOptionPane.INFORMATION_MESSAGE);
			hpsuccess = 0;
			return;
		}
		
		if (result.equals("없음")) {
			battlelog.writeLog("몬스터: 속성이 같거나 무속성이므로 속성 데미지는 없습니다. 입힌 데미지 : " + monsterattack + "\n");
		} else if (result.equals("추가")) {
			monsterattack = monsterattack * 2;
			battlelog.writeLog("몬스터: 속성이 유리하므로 데미지가 2배가 됩니다. 입힌 데미지: " + monsterattack + "\n");
		} else if (result.equals("반감")) {
			monsterattack = monsterattack / 2;
			battlelog.writeLog("몬스터: 속성이 불리하므로 데미지가 반감됩니다. 입힌 데미지: " + monsterattack + "\n");
		} else {
			System.out.println("(스킬) 잘못된 접근입니다.");
		}
		

		jobhp = jobhp - monsterattack;

		JOptionPane.showMessageDialog(null,
				"<html>당신이 받은 데미지는" + monsterattack + "입니다<br>" + "남은 hp" + jobhp + "입니다</html>", "몬스터에게 받은 데미지",
				JOptionPane.INFORMATION_MESSAGE);

		if (jobhp <= 0) {
			sound.playSound("sound/effectsound/gameover.wav", 1.0f, false);
			money = money - Math.abs(jobhp);
			turncount = 0;
			JOptionPane.showMessageDialog(null, "<html> 패배! 정비에 들어갑니다. <br>" + "돈" + Math.abs(jobhp) + "를 잃었다!<br>"
					+ "당신의 현재 돈은 " + money + "입니다</html>", "전투 패배", JOptionPane.INFORMATION_MESSAGE);
			inventory.setMoney(money);
			losegame();

		}

		if (money < 0) {
			sound.playSound("sound/effectsound/gameover.wav", 1.0f, false);
			JOptionPane.showMessageDialog(null, "돈이 없습니다.. 게임오버..", "게임오버", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

}
