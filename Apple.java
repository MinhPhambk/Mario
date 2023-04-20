import java.awt.Color;
import java.awt.Graphics;

public class Apple {
    
    private int xCoor, yCoor, width, height;

    public Apple(int xCoor, int yCoor, int titleSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = titleSize;
        height = titleSize;
    }

    public void tick(){

    }
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoor*width, yCoor*height, width, height);
    }

    public int getxCoor() {
        return xCoor;
    }

    public int setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public int setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}
