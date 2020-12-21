import java.util.Scanner;
import java.util.Random;

//This is the file that will initiate the game when only one human player is playing, the rest are CPUs
public class BBB1H3CPU
{
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();
    //The following array will contain the pumps that will be used for the entire game
    public static String pumps[] = {"Red","Pink","Yellow","Green","White"};
    //The following array will contain the pumps that will be used for the entire game
    public static String pumpsR2[] = {"Pink","Yellow","Green","White"};
    //The following array will contain the pumps that will be used for the entire game
    public static String pumpsR3[] = {"Pink","Yellow","Green"};
    //The following array will contain the pumps that will be used for the entire game
    public static String pumpsF[] = {"Red","Pink","Yellow","Green","White"};
    //This array contains the names of the playable characters from Mario Party 2, will be used for entire game
    public static String CPUNames[] = {"Mario", "Luigi", "Peach", "Yoshi", "Wario", "Donkey Kong"};
    //Name will be used for a check to determine if a CPU must make a choice or if a player must enter an input
    public static String playerOneName;
    public static void playGame1H3CPU()
    {
        //The following array will contain the names of the player and the CPU chosen for the game
        String namesOfPlayers[] = new String[4];
        //The following array will contain the order of which players will take their turn
        String orderedNamesOfPlayers[] = new String[4];
        System.out.println("");
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
        System.out.println("");
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
            opponentName = pickOpponents(CPUNames, playerOneName);
            System.out.println("Player " + x + ": " + opponentName);
            namesOfPlayers[count] = opponentName;
            count++;
            BowsersBigBlast.delayOneSecond();
        }
        System.out.println("");
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
        String[] sortedAfterRoundOne = new String[3];
        sortedAfterRoundOne = roundOne(orderedNamesOfPlayers, pumps);
        String[] sortedAfterRoundTwo = new String[2];
        sortedAfterRoundTwo = roundTwo(sortedAfterRoundOne, pumpsR2);
        roundThree(sortedAfterRoundTwo, pumpsR3);
        BowsersBigBlast.delayOneSecond();
        
    }

    //This will pick the names of the opponents from a set list in an array, at random
    public static String pickOpponents(String[] CPUNames, String playerOnesName)
    {
        String opponentName = "default";
        int select = rand.nextInt(6);
        opponentName = CPUNames[select];
        //This while loop will ensure a name is chosen that will NOT be null, thus letting it get compared to the human player name without an exception
        while (true)
        {
            //This is to ensure the human player of the game doesn't create a "duplicate" opponent with the same name
            if (opponentName == null)
            {
                select = rand.nextInt(6);
                opponentName = CPUNames[select];
            }
            else
            {
                break;
            }
        }
        if (opponentName.equals(playerOnesName))
        {
            //This will null out the duplicate name so that it is no longer going to be under consideration for being picked as a random opponent
            CPUNames[select] = null;
            opponentName = CPUNames[select];
            //This while loop will ensure a name is chosen that will NOT be null, thus letting it get compared to the human player name without an exception
            while (true)
            {
                //This is to ensure the human player of the game doesn't create a "duplicate" opponent with the same name
                if (opponentName == null)
                {
                    select = rand.nextInt(6);
                    opponentName = CPUNames[select];
                }
                else
                {
                    break;
                }
            }
        }
        CPUNames[select] = null;
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
        //This variable will indicate what round number it is so when an opponent makes a guess, they won't pick an invalid option
        int roundNum = 1;
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
                if (pumpsR1[x] == null)
                {
                    System.out.println("The " + pumpsF[x] + " pump has already been pushed down!");
                }
                else
                {
                    System.out.println((x + 1) + " = " + pumpsF[x] + " pump");
                }
            }
            System.out.print("Enter the number of the pump of your choice: ");
            if (fourPlayerGroupUnsorted[temp].equals(playerOneName))
            {
                myPick = in.nextInt();
            }
            else
            {
                myPick = opponentGuess(pumpsR1, roundNum);
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
                temp = 0;
                badPump = rand.nextInt(5);
                pumpsR1[0] = "Red";
                pumpsR1[1] = "Pink";
                pumpsR1[2] = "Yellow";
                pumpsR1[3] = "Green";
                pumpsR1[4] = "White";
                BowsersBigBlast.delayOneSecond();
                System.out.println("The pumps have reset");
                System.out.println("");
                //This line was used for checking purposes
                //System.out.println("The rigged pump is the " + badPump + " pump");
            }
        }
        //This ensures the order remains consistent to the next round, other the first player would have an advantage the whole game
        switch (temp)
        {
            case 0:
                fourPlayerGroupSorted[0] = fourPlayerGroupUnsorted[1];
                fourPlayerGroupSorted[1] = fourPlayerGroupUnsorted[2];
                fourPlayerGroupSorted[2] = fourPlayerGroupUnsorted[3];
                break;

            case 1:
                fourPlayerGroupSorted[0] = fourPlayerGroupUnsorted[2];
                fourPlayerGroupSorted[1] = fourPlayerGroupUnsorted[3];
                fourPlayerGroupSorted[2] = fourPlayerGroupUnsorted[0];
                break;

            case 2:
                fourPlayerGroupSorted[0] = fourPlayerGroupUnsorted[3];
                fourPlayerGroupSorted[1] = fourPlayerGroupUnsorted[0];
                fourPlayerGroupSorted[2] = fourPlayerGroupUnsorted[1];
                break;

            case 3:
                fourPlayerGroupSorted[0] = fourPlayerGroupUnsorted[0];
                fourPlayerGroupSorted[1] = fourPlayerGroupUnsorted[1];
                fourPlayerGroupSorted[2] = fourPlayerGroupUnsorted[2];
                break;

            default:
                System.out.println("ERROR.");
                break;
        }
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        System.out.println(fourPlayerGroupSorted[0] + ", " + fourPlayerGroupSorted[1] + ", and " + fourPlayerGroupSorted[2] + " look at disbelief as");
        System.out.println(fourPlayerGroupUnsorted[temp] + " was blown up by the Bowser head, sending them flying out of the room!");
        System.out.println("A large crane brings another Bowser head and screws it into place where the previous one was. The pumps");
        System.out.println("also reset, with the exception of the red pump, which has now disappeared, leaving only four options now.");
        System.out.println("The game continues as " + fourPlayerGroupSorted[0] + " steps up again ");
        System.out.println("");
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        //Losing player is nulled out and will not be included into the next round
        fourPlayerGroupUnsorted[temp] = null;
        return fourPlayerGroupSorted;
    }

    //This is where the second round of the game will take place (3 players)
    public static String[] roundTwo(String[] threePlayerGroupUnsorted, String[] pumpsR2)
    {
        String[] threePlayerGroupSorted = new String[2];
        pumpsF[0] = "Pink";
        pumpsF[1] = "Yellow";
        pumpsF[2] = "Green";
        pumpsF[3] = "White";
        int roundNum = 2;
        int temp = 0;
        int myPick = 0;
        boolean flag = true;
        //Will randomly generate the bad pump to be used to eliminate a player
        int badPump = rand.nextInt(4);
        while (flag == true)
        {
            System.out.println(threePlayerGroupUnsorted[temp] + ", which pump will you choose?");
            int x;
            for (x = 0; x < 4; x++)
            {
                if (pumpsR2[x] == null)
                {
                    System.out.println("The " + pumpsF[x] + " pump has already been pushed down!");
                }
                else
                {
                    System.out.println((x + 2) + " = " + pumpsF[x] + " pump");
                }
            }
            System.out.print("Enter the number of the pump of your choice: ");
            if (threePlayerGroupUnsorted[temp].equals(playerOneName))
            {
                myPick = in.nextInt();
            }
            else
            {
                myPick = opponentGuess(pumpsR2, roundNum);
                BowsersBigBlast.delayOneSecond();
                System.out.println(myPick);
            }
            if (myPick >= 2 && myPick < 6)
            {
                myPick = myPick - 2;
                while(pumpsR2[myPick] == null)
                {
                    System.out.println("");
                    System.out.print(threePlayerGroupUnsorted[temp] + ", this pump has already been pushed down. Choose another unused one: ");
                    myPick = in.nextInt();
                    myPick = myPick - 2;
                    while (myPick > 5 || myPick < 2)
                    {
                        System.out.println("");
                        System.out.print(threePlayerGroupUnsorted[temp] + ", please choose a valid number to enter: ");
                        myPick = in.nextInt();
                        myPick = myPick - 2;
                    }
                }
                pumpsR2[myPick] = null;
                flag = Check(myPick, badPump, threePlayerGroupUnsorted, temp);
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
            if (temp > 2)
            {
                temp = 0;
                badPump = rand.nextInt(4);
                pumpsR2[0] = "Pink";
                pumpsR2[1] = "Yellow";
                pumpsR2[2] = "Green";
                pumpsR2[3] = "White";
                BowsersBigBlast.delayOneSecond();
                System.out.println("The pumps have reset");
                System.out.println("");
                //This line was used for checking purposes
                //System.out.println("The rigged pump is the " + badPump + " pump");
            }
        }
        switch (temp)
        {
            case 0:
                threePlayerGroupSorted[0] = threePlayerGroupUnsorted[1];
                threePlayerGroupSorted[1] = threePlayerGroupUnsorted[2];
                break;

            case 1:
                threePlayerGroupSorted[0] = threePlayerGroupUnsorted[2];
                threePlayerGroupSorted[1] = threePlayerGroupUnsorted[0];
                break;

            case 2:
                threePlayerGroupSorted[0] = threePlayerGroupUnsorted[0];
                threePlayerGroupSorted[1] = threePlayerGroupUnsorted[1];
                break;

            default:
                System.out.println("ERROR.");
                break;
        }
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        System.out.println(threePlayerGroupSorted[0] + " and " + threePlayerGroupSorted[1] + " look in disbelief as " + threePlayerGroupUnsorted[temp]);
        System.out.println("was blown up by the Bowser head, sending them flying out of the room!");
        System.out.println("A large crane brings another Bowser head and screws it into place where the previous one was. The pumps");
        System.out.println("also reset, with the exception of the red and white pump, which have now disappeared, leaving only three options now.");
        System.out.println("The game continues as " + threePlayerGroupSorted[0] + " steps up again, now in the final round.");
        System.out.println("");
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        //Losing player is nulled out and will not be included into the next round
        threePlayerGroupUnsorted[temp] = null;
        return threePlayerGroupSorted;
    }

    //This is where the third round of the game will take place
    public static void roundThree(String[] twoPlayersRemain, String[] pumpsR3)
    {
        pumpsF[0] = "Pink";
        pumpsF[1] = "Yellow";
        pumpsF[2] = "Green";
        int roundNum = 3;
        int temp = 0;
        int myPick = 0;
        boolean flag = true;
        //Will randomly generate the bad pump to be used to eliminate a player
        int badPump = rand.nextInt(3);
        while (flag == true)
        {
            System.out.println(twoPlayersRemain[temp] + ", which pump will you choose?");
            int x;
            for (x = 0; x < 3; x++)
            {
                if (pumpsR3[x] == null)
                {
                    System.out.println("The " + pumpsF[x] + " pump has already been pushed down!");
                }
                else
                {
                    System.out.println((x + 2) + " = " + pumpsF[x] + " pump");
                }
            }
            System.out.print("Enter the number of the pump of your choice: ");
            if (twoPlayersRemain[temp].equals(playerOneName))
            {
                myPick = in.nextInt();
            }
            else
            {
                myPick = opponentGuess(pumpsR3, roundNum);
                BowsersBigBlast.delayOneSecond();
                System.out.println(myPick);
            }
            if (myPick >= 2 && myPick < 6)
            {
                myPick = myPick - 2;
                while(pumpsR3[myPick] == null)
                {
                    System.out.println("");
                    System.out.print(twoPlayersRemain[temp] + ", this pump has already been pushed down. Choose another unused one: ");
                    myPick = in.nextInt();
                    myPick = myPick - 2;
                    while (myPick > 5 || myPick < 2)
                    {
                        System.out.println("");
                        System.out.print(twoPlayersRemain[temp] + ", please choose a valid number to enter: ");
                        myPick = in.nextInt();
                        myPick = myPick - 2;
                    }
                }
                pumpsR3[myPick] = null;
                flag = Check(myPick, badPump, twoPlayersRemain, temp);
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
            if (temp > 1)
            {
                temp = 0;
                badPump = rand.nextInt(3);
                pumpsR3[0] = "Pink";
                pumpsR3[1] = "Yellow";
                pumpsR3[2] = "Green";
                BowsersBigBlast.delayOneSecond();
                System.out.println("The pumps have reset");
                System.out.println("");
                //This line was used for checking purposes
                //System.out.println("The rigged pump is the " + badPump + " pump");
            }
        }
        String winner = "default";
        switch (temp)
        {
            case 0:
                winner = twoPlayersRemain[1];
                break;

            case 1:
                winner = twoPlayersRemain[0];
                break;

            default:
                System.out.println("You shouldn't get this message - ERROR");
                break;
        }
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        System.out.println("As the last Bowser head explodes and sends " + twoPlayersRemain[temp] + " flying,");
        System.out.println(winner + " breathes a sigh of relief as they are the last player standing.");
        BowsersBigBlast.delayOneSecond();
        BowsersBigBlast.delayOneSecond();
        System.out.println("Congratulations to " + winner + " for beating Bowser's Big Blast!!!");
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
            BowsersBigBlast.delayOneSecond();
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
                    BowsersBigBlast.delayOneSecond();
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
    public static int opponentGuess(String[] pumpsRx, int roundNum)
    {
        int opponentsGuess = 0;
        switch(roundNum)
        {
            case 1:
                //In the event the opponent picks a pump that has already been pushed down, it will simply pick another
                opponentsGuess = rand.nextInt(5);
                while(pumpsRx[opponentsGuess] == null)
                {
                    opponentsGuess = rand.nextInt(5);
                }
                return (opponentsGuess + 1);

            case 2:
                opponentsGuess = rand.nextInt(4);
                while(pumpsRx[opponentsGuess] == null)
                {
                    opponentsGuess = rand.nextInt(4);
                }
                return (opponentsGuess + 2);

            case 3:
                opponentsGuess = rand.nextInt(3);
                while(pumpsRx[opponentsGuess] == null)
                {
                    opponentsGuess = rand.nextInt(3);
                }
                return (opponentsGuess + 2);
            
            default:
                //Should never reach this case
                return opponentsGuess;
        }
        //We add one/two because when we display the number to the user, it must match with the key that has the pumps
    }
}