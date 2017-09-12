package tdd1.supermarket;

import java.util.List;

/**
 * carrello della spesa
 *
 */
public interface Cart {

	public int getTotalPrice();
	
	public List<Item> getItemsInArticle(Article article);
	
	public void add(Item item);

}
