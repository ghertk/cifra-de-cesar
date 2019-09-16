package controller;

import dao.UsuarioDAO;
import cifradecesar.CifraDeCesar;
import model.Usuario;

public class CadastroController {

    private CifraDeCesar cifraDeCesar;
    private UsuarioDAO dao;

    public CadastroController() {
        this.dao = new UsuarioDAO();

        this.limpar();
    }

    public void inserirNovoUsuario(String login, String senha) throws Exception {
        String loginCriptografado = this.cifraDeCesar.criptografar(login);
        String senhaCriptografada = this.cifraDeCesar.criptografar(senha);

        Usuario usuario = new Usuario();
        usuario.setLogin(loginCriptografado);
        usuario.setSenha(senhaCriptografada);

        this.dao.inserir(usuario);
    }

    private void limpar() {
        this.cifraDeCesar = new CifraDeCesar();
    }
}
