package tdd1.supermarket;

public class Item
{

	
	private final Article article;
	private final int amount;

	public Item(Article article, int amount) {
		this.article = article;
		this.amount = amount;
	}

	public double total() {
		return article.total(amount);
	}

	public double getAmount() {
		return amount;
	}

	public boolean isArticle(Article article) {
		return this.article.equals(article);
	}
}
