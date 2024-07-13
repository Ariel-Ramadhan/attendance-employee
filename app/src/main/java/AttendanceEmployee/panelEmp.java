/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AttendanceEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ariel
 */
public class panelEmp extends javax.swing.JPanel {
    
    Connection conn = null;
    private static ResultSet st = null;
    private static PreparedStatement ps = null;
    
    /**
     * Creates new form panelAddemp
     */
    public panelEmp() {
        initComponents();
        conn = MyConnection.getConnection();
        showTable();
    }
    
    public static void showTable(){
        DefaultTableModel sb = new DefaultTableModel();
        
        sb.addColumn("ID");
        sb.addColumn("Fitst name");
        sb.addColumn("Last name");
        sb.addColumn("Department");
        sb.addColumn("Desiqnation");
        sb.addColumn("Number");
        sb.addColumn("Status");
        sb.addColumn("Address");
        sb.addColumn("Salary");
        tblEmp.setModel(sb);
        
        
        try {
            ps = MyConnection.getConnection().prepareStatement("SELECT * FROM emp_list");
            st = ps.executeQuery();
            
            while (st.next()){
                sb.addRow(new Object[]{
                    st.getString("srno"),
                    st.getString("fname"),
                    st.getString("lname"),
                    st.getString("department"),
                    st.getString("designation"),
                    st.getString("number"),
                    st.getString("status"),
                    st.getString("address"),
                    st.getString("salary"),
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(1200, 730));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Employe");

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(tblEmp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1050, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblEmp;
    // End of variables declaration//GEN-END:variables
}