import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        TankFrame tf = new TankFrame();
        tf.setVisible(true);

        for(;;) {
            try {
                Thread.sleep(25);
                //TimeUnit.MICROSECONDS.sleep(1000);//1秒=1000ms，睡25个毫秒，1秒40帧
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            //因为tf.paint需要传入参数g，所以用repaint
            tf.repaint();//repaint call update call paint
        }
    }
}
