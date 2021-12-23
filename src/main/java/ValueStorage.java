import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValueStorage {


    static public Color RED = new Color(201, 76, 68);
    static public Color YELLOW = new Color(241, 190, 65);
    static public Color PINK = new Color(100, 198, 220);

    Map<Color, ArrayList<Value>> storage = new HashMap<>();

    ValueStorage() {

        ArrayList<Value> redList = new ArrayList<>();
        ArrayList<Value> yellowList = new ArrayList<>();
        ArrayList<Value> pinkList = new ArrayList<>();
        storage.put(RED, redList);
        storage.put(YELLOW, yellowList);
        storage.put(PINK, pinkList);
        for (int w = 0; w <= 900; w += 360) {
            for (int h = 0; h <= 600; h += 120) {
                pinkList.add(new Value(w, h, PINK));
                yellowList.add(new Value(w + 120, h, YELLOW));
                redList.add(new Value(w + 240, h, RED));
            }
        }
        for (int w = 60; w <= 900; w += 360) {
            for (int h = 60; h <= 600; h += 120) {
                redList.add(new Value(w, h, RED));
                pinkList.add(new Value(w + 120, h, PINK));
                yellowList.add(new Value(w + 240, h, YELLOW));
            }
        }
    }



}
