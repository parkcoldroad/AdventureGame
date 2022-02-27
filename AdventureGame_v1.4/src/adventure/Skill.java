package adventure;

import java.util.Random;

import javax.swing.JOptionPane;

public class Skill {

	private static int playerattack;
	private static int monsterattack;
	private static int damage;
	private static int playerhp;
	private static int monsterhp;
	private static int playerlevels;
	private static int warriorlevels;
	private static int archerlevels;
	private static int wizardlevels;
	private static int difficulty;
	private static String property;
	private static String propertystatus;
	private static String jobname;

	private static int plusrandomdamage;
	private static int minusrandomdamage;

//	private static int mirrorsuccess;
//	private static int hpsuccess;

	Inventory inventory = new Inventory();
	Charcter charcter = new Charcter();
	Random rand = new Random();
	Property prop = new Property();
	Battlelog battlelog = new Battlelog();

	class Personskill {

		public int energyBall(int playerlevel) {// 공격력을 받고 데미지를 반환
			jobname = charcter.getJob();
			playerlevels = playerlevel;
			System.out.println("플레이어 레벨" + playerlevels);
			property = "water";
			setSkillProperty(property);

			if (playerlevels >= 1) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("에너지 볼! (공격력의 2배 데미지)");

				playerattack = playerattack * 2;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int flameClaw(int playerlevel) {
			jobname = charcter.getJob();
			playerlevels = playerlevel;
			System.out.println("플레이어 레벨" + playerlevels);
			property = "fire";
			setSkillProperty(property);
			if (playerlevels >= 2) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("플레임 클로! (공격력의 0~3배 데미지)");
				playerattack = playerattack * (int) ((Math.random() * 4) + 0);
				damage = playerattack;

				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int magicMirror(int playerlevel) {// 내가 먼저 떄림, 몬스터가 다음에 때림 내 턴에 매직가드, 몬스터 턴 때 때려서 50%확률로 성공하면
			// 나 데미지 안입고 몬스터가 자기 공격력만큼 데미지 입음., 스킬 실패할경우 난 공격못하고 데미지만 입음.
			playerlevels = playerlevel;
			battlelog.writeLog("매직미러! (50% 확률로 상대 공격을 방어하고 상대 공격력만큼 반사)");
			difficulty = Getdifficulty();
			
			if (playerlevels >= 3) {
				if (rand.nextInt(10) < 5) {// 성공
					monsterattack = charcter.monsterSetAttack(difficulty);
					damage = monsterattack;
					JOptionPane.showMessageDialog(null, "매직미러로 데미지를 반사합니다. 반사된 데미지는" + monsterattack + "입니다", "매직 미러 성공",
							JOptionPane.INFORMATION_MESSAGE);
					battlelog.writeLog("매직미러로 데미지를 반사합니다. 반사된 데미지는" + monsterattack + "입니다 \n");
					return damage;
				} else {// 실패
					return 0;
				}
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int drainYourHp(int playerlevel) {
			playerlevels = playerlevel;
			property = "leaf";
			setSkillProperty(property);
			difficulty = Getdifficulty();
			
			if (playerlevels >= 4) {
				if (rand.nextInt(10) < 5) {// 성공
					monsterattack = charcter.monsterSetAttack(difficulty);
					playerhp = monsterattack;
					propertystatus = prop.compareSkillProperty();
					battlelog.writeLog("스킬에 성공하셨습니다. 몬스터의 공격력이 플레이어의 체력으로 전환됩니다. \n");
					if (propertystatus.equals("없음")) {
						battlelog.writeLog("서로의 속성이 같으므로 추가 체력 흡혈은 없습니다. 전환된 체력: " + playerhp + "/n");
					} else if (propertystatus.equals("추가")) {
						battlelog.writeLog("속성추가 데미지 흡혈 :" + monsterattack);
						playerhp = monsterattack * 2;
						battlelog.writeLog("속성이 유리하므로 흡혈량이 2배가 됩니다. 전환된 체력: " + playerhp + "/n");
					} else if (propertystatus.equals("반감")) {
						battlelog.writeLog("원래 흡혈량 :" + monsterattack);
						playerhp = monsterattack / 2;
						battlelog.writeLog("속성이 불리하므로 흡혈량이 반감됩니다. 전환된 체력: " + playerhp + "/n");
					} else {
						JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
					}

					return playerhp;
				} else {
					return 0;
				}
			} else {
				System.out.println("레벨이 부족하여 스킬 사용이 불가능합니다.");
				return 0;
			}

		}

		public int swordOfJustice(int playerlevel) {
			playerlevels = playerlevel;
			difficulty = Getdifficulty();
			if (playerlevels >= 5) {

				monsterhp = charcter.monsterSetHp(difficulty);
				damage = monsterhp;
				battlelog.writeLog("정의의 검이 소환됩니다. 몬스터가 섬멸됩니다. 몬스터가 입은 데미지 : " + damage + "/n");
				return damage;

			} else {
				return 0;
			}
		}
	}

	class Warriorskill {

		public int argonDrive(int warriorlevel) {
			jobname = charcter.getJob();
			warriorlevels = warriorlevel;
			property = "fire";
			setSkillProperty(property);

			if (warriorlevels >= 1) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;// 랜덤데미지

				battlelog.writeLog("아르곤 드라이브! (공격력의 3배 데미지)");

				playerattack = playerattack * 3;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int hydroSlash(int warriorlevel) {
			jobname = charcter.getJob();
			warriorlevels = warriorlevel;
			property = "water";
			setSkillProperty(property);

			if (warriorlevels >= 2) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("하이드로 슬래쉬! (공격력의 2~4배 데미지)");

				playerattack = playerattack * (int) ((Math.random() * 3) + 2);
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int leafTornado(int warriorlevel) {
			jobname = charcter.getJob();
			warriorlevels = warriorlevel;
			property = "leaf";
			setSkillProperty(property);

			if (warriorlevels >= 3) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("리프 토네이도! (공격력의 1~3배 데미지를 입히고 입힌데미지만큼 체력회복)");
				
				playerattack = playerattack * (int) ((Math.random() * 3) + 1);
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}
	}

	class Archerskill {
		public int bombShoot(int archerlevel) {
			jobname = charcter.getJob();
			archerlevels = archerlevel;
			property = "fire";
			setSkillProperty(property);

			if (archerlevels >= 1) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("봄 샷! (공격력의 2배 데미지를 입힌다.");
				
				playerattack = playerattack * 2;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int coldSlit(int archerlevel) {
			jobname = charcter.getJob();
			archerlevels = archerlevel;
			property = "water";
			setSkillProperty(property);

			if (archerlevels >= 2) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("콜드 슬릿! (공격력의 3배 데미지를 입힌다.)");

				playerattack = playerattack * 3;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}

		public int sharpEyes(int archerlevel) {
			jobname = charcter.getJob();
			archerlevels = archerlevel;
			property = "leaf";
			setSkillProperty(property);

			if (archerlevels >= 3) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("샤프 아이즈! 공격력의 2배의 데미지를 입히고 자신의 공격력 +10(몬스터와 싸우는 턴까지만)");

				playerattack = playerattack * 2;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();
				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}

		}
	}

	class Wizardskill {
		public int fireDemon(int wizardlevel) {
			jobname = charcter.getJob();
			wizardlevels = wizardlevel;
			property = "fire";
			setSkillProperty(property);

			if (wizardlevels >= 1) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("파이어데몬(공격력의 1~5배 데미지를 입힌다");

				playerattack = playerattack * (int) ((Math.random() * 5) + 1);
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}
		}

		public int wateringHole(int wizardlevel) {
			jobname = charcter.getJob();
			wizardlevels = wizardlevel;
			property = "water";
			setSkillProperty(property);

			if (wizardlevels >= 2) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("워터링홀(공격력의 2~4배 데미지를 입힌다)");

				playerattack = playerattack * (int) ((Math.random() * 3) + 2);
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
				return 0;
			}
		}

		public int moonForest(int wizardlevel) {
			jobname = charcter.getJob();
			wizardlevels = wizardlevel;
			property = "leaf";
			setSkillProperty(property);

			if (wizardlevels >= 3) {
				playerattack = charcter.jobSetAttack(jobname);

				plusrandomdamage = (int) ((Math.random() * 5) + 3);
				minusrandomdamage = (int) ((Math.random() * 10) + 3) * -1;

				playerattack = playerattack + plusrandomdamage + minusrandomdamage;

				battlelog.writeLog("문포레스트! (공격력의 2배만큼 공격후 입힌 데미지만큼 체력회복)");

				playerattack = playerattack * 2;
				damage = playerattack;
				propertystatus = prop.compareSkillProperty();
				compareProperty();

				return damage;
			} else {
				System.out.println("레벨이 부족하여 스킬 사용이 불가능합니다.");
				return 0;
			}
		}

	}

	public void compareProperty() {

		if (propertystatus.equals("없음")) {
			battlelog.writeLog("서로의 속성이 같으므로 변화가 없습니다.");
		} else if (propertystatus.equals("추가")) {
			battlelog.writeLog("데미지 :" + damage);
			damage = damage * 2;
			battlelog.writeLog("속성이 유리하므로 데미지가 2배가 됩니다.");
		} else if (propertystatus.equals("반감")) {
			battlelog.writeLog("원래 데미지 :" + damage);
			damage = damage / 2;
			battlelog.writeLog("속성이 불리하므로 데미지가 반감됩니다.");
		} else {
			JOptionPane.showMessageDialog(null, "잘못된 접근 입니다.");
		}
		battlelog.writeLog(damage + "데미지 \n");
	}

	public void Setdifficulty(int difficulty2) {
		difficulty = difficulty2;

	}

	public int Getdifficulty() {

		return difficulty;
	}

	public void setSkillProperty(String property) {
		prop.setSkillProperty(property);
	}
}
