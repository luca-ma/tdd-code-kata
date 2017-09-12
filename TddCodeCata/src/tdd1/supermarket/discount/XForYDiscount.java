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
 sconto solo su un prodotto indipendentemente dagli altri
 *
 */
public class XForYDiscount implements Discount
{

	private Article article;
	private int numberForDiscount;
	private int valueForDiscount;

	public XForYDiscount(Article article, int numberForDiscount, int valueForDiscount) {
		this.article = article;
		this.numberForDiscount = numberForDiscount;
		this.valueForDiscount = valueForDiscount;
	}
	
	@Override
	public int discount(Cart cart)
	{
	//	int numOfItems=0;
		int amount = 0;
		for (Item item : cart.getItemsInArticle(article)) {
			amount += item.getAmount();
			//numOfItems++;
		}
		if (amount/this.numberForDiscount >=1) {
			//c'è uno sconto
			return (article.total(amount))-((amount/this.numberForDiscount)*this.valueForDiscount+article.total(amount%this.numberForDiscount));
		}else {
			return article.total(amount);
		}
	}

}
