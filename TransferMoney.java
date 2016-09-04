

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class TransferMoney extends javax.swing.JFrame {
   String uID,uID1;
    String tF;
    String balance,balance1,al;
    int b,b1;
    static int nb,cash;
    static String accno;
    public TransferMoney() {
        initComponents();
        getContentPane().setBackground(Color.ORANGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtf = new javax.swing.JTextField();
        jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To United Bank");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Enter Amount To Be Transfer");

        jtf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfActionPerformed(evt);
            }
        });

        jb.setText("OK");
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jb)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jtf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jb)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfActionPerformed
       
    }//GEN-LAST:event_jtfActionPerformed

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        uID=LoginPage.tf;
        uID1=TransferPage.tf;
        String UniqueId = null,UniqueId1=null;
        Connection Con;
        nb=0;
        Statement Stmt;
        Statement Stmt2,Stmt3;
        ResultSet ERs,ERs1;
         
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","system","mayank");
            Stmt=Con.createStatement();
            ERs=Stmt.executeQuery("Select * from ATM");
            // ERs1=Stmt.executeQuery("Select * from ATM");
            Stmt2=Con.createStatement();
            Stmt3=Con.createStatement();
           
            while(ERs.next())
            {
                 UniqueId1=ERs.getString("UNIQUEID");
                UniqueId=ERs.getString("UNIQUEID");
                 if(UniqueId.equals(uID)){
                      UniqueId=ERs.getString("UNIQUEID");
                balance=ERs.getString("BALANCE");
                accno=ERs.getString("ACCNO");
                 b=Integer.parseInt(balance);
                 cash=Integer.parseInt(jtf.getText());
                }
                 if(UniqueId1.equals(uID1)){
                     UniqueId1=ERs.getString("UNIQUEID");
                balance1=ERs.getString("BALANCE");
                
                 b1=Integer.parseInt(balance1);
                 }
            }
           
            
             
            if(cash<(b-1000))
            {
                nb=(b-cash);
                new TransferringPage().setVisible(true);
                this.dispose();
                String u="update ATM set BALANCE="+nb+" where UNIQUEID='"+LoginPage.tf+"'";
                Stmt2.executeUpdate(u);
                String u1="update ATM set BALANCE="+(b1+cash)+" where UNIQUEID='"+uID1+"'";
                Stmt3.executeUpdate(u1);
                
            }
            else
            {
                 JOptionPane.showMessageDialog(rootPane,"Don't Have Sufficient Balance To Withdraw.");
                 new LoginPage().setVisible(true);
                 this.dispose();
            }
           
           
        }
        catch(Exception e)
        {System.out.println(e.getMessage());}
    }//GEN-LAST:event_jbActionPerformed

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
            java.util.logging.Logger.getLogger(TransferMoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferMoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferMoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferMoney.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferMoney().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jb;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables
}
