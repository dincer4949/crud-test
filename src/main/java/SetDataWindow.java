import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class SetDataWindow {

    public static void SetDataStart(){
        JFrame f = new JFrame("Set Data");
        //JTextArea tArea = new JTextArea();
        JTextArea tfHeader,tfContext,tfDate;
        JLabel hdr,cntxt,date;
        hdr = new JLabel("Enter a header");
        cntxt = new JLabel("Enter a context");
        date = new JLabel("Enter a date");
        tfHeader = new JTextArea();
        tfContext = new JTextArea();
        tfDate = new JTextArea();
        JButton setDataBtn= new JButton("Set data");
        DbData db = new DbData();

        hdr.setBounds(60,10,150,50);
        tfHeader.setBounds(55,50,460,40);

        cntxt.setBounds(60,75,150,50);
        tfContext.setBounds(60,115,460,300);




        f.setVisible(true);
        f.add(hdr);
        f.add(cntxt);
        f.add(tfHeader);
        f.add(tfContext);
        f.add(tfDate);
        f.setSize(640,720);
    }
}
