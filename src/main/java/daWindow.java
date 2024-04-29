import javax.swing.*;
import java.util.ArrayList;

public class daWindow {

    public static void start(){
        JFrame w = new JFrame("test");
        JTextArea tArea = new JTextArea();
        DbData db = new DbData();
        w.setSize(400,400);

        for (int i = 0; i < db.getHeaderListSize(); i++) {
            String header = db.getHeader(i);
            tArea.append("Header " + i + ": " + header + "\n");
        }
        tArea.setEditable(false);

        w.add(tArea);
        w.isEnabled();
        w.setVisible(true);
    }

}
