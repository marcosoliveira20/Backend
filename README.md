# Construção de Uma API REST para o Hack pela Gastronomia

Essa API foi desenvolvida, para o desafio Hack pela Gastronomia. O qual é um hackathon para trazer soluções inovadoras. Para os desafios
que os restaurantes, bares e bistrôs vem sofrendo durante a pandemia e/ou pensando nos desafios que ocorrerão após a mesma.

A solução se trata de um aplicativo por onde o usuário pode marcar um horário para ir ao restaurante evitando aglomerações e fazendo com que o proprietario do restaurante possa se planejar para a chegada dos clientes. Na ideia original era possível fazer pedidos e que estes mesmos pedidos aparecessem para a cozinha, e depois de todo o consumo a ideia era que o usuário pudesse pagar por lá também, devido ao curto prazo infelizmente não foi possível aplicar todas as funcionalidades.

O projeto foi desenvolvido em grupo onde cada um ficou com uma determinada responsabilidade, como minha equipe foi composta por seis pessoas, eu e meu Colega (Roger dono do repositório original) ficamos com o Backend ou seja a construção de uma API rest, dois ficaram responsáveis por uma aplicação mobile e os outros dois por uma aplicação WEB


## Como testar a API

Por enquanto só é possível testar a API através de requisições sugiro que você use o  Postman que pode ser baixado <a href= "https://www.postman.com/downloads/">clicando aqui </a>  e uma IDE java de sua preferência por ser uma aplicação usando Spring boot sugiro que use Spring tool que pode ser baixada <a href="https://spring.io/tools">clicando aqui </a>

A integração foi feita usando o banco de dados Mysql, no mesmo você deve criar uma database chamado opafood, e logo após trocar a senha e usuario em application.properties.


## Tecnologias implementas na API Rest

- Spring boot
- Fliway Migration
- JPA
