/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintpfinal;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import sm.jrc.graficos.TipoFormas;
import sm.jrc.iu.*;

/**
 * Subclase de VentanaInterna, creada para trabajar con imágenes
 * @author Jesús Ruiz Castellano
 */
public class VentanaInternaImagen extends VentanaInterna {

    private VentanaPrincipalPFinal parent;
    private TipoFormas forma;
    private int grosor;
    private boolean mover, alisar, trans, relleno;
    private Point2D puntoMov;
    
    /**
     * Crea una nueva Ventana Principal
     * @param Parent : VentanaPrinicipal a la que se añade. Se liga a la ventana
     *                 padre para poder realizar comunicaciones entre ambas ventanas.
     * @param titulo : nombre de la ventana interna imagen
     */
    public VentanaInternaImagen(VentanaPrincipalPFinal Parent, String titulo) {
        inicia(Parent);
        super.setTitle(titulo);
    }

    
    public LienzoImagen2D getLienzo() {

        if (parent.getComboFiguras().getItemCount() != 0)
            parent.getBotonMover().setEnabled(true);
        
        return lienzoImagen2D2;
    }

    public Point2D getPuntoMov() {
        return puntoMov;
    }
       
    /**
     * Método creado para poder saber qué tipo de ventana interna estamos tratanto
     * en la ventana principal
     * @return 1 : tipo asignado a la ventana imagen
     */
    @Override
    public int getType() {
        return 1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lienzoImagen2D2 = new sm.jrc.iu.LienzoImagen2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAlignmentX(100.5F);
        setAlignmentY(100.5F);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosPFinal/Capturar.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(300, 250));
        setPreferredSize(new java.awt.Dimension(500, 300));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lienzoImagen2D2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoImagen2D2MouseMoved(evt);
            }
        });
        lienzoImagen2D2.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(lienzoImagen2D2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        forma = lienzoImagen2D2.getForma();
        grosor = lienzoImagen2D2.getGrosor();
        mover = lienzoImagen2D2.isMover();
        alisar = lienzoImagen2D2.isAlisado();
        relleno = lienzoImagen2D2.isRelleno();
        puntoMov = getPuntoMov();
        
        parent.ActualizarVInterna(grosor, forma, relleno, trans, alisar, mover);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        puntoMov = evt.getPoint();
    }//GEN-LAST:event_formMouseMoved

    // METODO PARA REINICIAR VALORES CUANDO NO HAY NINGUNA VENTANA INTERNA
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Función para indicar el punto del pixel sobre el que se encuentra el ratón,
     * así como su valor RGB
     */
    private void lienzoImagen2D2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoImagen2D2MouseMoved
        try{ 
            /** 
             * El método getRGB devuelve un entero con el pixel en el modelo de color por defecto
             * que es RGB
             */
            int pixel = lienzoImagen2D2.getImagen().getRGB(evt.getX(), evt.getY());
            /** 
             * Ahora, una vez obtenido el píxel en RGB, se puede desglosar en sus 
             * distintas bandas de color, para obtener el Int correspondiente
             */
            Color colorPixel = new Color(pixel);
            int r = colorPixel.getRed();
            int g = colorPixel.getGreen();
            int b = colorPixel.getBlue();
            /** 
             * Por último, se imprime el valor numérico correspondiente a las distintas
             * bandas de color que tenga el píxel en el que se encuentre en ratón
             */
            parent.getEstadoRGB().setText("     R: "+ String.valueOf(r) + " G: " + String.valueOf(g) + " B: " + String.valueOf(b) + "     ");
            /**
             * Para la posición X,Y del ratón basta con obtener los valores de 
             * dichas coordenadas del punto en el que está situado el ratón
             */
            parent.getEstadoPunto().setText( "     (" + evt.getX() + "," + evt.getY() + ")     ");
        }catch(Exception ex){
            parent.getEstadoPunto().setText(" ");
        }
    }//GEN-LAST:event_lienzoImagen2D2MouseMoved


    public void inicia (VentanaPrincipalPFinal Parent) {
        initComponents();
        this.setTitle(" Nuevo Lienzo");
        /**
         * Usaremos esta variable para actualizar el estado de la ventana principal(punto, linea, color que tenga, grosor, etc) 
         */
        parent = Parent;
        lienzoImagen2D2.iniciar();
        forma = lienzoImagen2D2.getForma();
        grosor = lienzoImagen2D2.getGrosor();
        mover = lienzoImagen2D2.isMover();
        alisar = lienzoImagen2D2.isAlisado();
        relleno = lienzoImagen2D2.isRelleno();
        puntoMov = new Point(-10,-10);
        parent.ActualizarVInterna(grosor, forma, relleno, trans, alisar, mover);
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private sm.jrc.iu.LienzoImagen2D lienzoImagen2D2;
    // End of variables declaration//GEN-END:variables
}