/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Datos.DAlmacen;
import Datos.DDFacturas;
import Datos.DFacturas;
import Logica.LAlmacen;
import Logica.LDFacturas;
import Logica.LFacturas;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class Facturas extends javax.swing.JInternalFrame {

    DefaultTableModel miModelo;

    static int iddepartamentos = 0;

    /**
     * Creates new form Facturas
     */
    public Facturas() {
        initComponents();
        habilitar(true);
       
        txtID.setEnabled(false);
        txtIdDepartamento.setEnabled(false);
        txtIdProveedor.setEnabled(false);
        txtTotal.setEditable(false);
        miModelo = (DefaultTableModel) tblFacturas.getModel();

        tblFacturas.getColumn("Código").setWidth(15);
        tblFacturas.getColumn("Código").setPreferredWidth(15);

        tblFacturas.getColumn("Descripción").setWidth(200);
        tblFacturas.getColumn("Descripción").setPreferredWidth(200);

        tblFacturas.getColumn("Precio Unitario").setWidth(20);
        tblFacturas.getColumn("Precio Unitario").setPreferredWidth(20);

        tblFacturas.getColumn("Cantidad").setWidth(20);
        tblFacturas.getColumn("Cantidad").setPreferredWidth(20);

        tblFacturas.getColumn("Unidad de Medida").setWidth(30);
        tblFacturas.getColumn("Unidad de Medida").setPreferredWidth(30);

        tblFacturas.getColumn("Total").setWidth(20);
        tblFacturas.getColumn("Total").setPreferredWidth(20);

        txtIdDepartamento.setEnabled(false);
        txtIdProveedor.setEnabled(false);
    }

    public static void setDepartamento(String id, String nombre) {
        iddepartamentos = Integer.parseInt(id);
        txtIdDepartamento.setText(id);
        txtDepartamento.setText(nombre);
    }

    public static void setProveedores(String id, String proveedor) {
        txtIdProveedor.setText(id);
        txtProveedor.setText(proveedor);
    }

    public void habilitar(boolean b) {
        txtFecha.setEnabled(!b);
        txtDepartamento.setEnabled(!b);
        txtProveedor.setEnabled(!b);
  
        btnGuardar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
    }
    
    public void limpiar() {
        txtFecha.setDate(null);
        txtDepartamento.setText("");
        txtProveedor.setText("");
        txtID.setText("");
        txtIdDepartamento.setText("");
        txtIdProveedor.setText("");
        txtTotal.setText("");
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblFacturas.getModel();
            int filas = tblFacturas.getRowCount();
            for(int i = 0; filas > i; i++){
                modelo.removeRow(0);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar tabla");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacturas = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        btnDepartamento = new javax.swing.JButton();
        txtIdDepartamento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Facturas");
        setPreferredSize(new java.awt.Dimension(750, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID:");

        jLabel3.setText("Proveedor:");

        jLabel4.setText("Fecha:");

        tblFacturas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Unidad de Medida", "Precio Unitario", "Total"
            }
        ));
        tblFacturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFacturasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFacturas);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnProveedor.setText("...");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });

        jLabel2.setText("Departamento:");

        txtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoActionPerformed(evt);
            }
        });

        btnDepartamento.setText("...");
        btnDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(184, 184, 184))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtProveedor))))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDepartamento)
                        .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        int filas = tblFacturas.getRowCount();
        int contar = 1;
        for (int n = 0; filas > n; n++) {
            contar = contar + 1;
        }
        if (contar >= 10) {
            miModelo.addRow(new Object[]{contar, "", "", "", "", ""});
        } else {
            miModelo.addRow(new Object[]{ "0" + contar, "", "", "", "", ""});
        }
        habilitar(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        BuscarProveedores mi = new BuscarProveedores(new JFrame(), true);
        mi.setLocationRelativeTo(null);
        mi.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoActionPerformed
        // TODO add your handling code here:
        BuscarDepartamento mi = new BuscarDepartamento(new JFrame(), true);
        mi.setLocationRelativeTo(null);
        mi.setVisible(true);
    }//GEN-LAST:event_btnDepartamentoActionPerformed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String msg = "", msgfinal = "";
        if (txtDepartamento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Campo departamento Obligatorio", "Informacion", JOptionPane.WARNING_MESSAGE);
            txtDepartamento.requestFocusInWindow();
            return;
        }

        if (txtProveedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Campo proveedor Obligatorio", "Informacion", JOptionPane.WARNING_MESSAGE);
            txtProveedor.requestFocusInWindow();
            return;
        }

        if (txtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Campo fecha Obligatorio", "Informacion", JOptionPane.WARNING_MESSAGE);
            txtFecha.requestFocusInWindow();
            return;
        }

        LFacturas fun = new LFacturas();
        DFacturas dts = new DFacturas();

        dts.setIdDepartamento(Integer.parseInt(txtIdDepartamento.getText()));
        dts.setIdProveedores(Integer.parseInt(txtIdProveedor.getText()));

        Calendar cal;

        cal = txtFecha.getCalendar();

        int aa, mm, dd;

        aa = cal.get(Calendar.YEAR) - 1900;
        mm = cal.get(Calendar.MONTH);
        dd = cal.get(Calendar.DAY_OF_MONTH);

        dts.setFecha(new Date(aa, mm, dd));
        txtProveedor.setText("");
        txtDepartamento.setText("");
        txtDepartamento.setEnabled(false);
        txtProveedor.setEnabled(false);

        int idfact = fun.insertarFacturas(dts);

        if (idfact >= 0) {
            int filas = tblFacturas.getRowCount();
            for (int i = 0; i < filas; i++) {
                String idprod = tblFacturas.getValueAt(i, 0).toString();
                String descrip = tblFacturas.getValueAt(i, 1).toString();
                int cantidad = Integer.parseInt(tblFacturas.getValueAt(i, 2).toString());
                String umedida = tblFacturas.getValueAt(i, 3).toString();
                double punitario = Double.parseDouble(tblFacturas.getValueAt(i, 4).toString());
                double total = Double.parseDouble(tblFacturas.getValueAt(i, 5).toString());

                LDFacturas funf = new LDFacturas();
                DDFacturas dtsf = new DDFacturas();

                dtsf.setFacturasId(idfact);
                dtsf.setProductosId(idprod);
                dtsf.setCantidad(cantidad);
                dtsf.setTotal(total);

                String mensaje = funf.registrarDetalleFactura(dtsf);

                if (mensaje.equals("si")) {
                    LAlmacen fund = new LAlmacen();
                    DAlmacen dtsp = new DAlmacen();

                    dtsp.setIdAlmacen(idprod);
                    dtsp.setDepartamentoid(iddepartamentos);
                    dtsp.setDescripcion(descrip);
                    dtsp.setPunitario(punitario);
                    dtsp.setStock(cantidad);
                    dtsp.setUmedida(umedida);

                    msgfinal = fund.insertarProductos(dtsp);

                }
            }
            JOptionPane.showMessageDialog(rootPane, "Se registro de forma correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un problema", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
        habilitar(true);
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoActionPerformed

    public boolean estaenTabla(String texto) {
        boolean res = false;
        DecimalFormat ft = new DecimalFormat("####.00");
        for (int i = 0; i < tblFacturas.getRowCount(); i++) {
            String codigo = tblFacturas.getValueAt(i, 0).toString();
            if (codigo.equals(texto)) {
                int cantidad = Integer.parseInt(tblFacturas.getValueAt(i, 2).toString());
                double preciounitario = Double.parseDouble(tblFacturas.getValueAt(i, 4).toString());
                int totalcantidad = cantidad + 1;
                tblFacturas.setValueAt(totalcantidad, i, 2);

                double totalparcial = totalcantidad * preciounitario;
                tblFacturas.setValueAt(ft.format(totalparcial), i, 5);
                res = true;
            }
        }
        sumarTotal();
        return res;
    }

    public void sumarTotal() {
        DecimalFormat ft = new DecimalFormat("####.00");
        double totalparcial = 0, totalfinal = 0;
        for (int i = 0; i < tblFacturas.getRowCount(); i++) {
            totalparcial = Double.parseDouble(tblFacturas.getValueAt(i, 5).toString());
            totalfinal += totalparcial;
            txtTotal.setText(ft.format(totalfinal));
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        habilitar(true);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblFacturasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFacturasKeyPressed
        // TODO add your handling code here:
        DecimalFormat ft = new DecimalFormat("####.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < tblFacturas.getRowCount(); i++) {
                int cantidad = Integer.parseInt(tblFacturas.getValueAt(i, 2).toString());
                double preciounitario = Double.parseDouble(tblFacturas.getValueAt(i, 4).toString());

                double totalparcial = cantidad * preciounitario;
                tblFacturas.setValueAt(ft.format(totalparcial), i, 5);
            }
            sumarTotal();
        }
    }//GEN-LAST:event_tblFacturasKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblFacturas;
    private static javax.swing.JTextField txtDepartamento;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtID;
    private static javax.swing.JTextField txtIdDepartamento;
    private static javax.swing.JTextField txtIdProveedor;
    private static javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
