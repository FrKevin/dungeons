package other;
public abstract class Button {

	protected Door door;
	
	public Button(Door door) {
		this.door = door;
	}
	
	public abstract void swt();
	
}
