
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbatch;
    JLabel labelEmpId;
    JButton submit, cancel;
    Choice cEmpId;

    UpdateTeacher() {

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblempid = new JLabel("Select Employee ID");
        lblempid.setBounds(50, 100, 200, 20);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 20);
        add(cEmpId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblEmpId = new JLabel("Employee ID");
        lblEmpId.setBounds(50, 200, 200, 30);
        lblEmpId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmpId);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelEmpId);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblssc = new JLabel("SSC GPA");
        lblssc.setBounds(400, 300, 200, 30);
        lblssc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblssc);

        JLabel labelssc = new JLabel();
        labelssc.setBounds(600, 300, 150, 30);
        labelssc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelssc);

        JLabel lblhsc = new JLabel("HSC GPA");
        lblhsc.setBounds(50, 350, 200, 30);
        lblhsc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblhsc);

        JLabel labelhsc = new JLabel();
        labelhsc.setBounds(200, 350, 150, 30);
        labelhsc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelhsc);

        JLabel lblnid = new JLabel("NID");
        lblnid.setBounds(400, 350, 200, 30);
        lblnid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblnid);

        JLabel labelnid = new JLabel();
        labelnid.setBounds(600, 350, 150, 30);
        labelnid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelnid);

        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        JLabel lblbatch = new JLabel("Department");
        lblbatch.setBounds(400, 400, 200, 30);
        lblbatch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbatch);

        tfbatch = new JTextField();
        tfbatch.setBounds(600, 400, 150, 30);
        add(tfbatch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empId='" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelEmpId.setText(rs.getString("empId"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelnid.setText(rs.getString("nid"));
                labelssc.setText(rs.getString("sscgpa"));
                labelhsc.setText(rs.getString("hscgpa"));
                tfcourse.setText(rs.getString("education"));
                tfbatch.setText(rs.getString("department"));           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId='" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelssc.setText(rs.getString("ssc"));
                        labelhsc.setText(rs.getString("hsc"));
                        labelnid.setText(rs.getString("nid"));
                        labelEmpId.setText(rs.getString("empId"));
                        tfcourse.setText(rs.getString("education"));
                        tfbatch.setText(rs.getString("department"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String EmpId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String batch = tfbatch.getText();

            try {
                String query = "update teacher set address='" + address + "', phone='" + phone + "', email='" + email
                        + "', education='" + course + "', department='" + batch + "' where EmpId='" + EmpId + "'";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "teacher Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}