package edu.praktikumpbo.tugaskelompok1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class SistemFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SistemFrame.class.getName());

    /**
     * Creates new form SistemFrame
     */
    public SistemFrame() {
        initComponents();
        this.setMinimumSize(new java.awt.Dimension(360,640));
        mainPanel.setLayout(new java.awt.BorderLayout());
        this.setSize(360,640);
        this.setPreferredSize(new java.awt.Dimension(360,640));
        this.setLocationRelativeTo(null);

        // Setup navigator panel
        setupNavigatorPanel();
        navigatorPanel.setVisible(false); // Hidden by default
    }

    private void setupNavigatorPanel() {
        navigatorPanel.setLayout(new java.awt.BorderLayout());

        // Back button (initially hidden)
        javax.swing.JButton backButton = new javax.swing.JButton("←");
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        backButton.setForeground(new java.awt.Color(39, 67, 32));
        backButton.setBackground(new java.awt.Color(188, 237, 90));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new java.awt.Dimension(50, 35));
        backButton.setVisible(false);
        backButton.setName("backButton"); // For easy access

        // Menu button (three dots)
        javax.swing.JButton menuButton = new javax.swing.JButton("⋯");
        menuButton.setFont(new java.awt.Font("Segoe UI", 1, 24));
        menuButton.setForeground(new java.awt.Color(39, 67, 32));
        menuButton.setBackground(new java.awt.Color(188, 237, 90));
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        menuButton.setPreferredSize(new java.awt.Dimension(50, 35));
        menuButton.addActionListener(e -> showQuickNavMenu(menuButton));

        navigatorPanel.add(backButton, java.awt.BorderLayout.WEST);
        navigatorPanel.add(menuButton, java.awt.BorderLayout.EAST);
    }

    private void showQuickNavMenu(java.awt.Component invoker) {
        javax.swing.JPopupMenu popupMenu = new javax.swing.JPopupMenu();
        popupMenu.setBackground(new java.awt.Color(245, 255, 251));

        javax.swing.JMenuItem dashboardItem = new javax.swing.JMenuItem("Dashboard");
        javax.swing.JMenuItem buatAjuanItem = new javax.swing.JMenuItem("Buat Ajuan");
        javax.swing.JMenuItem riwayatItem = new javax.swing.JMenuItem("Riwayat Ajuan");
        javax.swing.JMenuItem kalenderItem = new javax.swing.JMenuItem("Kalender");
        javax.swing.JMenuItem logoutItem = new javax.swing.JMenuItem("Logout");

        // Style menu items
        for (javax.swing.JMenuItem item : new javax.swing.JMenuItem[]{
            dashboardItem, buatAjuanItem, riwayatItem, kalenderItem, logoutItem}) {
            item.setForeground(new java.awt.Color(39, 67, 32));
            item.setFont(new java.awt.Font("Segoe UI", 0, 12));
        }

        dashboardItem.addActionListener(e -> changeMainPanel(new DashboardPengajuPanel(this)));
        buatAjuanItem.addActionListener(e -> changeMainPanel(new FormMahasiswaPanel(this)));
        riwayatItem.addActionListener(e -> changeMainPanel(new RiwayatPanel(this)));
        kalenderItem.addActionListener(e -> changeMainPanel(new KalenderPanel(this)));
        logoutItem.addActionListener(e -> {
            changeMainPanel(new LoginPagePanel(this));
            navigatorPanel.setVisible(false);
        });

        popupMenu.add(dashboardItem);
        popupMenu.add(buatAjuanItem);
        popupMenu.add(riwayatItem);
        popupMenu.add(kalenderItem);
        popupMenu.addSeparator();
        popupMenu.add(logoutItem);

        popupMenu.show(invoker, 0, invoker.getHeight());
    }

    public void setBackButtonVisible(boolean visible) {
        for (java.awt.Component comp : navigatorPanel.getComponents()) {
            if (comp instanceof javax.swing.JButton) {
                javax.swing.JButton btn = (javax.swing.JButton) comp;
                if ("backButton".equals(btn.getName())) {
                    btn.setVisible(visible);
                    break;
                }
            }
        }
    }

    public void setBackButtonAction(java.awt.event.ActionListener action) {
        for (java.awt.Component comp : navigatorPanel.getComponents()) {
            if (comp instanceof javax.swing.JButton) {
                javax.swing.JButton btn = (javax.swing.JButton) comp;
                if ("backButton".equals(btn.getName())) {
                    // Remove old listeners
                    for (java.awt.event.ActionListener al : btn.getActionListeners()) {
                        btn.removeActionListener(al);
                    }
                    btn.addActionListener(action);
                    break;
                }
            }
        }
    }
    
        public void changeMainPanel(javax.swing.JPanel panel){
        mainPanel.removeAll();
        
        if (panel instanceof FormMahasiswaPanel || panel instanceof FormEksternalPanel) {
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBorder(null);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);

            // Custom scrollbar appearance
            scrollPane.getVerticalScrollBar().setBackground(new java.awt.Color(245, 255, 251));
            scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = new java.awt.Color(188, 237, 90);
                    this.trackColor = new java.awt.Color(245, 255, 251);
                }

                @Override
                protected javax.swing.JButton createDecreaseButton(int orientation) {
                    return createZeroButton();
                }

                @Override
                protected javax.swing.JButton createIncreaseButton(int orientation) {
                    return createZeroButton();
                }

                private javax.swing.JButton createZeroButton() {
                    javax.swing.JButton button = new javax.swing.JButton();
                    button.setPreferredSize(new java.awt.Dimension(0, 0));
                    return button;
                }
            });

            mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        } else {
            mainPanel.add(panel, java.awt.BorderLayout.CENTER);
        }
            
        mainPanel.add(panel, java.awt.BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();

    }
        
     public void setNavigatorVisible(boolean visible) {
        navigatorPanel.setVisible(visible);
}

    public javax.swing.JPanel getNavigatorPanel() {
        return navigatorPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigatorPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        navigatorPanel.setBackground(new java.awt.Color(188, 237, 90));

        javax.swing.GroupLayout navigatorPanelLayout = new javax.swing.GroupLayout(navigatorPanel);
        navigatorPanel.setLayout(navigatorPanelLayout);
        navigatorPanelLayout.setHorizontalGroup(
            navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        navigatorPanelLayout.setVerticalGroup(
            navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navigatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new SistemFrame().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navigatorPanel;
    // End of variables declaration//GEN-END:variables
}
