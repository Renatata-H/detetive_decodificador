public class ADFGVX {

    public static void
    main (String args[]) {

        char[][] tabela = { {'N','A','1','C','3','H'},
                            {'8','T','B','2','O','M'},
                            {'E','5','W','R','P','D'},
                            {'4','F','6','G','7','I'},
                            {'9','J','0','K','L','Q'},
                            {'S','U','V','X','Y','Z'} };
        // Código do alfabeto: NA1C3H8TB2OME5WRPD4F6G7I9J0KLQSUVXYZ
        
        char[] letras = {'A','D','F','G','V','X'}; 

        String texto = args[0], chave = args[1], novo_texto = "";
        int i = 0, tamanho_texto = texto.length(), j, k;

        // Usa quadrado de Políbio;
        while (i < tamanho_texto) {
            j = 0;

            while (j < 6) {
                k = 0;

                while (k < 6) {
                    int letra = tabela[j][k];
                    letra = letra + 32;
                    char letra_buffer = (char) letra;
                    
                    if (tabela[j][k] == texto.charAt(i) || texto.charAt(i) == letra_buffer) {
                        novo_texto = novo_texto + letras[j] + letras[k];
                        k = 6; j = 6;
                    }
                    k = k + 1;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println(novo_texto);

        // Cria matriz para transposição;
        int quantidade_linhas = (int) Math.ceil((float) novo_texto.length()/ (float) chave.length());
        int quantidade_colunas = chave.length();
        char[][] transposicao_colunar = new char[quantidade_linhas][quantidade_colunas];

        // Insere resultado do quadrado de Políbio na matriz;
        i = 0; k = 0;
        while (i < quantidade_linhas) {
            j = 0;
            while (j < quantidade_colunas) {

                if (k < novo_texto.length()) {
                    transposicao_colunar[i][j] = novo_texto.charAt(k);
                    k = k + 1;
                } else {
                    transposicao_colunar[i][j] = '*';
                }
                
                j = j + 1;
            }
            i = i + 1;
        }

        int[] numeracao_chave = new int[quantidade_colunas];

        // Cria numeração para cada letra da chave
        i = 0; k = 0;
        while (i < 52) {
            
            char letra;
            if (i < 26) {
                letra = (char) (i + 97);
            } else {
                letra = (char) (i + 39);
            }

            j = 0;
            while (j < quantidade_colunas) {
                if (chave.charAt(j) == letra) {
                    numeracao_chave[j] = k;
                    k = k + 1;
                }
                j = j + 1;
            }
            i = i + 1;
        }

        // Printa as colunas;
        i = 0; 
        while (i < quantidade_colunas) {
            k = 0;
            while (k < quantidade_colunas) {
                if (numeracao_chave[k] == i) {
                    break;
                }
                k = k + 1;
            } 

            j = 0;
            while (j < quantidade_linhas) {
                char caractere = transposicao_colunar[j][k];
                if (caractere != '*') {
                    System.out.print(caractere);
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
}
