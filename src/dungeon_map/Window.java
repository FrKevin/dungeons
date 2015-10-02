package dungeon_map;

import javax.swing.JFrame;

import dungeon.Dungeon;
import main.Game;

@SuppressWarnings("serial")
public class Window extends JFrame {

	protected Dungeon dungeon;
	protected Map map;
	
	public Window(int w, int h, Game game) {
		this.dungeon = game.getDungeon();
		
		setTitle("Map generator by Xraptor");
		
		this.map = game.getMap();
		add(map);
		
		setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //pulse();
	}
	
    /*public void pulse() {
		
    	while (true) {
	        //map.repaint();
	        if(map.isRoomChanged()) {
        		System.out.println("repaint?");
	        	map.repaint();
	        }
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
    }*/
	
	/*public Map getMap() {
		return map;
	}*/
    
}
