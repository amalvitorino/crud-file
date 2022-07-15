/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controle.Ficheiro;
import visao.Tela;

/**
 *
 * @author Amal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ficheiro f = new Ficheiro();
        f.criar();
        Tela t = new Tela();
        t.setVisible(true);
    }
    
}
