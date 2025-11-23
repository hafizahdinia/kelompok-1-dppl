/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.tugaskelompok1;

/**
 *
 * @author Lenovo
 */
public class TugasKelompok1 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            SistemFrame frame = new SistemFrame();
            frame.changeMainPanel(new LoginPagePanel(frame));
            frame.setVisible(true);
        });
    }
}
