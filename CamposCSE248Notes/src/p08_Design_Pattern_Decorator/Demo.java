package p08_Design_Pattern_Decorator;

public class Demo {

	public static void main(String[] args) {
		Component c1 = new Component();
//		c1.doJob();
		ConcreteDecorator cd1 = new ConcreteDecorator(); // Wrapper Class
		cd1.setComponent(c1); // wrapping
		cd1.doJob();
	}

}
