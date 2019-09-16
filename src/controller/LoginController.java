package controller;

import cifradecesar.CifraDeCesar;
import dao.UsuarioDAO;
import model.Usuario;

public class LoginController {

    private CifraDeCesar cifraDeCesar;
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.cifraDeCesar = new CifraDeCesar();
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean efetuarLogin(String login, String senha) throws Exception {
        String loginCriptografado = this.cifraDeCesar.criptografar(login);
        String senhaCriptografada = this.cifraDeCesar.criptografar(senha);

        Usuario usuario = this.usuarioDAO.buscarPorLoginSenha(loginCriptografado, senhaCriptografada);

        if (usuario != null) {
            return true;
        }

        return false;
    }
}
