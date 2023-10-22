
public class Cifra_de_vigenere {
    
    public static void 
    main(String args []) {
        /* Dado como argumento a chave, um modo de execução e um texto
         * (nessa ordem), criptografa ou descriptografa tal texto com a
         * cifra de Vigènere.
         */

         String chave = args[0], letra;
         String texto = args[2];
         int i = 0, tamanho_texto = texto.length(), chave_i;
         String novo_texto = "";
 
         String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
         String[] ALFABETO = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

         String modo = args[1];

         if (chave.length() == tamanho_texto) {

            if (Cifra_de_cesar.ordem_lexicografica(modo,"criptografa") == 0) {
            
                while (i < tamanho_texto) {
                    chave_i = chave.charAt(i);
                    letra = texto.charAt(i)+"";

                    if (chave_i <= 90) {
                        chave_i = chave_i - 65;
                    } else {
                        chave_i = chave_i - 97;
                    }

                    novo_texto = novo_texto + Cifra_de_cesar.criptografa(chave_i, letra, 1, alfabeto, ALFABETO);  //Cifra_de_cesar.main(argumentos)
                    
                    i = i + 1;
                }
                System.out.println("TEXTO CRIPTOGRAFADO: "+novo_texto);
            }

            else if (Cifra_de_cesar.ordem_lexicografica(args[1],"descriptografa") == 0) {

                while (i < tamanho_texto) {
                    chave_i = chave.charAt(i);
                    letra = texto.charAt(i)+"";

                    if (chave_i <= 90) {
                        chave_i = chave_i - 65;
                    } else {
                        chave_i = chave_i - 97;
                    }

                    novo_texto = novo_texto + Cifra_de_cesar.descriptografa(chave_i, letra, 1, alfabeto, ALFABETO);  //Cifra_de_cesar.main(argumentos)
                    
                    i = i + 1;
                }
                System.out.println("TEXTO DESCRIPTOGRAFADO: "+novo_texto);

            } else {

                System.out.println("Modo de execução inválido!");
            }
        } else {
            System.out.println("Chave de tamanho inválido!");
        }
    }
}
