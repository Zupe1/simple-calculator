import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        // JFrame setup
        JFrame frame = new JFrame();
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Output JPanel setup
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        outputPanel.setPreferredSize(new Dimension(400,100));

        // Output label
        JLabel label = new JLabel("14667");
        Font font = new Font("DIALOG_INPUT",Font.PLAIN,60);
        label.setFont(font);

        outputPanel.add(label);
        frame.add(outputPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        JButton[] buttons = new JButton[16];

        String[] buttonNames = {
                "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "Clear", "0", "=", "/"
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}