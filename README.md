# JogoDaVida
O código implementa o Jogo da Vida, onde cada célula em uma grade bidimensional está viva ou morta com base em um conjunto de regras. As regras são as seguintes:
<br>
1 - Qualquer célula viva com menos de dois vizinhos vivos morre, como se fosse por subpopulação.<br>
2 - Qualquer célula viva com dois ou três vizinhos vivos continua viva para a próxima geração.<br>
3 - Qualquer célula viva com mais de três vizinhos vivos morre, como se fosse por superpopulação.<br>
4 - Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva, como se fosse por reprodução.<br>
A classe principal chama métodos da classe JogoDaVida, que lida com a lógica do jogo real. A classe JogoDaVida possui um objeto Matriz que contém métodos para criar e manipular a grade do jogo. A classe JogoDaVida tem um método, jogoDaVida, que recebe uma matriz e um número de iterações para executar o jogo. O método cria uma matriz temporária e aplica as regras do jogo a cada célula da matriz para determinar se ela deve estar viva ou morta na próxima geração. A nova matriz é retornada após todas as iterações terem sido concluídas.<br>

O código recebe a entrada do usuário para o tamanho da grade e, em seguida, gera aleatoriamente uma configuração inicial para o jogo. O jogo é executado até que o usuário saia ou até que a grade se estabilize (sem alteração de uma geração para a próxima). A saída é a grade do jogo após cada geração.
