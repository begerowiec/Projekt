package strzelanka;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Actor {
protected int x,y;
protected int width, height;
protected String spriteName;
protected Stage stage;
protected SpriteCache spriteCache;
protected int currentFrame;
protected String[] spriteNames;
protected int frameSpeed;
protected int t;
protected int vx;
protected boolean markedForRemoval;
protected boolean markedExist;
protected int type;
protected int target;


public Actor(Stage stage) {
this.stage = stage;
spriteCache = stage.getSpriteCache();
currentFrame = 0;
frameSpeed = 1;
t=0;
}
public int getFrameSpeed() {return frameSpeed; }
public void setFrameSpeed(int i) {frameSpeed = i; }

public void paint(Graphics2D g){
//	for (int i = 0; i < this.spriteNames.length; i++ ) {	
	g.drawImage( spriteCache.getSprite(spriteNames[currentFrame]), x,y, stage );
//	}
}
public int getX() { return x; }

public void setX(int i) { x = i; }
public int getY() { return y; }

public void setY(int i) { y = i; }

public void setSpriteNames(String[] names) {
	spriteNames = names;
	height = 0;
	width = 0;
	for (int i = 0; i < names.length; i++ ) {	
	BufferedImage image = spriteCache.getSprite(spriteNames[i]);
	height = Math.max(height,image.getHeight());
	width = Math.max(width,image.getWidth());
	}
}

public void setSpriteName(String string) {
spriteName = string;
		BufferedImage image = spriteCache.getSprite(spriteName);
		height = image.getHeight();
		width = image.getWidth();
}


public int getHeight() { return height; }
public int getWidth() { return width; }
public void setHeight(int i) {height = i; }
public void setWidth(int i) { width = i; }

public void act() {
	//System.out.println("act");
	t++;
	if (t % frameSpeed  == 0){
	t=0;
	currentFrame = (currentFrame + 1) % spriteNames.length;
	
	}
}

public void remove() {
markedForRemoval = true;
}

public boolean isMarkedForRemoval() {
return markedForRemoval;
}

///////////// kolizja
public Rectangle getBounds() {
return new Rectangle(x,y,width,height);
}

public void collision(Actor a){}


}
