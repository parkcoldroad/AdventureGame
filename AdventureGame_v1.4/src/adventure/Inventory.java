package adventure;

import javax.swing.JOptionPane;

import sound.Sound;

public class Inventory {
	int scinven;
	int scinvenselect1;
	int scinvenselect2; // 스캐너변수모음

	private String selectionresult = "";

	public static int redportion = 0;
	public static int blueportion = 0;
	private static int money;
	private static String weapon = "";
	private static String suit = "";
	private static String magicsuit = "";
	private static int wearingSuit = 0;
	private static int wearingWeapon = 0;
	private static int wearingmagicSuit = 0;

	private static int havemagicSuit = 0;
	private static int haveWeapon = 0;
	private static int haveSuit = 0;

	
	Sound sound = new Sound();
	Charcter charcter = new Charcter();

	public void confirmMoney() {
		int confirmmoney=getMoney();
		JOptionPane.showMessageDialog(null, "현재 당신이 가지고 있는 돈은" + confirmmoney + "입니다.", "골드 확인",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void confirmPotion() {
		int redportionNumber = getRedportion();
		int blueportionNumber = getBlueportion();
		JOptionPane.showMessageDialog(null, "<html> 빨간 포션의 개수는" + redportionNumber + "개 입니다. <br>"
				+ "파란 포션의 개수는" + blueportionNumber + "개 입니다. </html>", "포션 개수 확인",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void confirmWeapon() {
		if (wearingWeapon == 1) {
			JOptionPane.showMessageDialog(null, "현재 무기를 장착하고 있습니다.", "무기 장착완료", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("무기를 해제하시겠습니까? 해제하시려면 1번, 아니면 2번을 눌러주세요.");
			if (selectionresult.equals("1")) {
				cancelWeapon();
				sound.playSound("sound/effectsound/weaponsoff.wav", 1.0f, false);
				JOptionPane.showMessageDialog(null, "무기 해제가 완료되었습니다.", "무기 해제 완료", JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "무기 해제가 취소되었습니다.", "무기 해제 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

		else if (wearingWeapon == 0) {
			JOptionPane.showMessageDialog(null, "현재 무기가 장착되어 있지 않습니다.", "무기 미장착", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("무기를 장착하시겠습니까? 장착하시려면 1번, 아니면 2번을 눌러주세요.");

			if (selectionresult.equals("1")) {
				if (haveWeapon == 1) {
					wearWeapon();
					sound.playSound("sound/effectsound/equipsword.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "무기 장착이 완료되었습니다.", "무기 장착 완료", JOptionPane.INFORMATION_MESSAGE);
				} else if (haveWeapon == 0) {
					JOptionPane.showMessageDialog(null, "무기를 소유하고 있지 않습니다.", "무기 미소유", JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "무기 장착이 취소되었습니다.", "무기 장착 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}
	
	public void confirmSuit() {
		if (wearingSuit == 1) {
			JOptionPane.showMessageDialog(null, "현재 갑옷을 장착하고 있습니다.", "갑옷 장착완료", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("갑옷을 해제하시겠습니까? 해제하시려면 1번, 아니면 2번을 눌러주세요.");
			if (selectionresult.equals("1")) {
				cancelSuit();
				sound.playSound("sound/effectsound/weaponsoff.wav", 1.0f, false);
				JOptionPane.showMessageDialog(null, "갑옷 해제가 완료되었습니다.", "갑옷 해제 완료", JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "갑옷 해제가 취소되었습니다.", "갑옷 해제 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

		else if (wearingSuit == 0) {
			JOptionPane.showMessageDialog(null, "현재 갑옷이 장착되어 있지 않습니다.", "갑옷 미장착", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("갑옷을 장착하시겠습니까? 장착하시려면 1번, 아니면 2번을 눌러주세요.");

			if (selectionresult.equals("1")) {
				if (haveSuit == 1) {
					wearSuit();
					sound.playSound("sound/effectsound/equiparmor.wav", 2.0f, false);
					JOptionPane.showMessageDialog(null, "갑옷 장착이 완료되었습니다.", "갑옷 장착 완료", JOptionPane.INFORMATION_MESSAGE);
				} else if (haveSuit == 0) {
					JOptionPane.showMessageDialog(null, "갑옷을 소유하고 있지 않습니다.", "갑옷 미소유", JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "갑옷 장착이 취소되었습니다.", "갑옷 장착 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}
	
	public void confirmMagicSuit() {

		
		if (wearingmagicSuit == 1) {
			JOptionPane.showMessageDialog(null, "현재 마법갑옷을 장착하고 있습니다.", "마법갑옷 장착완료", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("마법갑옷을 해제하시겠습니까? 해제하시려면 1번, 아니면 2번을 눌러주세요.");
			if (selectionresult.equals("1")) {
				cancelmagicSuit();
				sound.playSound("sound/effectsound/weaponsoff.wav", 1.0f, false);
				JOptionPane.showMessageDialog(null, "마법갑옷 해제가 완료되었습니다.", "마법갑옷 해제 완료", JOptionPane.INFORMATION_MESSAGE);
			} else if (selectionresult.equals("2")) {
				JOptionPane.showMessageDialog(null, "마법갑옷 해제가 취소되었습니다.", "마법갑옷 해제 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

		else if (wearingmagicSuit == 0) {
			JOptionPane.showMessageDialog(null, "현재 마법갑옷이 장착되어 있지 않습니다.", "마법갑옷 미장착", JOptionPane.INFORMATION_MESSAGE);

			selectionresult = JOptionPane.showInputDialog("마법갑옷을 장착하시겠습니까? 장착하시려면 1번, 아니면 2번을 눌러주세요.");

			if (selectionresult.equals("1")) {
				if (havemagicSuit == 1) {
					wearmagicSuit();
					sound.playSound("sound/effectsound/equiparmor.wav", 1.0f, false);
					JOptionPane.showMessageDialog(null, "마법 갑옷 장착이 완료되었습니다.", "마법갑옷 장착 완료", JOptionPane.INFORMATION_MESSAGE);
				} else if (havemagicSuit == 0) {
					JOptionPane.showMessageDialog(null, "마법갑옷을 소유하고 있지 않습니다.", "마법갑옷 미소유", JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (selectionresult.equals("2")) {
				
				JOptionPane.showMessageDialog(null, "마법갑옷 장착이 취소되었습니다.", "마법갑옷 장착 취소", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 키를 입력하셨습니다.", "잘못된 키 입력", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}
	

	public void wearSuit() { // 워모그갑옷(풀) 착용
		wearingSuit = 1;

		JOptionPane.showMessageDialog(null, "워모그의 갑옷 착용으로 HP가 50 증가했습니다.", "워모그의 갑옷 착용", JOptionPane.INFORMATION_MESSAGE);
	}

	public void wearmagicSuit() { // 마법갑옷 착용
		wearingmagicSuit = 1;
		JOptionPane.showMessageDialog(null, "하이네스의 갑옷 착용으로 MP가 50 증가했습니다.", "하이네스의 갑옷 착용", JOptionPane.INFORMATION_MESSAGE);
	}

	public void wearWeapon() {// 무기 착용
		JOptionPane.showMessageDialog(null, "엑스칼리버 착용으로 공격력이 10 증가했습니다.", "엑스칼리버 착용", JOptionPane.INFORMATION_MESSAGE);
		wearingWeapon = 1;
	}

	public void cancelSuit() {// 갑옷 벗기
		wearingSuit = 0;
		//System.out.println("워모그의 갑옷 해제완료\n");
		return;
	}

	public void cancelmagicSuit() {// 마법갑옷 벗기
		wearingmagicSuit = 0;
		//System.out.println("하이네스의 갑옷 해제완료\n");
		return;
	}

	public void cancelWeapon() {// 무기 벗기
		wearingWeapon = 0;
		return;
	}

	public void setSuit(String suit1) {
		suit = suit1;
		haveSuit = 1;
	}

	public String getSuit() {
		return suit;
	}

	public void setWeapon(String weapon1) {
		weapon = weapon1;
		haveWeapon = 1;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setMagicsuit(String magicsuit1) {
		magicsuit = magicsuit1;
		havemagicSuit = 1;
	}

	public String getMagicsuit() {
		return magicsuit;
	}

	public int getMoney() {
		return money;
		
	}

	public void setMoney(int money1) {

		money = money1;
	}

	public void setPortion(String portionname2) {// 상점에서 포션삼 완료
		String portionname1;// 상점에서 포션 이름을 받아 구매
		portionname1 = portionname2;

		if (portionname1.equals("redportion")) {
			redportion = redportion + 1;
		} else if (portionname1.equals("blueportion")) {
			blueportion = blueportion + 1;
		} else {
			System.out.println("잘못된 접근입니다.");
		}

	}

	public int getRedportion() {
		return redportion;
	}

	public int getBlueportion() {
		return blueportion;
	}

	public void useRedPortion() {// 레드포션 사용
		redportion = redportion - 1;
	}

	public void useBluePortion() {// 블루포션 사용
		blueportion = blueportion - 1;
	}

	public int getWearingSuit() {
		return wearingSuit;
	}

	public int getWearingmagicSuit() {
		return wearingmagicSuit;
	}

	public int getWearingWeapon() {
		return wearingWeapon;
	}

	public int getHaveWeapon() {// 무기 소유
		return haveWeapon;
	}

	public int getHaveSuit() {// 갑옷 소유
		return haveSuit;
	}

	public int getHavemagicSuit() {// 마법갑옷 소유
		return havemagicSuit;
	}


}
