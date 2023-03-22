package in.ineuron.dto;

public class BookDTO
{
	private Integer bookId;
	private String title;
	private String author;
	private String category;
	private Integer availableQuantity;

	public Integer getBookId()
	{
		return bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public Integer getAvailableQuantity()
	{
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity)
	{
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString()
	{
		return "BookDTO [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", availableQuantity=" + availableQuantity + "]";
	}

}
