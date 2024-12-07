import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class WordCounterGUI {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Word Frequency Counter");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a label
        JLabel label = new JLabel("Enter your text:");
        label.setBounds(20, 20, 150, 30);
        frame.add(label);

        // Create a text field for input
        JTextField textField = new JTextField();
        textField.setBounds(20, 60, 440, 30);
        frame.add(textField);

        // Create a button
        JButton button = new JButton("Count Words");
        button.setBounds(20, 110, 150, 30);
        frame.add(button);

        // Create a text area for displaying the results
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 160, 440, 180);
        resultArea.setEditable(false);
        frame.add(resultArea);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textField.getText();
                if (content.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter some text!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Process the content to get the word frequency
                Map<String, Integer> wordCount = new HashMap<>();
                String[] words = content.toLowerCase().split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }

                // Prepare the result string
                StringBuilder result = new StringBuilder("Word Frequency:\n");
                for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                    result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }

                // Display the results in the text area
                resultArea.setText(result.toString());
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}