package other;

import java.util.Random;

public class Utils {
	
	public static final Random rnd = new Random();
	
	public static Way reverseWay(Way way) {
		if(way.ordinal() % 2 == 0)
			return Way.values()[way.ordinal()+1];
		return Way.values()[way.ordinal()-1];
	}
	
	public static int upperRound(float f) {
		if(f - (int)f > 0)
			return (int)f + 1;
		return (int)f;
	}
	
}
