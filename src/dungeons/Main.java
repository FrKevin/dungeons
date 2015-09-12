package dungeons;

import rooms.EnterRoom;
import rooms.Room;

public class Main {
	public static void main(String[] args) {
		Player player = new Player("Kevin");
		Game game = new Game(new Dungeon(player, new EnterRoom() ));
		game.run();
	}
}
