import java.awt.*;

public class Value implements Comparable<Value> {

    double x;
    double y;
    double r;
    int value;
    Color color = Color.YELLOW;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Value o) {
        return this.value - o.value;
    }
}
