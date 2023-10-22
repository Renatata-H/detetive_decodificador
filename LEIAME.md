# detetive decodificador
Série de programas para quebrar algumas cifras

## Cifra de César
Esse programa busca trabalhar com a [Cifra de César](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar), ao criptografar ou descriptografar um texto fornecido, conforme a demanda do usuário, com uma chave inserida.

Para compilar o programa, insira no terminal o seguinte comando:

        javac Cifra_de_cesar.java

Em seguida, para executar o programa, insira:

        java Cifra_de_cesar CHAVE MODO TEXTO

em que a CHAVE se refere a um número inteiro qualquer o qual ditará como o alfabeto será rotacionado; MODO se refere entre as opções "criptografa" e "descriptografa" (quaisquer outros textos escritos darão erro!); e TEXTO se refere ao texto o qual você deseja que programa trabalhe. Note que, para TEXTOs com mais de uma palavra, é necessário colocar aspas ("") ao redor dos mesmos. Além disso, **não utilize caracteres especiais**, como os acentuados, em seu TEXTO.

#### Exemplo: 
Suponha a CHAVE = 15, o MODO = "descriptografa" e o TEXTO = "Qdb sxp! :)". Inseriremos na linha de comando então:

      java Cifra_de_cesar 15 descriptografa "Qdb sxp! :)"

A saída deverá ser: 

      Bom dia! :)

## Cifra de Vigenère
Esse programa busca trabalhar com a [Cifra de Vigenère](https://pt.wikipedia.org/wiki/Cifra_de_Vigen%C3%A8re), ao criptografar ou descriptografar um texto fornecido, conforme a demanda do usuário, com uma chave inserida. Certifique-se de que a chave tenha a mesma quantidade de caracteres que o texto fornecido.

Para compilar o programa, insira no terminal o seguinte comando:

        javac Cifra_de_vigenere.java

Como a cifra de Vigenère é baseada na cifra de César, é necessário ter no mesmo diretório o arquivo Cifra_de_cesar.class para a execução desse programa. Em seguida, para executar, insira:

        java Cifra_de_vigenere CHAVE MODO TEXTO

em que a CHAVE se refere a uma string de tamanho igual ao TEXTO, a qual ditará como o alfabeto será rotacionado; MODO se refere entre as opções "criptografa" e "descriptografa" (quaisquer outros textos escritos darão erro!); e TEXTO se refere ao texto o qual você deseja que programa trabalhe. Note que, para TEXTOs com mais de uma palavra, é necessário colocar aspas ("") ao redor dos mesmos. Além disso, **não utilize caracteres especiais**, como os acentuados, em seu TEXTO.

#### Exemplo: 
Suponha a CHAVE = "limaolimaol", o MODO = "descriptografa" e o TEXTO = "Mwy rti! :)". Inseriremos na linha de comando então:

      java Cifra_de_vigenere limaolimaol descriptografa "Mwy rti! :)"

A saída deverá ser: 

      Bom dia! :)

## Cifra ADFGVX
Esse programa busca trabalhar com a [Cifra ADFGVX](https://en.wikipedia.org/wiki/ADFGVX_cipher), ao criptografar um texto fornecido, conforme a demanda do usuário, com uma chave inserida.

Para compilar o programa, insira no terminal o seguinte comando:

        javac ADFGVX.java

Em seguida, para executar o programa, insira:

        java ADFGVX CHAVE TEXTO

em que a CHAVE se refere a uma string de tamanho qualquer (escolha, preferencialmente, chaves pequenas); e TEXTO se refere ao texto o qual você deseja que programa trabalhe. Além disso, **utilize apenas letras** e **não utilize caracteres especiais**, como os acentuados ou pontos de exc, em seu TEXTO. Também não coloque espaçamento.

[//]: <>#### Exemplo: 
[//]: <>Suponha a CHAVE = "lima" e o TEXTO = "Bomdiaflordodia". Inseriremos na linha de comando então:

[//]: <>      java ADFGVX limao Bomdiaflordodia

[//]: <>A saída deverá ser: 

[//]: <>      Bom dia! :)
