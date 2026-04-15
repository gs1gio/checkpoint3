package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.model.Chamado;

import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao;

    public ChamadoService(ChamadoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Chamado chamado) {

        if (chamado.getSolicitante() == null || chamado.getSolicitante().isEmpty()) {
            throw new RuntimeException("Nome do Solicitante obrigatório");
        }

        if (chamado.getEquipamentoTag() == null || chamado.getEquipamentoTag().isEmpty()) {
            throw new RuntimeException("Equipamento tag obrigatório");
        }
        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado) {
        dao.atualizar(chamado);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }

    public Chamado buscar(int id) {
        return dao.buscarPorId(id);
    }
}