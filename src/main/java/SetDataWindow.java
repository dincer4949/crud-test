import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class SetDataWindow {

    public static void SetDataStart(){
        JFrame f = new JFrame("Set Data");
        JTextArea tArea = new JTextArea();
        JButton setDataBtn= new JButton("Set data");
        DbData db = new DbData();


        f.setVisible(true);
        f.setSize(640,720);
    }
}
