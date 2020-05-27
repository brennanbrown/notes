import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The Disc Jockey is responsible for all methods and functionality 
 * concerning the interaction between the user and the program itself.
 * 
 * There are effectively four main functions that the user can call on
 * in order to interact with the program and ArrayList that is created
 * from the database file. These include: adding a new item, searching
 * for an item, removing an item and generating a full, detailed list
 * of all items within the database.
 *	
 * @author Brennan Brown
 * @version 2017-02-12
 */

public class DiscJockey
{
	private final File DATABASE_LIST = new File ("res/database.txt");
	private ArrayList<Item>itemList;
	private Scanner sc = new Scanner(System.in);
	private Scanner infile;
	private int intInput;
	
	public DiscJockey() throws FileNotFoundException
	{
		loadItems(DATABASE_LIST);
		discJockeyMenu();
	}

	/**
	 * This method is responsible for allowing the user to
	 * input what function they would like to call and perform
	 * within the program.
	 * 
	 * The Disc Jockey Menu is the user-interface which will
	 * control what methods are being called, depending on
	 * what number is being chosen.
	 * 
	 * 1 will add a new Song, Talk Show or Commercial
	 * 2 will search for an Item by ID
	 * 3 will remove a Song, Talk Show or Commercial
	 * 4 will print a complete list of items, or all items within a category
	 * 5 will quit the program
	 * @throws FileNotFoundException
	 */
 	public void discJockeyMenu() throws FileNotFoundException
 	{
 		System.out.println("Welcome to the Disc Jockey Program.");
 		System.out.println("Press 1 to add a new Song, Talk Show or Commercial.");
 		System.out.println("Press 2 to search for an Item by ID.");
 		System.out.println("Press 3 to remove a Song, Talk Show or Commercial.");
 		System.out.println("Press 4 to print a complete list of items, or all items within a category.");
 		System.out.println("Press 5 to exit the program.");
 		getInput();
 	}

 	/**
 	 * This method is responsible for reading the input of the user and then calling the
 	 * corresponding function to complete their request. 
 	 */
 	public void getInput()
 	{
 		System.out.println("Please enter the number: ");
 		intInput = sc.nextInt();
 		
 		if(intInput == 1)
 		{
 			addItemToList();
 		}

 		else if(intInput == 2)
 		{
 			searchListByID();
 		}

 		else if(intInput == 3)
 		{
 			deleteItem();
 		}

 		else if(intInput == 4)
 		{
 			generateItemList();
 		}

 		else if(intInput == 5)
 		{
 			System.out.println("Exiting the program now. Goodbye.");
 			System.exit(0);
 		}
 		
 		else
 		{
 			System.out.println("Thats not an option, please choose again.");
 			intInput = sc.nextInt();
 		}
 	}
 	
 	/**
 	 * This method is responsible for allowing a user to add their own Item (Talk Show,
 	 * Song or Commercial) to the database list that is read by the program. The
 	 * function will ask the user to input each attribute of the Item, followed by the
 	 * attributes of the specific child class that it falls into.
 	 */
 	public void addItemToList()
 	{
 		char charInput = '\u0000';
 		PrintWriter outfile = null;	
 		int id;
 		char category;
 		double playTime;
 		String audioFile;
 		
 		String newSong = null;
 		String newTalkShow = null;
 		String newCommercial = null;
 		
 		System.out.println("Please enter the ID media item (####): \n");
 		id = sc.nextInt();
 		
 		
		/** 
		 * Runs a for loop through the entire Item List to check if
		 * the ID that has been inputed by user has already been
		 * entered into the database.
		 */
		for (int i = 0; i < itemList.size(); i++) 
		{
			Item item = itemList.get(i);
			if (item.getId() == id) 
			{
				System.out.println("That ID is already in use, please try again. Exiting. \n");
				System.exit(0);
			}
		}
		
		System.out.println("Please enter the category/genre of the media item: (Single Character)\n");
		category = sc.next().charAt(0);
		
		System.out.println("Please enter playing time of the media item: (Format: 0.00)\n");
		playTime = sc.nextDouble();
		
		System.out.println("Please enter file name for this media item: (Example.mp3)\n");
		audioFile = sc.next();
		
		System.out.print("Type 'Song' to add a Song ID.\n"
			+ "Type 'Talk Show' to add a Talk Show ID.\n"
			+ "Type 'Commercial' to add a Commercial ID.\n"
			+ "Type 'X' to exit the Disc Jockey Program.\n");
		charInput = sc.next().toUpperCase().charAt(0);
		while(charInput != 'X')
		{
			switch(charInput)
			{
				case 'S':
				{
					String songTitle;
					String songArtist;
					System.out.println("Please enter the title of this song: \n");
					songTitle = sc.next();
					System.out.println("Please enter the artist of this song: \n");
					songArtist = sc.next();
					newSong=id+","+category+","+songTitle+","+songArtist+","+playTime+","+audioFile;
					
					System.out.printf(newSong);
					String filename = "res/database.txt";
					try	
					{
						FileWriter fw = new FileWriter(filename, true);
						outfile = new PrintWriter(fw);
					}
					catch(IOException e)
					{
						System.err.println("An error occured when opening output!");
						System.exit(-1);
					}
					
					outfile.println("\n"+newSong);
					System.out.println("Sucessfully added a new song!");
					outfile.flush();	
					outfile.close();	
					System.out.println("Exiting Disc Jockey Program.");
					System.exit(0);
					break;
				}
				case 'T':
				{
					String talkShowTitle;
					String talkShowHost;
					System.out.println("Please enter the title of this song: \n");
					talkShowTitle = sc.next();
					System.out.println("Please enter the artist of this song: \n");
					talkShowHost = sc.next();
					newTalkShow=id+","+talkShowTitle+","+talkShowHost+","+category+","+playTime+","+audioFile;
					
					System.out.printf(newTalkShow);
					String filename = "res/database.txt";
					try	
					{
						FileWriter fw = new FileWriter(filename, true);
						outfile = new PrintWriter(fw);
					}
					catch(IOException e)
					{
						System.err.println("An error occured when opening output!");
						System.exit(-1);
					}
					
					outfile.println("\n"+newTalkShow);
					System.out.println("Sucessfully added a new talk show!");
					outfile.flush();	
					outfile.close();	
					System.out.println("Exiting Disc Jockey Program.");
					System.exit(0);
					break;
				}
				case 'C':
				{
					String commercialCompany;
					System.out.println("Please enter the company that created the commercial: \n");
					commercialCompany = sc.next();
					newCommercial=id+","+category+","+commercialCompany+","+playTime+","+audioFile;
					
					System.out.printf(newCommercial);
					String filename = "res/database.txt";
					try	
					{
						FileWriter fw = new FileWriter(filename, true);
						outfile = new PrintWriter(fw);
					}
					catch(IOException e)
					{
						System.err.println("An error occured when opening output!");
						System.exit(-1);
					}
					
					outfile.println("\n"+newCommercial);
					System.out.println("Sucessfully added a new commercial!");
					outfile.flush();	
					outfile.close();	
					System.out.println("Exiting Disc Jockey Program.");
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("That is not a valid choice, please select S, T or C. Press X to exit.");
					break;
				}
			}
		}
	}	
 	
 	/**
 	 * This method is responsible for allowing the user to search through the ArrayList for
 	 * a specific Item by ID. The program will then output all parent class attributes that
 	 * apply to that specific Item.
 	 * 
 	 * @return null, as the function only utilizes the Item class superficially.
 	 */
	public Item searchListByID()
	{		
		System.out.println("Enter the Item ID you want to search for: ");
		int searchID = sc.nextInt();

		for (int i = 0; i < itemList.size(); i++) 
		{
			Item itemSearch = itemList.get(i);
			if (itemSearch.getId() == searchID) 
			{
				int id = itemSearch.getId();
				char category = itemSearch.getCategory();
				double playTime = itemSearch.getPlayTime();
				String audioFile = itemSearch.getAudioFile();
				
				System.out.println("\nID\tGENRE\tLENGTH\t\tFILE NAME");
				System.out.printf("%4d\t%1c\t%2.2f\t%15s\n",
						id,category,playTime,audioFile);
				System.out.println("\nExiting Program.");
				System.exit(1);
			}
		}
		System.out.println("Error: ID is not found");
		return null;
	}

	/**
	 * This method is responsible for allowing the user to delete an Item (Talk Show,
	 * Song or Commercial) from the ArrayList. It is important to note that this function
	 * does not directly modify the database file, so the Item will only be deleted from
	 * the current instance of the program.
	 * 
	 * @return TRUE if the Item ID that the user has inputed can be found and deleted,
	 * and FALSE if the Item ID that the user has inputed cannot be found and therefore
	 * not deleted.
	 */
	public boolean deleteItem()
	{
		Item item;
		System.out.println("Enter the Song ID you want to delete: ");
		int deleteID = sc.nextInt();
		
		for (int i = 0; i < itemList.size(); i++) {
			item = itemList.get(i);
			if (item.getId() == deleteID) {
				itemList.remove(i);
				System.out.println("Removed Item ID = " + deleteID + "\n");
				return true;
			}
		}
		System.out.println("Error: Could not find ID. Exiting Program.");
		return false;

	}

	/**
	 * This method is responsible for generating a list of all Items (Talk Shows,
	 * Songs and Commercials) from the database list and printing them into the
	 * terminal for easy readability for the user.
	 */
	public void generateItemList()
	{	
		SimpleDateFormat currentDate = new SimpleDateFormat("Y-M-d");
		Date date = new Date();

		System.out.printf("\nRADIO STATION\t\t\t\t\t\tITEMS\t\t\t\t\t%s\n\n",currentDate.format(date));
		System.out.println("ID\tGENRE\tLENGTH\t\tFILE NAME\t\tTITLE/COMPANY\t\t\t\tARTIST/TOPIC\n");
		
		for(int i = 0; i < itemList.size(); i++)
		{
			Item itemReport = itemList.get(i);
			
			int id = itemReport.getId();
			char category = itemReport.getCategory();
			double playTime = itemReport.getPlayTime();
			String audioFile = itemReport.getAudioFile();
			
			// TALK SHOW
			if((id % 10) >= 0 && (id % 10) <= 2)
			{
				String talkShowTitle = ((TalkShow) itemReport).getTalkShowTitle();
				String talkShowHost = ((TalkShow) itemReport).getTalkShowHost();
				System.out.printf("%4d\t%1c\t%2.2f\t%15s\t%32s\t%29s\n",
					id,category,playTime,audioFile,talkShowTitle,talkShowHost);
			}
			
			// SONG
			else if((id % 10) >= 3 && (id % 10) <= 7)
			{
				String songTitle = ((Song) itemReport).getSongTitle();
				String songArtist = ((Song) itemReport).getSongArtist();
				System.out.printf("%4d\t%1c\t%2.2f\t%15s\t%32s\t%29s\n",
					id,category,playTime,audioFile,songTitle,songArtist);
			}
			
			// COMMERCIAL
			else if((id % 10) >= 8 && (id % 10) <= 9)
			{
				String commercialCompany = ((Commercial) itemReport).getCommercialCompany();
				System.out.printf("%4d\t%1c\t%2.2f\t%15s\t%32s\t\n",
						id,category,playTime,audioFile,commercialCompany);
			}
			
			// ERROR-CHECKING
			else
			{
				System.err.println("\tError reading infile. Please try again. Exiting.\n");
				System.exit(-1);
			}
			
		}
		System.out.println("Exiting Disc Jockey Program.");
		System.exit(0); 

	}

	//-----HELPER METHODS-----//

	/**
	 * This method is responsible for reading the database file and 
	 * parsing the data of each Item (and it's details) within the 
	 * ArrayList so that it can be used by the program.
	 * 
	 * @param DATABASE_LIST the File that stores all items within the ArrayList used within the program
	 * @throws FileNotFoundException the error given if the specific File cannot be found
	 */
	@SuppressWarnings("unused")
	private void loadItems(File DATABASE_LIST) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(DATABASE_LIST);
		String[] database;
		itemList = new ArrayList<Item>();
		
		try 
		{
			infile = new Scanner(DATABASE_LIST);
			
			while(infile.hasNext())
			{
				// Read ID, then go into loop
				String retrieve = infile.nextLine();
				database = retrieve.split(",");
				int id = Integer.parseInt(database[0]);
				
				/*
				 * This if/else statement will parse the last digit of the ID
				 * and will then run the rest of the parsing based on.
				 * 
				 * Explanation: When you look for the modulus (%) of any number
				 * divided by 10, it will print the last digit of the number 
				 * regardless of how large the number is.
				 * 
				 */

				// TALK SHOW
				if((id % 10) >= 0 && (id % 10) <= 2)
				{
					char category = database[1].charAt(0);
					String talkShowTitle = database[2];
					String talkShowHost = database[3];
					double playTime = Double.parseDouble(database[4]);
					String audioFile = database[5];
					
					itemList.add(new TalkShow(Integer.parseInt(database[0]),
						database[1].charAt(0),Double.parseDouble(database[4]),
						database[5],database[2],database[3]));
					inputFile.close();
				}

				// SONG
				else if((id % 10) >= 3 && (id % 10) <= 7)
				{
					char category = database[1].charAt(0);
					String songTitle = database[2];
					String songArtist = database[3];
					double playTime = Double.parseDouble(database[4]);
					String audioFile = database[5];
					
					itemList.add(new Song(Integer.parseInt(database[0]),database[1].charAt(0),
						Double.parseDouble(database[4]),database[5],database[2],database[3]));
					inputFile.close();
				}
				
				// COMMERCIAL
				else if((id % 10) >= 8 && (id % 10) <= 9)
				{
					char category = database[1].charAt(0);
					String commercialCompany = database[2];
					double playTime = Double.parseDouble(database[3]);
					String audioFile = database[4];
					
					itemList.add(new Commercial(Integer.parseInt(database[0]),database[1].
						charAt(0),Double.parseDouble(database[3]),database[4],database[2]));
					inputFile.close();
				}
				
				// ERROR CHECKING
				else
				{
					System.err.println("\tError reading infile. Please try again. Exiting.\n");
					System.exit(-1);
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("\tError reading infile. Please try again. Exiting.\n");
			System.exit(-1);
		}
	}
}
