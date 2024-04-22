import javax.swing.*;
public class daWindow {

    public static void start(){
        JFrame w = new JFrame("test");
        JTextField header = new JTextField();
        DbData db = new DbData();
        w.setSize(400,400);
        w.add(header);

        for (int i = 0; i < 2; i++) {
            header.setText(db.getHeader(i));
        }

        w.isEnabled();
        w.setVisible(true);
    }

}
