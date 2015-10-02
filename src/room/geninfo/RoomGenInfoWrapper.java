package room.geninfo;

public class RoomGenInfoWrapper {

	protected RoomGenInfo roomGenInfo;
	
	public RoomGenInfoWrapper(RoomGenInfo roomGenInfo) {
		this.roomGenInfo = roomGenInfo;
	}
	
	public void setRoomGenInfo(RoomGenInfo roomGenInfo) {
		this.roomGenInfo = roomGenInfo;
	}
	
	public RoomGenInfo getRoomGenInfo() {
		return roomGenInfo;
	}
	
}
