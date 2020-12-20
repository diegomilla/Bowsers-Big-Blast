import java.util.Scanner;

public class BowsersBigBlast
{
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Bowser's Big Blast");
		System.out.println("");
        delayOneSecond();
        //This part of the code is just to add visual effects to the console, it's actually unnecessary
		System.out.print("Game initiated");
		for (int x = 0; x <= 3; x++)
		{
			delayOneSecond();
			System.out.print(". ");
		}
		System.out.println("");
		System.out.println("");
		System.out.print("Game loading");
		for (int x = 0; x <= 3; x++)
		{
			delayOneSecond();
			System.out.print(". ");
        }
        //end of unnecessary part

		//Game actually begins here, options "menu" is displayed for user to choose what they wish to do
		System.out.println("");
		System.out.println("Welcome to Bowser's Big Blast!");
		System.out.println("");
		System.out.println("Please pick an option and then hit enter (type 1 for option 1, 2 for option 2, etc)");
		System.out.println("");
		System.out.println("Option 1 - Play Game");
		System.out.println("Option 2 - Learn More About Game");
		System.out.println("Option 3 - Math/Complexity Behind Game");
		System.out.println("");
        int beginningChoice = in.nextInt();
        //Will loop as many times until the user decides to start the game
		while (beginningChoice != 1)
		{
			if (beginningChoice == 2)
			{
				//Brief history of the game, origins
				System.out.println("");
				System.out.println("In Japan in 1999, Mario Party 2 was released for the Nintendo 64.");
				System.out.println("Developed by Hudson Soft and published by Nintendo, this next installment");
				System.out.println("in the Mario Party game series provided a refined and improved version of");
				System.out.println("the original game. Each game consisted of four players moving around a board");
				System.out.println("where the objective was to get as many stars and coins than your opponent. At");
				System.out.println("the end of each player's turn, they all play a mini-game together and the winner");
				System.out.println("receives coins at the end to use for next turn. There were a plethora of mini-games");
				System.out.println("in Mario Party 2, but one reallys stands out. Subsequently titled the same as this");
				System.out.println("program, Bowser's Big Blast was the mini-game that inspired this program. The premise");
				System.out.println("is four players take turns pushing down pumps, until one remains. With each iteration,");
				System.out.println("the number of pumps and players goes down until there are two players and three pumps remaining.");
				System.out.println("The game can be very short or long, depending if the \"bad\" pump is pushed down or avoided.");
				System.out.println("With each player that gets eliminated, the pressure and intensity grows! In the end, it all");
				System.out.println("rides on luck. Last player standing is deemed the winner! Good luck!");
				System.out.println("");
				try
				{
					Thread.sleep(6000);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				System.out.println("Please pick an option and then hit enter (type 1 for option 1, 2 for option 2, etc)");
				System.out.println("");
				System.out.println("Option 1 - Play Game");
				System.out.println("Option 2 - Learn More About Game");
				System.out.println("Option 3 - Math/Complexity Behind Game");
				System.out.println("");
				beginningChoice = in.nextInt();
			}
			else if (beginningChoice == 3)
			{
				System.out.println("");
				System.out.println("The math and complexity behind the game is actually quite simple. Beginning with four players,");
				System.out.println("called n, there will always be n + 1 pumps. One of these pumps will be given a false flag while");
				System.out.println("the others are flagged as true. When a player chooses a pump, the program will check to see if");
				System.out.println("the pump is flagged false. If so, the player is eliminated and the pumps reset, get flagged");
				System.out.println("randomly and the game resumes, with the next player in queue now going. This process will");
				System.out.println("continue until there are two players remaining, with three pumps. If an entire turn goes by");
				System.out.println("and nobody is eliminated, the amount of pumps will not be reduced by one. The game ends once one");	
				System.out.println("of the players picks the bad pump and is eliminated, thus crowning the last player victorious!");
				try
				{
					Thread.sleep(5000);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				System.out.println("");
				System.out.println("Please pick an option and then hit enter (type 1 for option 1, 2 for option 2, etc)");
				System.out.println("");
				System.out.println("Option 1 - Play Game");
				System.out.println("Option 2 - Learn More About Game");
				System.out.println("Option 3 - Math/Complexity Behind Game");
				System.out.println("");
				beginningChoice = in.nextInt();
			}
			else
			{
				System.out.println("");
				System.out.println("Please choose a valid option.");
				System.out.println("");
				System.out.println("Option 1 - Play Game");
				System.out.println("Option 2 - Learn More About Game");
				System.out.println("Option 3 - Math/Complexity Behind Game");
				System.out.println("");
				beginningChoice = in.nextInt();
			}
		}
        System.out.println("");
        //We select the amount of players that will play
		System.out.println("First things first, how many players will be playing?");
		System.out.println("(Note: There can only be a max of four players per game)");
		System.out.println("(Note: Any remaining slots will be given to CPUs)");
		while (true)
		{
			System.out.print("Please enter the amount of players that will play: ");
			int numOfPlayers = in.nextInt();
			while (numOfPlayers < 1 || numOfPlayers > 4)
			{
				System.out.print("Please enter a valid number: ");
				numOfPlayers = in.nextInt();
			}
			int confirmSelection = 0;
			switch (numOfPlayers)
			{
				case 1:
					System.out.println("This means there will be " + numOfPlayers + " player and 3 CPUs");
					delayOneSecond();
					System.out.print("Correct? (1 - Yes, 2 - No): ");
					confirmSelection = in.nextInt();
					while (confirmSelection < 1 || confirmSelection > 2)
					{
						System.out.print("please enter a valid response (1 - Yes, 2 - No):");
						confirmSelection = in.nextInt();
					}
					if (confirmSelection == 1)
					{
						BBB1H3CPU.playGame1H3CPU();
					}
					else
					{
						break;
					}
					break;

				case 2:
					System.out.println("This means there will be " + numOfPlayers + " players and 2 CPUs");
					delayOneSecond();
					System.out.print("Correct? (1 - Yes, 2 - No): ");
					confirmSelection = in.nextInt();
					while (confirmSelection < 1 || confirmSelection > 2)
					{
						System.out.print("please enter a valid response (1 - Yes, 2 - No):");
						confirmSelection = in.nextInt();
					}
					if (confirmSelection == 1)
					{
						BBB2H2CPU.playGame2H2CPU();
					}
					else
					{
						break;
					}
					break;

				case 3:
					System.out.println("This means there will be " + numOfPlayers + " players and 1 CPU");
					delayOneSecond();
					System.out.print("Correct? (1 - Yes, 2 - No): ");
					confirmSelection = in.nextInt();
					while (confirmSelection < 1 || confirmSelection > 2)
					{
						System.out.print("please enter a valid response (1 - Yes, 2 - No):");
						confirmSelection = in.nextInt();
					}
					if (confirmSelection == 1)
					{
						BBB3H1CPU.playGame3H1CPU();
					}
					else
					{
						break;
					}
					break;

				case 4:
					System.out.println("This means there will be " + numOfPlayers + " players and 0 CPUs");
					delayOneSecond();
					System.out.print("Correct? (1 - Yes, 2 - No): ");
					confirmSelection = in.nextInt();
					while (confirmSelection < 1 || confirmSelection > 2)
					{
						System.out.print("please enter a valid response (1 - Yes, 2 - No):");
						confirmSelection = in.nextInt();
					}
					if (confirmSelection == 1)
					{
						BBB4H0CPU.playGame4H0CPU();
					}
					else
					{
						break;
					}
					break;

				default:
					//Should never reach this case
					break;
			}
			break;
		}
	}
    
    //Adds time effect, for visual purposes only
	public static void delayOneSecond()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	//CURRENTLY UNUSED
	//Checks to see if you entered a valid amount of players
	public int checkValidSelecion(int isItValid)
	{
		while (isItValid < 1 || isItValid > 4)
		{
			System.out.print("This is an invalid choice, please select a correct choice: ");
			isItValid = in.nextInt();
			if (isItValid >= 1 && isItValid <= 4)
			{
				System.out.println("This means there will be " + isItValid + " human player(s) and " + (4 - isItValid) + " CPU(s)");
				delayOneSecond();
				System.out.print("Correct? (1 - Yes, 2 - No): ");
				int confirmSelection = in.nextInt();
				while (confirmSelection != 1 || confirmSelection != 2)
				{
					System.out.print("Please enter a valid number! (1 - Yes, 2 - No): ");
					confirmSelection = in.nextInt();
				}
				if (confirmSelection == 1)
				{
					break;
				}
				else
				{
					System.out.print("Please enter the number of players that will play: ");
					isItValid = in.nextInt();
				}
			}
			else
			{
				//User entered invalid number
				continue;
			}
		}
		return isItValid;
	}
}