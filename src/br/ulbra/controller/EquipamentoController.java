/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.dao.EquipamentoDAOImpl;
import br.ulbra.model.Equipamento;
import br.ulbra.service.EquipamentoService;

import java.util.List;

public class EquipamentoController {

    private EquipamentoService service;

    public EquipamentoController() {
        this.service = new EquipamentoService(new EquipamentoDAOImpl());
    }

    public String cadastrar(String tagPatrimonio, String tipo, String sala) {

        try {
            Equipamento equipamento = new Equipamento();

            equipamento.setTagPatrimonio(tagPatrimonio);
            equipamento.setTipo(tipo);
            equipamento.setSala(sala);

            service.cadastrar(equipamento);

            return "Cadastro de equipamento aberto com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Equipamento> listar() {
        return service.listar();
    }

    public String atualizar(int id_equipamento, String tagPatrimonio, String tipo, String sala) {

        try {
            Equipamento equipamento = new Equipamento();
            equipamento.setIdEquipamento(id_equipamento);
            equipamento.setTagPatrimonio(tagPatrimonio);
            equipamento.setTipo(tipo);
            equipamento.setSala(sala);

            service.atualizar(equipamento);

            return "Equipamento atualizado com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(int id_equipamento) {

        try {
            service.deletar(id_equipamento);
            return "Equipamento deletado com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}
