
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LoginPage extends javax.swing.JFrame implements ActionListener {
    Timer t;
    String pf;
    public static String tf, n, balance, accno;
    ResultSet res;
    int i = 0;

    public LoginPage() {
        initComponents();
        getContentPane().setBackground(java.awt.Color.ORANGE);
         t=new Timer(20000,this);
        t.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        t.stop();
        this.dispose();
        //System.exit(0);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl1 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        jtf1 = new javax.swing.JTextField();
        jpf = new javax.swing.JPasswordField();
        jl3 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To United Bank");
        setResizable(false);

        jl1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jl1.setText("UNIQUE ID");

        jl2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jl2.setText("PIN");

        jtf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf1ActionPerformed(evt);
            }
        });

        jpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfActionPerformed(evt);
            }
        });

        jl3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jl3.setText("Enter Your UniqueID and PIN");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl1)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jpf, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(jtf1)))
                            .addComponent(jl2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jl3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(ok)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jl3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl2))
                .addGap(50, 50, 50)
                .addComponent(ok)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf1ActionPerformed
        tf = jtf1.getText();
    }//GEN-LAST:event_jtf1ActionPerformed

    private void jpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfActionPerformed
        pf = jpf.getText();
    }//GEN-LAST:event_jpfActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        Connection con;
        ResultSet res;
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","system","mayank");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            Statement stmt = con.createStatement();
            res = stmt.executeQuery("select * from ATM");
            while (res.next()) {

                if (res.getString("UNIQUEID").equals(jtf1.getText()) && res.getString("PIN").equals(new String(jpf.getText()))) {
                    n = res.getString("NAME");
                    tf = res.getString("UNIQUEID");
                    balance = res.getString("BALANCE");
                    accno = res.getString("ACCNO");
                    new OptionPage().setVisible(true);
                    this.dispose();
                    i++;
                }
            }
            if (i == 0) {

                JOptionPane.showMessageDialog(rootPane, "Inavalid UNIQUEID or PIN");
                new FrontPage().setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Server Down");
            new FrontPage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_okActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jl3;
    private javax.swing.JPasswordField jpf;
    public javax.swing.JTextField jtf1;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
