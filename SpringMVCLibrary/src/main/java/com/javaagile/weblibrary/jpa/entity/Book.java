package com.javaagile.weblibrary.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A model object for book.
 * @author Memo Pena
 */
@Entity
@Table(name = "book")
public class Book {
	
	private static final int MAX_LENGTH_FIRST_NAME = 50;
	private static final int MAX_LENGTH_LAST_NAME = 50;
	private static final int MAX_LENGTH_TITLE = 60;
	private static final int MAX_LENGTH_DESCRIPTION = 80;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="title", nullable=false, length = MAX_LENGTH_TITLE)
	private String title;
	
	@Column(name = "author_first_name", nullable=false, length = MAX_LENGTH_FIRST_NAME)
    private String authorFirstName;
	
	@Column(name = "author_last_name", nullable=false, length = MAX_LENGTH_LAST_NAME)
    private String authorLastName;
	
	@Column(name = "price")
    private float price;
	
	@Column(name = "on_sale")
    private boolean  onSale;
	
	@Column(name = "year")
    private int  year;
	
	@Column(name = "description",  length = MAX_LENGTH_DESCRIPTION)
    private String   description;

	public Long getId() {
		return id;
	}
	
	  public static Builder getBuilder(String title, String authorFirstName, String authorLastName ) {
		  
	        return new Builder(title, authorFirstName, authorLastName );
	    }
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	
	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public float getPrice() {
		return price;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorFirstName == null) ? 0 : authorFirstName.hashCode());
		result = prime * result
				+ ((authorLastName == null) ? 0 : authorLastName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorFirstName == null) {
			if (other.authorFirstName != null)
				return false;
		} else if (!authorFirstName.equals(other.authorFirstName))
			return false;
		if (authorLastName == null) {
			if (other.authorLastName != null)
				return false;
		} else if (!authorLastName.equals(other.authorLastName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public void update(final float price, final boolean onSale, final int year, String description ){
		
		this.price = price;
		this.onSale = onSale;
		this.year = year;
		this.description = description;
		
	}
	
	
	/**
	 * Builder class for Book entity
	 * @author Memo Pena
	 *
	 */
	public static class Builder{
		
		private Book built;
		
		public Builder( String title, String authorFirstName, String authorLastName ){
			
			built = new Book();
			built.title = title;
			built.authorFirstName = authorFirstName;
			built.authorLastName =  authorLastName;
			
		}
		
		public Builder price(float price){
			
			built.price = price;
			return this;
		}
		
		public Builder onSale(boolean onSale){
			
			built.onSale = onSale;
			return this;
		}
		
		
		public Builder year(int year){
			
			built.year = year;
			return this;
			
		}
		
		public Builder description(String description){
			
			built.description = description;
			return this;
		}
		
		
		public Book build(){
			
			return built;
			
		}
		
	}

}
