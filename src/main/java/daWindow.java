import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

public class daWindow {

    public static void start(){
        JFrame w = new JFrame("test");
        JTextArea tArea = new JTextArea();
        DbData db = new DbData();
        w.setSize(600,400);

        for (int i = 0; i < db.getHeaderListSize(); i++) {
            String header = db.getHeader(i);
            String context = db.getContext(i);
            Date date = db.getDate(i);
            tArea.append("Header " + i + ": " + header +" Date: "+ date + "\nContext: "+context+"\n ");
        }
        tArea.setEditable(false);

        w.add(tArea);
        w.isEnabled();
        w.setVisible(true);
    }

}
