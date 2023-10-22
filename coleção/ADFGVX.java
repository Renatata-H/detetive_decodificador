public class ADFGVX {

    public static void
    copia_vetor(char[][] matriz, char[] lista_alvo, int i) {
        int j = 0;
        while (j < matriz.length) {
            lista_alvo[j] = matriz[j][i];
            j = j + 1;
        }
    }

    public static void
    imprime_matriz(char matriz[][]) {
        int i = 0, j;

        while (i < matriz.length) {
            j = 0;
            while (j < matriz[0].length) {
                System.out.print(matriz[i][j]+" ");
                j = j + 1;
            }
            System.out.println();
            i = i + 1;
        }
    }

    public static void
    mergeSort(char[] lista, int inicio, int fim) {

        if (fim == inicio+1) {
            return;
        }
        
        int meio = (inicio+fim)/2;
        char[] temporario = new char[fim-inicio];

        //char [] lista_esquerda = lista.slice(inicio,meio);
        //char [] lista_direita = lista.slice(meio,fim); 

        mergeSort(lista,inicio,meio);
        mergeSort(lista,meio,fim);

        int i = inicio, j = meio, k = 0;
        while (i < meio && j < fim) {
            if (lista[i] > lista[j]) {
                temporario[k] = lista[j];
                j = j + 1;
            } else if (lista[i] < lista[j]) {
                temporario[k] = lista[i];
                i = i + 1;
            } else {
                temporario[k] = lista[i];
                temporario[k+1] = lista[j];
                i = i + 1;
                j = j + 1;
                k = k + 1;
            }
            k = k + 1;
        }

        while (i < meio) {
            temporario[k] = lista[i];
            k = k + 1;
            i = i + 1;
        }
        while (j < fim) {
            temporario[k] = lista[j];
            k = k + 1;
            j = j + 1;
        }

        i = 0; j = fim-inicio;
        while (i < j) {
            lista[i+inicio] = temporario[i];
            i = i + 1;
        }

        return;
    }

    public static void
    main (String args[]) {

        char[][] tabela = { {'N','A','1','C','3','H'},
                            {'8','T','B','2','O','M'},
                            {'E','5','W','R','P','D'},
                            {'4','F','6','G','7','I'},
                            {'9','J','0','K','L','Q'},
                            {'S','U','V','X','Y','Z'} };
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
        imprime_matriz(transposicao_colunar);

        char[] guarda_coluna = new char[quantidade_linhas];
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

        // Organiza as colunas de acordo com a numeração;
        i = 0;
        while (i < quantidade_colunas) {
            int posicao_desejada = numeracao_chave[i];
            if (i != posicao_desejada) {
                copia_vetor(transposicao_colunar,guarda_coluna,posicao_desejada);
                
                j = 0;
                while (j < quantidade_linhas) {
                    transposicao_colunar[j][posicao_desejada] = transposicao_colunar[j][i];
                    j = j + 1;
                }              
    
                j = 0;
                while (j < quantidade_linhas) {
                    transposicao_colunar[j][i] = guarda_coluna[j];
                    j = j + 1;
                }           
            }
            i = i + 1;
        }



        System.out.println();
        i = 0;
        while (i < numeracao_chave.length) {
            System.out.print(numeracao_chave[i]+" ");
            i = i + 1;
        }   System.out.println();


        
    }
}
