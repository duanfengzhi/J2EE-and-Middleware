package ejbtest;

import java.util.List;


public interface Cart{
	 public void AddBuyItem(String productName);
	 public List<String> getBuyItem();
	 public void deleteBuyItem(String productName);
	 public void remove();
}
