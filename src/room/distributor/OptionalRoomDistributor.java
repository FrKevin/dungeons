package room.distributor;

import other.Config;
import other.Utils;

public class OptionalRoomDistributor {

	protected int mainRoomNb;
	protected int mainRoomCreatedNb;
	protected int optionalRoomNb;
	protected int optionalRoomCreatedNb;
	
	protected int nextRoomPop;
	protected int nextNb;
	
	public OptionalRoomDistributor(int mainRoomNb, int optionalRoomNb) {
		this.mainRoomNb = mainRoomNb;
		this.optionalRoomNb = optionalRoomNb;
		mainRoomCreatedNb = 0;
		optionalRoomCreatedNb = 0;
		nextRoomPop = -1;
	}
	
	public boolean isGenerationFinished() {
		if(optionalRoomNb-optionalRoomCreatedNb == 0 && nextRoomPop == -1)
			return true;
		return false;
	}
	
	public boolean isRoomPop() {
		mainRoomCreatedNb++;
		if(nextRoomPop == -1)
			createRoomNumber();
		if(mainRoomCreatedNb == nextRoomPop)
			return true;
		return false;
	}
	
	public int nextRoomNumber() {
		nextRoomPop = -1;
		return nextNb;
	}

	public void createRoomNumber() {
		
		int maxOptionalNb = Utils.upperRound((optionalRoomNb * Config.optionalRoomRate));
		int optionalNb = Utils.rnd.nextInt(maxOptionalNb)+1;
		
		if(optionalRoomNb-optionalRoomCreatedNb < optionalNb)
			optionalNb = optionalRoomNb-optionalRoomCreatedNb;
		
		int mainRoomSlice = Utils.upperRound((optionalNb / (float)optionalRoomNb) * mainRoomNb);
		mainRoomSlice = Utils.rnd.nextInt(mainRoomSlice)+1;
		
		int mainRoomSliceStart = Utils.upperRound((optionalRoomCreatedNb / (float)optionalRoomNb) * mainRoomNb);
		nextRoomPop = mainRoomSliceStart + mainRoomSlice;
		
		optionalRoomCreatedNb += optionalNb; // Don't forget to count new optionals
		nextNb = optionalNb;
	}
	
}
