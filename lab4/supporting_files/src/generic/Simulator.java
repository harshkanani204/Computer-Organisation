package generic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import processor.Clock;
import processor.Processor;

public class Simulator {
		
	static Processor processor;
	static boolean simulationComplete;
	
	public static void setupSimulation(String assemblyProgramFile, Processor p)
	{
		Simulator.processor = p;
		loadProgram(assemblyProgramFile);
		
		simulationComplete = false;
	}
	
	static void loadProgram(String assemblyProgramFile)
	{
		/*
		 * TODO
		 * 1. load the program into memory according to the program layout described
		 *    in the ISA specification
		 * 2. set PC to the address of the first instruction in the main
		 * 3. set the following registers:
		 *     x0 = 0
		 *     x1 = 65535
		 *     x2 = 65535
		 */

		try {
			
				System.out.println(assemblyProgramFile);
				BufferedInputStream bufferistream = new BufferedInputStream(new FileInputStream(assemblyProgramFile));
				int pcValue,readingLine,noLineAssemblyFile,data,code;

				readingLine = 0;
				pcValue = 0;
				data = -1;
				code = data + 1;
				byte[] tempInstruction = new byte[4];
				noLineAssemblyFile = bufferistream.read(tempInstruction,0,4);

				if(noLineAssemblyFile != -1)
				{
					pcValue = ByteBuffer.wrap(tempInstruction).getInt();
					processor.getRegisterFile().setProgramCounter(pcValue);
				}

				while(1>0)
				{
					if (readingLine > pcValue - 1) 
					{
						break;	
					}

					noLineAssemblyFile = bufferistream.read(tempInstruction,0,4);
					data++;
					code = data;
					readingLine = readingLine + 1;

					int n = ByteBuffer.wrap(tempInstruction).getInt();
					processor.getMainMemory().setWord(data, n);
				}

				noLineAssemblyFile = bufferistream.read(tempInstruction,0,4);
				while(1>0)
				{
					if(noLineAssemblyFile == -1)
					{
						break;
					}

					readingLine++;
					code++;

					int k;
					k = ByteBuffer.wrap(tempInstruction).getInt();
					processor.getMainMemory().setWord(code, k);
					noLineAssemblyFile = bufferistream.read(tempInstruction,0,4);
				}

			int r0 = 0; 
			int r1 = 1;
			int r2 = 2;
			int value;
			value = (int)Math.pow(2,16);
			value = value - 1;
			processor.getRegisterFile().setValue(r0, 0);
			processor.getRegisterFile().setValue(r1, value);
			processor.getRegisterFile().setValue(r2, value);


		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public static void simulate()
	{
		Statistics x;
		x = new Statistics();
		x.setNumberOfCycles(0);
		x.setNumberOfInstructions(0);

		while(simulationComplete != true)
		{
			processor.getIFUnit().performIF();
			//Clock.incrementClock();
			processor.getOFUnit().performOF();
			//Clock.incrementClock();
			processor.getEXUnit().performEX();
			//Clock.incrementClock();
			processor.getMAUnit().performMA();
			//Clock.incrementClock();
			processor.getRWUnit().performRW();
			Clock.incrementClock();

			int noIns,noCycle;
			noIns = x.getNumberOfInstructions() + 1; 
			noCycle = x.getNumberOfCycles() + 1;
			x.setNumberOfCycles(noCycle);
			x.setNumberOfInstructions(noIns);
		}
	}
	
	public static void setSimulationComplete(boolean value)
	{
		simulationComplete = value;
	}
}
