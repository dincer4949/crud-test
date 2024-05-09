import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MainWindow {
    public static JButton setDataBtn= new JButton("Set data");
    public static void start(){
        JFrame f = new JFrame("MainWindow");
        JTextArea tArea = new JTextArea();

        DbData db = new DbData();

        tArea.setSize(800,300);
        setDataBtn.setBounds(60,600, 150,50);

        setDataBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetDataWindow.SetDataStart();
            }
        });

        for (int i = 0; i < db.getHeaderListSize(); i++) {
            String header = db.getHeader(i);
            String context = db.getContext(i);
            Date date = db.getDate(i);
            tArea.append("Header " + i + ": " + header +" Date: "+ date + "\nContext: "+context+"\n ");
        }
        tArea.setEditable(false);

        f.add(tArea);
        f.add(setDataBtn);
        f.setSize(1280,720);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
