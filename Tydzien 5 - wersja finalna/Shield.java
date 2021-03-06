package strzelanka;

public class Shield extends Actor {
protected int vx,mspeed,mpx,mpy;
protected static final double FIRING_FREQUENCY = 0.01;

public Shield(Stage stage) {
super(stage);
setSpriteNames( new String[] {"shield1.gif"});
setFrameSpeed(25);
}

public void act(){
	super.act();
	x = (stage.getPlayer().x-40);
	y = (stage.getPlayer().y-20);
	remove();
}

public void spawn() {
	Shield m = new Shield(stage);
	m.setX(stage.getPlayer().x-40);
	m.setY(stage.getPlayer().y-20);
	m.type = 6;
	stage.addActor(m);
}

}