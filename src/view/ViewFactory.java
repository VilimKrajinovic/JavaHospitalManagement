/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.console.ConsoleView;
import view.gui.GuiView;

/**
 *
 * @author amd
 */
public class ViewFactory{
    
    public static View getView(int n){
        switch(n){
            case 1:
                return new ConsoleView();
            case 2:
                return new GuiView();
            default:
                return null;
        } 
    }
}
