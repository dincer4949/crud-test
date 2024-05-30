import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RemoveData {

       static DbData db = new DbData();
        public static void start() {

            JLabel id = new JLabel("Enter an ID to remove the whole with");
            JFrame f = new JFrame("Remove Data");
            JButton removeBtn = new JButton("Remove");
            JTextPane tpId = new JTextPane();

            id.setBounds(60,540,250,50);
            tpId.setBounds(55,580,150,20);
            id.setLabelFor(tpId);

            removeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    db.removeAllData(Integer.valueOf(tpId.getText()));
                }
            });

            f.setVisible(true);
            f.add(removeBtn);
            f.setSize(640, 720);
            f.setLayout(null);
        }
}
