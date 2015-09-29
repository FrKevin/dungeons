package dungeon_map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Map.Entry;

import javax.swing.JPanel;

import dungeon.Dungeon;
import other.Door;
import other.Utils;
import other.Way;
import room.Room;

public class Map extends JPanel {
	
    protected Window window;
    protected Dungeon dungeon;
    
    protected final int stepX = 20;
    protected final int stepY = 20;
    
    public Map(Window window, Dungeon dungeon) {
    	this.window = window;
    	this.dungeon = dungeon;
    	this.setSize(window.getWidth(), window.getHeight());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        		RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.blue);
        
        g2d.fillRect(
        		getWidth()/2-stepX/2, 
        		getHeight()/2-stepY/2, 
        		stepX, 
        		stepY
        	);
        dispRoom(g2d, dungeon.getCurrentRoom(), Way.SOUTH, 0, 0);
    }

	public void dispRoom(Graphics2D g2d, Room room, Way excludeWay, int w, int h) {
		
		for(Entry<Way, Door> entry : room.getDoors().entrySet()) {
			if(entry.getKey() != excludeWay) {
	        	switch(entry.getKey()) {
		        	case NORTH:
		        		graphDispRoom(g2d, w, h-stepY);
		        		dispRoom(
	        				g2d, 
	        				entry.getValue().getAdjacentRoom(room), 
	        				Utils.reverseWay(entry.getKey()),
	        				w,
	        				h-stepY
		        		);
		        		break;
		        	case SOUTH:
		        		graphDispRoom(g2d, w, h+stepY);
		        		dispRoom(
	        				g2d, 
	        				entry.getValue().getAdjacentRoom(room), 
	        				Utils.reverseWay(entry.getKey()),
	        				w,
	        				h+stepY
		        		);
		        		break;
		        	case EAST:
		        		graphDispRoom(g2d, w+stepX, h);
		        		dispRoom(
	        				g2d, 
	        				entry.getValue().getAdjacentRoom(room), 
	        				Utils.reverseWay(entry.getKey()),
	        				w+stepX,
	        				h
		        		);
		        		break;
		        	case WEST:
		        		graphDispRoom(g2d, w-stepX, h);
		        		dispRoom(
	        				g2d, 
	        				entry.getValue().getAdjacentRoom(room), 
	        				Utils.reverseWay(entry.getKey()),
	        				w-stepX,
	        				h
		        		);
		        		break;
	        	}
	        	
			}
		}
		
	}
	
	public void graphDispRoom(Graphics2D g2d, int w, int h) {
		g2d.fillRect(
        		getWidth()/2-stepX/2 + w, 
        		getHeight()/2-stepY/2 + h, 
        		stepX, 
        		stepY
        	);
	}
}