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
        System.out.println("Let's play Bowser's Big Blast!");
        BowsersBigBlast.delayOneSecond();
        System.out.print("First, please enter your name: ");
        String playerOneName = in.next();
        namesOfPlayers[0] = playerOneName;
        System.out.println("");
        String opponentName = "default";
        System.out.println(playerOneName + ", your opponents will be:");
        int count = 1;
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
        System.out.println("red, pink, yellow, white, and green pump. ");
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
        return sortedArr;
    }
}