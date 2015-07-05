
package paquete;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmPrincipal extends javax.swing.JFrame {

    private MySql oMySql ;
    private DefaultTableModel modGrilla ;
    
    public FrmPrincipal() {
        initComponents();
        
        try 
        {
             oMySql = new MySql();
             cargarCombo();
             
        } 
        catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage()  );
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BgTipoInmueble = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Combo = new javax.swing.JComboBox();
        RbDepto = new javax.swing.JRadioButton();
        RbCasa = new javax.swing.JRadioButton();
        RbLocal = new javax.swing.JRadioButton();
        ChkVenta = new javax.swing.JCheckBox();
        CmdMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Barrio");

        BgTipoInmueble.add(RbDepto);
        RbDepto.setText("Depto");

        BgTipoInmueble.add(RbCasa);
        RbCasa.setSelected(true);
        RbCasa.setText("Casa");

        BgTipoInmueble.add(RbLocal);
        RbLocal.setText("Local");

        ChkVenta.setText("Venta");

        CmdMostrar.setText("Mostrar");
        CmdMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdMostrarActionPerformed(evt);
            }
        });

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Grilla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RbCasa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RbLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RbDepto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ChkVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CmdMostrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RbDepto)
                    .addComponent(RbCasa)
                    .addComponent(RbLocal)
                    .addComponent(ChkVenta)
                    .addComponent(CmdMostrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmdMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdMostrarActionPerformed
        String consultaSQL = generarConsulta();
        cargarGrilla(consultaSQL);
    }//GEN-LAST:event_CmdMostrarActionPerformed
    
    private void cargarCombo() {
        Combo.removeAllItems();
        
        Combo.addItem("Todos");
        
        String consulta = "select barrio, nombre from barrios order by barrio ";
        ResultSet reg = null  ;
        
        try {
            reg = this.oMySql.cargarResulset(consulta);
  
            while(reg.next()){
                
         
         
                Combo.addItem(new ComboBox(reg.getInt("barrio"), reg.getString("nombre")));
         
               
            }
        }  
        catch (Exception ex) 
        {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void setearGrilla(){
            this.modGrilla = new DefaultTableModel();
            
           Grilla.setModel(this.modGrilla);
            
            this.modGrilla.addColumn("Domicilio");
            Grilla.getColumnModel().getColumn(0).setMinWidth(80);
            
            this.modGrilla.addColumn("Importe");  
            Grilla.getColumnModel().getColumn(1).setMinWidth(50);
            
            this.modGrilla.addColumn("Nombre Propietario");  
            Grilla.getColumnModel().getColumn(2).setMinWidth(150);
            
            this.modGrilla.addColumn("Tel Propietario"); 
            Grilla.getColumnModel().getColumn(3).setMinWidth(70);
            
            if (Combo.getItemAt(Combo.getSelectedIndex()).toString().equals("Todos"))
            {
                this.modGrilla.addColumn("Barrio");  
                Grilla.getColumnModel().getColumn(4).setMinWidth(150); 
            }
          

    }
    private String generarConsulta()
    {
    String consulta = 
                      "select domicilio, importe, propietarios.nombre as nombrepropietario, "
                    + "telefono, barrios.nombre as nombrebarrio "
                    + "from inmuebles "
                    + "inner join propietarios on propietarios.propietario = inmuebles.propietario "
                    + "inner join barrios on barrios.barrio = inmuebles.barrio ";
            
            
            String filtros = "" ;
       
                //.setselected(true) para tildarlo
            if (RbCasa.isSelected()== true)
            {
                filtros = filtros + " tipo = '" + "C" + "' ";

            }
            
            if (RbDepto.isSelected()== true)
            {
                filtros = filtros + " tipo = '" + "D" + "' ";

            }
            
            if (RbLocal.isSelected()== true)
            {
                filtros = filtros + " tipo = '" + "L" + "' ";

            }
        
                        
            if (ChkVenta.isSelected()== true)
            {
                filtros = filtros + " AND situacion = '" + "V" + "' ";
            }
            else
            {
                filtros = filtros + " AND situacion = '" + "A" + "' ";
            }
            
        
                        
            if (Combo.getItemAt(Combo.getSelectedIndex()).toString().equals("Todos") == false)
            {
               ComboBox objeto = (ComboBox) Combo.getItemAt(Combo.getSelectedIndex());
               filtros = filtros + " AND inmuebles.barrio = " + String.valueOf(objeto.getCodigo());
             
            }
                        
        
            return  consulta + "where" + filtros;
            
              
    }
    
    
    
    private void cargarGrilla(String consulta){
        setearGrilla();
        try {                                 
                        
            try (ResultSet reg = this.oMySql.cargarResulset(consulta)  ) {
                while(reg.next())
                {
                    Object vector[] = new Object[5];
                    vector[0] = reg.getObject("domicilio");
                    vector[1] = reg.getObject("importe");
                    vector[2] = reg.getObject("nombrepropietario");
                    vector[3] = reg.getObject("telefono");
                    vector[4] = reg.getObject("nombrebarrio");
                   
                    modGrilla.addRow(vector);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BgTipoInmueble;
    private javax.swing.JCheckBox ChkVenta;
    private javax.swing.JButton CmdMostrar;
    private javax.swing.JComboBox Combo;
    private javax.swing.JTable Grilla;
    private javax.swing.JRadioButton RbCasa;
    private javax.swing.JRadioButton RbDepto;
    private javax.swing.JRadioButton RbLocal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
