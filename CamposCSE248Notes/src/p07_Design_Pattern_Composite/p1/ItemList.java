package p07_Design_Pattern_Composite.p1;

import java.util.ArrayList;

public class ItemList {
	private ArrayList<IItem> list;
	
	public ItemList() {
		this.list = new ArrayList<>();
	}
	
	public void add(IItem item) {
		list.add(item);
	}
	
	public void printAllItems() {
		for (IItem item : list)
			item.print();
	}
}
