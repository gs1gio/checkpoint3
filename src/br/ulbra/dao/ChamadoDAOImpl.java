package br.ulbra.dao;

import br.ulbra.model.Chamado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ChamadoDAOImpl implements ChamadoDAO {

    @Override
    public void salvar(Chamado chamado) {
//id solicitante sala equipamento_tag problema_relatado diagnostico_tecnico prioridade status data_abertura
        String sql = "INSERT INTO chamado_tecnico "
                + "(solicitante, sala, equipamento_tag, problema_relatado, diagnostico_tecnico, prioridade, status, data_abertura) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getSala());
            stmt.setString(3, chamado.getEquipamentoTag());
            stmt.setString(4, chamado.getProblemaRelatado());
            stmt.setString(5, chamado.getDiagnosticoTecnico());
            stmt.setString(6, chamado.getPrioridade());
            stmt.setString(7, chamado.getStatus());
            stmt.setString(8, chamado.getDataAbertura());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Chamado> listar() {

        String sql = "SELECT * FROM chamado_tecnico";
        List<Chamado> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Chamado c = new Chamado(
                        rs.getInt("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );

                lista.add(c);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro:"+ e.getMessage());
        }

        return lista;
    }

    @Override
    public Chamado buscarPorId(int id) {

        String sql = "SELECT * FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Chamado(
                        rs.getInt("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Chamado chamado) {

        String sql = "UPDATE chamado_tecnico SET "
                + "solicitante = ?, sala = ?, equipamento_tag = ?, problema_relatado = ?, "
                + "diagnostico_tecnico = ?, prioridade = ?, status = ?, data_abertura = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getSala());
            stmt.setString(3, chamado.getEquipamentoTag());
            stmt.setString(4, chamado.getProblemaRelatado());
            stmt.setString(5, chamado.getDiagnosticoTecnico());
            stmt.setString(6, chamado.getPrioridade());
            stmt.setString(7, chamado.getStatus());
            stmt.setString(8, chamado.getDataAbertura());
            stmt.setInt(9, chamado.getId());
            

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id) {

        String sql = "DELETE FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}