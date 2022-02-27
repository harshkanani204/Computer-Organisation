package generic;

import java.io.*;
import generic.Operand.OperandType;


public class Simulator
 {
		
	static FileInputStream inputcodeStream = null;

	static String output = null;
	
	public static void setupSimulation(String assemblyProgramFile, String objectProgramFile)
	{	
		output = objectProgramFile;
		int firstCodeAddress = ParsedProgram.parseDataSection(assemblyProgramFile);
		ParsedProgram.parseCodeSection(assemblyProgramFile, firstCodeAddress);
		ParsedProgram.printState();
	}
	public static Integer type(Instruction in, char ch)
	{
		Integer h = 0;
		if(ch=='a')
		h = in.getSourceOperand1().getValue();
		else if (ch=='b')
		h = in.getSourceOperand2().getValue();
		else if (ch=='c')
		h = in.getDestinationOperand().getValue();
		else if (ch == 'd')
		h = in.getProgramCounter();
		return h;
	}
	public static Integer modify(Instruction x)
	{
		Integer val  = 0;
		Integer n = x.getOperationType().ordinal();
		val = n;
		val <<= 5;
		if (n < 22 && n%2 == 0)
		{
			val += type(x,'a');
			val <<= 5;
			val += type(x,'b');
			val <<= 5;
			val += type(x,'c');
			val <<= 12;
		}
		else if (n < 22 && n %2 != 0)
		{
			val += type(x,'a');
			val <<= 5;
			val += type(x,'c');
			val <<= 17;
			val += type(x,'b');
		}
		else if (n > 21 && n < 24 ) 
		{
			val += type(x,'a');
			val <<= 5;
			val += type(x,'c');
			val <<= 17;
			val += type(x,'b');
		}
		else if(n== 24 && x.getDestinationOperand().getOperandType() == OperandType.Label )
		{
			val += ParsedProgram.symtab.get((type(x,'e'))) - (type(x,'d'));
		}
		else if (n == 24)
		{
			val += (type(x, 'c')) << 22;
		}
		else if (n > 24 && n < 29)
		{
			val += (type(x, 'a'));
			val <<= 5;
			val += (type(x,'b'));
			val <<= 17;
			if (x.getDestinationOperand().getOperandType() == OperandType.Label)
			{
				Integer k = (ParsedProgram.symtab.get(x.getDestinationOperand().getLabelValue()) - (type(x,'d')));
				if (k < 0)
					k = Integer.parseInt(Integer.toBinaryString(k).substring(15, 32), 2);
				val += k;
			}
			else
			{
				val += (type(x , 'c'));
			}
		}
		else if (n == 29)
		{
			val  = val << 22;
		}
		else
		{
			Misc.printErrorAndExit("Invalid Instruction");
		}
		return val;
	}
	public static void assemble()
    {
        //TODO your assembler code

        try 
        {
            DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(output));
            
            

            try 
            {
                dataOutput.writeInt(ParsedProgram.mainFunctionAddress);

                for (Integer x : ParsedProgram.data) 
                {
                    dataOutput.writeInt(x);
                }

                for (Instruction x : ParsedProgram.code) 
                {
                    dataOutput.writeInt(modify(x));
                }

                dataOutput.flush();
                dataOutput.close();
            } 
            
            catch (IOException error) 
            {
                Misc.printErrorAndExit(error.toString());
            }
            

        } 
        
        catch (FileNotFoundException error) 
        {
            Misc.printErrorAndExit(error.toString());
        }

    }
	
}
