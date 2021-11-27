import javax.swing.*;
import java.awt.*;

import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

public class DrawPanel extends JPanel {

    public void setValues(List<Value> values) {
        int size = values.size();
        int gap = 800 / (size);
        int radius = gap / 2;
        for (int i = 0; i < values.size(); i++) {
            values.get(i).x = 50 + i * gap;
            values.get(i).y = 300;
            values.get(i).r = radius;
        }
        this.values = values;

    }


    List<Value> values;
    int width;
    int height;


    DrawPanel() {
        setSize(900, 500);
        this.width = 900;
        this.height = 500;
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
        g.setColor(new Color(1,50,32));
        g.fillRect(0, 0, 900, 500);
        setSize(900, 500);
        drawValues(gr);

    }

    public void drawValues(Graphics gr) {
        if (values == null) return;

        for (Value value : values) {
            gr.setColor(value.color);
            gr.fillOval((int) (value.x + value.r / 2), (int) (value.y - value.r / 2), (int) (value.r), (int) (value.r));
            gr.setColor(Color.BLACK);
            gr.drawOval((int) (value.x + value.r / 2), (int) (value.y - value.r / 2), (int) (value.r), (int) (value.r));
            String text = String.valueOf(value.value);
            centerString(gr, new Rectangle((int) (value.x + value.r / 2), (int) (value.y - value.r / 2), (int) (value.r), (int) (value.r)), text, gr.getFont());
        }

    }


    public void centerString(Graphics g, Rectangle r, String s,
                             Font font) {
        FontRenderContext frc =
                new FontRenderContext(null, true, true);

        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }

    public void InsertionSort() {
        new Thread(() -> {

            for (int left = 0; left < values.size(); left++) {
                int minInd = left;
                Value min = null;
                for (int i = left; i < values.size(); i++) {
                    highlight(values.get(left), values.get(i), Color.RED);
                    if (values.get(i).compareTo(values.get(minInd)) < 0) {
                        minInd = i;
                        returnColor(min);
                        min = values.get(minInd);
                        highlight(min, Color.MAGENTA);
                    }
                }
                swap(values, left, minInd);
                returnColor(min);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void returnColor(Value value){
        if (value == null) return;
        value.color = Color.YELLOW;
    }

    public void highlight(Value value1, Color color) {
        value1.color = color;
        super.repaint();

    }

    public void highlight(Value value1, Value value2, Color color) {

        value1.color = color;
        value2.color = color;
        super.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value1.color = Color.YELLOW;
        value2.color = Color.YELLOW;
        super.repaint();
    }

    public void swap(List<Value> values, int index1, int index2) {
        Collections.swap(values, index1, index2);
        Value value1 = values.get(index1);
        Value value2 = values.get(index2);
        int xR = (int) (Math.abs(value2.x - value1.x)) / 2;
        if (value1.x < value2.x) {
            for (int i = 1; i <= 180; i += 1) {
                double offsetX = Math.cos(i * Math.PI / 180.0) - Math.cos((i - 1) * Math.PI / 180.0);
                value1.x -= offsetX * xR;
                value2.x += offsetX * xR;
                moveY(value1, value2, xR, i);
            }
        } else {
            for (int i = 1; i <= 180; i += 1) {
                double offsetX = Math.cos(i * Math.PI / 180.0) - Math.cos((i - 1) * Math.PI / 180.0);
                value1.x += offsetX * xR;
                value2.x -= offsetX * xR;
                moveY(value1, value2, xR, i);
            }

        }

    }

    private void moveY(Value value1, Value value2, int xR, int i) {
        double offsetY = (Math.sin(i * Math.PI / 180.0) - Math.sin((i - 1) * Math.PI / 180.0));
        value2.y -= offsetY * xR;
        value1.y += offsetY * xR;
        super.repaint();
        try {
            Thread.sleep(5);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }




}
