package p06_Design_Pattern_Factory;

public class EnemyShipFactory {
	public EnemyShip makeEnemyShip(String shipType) {
		if (shipType.equals("U"))
			return new UFOEnemyShip();
		else if (shipType.equals("R"))
			return new RocketEnemyShip();
		else if (shipType.equals("H"))
			return new HugeUFOEnemeyShip();
		else
			return null;
	}
}
