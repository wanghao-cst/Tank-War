import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;//位置明显是坦克的属性
    public static final int SPEED = 5;
    private Dir dir;
    private boolean bL, bR, bU, bD;
    //记录键盘是否被按下的变量

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y,50,50);
        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT://VK virtual key
                bL = true;
                break;
            case KeyEvent.VK_UP://VK virtual key
                bU = true;
                break;
            case KeyEvent.VK_RIGHT://VK virtual key
                bR = true;
                break;
            case KeyEvent.VK_DOWN://VK virtual key
                bD = true;
                break;
        }
        setMainDir();
    }

    private void setMainDir() {
        if(!bL && !bU && !bR && !bD)
            dir = Dir.STOP;
        if(bL && !bU && !bR && !bD)
            dir = Dir.L;
        if(!bL && bU && !bR && !bD)
            dir = Dir.U;
        if(!bL && !bU && bR && !bD)
            dir = Dir.R;
        if(!bL && !bU && !bR && bD)
            dir = Dir.D;
    }

    private void move() {
        switch(dir){
            case L:
                x -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT://VK virtual key
                bL = false;
                break;
            case KeyEvent.VK_UP://VK virtual key
                bU = false;
                break;
            case KeyEvent.VK_RIGHT://VK virtual key
                bR = false;
                break;
            case KeyEvent.VK_DOWN://VK virtual key
                bD = false;
                break;
        }
        setMainDir();//计算当前方向
    }
}
