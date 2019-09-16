package controller;

import cifradecesar.CifraDeCesar;
import DAO.UsuarioDAO;

public class LoginController {
    private CifraDeCesar cifraDeCesar;
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.cifraDeCesar = new CifraDeCesar();
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public boolean efetuarLogin(String login, String senha) {
        String loginCriptografado = this.cifraDeCesar.criptografar(login);
        String senhaCriptografada = this.cifraDeCesar.criptografar(senha);
        
//        this.usuarioDAO.buscarPorLoginSenha(loginCriptografado, senhaCriptografada);
        return true;
    }
}
