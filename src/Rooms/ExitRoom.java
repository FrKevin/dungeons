package rooms;

public class ExitRoom extends Room{

	@Override
	public String toString() {
		return "Fin dungeons";
	}

	@Override
	public boolean canEnert() {
		return true;
	}
	@Override
	public boolean isExit(){
		return true;
	}
}
