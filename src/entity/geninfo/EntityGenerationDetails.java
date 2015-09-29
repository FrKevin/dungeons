package entity.geninfo;

import entity.Entity;
import other.Utils;

public class EntityGenerationDetails {
	
	protected Entity entity;
	protected int min; //Minimum range number of generation for the entity
	protected int max; //Maximum range number of generation for the entity
	
	protected int maxGen; //Maximum generation number for this kind of entity
	protected int genCount; //Generation number counter for this kind of entity
	
	public EntityGenerationDetails(Entity entity, int min, int max) {
		this.entity = entity;
		this.min = min;
		this.max = max;
		genCount = 0;
		
		if((maxGen = Utils.rnd.nextInt(max-min+1)) > 0) {
			maxGen = min+maxGen-1;
		} else {
			maxGen = min;
		}
	}
	
	public Entity generateNewEntity() {
		genCount++;
		return entity.clone();
	}
	
	public boolean isGenerationFinished() {
		if(genCount < maxGen) {
			return false;
		}
		return true;
	}
	
	public int getGenCount() {
		return genCount;
	}
	
	public int getMaxGen() {
		return maxGen;
	}
	
	public String getClassName() {
		return entity.getClass().getSimpleName();
	}
	
}
