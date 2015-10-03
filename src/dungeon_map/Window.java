package dungeon_map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import dungeon.Dungeon;
import main.Game;
import other.Way;

@SuppressWarnings("serial")
public class Window extends JFrame {

	protected Map map;
	protected Game game;
	
	public Window(int w, int h, Game game) {
		this.game = game;
		
		setTitle("Map generator by Xraptor");
		
		this.map = game.getMap();
		add(map);
		
		setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        bindFrameWithKeyListener();
        
        //pulse();
	}
	
	public void bindFrameWithKeyListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP:
			            game.getDungeon().setCurrentRoom(
			            		game.getDungeon().getCurrentRoom().getRoom("north")
			            );
			            break;
			        case KeyEvent.VK_DOWN:
			        	game.getDungeon().setCurrentRoom(
			            		game.getDungeon().getCurrentRoom().getRoom("south")
			            );
			            break;
			        case KeyEvent.VK_LEFT:
			        	game.getDungeon().setCurrentRoom(
			            		game.getDungeon().getCurrentRoom().getRoom("west")
			            );
			            break;
			        case KeyEvent.VK_RIGHT :
			        	game.getDungeon().setCurrentRoom(
			            		game.getDungeon().getCurrentRoom().getRoom("east")
			            );
			            break;
			     }
			     map.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
