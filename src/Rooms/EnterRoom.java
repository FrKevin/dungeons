package rooms;

public class EnterRoom extends Room{

	@Override
	public String toString() {
		return "Your are in the entrance room.";
	}

	@Override
	public boolean canEnert() {
		return true;
	}

}
