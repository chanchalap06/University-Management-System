/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author ilaan
 */
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 class Splash extends JFrame {
    
 
    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
 
    public Splash() {
        super("Splash");
        setSize(404, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        img = new ImageIcon(ClassLoader.getSystemResource("project\\icons\\splash.jpg"));
         Image i2 = img.getImage().getScaledInstance(404, 310,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        imglabel = new JLabel(i3);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, 404, 310);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 290, 404, 20);
 
        Thread t = new Thread() {
 
            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i+=20;
                }
            }
        };
        t.start();
    }
}
public class first{
public static void main(String[] args) throws InterruptedException {

        Splash s=new Splash();
        s.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(1500);
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                //opening the main application
                 new Project().setVisible(true);
            }
            
            
        });
    }

}


