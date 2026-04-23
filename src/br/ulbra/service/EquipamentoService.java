/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

import br.ulbra.dao.EquipamentoDAO;
import br.ulbra.model.Equipamento;

import java.util.List;

public class EquipamentoService {

    private EquipamentoDAO dao;

    public EquipamentoService(EquipamentoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Equipamento equipamento) {

        if (equipamento.getTagPatrimonio() == null || equipamento.getTagPatrimonio().isEmpty()) {
            throw new RuntimeException("Tag do patrimôno obrigatório iiii];)'");
        }
        if (equipamento.getSala() == null || equipamento.getSala().isEmpty()) {
            throw new RuntimeException("Sala obrigatório iiii];)'");
        }

        dao.salvar(equipamento);
    }

    public List<Equipamento> listar() {
        return dao.listar();
    }

    public void atualizar(Equipamento equipamento) {
        dao.atualizar(equipamento);
    }

    public void deletar(int id_equipamento) {
        dao.deletar(id_equipamento);
    }

    public Equipamento buscar(int id_equipamento) {
        return dao.buscarPorId(id_equipamento);
    }
}