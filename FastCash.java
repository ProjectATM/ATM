
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FastCash extends javax.swing.JFrame {
    static String accno;
    String c=null,balance;
    static int nb,cash;
    int b,i=0;
    public FastCash() {
        initComponents();
        getContentPane().setBackground(Color.ORANGE);
        ButtonGroup bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jrb1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jrb2 = new javax.swing.JRadioButton();
        jrb3 = new javax.swing.JRadioButton();
        jrb4 = new javax.swing.JRadioButton();
        jbok = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To United Bank");
        setResizable(false);

        jrb1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jrb1.setText("500");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Choose any one option.........");

        jrb2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jrb2.setText("1000");

        jrb3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jrb3.setText("5000");

        jrb4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jrb4.setText("10000");

        jbok.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbok.setText("OK");
        jbok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb3)
                    .addComponent(jrb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb4)
                    .addComponent(jrb2))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jbok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb1)
                    .addComponent(jrb2))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb3)
                    .addComponent(jrb4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jbok, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbokActionPerformed
       if(jrb1.isSelected()){
           c=jrb1.getText();
           i++;
           System.out.println(jrb1.isSelected());
       }
        if(jrb2.isSelected()){
           c=jrb2.getText();
           i++;
           System.out.println(jrb2.isSelected());
       }
         if(jrb3.isSelected()){
           c=jrb3.getText();
           i++;
           System.out.println(jrb3.isSelected());
       }
          if(jrb4.isSelected()){
           c=jrb4.getText();
           i++;
           System.out.println(jrb4.isSelected());
       }
          if(i==0){
              JOptionPane.showMessageDialog(rootPane,"Choose atleast one option.");
              new FastCash().setVisible(true);
              this.dispose();
          }
          if(i==1){
        new AskReceipt().setVisible(true);
        this.dispose();
        String UniqueId = null;
        String name = null;
        Connection Con;
        String pin;
        
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
                name=ERs.getString("NAME");             
                pin=ERs.getString("PIN");
                balance=ERs.getString("BALANCE");
                accno=ERs.getString("ACCNO");
                 b=Integer.parseInt(balance);
                 cash=Integer.parseInt(c);
                
                 if(UniqueId.equals(LoginPage.tf)){
         
                    
                    break;
                    
                }
            }
            if(cash<(b-1000))
            {
                nb=(b-cash);
                
                String k=Integer.toString(nb);
                
                String u="update ATM set BALANCE="+nb+" where UNIQUEID='"+LoginPage.tf+"'";
                Stmt2.executeUpdate(u);
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
    }//GEN-LAST:event_jbokActionPerformed
    }

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
            java.util.logging.Logger.getLogger(FastCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FastCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FastCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FastCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FastCash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JButton jbok;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JRadioButton jrb4;
    // End of variables declaration//GEN-END:variables
}
