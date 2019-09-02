package principal;

import Connection.Conexao;
import cifradecesar.CifraDeCesar;

public class Principal {

    public static void main(String[] args) throws Exception {

        System.out.println("********************");
        System.out.println("** Cifra de César **");
        System.out.println("********************");

        CifraDeCesar cifra = new CifraDeCesar();

        String mensagem = "valter ghert abcdefghijklmnopqrstuvwxyz";
        
        String mensagemCriptografada = cifra.criptografar(mensagem);
        System.out.println("-----------------------");
        System.out.println("Mensagem Criptografada");
        System.out.println("-----------------------");
        System.out.println(mensagemCriptografada);
        System.out.println("-----------------------");

        String mensagemDescriptografada = cifra.descriptografar(mensagemCriptografada);
        System.out.println("-----------------------");
        System.out.println("Mensagem Descriptografada");
        System.out.println("-----------------------");
        System.out.println(mensagemDescriptografada);
        System.out.println("-----------------------");
        
        Conexao.obterConexao();
    }

}
