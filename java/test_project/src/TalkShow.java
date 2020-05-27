/**
 * The Talk Show child class inherits the attributes and properties of the Item 
 * parent class. The purpose of this class is to allow the Disc Jockey class to
 * create instances of Talk Show object for the user to read and modify.
 * 
 * Upon creation of an instance of this child class, in addition to the attributes
 * initialized in the Item parent class, the Talk Show's title and host can be set
 * and get by the program and user.
 *	
 * @author Brennan Brown
 * @version 2017-02-24
 */

public class TalkShow extends Item
{
	/**
	 * The title of the Talk Show
	 */
	private String talkShowTitle;
	/**
	 * The host of the Talk Show
	 */
	private String talkShowHost;
	
	/**
	 * Constructor
	 * @param talkShowTitle a string of the title of the Talk Show
	 * @param talkShowHost  a string of the host of the Talk Show
	 * 
	 * For documentation on the rest of the parameters, please look at Item.java
	 */
	public TalkShow(int id, char category, double playTime, String audioFile, String talkShowTitle, String talkShowHost) 
	{
		super(id, category, playTime, audioFile);
		this.talkShowTitle = talkShowTitle;
		this.talkShowHost = talkShowHost;		
	}
	
	/**
	 * A method to set the title of the Talk Show 
	 * @param talkShowTitle a string for the title of the Talk Show
	 */
	public void setTalkShowTitle(String talkShowTitle) 
	{
		this.talkShowTitle = talkShowTitle;
	}
	
	/**
	 * A method to get the title of the Talk Show
	 * @return a string for the title of the Talk Show
	 */
	public String getTalkShowTitle() 
	{
		return talkShowTitle;
	}

	/**
	 * A method to get the host of the Talk Show
	 * @return a string for the host of the Talk Show
	 */
	public String getTalkShowHost() 
	{
		return talkShowHost;
	}

	/**
	 * A method to set the host of the Talk Show 
	 * @param talkShowTitle a string for the host of the Talk Show
	 */
	public void setTalkShowHost(String talkShowHost) {
		this.talkShowHost = talkShowHost;
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
		return super.toString() + ", Talk Show Title" + talkShowTitle + ", Talk Show Host = " + talkShowHost;
		
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
		if(obj instanceof Item)
		{
			Item inputItem = (Item)obj;
			if(inputItem.getId() == this.getId())
			{
				return true;
			}
		}
		return false;
	}

}
