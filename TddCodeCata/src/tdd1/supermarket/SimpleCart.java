package tdd1.supermarket;

import java.util.ArrayList;
import java.util.List;

public class SimpleCart implements Cart
{
	
	private List<Item> items = new ArrayList<Item>();

	@Override
	public int getTotalPrice()
	{
		int total = 0;
		for (Item item : items) {
			total += item.total();
		}
		return total;
	}

	@Override
	public List<Item> getItemsInArticle(Article article)
	{
		List<Item> articleItems = new ArrayList<Item>();
		for (Item item : items) {
			if (item.isArticle(article)) {
				articleItems.add(item);
			}
		}
		return articleItems;
	}

	@Override
	public void add(Item item)
	{
		items.add(item);
		
	}

}
