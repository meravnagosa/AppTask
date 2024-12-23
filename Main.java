import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JFrame frame;
    private JPanel page1, page2;

    //first page components
    private JTextField fullNameField;
    private JTextField favoriteColorField;
    private JTextField dreamDestinationField;

    //second page components
    private JTextField favoriteAnimalField;
    private JComboBox<String> budgetDropdown;
    private JComboBox<String> colorDropdown;


    public Main() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        createPage1();
        createPage2();

        frame.add(page1);
        frame.add(page2);
        page1.setVisible(true);
        page2.setVisible(false);
        frame.setVisible(true);
    }

    private void createPage1() {
        page1 = new JPanel();
        page1.setBounds(0, 0, 400, 300);
        page1.setLayout(new GridLayout(5, 1, 10, 10));

        fullNameField = new JTextField();
       favoriteColorField = new JTextField();
        dreamDestinationField = new JTextField();
        JButton nextButton = new JButton("Next");

        page1.add(new JLabel("Full Name:"));
        page1.add(fullNameField);
        page1.add(new JLabel("Favorite Color:"));
        colorDropdown = new JComboBox<>(new String[]{"Red", "Pink", "Purple"});
        page1.add(colorDropdown);
        page1.add(new JLabel("Dream Destination:"));
        page1.add(dreamDestinationField);

        page1.add(nextButton);

        //action listener
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page1.setVisible(false);
                page2.setVisible(true);
            }
        });
    }

    private void createPage2() {
        page2 = new JPanel();
        page2.setBounds(0, 0, 400, 300);
        page2.setLayout(new GridLayout(5, 1, 10, 10));

        favoriteAnimalField = new JTextField();
        budgetDropdown = new JComboBox<>(new String[]{"$1,000", "$2,000", "$3,000", "$4,000"});
        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");

        page2.add(new JLabel("Feared Animal:"));
        page2.add(favoriteAnimalField);
        page2.add(new JLabel("Travel Budget:"));
        page2.add(budgetDropdown);
        page2.add(backButton);
        page2.add(submitButton);

        // action liesener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hide the second page
                page2.setVisible(false);
                //Hide the first page
                page1.setVisible(true);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String favoriteColor = favoriteColorField.getText();
                String dreamDestination = dreamDestinationField.getText();
                String favoriteAnimal = favoriteAnimalField.getText();

            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
