package p08_Design_Pattern_Decorator;

public abstract class Decorator implements IComponent {
	private IComponent component;
	
	public void setComponent(IComponent component) {
		this.component = component;
	}
	
	@Override
	public void doJob() {
		if (component != null) {
			component.doJob();
		}
	}	
}
