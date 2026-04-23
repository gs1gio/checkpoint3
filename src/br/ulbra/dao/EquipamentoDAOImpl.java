/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Equipamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAOImpl implements EquipamentoDAO {

    @Override
    public void salvar(Equipamento equipamento) {

        String sql = "INSERT INTO equipamento "
                + "(tag_patrimonio, tipo, sala) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTagPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Equipamento> listar() {

        String sql = "SELECT * FROM equipamento";
        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Equipamento c = new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("tipo"),
                        rs.getString("sala")
                );

                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Equipamento buscarPorId(int id_equipamento) {

        String sql = "SELECT * FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_equipamento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("tipo"),
                        rs.getString("sala")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Equipamento equipamento) {

        String sql = "UPDATE equipamento SET "
                + "tag_patrimonio = ?, tipo = ?, sala = ? WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTagPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getSala());
            stmt.setInt(4, equipamento.getIdEquipamento());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(int id_equipamento) {

        String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_equipamento);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
