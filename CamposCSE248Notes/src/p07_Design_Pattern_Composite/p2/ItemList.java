package p07_Design_Pattern_Composite.p2;

import java.util.ArrayList;

public class ItemList {
	private ArrayList<ConsumableItem> list;
	
	public ItemList() {
		this.list = new ArrayList<>();
	}
	
	public void add(ConsumableItem item) {
		list.add(item);
	}
	
	public void printAllItems() {
		for (ConsumableItem item : list)
			item.print();
	}
}
