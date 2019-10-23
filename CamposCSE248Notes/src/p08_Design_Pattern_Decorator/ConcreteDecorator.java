package p08_Design_Pattern_Decorator;

public class ConcreteDecorator extends Decorator {
	@Override
	public void doJob() {
		super.doJob();
		System.out.println("Job Done by ConcreteDecorator");
	}
}
