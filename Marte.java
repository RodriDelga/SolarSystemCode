/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemasolar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
//import java.applet.AudioClip;


/**
 *
 * @author yared
 */


public class Marte extends javax.swing.JFrame {
    
    private Clip clip;
    Icon imagen;
    Icon movimientos;
    Icon Item;
    boolean bajar;
    int seg=0;
    int BloqueoDerecha=-2508;
    boolean nave=true;
    /**
     * Creates new form Marte
     */
    //32 87 65 83 68

    Timer S = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            subir();
            bajar();
        }
    });
//    Controlador control;
    public Marte() {
        initComponents();
        this.setSize(1090, 650);
        this.setLocationRelativeTo(null);
        lbLewis.setVisible(false);
        btnEntrar.setVisible(false);
        btnEnergia.setVisible(false);
        lbF.setVisible(false);
        lbMesa.setVisible(false);
        lbRobot.setVisible(false);
        lbhawkingT.setVisible(false);
        
//        System.out.println(""+lbLewis.getY());
//        System.out.println(""+lbLewis.getX());
        CargarSonido("src/Audios/Marte.wav");
        Reproducir();
        Mostrar();
    }
    
    public void subir(){
        if(seg<=20){
            seg++;
            lbLewis.setLocation(lbLewis.getX(), lbLewis.getY()-5);
//            System.out.println(""+lbLewis.getY());
        }
        if(lbLewis.getY()==255){
            bajar=true;
        }
    }
    
    public void bajar(){
       if(bajar==true){
            seg++;
            lbLewis.setLocation(lbLewis.getX(), lbLewis.getY()+5);
        }
       if(lbLewis.getY()==350){
           bajar=false;
           S.stop();
       }
    }
    
    public void saltar(){
        if(lbLewis.getY()==350){
            seg=0;
            S.start();
        }
    }
    
    public void Izquierda(){
        if(lbLewis.getX()>100){
            Mesa();
            movimientos = new ImageIcon(getClass().getResource("/imagenes/LewisTrajeEspacialIzq.gif"));
            lbLewis.setIcon(movimientos);
            lbLewis.setLocation(lbLewis.getX()-5, lbLewis.getY());
//            System.out.println(""+lbLewis.getY());
            lbF.setVisible(false);
        }else{
            if(lb_Marte.getX()<0){
                Mesa();
                lb_Marte.setLocation(lb_Marte.getX()+6, lb_Marte.getY());
                lbNaveDestruida.setLocation(lbNaveDestruida.getX()+6, lbNaveDestruida.getY());
                lbMesa.setLocation(lbMesa.getX()+6, lbMesa.getY());
                lbRobot.setLocation(lbRobot.getX()+6, lbRobot.getY());
                lbhawkingT.setLocation(lbhawkingT.getX()+6, lbhawkingT.getY());
                lbF.setVisible(false);
            }
        }
        
    }
    
    public void Derecha(){
            
            if(lbLewis.getX()<=800){
                Mesa();
                movimientos = new ImageIcon(getClass().getResource("/imagenes/LewisTrajeEspacial.gif"));
                lbLewis.setIcon(movimientos);
                lbLewis.setLocation(lbLewis.getX()+5, lbLewis.getY());
                lbF.setVisible(false);
//                System.out.println(""+lbLewis.getX());
//                System.out.println(""+lb_Marte.getX());
            }else{
                if(lb_Marte.getX()>BloqueoDerecha){
                    Mesa();
                    lb_Marte.setLocation(lb_Marte.getX()-6, lb_Marte.getY());
                    lbNaveDestruida.setLocation(lbNaveDestruida.getX()-6, lbNaveDestruida.getY());
                    lbMesa.setLocation(lbMesa.getX()-6, lbMesa.getY());
                    lbRobot.setLocation(lbRobot.getX()-6, lbRobot.getY());
                    lbhawkingT.setLocation(lbhawkingT.getX()-6, lbhawkingT.getY());
                    lbF.setVisible(false);
                }
                if(lb_Marte.getX()==-2508){
                    lbF.setVisible(true);
                }
            }
    }
    
    public void EntrarNave(){
        try {
            RandomAccessFile locate= new RandomAccessFile("MarteUbicacion.txt", "rw");
            String lugar=locate.readLine();
            if(lugar.equals("Fuera,")&&lb_Marte.getX()>=0){
                    imagen = new ImageIcon(getClass().getResource("/imagenes/Marte.gif"));
                    lb_Marte.setIcon(imagen);
                    lbLewis.setVisible(false);
                    lb_control.setVisible(true);
                    lb_hawking.setVisible(true);
                    btnBinario.setVisible(true);
                    btnVolver.setVisible(true);
                    btnAterrizar.setVisible(true);
                    this.setSize(1090, 650);
                    lbhawkingT.setVisible(false);
                    
                }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void SalirNaveDestruida(){
        try {
            RandomAccessFile locate = new RandomAccessFile("MarteUbicacion.txt", "rw");
            String lugar=locate.readLine();
            if(lugar.equals("Dentro")&&lb_Marte.getX()>=0){
                imagen = new ImageIcon(getClass().getResource("/imagenes/MarteFondoImagen.png"));
                lb_Marte.setIcon(imagen);
                lb_Marte.setLocation(-2508, lb_Marte.getY());
                BloqueoDerecha=-2508;
                lbNaveDestruida.setVisible(true);
                movimientos = new ImageIcon(getClass().getResource("/imagenes/LewisTrajeEspacialIzq.gif"));
                lbLewis.setIcon(movimientos);
                RandomAccessFile archivo = new RandomAccessFile("MarteUbicacion.txt", "rw");
                byte Ubicacion[]={'F', 'u', 'e', 'r', 'a', ','};
                archivo.write(Ubicacion);
                archivo.close();
                lbMesa.setLocation(3800, lbMesa.getY());
                lbLewis.setLocation(720, lbLewis.getY());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Entrar(){
            if(lb_Marte.getX()<=-2508){
                    this.setSize(1090, 660);
                    lb_Marte.setLocation(0, lb_Marte.getY());
                    lbNaveDestruida.setVisible(false);
                    imagen = new ImageIcon(getClass().getResource("/imagenes/PuertaNaveD.png"));
                    lb_Marte.setIcon(imagen);
                    lbLewis.setLocation(-2508, lbLewis.getY());
                    lbLewis.setVisible(false);
                    btnEntrar.setVisible(true);
                    btnEnergia.setVisible(true);
                    lbF.setVisible(false);
                    
                }
    }
    
    public void Mesa(){
        if(lbMesa.getX()<(lbLewis.getX()+50)&&(lbMesa.getX()+250)>lbLewis.getX()){
//            System.out.println("Colision");
        }
        if(lbRobot.getX()<(lbLewis.getX()+50)&&(lbRobot.getX()+140)>lbLewis.getX()){
//            System.out.println("colision");
        }
    }
    public void Mostrar(){
        try {
            RandomAccessFile totem = new RandomAccessFile("Inventario.txt", "rw");
            String ver=totem.readLine();
            if(!(ver.equals("vacio_________________________________________________________________"))){
                Item = new ImageIcon(getClass().getResource("/imagenes/MesaVacia.png"));
                lbMesa.setIcon(Item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Recoger(){
        if(lbMesa.getX()<(lbLewis.getX()+50)&&(lbMesa.getX()+250)>lbLewis.getX()){
        try {
            RandomAccessFile Guardar = new RandomAccessFile("Inventario.txt", "rw");
            byte Save[]={'t','o','t','e','m',','};
            Guardar.seek(0);
            Guardar.write(Save);
            Guardar.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {
                Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        }
        Item = new ImageIcon(getClass().getResource("/imagenes/MesaVacia.png"));
        lbMesa.setIcon(Item);
        }
    }
    
    public void Codigo(){
        if(lbRobot.getX()<(lbLewis.getX()+50)&&(lbRobot.getX()+140)>lbLewis.getX()){
            LocateCode cd = new LocateCode(this, true);
            cd.setVisible(true);
        }
    }
    
    
        
    public void CargarSonido(String ruta){
            try{
                File archivoSonido = new File(ruta);
                AudioInputStream audioinputstream = AudioSystem.getAudioInputStream(archivoSonido);
                clip = AudioSystem.getClip();
                clip.open(audioinputstream);
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
    }
   
    public void Reproducir(){
        if(clip!=null){
            clip.setFramePosition(0);
            clip.start();
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

        lb_hawking = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnAterrizar = new javax.swing.JButton();
        btnBinario = new javax.swing.JButton();
        lbejemplo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_control = new javax.swing.JLabel();
        lbLewis = new javax.swing.JLabel();
        lbF = new javax.swing.JLabel();
        lbNaveDestruida = new javax.swing.JLabel();
        btnEnergia = new javax.swing.JButton();
        lbMesa = new javax.swing.JLabel();
        lbRobot = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lbhawkingT = new javax.swing.JLabel();
        lb_Marte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        lb_hawking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_hawking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hawking.gif"))); // NOI18N
        getContentPane().add(lb_hawking);
        lb_hawking.setBounds(100, 80, 70, 40);

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonVolver.gif"))); // NOI18N
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(920, 500, 60, 80);

        btnAterrizar.setFont(new java.awt.Font("Felix Titling", 3, 24)); // NOI18N
        btnAterrizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAterrizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonAterrizar.gif"))); // NOI18N
        btnAterrizar.setContentAreaFilled(false);
        btnAterrizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAterrizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAterrizar);
        btnAterrizar.setBounds(880, 410, 40, 70);

        btnBinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotonBinario.gif"))); // NOI18N
        btnBinario.setContentAreaFilled(false);
        btnBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnBinario);
        btnBinario.setBounds(980, 410, 50, 80);

        lbejemplo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbejemplo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Robbie.gif"))); // NOI18N
        getContentPane().add(lbejemplo);
        lbejemplo.setBounds(3000, 330, 120, 110);

        jLabel1.setText("l");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 390, 80, 110);

        lb_control.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_control.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Control.png"))); // NOI18N
        getContentPane().add(lb_control);
        lb_control.setBounds(840, 370, 230, 240);

        lbLewis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLewis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LewisTrajeEspacial.gif"))); // NOI18N
        getContentPane().add(lbLewis);
        lbLewis.setBounds(420, 350, 90, 150);

        lbF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TeclaF.png"))); // NOI18N
        lbF.setToolTipText("");
        getContentPane().add(lbF);
        lbF.setBounds(870, 270, 50, 50);

        lbNaveDestruida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNaveDestruida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NaveDestruida2.png"))); // NOI18N
        getContentPane().add(lbNaveDestruida);
        lbNaveDestruida.setBounds(3000, 100, 610, 560);

        btnEnergia.setFont(new java.awt.Font("Felix Titling", 3, 24)); // NOI18N
        btnEnergia.setForeground(new java.awt.Color(0, 153, 153));
        btnEnergia.setBorderPainted(false);
        btnEnergia.setContentAreaFilled(false);
        btnEnergia.setFocusPainted(false);
        btnEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnergiaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnergia);
        btnEnergia.setBounds(840, 50, 180, 110);

        lbMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mesa.png"))); // NOI18N
        lbMesa.setToolTipText("");
        getContentPane().add(lbMesa);
        lbMesa.setBounds(3800, 310, 360, 180);

        lbRobot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRobot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RobotC-974.png"))); // NOI18N
        getContentPane().add(lbRobot);
        lbRobot.setBounds(3800, 360, 140, 130);

        btnEntrar.setFont(new java.awt.Font("Felix Titling", 3, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 153, 153));
        btnEntrar.setBorderPainted(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setFocusPainted(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(850, 300, 70, 110);

        lbhawkingT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/HawkingTierra (1).gif"))); // NOI18N
        getContentPane().add(lbhawkingT);
        lbhawkingT.setBounds(0, -30, 330, 530);

        lb_Marte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_Marte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Marte.gif"))); // NOI18N
        getContentPane().add(lb_Marte);
        lb_Marte.setBounds(0, 0, 3600, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        clip.stop();
        Principal ventanaP = new Principal();
        ventanaP.setVisible(true);
        ventanaP.setSize(1080, 730);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinarioActionPerformed
        // TODO add your handling code here:
        CodigoBinario ventanaB = new CodigoBinario();
        ventanaB.setVisible(true);
        ventanaB.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBinarioActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
//        System.out.println("Key code: "+evt.getKeyCode()+" Char: "+evt.getKeyChar());
        if(evt.getKeyCode()==65){
            Izquierda();
        }
        if(evt.getKeyCode()==68){
            Derecha();
        }
        if(evt.getKeyCode()==87){
                saltar();
        }
        if(evt.getKeyCode()==70){
                Entrar();
                SalirNaveDestruida();
        }
        if(evt.getKeyCode()==82){
                EntrarNave();
        }
        if(evt.getKeyCode()==69){
                Recoger();
                Codigo();
        }
//        
    }//GEN-LAST:event_formKeyPressed

    private void btnAterrizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAterrizarActionPerformed
        // TODO add your handling code here:
        
        imagen = new ImageIcon(getClass().getResource("/imagenes/MarteFondoImagen.png"));
        lb_Marte.setIcon(imagen);
        lbLewis.setVisible(true);
        lb_control.setVisible(false);
        lb_hawking.setVisible(false);
        btnBinario.setVisible(false);
        btnVolver.setVisible(false);
        btnAterrizar.setVisible(false);
        lbhawkingT.setVisible(true);
//        control = new Controlador(this);
//        this.addKeyListener(control);
        this.setFocusable(true);
        this.requestFocus();
//        System.out.println(""+lbLewis.getY());
//        System.out.println(""+lbLewis.getX());
        nave=false;
        try {
            RandomAccessFile archivo = new RandomAccessFile("MarteUbicacion.txt", "rw");
            byte Ubicacion[]={'F', 'u', 'e', 'r', 'a', ','};
            archivo.write(Ubicacion);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Marte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAterrizarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
//        Verificacion();
        try {
            
            RandomAccessFile archivo = new RandomAccessFile("Puerta.txt", "rw");
            String linea=archivo.readLine();
            if(linea.equals("truee")){
                imagen = new ImageIcon(getClass().getResource("/imagenes/NaveDestruidaFondoVacia.png"));
                lb_Marte.setIcon(imagen);
                lbLewis.setVisible(true);
                lbLewis.setLocation(200, 350);
                this.setSize(1090, 640);
                this.setFocusable(true);
                this.requestFocus();
                lbMesa.setVisible(true);
                lbMesa.setLocation(420, lbMesa.getY());
                lbRobot.setVisible(true);
                lbRobot.setLocation(1470, lbRobot.getY());
            }
            RandomAccessFile archivoM = new RandomAccessFile("MarteUbicacion.txt", "rw");
            byte Ubicacion[]={'D', 'e', 'n', 't', 'r', 'o'};
            archivoM.write(Ubicacion);
            archivoM.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        }   
        BloqueoDerecha=-870;
        nave=true;
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnergiaActionPerformed
        // TODO add your handling code here:
        try {
            
            RandomAccessFile archivo = new RandomAccessFile("Puerta.txt", "rw");
            String linea=archivo.readLine();
            if(linea.equals("false")){
            EnergiaPuerta ep = new EnergiaPuerta(this, true);
            ep.setVisible(true);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        }
        
    }//GEN-LAST:event_btnEnergiaActionPerformed

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
            java.util.logging.Logger.getLogger(Marte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Marte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Marte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Marte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Marte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAterrizar;
    private javax.swing.JButton btnBinario;
    private javax.swing.JButton btnEnergia;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbF;
    private javax.swing.JLabel lbLewis;
    private javax.swing.JLabel lbMesa;
    private javax.swing.JLabel lbNaveDestruida;
    private javax.swing.JLabel lbRobot;
    private javax.swing.JLabel lb_Marte;
    private javax.swing.JLabel lb_control;
    private javax.swing.JLabel lb_hawking;
    private javax.swing.JLabel lbejemplo;
    private javax.swing.JLabel lbhawkingT;
    // End of variables declaration//GEN-END:variables
}
