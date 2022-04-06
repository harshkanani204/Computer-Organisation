package processor.pipeline;
import generic.Instruction;

public class MA_RW_LatchType {
	
	boolean RW_enable;
	Instruction instruction;
	int loadresult;
	int aluresult;
	
	public MA_RW_LatchType()
	{
		RW_enable = false;
	}

	public boolean isRW_enable() {
		return RW_enable;
	}

	public void setRW_enable(boolean rW_enable) {
		RW_enable = rW_enable;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction ins) {
		instruction = ins;
	}

	public void setLoadresult(int result) {
		loadresult = result;
	}

	public int getLoadresult() {
		return loadresult;
	}

	public int getALUresult() {
		return aluresult;
	}

	public void setALUresult(int result) {
		aluresult = result;
	}

}
