package cifradecesar;

public class CifraDeCesar {

    private final int CHAVE_CRIPTOGRAFIA = 27;
    private final char[] alfabeto;
    private final char[] alfabetoCriptografado;
    private final char offset = 'a';

    public CifraDeCesar() {
        alfabeto = new char[26];
        for (int i = 0; i < alfabeto.length; i++) {
            alfabeto[i] = (char) (offset + i);
        }
        alfabetoCriptografado = new char[]{
            'c', 'e', 'd', 'q', 'n', 'j', 'b', 'f', 'w', 'g', 'v', 'l', 'i',
            'o', 'x', 'h', 'a', 'm', 't', 'r', 's', 'u', 'y', 'k', 'p', 'z'
        };
    }

    public String criptografar(String conteudo) {
        String retorno = "";
        char[] letras = conteudo.toCharArray();

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == ' ') {
                retorno += ' ';
                continue;
            }
            for (int j = 0; j < alfabeto.length; j++) {
                if (alfabeto[j] == letras[i]) {
                    retorno += alfabetoCriptografado[((j + CHAVE_CRIPTOGRAFIA) % alfabeto.length)];
                }
            }
        }

        return retorno;
    }

    public String descriptografar(String conteudoCriptografado) {
        String retorno = "";

        char[] letras = conteudoCriptografado.toCharArray();

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == ' ') {
                retorno += ' ';
                continue;
            }
            for (int j = 0; j < alfabetoCriptografado.length; j++) {
                if (alfabetoCriptografado[j] == letras[i]) {
                    retorno += alfabeto[((alfabeto.length - (CHAVE_CRIPTOGRAFIA % alfabeto.length) + j) % alfabeto.length)];
                }
            }
        }

        return retorno;
    }
}
