import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;

public class Gui {

    static JTextArea textArea;

    public static void add_TEMPORARY() {
        ImageIcon i = new ImageIcon("contractor.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        j.setVisible(true);
        j.setTitle("ADD TEMPORARY EMPLOYEE");
        j.setSize(450, 600);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label1 = new JLabel("Enter ID:");
        label1.setBounds(50, 50, 300, 30);
        panel.add(label1);

        JTextField F1 = new JTextField();
        F1.setBounds(50, 80, 300, 30);
        panel.add(F1);

        JLabel label2 = new JLabel("Enter Name:");
        label2.setBounds(50, 120, 300, 30);
        panel.add(label2);

        JTextField F2 = new JTextField();
        F2.setBounds(50, 150, 300, 30);
        panel.add(F2);

        JLabel label3 = new JLabel("Enter NO OF WORKING DAYS:");
        label3.setBounds(50, 190, 300, 30);
        panel.add(label3);

        JTextField F3 = new JTextField();
        F3.setBounds(50, 220, 300, 30);
        panel.add(F3);

        JLabel label4 = new JLabel("Enter DAILY WAGES (IN RS):");
        label4.setBounds(50, 260, 300, 30);
        panel.add(label4);

        JTextField F4 = new JTextField();
        F4.setBounds(50, 290, 300, 30);
        panel.add(F4);

        JLabel label5 = new JLabel("Enter DEDUCTION:");
        label5.setBounds(50, 330, 300, 30);
        panel.add(label5);

        JTextField F5 = new JTextField();
        F5.setBounds(50, 360, 300, 30);
        panel.add(F5);

        JLabel label6 = new JLabel("Enter BONUS:");
        label6.setBounds(50, 400, 300, 30);
        panel.add(label6);

        JTextField F6 = new JTextField();
        F6.setBounds(50, 430, 300, 30);
        panel.add(F6);

        CS C = new CS();
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(175, 470, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(F1.getText());
                String name = F2.getText();
                int workingDays = Integer.parseInt(F3.getText());
                double dailyWage = Double.parseDouble(F4.getText());
                double deductions = Double.parseDouble(F5.getText());
                double bonuses = Double.parseDouble(F6.getText());
                try {
                    C.addTEMPORARYEmployee(id, name, 0, workingDays, dailyWage, deductions, bonuses);
                } catch (ClassNotFoundException | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        panel.add(submitButton);

        j.add(panel);
    }

    public static void add_permanent() {
        ImageIcon i = new ImageIcon("Permanent.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        j.setVisible(true);
        j.setTitle("ADD PERMANENT EMPLOYEE");
        j.setSize(450, 550);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label1 = new JLabel("Enter ID:");
        label1.setBounds(50, 50, 300, 30);
        panel.add(label1);

        JTextField F1 = new JTextField();
        F1.setBounds(50, 80, 300, 30);
        panel.add(F1);

        JLabel label2 = new JLabel("Enter Name:");
        label2.setBounds(50, 120, 300, 30);
        panel.add(label2);

        JTextField F2 = new JTextField();
        F2.setBounds(50, 150, 300, 30);
        panel.add(F2);

        JLabel label3 = new JLabel("Enter SALARY (IN RS):");
        label3.setBounds(50, 190, 300, 30);
        panel.add(label3);

        JTextField F3 = new JTextField();
        F3.setBounds(50, 220, 300, 30);
        panel.add(F3);

        JLabel label4 = new JLabel("Enter DEDUCTION (IN RS):");
        label4.setBounds(50, 260, 300, 30);
        panel.add(label4);

        JTextField F4 = new JTextField();
        F4.setBounds(50, 290, 300, 30);
        panel.add(F4);

        JLabel label5 = new JLabel("Enter BONUS (IN RS):");
        label5.setBounds(50, 330, 300, 30);
        panel.add(label5);

        JTextField F5 = new JTextField();
        F5.setBounds(50, 360, 300, 30);
        panel.add(F5);

        CS C = new CS();
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(175, 400, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(F1.getText());
                String name = F2.getText();
                double salary = Double.parseDouble(F3.getText());
                double deductions = Double.parseDouble(F4.getText());
                double bonuses = Double.parseDouble(F5.getText());
                try {
                    C.addPERMANENTEmployee(id, name, salary, deductions, bonuses);
                } catch (ClassNotFoundException | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        panel.add(submitButton);

        j.add(panel);
    }

    public static void generatePaySlip_PERMANENT_Emply(int ID) {
        ImageIcon i = new ImageIcon("abc.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        j.setVisible(true);
        j.setTitle("GENERATE PAYSLIP FOR PERMANENT EMPLOYEE");
        j.setSize(450, 250);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        CS user = new CS();
        int id = ID;
        String[] data_PERMANENT = null;
        try {
            data_PERMANENT = App.generatePaySlipPERMANENT(id);
            new SalarySlip(
                    Integer.parseInt(data_PERMANENT[0]),
                    data_PERMANENT[1],
                    Integer.parseInt(data_PERMANENT[2]),
                    Double.parseDouble(data_PERMANENT[3]),
                    Double.parseDouble(data_PERMANENT[4]),
                    Double.parseDouble(data_PERMANENT[5]),
                    data_PERMANENT[6],
                    Double.parseDouble(data_PERMANENT[7]));
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        user.generatePaySlipPERMANENTEmployee(id, data_PERMANENT);
    }

    public static void generatePaySlip_TEMPORARY_Emply(int ID) {
        ImageIcon i = new ImageIcon("abc.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        j.setVisible(true);
        j.setTitle("GENERATE PAYSLIP FOR TEMPORARY EMPLOYEE");
        j.setSize(450, 250);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        CS user = new CS();
        int id = ID;
        String[] data_PERMANENT = null;
        try {
            data_PERMANENT = App.generatePaySlipTEMPORARY(id);
            new SalarySlip(
                    Integer.parseInt(data_PERMANENT[0]),
                    data_PERMANENT[1],
                    Integer.parseInt(data_PERMANENT[2]),
                    Double.parseDouble(data_PERMANENT[3]),
                    Double.parseDouble(data_PERMANENT[4]),
                    Double.parseDouble(data_PERMANENT[5]),
                    data_PERMANENT[6],
                    Double.parseDouble(data_PERMANENT[7]));
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        user.generatePaySlipTEMPORARYEmployee(id, data_PERMANENT);
    }

    public void update_payslip() {
        ImageIcon i = new ImageIcon("UPDATE.png");
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        j.setVisible(true);
        j.setTitle("UPDATE PAYSLIP");
        j.setSize(450, 250);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l = new JLabel("Enter Employee ID:");
        l.setBounds(50, 50, 300, 30);
        panel.add(l);

        JTextField F5 = new JTextField();
        F5.setBounds(50, 80, 300, 30);
        panel.add(F5);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(175, 120, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(F5.getText());
                JFrame updateFrame = new JFrame();
                JPanel updatePanel = new JPanel();
                updatePanel.setLayout(null);
                updateFrame.setVisible(true);
                updateFrame.setTitle("Update Fields");
                updateFrame.setSize(450, 350);
                updateFrame.setIconImage(i.getImage());
                updateFrame.setResizable(false);
                updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JLabel chooseField = new JLabel("Choose field to update:");
                chooseField.setBounds(50, 20, 300, 30);
                updatePanel.add(chooseField);

                JButton nameButton = new JButton("Update Name");
                nameButton.setBounds(50, 70, 150, 30);
                nameButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateField("NAME", id);
                    }
                });
                updatePanel.add(nameButton);

                JButton salaryButton = new JButton("Update Salary");
                salaryButton.setBounds(250, 70, 150, 30);
                salaryButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateField("SALARY", id);
                    }
                });
                updatePanel.add(salaryButton);

                JButton bonusButton = new JButton("Update Bonus");
                bonusButton.setBounds(50, 130, 150, 30);
                bonusButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateField("BONUS", id);
                    }
                });
                updatePanel.add(bonusButton);

                JButton deductionButton = new JButton("Update Deduction");
                deductionButton.setBounds(250, 130, 150, 30);
                deductionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateField("DEDUCTION", id);
                    }
                });
                updatePanel.add(deductionButton);

                updateFrame.add(updatePanel);
            }
        });

        panel.add(submitButton);
        j.add(panel);
    }

    private void updateField(String field, int id) {
        ImageIcon i = new ImageIcon("UPDATE.png");
        JFrame updateFrame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        updateFrame.setVisible(true);
        updateFrame.setTitle("Update " + field);
        updateFrame.setSize(450, 250);
        updateFrame.setIconImage(i.getImage());
        updateFrame.setResizable(false);
        updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Enter new " + field + ":");
        label.setBounds(50, 50, 300, 30);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(50, 80, 300, 30);
        panel.add(textField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(175, 120, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newValue = textField.getText();
                try {
                    App.updatedata(field, newValue, id);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                updateFrame.dispose();
            }
        });

        panel.add(submitButton);
        updateFrame.add(panel);
    }

    public static void showAllEmployees() {
        try {
            // Database Connection
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM payslip";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // Create a new frame to display the data
            JFrame dataFrame = new JFrame("All Employees");
            dataFrame.setSize(600, 400);
            dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dataFrame.setLayout(new BorderLayout());

            // Initialize textArea
            textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            textArea.setEditable(false);

            // Clear previous data
            textArea.setText("");

            // Fetch Data
            textArea.append("ID\tName\tSalary\tDesignation\n");
            textArea.append("-------------------------------------\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String type = rs.getString("type");

                textArea.append(id + "\t" + name + "\t" + salary + "\t" + type + "\n");
            }

            // Add textArea to a scroll pane
            JScrollPane scrollPane = new JScrollPane(textArea);
            dataFrame.add(scrollPane, BorderLayout.CENTER);

            // Close resources
            rs.close();
            pst.close();
            con.close();

            // Set visibility
            dataFrame.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }

    public static void admin() {
        // Create Frame
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout for better spacing

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20); // Top, Left, Bottom, Right padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Create Buttons
        JButton btnAddTemporary = createStyledButton("ADD TEMPORARY");
        JButton btnAddPermanent = createStyledButton("ADD PERMANENT");
        JButton btnShowAll = createStyledButton("SHOW ALL");
        JButton btnUpdate = createStyledButton("UPDATE DATA");
        JButton btnExit = createStyledButton("<EXIT>");

        // Add Action Listeners
        btnAddTemporary.addActionListener(_ -> add_TEMPORARY());
        btnAddPermanent.addActionListener(_ -> add_permanent());
        btnShowAll.addActionListener(_ -> showAllEmployees());
        btnUpdate.addActionListener(_ -> {
            Gui g = new Gui();
            g.update_payslip();
        });
        btnExit.addActionListener(_ -> frame.dispose());

        // Add Buttons to Frame
        gbc.gridy = 0;
        frame.add(btnAddTemporary, gbc);
        gbc.gridy = 1;
        frame.add(btnAddPermanent, gbc);
        gbc.gridy = 2;
        frame.add(btnShowAll, gbc);
        gbc.gridy = 3;
        frame.add(btnUpdate, gbc);
        gbc.gridy = 4;
        frame.add(btnExit, gbc);

        // Set Visibility
        frame.setVisible(true);
    }

    // Method to Create Styled Buttons
    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(250, 50)); // Set size
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Font style
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adds space inside button
        return button;
    }

    public void adminLogin() {
        JFrame adminFrame = new JFrame("Admin Login");
        adminFrame.setSize(400, 300);
        adminFrame.setLayout(null);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Labels and Fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 100, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 30);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 30);
        JTextField idField = new JTextField();
        idField.setBounds(150, 70, 200, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 110, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 200, 30);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(50, 160, 130, 40);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String id = idField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String type = "Admin"; // Default type

                if (name.isEmpty() || id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(adminFrame, "All fields must be filled!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Connection con = DBConnection.getConnection();
                    String query = "INSERT INTO login (name, id, password, type) VALUES (?, ?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, name);
                    pst.setString(2, id);
                    pst.setString(3, password);
                    pst.setString(4, type);

                    int rowsInserted = pst.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(adminFrame,
                                "Admin Signed Up Successfully!\nName: " + name + "\nID: " + id);
                    }

                    pst.close();
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(adminFrame, "Error: " + ex.getMessage(), "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton signinButton = new JButton("Sign In");
        signinButton.setBounds(220, 160, 130, 40);
        signinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(adminFrame, "ID and Password cannot be empty!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Connection con = DBConnection.getConnection();
                    String query = "SELECT * FROM login WHERE id = ? AND password = ? AND type = 'Admin'";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, id);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(adminFrame, "Admin Logged In Successfully!");
                        admin();
                    } else {
                        JOptionPane.showMessageDialog(adminFrame, "Invalid Credentials", "Login Failed",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    rs.close();
                    pst.close();
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(adminFrame, "Error: " + ex.getMessage(), "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding components to the frame
        adminFrame.add(nameLabel);
        adminFrame.add(nameField);
        adminFrame.add(idLabel);
        adminFrame.add(idField);
        adminFrame.add(passwordLabel);
        adminFrame.add(passwordField);
        adminFrame.add(signupButton);
        adminFrame.add(signinButton);

        adminFrame.setVisible(true);
    }

    public static void employee() {

    }

    public void employeeLogin() {
        // Create input fields
        JTextField nameField = new JTextField(10);
        JTextField idField = new JTextField(10);

        // Create a panel to hold the fields
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Enter your Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Enter your Employee ID:"));
        panel.add(idField);

        // Show input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Employee Login", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // If user cancels or enters invalid input
        if (result != JOptionPane.OK_OPTION || nameField.getText().trim().isEmpty()
                || idField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login Canceled or Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String empName = nameField.getText().trim();
        String empID = idField.getText().trim();

        try {
            // Database Connection
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM payslip WHERE id = ? AND name = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(empID)); // Convert ID to integer
            pst.setString(2, empName);

            ResultSet rs = pst.executeQuery();

            // Check if user exists
            if (rs.next()) {
                String empType = rs.getString("type"); // Get employee type
                JOptionPane.showMessageDialog(null, "Login Successful! Welcome " + empName, "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                // Create GUI for salary slip generation
                JFrame frame = new JFrame("Salary Slip Generation");
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new FlowLayout());

                JButton generateSalaryButton = new JButton("Generate Pay Salary");
                frame.add(generateSalaryButton);

                if ("T".equals(empType)) {
                    generateSalaryButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatePaySlip_TEMPORARY_Emply(Integer.parseInt(empID));
                            frame.dispose();
                        }
                    });
                } else if ("P".equals(empType)) {
                    generateSalaryButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatePaySlip_PERMANENT_Emply(Integer.parseInt(empID));
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown Employee Type", "Error", JOptionPane.ERROR_MESSAGE);
                }

                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials! Employee Not Found.", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Close connections
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Debugging
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Employee ID Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Failed to initialize LaF");
        }
        JFrame j = new JFrame();
        Gui g = new Gui();
        ImageIcon i = new ImageIcon("payslip.png");
        JLabel l = new JLabel();
        Font f = new Font("Times New Roman", Font.BOLD, 26);

        l.setFont(f);
        l.setVisible(true);
        l.setText("PAYSLIP GENERATOR");
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.TOP);
        l.setBounds(50, 20, 450, 50);
        j.add(l);

        JButton adminLogin = new JButton("ADMIN LOGIN");
        adminLogin.setBounds(115, 120, 300, 50);
        adminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.adminLogin();
            }
        });

        JButton employeeLogin = new JButton("EMPLOYEE LOGIN");
        employeeLogin.setBounds(115, 200, 300, 50);
        employeeLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.employeeLogin();
            }
        });

        JButton exitButton = new JButton("<EXIT>");
        exitButton.setBounds(210, 280, 100, 35);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        j.setVisible(true);
        j.setTitle("Payslip Generator");
        j.setSize(550, 400);
        j.setIconImage(i.getImage());
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        j.add(adminLogin);
        j.add(employeeLogin);
        j.add(exitButton);
    }
}