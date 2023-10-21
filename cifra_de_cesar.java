public class cifra_de_cesar {

    public static int 
    ordem_lexicografica(String palavra1, String palavra2) {
        /* Dadas duas palavras, verifica qual delas é lexicofraficamente maior que
         * a outra. Se:
         * 
         * --> palavra1 > palavra2, então retorna um valor positivo;
         * --> palavra1 = palavra2, então retorna 0;
         * --> palavra1 < palavra2, então retorna um valor negativo.
         * 
         *  Note que, pela tabela ASCII, a < b < c < .... < z; e A < a.
         *  Se as uma palavra estiver contida em outra, por exemplo, temos que maca < macaco.
         * 
         *  Funciona bem apenas para palavras individuais, sem caracteres especiais. como acentos.
         */
       int i = 0;

       int tamanho_palavra1, tamanho_palavra2;
       tamanho_palavra1 = palavra1.length();
       tamanho_palavra2 = palavra2.length();

       int letra1, letra2;

       while (i < tamanho_palavra1 && i < tamanho_palavra2) {
            letra1 = palavra1.charAt(i);
            letra2 = palavra2.charAt(i);

            if (letra1 != letra2) {
                return letra1-letra2;
            }

            i = i + 1;
        }
       return tamanho_palavra1-tamanho_palavra2;
    }

    public static int 
    busca_binaria(String[] lista, String elemento) {
        /* Dado uma lista de N elementos organizados em ordem não-
         * decrescente e um elemento, verifica onde está esse elemento na lista.
         */
        
        int maximo, meio, minimo;
        maximo = lista.length - 1;
        minimo = 0;

        while (maximo >= minimo) {
            meio = (maximo+minimo)/2;

            if (ordem_lexicografica(lista[meio], elemento) > 0) {
                //System.out.println(lista[meio]+" é maior que "+elemento);
                maximo = meio - 1;

            } else if (ordem_lexicografica(lista[meio], elemento) < 0) {
                //System.out.println(lista[meio]+" é menor que "+elemento);
                minimo = meio + 1;

            } else {
                return meio;
            }
        }
        return -1;
    }

    public static void 
    main(String args[]) {
        /* Dado como argumento a chave, um modo de execução e um texto
         * (nessa ordem), criptografa ou descriptografa tal texto com a
         * cifra de César.
         */

        int chave = Integer.parseInt(args[0]);
        int i = 0, letra, posição_alfabeto;

        String texto = args[2];
        int tamanho_texto = texto.length();
        String novo_texto = "";

        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] ALFABETO = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        String modo = args[1];
        System.out.println(modo);

        // Criptografa
        if (ordem_lexicografica(args[1],"criptografa") == 0) {

            while (i < tamanho_texto) {
                letra = texto.charAt(i);

                if (letra >= 65 && letra <= 90) {
                    // Letra maiúscula;
                    posição_alfabeto = busca_binaria(ALFABETO, ""+texto.charAt(i));
                    posição_alfabeto = (posição_alfabeto + chave)%26;
                    novo_texto = novo_texto + ALFABETO[posição_alfabeto];

                } else if (letra >= 97 && letra <= 122) {
                    // Letra minúscula;
                    posição_alfabeto = busca_binaria(alfabeto, ""+texto.charAt(i));
                    posição_alfabeto = (posição_alfabeto + chave)%26;
                    if (posição_alfabeto < 0) {
                        posição_alfabeto = posição_alfabeto + 26;
                    }
                    novo_texto = novo_texto + alfabeto[posição_alfabeto];
                } else {
                    novo_texto = novo_texto + texto.charAt(i);
                }

                i = i + 1;
            }
            System.out.println(novo_texto);
        } 
        // Descriptografa
        else if (ordem_lexicografica(args[1],"descriptografa") == 0) {

            while (i < tamanho_texto) {
                letra = texto.charAt(i);

                if (letra >= 65 && letra <= 90) {
                    // Letra maiúscula;
                    posição_alfabeto = busca_binaria(ALFABETO, ""+texto.charAt(i));
                    posição_alfabeto = (posição_alfabeto-chave)%26;
                    novo_texto = novo_texto + ALFABETO[posição_alfabeto];

                } else if (letra >= 97 && letra <= 122) {
                    // Letra minúscula;
                    posição_alfabeto = busca_binaria(alfabeto, ""+texto.charAt(i));
                    posição_alfabeto = (posição_alfabeto-chave)%26;
                    if (posição_alfabeto < 0) {
                        posição_alfabeto = posição_alfabeto + 26;
                    }
                    novo_texto = novo_texto + alfabeto[posição_alfabeto];
                } else {
                    novo_texto = novo_texto + texto.charAt(i);
                }
                i = i + 1;
            }
            System.out.println(novo_texto);
            
        
        } 
        // Inválido 
        //else {
        //    System.out.println("Modo de execução inválido!");
        //}
    }
}
