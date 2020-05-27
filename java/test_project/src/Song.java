/**
 * The Song child class inherits the attributes and properties of the Item 
 * parent class. The purpose of this class is to allow the Disc Jockey class to
 * create instances of Song object for the user to read and modify.
 * 
 * Upon creation of an instance of this child class, in addition to the attributes
 * initialized in the Item parent class, the Song's title and artist can be set
 * and get by the program and user.
 *	
 * @author Brennan Brown
 * @version 2017-02-24
 */

public class Song extends Item
{
	/**
	 * The title of the Song
	 */
	private String songTitle = null;
	/**
	 * The host of the Song
	 */
	private String songArtist = null;
	
	/**
	 * Constructor
	 * @param songTitle  a string of the title of the Song
	 * @param songArtist a string of the artist of the Song
	 * 
	 * For documentation on the rest of the parameters, please look at Item.java
	 */
	public Song(int id, char category, double playTime, String audioFile, String songTitle, String songArtist) 
	{
		super(id, category, playTime, audioFile);
		this.songTitle = songTitle;
		this.songArtist = songArtist;
	}
	
	/**
	 * A method to get the title of the Song
	 * @return a string for the title of the Song
	 */
	public String getSongTitle() 
	{
		return songTitle;
	}

	/**
	 * A method to set the title of the Song
	 * @param songTitle a string for the title of the Song
	 */
	public void setSongTitle(String songTitle) 
	{
		this.songTitle = songTitle;
	}

	/**
	 * A method to get the artist of the Song
	 * @return a string for the artist of the Song
	 */
	public String getSongArtist() 
	{
		return songArtist;
	}

	/**
	 * A method to set the artist of the Song
	 * @param songArtist a string for the artist of the Song
	 */
	public void setSongArtist(String songArtist) 
	{
		this.songArtist = songArtist;
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
		return super.toString() + ", Song Title" + songTitle + ", Song Artist = " + songArtist;
		
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
