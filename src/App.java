import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class App {
    public static void createTable() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DBConnection.getConnection(); Statement s = con.createStatement()) {
            String sql = "CREATE TABLE PAYSLIP(ID INT PRIMARY KEY ,NAME VARCHAR(100), WORKING_DAYS INT,DAILYWAGES DOUBLE,DEDUCTION DOUBLE,BONUS DOUBLE,TYPE VARCHAR(2),SALARY DOUBLE)";
            s.executeUpdate(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("Table already exists.");
        }
        return;
    }

    static void addRecord(int id, String name, int workingDays, double dailyWage, double deductions, double bonuses,
            String type, double salary) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DBConnection.getConnection(); Statement s = con.createStatement()) {
            name = "'" + name.toUpperCase() + "'";
            type = "'" + type.toUpperCase() + "'";
            String sql = "INSERT INTO PAYSLIP VALUES(" + id + ',' + name + ',' + workingDays + ',' + dailyWage + ','
                    + deductions + ',' + bonuses + ',' + type + "," + salary + ")";
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter valid data in all fields!");
        }
    }

    public static void updatedata(String attri, String newValue, int id) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DBConnection.getConnection();
                Statement s = con.createStatement()) {
            if (attri.equalsIgnoreCase("NAME") || attri.equalsIgnoreCase("TYPE")) {
                newValue = "'" + newValue.toUpperCase() + "'";
            }
            String sql = "UPDATE PAYSLIP SET " + attri + " = " + newValue + " WHERE ID = " + id;
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Table updated successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter valid data in all fields!");
        }
        return;
    }

    public static String[] generatePaySlipTEMPORARY(int id) throws ClassNotFoundException {
        return generatePaySlip(id, "'T'");
    }

    public static String[] generatePaySlipPERMANENT(int id) throws ClassNotFoundException {
        return generatePaySlip(id, "'P'");
    }

    private static String[] generatePaySlip(int id, String type) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DBConnection.getConnection(); Statement s = con.createStatement()) {
            String sql = "SELECT * FROM PAYSLIP WHERE id = " + id + " AND type = " + type;
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                return new String[] {
                        Integer.toString(r.getInt("ID")),
                        r.getString("NAME"),
                        Integer.toString(r.getInt("WORKING_DAYS")),
                        Double.toString(r.getDouble("DAILYWAGES")),
                        Double.toString(r.getDouble("DEDUCTION")),
                        Double.toString(r.getDouble("BONUS")),
                        r.getString("TYPE"),
                        Double.toString(r.getDouble("SALARY"))
                };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
