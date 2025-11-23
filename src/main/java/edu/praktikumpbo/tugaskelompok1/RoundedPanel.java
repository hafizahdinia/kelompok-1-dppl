package edu.praktikumpbo.tugaskelompok1;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
    public class RoundedPanel extends JPanel {
        private int arcWidth;
        private int arcHeight;

        public RoundedPanel(int arcWidth, int arcHeight) {
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Gambar latar belakang dengan sudut melengkung
            RoundRectangle2D rounded = new RoundRectangle2D.Double(
                0, 0, getWidth(), getHeight(), arcWidth, arcHeight
            );
            g2d.setColor(getBackground());
            g2d.fill(rounded);
            
            super.paintComponent(g);
        }

        @Override
        public void paintBorder(Graphics g) {
            // Kosongkan border default
        }
    }
