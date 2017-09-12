package tdd1.supermarket;

import java.util.ArrayList;
import java.util.List;

import tdd1.supermarket.discount.Discount;

public class Cassier {

	private List<Discount> discounts = new ArrayList<Discount>();
	
	public int total(Cart cart) {
		int total = cart.getTotalPrice();
		for (Discount discount : discounts) {
			total -= discount.discount(cart);
		}
		return total;
	}

	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}

}
