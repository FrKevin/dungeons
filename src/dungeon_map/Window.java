package dungeon_map;

import javax.swing.JFrame;

import dungeon.Dungeon;

@SuppressWarnings("serial")
public class Window extends JFrame {

	protected Dungeon dungeon;
	protected Map map;
	
	public Window(int w, int h, Dungeon dungeon) {
		this.dungeon = dungeon;
		
		setTitle("Map generator by Xraptor");
		
		map = new Map(this, dungeon);
		add(map);
		
		setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
    public void pulse() {
		
    	while (true) {
	        map.repaint();
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
    }
    
}
