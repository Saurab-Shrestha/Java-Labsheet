import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CollegeRecord extends JFrame implements ActionListener {
    JMenuItem misave,mireset,miexit;
    JTextField fname,lname,age;
    JRadioButton rbmale,rbfemale;
    ButtonGroup group;
    JComboBox cbfaculty,cbsemester;
    JTextArea remarks;

    CollegeRecord(){
        setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Record");
        setSize(300,500);

        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu fm=new JMenu("File");
        mb.add(fm);
        misave=new JMenuItem("Save");
        misave.addActionListener(this);
        mireset=new JMenuItem("Reset");
        mireset.addActionListener(this);
        miexit=new JMenuItem("Exit");
        miexit.addActionListener(this);
        fm.add(misave);
        fm.add(mireset);
        fm.addSeparator();
        fm.add(miexit);

        JLabel lfname=new JLabel("First Name:");
        fname=new JTextField(15);
        add(lfname);
        add(fname);

        JLabel llname=new JLabel("Last Name:");
        lname=new JTextField(15);
        add(llname);
        add(lname);

        JLabel lage=new JLabel("Age:");
        age=new JTextField(15);
        add(lage);
        add(age);

        JLabel lgender=new JLabel("Gender:");
        rbmale=new JRadioButton("Male");
        rbfemale=new JRadioButton("Female");
        group=new ButtonGroup();
        group.add(rbmale);
        group.add(rbfemale);
        add(lgender);
        add(rbmale);
        add(rbfemale);

        JLabel lfaculty=new JLabel("Faculty:");
        String[] facultyList={"Bsc.csit","BBM","BIT","Engineering"};
        cbfaculty=new JComboBox(facultyList);
        add(lfaculty);
        add(cbfaculty);

        JLabel lsemester = new JLabel("Semester:");
        String[] semesterList ={"1st Semester","2nd Semester","3rd Semester",
                "4th Semester","5th Semester",
                "6th Semester","7th Semester","8th Semester"};
        cbsemester = new JComboBox(semesterList);
        add(lsemester);
        add(cbsemester);

        JLabel lremarks = new JLabel("Remarks:");
        remarks = new JTextArea("",10,20);
        add(lremarks);
        add(remarks);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==miexit) {
            System.exit(0);
        }
        else if(e.getSource()==misave) {
            try {
                saveRecord(getFieldValue());
            } catch (IOException err) {
                System.out.println(err);
            }
        }
        else
        {
            resetRecord();
        }
    }

    void resetRecord() {
        fname.setText("");
        lname.setText("");
        age.setText("");
        group.clearSelection();
        cbfaculty.setSelectedIndex(0);
        cbsemester.setSelectedIndex(0);
        remarks.setText("");
    }

    String[] getFieldValue() {
        rbmale.setActionCommand("Male");
        rbfemale.setActionCommand("Female");

        String[] text = {
                fname.getText(),
                lname.getText(),
                age.getText(),
                group.getSelection().getActionCommand(),
                (String)cbfaculty.getSelectedItem(),
                (String)cbsemester.getSelectedItem(),
                remarks.getText()
        };
        return text;
    }

    void saveRecord(String[] text) throws IOException {
        String userDir = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser(userDir+"/Desktop");
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        chooser.setSelectedFile(new File(".txt"));
        int result = chooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            PrintWriter out = null;
            try
            {
                out = new PrintWriter(file);
                for (int i=0; i<text.length; i++)
                {
                    out.print(text[i]+"\n");

                }
            }
            finally
            {
                out.close();
            }
        }
        else
            return;
    }

    public static void main(String args[]) {
        new CollegeRecord();
    }
}

