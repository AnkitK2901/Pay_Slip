import java.io.FileNotFoundException;
//import java.util.*;

import javax.swing.JOptionPane;

class Employee {
    public String name;
    public double salary;
    public double deduction;
    public double bonus;

    protected Employee(String name, double salary, double deduction, double bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.deduction = deduction;
    }
}

class PERMANENTEmployee extends Employee {
    public int id;

    public PERMANENTEmployee(int id, String name, double salary, double deduction, double bonus) {
        super(name, salary, deduction, bonus);
        this.id = id;
    }

    public void loadDataPERMANENT() throws ClassNotFoundException, FileNotFoundException {
        // new SalarySlip(id, name, 0, 0, deduction, bonus, "P", salary);
        App.addRecord(id, name, 0, 0, deduction, bonus, "P", salary);
    }
}

class TEMPORARYEmployee extends Employee {
    public int id;
    public int workDays;
    public double dailyWage;

    public TEMPORARYEmployee(int id, String name, double salary, int workDays, double deduction, double bonus,
            double dailyWage) {
        super(name, salary, deduction, bonus);
        this.id = id;
        this.workDays = workDays;
        this.dailyWage = dailyWage;
    }

    public void loadDataTEMPORARY() throws ClassNotFoundException, FileNotFoundException {
        // int id, String name, double salary, int workDays, double deduction, double
        // bonus, double dailyWage, String type
        // new SalarySlip(id, name, workDays, dailyWage, deduction, bonus, "T",
        // (workDays * dailyWage));
        App.addRecord(id, name, workDays, dailyWage, deduction, bonus, "T", (workDays * dailyWage));

    }
}

public class CS {

    public void addPERMANENTEmployee(int id, String name, double salary, double deductions, double bonuses)
            throws ClassNotFoundException, FileNotFoundException {
        PERMANENTEmployee temp = new PERMANENTEmployee(id, name, salary, deductions, bonuses);
        temp.loadDataPERMANENT();
    }

    public void addTEMPORARYEmployee(int id, String name, double salary, int workingDays, double dailyWage,
            double deductions, double bonuses) throws ClassNotFoundException, FileNotFoundException {
        TEMPORARYEmployee temp = new TEMPORARYEmployee(id, name, salary, workingDays, deductions, bonuses, dailyWage);
        temp.loadDataTEMPORARY();
    }

    public void generatePaySlipPERMANENTEmployee(int id, String[] data) {
        if (data == null) {
            JOptionPane.showMessageDialog(null, "PERMANENT employee with ID " + id + " not found.");
            return;
        }
        // double salary = Double.parseDouble(data[7]);
        // double deduction = Double.parseDouble(data[4]);
        // double bonus = Double.parseDouble(data[5]);
        // System.out.println(Arrays.toString(data));
        // String writeThis = "\n\n_____|/|/|/|:PAY SLIP:|/|/|/|_____\n" + "Pay Slip for
        // PERMANENT Employee:\n\n" + "Name: " + data[1] + "\n" + "ID: " + data[0] +
        // "\n" + "Salary: " + data[7] + "\n" + "Deduction: " + data[4] + "\n" + "Bonus:
        // " + data[5] + "\n" + "Employee Type: " + data[6] + "\n" + "Net Salary: " +
        // (salary - deduction + bonus) + "\n";

        // JOptionPane.showMessageDialog(null, writeThis);

    }

    public void generatePaySlipTEMPORARYEmployee(int id, String[] data) {
        if (data == null) {
            JOptionPane.showMessageDialog(null, "\nTEMPORARY employee with ID " + id + " not found.\n\n");
            return;
        }
        // double salary = Double.parseDouble(data[7]);
        // double deduction = Double.parseDouble(data[4]);
        // double bonus = Double.parseDouble(data[5]);

        // String writeThis = "\n\n_____|/|/|/|:PAY SLIP:|/|/|/|_____\n"+"Pay Slip for
        // TEMPORARY Employee:\n\n"+"\nName: " + data[1]+"\nID: " + data[0]+"\nSalary: "
        // + data[7]+"\nWorking Days: " + data[2]+"\nDaily Wage: " +
        // data[3]+"\nDeduction: "+ data[4]+"\nBonus: " + data[5]+"\nEmployee Type: " +
        // data[6]+"\nNet Salary: " + (salary - deduction + bonus) + "\n";
        // JOptionPane.showMessageDialog(null, writeThis);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        App.createTable();

    }
}