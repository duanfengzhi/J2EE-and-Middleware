package ejbtest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful
@Local()
public class CartBean implements Cart{
	private List<String> buyitem = new ArrayList<String>();
	
	public void AddBuyItem(String productName) {
		buyitem.add(productName);
	}

	public List<String> getBuyItem() {
		return buyitem;
	}
	
	public void deleteBuyItem(String productName) {
		buyitem.remove(productName);
	}
     public void remove() {
		 buyitem.clear();
    }
}
