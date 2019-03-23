/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author Daniel
 */
public class Detalle extends javax.swing.JFrame {

   int iBonificacion=250;
   double dIGSS=0.0483, dISR ,  dCalculoIGSS;
   
    
    public Detalle() {
        initComponents();
        codEmpleado();
        CodConcepto();
        MostrarDatosPlanilla("");
        ValorDetalle();
        this.setLocationRelativeTo(null);
    }
    
     public void CalculosEfectoPlanilla() {
         // Este metodo calculo todos los ingresos y egresos del empleado
                  try {
             double   dComisiones = (Math.random() * (400 - 500) + 500);
            double    dDescuentoJudicial = (Math.random() * (600 - 250) + 250);
            double dSueldo = 0;
                String sCodConcepto = cbCodConcepto.getSelectedItem().toString().trim();
                String sCodEmpleado = cbEmpleado.getSelectedItem().toString().trim();
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM empleado e,concepto c WHERE e.emp_codigo='" + sCodEmpleado + "' AND c.codigoConcepto='" + sCodConcepto + "'");
                while (rs.next()) {
                    dSueldo = rs.getDouble("Sueldo_nominal");
                    sCodConcepto = rs.getString("codigoConcepto");
                    System.out.println(dSueldo + " " + sCodConcepto);
                }
                if (sCodConcepto.equals("1")) {
                    txtTotalDetalle.setText(Integer.toString(iBonificacion));
                }
               
                if (sCodConcepto.equals("2")) {
                    if (dSueldo > 30000) {
                        dISR = (dSueldo * 0.07) / 12;
                    } else {
                        dISR = (dSueldo * 0.05) / 12;
                    }
                    txtTotalDetalle.setText(Double.toString((double) Math.round(dISR*100d/100)));
                }
                   if (sCodConcepto.equals("3")) {
                    txtTotalDetalle.setText(Double.toString((double) Math.round(dComisiones*100d/100)));
                }
                 if (sCodConcepto.equals("4")) {
                    txtTotalDetalle.setText(Double.toString((double) Math.round(dDescuentoJudicial*100d/100)));
                }
                if (sCodConcepto.equals("5")) {
                   dCalculoIGSS = dSueldo * dIGSS;
                   txtTotalDetalle.setText(Double.toString((double) Math.round(dCalculoIGSS*100d/100)));
                }
               
              
                if (sCodConcepto.equals("6")) {
                   double dSueldoLiquido=dSueldo-dISR-dCalculoIGSS-dDescuentoJudicial+iBonificacion+dComisiones;
                    txtTotalDetalle.setText(Double.toString((double) Math.round(dSueldoLiquido*100d/100)));
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
 public void ValorDetalle() {
        try {
            double dAcum ,dTotal = 0;
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
            String sEfecto = "+";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nominadetalle nd,concepto c WHERE c.efecto_concepto='" + sEfecto + "' AND nd.codigoConcepto=c.codigoConcepto");
            while (rs.next()) {
                sEfecto = rs.getString("efecto_concepto");
                String sCod1 = rs.getString("nd.codigoConcepto");
                String sCod2 = rs.getString("c.codigoConcepto");
                if (sCod1.equals(sCod2)) {
                    if (sCod1.equals("6")) {
                        dAcum = 0;
                    } else {
                        if (sEfecto.equals("+")) {
                            dAcum = rs.getDouble("total");
                           dTotal += dAcum;
                        }
                    }
                }

            }
            try{
                PreparedStatement pst=cn.prepareStatement("UPDATE nominaencabezada SET valornomina='"+Double.toString(dTotal)+"'");
                pst.executeUpdate();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


 public void MostrarDatosPlanilla(String sCadena){
      DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Empleado");
        modelo.addColumn("Concepto");
        modelo.addColumn("Valor");
        tblPlanilla.setModel(modelo);
        String[] sDatos = new String[4];
        String sSQL = "";
        if (sCadena.equals("")) {
            sSQL = "SELECT * FROM nominadetalle";
        } else {
            sSQL = "SELECT * FROM nominadetalle WHERE codnomina='" + sCadena + "'";
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                sDatos[0] = rs.getString(1);
                sDatos[1] = rs.getString(2);
                sDatos[2] = rs.getString(3);
                sDatos[3] = rs.getString(4);
                modelo.addRow(sDatos);
            }
            tblPlanilla.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodNomina = new javax.swing.JTextField();
        RegistroDepto = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalDetalle = new javax.swing.JTextField();
        cbEmpleado = new javax.swing.JComboBox<>();
        cbCodConcepto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanilla = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMINA DETALLE");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cod Nomina");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Valor Nomina");

        txtCodNomina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNominaActionPerformed(evt);
            }
        });

        RegistroDepto.setBackground(new java.awt.Color(255, 51, 51));
        RegistroDepto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RegistroDepto.setForeground(new java.awt.Color(255, 255, 255));
        RegistroDepto.setText("Registrar");
        RegistroDepto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegistroDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroDeptoActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(51, 0, 255));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("Mostrar");
        btnMostrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cod Empleado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cod Concepto");

        txtTotalDetalle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpleadoActionPerformed(evt);
            }
        });

        cbCodConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodConceptoActionPerformed(evt);
            }
        });

        tblPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPlanilla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodNomina, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(cbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbCodConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RegistroDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbCodConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTotalDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistroDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnSalir.setBackground(new java.awt.Color(51, 0, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 746, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNominaActionPerformed

    private void RegistroDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroDeptoActionPerformed
try{
    if (cbCodConcepto.getSelectedItem().equals("Seleccione")  || cbEmpleado.getSelectedItem().equals("Seleccione")) {
                    JOptionPane.showMessageDialog(null, "No están llenos los campos", "ADVERTENCIA", JOptionPane.PLAIN_MESSAGE);
                } else {
             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
                    PreparedStatement pst = cn.prepareStatement("INSERT into nominadetalle VALUES(?,?,?,?)");
                    pst.setString(1, txtCodNomina.getText().toString().trim());
                    pst.setString(2, cbEmpleado.getSelectedItem().toString().trim());
                    pst.setString(3, cbCodConcepto.getSelectedItem().toString().trim());
                    pst.setString(4, txtTotalDetalle.getText().trim());
                     JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO", " ", JOptionPane.PLAIN_MESSAGE);
                    pst.executeUpdate();
                    MostrarDatosPlanilla(" ");        
                    
                    
                }
           
             txtCodNomina.setText("");
            txtTotalDetalle.setText("");
            JOptionPane.showMessageDialog(null,"Registro del departamento existoso");
        }catch (Exception e){
           JOptionPane.showMessageDialog (null,"Error "+e);
        }

    }//GEN-LAST:event_RegistroDeptoActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpleadoActionPerformed
 
    }//GEN-LAST:event_cbEmpleadoActionPerformed

    private void cbCodConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodConceptoActionPerformed
       CalculosEfectoPlanilla();
    }//GEN-LAST:event_cbCodConceptoActionPerformed

    public void  codEmpleado()
    {
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
            PreparedStatement pst = cn.prepareStatement("select* from empleado");
            ResultSet rs = pst.executeQuery();
             
            cbEmpleado.addItem("Seleccione");
              while(rs.next()){
              this. cbEmpleado.addItem(rs.getString("emp_codigo"));

            } 

        }catch (Exception e){
        }
}
    
    public void CodConcepto()
     {
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");
            PreparedStatement pst = cn.prepareStatement("select* from concepto");
            ResultSet rs = pst.executeQuery();
             
            cbCodConcepto.addItem("Seleccione");
              while(rs.next()){
              this. cbCodConcepto.addItem(rs.getString("codigoConcepto"));

            } 

        }catch (Exception e){
        }
}
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
            java.util.logging.Logger.getLogger(Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistroDepto;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbCodConcepto;
    private javax.swing.JComboBox<String> cbEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlanilla;
    private javax.swing.JTextField txtCodNomina;
    private javax.swing.JTextField txtTotalDetalle;
    // End of variables declaration//GEN-END:variables
}
