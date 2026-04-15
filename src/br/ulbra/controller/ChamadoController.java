package br.ulbra.controller;

import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;

import java.util.List;

public class ChamadoController {

    private ChamadoService service;

    public ChamadoController() {
        this.service = new ChamadoService(new ChamadoDAOImpl());
    }

    public String cadastrar(String solicitante, String sala, String equipamentoTag,
                            String problemaRelatado, String diagnosticoTecnico,
                            String prioridade, String status, String dataAbertura) {

        try {
            Chamado chamado = new Chamado();

            chamado.setSolicitante(solicitante);
            chamado.setSala(sala);
            chamado.setEquipamentoTag(equipamentoTag);
            chamado.setProblemaRelatado(problemaRelatado);
            chamado.setDiagnosticoTecnico(diagnosticoTecnico);
            chamado.setPrioridade(prioridade);
            chamado.setStatus(status);
            chamado.setDataAbertura(dataAbertura);

            // regra do sistema
            chamado.setStatus("PENDENTE");

            service.cadastrar(chamado);

            return "Chamado aberto com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(int id, String solicitante, String sala, String equipamentoTag,
                            String problemaRelatado, String diagnosticoTecnico,
                            String prioridade, String status, String dataAbertura) {

        try {
            Chamado chamado = new Chamado();

            chamado.setId(id);
            chamado.setSolicitante(solicitante);
            chamado.setSala(sala);
            chamado.setEquipamentoTag(equipamentoTag);
            chamado.setProblemaRelatado(problemaRelatado);
            chamado.setDiagnosticoTecnico(diagnosticoTecnico);
            chamado.setPrioridade(prioridade);
            chamado.setStatus(status);
            chamado.setDataAbertura(dataAbertura);

            service.atualizar(chamado);

            return "Chamado atualizado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(int id) {

        try {
            service.deletar(id);
            return "Chamado deletado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}