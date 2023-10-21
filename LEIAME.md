# detetive decodificador
Série de programas para quebrar algumas cifras

## Cifra de César
Esse programa busca trabalhar com a [Cifra de César](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar), ao criptografar ou descriptografar um texto fornecido, conforme a demanda do usuário, com uma chave inserida.

Para compilar o programa, insira no terminal o seguinte comando:

        javac cifra_de_cesar.java

Em seguida, para executar o programa, insira:

        java cifra_de_cesar CHAVE MODO TEXTO

em que a CHAVE se refere a um número inteiro qualquer o qual ditará como o alfabeto será rotacionado; MODO se refere entre as opções "criptografa" e "descriptografa" (quaisquer outros textos escritos darão erro!); e TEXTO se refere ao texto o qual você deseja que programa trabalhe. Note que, para TEXTOs com mais de uma palavra, é necessário colocar aspas ("") ao redor dos mesmos.

#### Exemplo: 
Suponha a CHAVE = 15, o MODO = "descriptografa" e o TEXTO = "Qdb sxp! :)". Inseriremos na linha de comando então:

      java cifra_de_cesar 15 descriptografa "Qdb sxp! :)"

A saída deverá ser: 

      TEXTO DESCRIPTOGRAFADO: Bom dia! :)
