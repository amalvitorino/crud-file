/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;

/**
 *
 * @author Amal
 */
public class Ficheiro {

    File bancoDados = new File("DB.dat");
    ArrayList<Pessoa> lista = new ArrayList();

    //Metodo para criar (BAse de dados em ficheiro)
    public void criar() {
        if (!bancoDados.exists()) {

            try {
                bancoDados.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
            }
            gravar(lista);

        }else{
            System.out.println("ficheiro existe");
        }
    }

    //Metodo para registar (Pessoa)
    public void registar(Pessoa p) {
        lista = (ArrayList<Pessoa>) lista1().clone();
        lista.add(p);
        gravar(lista);
    }

    //Metodo para apagar (Pessoa)
    public void eliminar(int id) {
        lista = (ArrayList<Pessoa>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        gravar(lista);
    }

    //Metodo para Editar (Pessoa)
    public void editar(int id, Pessoa p) {
        lista = (ArrayList<Pessoa>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId() == id) {
                lista.remove(i);
                lista.add(p);
                break;
            }
        }
        gravar(lista);
    }

    //Metodo para pesquisar
    public ArrayList<Pessoa> listaPesquisa(String nome) {
        lista = (ArrayList<Pessoa>) lista1().clone();
        ArrayList<Pessoa> listaP = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().toUpperCase().startsWith(nome.toUpperCase())) {
                listaP.add(lista.get(i));
            }
        }
        return listaP;

    }

    //Metodo para gravar os dados no ficheiro
    private void gravar(ArrayList<Pessoa> lista) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));
            objectOutputStream.writeObject(lista);
            objectOutputStream.close();
            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo para retornar todos os dados do ficheiro
    public  ArrayList<Pessoa> lista1() {
        try {

            FileInputStream readData = new FileInputStream(bancoDados);
            ObjectInputStream os = new ObjectInputStream(readData);

            lista = (ArrayList<Pessoa>) os.readObject();

            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
