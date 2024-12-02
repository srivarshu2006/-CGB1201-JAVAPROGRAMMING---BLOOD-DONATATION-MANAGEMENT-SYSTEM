import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BloodDonationManagementSystem extends Frame {
    // Donor registration form components
    private Label nameLabel, ageLabel, bloodTypeLabel;
    private TextField nameField, ageField;
    private Choice bloodTypeChoice;
    private Button registerButton;

    // Donation scheduling form components
    private Label scheduleLabel, dateLabel, timeLabel;
    private TextField dateField, timeField;
    private Button scheduleButton;

    // Donation history display components
    private TextArea historyArea;

    // Blood bank inventory management components
    private Label inventoryLabel, bloodTypeInventoryLabel;
    private TextField bloodTypeInventoryField;
    private Button updateInventoryButton;

    // Constructor for initializing the GUI
    public BloodDonationManagementSystem() {
        // Set up the frame
        setTitle("Blood Donation Management System");
        setSize(500, 600);
        setLayout(new FlowLayout());

        // Donor Registration Section
        nameLabel = new Label("Name: ");
        nameField = new TextField(20);
        ageLabel = new Label("Age: ");
        ageField = new TextField(3);
        bloodTypeLabel = new Label("Blood Type: ");
        bloodTypeChoice = new Choice();
        bloodTypeChoice.add("A+");
        bloodTypeChoice.add("A-");
        bloodTypeChoice.add("B+");
        bloodTypeChoice.add("B-");
        bloodTypeChoice.add("O+");
        bloodTypeChoice.add("O-");
        bloodTypeChoice.add("AB+");
        bloodTypeChoice.add("AB-");
        registerButton = new Button("Register Donor");

        // Donation Scheduling Section
        scheduleLabel = new Label("Donation Scheduling");
        dateLabel = new Label("Donation Date (yyyy-mm-dd): ");
        dateField = new TextField(10);
        timeLabel = new Label("Donation Time (hh:mm): ");
        timeField = new TextField(5);
        scheduleButton = new Button("Schedule Donation");

        // Donation History Section
        historyArea = new TextArea(5, 40);
        historyArea.setEditable(false);

        // Blood Bank Inventory Management Section
        inventoryLabel = new Label("Blood Bank Inventory");
        bloodTypeInventoryLabel = new Label("Blood Type: ");
        bloodTypeInventoryField = new TextField(5);
        updateInventoryButton = new Button("Update Inventory");

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(bloodTypeLabel);
        add(bloodTypeChoice);
        add(registerButton);

        add(scheduleLabel);
        add(dateLabel);
        add(dateField);
        add(timeLabel);
        add(timeField);
        add(scheduleButton);

        add(inventoryLabel);
        add(bloodTypeInventoryLabel);
        add(bloodTypeInventoryField);
        add(updateInventoryButton);

        add(new Label("Donation History:"));
        add(historyArea);

        // Set up event listeners for buttons
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String bloodType = bloodTypeChoice.getSelectedItem();
                
                if (name.isEmpty() || age.isEmpty()) {
                    showMessage("Please fill in all fields.");
                } else {
                    showMessage("Donor Registered: " + name + ", " + age + " years, Blood Type: " + bloodType);
                    nameField.setText("");
                    ageField.setText("");
                }
            }
        });

        scheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String time = timeField.getText();

                if (date.isEmpty() || time.isEmpty()) {
                    showMessage("Please select a date and time for donation.");
                } else {
                    showMessage("Donation Scheduled for " + date + " at " + time);
                    dateField.setText("");
                    timeField.setText("");
                }
            }
        });

        updateInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bloodType = bloodTypeInventoryField.getText();
                if (bloodType.isEmpty()) {
                    showMessage("Please enter a blood type to update inventory.");
                } else {
                    showMessage("Inventory updated for blood type: " + bloodType);
                    bloodTypeInventoryField.setText("");
                }
            }
        });

        // Close the frame when the window is closed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Method to display messages
    private void showMessage(String message) {
        historyArea.append(message + "\n");
    }

    public static void main(String[] args) {
        new BloodDonationManagementSystem();
    }
}
