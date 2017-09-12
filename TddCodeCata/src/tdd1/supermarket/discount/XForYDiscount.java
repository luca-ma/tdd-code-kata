package tdd1.supermarket.discount;

import tdd1.supermarket.Article;
import tdd1.supermarket.Cart;
import tdd1.supermarket.Item;


/**
 * % sconto dato 
 * un articolo e una quantità di item
 * 
 * ES:articolo  A    3 item  for 130
 * 
 * @author 10095067
 *
 */
public class XForYDiscount implements Discount
{

	private Article article;
	private double itemAmount;
	private double forAmount;

	public XForYDiscount(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}
	
	@Override
	public double discount(Cart cart)
	{
		int amount = 0;
		for (Item item : cart.getItemsInArticle(article)) {
			amount += item.getAmount();
		}
		double discount = (amount / itemAmount) * article.total(itemAmount - forAmount);
		return discount;
	}

}
