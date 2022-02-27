package adventure;

public class Property {// 불,물,풀 추가해서 각 속성에 맞게 데미지가 달라짐
	// 속성은 스킬과 장비 등에 기본적으로 붙어있음
	private static String skillproperty;
	public static String monsterproperty;
	public static String jobproperty;
	@SuppressWarnings("unused")
	private static String jobname = "";

	private String compareskillproperty;
	private String comparemonsterproperty;
	private String comparejobproperty;

	Charcter charcter = new Charcter();

	// 장비의 속성 , 스킬의 속성을 받아온 후에 몬스터와 속성을 비교한 후
	// 그에 따른 데미지 추가, 감소 이후 데미지 반환
	// 경우의 수는 총 9가지, 불-물, / 물-풀, /

	public String compareSkillProperty() {
		String result = "";

		compareskillproperty = getSkillProperty();
		comparemonsterproperty = getMonsterProperty();
		System.out.println("스킬속성 : " + compareskillproperty + " 몬스터 속성 : " + comparemonsterproperty);

		if (compareskillproperty == comparemonsterproperty) {// 스킬 속성과 몬스터의 속성이 같을 때 속성 데미지 없음 (불-불 물-물 풀-풀)
			result = "없음";
			return result;
		} else if (compareskillproperty.equals("fire") && comparemonsterproperty.equals("leaf")) {// 불-풀
			result = "추가";
			return result;
		} else if (compareskillproperty.equals("fire") && comparemonsterproperty.equals("water")) {// 불-물
			result = "반감";
			return result;
		} else if (compareskillproperty.equals("water") && comparemonsterproperty.equals("fire")) {// 물-불
			result = "추가";
			return result;
		} else if (compareskillproperty.equals("water") && comparemonsterproperty.equals("leaf")) {// 물-풀
			result = "반감";
			return result;
		} else if (compareskillproperty.equals("leaf") && comparemonsterproperty.equals("fire")) {// 풀-불
			result = "반감";
			return result;
		} else if (compareskillproperty.equals("leaf") && comparemonsterproperty.equals("water")) {// 풀-물
			result = "추가";
			return result;
		} else {
			System.out.println("(속성) 잘못된 입력입니다.");
		}
		return result;

	}

	public String comparePlayerAttackProperty() {// 캐릭터 직업 속성 - 몬스터 속성 비교 (캐릭터가 주체)
		jobname = charcter.getJob();
		comparejobproperty = getJobProperty();
		comparemonsterproperty = getMonsterProperty();

		String result2 = "";

		if (comparejobproperty == comparemonsterproperty || comparejobproperty.equals("white")) {// 캐릭터 속성과 몬스터의 속성이 같을
																									// 때
			result2 = "없음";
			return result2;
		} else if (comparejobproperty.equals("fire") && comparemonsterproperty.equals("leaf")) {// 불-풀
			result2 = "추가";
			return result2;
		} else if (comparejobproperty.equals("fire") && comparemonsterproperty.equals("water")) {// 불-물
			result2 = "반감";
			return result2;
		} else if (comparejobproperty.equals("water") && comparemonsterproperty.equals("fire")) {// 물-불
			result2 = "추가";
			return result2;
		} else if (comparejobproperty.equals("water") && comparemonsterproperty.equals("leaf")) {// 물-풀
			result2 = "반감";
			return result2;
		} else if (comparejobproperty.equals("leaf") && comparemonsterproperty.equals("fire")) {// 풀-불
			result2 = "반감";
			return result2;
		} else if (comparejobproperty.equals("leaf") && comparemonsterproperty.equals("water")) {// 풀-물
			result2 = "추가";
			return result2;
		} else {
			System.out.println("(속성) 잘못된 입력입니다.");
		}

		return result2;

	}
	
	public String compareMonsterAttackProperty() {// 캐릭터 직업 속성 - 몬스터 속성 비교 (몬스터가 주체)
		jobname = charcter.getJob();
		comparejobproperty = getJobProperty();
		comparemonsterproperty = getMonsterProperty();

		String result2 = "";

		if (comparejobproperty == comparemonsterproperty || comparejobproperty.equals("white")) {// 캐릭터 속성과 몬스터의 속성이 같을
			result2 = "없음";
			return result2;
		} else if (comparejobproperty.equals("fire") && comparemonsterproperty.equals("leaf")) {// 불-풀
			result2 = "반감";
			return result2;
		} else if (comparejobproperty.equals("fire") && comparemonsterproperty.equals("water")) {// 불-물
			result2 = "추가";
			return result2;
		} else if (comparejobproperty.equals("water") && comparemonsterproperty.equals("fire")) {// 물-불
			result2 = "반감";
			return result2;
		} else if (comparejobproperty.equals("water") && comparemonsterproperty.equals("leaf")) {// 물-풀
			result2 = "추가";
			return result2;
		} else if (comparejobproperty.equals("leaf") && comparemonsterproperty.equals("fire")) {// 풀-불
			result2 = "추가";
			return result2;
		} else if (comparejobproperty.equals("leaf") && comparemonsterproperty.equals("water")) {// 풀-물
			result2 = "반감";
			return result2;
		} else {
			System.out.println("(속성) 잘못된 입력입니다.");
		}

		return result2;

	}
	
	
	public void setSkillProperty(String skillproperty2) {
		skillproperty = skillproperty2;
	}

	public String getSkillProperty() {
		return skillproperty;

	}

	public void monsterSetproperties(String monsterproperty2) {
		monsterproperty = monsterproperty2;
	}

	public String getMonsterProperty() {
		return monsterproperty;
	}

	public void setJobProperty(String jobproperty2) {
		jobproperty = jobproperty2;
	}

	public String getJobProperty() {
		return jobproperty;
	}

}
