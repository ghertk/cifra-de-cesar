package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Contato;

public class ContatoDAO {

    Connection conexao;

    public void inserir(Contato contato) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" INSERT INTO contato (nome, celular, cidade, email) VALUES (?, ?, ?, ?);");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getCelular());
            stmt.setString(3, contato.getCidade());
            stmt.setString(4, contato.getEmail());
            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
    }

    public void alterar(Contato contato) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" UPDATE contato SET nome = ?, celular = ?, cidade = ?, email = ? WHERE id = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getCelular());
            stmt.setString(3, contato.getCidade());
            stmt.setString(4, contato.getEmail());
            stmt.setLong(5, contato.getId());
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
                    .append(" DELETE FROM contato WHERE id = ?;");

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

    public Contato buscarPorId(Long id) throws Exception {
        Contato contato = null;
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" SELECT id, nome, celular, cidade, email FROM contato WHERE id = ?;");

            this.conexao = Conexao.obterConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setCelular(rs.getString("celular"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
                System.out.println(contato.toString());
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.conexao.close();
        }
        return contato;
    }

    public List<Contato> buscarTudo() throws Exception {
        List<Contato> lista = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("")
                    .append(" SELECT id, nome, celular, cidade, email FROM contato;");

            Connection conexao = Conexao.obterConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setCelular(rs.getString("celular"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
                lista.add(contato);
            }

            stmt.close();
            rs.close();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}