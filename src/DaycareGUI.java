import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class DaycareGUI extends JFrame {
    private PetDaycare daycare;
    private JTextArea displayArea;

    public DaycareGUI() {
        super("Pet Daycare Management System");

        // Initialize Daycare
        String name = JOptionPane.showInputDialog(this, "Enter daycare name:", "Setup", JOptionPane.QUESTION_MESSAGE);
        if (name == null || name.trim().isEmpty()) {
            name = "Default Daycare";
        }
        daycare = new PetDaycare(name);

        // Setup UI Components
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Output Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Redirect console output to the JTextArea
        redirectSystemOut();

        // Control Panel (Buttons)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 5, 5));

        JButton btnRegister = new JButton("1. Register a Pet");
        JButton btnListAll = new JButton("2. List All Pets");
        JButton btnFeed = new JButton("3. Feed a Pet");
        JButton btnListHungry = new JButton("4. List Hungry Pets");
        JButton btnSummary = new JButton("5. Print Care Summary");
        JButton btnClear = new JButton("Clear Screen");

        buttonPanel.add(btnRegister);
        buttonPanel.add(btnListAll);
        buttonPanel.add(btnFeed);
        buttonPanel.add(btnListHungry);
        buttonPanel.add(btnSummary);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.EAST);

        // Button Actions
        btnRegister.addActionListener(e -> registerPetDialog());
        
        btnListAll.addActionListener(e -> {
            System.out.println("\n--- All Pets ---");
            daycare.listAllPets();
        });

        btnFeed.addActionListener(e -> {
            String petName = JOptionPane.showInputDialog(this, "Enter pet name to feed:");
            if (petName != null && !petName.trim().isEmpty()) {
                System.out.println();
                daycare.feedPet(petName.trim());
            }
        });

        btnListHungry.addActionListener(e -> {
            System.out.println();
            daycare.listHungryPets();
        });

        btnSummary.addActionListener(e -> {
            System.out.println();
            daycare.printCareSummary();
        });

        btnClear.addActionListener(e -> displayArea.setText(""));

        System.out.println("Welcome to " + name + "!");
    }

    private void registerPetDialog() {
        JTextField typeField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField ownerField = new JTextField();

        Object[] message = {
            "Pet Type (dog/cat/bird):", typeField,
            "Pet Name:", nameField,
            "Pet Age:", ageField,
            "Owner Name:", ownerField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Register New Pet", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String type = typeField.getText().toLowerCase().trim();
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String owner = ownerField.getText().trim();

                Pet newPet = null;
                switch (type) {
                    case "dog":
                        newPet = new Dog(name, age, owner);
                        break;
                    case "cat":
                        newPet = new Cat(name, age, owner);
                        break;
                    case "bird":
                        newPet = new Bird(name, age, owner);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Unknown pet type. Please enter dog, cat, or bird.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                System.out.println();
                daycare.registerPet(newPet);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Helper method to redirect System.out.println to the JTextArea
    private void redirectSystemOut() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                SwingUtilities.invokeLater(() -> {
                    displayArea.append(String.valueOf((char) b));
                    displayArea.setCaretPosition(displayArea.getDocument().getLength());
                });
            }
        };
        System.setOut(new PrintStream(out, true));
    }

    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            DaycareGUI gui = new DaycareGUI();
            gui.setLocationRelativeTo(null); // Center on screen
            gui.setVisible(true);
        });
    }
}
