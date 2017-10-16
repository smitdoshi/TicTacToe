/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author SMITDOSHI
 */
public class tictactoe extends javax.swing.JFrame {
    
    
// Constructor
    
    public tictactoe() {
        initComponents();
        addAction();
    }
    
    // Function that will give some win effect.Passing buttons to this function inorder to get the effects
    public void winEffect(JButton winBtn1,JButton winBtn2,JButton winBtn3){
        winBtn1.setBackground(Color.GREEN);
        winBtn2.setBackground(Color.GREEN);
        winBtn3.setBackground(Color.GREEN);
        
        winBtn1.setForeground(Color.WHITE);
        winBtn2.setForeground(Color.WHITE);
        winBtn3.setForeground(Color.WHITE);
        
        // Show this message on the top
        String winmsg = winBtn1.getText() + " Is the Winner"; // This will show X or O is winner
        jLabelWinMSG.setText(winmsg);
    }
    // Boolean Variable for determining the Win
    boolean win=false;
    // Logic to check the winner 
    public void getWinner(){
       
        // Check jButton1 is not empty and jbutton1 equals to X same as jbutton2 and jbutton3
        // Vertical ROW 1 Win Check
        if(!jButton1.getText().equals("")&&jButton1.getText().equals(jButton2.getText())&&
                jButton1.getText().equals(jButton3.getText())&& win==false)
        {
            winEffect(jButton1, jButton2, jButton3);
            win=true;
            //System.out.println("Win");
        }
        //Similarly Vertical ROW 2 Check
        if(!jButton4.getText().equals("")&&jButton4.getText().equals(jButton5.getText())&&
                jButton4.getText().equals(jButton6.getText())&& win==false)
        {
            winEffect(jButton4, jButton5, jButton6);
            win=true;
            //System.out.println("Win");
        }
        //Similarly Vertical ROW 3 Check
        if(!jButton7.getText().equals("")&&jButton7.getText().equals(jButton8.getText())&&
                jButton7.getText().equals(jButton9.getText())&& win==false)
        {
            winEffect(jButton7, jButton8, jButton9);
            win=true;
            //System.out.println("Win");
        }
        //Similarly Horizontal Col 1 Check
        if(!jButton1.getText().equals("")&&jButton1.getText().equals(jButton4.getText())&&
                jButton1.getText().equals(jButton7.getText())&& win==false)
        {
            winEffect(jButton1, jButton4, jButton7);
            win=true;
            //System.out.println("Win");
        }
        //Similarly Horizontal Col 2 Check
        if(!jButton2.getText().equals("")&&jButton2.getText().equals(jButton5.getText())&&
                jButton2.getText().equals(jButton8.getText())&& win==false)
        {
            winEffect(jButton2, jButton5, jButton8);
            win=true;
            //System.out.println("Win");
        }
        //Similarly Horizontal Col 3 Check
        if(!jButton3.getText().equals("")&&jButton3.getText().equals(jButton6.getText())&&
                jButton3.getText().equals(jButton9.getText())&& win==false)
        {
            winEffect(jButton3, jButton6, jButton9);
            win=true;
            //System.out.println("Win");
        }
        // Cross 1 Check
        if(!jButton1.getText().equals("")&&jButton1.getText().equals(jButton5.getText())&&
                jButton1.getText().equals(jButton9.getText())&& win==false)
        {
            winEffect(jButton1, jButton5, jButton9);
            win=true;
            //System.out.println("Win");
        }
        // Cross 2 Check
        if(!jButton3.getText().equals("")&&jButton3.getText().equals(jButton5.getText())&&
                jButton3.getText().equals(jButton7.getText())&& win==false)
        {
            winEffect(jButton3, jButton5, jButton7);
            win=true;
            //System.out.println("Win");
        }
        else if(allButtonTextLength()==9 && win==false){
            jLabelWinMSG.setText("Game Draw");
        }
        
    }
    
    // Function to Check if there is a draw
    public int allButtonTextLength(){
        // Check the lenght of the text on button
        String txt = "";
        // Component is helps for graphical representation
        Component[] comps = jPanel1.getComponents(); // jPanel1 contains all the buttons
        
        // For each loop
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton jbtn = (JButton)comp; //type cast comp to JButton
                txt = txt + jbtn.getText();
            }
        }
        return txt.length();
    }
    
    // Create a variable to display X and O
    int x_o = 0;
    
    public ActionListener createAction(JButton button){
        ActionListener actlist = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Below logic is get X chance then O chance as alternative
                System.out.println("Value of X_O:"+x_o);
                // Now let's check if the button text is empty then set Text
                if(button.getText().equals("")){
                    // If the button doesn't have text then set Text to X or O
                    if(((x_o%2)==0)&& win==false){
                        
                        button.setText("X");
                        // Add color to the text
                        button.setForeground(Color.BLUE);
                        // Display msg on the top who's turn next
                        jLabelWinMSG.setText("O TURN");
                        getWinner();
                        
                    }else if(((x_o%2)==1)&& win==false){
                        button.setText("O");
                        // similarly color to O
                        button.setForeground(Color.RED); 
                        // Display msg on the top who's turn next
                        jLabelWinMSG.setText("X TURN");
                        getWinner();

                    }
                    // increment the value of x_0
                    x_o++; // if you don't increment this value you will only get X on the button
                }
                
            }
        };
        return actlist;
    }
    
    // Function that will place the above text when the button is clicked
    
    public void addAction(){
        // Component is helps for graphical representation
        Component[] comps = jPanel1.getComponents(); // jPanel1 contains all the buttons
        
        // For each loop
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton jbtn = (JButton)comp; //type cast comp to JButton
                jbtn.addActionListener(createAction(jbtn)); // call above function and pass
            }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelWinMSG = new javax.swing.JLabel();
        jButtonRestart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton2.setBorder(null);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton3.setBorder(null);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton4.setBorder(null);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton5.setBorder(null);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton6.setBorder(null);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton7.setBorder(null);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton8.setBorder(null);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton9.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jLabelWinMSG.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelWinMSG.setForeground(new java.awt.Color(255, 255, 255));
        jLabelWinMSG.setText("Play");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWinMSG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWinMSG, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonRestart.setBackground(new java.awt.Color(46, 203, 113));
        jButtonRestart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonRestart.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRestart.setText("Replay");
        jButtonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRestartActionPerformed
        // TODO add your handling code here:
        // Component is helps for graphical representation
        win=false;
        Component[] comps = jPanel1.getComponents(); // jPanel1 contains all the buttons
        
        // For each loop
        for(Component comp : comps){
            if(comp instanceof JButton){
                JButton jbtn = (JButton)comp; //type cast comp to JButton
                jbtn.setText("");
                jbtn.setBackground(Color.WHITE);
                jLabelWinMSG.setText("Play");
            }
        }
    }//GEN-LAST:event_jButtonRestartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tictactoe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonRestart;
    private javax.swing.JLabel jLabelWinMSG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
