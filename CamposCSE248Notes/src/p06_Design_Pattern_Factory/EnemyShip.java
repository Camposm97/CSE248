package p06_Design_Pattern_Factory;

public abstract class EnemyShip {
	private String name;
	private double speed;
	private double directX;
	private double directY;
	private double amtDamage;

	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirectX(double directX) {
		this.directX = directX;
	}

	public void setDirectY(double directY) {
		this.directY = directY;
	}

	public void setAmtDamage(double amtDamage) {
		this.amtDamage = amtDamage;
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public void followHeroShip() {
		// TODO Auto-generated method stub
		
	}

	public void shoots() {
		// TODO Auto-generated method stub
		
	}
	
	
}
