import java.io.FileNotFoundException;

/**
 * The App Driver class is responsible for calling the Disc Jockey class and
 * being used to run the program.
 * 
 * @author Brennan Brown
 * @version 2017-02-12
 */

public class AppDriver
{
	/**
	 * This is the main function of the app driver that calls the Disc Jockey
	 * class, which then can run.
	 * 
	 * @throws FileNotFoundException this error checking is needed, as there is
	 * a method (loadItems) within the Disc Jockey class that throws this error.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		new DiscJockey();
	}
}
