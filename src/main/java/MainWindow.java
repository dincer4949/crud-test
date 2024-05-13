import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MainWindow {
    public static JButton setDataBtn= new JButton("Set data");
    public static JButton refreshBtn= new JButton("Refresh Data");
    static JTextArea tArea = new JTextArea();
    static DbData db = new DbData();
    public static void writeData(){
        for (int i = 0; i < db.getHeaderListSize(); i++) {
            String header = db.getHeader(i);
            String context = db.getContext(i);
            Date date = db.getDate(i);
            tArea.append("Header " + i + ": " + header +"\nDate: "+ date + "\nContext: "+context+"\n ");
        }
    }
    public static void start(){
        JFrame f = new JFrame("MainWindow");

        tArea.setSize(800,300);
        setDataBtn.setBounds(60,600, 150,50);
        refreshBtn.setBounds(250,600, 150,50);
        writeData();

        setDataBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetDataWindow.SetDataStart();
            }
        });

        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.getData();
                writeData();
            }
        });


        tArea.setEditable(false);

        f.add(tArea);
        f.add(setDataBtn);
        f.add(refreshBtn);
        f.setSize(1280,720);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
