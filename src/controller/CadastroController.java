package controller;

import DAO.UsuarioDAO;
import cifradecesar.CifraDeCesar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

public class CadastroController {

    private CifraDeCesar cifraDeCesar;
    private UsuarioDAO dao;

    public CadastroController() {
        this.dao = new UsuarioDAO();

        this.limpar();
    }

    public void inserirNovoUsuario(String login, String senha) {
        try {
            String loginCriptografado = this.cifraDeCesar.criptografar(login);
            String senhaCriptografada = this.cifraDeCesar.criptografar(senha);

            Usuario usuario = new Usuario();
            usuario.setLogin(loginCriptografado);
            usuario.setSenha(senhaCriptografada);

            this.dao.inserir(usuario);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Inserir novo Usuário!");
            ex.printStackTrace();
        }
    }

    private void limpar() {
        this.cifraDeCesar = new CifraDeCesar();
    }
}
