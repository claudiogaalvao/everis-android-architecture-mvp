# Descubra as pessoas que estão no espaço sideral agora !

# Android Studio 3.6

Este aplicativo consome a API http://open-notify.org/Open-Notify-API/People-In-Space/ para saber a quantidade de pessoas que estão no espaço sideral agora.

O objetivo do projeto é migrar um aplicativo Android que não segue nenhuma arquitetura definida para a arquitetura MVP (Model View Presenter). Podemos notar que o pojeto possui diversos code smells (code smells são trechos de código que podem indicar problemas). A lógica da aplicação está toda definida na View (MainFragment.kt), em um aplicativo pequeno e com poucos recursos isto pode não parecer um grande problema, mas este tipo de abordagem dificulta a evolução do aplicativo, dificulta a atuação de múltiplas equipes no mesmo projeto além de ter uma baixa testabilidade. 

Neste projeto não será necessário escrever a implementação da classe Model nem da classe Presenter, eu já deixei essas classes escritas para vocês ;). A ideia é apenas entender o papel de cada uma delas dentro do seu aplicativo.

Eu preparei alguns TODO's que vão guia-los nesta jornada, para acessar os TODO's vocês podem ir em View -> Tool Windows -> TODO.

Antes de iniciar o refactore, rode o aplicativo e verifique como ele funciona, após o refactore execute novamente para garantir que as funcionalidades continuam de acordo com o esperado. 

- Primeiro passo para iniciar o refactore do código, vamos mover as classes da camada view para o seu pacote correspondente. Execute os TODOS 1, 2 e 3. Para realizar estes passos a tecla de atalho F6 pode ajuda-los. 

- Antes de partir para o TODO número 4, abra o arquivo PeopleContract.kt e leia os comentários e contrato de cada uma das camadas, é importante entender esses conceitos para seguir nas próximas etapas 

- Vamos para próxima etapa, esta etapa consiste em implementar os métodos da camada View, para isso o nosso fragment precisa implementar a interface PeopleContract.View, no final do TODO 4 sua classe vai apresentar erro isso será resolvido ao implementar o TODO número 5 e número 6, esses TODOS são relacionados aos metodos da view que serão chamados pela presenter. Nos TODOS's número 5 e número 6 além de remover o comentário vocês precisaram implementar esses metodos, o metodo showMessage deve exibir a string message para o usuário isso pode ser feito através de um TOAST e o TODO número 6 deve atualizar a lista de astronautas, para atualizar a lista de astronautas você deve chamar o metodo adapter.setData. 

- Nesta etapa vamos iniciar e destruir a presenter, este é um passo importante da arquitetura pois a presenter precisa conhecer a View que ela irá orquestrar, e também precisa ser avisada quando esta view for destruida, realize os TODO's número 7 e 8.

- Chegamos na etapa final da refatoração, nesta etapa vamos remover os metodos que estão acoplados na nossa View e delegar a responsabilidade para a camada presenter, realize todos os TODOS's restantes. 










