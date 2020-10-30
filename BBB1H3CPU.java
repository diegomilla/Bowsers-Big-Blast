import java.util.Scanner;
import java.util.Random;

//This is the file that will initiate the game when only one human player is playing, the rest are CPUs
public class BBB1H3CPU
{
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();
    public static void playGame1H3CPU()
    {
        String CPUNames[] = {"Mario", "Luigi", "Peach", "Yoshi", "Wario", "Donkey Kong"};
        System.out.println("Let's play Bowser's Big Blast!");
        BowsersBigBlast.delayOneSecond();
        System.out.print("First, please enter your name: ");
        String playerOneName = in.next();
        System.out.println("");
        String opponentName = "default";
        System.out.println(playerOneName + ", your opponents will be:");
        for (int x = 2; x < 5; x++)
        {
            opponentName = pickOpponents(CPUNames);
            System.out.println("Player " + x + ": " + opponentName);
        }
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
}