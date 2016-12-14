import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Withdrawl extends javax.swing.JFrame {
    String uID,uID1;
    String tF;
    String balance,al;
    int b;
    static int nb,cash;
    static String accno;
   
    public Withdrawl() {
        initComponents();
        getContentPane().setBackground(Color.ORANGE);
                
    }
   
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        tF1 = new javax.swing.JTextField();
        jB1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Enter The Amount To Be Withdrawn");

        jB1.setText("Confirm");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jB1ActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Withdrawl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jB1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(tF1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(tF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jB1)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }  

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {//GEN-FIRST:event_jB1ActionPerformed
        uID=LoginPage.tf;
        
        String UniqueId = null;
        Connection Con;
        nb=0;
        Statement Stmt;
        Statement Stmt2;
        ResultSet ERs;
         
        try
        {
            
             
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","system","mayank");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            Stmt=Con.createStatement();
            ERs=Stmt.executeQuery("Select * from ATM");
            Stmt2=Con.createStatement();
           
            while(ERs.next())
            {
                UniqueId=ERs.getString("UNIQUEID");
                balance=ERs.getString("BALANCE");
                accno=ERs.getString("ACCNO");
                 b=Integer.parseInt(balance);
                 cash=Integer.parseInt(tF1.getText());
                
                 if(UniqueId.equals(uID)){
         
                    
                    break;
                    
                }
            }
             
            if(cash<(b-1000))
            {
                nb=(b-cash);
                
                String k=Integer.toString(nb);
                if(!OptionPage.b2){
                    
                new AskReceipt().setVisible(true);
                this.dispose();
                String u="update ATM set BALANCE="+nb+" where UNIQUEID='"+uID+"'";
                Stmt2.executeUpdate(u);
                }
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
     
     
    }
    public static void main(String args[]) throws InterruptedException {
        
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
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new Withdrawl().setVisible(true);
            }
        });
        
    }

   
    private javax.swing.JButton jB1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tF1;
   
}
