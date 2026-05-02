package AdventureGame;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Güvenli Ev");	
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("İyileştiniz...");
		System.out.println("Şu An Güvenli Ev Adlı Yerdesiniz.");
		return true;
	}
}
