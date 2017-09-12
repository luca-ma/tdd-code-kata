package tdd1.supermarket;

public class ArticleFactory
{
	
	
	public Article article(String name, int price) {
		
		return new Article(name, new Price(price));
	}

}
