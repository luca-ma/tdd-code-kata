package tdd1.supermarket;

import org.junit.Assert;
import org.junit.Test;

import tdd1.supermarket.discount.Discount;
import tdd1.supermarket.discount.XForYDiscount;


/*
Back to the Checkout
http://codekata.com/kata/kata09-back-to-the-checkout/
Item   Unit      Special
       Price     Price
--------------------------
  A     50       3 for 130
  B     30       2 for 45
  C     20
  D     15
*/

public class CartTest
{
			
		private ArticleFactory articleFactory = new ArticleFactory();
		private Article articleA = articleFactory.article("A",50);
		private Article articleB = articleFactory.article("B",30);
		private ItemBuilder itemBuilder = new ItemBuilder();

		@Test
		public void testNoItems() {
			Cassier cassier = new Cassier();
			Cart cart = new SimpleCart();
			double total = cassier.total(cart);
			
			Assert.assertEquals(0.0, total, 0.001);
		}

		
		
		/**
		 * 1 for A + 1 for A (no disc)
		 */
		@Test
		public void testOneKindItem() {
			Cassier cassier = new Cassier();
			Cart cart = new SimpleCart();
			cart.add(itemBuilder.create(articleA, 1));
			cart.add(itemBuilder.create(articleA, 1));
			int total = cassier.total(cart);
			
			Assert.assertEquals(1080, total);
		}

		@Test
		public void testTwoKindItem() {
			
		}
		
		
		@Test
		public void testThreeKindItem() {
			
		}
		// 3 for A
		//and 4 for A
		@Test
		public void testSpecialOffer() {
			Cassier cassier = new Cassier();
			Cart cart = new SimpleCart();
			cassier.addDiscount(new XForYDiscount(articleA,3,130));
			
			cart.add(itemBuilder.create(articleA, 3));
			int total = cassier.total(cart);
			
			Assert.assertEquals(130, total);
		}
		
		//========================
		@Test
		public void testItems() {
			Cassier cassier = new Cassier();
			Cart cart = new SimpleCart();
			cart.add(itemBuilder.create(articleA, 3));
			
			double total = cassier.total(cart);
			
			Assert.assertEquals(4.0, total, 0.001);
		}

		@Test
		public void test3For2() {
			Cassier cassier = new Cassier();
			cassier.addDiscount(new XForYDiscount(articleA, 3, 2));
			Cart cart = new SimpleCart();
			cart.add(itemBuilder.create(articleA ,1));
			cart.add(itemBuilder.create(articleB ,3));
			double total = cassier.total(cart);
			
			Assert.assertEquals(4.0, total, 0.001);
		}


}
