package p06_Design_Pattern_Factory;

public class Demo {
	public static void main(String[] args) {
		EnemyShipFactory factory = new EnemyShipFactory();
		EnemyShip es = factory.makeEnemyShip("U");
		doStuff(es);
	}
	
	public static void doStuff(EnemyShip es) {
		es.display();
		es.followHeroShip();
		es.shoots();
	}
}
