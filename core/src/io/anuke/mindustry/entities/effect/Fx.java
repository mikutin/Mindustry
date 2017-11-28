package io.anuke.mindustry.entities.effect;

import com.badlogic.gdx.graphics.Color;

import io.anuke.mindustry.Vars;
import io.anuke.ucore.core.Draw;
import io.anuke.ucore.core.Effects.Effect;
import io.anuke.ucore.graphics.Hue;
import io.anuke.ucore.util.Angles;
import io.anuke.ucore.util.Mathf;

public class Fx{
	static Color lightRed = Hue.mix(Color.WHITE, Color.FIREBRICK, 0.1f);
	static Color lightOrange = Color.valueOf("f68021");
	static Color whiteOrange = Hue.mix(lightOrange, Color.WHITE, 0.6f);
	static Color whiteYellow = Hue.mix(Color.YELLOW, Color.WHITE, 0.6f);
	
	public static final Effect
	
	generatorexplosion = new Effect(28, e -> {
		Angles.randLenVectors(e.id, 16, 10f + e.ifract()*8f, (x, y)->{
			float size = e.fract()*12f + 1f;
			Draw.color(Color.WHITE, lightOrange, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	reactorsmoke = new Effect(17, e -> {
		Angles.randLenVectors(e.id, 4, e.ifract()*8f, (x, y)->{
			float size = 1f+e.fract()*5f;
			Draw.color(Color.LIGHT_GRAY, Color.GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	nuclearsmoke = new Effect(40, e -> {
		Angles.randLenVectors(e.id, 4, e.ifract()*13f, (x, y)->{
			float size = e.sfract()*4f;
			Draw.color(Color.LIGHT_GRAY, Color.GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	nuclearcloud = new Effect(90, e -> {
		Angles.randLenVectors(e.id, 10, e.powfract()*90f, (x, y)->{
			float size = e.fract()*14f;
			Draw.color(Color.LIME, Color.GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	chainshot = new Effect(9f, e -> {
		Draw.color(Color.WHITE, lightOrange, e.ifract());
		Draw.thick(e.fract()*4f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*7f);
		Draw.thick(e.fract()*2f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*10f);
		Draw.reset();
	}),
	
	mortarshot = new Effect(10f, e -> {
		Draw.color(Color.WHITE, Color.DARK_GRAY, e.ifract());
		Draw.thick(e.fract()*6f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*10f);
		Draw.thick(e.fract()*5f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*14f);
		Draw.thick(e.fract()*1f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*16f);
		Draw.reset();
	}),
	
	railshot = new Effect(9f, e -> {
		Draw.color(Color.WHITE, Color.DARK_GRAY, e.ifract());
		Draw.thick(e.fract()*5f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*8f);
		Draw.thick(e.fract()*4f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*12f);
		Draw.thick(e.fract()*1f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*14f);
		Draw.reset();
	}),
	
	titanshot = new Effect(12f, e -> {
		Draw.color(Color.WHITE, lightOrange, e.ifract());
		Draw.thick(e.fract()*7f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*12f);
		Draw.thick(e.fract()*4f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*16f);
		Draw.thick(e.fract()*2f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*18f);
		Draw.reset();
	}),
	
	largeCannonShot = new Effect(11f, e -> {
		Draw.color(Color.WHITE, whiteYellow, e.ifract());
		Draw.thick(e.fract()*6f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*12f);
		Draw.thick(e.fract()*3f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*16f);
		Draw.thick(e.fract()*1f);
		Draw.lineAngle(e.x, e.y, e.rotation, e.fract()*18f);
		Draw.reset();
	}),
	
	shockwave = new Effect(10f, e -> {
		Draw.color(Color.WHITE, Color.LIGHT_GRAY, e.ifract());
		Draw.thick(e.fract()*2f + 0.2f);
		Draw.circle(e.x, e.y, e.ifract()*28f);
		Draw.reset();
	}),
	
	nuclearShockwave = new Effect(10f, e -> {
		Draw.color(Color.WHITE, Color.LIGHT_GRAY, e.ifract());
		Draw.thick(e.fract()*3f + 0.2f);
		Draw.polygon(40, e.x, e.y, e.ifract()*140f);
		Draw.reset();
	}),
	
	shockwaveSmall = new Effect(10f, e -> {
		Draw.color(Color.WHITE, Color.LIGHT_GRAY, e.ifract());
		Draw.thick(e.fract()*2f + 0.1f);
		Draw.circle(e.x, e.y, e.ifract()*15f);
		Draw.reset();
	}),
	
	empshockwave = new Effect(7f, e -> {
		Draw.color(Color.WHITE, Color.SKY, e.ifract());
		Draw.thick(e.fract()*2f);
		Draw.circle(e.x, e.y, e.ifract()*40f);
		Draw.reset();
	}),
	
	empspark = new Effect(13, e -> {
		Angles.randLenVectors(e.id, 7, 1f + e.ifract()*12f, (x, y)->{
			float len = 1f+e.fract()*6f;
			Draw.color(Color.SKY);
			Draw.lineAngle(e.x + x, e.y + y, Mathf.atan2(x, y), len);
			Draw.reset();
		});
	}),
	
	shellsmoke = new Effect(20, e -> {
		Angles.randLenVectors(e.id, 8, 3f + e.ifract()*17f, (x, y)->{
			float size = 2f+e.fract()*5f;
			Draw.color(Color.LIGHT_GRAY, Color.DARK_GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	blastsmoke = new Effect(26, e -> {
		Angles.randLenVectors(e.id, 12, 1f + e.ifract()*23f, (x, y)->{
			float size = 2f+e.fract()*6f;
			Draw.color(Color.LIGHT_GRAY, Color.DARK_GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	lava = new Effect(18, e -> {
		Angles.randLenVectors(e.id, 3, 1f + e.ifract()*10f, (x, y)->{
			float size = e.sfract()*4f;
			Draw.color(Color.ORANGE, Color.GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
	}),
	
	lavabubble = new Effect(45f, e -> {
		Draw.color(Color.ORANGE);
		float scl = 0.35f;
		Draw.thick(1f - Mathf.clamp(e.ifract() - (1f-scl)) * (1f/scl));
		Draw.circle(e.x, e.y, e.ifract()*4f);
		Draw.reset();
	}),
	
	oilbubble = new Effect(64f, e -> {
		Draw.color(Color.DARK_GRAY);
		float scl = 0.25f;
		Draw.thick(1f - Mathf.clamp(e.ifract() - (1f-scl)) * (1f/scl));
		Draw.circle(e.x, e.y, e.ifract()*3f);
		Draw.reset();
	}),
	
	shellexplosion = new Effect(9, e -> {
		Draw.thickness(2f - e.ifract()*1.7f);
		Draw.color(Color.WHITE, Color.LIGHT_GRAY, e.ifract());
		Draw.circle(e.x, e.y, 3f + e.ifract() * 9f);
		Draw.reset();
	}),
	
	blastexplosion = new Effect(16, e -> {
		Draw.thickness(1.2f - e.ifract());
		Draw.color(Color.WHITE, Color.SCARLET, e.ifract());
		Draw.circle(e.x, e.y, 1.5f + e.ifract() * 9f);
		Draw.reset();
	}),
	
	place = new Effect(16, e -> {
		Draw.thickness(3f - e.ifract() * 2f);
		Draw.square(e.x, e.y, Vars.tilesize / 2f + e.ifract() * 3f);
		Draw.reset();
	}),
	
	purify = new Effect(10, e -> {
		Draw.color(Color.ROYAL, Color.GRAY, e.ifract());
		Draw.thickness(2f);
		Draw.spikes(e.x, e.y, e.ifract() * 4f, 2, 6);
		Draw.reset();
	}),
	
	purifyoil = new Effect(10, e -> {
		Draw.color(Color.BLACK, Color.GRAY, e.ifract());
		Draw.thickness(2f);
		Draw.spikes(e.x, e.y, e.ifract() * 4f, 2, 6);
		Draw.reset();
	}),
	
	purifystone = new Effect(10, e -> {
		Draw.color(Color.ORANGE, Color.GRAY, e.ifract());
		Draw.thickness(2f);
		Draw.spikes(e.x, e.y, e.ifract() * 4f, 2, 6);
		Draw.reset();
	}),
	
	generate = new Effect(11, e -> {
		Draw.color(Color.ORANGE, Color.YELLOW, e.ifract());
		Draw.thickness(1f);
		Draw.spikes(e.x, e.y, e.ifract() * 5f, 2, 8);
		Draw.reset();
	}),

	spark = new Effect(10, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.GRAY, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 5f, 2, 8);
		Draw.reset();
	}),
	
	sparkbig = new Effect(11, e -> {
		Draw.thickness(1f);
		Draw.color(lightRed, Color.GRAY, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 5f, 2.3f, 8);
		Draw.reset();
	}),
	
	smelt = new Effect(10, e -> {
		Draw.thickness(1f);
		Draw.color(Color.YELLOW, Color.RED, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 5f, 2, 8);
		Draw.reset();
	}),

	breakBlock = new Effect(12, e -> {
		Draw.thickness(2f);
		Draw.color(Color.WHITE, Color.GRAY, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 5f, 2, 5);
		Draw.reset();
	}),

	hit = new Effect(10, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.ORANGE, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 3f, 2, 8);
		Draw.reset();
	}),
	
	laserhit = new Effect(10, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.SKY, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 2f, 2, 6);
		Draw.reset();
	}),
	
	shoot = new Effect(8, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.GOLD, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 2f, 2, 5);
		Draw.reset();
	}),
	
	shoot2 = new Effect(8, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.SKY, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 2f, 1, 5);
		Draw.reset();
	}),
	
	shoot3 = new Effect(8, e -> {
		Draw.thickness(1f);
		Draw.color(Color.WHITE, Color.GOLD, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 2f, 1, 5);
		Draw.reset();
	}),
	
	railshoot = new Effect(8, e -> {
		Draw.thickness(2f  - e.ifract()*2f);
		Draw.color(Color.WHITE, Color.LIGHT_GRAY, e.ifract());
		Draw.spikes(e.x, e.y, 1f + e.ifract() * 4f, 1, 5);
		Draw.reset();
	}),
	
	mortarshoot = new Effect(9, e -> {
		Draw.thickness(1.3f - e.ifract());
		Draw.color(Color.WHITE, Color.ORANGE, e.ifract());
		Draw.spikes(e.x, e.y, e.ifract() * 4f, 2, 6);
		Draw.circle(e.x, e.y, e.ifract() * 5f + 1f);
		Draw.reset();
	}),
	
	titanExplosion = new Effect(11, e -> {
		Draw.thickness(2f*e.fract()+0.5f);
		Draw.color(Color.WHITE, Color.DARK_GRAY, e.powfract());
		Draw.circle(e.x, e.y, 5f + e.powfract() * 8f);
		
		Draw.color(e.ifract() < 0.5f ? whiteOrange : Color.DARK_GRAY);
		float rad = e.fract()*10f + 5f;
		Angles.randLenVectors(e.id, 5, 9f, (x, y)->{
			Draw.rect("circle2", e.x + x, e.y + y, rad, rad);
		});
		
		Draw.reset();
	}),

	explosion = new Effect(11, e -> {
		Draw.thickness(2f*e.fract()+0.5f);
		Draw.color(Color.WHITE, Color.DARK_GRAY, e.powfract());
		Draw.circle(e.x, e.y, 5f + e.powfract() * 6f);
		
		Draw.color(e.ifract() < 0.5f ? Color.WHITE : Color.DARK_GRAY);
		float rad = e.fract()*10f + 5f;
		Angles.randLenVectors(e.id, 5, 8f, (x, y)->{
			Draw.rect("circle2", e.x + x, e.y + y, rad, rad);
		});
		
		Draw.reset();
	}),
	
	
	blockexplosion = new Effect(13, e -> {
		Angles.randLenVectors(e.id+1, 8, 5f + e.ifract()*11f, (x, y)->{
			float size = 2f+e.fract()*8f;
			Draw.color(Color.LIGHT_GRAY, Color.DARK_GRAY, e.ifract());
			Draw.rect("circle", e.x + x, e.y + y, size, size);
			Draw.reset();
		});
		
		Draw.thickness(2f*e.fract()+0.4f);
		Draw.color(Color.WHITE, Color.ORANGE, e.powfract());
		Draw.circle(e.x, e.y, 2f + e.powfract() * 9f);
		
		Draw.color(e.ifract() < 0.5f ? Color.WHITE : Color.DARK_GRAY);
		float rad = e.fract()*10f + 2f;
		Angles.randLenVectors(e.id, 5, 8f, (x, y)->{
			Draw.rect("circle2", e.x + x, e.y + y, rad, rad);
		});
		
		Draw.reset();
	}),
	
	coreexplosion = new Effect(13, e -> {
		Draw.thickness(3f-e.ifract()*2f);
		Draw.color(Color.ORANGE, Color.WHITE, e.ifract());
		Draw.spikes(e.x, e.y, 5f + e.ifract() * 40f, 6, 6);
		Draw.circle(e.x, e.y, 4f + e.ifract() * 40f);
		Draw.reset();
	}),
	
	smoke = new Effect(100, e -> {
		Draw.color(Color.GRAY, new Color(0.3f, 0.3f, 0.3f, 1f), e.ifract());
		float size = 7f-e.ifract()*7f;
		Draw.rect("circle", e.x, e.y, size, size);
		Draw.reset();
	}),
	
	railsmoke = new Effect(30, e -> {
		Draw.color(Color.LIGHT_GRAY, Color.WHITE, e.ifract());
		float size = e.fract()*4f;
		Draw.rect("circle", e.x, e.y, size, size);
		Draw.reset();
	}),
	
	spawn = new Effect(23, e -> {
		Draw.thickness(2f);
		Draw.color(Color.DARK_GRAY, Color.SCARLET, e.ifract());
		Draw.circle(e.x, e.y, 7f - e.ifract() * 6f);
		Draw.reset();
	}),

	ind = new Effect(100, e -> {
		Draw.thickness(3f);
		Draw.color("royal");
		Draw.circle(e.x, e.y, 3);
		Draw.reset();
	}),
	
	respawn = new Effect(Vars.respawnduration, e -> {
		Draw.tcolor(Color.SCARLET);
		Draw.tscl(0.25f);
		Draw.text("Respawning in " + (int)((e.lifetime-e.time)/60), e.x, e.y);
		Draw.tscl(0.5f);
		Draw.reset();
	});
}
