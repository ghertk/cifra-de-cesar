package controller;

import dao.ContatoDAO;
import cifradecesar.CifraDeCesar;
import java.util.ArrayList;
import java.util.List;
import model.Contato;

public class ContatoController {
    
    private ContatoDAO contatoDAO;
    private CifraDeCesar cifraDeCesar;


    public ContatoController() {
        this.contatoDAO = new ContatoDAO();
        this.cifraDeCesar = new CifraDeCesar();
    }
    
    public void criarContato(String nome, String celular, String cidade, String email) throws Exception {
        this.contatoDAO.inserir(new Contato(nome, celular, cidade, email));
    }

    public List<Object[]> buscarUsuarios() throws Exception {
        List<Object[]> rows = new ArrayList<>();
        for (Contato contato : this.contatoDAO.buscarTudo()) {
            Object[] row = {
                contato.getId(),
                contato.getNome(),
                contato.getEmail(),
                contato.getCelular(),
                contato.getCidade()
            };
            rows.add(row);
        }
        return rows;
    }
}
