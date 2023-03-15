# JogoDaVida
O código implementa o Jogo da Vida, onde cada célula em uma grade bidimensional está viva ou morta com base em um conjunto de regras. As regras são as seguintes:
<br><br>
- Qualquer célula viva com menos de dois vizinhos vivos morre, como se fosse por subpopulação.<br>
- Qualquer célula viva com dois ou três vizinhos vivos continua viva para a próxima geração.<br>
- Qualquer célula viva com mais de três vizinhos vivos morre, como se fosse por superpopulação.<br>
- Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva, como se fosse por reprodução.<br><br>

A classe principal chama métodos da classe JogoDaVida, que lida com a lógica do jogo real. A classe JogoDaVida possui um objeto Matriz que contém métodos para criar e
manipular a grade do jogo. A classe JogoDaVida tem um método, jogoDaVida, que recebe uma matriz e um número de iterações para executar o jogo. O método cria uma matriz 
temporária e aplica as regras do jogo a cada célula da matriz para determinar se ela deve estar viva ou morta na próxima geração. A nova matriz é retornada após todas as 
iterações terem sido concluídas.<br>

O código recebe a entrada do usuário para o tamanho da grade e, em seguida, gera aleatoriamente uma configuração inicial para o jogo. O jogo é executado até que o 
usuário saia ou até que a grade se estabilize (sem alteração de uma geração para a próxima). A saída é a grade do jogo após cada geração.<br><br>

## Como Rodar o Jogo?

Para executar o jogo, basta seguir os seguintes passos:<br><br>

1. Crie um clone do repositório em sua máquina.
  ```
    git clone https://github.com/JoaoVitorMirandaBandeira/JogoDaVida.git
  ```
2. Abra o arquivo Main.java no JGrasp (preferencialmente).
3. Compile o código.
4. Agora é só dar "start" no código e seguir as instruções no terminal.

__OBS:__ Pode ser usado qualquer outro software que compile e execute arquivos _.java_ .
