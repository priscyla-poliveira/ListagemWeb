/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.prova2;

/**
 *
 * @author ftsuda-senac
 */
public class Responsavel {

    private Integer id;

    private String nome;

    public Responsavel() {
    }

    public Responsavel(String nome) {
        this.nome = nome;
    }

    public Responsavel(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
