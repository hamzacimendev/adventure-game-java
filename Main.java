package AdventureGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoşgeldiniz !");
		System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("=========================================");
			System.out.println();
			System.out.println("Eylem Gerçekleştirmek İçin Bir Yer Seçiniz: ");
			System.out.println("\n1-Güvenli Ev --> Size Ait Güvenli Bir Mekan, Düşman Yok !");
			System.out.println("2-Mağara --> Karşınıza Zombi Çıkabilir !");
			System.out.println("3-Orman --> Karşınıza Vampir Çıkabilir !");
			System.out.println("4-Nehir --> Karşınıza Ayı Çıkabilir !");
			System.out.println("5-Mağaza --> Silah veya Zırh Alabilirsiniz !");
			System.out.println("Gitmek İstediğiniz Yer: ");
			int selLoc = scan.nextInt();
			while(selLoc < 1 || selLoc > 5) {
				System.out.println("Lütfen Gçerli Bir Yer Seçiniz: ");
				selLoc = scan.nextInt();
			}
			
			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}
			
			if(location.getName() == "Güvenli Ev") {
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Tebrikler Oyunu Kazandınız !");
					break;
				}
			}
			if(!location.getLocation()) {
				System.out.println("Oyun Bitti !");
				break;
			}
		}
	}
}
