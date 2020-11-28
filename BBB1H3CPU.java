import java.util.Scanner;
import java.util.Random;

//KEEP IN MIND THIS PROGRAM IS TO BE USED FOR WHEN THERE ARE FOUR HUMAN PLAYERS, MUST MODIFY CODE TO MAKE CPU GUESS

//This is the file that will initiate the game when only one human player is playing, the rest are CPUs
public class BBB1H3CPU
{
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();
    //The following array will contain the pumps that will be used for the entire game
    public static String pumps[] = {"Red","Pink","Yellow","Green","White"};
    //Name will be used for a check to determine if a CPU must make a choice or if a player must enter an input
    public static String playerOneName;
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
        System.out.println("Each player will take turns pushing down pumps, in hopes they don't push down a");
        System.out.println("bad pump that will cause the huge Bowser head to explode, thus eliminating them.");
        BowsersBigBlast.delayOneSecond();
        System.out.println("With each time a player is eliminated, the number of pumps will go down by one.");
        System.out.println("This keeps going until there are three pumps and two players left!");
        BowsersBigBlast.delayOneSecond();
        System.out.println("Remember, the objective of the game is to be the last remaining player! Good luck!");
        BowsersBigBlast.delayOneSecond();
        System.out.print("First, please enter your name: ");
        playerOneName = in.next();
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
        System.out.println("");
        System.out.println("Ready to begin?");
        System.out.println("(press enter to continue)");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {
            System.out.println("FATAL ERROR.");
        }
        System.out.println("");
        System.out.println(orderedNamesOfPlayers[0] + ", " + orderedNamesOfPlayers[1] + ", " + orderedNamesOfPlayers[2] + ", and " + orderedNamesOfPlayers[3] + " step into a large room");
        System.out.println("They see five pumps and one giant Bowser head behind them. From left to right, they see a");
        System.out.println("red, pink, yellow, white, and green pump. " + orderedNamesOfPlayers[0] + " runs towards the");
        System.out.println("pumps and looks around as the other players get in line.");
        System.out.println("");
        String[] sortedAfterRoundOne = new String[4];
        sortedAfterRoundOne = roundOne(orderedNamesOfPlayers, pumps);
        BowsersBigBlast.delayOneSecond();
    }

    //This will pick the names of the opponents from a set list in an array, at random
    public static String pickOpponents(String[] CPUNames)
    {
        String opponentName = "default";
        int select = rand.nextInt(6);
        opponentName = CPUNames[select];
        while (true)
        {
            //This is to ensure the human player of the game doesn't create a "duplicate" opponent with the same name
            if (opponentName == playerOneName)
            {
                //This will null out the duplicate name so that it is no longer going to be under consideration for being picked as a random opponent
                CPUNames[select] = "null";
                select = rand.nextInt(6);
                opponentName = CPUNames[select];
            }
            else
            {
                break;
            }
        }
        CPUNames[select] = "null";
        //past code here
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
        for (int y = 0; y < 4; y++)
        {
            //This creates a variable with getting a random number, either 0, 1, 2, or 3
            temp = rand.nextInt(4);
            //This assigns the first empty spot in the sorted array to the first randomly selected name from the unsorted list
            sortedArr[y] = unsortedArr[temp];
            //Since that name was already picked, we will null out that entry to prevent repeats when we cycle again
            unsortedArr[temp] = null;
            //This if statement ensures that the next check for non-null names will happen on the second cycle
            if (y > 0)
            {
                //This while statement will continue cycling until it picks out a non-null name from the unsorted list to be used
                while (sortedArr[y] == null)
                {
                    //Generate another random number since it picked out a nulled out value
                    temp = rand.nextInt(4);
                    sortedArr[y] = unsortedArr[temp];
                    unsortedArr[temp] = null;
                }
            }
        }
        //And now the new list will be printed out to show the user the order of which the players will go
        System.out.println("This is the order in which players will go: ");
        for (int j = 0; j < 4; j++)
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
        int myPick = 0;
        boolean flag = true;
        //Will randomly generate the bad pump to be used to eliminate a player
        int badPump = rand.nextInt(5);
        while (flag == true)
        {
            System.out.println(fourPlayerGroupUnsorted[temp] + ", which pump will you choose?");
            int x;
            for (x = 0; x < 5; x++)
            {
                System.out.println((x + 1) + " = " + pumps[x] + " pump");
            }
            System.out.print("Enter the number of the pump of your choice: ");
            if (fourPlayerGroupUnsorted[temp] == playerOneName)
            {
                myPick = in.nextInt();
            }
            else
            {
                myPick = opponentGuess(pumpsR1);
                BowsersBigBlast.delayOneSecond();
                System.out.println(myPick);
            }
            if (myPick >= 1 && myPick < 6)
            {
                myPick--;
                while(pumpsR1[myPick] == null)
                {
                    System.out.println("");
                    System.out.print(fourPlayerGroupUnsorted[temp] + ", this pump has already been pushed down. Choose another unused one: ");
                    myPick = in.nextInt();
                    myPick--;
                    while (myPick > 5 || myPick < 1)
                    {
                        System.out.println("");
                        System.out.print(fourPlayerGroupUnsorted[temp] + ", please choose a valid number to enter: ");
                        myPick = in.nextInt();
                        myPick--;
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
            if (temp > 3)
            {
                temp = 1;
                badPump = rand.nextInt(5);
                pumpsR1[0] = "Red";
                pumpsR1[1] = "Pink";
                pumpsR1[2] = "Yellow";
                pumpsR1[3] = "Green";
                pumpsR1[4] = "White";
                BowsersBigBlast.delayOneSecond();
                System.out.println("The pumps have reset");
                System.out.println("");
                //System.out.println("new badLever is " + badLever);
            }
        }
        //Losing player is nulled out and will not be included into the next round
        fourPlayerGroupUnsorted[temp] = null;
        for (int i = 0; i < 4; i++)
        {
            //add if here to check if value is null or not
            fourPlayerGroupSorted[i] = fourPlayerGroupUnsorted[i];
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

    //This method is where the opponent will guess a number and that will be the pump they push down
    public static int opponentGuess(String[] pumpsR1)
    {
        int opponentsGuess = rand.nextInt(5);
        //In the event the opponent picks a pump that has already been pushed down, it will simply pick another
        while(pumpsR1[opponentsGuess] == null)
        {
            opponentsGuess = rand.nextInt(5);
        }
        //We add one because when we display the number to the user, it must match with the key that has the pumps
        return (opponentsGuess + 1);
    }
}