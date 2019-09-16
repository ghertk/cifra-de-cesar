package controller;

import cifradecesar.CifraDeCesar;
import DAO.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;

public class LoginController {

    private CifraDeCesar cifraDeCesar;
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.cifraDeCesar = new CifraDeCesar();
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean efetuarLogin(String login, String senha) {
        try {
            String loginCriptografado = this.cifraDeCesar.criptografar(login);
            String senhaCriptografada = this.cifraDeCesar.criptografar(senha);

            System.out.println(login);
            System.out.println(senha);

            Usuario usuario = this.usuarioDAO.buscarPorLoginSenha(loginCriptografado, senhaCriptografada);
//            Usuario usuario = this.usuarioDAO.buscarPorLoginSenha(login, senha);

            if (usuario != null) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no momento do Login!");
            e.printStackTrace();
        }

        return false;
    }
}
