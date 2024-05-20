import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        outputPanel.setPreferredSize(new Dimension(400,100));

        JLabel textArea = new JLabel("14667");
        Font font = new Font("DIALOG_INPUT",Font.PLAIN,60);
        textArea.setFont(font);

        outputPanel.add(textArea);
        frame.add(outputPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));



        JButton button1 = new JButton("1");
        panel.add(button1);

        JButton button2 = new JButton("2");
        panel.add(button2);

        JButton button3 = new JButton("3");
        panel.add(button3);

        JButton button4 = new JButton("+");
        panel.add(button4);

        JButton button5 = new JButton("4");
        panel.add(button5);

        JButton button6 = new JButton("5");
        panel.add(button6);

        JButton button7 = new JButton("6");
        panel.add(button7);

        JButton button8 = new JButton("-");
        panel.add(button8);

        JButton button9 = new JButton("7");
        panel.add(button9);

        JButton button10 = new JButton("8");
        panel.add(button10);

        JButton button11 = new JButton("9");
        panel.add(button11);

        JButton button12 = new JButton("*");
        panel.add(button12);

        JButton button13 = new JButton("Clear");
        panel.add(button13);

        JButton button14 = new JButton("0");
        panel.add(button14);

        JButton button15 = new JButton("=");
        panel.add(button15);

        JButton button16 = new JButton("/");
        panel.add(button16);



        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Calc");

            }
        });
    }
}