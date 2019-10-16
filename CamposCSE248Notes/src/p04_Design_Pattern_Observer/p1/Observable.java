package p04_Design_Pattern_Observer.p1;

public interface Observable {
	public abstract void register(Observer o);
	
	public abstract void unregister(Observer o);
	
	public abstract void notifyObservers();
}
