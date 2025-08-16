import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfdob, tfaddress, tfphone, tfemail, tfsscgpa, tfhscgpa, tfnid, tfcourse;
    JLabel lablelempID, lbladdress, lblphone, lblemail, lblsscgpa, lblhscgpa, lblnid, lblcourse, lblBatch;
    JComboBox cbcourse, cbbatch;
    JButton submit, cancel;

    Random ran = new Random();// For Generating random Number
    long first4 = Math.abs(ran.nextLong() % 9000L) + 1000L; // Generates a number between 1000 and 9999

    AddTeacher() {
        setSize(900, 700);
        setLocation(500, 250);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(290, 10, 480, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblempID = new JLabel("Employee ID:");
        lblempID.setBounds(50, 200, 200, 30);
        lblempID.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblempID);

        lablelempID = new JLabel("921-" + first4);
        lablelempID.setBounds(210, 200, 200, 30);
        lablelempID.setFont(new Font("Arial", Font.BOLD, 20));
        add(lablelempID);

        JLabel lbldob = new JLabel("Date Of Birth:");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbldob);

        tfdob = new JTextField();
        tfdob.setBounds(600, 200, 150, 30);
        add(tfdob);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(400, 250, 200, 30);
        lbladdress.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(600, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(50, 250, 200, 30);
        lblphone.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("E-mail ID:");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblsscgpa = new JLabel("SSC GPA:");
        lblsscgpa.setBounds(50, 350, 200, 30);
        lblsscgpa.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblsscgpa);

        tfsscgpa = new JTextField();
        tfsscgpa.setBounds(600, 300, 150, 30);
        add(tfsscgpa);

        JLabel lblhscgpa = new JLabel("HSC GPA:");
        lblhscgpa.setBounds(400, 350, 200, 30);
        lblhscgpa.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblhscgpa);

        tfhscgpa = new JTextField();
        tfhscgpa.setBounds(600, 350, 150, 30);
        add(tfhscgpa);

        JLabel lblnid = new JLabel("NID No:");
        lblnid.setBounds(400, 300, 200, 30);
        lblnid.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 350, 150, 30);
        add(tfnid);

        JLabel lblcourse = new JLabel("Qualification:");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblcourse);

        String course[] = { "BSC Sofware Engineering", "CSE", "BBA", "Ethical Hacking", "MBA", "English(Hons)",
                "MSC Software Engineering", "EEE" };
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 155, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblBatch = new JLabel("Department:");
        lblBatch.setBounds(400, 400, 200, 30);
        lblBatch.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblBatch);

        String Batch[] = { "BSC Sofware Engineering", "CSE", "BBA", "Ethical Hacking", "MBA", "English(Hons)",
                "MSC Software Engineering", "EEE" };
        cbbatch = new JComboBox<>(Batch);
        cbbatch.setBounds(600, 400, 155, 30);
        cbbatch.setBackground(Color.WHITE);
        add(cbbatch);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = lablelempID.getText();
            String dob = tfdob.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String nid = tfnid.getText();
            String sscgpa = tfsscgpa.getText();
            String hscgpa = tfhscgpa.getText();
            String course = (String) cbcourse.getSelectedItem();
            String batch = (String) cbbatch.getSelectedItem();

            try {
                String query = "insert into teacher values('" + name + "','" + fname + "','" + rollno + "','" + dob
                        + "','" + address + "','" + phone + "','" + email + "','" + sscgpa + "','" + nid + "','"
                        + hscgpa + "','" + course + "','" + batch + "')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
