/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.dao.UsuarioDAOImpl;
import br.ulbra.model.Usuario;
import br.ulbra.service.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        this.service = new UsuarioService(new UsuarioDAOImpl());
    }

    public String cadastrar(String nome, String cargo, String email,
            String senha) {

        try {
            Usuario usuario = new Usuario();

            usuario.setNome(nome);
            usuario.setCargo(cargo);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            service.cadastrar(usuario);

            return "Cadastro de usuário aberto com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public String atualizar(int id_usuario, String nome, String cargo, String email,
            String senha) {

        try {
            Usuario usuario = new Usuario();
            usuario.setId_usuario(id_usuario);
            usuario.setNome(nome);
            usuario.setCargo(cargo);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            service.atualizar(usuario);

            return "Usuário atualizado com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(int id_usuario) {

        try {
            service.deletar(id_usuario);
            return "Usuário deletado com sucesso iiii];)'";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}