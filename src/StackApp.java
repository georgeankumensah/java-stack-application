import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackApp {
    private Stack<Integer> stack = new Stack<>();
    private JTextArea stackTextArea = new JTextArea();

    public StackApp() {
        JFrame frame = new JFrame("Stack Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        JTextField input = new JTextField(5);
        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");
        JButton peekButton = new JButton("Peek");

        controls.add(input);
        controls.add(pushButton);
        controls.add(popButton);
        controls.add(peekButton);

        stackTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(stackTextArea);

        frame.add(controls, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(input.getText());
                    stack.push(value);
                    stackTextArea.setText(stack.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The stack is empty.");
                } else {
                    stack.pop();
                    stackTextArea.setText(stack.toString());
                }
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The stack is empty.");
                } else {
                    int value = stack.peek();
                    JOptionPane.showMessageDialog(null, "The top value in the stack is: " + value);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StackApp();
            }
        });
    }
}
