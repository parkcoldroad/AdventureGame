package adventure;

public class Charcter {
	private static int difficulty; // 난이도
	private static int jobmp = 0;
	private static int jobhp = 0;

	private static int jobattack;

	private int monsterhp;
	private int monsterattack;
	private int monsterlevel = 1;

	private int wearingweapon = 0;
	private int wearingsuit = 0;
	private int wearingmagicsuit = 0;
	private int reward = 0;

	public static String monsterName;
	public static String jobname = "player";
	public static int playerlevel = 0;
	public static int warriorlevel = 0;
	public static int archerlevel = 0;
	public static int wizardlevel = 0;
	public static int joblevel = 0;

	String playerName;
	String playerWeapon = "";
	String playerSuit = "";
	String playermagicSuit = "";

	private String fireproperty;
	private String waterproperty;
	private String leafproperty;
	private String personproperty;

	private String property = "";

	public int monsterSetLevel() {
		monsterlevel = monsterlevel + 1;
		return monsterlevel;
	}

	public int getMonsterlevel() {
		return monsterlevel;
	}

	public int monsterGetAttack() {
		return monsterattack;
	}

	public int getJobAttack() {
		return jobattack;
	}

	public int monsterSetHp(int idiff) {
		difficulty = idiff;
		if (difficulty == 1) {
			monsterhp = 50;
		} else if (difficulty == 2) {
			monsterhp = 100;
		} else if (difficulty == 3) {
			monsterhp = 150;
		} else if (difficulty == 4) {
			monsterhp = 200;
		}
		return monsterhp;
	}

	public int getJobmp() {
		return jobmp;
	}

	public int getJobhp() {
		return jobhp;
	}

	public int getMonsterhp() {
		return monsterhp;
	}

	public int monsterSetAttack(int idiff) {
		difficulty = idiff;
		if (difficulty == 1) {
			monsterattack = (int) ((Math.random() * 10) + 3);
		} else if (difficulty == 2) {
			monsterattack = (int) ((Math.random() * 20) + 5);
		} else if (difficulty == 3) {
			monsterattack = (int) ((Math.random() * 30) + 10);
		} else if (difficulty == 4) {
			monsterattack = (int) ((Math.random() * 35) + 15);
		}
		return monsterattack;
	}

	public int monsterSetDifficulty(int i) {
		difficulty = i;
		if (difficulty == 1) {// 슬라임
			return difficulty;
		} else if (difficulty == 2) {// 드레이크
			return difficulty;
		} else if (difficulty == 3) {// 발록
			return difficulty;
		} else if (difficulty == 4) {// 반레온
			return difficulty;
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		return 0;
	}

	public int monsterGetDifficulty() {
		return difficulty;
	}

	public String monsterSetname(int i) {

		difficulty = i;
		if (difficulty == 1) {
			monsterName = "킹슬라임";
			return monsterName;
		} else if (difficulty == 2) {
			monsterName = "머쉬맘";
			return monsterName;
		} else if (difficulty == 3) {
			monsterName = "크림슨발록";
			return monsterName;
		} else if (difficulty == 4) {
			monsterName = "반레온";
			return monsterName;
		} else {
			System.out.println("잘못된 접근입니다.");
		}
		return monsterName;
	}

	public String monsterGetname() {
		return monsterName;
	}

	public int getReward(int i) {

		difficulty = i;
		if (difficulty == 1) {
			reward = 5;
			return reward;
		} else if (difficulty == 2) {
			reward = 10;
			return reward;
		} else if (difficulty == 3) {
			reward = 15;
			return reward;
		} else if (difficulty == 4) {
			reward = 20;
			return reward;
		} else {
			System.out.println("잘못된 접근입니다.");
		}
		return 0;
	}

	public String monsterSetProperty(int difficulty2) {// 메인클래스에서 난이도를 받아 몬스터에게 속성을 할당
		Property prop = new Property();
		fireproperty = "fire";
		waterproperty = "water";
		leafproperty = "leaf";

		difficulty = difficulty2;
		if (difficulty == 1) {// 슬라임 물속성
			prop.monsterSetproperties(waterproperty);
			return waterproperty;
		} else if (difficulty == 2) {// 머쉬맘 풀속성
			prop.monsterSetproperties(leafproperty);
			return leafproperty;
		} else if (difficulty == 3) {// 발록 불속성
			prop.monsterSetproperties(fireproperty);
			return fireproperty;
		} else if (difficulty == 4) {// 반레온 불속성
			prop.monsterSetproperties(fireproperty);
			return fireproperty;
		} else {
			System.out.println("잘못된 접근입니다.");
			return property;
		}

	}

	public String monsterGetProperty() {
		return property;
	}

	public void jobSetProperty(String jobname2) {// 메인클래스에서 직업이름을 받아 직업별로 속성할당
		Property prop = new Property();
		jobname = jobname2;

		fireproperty = "fire";
		waterproperty = "water";
		leafproperty = "leaf";
		personproperty = "white";

		if (jobname.equals("warrior")) {
			prop.setJobProperty(fireproperty);
		} else if (jobname.equals("archer")) {
			prop.setJobProperty(leafproperty);
		} else if (jobname.equals("wizard")) {
			prop.setJobProperty(waterproperty);
		} else {
			prop.setJobProperty(personproperty);
		}

	}

	public int jobSetAttack(String jobname2) {
		Inventory inventory = new Inventory();
		jobname = jobname2;

		if (jobname.equals("player"))
			jobattack = 10;
		else if (jobname.equals("warrior")) {
			jobattack = 25;
		} else if (jobname.equals("archer")) {
			jobattack = 20;
		} else if (jobname.equals("wizard")) {
			jobattack = 15;
		} else {
			System.out.println("잘못된 접근입니다(직업 공격력할당)");
		}

		wearingweapon = inventory.getWearingWeapon();

		if (wearingweapon == 1) {
			playerWeapon = inventory.getWeapon();
			if (playerWeapon.equals("엑스칼리버")) {
				jobattack = jobattack + 10;
			}
		}

		return jobattack;
	}

	public int jobSetHp(String jobname2) {
		Inventory inventory = new Inventory();
		jobname = jobname2;

		if (jobname.equals("player")) {
			jobhp = 40;
		} else if (jobname.equals("warrior")) {
			jobhp = 70;
		} else if (jobname.equals("archer")) {
			jobhp = 50;
		} else if (jobname.equals("wizard")) {
			jobhp = 50;
		} else {
			System.out.println("잘못된 접근입니다(직업 hp할당)");
		}

		wearingsuit = inventory.getWearingSuit();
		if (wearingsuit == 1) {
			playerSuit = inventory.getSuit();
			if (playerSuit.equals("워모그의갑옷")) {
				jobhp = jobhp + 50;
			}
		}

		return jobhp;

	}

	public int jobSetMp(String jobname2) {
		Inventory inventory = new Inventory();
		jobname = jobname2;

		if (jobname.equals("player")) {
			jobmp = 20;
		} else if (jobname.equals("warrior")) {
			jobmp = 30;
		} else if (jobname.equals("archer")) {
			jobmp = 40;
		} else if (jobname.equals("wizard")) {
			jobmp = 60;
		} else {
			System.out.println("잘못된 접근입니다(직업 mp할당)");
		}

		wearingmagicsuit = inventory.getWearingmagicSuit();

		if (wearingmagicsuit == 1) {
			playermagicSuit = inventory.getMagicsuit();
			if (playermagicSuit.equals("하이네스의갑옷")) {
				jobmp = jobmp + 50;
			}
		}

		return jobmp;

	}
	
	public void playerSetLevelUp(int playerlevel2) {
		playerlevel = playerlevel2 + 1;
	}

	public int getPlayerlevel() {
		return playerlevel;
	}


	public String getJob() {
		return jobname;
	}

	public void setJob(String jobname2) {
		jobname = jobname2;
	}

	public void warriorSetLevel(int warriorlevel2) {
		warriorlevel = warriorlevel2;

	}

	public void archerSetLevel(int archerlevel2) {
		archerlevel = archerlevel2;

	}

	public void wizardSetLevel(int wizardlevel2) {
		wizardlevel = wizardlevel2;

	}

	public int getJobLevel(String jobname2) {
		String jobname = jobname2;
		if (jobname.equals("warrior"))
			return warriorlevel;
		else if (jobname.equals("archer"))
			return archerlevel;
		else if (jobname.equals("wizard"))
			return wizardlevel;
		return 0;
	}

	public void playerSetWarriorLevelUp(int warriorlevel2) {
		warriorlevel = warriorlevel2 + 1;
	}

	public void playerSetArcherLevelUp(int archerlevel2) {
		archerlevel = archerlevel2 + 1;
	}

	public void playerSetWizardLevelUp(int wizardlevel2) {
		wizardlevel = wizardlevel2 + 1;
	}
	
	

}
