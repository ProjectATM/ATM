/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
import java.awt.*;
import static java.awt.Font.BOLD;
import javax.swing.*;
import static javax.swing.text.StyleConstants.Bold;
// static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrontPage {
    public static void main(String[] args) {
        JFrame jf=new JFrame("Welcome To The United Bank");
        jf.getContentPane().setBackground(Color.ORANGE );
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
        
        JButton jb1=new JButton("Continue....");
        jf.add(jb1);
        jb1.setBounds(250, 400, 100, 30);
        
        JLabel jl1=new JLabel("Welcome To United Bank");
        jl1.setFont(new Font("Arial", Font.BOLD, 30));
        jf.add(jl1);
        jl1.setForeground(Color.BLACK);
        jl1.setBounds(60, 200, 500, 30);
        //jl1.setText("Welcome To United Bank");
        
         JLabel jl2=new JLabel("Press Button To Continue...");
        jf.add(jl2);
        jl2.setForeground(Color.WHITE);
        jl2.setBounds(10, 400, 500, 30);
        
    }
    
}
