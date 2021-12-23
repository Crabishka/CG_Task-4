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
        this.setSize(900, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        drawPanel.go(getGraphics());

    }


    public static void main(String[] args) {
        new MainForm();
    }


}
