package tdd1.supermarket;

public class ItemBuilder
{

	Item create(Article article , Integer amount) {
		
		return new Item(article, amount);
	}
}
