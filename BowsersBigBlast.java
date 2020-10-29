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
				System.out.println("In Japan in 1999, Mario Party 2 was released for the Nintendo 64.");
				System.out.println("Developed by Hudson Soft and published by Nintendo, this next installment");
				System.out.println("in the Mario Party game series provided a refined and improved version of");
				System.out.println("the original game. Each game consisted of four players moving around a board");
				System.out.println("where the objective was to get as many stars and coins than your opponent. At");
				System.out.println("the end of each player's turn, they all play a mini-game together and the winner");
				System.out.println("recieves coins at the end to use for next turn. There were a plethora of mini-games");
				System.out.println("in Mario Party 2, but one reallys stands out. Subsequently titled the same as this");
				System.out.println("program, Bowser's Big Blast was the mini-game that inspired this program. The premise");
				System.out.println("is four players take turns pushing down pumps, until one remains. With each iteration,");
				System.out.println("the number of pumps and players goes down until two players and three pumps remaining.");
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
		System.out.print("Please enter the amount of players: ");
		int numOfPlayers = in.nextInt();
	}
	
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
}