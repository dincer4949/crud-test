import javax.swing.*;
import java.util.ArrayList;

public class daWindow {

    public static void start(){
        JFrame w = new JFrame("test");
        JTextField header = new JTextField();
        DbData db = new DbData();
        w.setSize(400,400);
        w.add(header);

        ArrayList<String> headers = new ArrayList<String>();

        for (int i = 0; i < 2; i++) {
            headers.add(db.getHeader(i));
        }

        for(String h : headers){
            header.setText(h);
        }

        w.isEnabled();
        w.setVisible(true);
    }

}
