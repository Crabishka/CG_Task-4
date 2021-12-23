import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DrawPanel extends JPanel {

    int width;
    int height;
    ValueStorage valueStorage;


    DrawPanel() {
        setSize(900, 600);
        this.width = 900;
        this.height = 600;
        valueStorage = new ValueStorage();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        this.width = width;
        this.height = height;
    }


    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;

        setSize(900, 600);
    }

    private void drawAll(Graphics gr) {

        for (Map.Entry<Color, ArrayList<Value>> entry : valueStorage.storage.entrySet()) {
            for (Value value : entry.getValue()) {
                value.draw(gr);
            }
        }

        for (Value value : valueStorage.storage.get(valueStorage.RED)) {
            value.pulse(gr);
        }

    }

    public void go(Graphics gr) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gr.setColor(new Color(0, 0, 0));
                gr.fillRect(0, 0, 900, 600);
                drawAll(gr);
            }

        }).start();
    }


}
