package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    Connection conexao;

    public void inserir(Usuario usuario) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" INSERT INTO usuario (login, senha) VALUES (?, ?);");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
    }

    public void alterar(Usuario usuario) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" UPDATE usuario SET login = ?, senha = ? WHERE id = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setLong(3, usuario.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
    }

    public void deletar(Long id) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" DELETE FROM usuario WHERE id = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setLong(1, id);
            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
    }

    public Usuario buscarPorLoginSenha(String login, String senha) throws Exception {
        Usuario usuario = null;
        try {

            StringBuilder sql = new StringBuilder("")
                    .append(" SELECT id, login, senha FROM usuario WHERE login = ? AND senha = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
        return usuario;
    }

    public Usuario buscarPorId(Long id) throws Exception {
        Usuario usuario = null;
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" SELECT id, login, senha FROM usuario WHERE id = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
        return usuario;
    }

    public List<Usuario> buscarTudo() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" SELECT id, login, senha FROM usuario;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
            
        return lista;
    }

}