/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

import br.ulbra.dao.UsuarioDAO;
import br.ulbra.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatório iiii];)'");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new RuntimeException("Senha obrigatório iiii];)'");
        }

        dao.salvar(usuario);
    }

    public List<Usuario> listar() {
        return dao.listar();
    }

    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void deletar(int id_usuario) {
        dao.deletar(id_usuario);
    }

    public Usuario buscar(int id_usuario) {
        return dao.buscarPorId(id_usuario);
    }
}