package edu.sjsu.cs.etrt.model.Patient;

/**
 * 
 * @author Christian Oh
 *
 */
public enum Category {
	category0, category1, category2, category3,category4;
	
	public int categoryToInt(Category c)
	{
		switch(c)
		{
			case category0:
				return 0;
			case category1:
				return 1;
			case category2:
				return 2;
			case category3:
				return 3;
			case category4:
				return 4;
			default:
				return -1;
		}
	}
	
	public Category intToCategory(int i)
	{
		switch(i)
		{
			case 0:
				return category0;
			case 1:
				return category1;
			case 2:
				return category2;
			case 3:
				return category3;
			case 4:
				return category4;
			default:
				return category0;
		}
	}
}
