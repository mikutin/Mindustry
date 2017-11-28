package io.anuke.mindustry.entities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.badlogic.gdx.utils.ObjectMap;

import io.anuke.mindustry.Vars;
import io.anuke.mindustry.entities.effect.Fx;
import io.anuke.mindustry.entities.enemies.Enemy;
import io.anuke.mindustry.resource.Item;
import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.Tile;
import io.anuke.mindustry.world.blocks.ProductionBlocks;
import io.anuke.mindustry.world.blocks.types.Wall;
import io.anuke.ucore.core.Effects;
import io.anuke.ucore.core.Timers;
import io.anuke.ucore.entities.Entities;
import io.anuke.ucore.entities.Entity;
import io.anuke.ucore.util.Mathf;

public class TileEntity extends Entity{
	public Tile tile;
	public ObjectMap<Item, Integer> items = new ObjectMap<>();
	public int maxhealth, health;
	public boolean dead = false;
	public boolean added;
	
	/**Sets this tile entity data to this tile, and adds it if necessary.*/
	public TileEntity init(Tile tile, boolean added){
		this.tile = tile;
		this.added = added;
		x = tile.worldx();
		y = tile.worldy();
		
		maxhealth = tile.block().health;
		health = maxhealth;
		
		if(added){
			add(Entities.getGroup(TileEntity.class));
		}
		
		return this;
	}
	
	public void write(DataOutputStream stream) throws IOException{
		
	}
	
	public void read(DataInputStream stream) throws IOException{
		
	}
	
	public void onDeath(){
		dead = true;
		
		if(tile.block() == ProductionBlocks.core){
			Vars.control.coreDestroyed();
		}
		
		Block block = tile.block();
		
		block.onDestroyed(tile);
		
		Vars.world.removeBlock(tile);
	}
	
	public void collision(Bullet other){
		damage(other.getDamage());
	}
	
	public void damage(int damage){
		if(dead) return;
		
		int amount = tile.block().handleDamage(tile, damage);
		health -= amount;
		if(health <= 0) onDeath();
	}
	
	public boolean collide(Bullet other){
		return other.owner instanceof Enemy;
	}
	
	@Override
	public void update(){
		if(health != 0 && !(tile.block() instanceof Wall) &&
				Mathf.chance(0.009f*Timers.delta()*(1f-(float)health/maxhealth))){
			
			Effects.effect(Fx.smoke, x+Mathf.range(4), y+Mathf.range(4));
		}
		
		tile.block().update(tile);
	}
	
	public int totalItems(){
		int sum = 0;
		for(Item item : Item.values()){
			sum += items.get(item, 0);
		}
		return sum;
	}
	
	public int getItem(Item item){
		return items.get(item, 0);
	}
	
	public boolean hasItem(Item item){
		return items.get(item, 0) > 0;
	}
	
	public boolean hasItem(Item item, int amount){
		return items.get(item, 0) >= amount;
	}
	
	public void addItem(Item item, int amount){
		items.put(item, items.get(item, 0) + amount);
	}
	
	public void removeItem(Item item, int amount){
		items.put(item, items.get(item, 0) - amount);
	}
}
