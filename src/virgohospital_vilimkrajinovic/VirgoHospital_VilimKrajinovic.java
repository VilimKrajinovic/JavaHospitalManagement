/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virgohospital_vilimkrajinovic;

import View.View;
import View.ViewFactory;

/**
 *
 * @author amd
 */
public class VirgoHospital_VilimKrajinovic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            View view = ViewFactory.getView(2); //change here

            view.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to start application");
        }
    }

}
