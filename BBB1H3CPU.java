import java.util.Scanner;
import java.util.Random;

//This is the file that will initiate the game when only one human player is playing, the rest are CPUs
public class BBB1H3CPU
{
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();
    public static void playGame1H3CPU()
    {
        //This array contains the names of the playable characters from Mario Party 2
        String CPUNames[] = {"Mario", "Luigi", "Peach", "Yoshi", "Wario", "Donkey Kong"};
        //The following array will contain the names of the player and the CPU chosen for the game
        String namesOfPlayers[] = new String[4];
        //The following array will contain the order of which players will take their turn
        String orderedNamesOfPlayers[] = new String[4];
        //The following array will contain the pumps that will be used for the entire game
        String pumps[] = {"Red","Pink","Yellow","Green","White"};
        System.out.println("Let's play Bowser's Big Blast!");
        BowsersBigBlast.delayOneSecond();
        System.out.println("Each player will take turns pushing down pumps, in hopes they don't push down a");
        System.out.println("bad pump that will cause the huge Bowser head to explode, thus eliminating them.");
        BowsersBigBlast.delayOneSecond();
        System.out.println("With each time a player is eliminated, the number of pumps will go down by one.");
        System.out.println("This keeps going until there are three pumps and two players left!");
        BowsersBigBlast.delayOneSecond();
        System.out.println("Remember, the objective of the game is to be the last remaining player! Good luck!");
        BowsersBigBlast.delayOneSecond();
        System.out.print("First, please enter your name: ");
        String playerOneName = in.next();
        namesOfPlayers[0] = playerOneName;
        System.out.println("");
        String opponentName = "default";
        System.out.println(playerOneName + ", your opponents will be:");
        int count = 1;
        //This is will pick out the names of the remaining players, at random
        for (int x = 2; x < 5; x++)
        {
            opponentName = pickOpponents(CPUNames);
            System.out.println("Player " + x + ": " + opponentName);
            namesOfPlayers[count] = opponentName;
            count++;
            BowsersBigBlast.delayOneSecond();
        }
        System.out.println("Now we will choose the order in which the players will go. This will be chosen randomly.");
        //This method call will determine the order of the four players to start the game
        orderedNamesOfPlayers = determineOrderofPlayers(namesOfPlayers);
        BowsersBigBlast.delayOneSecond();
        System.out.println("Ready to begin?");
        System.out.println("(press enter to continue)");
        in.nextLine();
        System.out.println(playerOneName + ", " + namesOfPlayers[1] + ", " + namesOfPlayers[2] + ", and " + namesOfPlayers[3] + " step into a large room");
        System.out.println("They see five pumps and one giant Bowser head behind them. From left to right, they see a");
        System.out.println("red, pink, yellow, white, and green pump. " + orderedNamesOfPlayers[1] + " runs towards the");
        System.out.println("pumps and looks around as the other players get in line.");
        BowsersBigBlast.delayOneSecond();
    }

    //This will pick the names of the opponents from a set list in an array, at random
    public static String pickOpponents(String[] CPUNames)
    {
        String opponentName = "default";
        int select = rand.nextInt(5) + 1;
        opponentName = CPUNames[select];
        CPUNames[select] = "null";
        while (true)
        {
            if (opponentName == "null")
            {
                select = rand.nextInt(5) + 1;
                opponentName = CPUNames[select];
                CPUNames[select] = "null";
            }
            else
            {
                break;
            }
        }
        return opponentName;
    }

    //This method will randomly select the order the four players in the game
    public static String[] determineOrderofPlayers(String[] unsortedArr)
    {
        String[] sortedArr = new String[4];
        //Visual effect
        System.out.print("Generating order of players.");
        for (int x = 0; x < 4; x++)
        {
            if (x == 3)
            {
                System.out.println(".");
            }
            else
            {
                System.out.print(".");
            }
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("");
        int temp;
        for (int y = 1; y <= 4; y++)
        {
            //This creates a variable with getting a random number between 0 and 4 (exclusive)
            temp = rand.nextInt(3) + 1;
            //This assigns the first empty spot in the sorted array to the first randomly selected name from the unsorted list
            sortedArr[y] = unsortedArr[temp];
            //Since that name was already picked, we will null out that entry to prevent repeats when we cycle again
            unsortedArr[temp] = null;
            //This if statement ensures that the next check for non-null names will happen on the second cycle
            if (y > 1)
            {
                //This while statement will continue cycling until it picks out a non-null name from the unsorted list to be used
                while (sortedArr[y] == null)
                {
                    temp = rand.nextInt(3) + 1;
                    sortedArr[y] = unsortedArr[temp];
                    unsortedArr[temp] = null;
                }
            }
        }
        //And now the new list will be printed out to show the user the order of which the players will go
        System.out.println("This is the order in which players will go: ");
        for (int j = 1; j <= 4; j++)
        {
            System.out.println(sortedArr[j]);
            BowsersBigBlast.delayOneSecond();
        }
        return sortedArr;
    }

    //This is where the first round of the game will take place (4 players)
    public static String[] roundOne(String[] fourPlayerGroupUnsorted, String[] pumps)
    {
        //enter code here..
        return pumps;
    }
}