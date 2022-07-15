package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Amal
 */
public class Pessoa implements Serializable{

    private String nome, morada;
    private int idade;
    private int id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
