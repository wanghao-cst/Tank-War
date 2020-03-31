import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//awt: abstract window toolkit
//抽象出名词：类，属性
//抽象出动词：方法
public class TankFrame extends Frame {
    private Tank enemy;
    private Tank myTank;
    public TankFrame(){
        this.setTitle("Tank War");
        this.setLocation(400,100);
        this.setSize(800,600);
        this.addKeyListener(new TankKeyListener());//自学观察者
        myTank = new Tank(100,100, Dir.R);
        enemy = new Tank(200,200, Dir.D);
    }
    //为什么使用内部类：不需要让别的类访问键盘监听类，高内聚，低耦合
    //为什么不使用方法的内部类，或者匿名类，因为看起来不方便
    @Override
    public void paint(Graphics g) {
        /*
        //图形系统自动初始化了Graphics g这个参数，可以直接拿来用
        //g代表着一支画笔
        g.fillRect(x,y,50,50);//画一个四方块当作坦克
        //动块的原理，位置记录下来并变化，伴随着帧变化
        //x++;
        改用坦克自己画
         */
        myTank.paint(g);//我把画笔交给坦克自己画
        enemy.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {//这里不用implements KeyListener因为每个方法都要补完，而KeyAdapter帮我写了很多方法，我只要重写部分即可
        //若有100辆坦克，每辆坦克还有位置值，每一个属性都应该用一个数组或者list存，很麻烦属于纯面向过程
        //OO设计，所以有了坦克类
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);//把键盘给坦克自己去处理
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);

        }
    }
}
