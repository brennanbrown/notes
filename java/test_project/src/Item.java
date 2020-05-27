/**
 * The Item parent class is responsible for creating the shared attributes of the
 * three child classes within this program: Talk Show, Song and Commercial. The
 * purpose of this class is to allow these child classes to created and then read 
 * and modified by the Disc Jockey class.
 * 
 * Upon creation of an instance of this parent class, the base attributes of all
 * children classes will be initialized, which can be set and get by the user and
 * program.
 * 	
 * @author Brennan Brown
 * @version 2017-02-24
 */

public abstract class Item 
{

	/**
	 * The audio item's unique ID
	 */
	private int id = 0;
	/**
	 * The audio item's category (or genre)
	 */
	private char category = '\u0000';
	/**
	 * The audio item's length of time
	 */
	private double playTime = 0;
	/**
	 * The audio item's file name
	 */
	private String audioFile = null;

	/**
	 * Constructor
	 * 
	 * @param id        an int of the audio item's unique ID
	 * @param category  a char of the audio item's category (or genre)
	 * @param playTime  a double of the audio item's length of time
	 * @param audioFile a String of the audio item's file name
	 */
	public Item(int id, char category, double playTime, String audioFile)
	{
		this.id = id;
		this.category = category;
		this.playTime = playTime;
		this.audioFile = audioFile;
	}
	
	/**
	 * A method to get the int of the audio item's unique ID
	 * @return an int of the audio item's unique ID
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * A method to set the audio item's unique ID
	 * @param id an int of the audio item's unique ID
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * A method to get the audio item's category (or genre)
	 * @return a char of the audio item's category (or genre)
	 */
	public char getCategory() 
	{
		return category;
	}

	/**
	 * A method to set the audio item's category (or genre)
	 * @param category a char of the audio item's category (or genre)
	 */
	public void setCategory(char category) 
	{
		this.category = category;
	}

	/**
	 * A method to get the audio item's length of time
	 * @return a double of the audio item's length of time
	 */
	public double getPlayTime() 
	{
		return playTime;
	}

	/**
	 * A method to set the audio item's length of time
	 * @param playTime a double of the audio item's length of time
	 */
	public void setPlayTime(double playTime) 
	{
		this.playTime = playTime;
	}

	/**
	 * A method to get the audio item's file name
	 * @return a String of the audio item's file name
	 */
	public String getAudioFile() 
	{
		return audioFile;
	}

	/**
	 * A method to set the audio item's file name
	 * @param audioFile a String of the audio item's file name
	 */
	public void setAudioFile(String audioFile) 
	{
		this.audioFile = audioFile;
	}

	
	//-----HELPER METHODS-----//
	
	
	/**
	 * The purpose of the toString method is to provide a 
	 * string representation of instances of the Talk Show 
	 * object.
	 */
	@Override
	public String toString(){		
		return 	"ID =" + id+", Category = " + category 
				+ ", Play Time = " + playTime + ", Audio File = " 
				+ audioFile;
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
			if(inputItem.id == this.id)
			{
				return true;
			}
		}
		return false;
	}
}