import javax.swing.JOptionPane;

public class RPS
{
	public static void main(String[] args)
	{
		String player = "";
		int computer;
		String message = "";
		String instructions = "Type one of the following: \nRock \nPaper \nScissors";
		String compPick;
		final int LOW = 1;
		final int HIGH = 3;
		final int NUM_GAMES = 10;
		int gameCount = 0;
		int playerWins = 0;
		int compWins = 0;
		int tieGames = 0;
		
		// loop that test how many games have been played, stooping after 10
		while(gameCount < NUM_GAMES)
		{
			player = "";
			message = "";
			
			// computers randomly generated selection
			computer = LOW + (int)(Math.random() * HIGH);
			
			while(!player.equalsIgnoreCase("Rock") && !player.equalsIgnoreCase("Paper") && !player.equalsIgnoreCase("Scissors"))
			{	
				player = JOptionPane.showInputDialog(null, instructions);
				player = player.toLowerCase();
				
				if(player.startsWith("ro"))
					player = "ROCK";
				else
					if(player.startsWith("pa"))
						player = "PAPER";
				else
					if(player.startsWith("Sc"))
						player = "SCISSORS";
				else
					JOptionPane.showMessageDialog(null, "You must choose ROCK, PAPER or SCISSORS.");
			}	//end of inner while loop
					
			// turn the numeric choice of the computer into a string for output
			if(computer == 1)
				compPick = "ROCK";
			else 
				if(computer == 2)
					compPick = "PAPER";
				else
					compPick = "SCISSORS";
				
			// game mechanics 
			if(player.equals(compPick))
			{
				message = "We have a tie!";
				++tieGames;
			}
			else 
				if(player.equals("ROCK"))
					if(compPick.equals("PAPER"))
					{
						message = "The computer wins..";
						++compWins;
					}
					else 
					{
						message = "You win !!";
						++playerWins;
					}
				else
					if(player.equals("PAPER"))
						if(compPick.equals("SCISSORS"))
						{
							message = "The computer wins..";
							++compWins;
						}
						else 
						{
							message = "You win !!";
							++playerWins;
						}
					else 
						if(compPick.equals("ROCK"))
						{
							message = "The computer wins..";
							++compWins;
						}
						else
						{
							message = "You win !!";
							++playerWins;
						}
						++gameCount;
					// output message dialog box displaying the results of one game
					JOptionPane.showMessageDialog(null, "You chose " + player + "\nThe computer picked " + compPick + "\nResult: " + message + "\nYou have played " + gameCount + " games so far.");
						
		} // end of first while loop
	
		// output message dialog box displaying the total results
		JOptionPane.showMessageDialog(null, "End of games!! \nYou won " + playerWins + " game(s) \nComputer won " + compWins + " game(s) \nThere were " + tieGames + " tie games. \nThank you for playing!!");
	}
}