public class Dogs
{
	// Declare Attributes
	private int id = 0;
	private String name = null;
	private double runningTime = 0.0;
	private double penalty = 0.0;
	private char courseCode = null;

	// Constructor
	public Dogs(int id, String name, double runningTime, double penalty, char courseCode)
	{
		this.id = id;
		this.name = name;
		this.runningTime = runningTime;
		this.penalty = penalty;
		this.courseCode = courseCode;
	}

	public int getID() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getRunningTime(){
		return runingTime;
	}

}