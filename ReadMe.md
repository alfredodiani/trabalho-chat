
  # Trabalho CHAT 
  <br>  
  Sistemas Distribuidos - GCC 129  <br>
  Universidade Federal de Lavras   <br>                        
  <br>                                 
  Data: 18/02/2022<br>                 
  <br>                                 


<h2> Descrição: </h2>
Aplicação de chat por protocolo TCP desenvolvido em Java. <br>
Contem Servidor e Cliente os quais podem trocar mensagens entre si de forma assíncrona.<br>

É utilizado uma comunicação por Sockets entre Cliente e Servidor, os quais cada um roda duas Threads, 
uma para escutar o Socket e escrever as mensagens recebidas na tela
e outra para enviar a mensagem digitada pelo Socket.
<br>


<h2>Instruções:</h2>

Para rodar basta compilar em ordem as classes: <br>
	MsgListener.java <br>
	MsgWriter.java <br>
	Client.java <br>
	Server.java <br>

Após isso, executar primeiro o Server, depois o Client<br>
<br>

<h2>Instrução para compilação:</h2> 
javac MsgListener.java <br>
javac MsgWriter.java <br>
javac Client.java <br>
javac Server.java <br>
<br>

<h2>Instuções para rodar:</h2>

java Server <br>
java Client <br>





