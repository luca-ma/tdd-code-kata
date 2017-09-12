package tdd1.supermarket;

public class Article
{
	private final Price price;
	private final String name;

	public Article(String name, Price price) {
		this.name = name;
		this.price = price;
	}

	public int total(int amount) {
		return price.total(amount);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else
			if (!name.equals(other.name))
				return false;
		if (price == null)
		{
			if (other.price != null)
				return false;
		}
		else
			if (!price.equals(other.price))
				return false;
		return true;
	}

	

	
	
}
