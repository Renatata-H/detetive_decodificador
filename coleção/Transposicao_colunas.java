public class Transposicao_colunas {
    // Não finalizado >:(

    public static String
    criptografa(String texto, String chave) {
        String novo_texto = "";
        char letra;

        // Numera as letras da chave
        int tamanho_chaves = chave.length();
        int i = 0, j, k = 0;
        int[] numeracao = new int[tamanho_chaves];
        while (i < 52) {
            
            if (i < 26) {
                letra = (char) (i + 97);
            } else {
                letra = (char) (i + 39);
            }

            j = 0;
            while (j < tamanho_chaves) {
                if (chave.charAt(j) == letra) {
                    numeracao[j] = k;
                    k = k + 1;
                }             
                j = j + 1;
            }
            i = i + 1;
        }

        // FAZER GAMBIARRA PRA TIRAR ESPAÇOS
        int tamanho_texto = texto.length();

        // Cria novo_texto;
        boolean achou_todos = false;
            double temp = (double) tamanho_texto;
        int quantidade_linhas = (int) Math.ceil(temp/tamanho_chaves);    
        int l; k = 0;
        while (!achou_todos) {
            i = 0;
            while (i < tamanho_chaves) {
                if (numeracao[i] == k) {

                    l = 0; 
                    while (l < quantidade_linhas) {
                        if (i+l*tamanho_chaves < tamanho_texto) {
                            novo_texto = novo_texto + texto.charAt(i+l*tamanho_chaves);
                        }
                        l = l + 1;
                    }
                    k = k + 1;
                    if (k == tamanho_chaves) {
                        achou_todos = true;
                        i = tamanho_chaves;
                    } 
                }
                i = i + 1;
            }
        }

        return novo_texto;
    }
    
    public static void
    main (String args[]) {

        String codigo = criptografa(args[1], args[0]);
        System.out.println(codigo);

    }
}
