/*
 Clase de la interfaz de detalle de facturas
 */
package Principal;

import Datos.DDFacturas;
import Logica.LDFacturas;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class DetalleFacturas extends javax.swing.JDialog {

    // Creación de una tabla

    DefaultTableModel miModelo;

    /**
     * Creates new form DetalleFacturas
     */
    public DetalleFacturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtIdFactura.setEditable(false);
        txtProveedor.setEditable(false);
        txtDepartamento.setEditable(false);
        txtFecha.setEditable(false);
        txtTotal.setEditable(false);
        miModelo = (DefaultTableModel) tblFacturas.getModel();

        tblFacturas.getColumn("CODIGO").setWidth(15);
        tblFacturas.getColumn("CODIGO").setPreferredWidth(15);

        tblFacturas.getColumn("DESCRIPCION").setWidth(220);
        tblFacturas.getColumn("DESCRIPCION").setPreferredWidth(220);

        tblFacturas.getColumn("CANTIDAD").setWidth(20);
        tblFacturas.getColumn("CANTIDAD").setPreferredWidth(20);

        tblFacturas.getColumn("U/MEDIDA").setWidth(20);
        tblFacturas.getColumn("U/MEDIDA").setPreferredWidth(20);

        tblFacturas.getColumn("P/UNITARIO").setWidth(20);
        tblFacturas.getColumn("P/UNITARIO").setPreferredWidth(20);

        tblFacturas.getColumn("TOTAL").setWidth(20);
        tblFacturas.getColumn("TOTAL").setPreferredWidth(20);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacturas = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("ID:");

        jLabel2.setText("Departamento:");

        jLabel3.setText("Proveedor");

        jLabel4.setText("Fecha:");

        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "U/MEDIDA", "P/UNITARIO", "TOTAL"
            }
        ));
        tblFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFacturasMousePressed(evt);
            }
        });
        tblFacturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFacturasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFacturas);

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("TOTAL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtProveedor)
                            .addGap(466, 466, 466))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFacturasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturasMousePressed

    private void tblFacturasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFacturasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturasKeyPressed
    // Método para settear la factura.
    public void setFactura(String idfactura, String proveedor, String departamento, String fecha) {
        txtIdFactura.setText(idfactura);
        txtProveedor.setText(proveedor);
        txtDepartamento.setText(departamento);
        txtFecha.setText(fecha);
        mostrarDetalleFactura(Integer.parseInt(idfactura));
    }   
    // Método para mostrar el detalle de la factura
    private void mostrarDetalleFactura(int idfactura) {
        miModelo = (DefaultTableModel) tblFacturas.getModel();
        DDFacturas dts = new DDFacturas();
        LDFacturas fun = new LDFacturas();
        dts.setFacturasId(idfactura);
        miModelo = fun.mostrarFacturas(dts);
        tblFacturas.setModel(miModelo);
        sumarTotal();
    }
    // Método para sumar el total
    public void sumarTotal() {
        DecimalFormat ft = new DecimalFormat("####.00");
        double totalparcial = 0, totalfinal = 0;
        for (int i = 0; i < tblFacturas.getRowCount(); i++) {
            totalparcial = Double.parseDouble(tblFacturas.getValueAt(i, 5).toString());
            totalfinal += totalparcial;
            txtTotal.setText(ft.format(totalfinal));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFacturas;
    public static javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdFactura;
    public static javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}