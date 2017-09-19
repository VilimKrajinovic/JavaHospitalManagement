/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui;

import java.awt.EventQueue;

/**
 *
 * @author amd
 */
public class GuiView implements View.View {

    @Override
    public void initialize() {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e){
            
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartMenu().setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }
    
}
