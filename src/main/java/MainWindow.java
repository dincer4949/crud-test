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
            tArea.append("Header " + i + ": " + header +"\nDate: "+ date + "\nContext: "+context+"\n\n\n");
        }
    }
    public static void start(){
        JFrame f = new JFrame("MainWindow");

        tArea.setBounds(10, 10, 1160, 580); // set the bounds of the textarea
        JScrollPane scrollPane = new JScrollPane(tArea); // create a scrollpane with the textarea
        scrollPane.setBounds(10, 10, 1160, 580); // set the bounds of the scrollpane

        setDataBtn.setBounds(60,620, 150,50);
        refreshBtn.setBounds(250,620, 150,50);

        writeData();

        setDataBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetDataWindow.SetDataStart();
            }
        });

        refreshBtn.addActionListener(new ActionListener() {  /////////////////////    do the update shit
            @Override
            public void actionPerformed(ActionEvent e) {

                tArea.append("");
                writeData();
            }
        });

        tArea.setEditable(false);

        f.add(scrollPane); // add the scrollpane to the frame
        f.add(setDataBtn);
        f.add(refreshBtn);
        f.setSize(1280,720);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
