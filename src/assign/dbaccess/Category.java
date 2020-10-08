package assign.dbaccess;

import java.io.*;
 
/**
 * 
 * Category Bean
 *
 */

public class Category implements Serializable {
 

	private String categoryId;
	private String categoryName;



	/**
	 * No Argument Constructor
	 */
	public Category() {
		super();
	}

// Getters

	public String getCategoryId() {
		return categoryId;
	}
 
	public String getCategoryName() {
		return categoryName;
	}


// Setters

	public void setCategoryId(String inCategoryId) {
		categoryId = inCategoryId;
	}
 
	public void setCategoryName(String inCategoryName) {
		categoryName = inCategoryName;
	}
}
 
