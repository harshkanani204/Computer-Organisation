package processor.pipeline;

public class IF_OF_LatchType {
	
	boolean OF_enable;
	int instruction;
	
	public boolean isOF_enable() {
		return OF_enable;
	}

	public IF_OF_LatchType()
	{
		OF_enable = false;
	}

	public int getInstruction() {
		return instruction;
	}

	public void setOF_enable(boolean oF_enable) {
		OF_enable = oF_enable;
	}

	public void setInstruction(int instruction) {
		this.instruction = instruction;
	}

}
