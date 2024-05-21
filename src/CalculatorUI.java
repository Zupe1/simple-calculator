import javax.swing.*;
import java.awt.*;

public class CalculatorUI {

    private final JLabel outputLabel;

    public CalculatorUI(Calculator calculator) {
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
        outputLabel = new JLabel("0");
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

        for (String buttonName : buttonNames) {
            // Instantiate button with name
            JButton button = new JButton(buttonName);
            button.setFont(font);
            button.addActionListener(calculator);

            // Add buttons to Panel
            buttonPanel.add(button);
        }

        // Add Panels to Frame and make visible
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(outputPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public String getOutputLabelText() {
        return outputLabel.getText();
    }

    public void setOutputLabelText(String outputLabelText) {
        this.outputLabel.setText(outputLabelText);
    }
}
