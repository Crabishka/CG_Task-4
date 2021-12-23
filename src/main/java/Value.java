import javax.swing.*;
import java.awt.*;

public class Value {

    int x;
    int y;
    int r = 20;
    double pulseR = 20;
    Color color;

    public Value(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics gr) {
        gr.setColor(color);
        gr.fillOval(x - r, y, r * 2, r * 2);


    }

    public void pulse(Graphics gr) {
        if (pulseR > 60) {
            pulseR = 20;
        }
        gr.setColor(color);
        gr.drawOval(x - (int) pulseR, y + r - (int) pulseR, (int) pulseR * 2, (int) pulseR * 2);
        pulseR += 5;

//        pulseR = 20;


    }

}
