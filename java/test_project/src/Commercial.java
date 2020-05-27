/**
 * The Commercial child class inherits the attributes and properties of the Item 
 * parent class. The purpose of this class is to allow the Disc Jockey class to
 * create instances of Commercial object for the user to read and modify.
 * 
 * Upon creation of an instance of this child class, in addition to the attributes
 * initialized in the Item parent class, the Commercial's company can be set and
 * get by the program and user.
 *	
 * @author Brennan Brown
 * @version 2017-02-24
 */

public class Commercial extends Item
{
	/**
	 * The company being represented in the commercial
	 */
	private String commercialCompany;
	
	/**
	 * Constructor
	 * @param commercialCompany a string of the company being represented in the commercial
	 * 
	 * For documentation on the rest of the parameters, please look at Item.java
	 */
	public Commercial(int id, char category, double playTime, String audioFile, String commercialCompany) 
	{
		super(id, category, playTime, audioFile);
		this.commercialCompany = commercialCompany;
	}
	
	/**
	 * A method to get the company being represented in the commercial
	 * @return a string for the company being represented in the commercial
	 */
	public String getCommercialCompany() 
	{
		return commercialCompany;
	}

	/**
	 * A method to set the company being represented in the commercial
	 * @param commercialCompany a string for the company being represented in the commercial
	 */
	public void setCommercialCompany(String commercialCompany) 
	{
		this.commercialCompany = commercialCompany;
	}
	
	
	//-----HELPER METHODS-----//
	
	
	/**
	 * The purpose of the toString method is to provide a 
	 * string representation of instances of the Talk Show 
	 * object.
	 */
	@Override
	public String toString() 
	{
		return super.toString() + ", Commercial Company" + commercialCompany;
	}

	/**
	 * Compares memory location of `id` attribute of the
	 * instance of the object, and only returns true if 
	 * two reference variables are pointing to same memory 
	 * location, in other words, if they are essentially 
	 * the same instance of the object.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return super.equals(obj);
	}
	

}
