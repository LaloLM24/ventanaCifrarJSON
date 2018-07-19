package cifrarjson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JCheckBox;



/**
 * @author Eduardo López Melo
 */
public class ventana extends javax.swing.JFrame {
     private   File rutaFile = null;
     private   String ruta = "";
     private   String rutaString = "";
     private   String leerContenido = "";
     private   JFileChooser archivo = null;
     private   FileReader leerArchivo = null;
     private   BufferedReader archivoCompleto = null;
     private   int tamanio = 0;
     private   String [] llave;
     private   Object [] valor;
     private   String [] valorString;
     private   String [] Cifrado;
     
     private   List<JCheckBox> caja;
     private   int indice;

    public ventana() throws FileNotFoundException, IOException 
    {
        RSACifrado rsa = new RSACifrado();
        
        cargarArchivo();
        initComponents();
        textoJson.setText(leerContenido);
        System.out.println(rutaFile);
        ruta = rutaFile.toString();
        
        archivoJSON json = new archivoJSON(ruta,leerArchivo);
        json.cargarJson();
        tamanio = json.obtenerTamanio();
        llave = json.clave();
        valor = json.valores();
        System.out.println(tamanio);
        
        caja = new ArrayList<JCheckBox>();
        indice = 0;
        

        for(int a = 0; a<tamanio; a++)
        {
            //JCheckBox checkCaja = new JCheckBox ("Caja " + indice);          
            JCheckBox checkCaja = new JCheckBox (llave[indice]);
            panel.add(checkCaja);
            caja.add(checkCaja);
            indice ++;
            panel.updateUI();
        }
        
        valorString = new String[valor.length];
        for(int b = 0; b < valor.length; b++)
        {
            valorString[b] = String.valueOf(valor[b]);
            System.out.println(valorString[b]);
        }
                
    }

    private void cargarArchivo() throws FileNotFoundException, IOException
    {
        archivo = new JFileChooser();
        archivo.setDialogTitle("Buscar JSON");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".json", "JSON");
        archivo.setFileFilter(filtro);

        int seleccion = archivo.showOpenDialog(this);
        
        if(seleccion == JFileChooser.CANCEL_OPTION)
        {
            System.exit(-1);
        }
        else if (seleccion == JFileChooser.APPROVE_OPTION)
        {
            rutaFile = archivo.getSelectedFile();
            rutaString = ruta.toString();
            System.out.println(rutaString);
            
            leerArchivo = new FileReader(rutaFile);
            System.out.println(leerArchivo);
            
            archivoCompleto = new BufferedReader(leerArchivo);
            System.out.println(archivoCompleto);
            
            String linea;
            
            while( ( linea = archivoCompleto.readLine() ) != null )
            {
                    leerContenido += linea + "\n";
            }
            System.out.println(leerContenido);
        
        }


    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        pestanias = new javax.swing.JTabbedPane();
        panelPrincipal1 = new javax.swing.JPanel();
        scrollJsonCargado = new javax.swing.JScrollPane();
        textoJson = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        botonCifrar = new javax.swing.JButton();
        cargarNuevo = new javax.swing.JButton();
        panelPrincipal2 = new javax.swing.JPanel();
        scrollResultado = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("Cifrar JSON");

        textoJson.setEditable(false);
        textoJson.setColumns(20);
        textoJson.setRows(5);
        scrollJsonCargado.setViewportView(textoJson);

        panel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(panel);

        botonCifrar.setText("Cifrar");
        botonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCifrarActionPerformed(evt);
            }
        });

        cargarNuevo.setText("Cargar Nuevo");
        cargarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipal1Layout = new javax.swing.GroupLayout(panelPrincipal1);
        panelPrincipal1.setLayout(panelPrincipal1Layout);
        panelPrincipal1Layout.setHorizontalGroup(
            panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipal1Layout.createSequentialGroup()
                        .addComponent(scrollJsonCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addGroup(panelPrincipal1Layout.createSequentialGroup()
                        .addComponent(cargarNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCifrar))))
        );
        panelPrincipal1Layout.setVerticalGroup(
            panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollJsonCargado)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCifrar)
                    .addComponent(cargarNuevo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pestanias.addTab("Cifrar", panelPrincipal1);

        resultado.setEditable(false);
        resultado.setColumns(20);
        resultado.setRows(5);
        scrollResultado.setViewportView(resultado);

        guardar.setText("Guardar");

        javax.swing.GroupLayout panelPrincipal2Layout = new javax.swing.GroupLayout(panelPrincipal2);
        panelPrincipal2.setLayout(panelPrincipal2Layout);
        panelPrincipal2Layout.setHorizontalGroup(
            panelPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipal2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar)))
                .addContainerGap())
        );
        panelPrincipal2Layout.setVerticalGroup(
            panelPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal2Layout.createSequentialGroup()
                .addComponent(scrollResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(guardar))
        );

        pestanias.addTab("Resultado", panelPrincipal2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pestanias))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pestanias)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCifrarActionPerformed
      //  textoJson.append(rutaString);

    }//GEN-LAST:event_botonCifrarActionPerformed

    private void cargarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarNuevoActionPerformed
        textoJson.setText("");
        ruta = null;
        rutaString = "";
        leerContenido = "";
        archivo = null;
        leerArchivo = null;
        archivoCompleto = null;
        
        try {
             cargarArchivo();
         } catch (IOException ex) {
             Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        textoJson.setText(leerContenido);
    }//GEN-LAST:event_cargarNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    new ventana().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCifrar;
    private javax.swing.JButton cargarNuevo;
    private javax.swing.JButton guardar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelPrincipal1;
    private javax.swing.JPanel panelPrincipal2;
    private javax.swing.JTabbedPane pestanias;
    private javax.swing.JTextArea resultado;
    private javax.swing.JScrollPane scrollJsonCargado;
    private javax.swing.JScrollPane scrollResultado;
    private javax.swing.JTextArea textoJson;
    // End of variables declaration//GEN-END:variables
}
