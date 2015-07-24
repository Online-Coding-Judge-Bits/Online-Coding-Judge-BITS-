/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import javax.swing.JOptionPane;

/**
 *
 * @author vAibHav
 */
public class regScreen extends javax.swing.JFrame {

    /**
     * Creates new form TeamRegScreen
     */
    public regScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        teamName = new javax.swing.JTextField();
        mem1Contact = new javax.swing.JTextField();
        mem1Email = new javax.swing.JTextField();
        mem1Institute = new javax.swing.JTextField();
        mem2Name = new javax.swing.JTextField();
        mem2Contact = new javax.swing.JTextField();
        mem2Email = new javax.swing.JTextField();
        mem2Institute = new javax.swing.JTextField();
        mem1Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1366, 728));

        jPanel1.setPreferredSize(new java.awt.Dimension(1364, 703));
        jPanel1.setLayout(null);

        registerButton.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Register");
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(registerButton);
        registerButton.setBounds(600, 560, 160, 30);
        jPanel1.add(teamName);
        teamName.setBounds(580, 110, 200, 25);
        jPanel1.add(mem1Contact);
        mem1Contact.setBounds(400, 330, 150, 20);
        jPanel1.add(mem1Email);
        mem1Email.setBounds(400, 380, 150, 20);
        jPanel1.add(mem1Institute);
        mem1Institute.setBounds(400, 430, 150, 20);
        jPanel1.add(mem2Name);
        mem2Name.setBounds(880, 280, 150, 20);
        jPanel1.add(mem2Contact);
        mem2Contact.setBounds(880, 330, 150, 20);
        jPanel1.add(mem2Email);
        mem2Email.setBounds(880, 380, 150, 20);
        jPanel1.add(mem2Institute);
        mem2Institute.setBounds(880, 430, 150, 20);
        jPanel1.add(mem1Name);
        mem1Name.setBounds(400, 280, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/images/reg_screen.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1364, 703);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        String teamname = teamName.getText();
        String mem1name = mem1Name.getText();
        String mem1contact = mem1Contact.getText();
        String mem1email = mem1Email.getText();
        String mem1institute = mem1Institute.getText();
        String mem2name = mem2Name.getText();
        String mem2contact = mem2Contact.getText();
        String mem2email = mem2Email.getText();
        String mem2institute = mem2Institute.getText();
        
        //System.out.println(mem2name);
        if(teamname.equals("")){
            String str = "Please Enter Teamname!";
            JOptionPane.showMessageDialog(null, str);
        }
        else if(mem1name.equals("") || mem1contact.equals("") || mem1email.equals("") || mem1institute.equals("")){
            String str = "Please Fill All The Details Of A Member";
            JOptionPane.showMessageDialog(null, str);
        }
        else{
            user user1 = new user(teamname,mem1name,mem1email,mem1contact,mem1institute);
            
            user1.makeConnection();
            boolean valid = user1.checkTeamname();
            if(valid){
                boolean validUser1 = user1.addUser();//for successfull add user
                boolean validTeam =user1.addTeam();//for successfull add team
                //System.out.println(teamname);
                if(!mem2name.equals("") ){
                    //if member two exists
                    user user2 = new user(teamname,mem2name,mem2email,mem2contact,mem2institute);
                    user2.makeConnection();
                    boolean validUser2 = user2.addUser();
                }
                
                if(validUser1 && validTeam){
                    String str = "Registration Successfull";
                    JOptionPane.showMessageDialog(null, str);
                    loginScreenAlternative lsa = new loginScreenAlternative();
                    lsa.setLocation(0, 0);
                    lsa.setVisible(true);
                    setVisible(false);
                    
                }
                else{
                    String str = "Error Occured! Please Try With Different Teamname!";
                    JOptionPane.showMessageDialog(null, str);
                }
            }
            else{
                String str = "Teamname Exists!";
                JOptionPane.showMessageDialog(null, str);
            }
        }
        
        
        
        /*loginScreenAlternative lsa = new loginScreenAlternative();
        lsa.setLocation(0, 0);
        lsa.setVisible(true);

        setVisible(false);*/
    }//GEN-LAST:event_registerButtonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(regScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mem1Contact;
    private javax.swing.JTextField mem1Email;
    private javax.swing.JTextField mem1Institute;
    private javax.swing.JTextField mem1Name;
    private javax.swing.JTextField mem2Contact;
    private javax.swing.JTextField mem2Email;
    private javax.swing.JTextField mem2Institute;
    private javax.swing.JTextField mem2Name;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField teamName;
    // End of variables declaration//GEN-END:variables
}
