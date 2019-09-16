package principal;

import Connection.Conexao;
import DAO.UsuarioDAO;
import cifradecesar.CifraDeCesar;
import java.util.List;
import model.Usuario;
import view.Tela;

public class Principal {

    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });

//        System.out.println("********************");
//        System.out.println("** Cifra de César **");
//        System.out.println("********************");
//
//        CifraDeCesar cifra = new CifraDeCesar();
//
//        String mensagem = "valter ghert abcdefghijklmnopqrstuvwxyz";
//        
//        String mensagemCriptografada = cifra.criptografar(mensagem);
//        System.out.println("-----------------------");
//        System.out.println("Mensagem Criptografada");
//        System.out.println("-----------------------");
//        System.out.println(mensagemCriptografada);
//        System.out.println("-----------------------");
//
//        String mensagemDescriptografada = cifra.descriptografar(mensagemCriptografada);
//        System.out.println("-----------------------");
//        System.out.println("Mensagem Descriptografada");
//        System.out.println("-----------------------");
//        System.out.println(mensagemDescriptografada);
//        System.out.println("-----------------------");
//        
//        Conexao.obterConexao();
//        List<Usuario> lista = new UsuarioDAO().buscarTudo();
//        System.out.println("teste");
//        System.out.println(lista);

           
          CifraDeCesar cdc = new CifraDeCesar();
          System.out.println(cdc.criptografar("valter"));
          System.out.println(cdc.criptografar("ghert"));
    }

}
