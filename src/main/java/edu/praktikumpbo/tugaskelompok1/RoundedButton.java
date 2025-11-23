package edu.praktikumpbo.tugaskelompok1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private int arcWidth;
    private int arcHeight;

    public RoundedButton(String text, int arcWidth, int arcHeight) {
        super(text);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
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
