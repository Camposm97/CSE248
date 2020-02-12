package p07_Design_Pattern_Composite.p1;

import java.util.ArrayList;

/**
 * Composite: List of Objects that implement the same interface.  So the generic of the list is that interface.  
 * 
 * @author Camposm97
 */
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
