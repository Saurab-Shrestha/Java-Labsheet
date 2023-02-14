import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;

public class Notepad extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu fm,em,fom,vm,hm,smzoom;
    JMenuItem minew,miopen,misave,miprint,miexit,
            miundo,micut,micopy,mipaste,midelete,
            mifont,
            mizoomIn,mizoomOut,midefaultZoom,
            miviewhelp,mifeedback,miabout;
    JCheckBox mistatusBar,miwordWrap;
    JFileChooser openDialog,saveDialog;
    JTextArea textArea;

    public Notepad() {
        setSize(600,400);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Notepad");

        textArea=new JTextArea();
        add(textArea);

        mb=new JMenuBar();
        fm=new JMenu("File");
        em=new JMenu("Edit");
        fom=new JMenu("Format");
        vm=new JMenu("View");
        hm=new JMenu("Help");
        fm.setMnemonic('F');
        mb.add(fm);
        mb.add(em);
        mb.add(fom);
        mb.add(vm);
        mb.add(hm);

        minew=new JMenuItem("New");
        miopen=new JMenuItem("Open",'o');
        misave=new JMenuItem("Save");
        miprint=new JMenuItem("Print");
        miexit=new JMenuItem("Exit");
        fm.add(minew);
        fm.add(miopen);
        fm.add(misave);
        fm.addSeparator();
        fm.add(miprint);
        fm.addSeparator();
        fm.add(miexit);

        miundo=new JMenuItem("Undo");
        micut=new JMenuItem("Cut");
        micopy=new JMenuItem("Copy");
        mipaste=new JMenuItem("Paste");
        midelete=new JMenuItem("Delete");
        em.add(miundo);
        em.addSeparator();
        em.add(micut);
        em.add(micopy);
        em.add(mipaste);
        em.add(midelete);

        miwordWrap= new JCheckBox("Word Wrap");
        mifont=new JMenuItem("Font...");
        fom.add(miwordWrap);
        fom.add(mifont);

        smzoom=new JMenu("Zoom");
        vm.add(smzoom);
        mistatusBar=new JCheckBox("Status Bar");
        vm.add(mistatusBar);
        mistatusBar.setSelected(true);
        mistatusBar.setEnabled(false);
        mizoomIn=new JMenuItem("Zoom In");
        mizoomOut=new JMenuItem("Zoom Out");
        midefaultZoom=new JMenuItem("Default Zoom");
        smzoom.add(mizoomIn);
        smzoom.add(mizoomOut);
        smzoom.add(midefaultZoom);

        miviewhelp=new JMenuItem("View Help");
        mifeedback=new JMenuItem("Send Feedback");
        miabout=new JMenuItem("About");
        hm.add(miviewhelp);
        hm.add(mifeedback);
        hm.addSeparator();
        hm.add(miabout);

        setJMenuBar(mb);
        setVisible(true);

        miopen.addActionListener(this);
        misave.addActionListener(this);
        miabout.addActionListener(this);
        miexit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==miopen) {
            try {
                openFile();
            }
            catch(Exception err) {
                System.out.println(err);
            }
        }
        if(e.getSource()==misave) {
            String text=textArea.getText();
            try {
                saveFile(text);
            }
            catch(Exception err) {
                System.out.println(err);
            }
        }

        if(e.getSource()==miexit) {
            System.exit(0);
        }

        if(e.getSource()==miabout) {
            JDialog d =new JDialog(this,"About Us",true);
            JLabel l=new JLabel("<html>App name: Notepad<br/>Version: 1.0.0<br/>@2022 All Rights Reserved");
            d.add(l);
            d.setSize(400,300);
            d.setVisible(true);
        }
    }

    private void saveFile(String text) throws IOException{
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
                out.print(text);
            }
            finally
            {
                out.close();
            }
        }
        else
            return;
    }

    private void openFile() throws Exception{
        String userDir = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userDir+"/Desktop");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)","txt"));
        int result = fileChooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile =fileChooser.getSelectedFile();


            BufferedReader in = null;
            String fileName = selectedFile.getName();
            setTitle(fileName);

            try
            {
                in = new BufferedReader(new FileReader(selectedFile));
                StringBuilder sb = new StringBuilder();

                String line;
                while (true)
                {
                    line = in.readLine();
                    sb.append(line + "\n");
                    if (line==null)
                        break;
                    textArea.setText(sb.toString());
                }
            }
            finally
            {
                if (in!=null)
                    in.close();
            }
        }
    }

    public static void main(String args[]) {
        new Notepad();
    }
}