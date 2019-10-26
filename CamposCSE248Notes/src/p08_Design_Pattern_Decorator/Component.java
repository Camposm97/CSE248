package p08_Design_Pattern_Decorator;

public class Component implements IComponent { 
	
	@Override
	public void doJob() {
		System.out.println("Job Done by Component Class");
	}
}
