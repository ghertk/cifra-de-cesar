package principal;

import cifradecesar.CifraDeCesar;
import view.Tela;

public class Principal {

    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });

        CifraDeCesar cdc = new CifraDeCesar();
        System.out.println("valter ==> " + cdc.criptografar("valter"));
        System.out.println("ghert ==> " + cdc.criptografar("ghert"));
        System.out.println("teste ==> " + cdc.criptografar("teste"));
        System.out.println("darlan ==> " + cdc.criptografar("darlan"));
        System.out.println("testevalter ==> " + cdc.criptografar("testevalter"));
    }

}
