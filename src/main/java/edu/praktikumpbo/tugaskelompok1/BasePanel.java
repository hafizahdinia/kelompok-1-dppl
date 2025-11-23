/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.tugaskelompok1;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;

/**
 * Base class untuk semua Panel yang butuh changeMainPanel
 */
public class BasePanel extends JPanel {
    
    protected SistemFrame parentFrame;
    
    public BasePanel(SistemFrame frame) {
        this.parentFrame = frame;
    }
    
    /**
     * Convenience method untuk mengganti main panel
     */
    protected void changeMainPanel(JPanel panel) {
        if (parentFrame != null) {
            parentFrame.changeMainPanel(panel);
        }
    }
}
