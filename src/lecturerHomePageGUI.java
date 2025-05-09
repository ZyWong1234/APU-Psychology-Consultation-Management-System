
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author zhiyo
 */
public class lecturerHomePageGUI extends javax.swing.JFrame {
    private final String lecturerID;
    /**
     * Creates new form lecturerHomePageGUI
     * @param userID
     * @param username
     * @param userTypes
     */
    public lecturerHomePageGUI(String userID, String username, String userTypes) {
        initComponents();
        this.lecturerID = userID;
        
        setTitle("APU Psychology Consultation Management System ---" + userID + " (" + userTypes + ")");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int logOut = JOptionPane.showConfirmDialog(null, "Log Out?", "Log Out", JOptionPane.YES_NO_OPTION);
                if (logOut == JOptionPane.YES_OPTION) {
                    Login login = new Login(); //when log out, it will navigate back to login page
                    login.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelled Log Out. Go back to Home Page......", "Log Out Cancellation", JOptionPane.OK_OPTION);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        consultationSlotsLabel = new javax.swing.JLabel();
        appointmentLabel = new javax.swing.JLabel();
        rescheduleLabel = new javax.swing.JLabel();
        consultationFeedbackLabel = new javax.swing.JLabel();
        studentFeedbackLabel = new javax.swing.JLabel();
        consultationSlotsButton = new javax.swing.JButton();
        viewAppointmentsButton = new javax.swing.JButton();
        rescheduleButton = new javax.swing.JButton();
        consultationFeedbackButton = new javax.swing.JButton();
        studentFeedbackButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        titleLabel.setText("APU Psychology Consultation Management System --- LECTURE");
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        consultationSlotsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consultationSlotsLabel.setForeground(new java.awt.Color(255, 255, 0));
        consultationSlotsLabel.setText("Manage Consultation Slots");
        getContentPane().add(consultationSlotsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 180, -1, -1));

        appointmentLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        appointmentLabel.setForeground(new java.awt.Color(255, 255, 0));
        appointmentLabel.setText("View Upcoming and Past Appointments");
        getContentPane().add(appointmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 232, -1, -1));

        rescheduleLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rescheduleLabel.setForeground(new java.awt.Color(255, 255, 0));
        rescheduleLabel.setText("Rescheduling Request");
        getContentPane().add(rescheduleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 284, -1, -1));

        consultationFeedbackLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consultationFeedbackLabel.setForeground(new java.awt.Color(255, 255, 0));
        consultationFeedbackLabel.setText("Consultation Feedback");
        getContentPane().add(consultationFeedbackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 336, -1, -1));

        studentFeedbackLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentFeedbackLabel.setForeground(new java.awt.Color(255, 255, 0));
        studentFeedbackLabel.setText("Student Feedback");
        getContentPane().add(studentFeedbackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 388, -1, -1));

        consultationSlotsButton.setText("Consultation Slots");
        consultationSlotsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultationSlotsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationSlotsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(consultationSlotsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 177, 142, -1));

        viewAppointmentsButton.setText("View Appointments");
        viewAppointmentsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewAppointmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppointmentsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewAppointmentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 229, 142, -1));

        rescheduleButton.setText("Reschedule");
        rescheduleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rescheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescheduleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rescheduleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 281, 142, -1));

        consultationFeedbackButton.setText("Consultation");
        consultationFeedbackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultationFeedbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationFeedbackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(consultationFeedbackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 333, 142, -1));

        studentFeedbackButton.setText("Feedback");
        studentFeedbackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentFeedbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentFeedbackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentFeedbackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 385, 142, -1));

        logOutButton.setText("Log Out");
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background home page.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultationSlotsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationSlotsButtonActionPerformed
        // TODO add your handling code here:
        consultationSlots consultationSlots = new consultationSlots(lecturerID); //navigate to the consultationSlots page
        
        String fileName = lecturerID + "availableSlots.txt";
        consultationSlots.loadSlots(fileName); //read the available slots data from the file
        consultationSlots.setVisible(true);
    }//GEN-LAST:event_consultationSlotsButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
        int logOut = JOptionPane.showConfirmDialog(null, "Log Out?", "Log Out", JOptionPane.YES_NO_OPTION);
        
        if (logOut == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true); 
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(null, "Cancelled Log Out. Go back to Home Page......", "Log Out Cancellation", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void viewAppointmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppointmentsButtonActionPerformed
        // TODO add your handling code here:
        viewAppointments viewAppointments = new viewAppointments(lecturerID); //navigate to the viewAppointments page
        viewAppointments.setVisible(true);
    }//GEN-LAST:event_viewAppointmentsButtonActionPerformed

    private void rescheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescheduleButtonActionPerformed
        // TODO add your handling code here:
        rescheduleRequest rescheduleRequest = new rescheduleRequest(lecturerID); //navigate to the rescheduleRequest page
        rescheduleRequest.setVisible(true);
    }//GEN-LAST:event_rescheduleButtonActionPerformed

    private void consultationFeedbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationFeedbackButtonActionPerformed
        // TODO add your handling code here:
        consultationFeedback consultationFeedback = new consultationFeedback(lecturerID); //navigate to the consultationFeedback page
        consultationFeedback.setVisible(true);
    }//GEN-LAST:event_consultationFeedbackButtonActionPerformed

    private void studentFeedbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentFeedbackButtonActionPerformed
        // TODO add your handling code here:
        viewStudentFeedback viewStudentFeedback = new viewStudentFeedback(lecturerID); //navigate to the studentFeedback page
        viewStudentFeedback.setVisible(true);
    }//GEN-LAST:event_studentFeedbackButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentLabel;
    private javax.swing.JLabel background;
    private javax.swing.JButton consultationFeedbackButton;
    private javax.swing.JLabel consultationFeedbackLabel;
    private javax.swing.JButton consultationSlotsButton;
    private javax.swing.JLabel consultationSlotsLabel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton rescheduleButton;
    private javax.swing.JLabel rescheduleLabel;
    private javax.swing.JButton studentFeedbackButton;
    private javax.swing.JLabel studentFeedbackLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton viewAppointmentsButton;
    // End of variables declaration//GEN-END:variables
}
