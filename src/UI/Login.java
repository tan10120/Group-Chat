package UI;

import Auth.User;
import UI.SignUP;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        MainLabel = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        LoginBTN = new javax.swing.JButton();
        resultLBL = new javax.swing.JLabel();
        SignUPBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChitChat - Login");
        setBounds(new java.awt.Rectangle(0, 0, 400, 400));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 800));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setForeground(new java.awt.Color(102, 102, 102));
        MainPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        MainPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        MainLabel.setBackground(new java.awt.Color(255, 255, 255));
        MainLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        MainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainLabel.setText("Login");
        MainLabel.setToolTipText("");
        MainLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        emailTF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        emailTF.setForeground(new java.awt.Color(51, 51, 51));
        emailTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        emailTF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailTF.setSelectionColor(new java.awt.Color(204, 102, 0));

        passwordTF.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        passwordTF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        LoginBTN.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LoginBTN.setForeground(new java.awt.Color(102, 102, 102));
        LoginBTN.setText("Login");
        LoginBTN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        LoginBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBTNActionPerformed(evt);
            }
        });

        SignUPBTN.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SignUPBTN.setForeground(new java.awt.Color(102, 102, 102));
        SignUPBTN.setText("Sign Up");
        SignUPBTN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        SignUPBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUPBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUPBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(resultLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(SignUPBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTF, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(18, 18, 18))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignUPBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(resultLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBTNActionPerformed
        String email = emailTF.getText();
        String password = new String(passwordTF.getPassword());

        User user = new User("", email, password).authenticate();

        if (!"".equals(user.id)) {
            new Groups(user).setVisible(true);
            this.setVisible(false);
        } else {
            resultLBL.setText("UserID and password incorrect");
        }
    }//GEN-LAST:event_LoginBTNActionPerformed

    private void SignUPBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUPBTNActionPerformed
        new SignUP().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SignUPBTNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBTN;
    private javax.swing.JLabel MainLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton SignUPBTN;
    private javax.swing.JTextField emailTF;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JLabel resultLBL;
    // End of variables declaration//GEN-END:variables
}
