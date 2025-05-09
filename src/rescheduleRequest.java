
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author zhiyo
 */
public class rescheduleRequest extends javax.swing.JFrame {
    private final String lecturerID;

    /**
     * Creates new form rescheduleRequest
     * @param lecturerID
     */
    public rescheduleRequest(String lecturerID) {
        initComponents();
        this.lecturerID = lecturerID;
        
        setTitle("Rescheduling Request");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        loadTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rescheduleRequestLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rescheduleTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rescheduleRequestLabel.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        rescheduleRequestLabel.setText("Reschedule Request");
        getContentPane().add(rescheduleRequestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 35, -1, -1));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 56, -1));

        rescheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AppointmentID", "Original Date", "Original Time", "Reschedule Date", "Reschedule Time", "Student ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(rescheduleTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 72, 729, 398));

        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(approveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 209, -1, 37));

        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rejectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 258, 76, 37));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consultation slots background.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = rescheduleTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                    "Please select an reschedule request appointment to perform reject action.", 
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        DefaultTableModel rescheduleTableModel = (DefaultTableModel) rescheduleTable.getModel();
        
        String appointmentID = (String) rescheduleTableModel.getValueAt(selectedRow, 0);
        String studentID = (String) rescheduleTableModel.getValueAt(selectedRow, 5);

        // File to update
        File file = new File(lecturerID + "availableSlots.txt");
        List<String> updatedLines = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // Step 1: Read through the file and verify appointment status.
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 6) {
                        String appointmentIDInFile = parts[0].trim();
                        String date = parts[1].trim();
                        String fileStartTime = parts[2].trim();
                        String fileEndTime = parts[3].trim();
                        String studentInFile = parts[4].trim();
                        String status = parts[5].trim();

                        // If the selected appointment matches the one in the file, update its status
                        if (appointmentID.equals(appointmentIDInFile) && studentID.equals(studentInFile)) {
                            // Check the status of the appointment in the file
                            switch (status) {
                                case "original" ->                                     {
                                        //removed the original appointment from txt file
                                        continue;
                                    }
                                case "rescheduling" ->                                     {
                                        // Change status from "rescheduling" to "reschedule confirmed"
                                        String updatedRejectedLine = appointmentID + "," + date + "," 
                                                + fileStartTime + "," + fileEndTime + "," + studentInFile + ",rejected";
                                        updatedLines.add(updatedRejectedLine);
                                        System.out.println("Reschedule rejected for Appointment ID: " + appointmentIDInFile);  // Debugging
                                    }
                                default -> // Keep other statuses as they are
                                    updatedLines.add(line);
                            }
                        } else {
                            // If no match, retain the original line
                            updatedLines.add(line);
                        }
                    } else {
                        // Invalid line format, keep as it is
                        updatedLines.add(line);
                    }
                }

                // Step 2: Write back the updated content to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String updatedLine : updatedLines) {
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "Reschedule request rejected and status updated. The original appointment has been cancelled. Please set the available slot again if needed.");
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading/writing to the file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        int selectedRow = rescheduleTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an reschedule request appointment to perform approve action.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel rescheduleTableModel = (DefaultTableModel) rescheduleTable.getModel();
        
        String appointmentID = (String) rescheduleTableModel.getValueAt(selectedRow, 0);
        String originalDate = (String) rescheduleTableModel.getValueAt(selectedRow, 1);
        String studentID = (String) rescheduleTableModel.getValueAt(selectedRow, 5);

        // File to update
        File file = new File(lecturerID + "availableSlots.txt");
        List<String> updatedLines = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // Step 1: Read through the file and verify appointment status.
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 6) {
                        String appointmentIDInFile = parts[0].trim();
                        String date = parts[1].trim();
                        String fileStartTime = parts[2].trim();
                        String fileEndTime = parts[3].trim();
                        String studentInFile = parts[4].trim();
                        String status = parts[5].trim();
                        
                        // Debugging print statement to check the values being compared
                        System.out.println("Selected Appointment ID: " + appointmentID);
                        System.out.println("Appointment ID in File: " + appointmentIDInFile);
                        System.out.println("Original Date: " + originalDate);
                        System.out.println("Date in File: " + date);
                        System.out.println("Student ID: " + studentID);
                        System.out.println("Student ID in File: " + studentInFile);
                        System.out.println("Status in File: " + status);

                        // If the selected appointment matches the one in the file, update its status
                        if (appointmentID.equals(appointmentIDInFile) && studentID.equals(studentInFile)) {
                            // Check the status of the appointment in the file
                            switch (status) {
                                case "original" ->                                     {
                                        // remove the original line
                                        continue;
                                    }
                                case "rescheduling" ->                                     {
                                        // Change status from "rescheduling" to "reschedule confirmed"
                                        String updatedRescheduleLine = appointmentID + "," + date + "," + fileStartTime + "," + fileEndTime + "," + studentInFile + ",rescheduled";
                                        updatedLines.add(updatedRescheduleLine);
                                        System.out.println("Reschedule confirmed for Appointment ID: " + appointmentIDInFile);  // Debugging
                                    }
                                default -> // Keep other statuses as they are
                                    updatedLines.add(line);
                            }
                        } else {
                            // If no match, retain the original line
                            updatedLines.add(line);
                        }
                    } else {
                        // Invalid line format, keep as it is
                        updatedLines.add(line);
                    }
                }

                // Step 2: Write back the updated content to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String updatedLine : updatedLines) {
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "Reschedule request approved and status updated.\nThe original appointment has been cancelled.\nPlease set the available slot again if needed.");
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading/writing to the file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_approveButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        loadTableData();
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void loadTableData() {
        DefaultTableModel rescheduleTableModel = (DefaultTableModel) rescheduleTable.getModel();
        rescheduleTableModel.setRowCount(0);

        Map<String, String[]> originalAppointments = new HashMap<>();
        Map<String, String[]> rescheduleAppointments = new HashMap<>();

        File file = new File(lecturerID + "availableSlots.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    System.out.println("Processing line: " + line);
                    if (parts.length != 6) { // Ensure the line has exactly 5 components
                        System.out.println("Skipped invalid line: " + line);
                        continue;
                    }
                    
                    String appointmentID = parts[0].trim();
                    String date = parts[1].trim();
                    String startTime = parts[2].trim();
                    String endTime = parts[3].trim();
                    String studentID = parts[4].trim();
                    String status = parts[5].trim();

                    switch (status) {
                        case "original" -> originalAppointments.put(appointmentID, new String[]{appointmentID, date, startTime, endTime, studentID});
                        case "rescheduling" -> rescheduleAppointments.put(appointmentID, new String[]{appointmentID, date, startTime, endTime, studentID});
                        default -> System.out.println("Unknown status detected: " + status);
                    }
                }

                // Populate table with original and pending reschedules
                for (String appointmentID : originalAppointments.keySet()) {
                    String[] originalData = originalAppointments.get(appointmentID);
                    String[] rescheduleData = rescheduleAppointments.get(appointmentID);

                    String originalDate = originalData[1];
                    String originalTime = originalData[2] + " - " + originalData[3];
                    String studentID = originalData[4];
                    String rescheduleDate = (rescheduleData != null) ? rescheduleData[1] : "-";
                    String rescheduleTime = (rescheduleData != null) ? rescheduleData[2] + " - " + rescheduleData[3] : "-";
                    String status = (rescheduleData != null) ? "Pending" : "Original";

                    rescheduleTableModel.addRow(new Object[]{appointmentID, originalDate, originalTime, rescheduleDate, rescheduleTime, studentID, status});
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "File does not exist!", "File Error", JOptionPane.ERROR_MESSAGE);
        }
        rescheduleTable.revalidate();
        rescheduleTable.repaint();
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton rejectButton;
    private javax.swing.JLabel rescheduleRequestLabel;
    private javax.swing.JTable rescheduleTable;
    // End of variables declaration//GEN-END:variables
}
