import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JDialog {

    private JPanel MainPane;
    private JButton buttonDo;
    private JTextField textField1;
    private final DrawPanel drawPanel;

    public MainForm() {
        drawPanel = new DrawPanel();
        this.setContentPane(MainPane);
        MainPane.add(drawPanel);
        this.setSize(920, 650);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        buttonDo.addActionListener(e -> {
            String[] tokens = textField1.getText().split("\s");
            List<Value> valueList = new ArrayList<>();
            for (String token : tokens) {
                valueList.add(new Value(Integer.parseInt(token)));
            }
            drawPanel.setValues(valueList);
            drawPanel.repaint();
            drawPanel.InsertionSort();
        });
    }


    public static void main(String[] args) {
        new MainForm();
    }


}
