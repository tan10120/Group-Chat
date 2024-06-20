package UI;

import Auth.User;
import java.awt.Dimension;
import java.awt.Toolkit;
import utility.Group;
import java.net.*;
import java.io.*;
import java.sql.*;

public class Messages extends javax.swing.JFrame {

    public User user;
    public Group group;

    private User[] users;

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Messages(User user, Group group, Socket socket) {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        jFrame1.setBounds(dim.width / 2 - jFrame1.getSize().width / 2, dim.height / 2 - jFrame1.getSize().height / 2, 300, 400);

        this.user = user;
        this.group = group;

        this.socket = socket;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chitchat", "root", "root");
            Statement stmt = con.createStatement();
            String query = "SELECT admin FROM rooms WHERE id = '" + group.id + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("admin").equals(user.id)) {
                    addMemberBTN.setEnabled(true);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        users = new User().getUsers(user.id, group.id);

        String[] listData = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            listData[i] = users[i].name;
        }
        usersLST.setListData(listData);
        curGroupLBL.setText(user.name + ", " + group.name);

        try {
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            bufferedWriter.write(user.name);
            bufferedWriter.newLine();
            bufferedWriter.write(group.id);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            listenForMessage();
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    public Messages(Socket socket) {

    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedwriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sendMessage() {
        try {

            String msgToSend = messageTF.getText();

            bufferedWriter.write(user.name + " : " + msgToSend);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException ex) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroup;
                while (socket.isConnected()) {
                    try {
                        msgFromGroup = bufferedReader.readLine();
                        chatTA.append(msgFromGroup + "\n");
                    } catch (IOException ex) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }
        ).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersLST = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        curGroupLBL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTA = new javax.swing.JTextArea();
        sendBTN = new javax.swing.JButton();
        messageTF = new javax.swing.JTextField();
        addMemberBTN = new javax.swing.JButton();

        usersLST.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        usersLST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersLSTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(usersLST);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChitChat - Messages");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        curGroupLBL.setText("jLabel1");
        curGroupLBL.setMaximumSize(new java.awt.Dimension(1920, 1080));
        curGroupLBL.setMinimumSize(new java.awt.Dimension(800, 400));
        curGroupLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                curGroupLBLMouseClicked(evt);
            }
        });

        chatTA.setEditable(false);
        chatTA.setColumns(20);
        chatTA.setRows(5);
        jScrollPane1.setViewportView(chatTA);

        sendBTN.setText("Send");
        sendBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBTNActionPerformed(evt);
            }
        });

        messageTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageTFKeyPressed(evt);
            }
        });

        addMemberBTN.setText("Add Member");
        addMemberBTN.setEnabled(false);
        addMemberBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(curGroupLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(addMemberBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(messageTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendBTN)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curGroupLBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMemberBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendBTN)
                    .addComponent(messageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void sendBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBTNActionPerformed
        if (!messageTF.getText().trim().equals("")) {
            sendMessage();
            chatTA.append("You : " + messageTF.getText() + "\n");
            messageTF.setText("");
        }
    }//GEN-LAST:event_sendBTNActionPerformed

    private void addMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberBTNActionPerformed
        jFrame1.setVisible(true);
    }//GEN-LAST:event_addMemberBTNActionPerformed

    private void usersLSTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersLSTMouseClicked
        try {
            User selUser = users[usersLST.getSelectedIndex()];
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chitchat", "root", "root");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO members(userid, groupid, groupname) VALUES('" + selUser.id + "','" + group.id + "','" + group.name + "')";

            stmt.executeUpdate(query);

            chatTA.append(selUser.name + " Added to " + group.name + "\n");

        } catch (Exception ex) {
            chatTA.append("Already Exists \n");
        }

        jFrame1.setVisible(false);
    }//GEN-LAST:event_usersLSTMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void messageTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTFKeyPressed
        int keyCode = evt.getKeyCode();
        if (keyCode == 10) {
            sendBTN.doClick();
        }
    }//GEN-LAST:event_messageTFKeyPressed

    private void curGroupLBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_curGroupLBLMouseClicked
        new Groups(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_curGroupLBLMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberBTN;
    public static javax.swing.JTextArea chatTA;
    private javax.swing.JLabel curGroupLBL;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextField messageTF;
    private javax.swing.JButton sendBTN;
    private javax.swing.JList<String> usersLST;
    // End of variables declaration//GEN-END:variables
}
