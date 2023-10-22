public class Cifra_de_polibio {
    
    public static String
    criptografa (String texto, String alfabeto, String simbolos) {
        // OBRIGATORIAMENTE 6 SÍMBOLOS

        if (alfabeto.length() == 0) {
            alfabeto = "NA1C3H8TB2OME5WRPD4F6G7I9J0KLQSUVXYZ";
        } 

        String novo_texto = "";
        int tamanho_texto = texto.length();
        int tamanho_alfabeto_real = alfabeto.length();
        int tamanho_alfabeto;

        if (tamanho_alfabeto_real < 36) {
            tamanho_alfabeto = tamanho_alfabeto_real;
        } else {
            tamanho_alfabeto = 36;
        }

        // Quociente da divisão inteira vai ser a linha
        // Resto da divisão inteira vai ser a coluna
        int i = 0, j;

        while (i < tamanho_texto) {
            j = 0;
            while (j < tamanho_alfabeto) {
                    int letra = texto.charAt(i);
                    char outra_letra = ' ';

                    // Se a letra for maiscula / minuscula
                    if (letra >= 65 && letra <= 90) {
                        outra_letra = (char) (letra+32);
                    } else if (letra >= 97 && letra <= 122) {
                        outra_letra = (char) (letra-32);
                    }

                    if (alfabeto.charAt(j) == texto.charAt(i) || alfabeto.charAt(j) == outra_letra) {
                        novo_texto = novo_texto + simbolos.charAt(j/6) + simbolos.charAt(j%6);
                        j = tamanho_alfabeto;
                    } 

                j = j + 1;
            } 
            i = i + 1;
        }

        return novo_texto;
    }

    public static String
    descriptografa (String texto, String alfabeto, String simbolos) {

        if (alfabeto.length() == 0) {
            alfabeto = "NA1C3H8TB2OME5WRPD4F6G7I9J0KLQSUVXYZ";
        } 

        String novo_texto = "";
        int tamanho_texto = texto.length();

        int i = 0, j;
        int coordenada_linha = -1, coordenada_coluna = -1;

        while (i < tamanho_texto) {
            j = 0;
            while (j < 6) {
                if (texto.charAt(i) == simbolos.charAt(j)) {
                    coordenada_linha = j;
                }
                j = j + 1;
            }
            i = i + 1;
            j = 0;
            while (j < 6) {
                if (texto.charAt(i) == simbolos.charAt(j)) {
                    coordenada_coluna = j;
                }
                j = j + 1;
            }
            if (coordenada_coluna == -1 || coordenada_linha == -1) {
                return "Erro! Esse texto cifrado não foi gerado pelo conjunto de símbolos fornecido.";
            }
            i = i + 1;

            novo_texto = novo_texto + alfabeto.charAt((6*coordenada_linha) + coordenada_coluna);
        }

        return novo_texto;
    }

    public static void
    main (String args[]) {
        /* Dado como argumento a chave de seis caracters, um modo de execução e um texto
         * (nessa ordem), um alfabeto opcionalmente , criptografa ou descriptografa tal texto com a
         * cifra de Políbio.
         */

        String alfabeto;
        if (args.length > 3) {
            alfabeto = args[3];
        } else {
            alfabeto = "";
        }

        String texto = args[2];
        String seis_simbolos = args[0];
        String modo = args[1];

        if (seis_simbolos.length() > 6) {
            System.out.println("Erro! Tamanho de chave inválida!");
        } else {

            String codigo; 
            if (modo.equals("criptografa")) {
                codigo = criptografa(texto, alfabeto, seis_simbolos);
                System.out.println(codigo);
            } else if (modo.equals("descriptografa")) {
                codigo = descriptografa(texto, alfabeto, seis_simbolos);
                System.out.println(codigo);
            } else {
                System.out.println("Erro! Modo de execução inválido.");
            }
        }
    }
}
