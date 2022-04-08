package generic;

import java.io.PrintWriter;

public class Statistics {
	
	// TODO add your statistics here
	static int numberOfInstructions;
	static int numberOfCycles;
	static int noOfRWStageInstruction,noOfBranchesTaken,noOFStageInstruction,noOfOFStagesStalled;

	public static void printStatistics(String statFile)
	{
		try
		{
			PrintWriter writer = new PrintWriter(statFile);
			
			noOfOFStagesStalled = numberOfInstructions - noOfRWStageInstruction;

			writer.println("Number of instructions executed = " + numberOfInstructions);
			writer.println("Number of cycles taken = " + numberOfCycles);
			writer.println("Number of OF_Stages Stalled = " + noOfOFStagesStalled);
			writer.println("Number of Wrong Branches Instruction = " + noOfBranchesTaken);
			
			// TODO add code here to print statistics in the output file
			
			writer.close();
		}
		catch(Exception e)
		{
			Misc.printErrorAndExit(e.getMessage());
		}
	}
	
	// TODO write functions to update statistics
	public void setNumberOfInstructions(int numberOfInstructions) {
		Statistics.numberOfInstructions = numberOfInstructions;
	}

	public void setNumberOfCycles(int numberOfCycles) {
		Statistics.numberOfCycles = numberOfCycles;
	}

	public static int getNumberOfCycles()
	{
		return numberOfCycles;
	}

	public static int getNumberOfInstructions() 
	{
		return numberOfInstructions;	
	}

	public void setNumberOfOFStageInstructions(int numberOfInstructions) 
	{
		Statistics.noOFStageInstruction = numberOfInstructions;
	}

	public void setNumberOfBranchesTaken(int numberOfBranches) 
	{
		Statistics.noOfBranchesTaken = numberOfBranches;
	}

	public void setNumberOfRWStageInstructions(int numberOfInstructions) 
	{
		Statistics.noOfRWStageInstruction = numberOfInstructions;
	}

	public static int noOFStageInstruction()
	{
		return noOFStageInstruction;
	}

	public static int noOfBranchesTaken() 
	{
		return noOfBranchesTaken;	
	}

	public static int getNumberOfRWStageInstructions()
	{
		return noOfRWStageInstruction;
	}
	
}
