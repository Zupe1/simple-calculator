import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Calculator implements ActionListener {
    public static void main(String[] args) {
        new Calculator();
    }

    // Output Label
    JLabel outputLabel;

    double previousNumber;
    String operator;

    public Calculator() {
        initializeInterface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "+":
                operator = "add";
                break;
            case "-":
                operator = "subtract";
                break;
            case "*":
                operator = "multiply";
                break;
            case "/":
                operator = "divide";
                break;
            case "C":
                operator = "clear";
                break;
            case "=":
                operator = "equals";
                break;
            default:
                outputLabel.setText(outputLabel.getText() + buttonText);
                break;
        }
    }

    private void initializeInterface() {
        // Frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setSize(400,450);

        // Font
        Font font = new Font("Dialogue", Font.PLAIN, 40);

        // Output Panel
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        outputPanel.setPreferredSize(new Dimension(400, 50));
        outputLabel = new JLabel("1234");
        outputLabel.setFont(font);
        outputPanel.add(outputLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonNames = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "C", "0", "/", "="
        };

        for (int i = 0; i < 16; i++) {
            // Instantiate button with name
            JButton button = new JButton(buttonNames[i]);
            button.setFont(font);
            button.addActionListener(this);

            // Add buttons to Panel
            buttonPanel.add(button);
        }

        // Add Panels to Frame and make visible
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(outputPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}