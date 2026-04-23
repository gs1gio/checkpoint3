/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

public class Equipamento {

    private int idEquipamento;
    private String tagPatrimonio;
    private String tipo;
    private String sala;

    public Equipamento() {
    }


    public Equipamento(int idEquipamento, String tagPatrimonio, String tipo, String sala) {
        this.idEquipamento = idEquipamento;
        this.tagPatrimonio = tagPatrimonio;
        this.tipo = tipo;
        this.sala = sala;
    }


    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getTagPatrimonio() {
        return tagPatrimonio;
    }

    public void setTagPatrimonio(String tagPatrimonio) {
        this.tagPatrimonio = tagPatrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return tagPatrimonio + " - " + tipo + " (" + sala + ")";
    }
}
 
    

