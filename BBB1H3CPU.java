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
        System.out.println("red, pink, yellow, white, and green pump. " + orderedNamesOfPlayers[0] + " runs towards the");
        System.out.println("pumps and looks around as the other players get in line.");
        BowsersBigBlast.delayOneSecond();
    }

    //This will pick the names of the opponents from a set list in an array, at random
    public static String pickOpponents(String[] CPUNames)
    {
        String opponentName = "default";
        int select = rand.nextInt(6) + 1;
        select--; //to get a random number from 0 to 5, to use with array
        opponentName = CPUNames[select];
        CPUNames[select] = "null";
        while (true)
        {
            if (opponentName == "null")
            {
                select = rand.nextInt(6) + 1;
                select--;
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
        //NOTE: CODE HAS MAJOR FAULTS FROM HERE ON OUT, MUST FIGURE OUT ISSUE BEFORE CONTINUING
        for (int y = 0; y < 4; y++)
        {
            //This creates a variable with getting a random number between 1 and 4 (inclusive)
            temp = rand.nextInt(4) + 1;
            //temp--;
            System.out.println("test temp = " + temp);
            //This assigns the first empty spot in the sorted array to the first randomly selected name from the unsorted list
            sortedArr[y] = unsortedArr[temp];
            System.out.println("first player in sorted array is " + sortedArr[y]);
            //Since that name was already picked, we will null out that entry to prevent repeats when we cycle again
            unsortedArr[temp] = null;
            System.out.println("test 1 cleared, y = " + y);
            //This if statement ensures that the next check for non-null names will happen on the second cycle
            if (y > 0)
            {
                //This while statement will continue cycling until it picks out a non-null name from the unsorted list to be used
                System.out.println("test 2 cleared, y = " + y);
                while (sortedArr[y] == null)
                {
                    temp = rand.nextInt(4) + 1;
                    //temp--;
                    sortedArr[y] = unsortedArr[temp];
                    unsortedArr[temp] = null;
                    System.out.println("test 3 cleared, temp = " + temp);
                    System.out.println("player " + (y+1) + " is " + sortedArr[y]);
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
    public static String[] roundOne(String[] fourPlayerGroupUnsorted, String[] pumpsR1)
    {
        String[] fourPlayerGroupSorted = new String[3];
        int temp = 0;
        int myPick;
        boolean flag = true;
        int badPump = rand.nextInt(4) + 1;
        while (flag = true)
        {
            System.out.println(fourPlayerGroupUnsorted[temp] + ", which pump will you choose?");
            for (int x = 0; x < 5; x++)
            {
                System.out.println((x + 1) + " = " + pumpsR1[x] + " pump");
            }
            System.out.print("Enter the number of the pump of your choice: ");
            myPick = in.nextInt();
            if (myPick >= 1 && myPick < 6)
            {
                while(pumpsR1[myPick] == null)
                {
                    System.out.println("");
                    System.out.print(fourPlayerGroupUnsorted[temp] + ", this pump has already been pushed down. Choose another unused one: ");
                    myPick = in.nextInt();
                    while (myPick > 5 || myPick < 1)
                    {
                        System.out.println("");
                        System.out.print(fourPlayerGroupUnsorted[temp] + ", please choose a valid number to enter: ");
                        myPick = in.nextInt();
                    }
                }
                pumpsR1[myPick] = null;
                flag = Check(myPick, badPump, fourPlayerGroupUnsorted, temp);
                if (flag == true)
                {
                    temp++;
                }
            }
            else
            {
                System.out.println("");
                System.out.println("(Please choose a valid number to enter)");
                System.out.println("");
            }
            if (temp > 4)
            {
                temp = 1;
                badPump = rand.nextInt(4) + 1;
                pumpsR1[0] = "Red";
                pumpsR1[1] = "Pink";
                pumpsR1[2] = "Yellow";
                pumpsR1[3] = "Green";
                pumpsR1[4] = "White";
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println("The pumps have reset");
                System.out.println("");
                //System.out.println("new badLever is " + badLever);
            }
        }
        return fourPlayerGroupSorted;
    }

    //This is where a check is made between the player's choice of a pump and the "bad" pump that was randomly selected
    public static Boolean Check(int myPickR, int badLeverR, String[] playerName, int playerNumber)
    {
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
        if (myPickR != badLeverR)
        {
            System.out.println("");
            System.out.println("Safe!");
            System.out.println("");
            return true;
        }
        else
        {
            int counter = 3;
            for (int x = 0; x < 4; x++)
            {
                if (x != 3)
                {
                    System.out.println("");
                    System.out.println(counter);
                    System.out.println("");
                    counter--;
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                else
                {
                    System.out.println("BOOM!");
                    System.out.println("");
                    System.out.println(playerName[playerNumber] + " has been eliminated.");
                    System.out.println("");
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
            return false;
        }
    }
}