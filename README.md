# ToDoList

## Sistema feito para disciplina de Desenvolvimento Web 4 do curso Sistemas para internet na UTFPR. Foi realizado utilizando Java com Servlets. É um aplicativo simples que cria, lista e marca tarefas (to-do) como feitas. Tem lógica de criar e autenticar usuário de forma simples. 

Obs: Faz muito tempo que fiz então deve ter algum bug ou esqueci de falar algo. De qualquer forma era apenas um projeto para aprender a tecnologia e eu tinha um curto prazo para entregar.

As próximas sessões mostram coisas obrigatórias que precisava ser feito para pontuar na avaliação.

## Wireframes
https://www.figma.com/file/J6m5jfVPjugmaql2EsEWRX/To-do-list

## Checklist

- [x] Encaminhamento e redirecionamento
    - [x] Usar encaminhamento fora do modelo MVC (i.e. um servlet encaminhando a requisição para outro servlet). A dica é dividir um processamento complexo em duas etapas, ou seja, em dois servlets.
    - [x] Usar redirecionamento depois de requisições POST de um formulário para evitar o reenvio destes dados ao atualizar a página com F5.
    - [x] Para uma mesma rota de um Servlet, usar doGet para encaminhar a uma página e doPost para recuperar os dados da página/formulário
- [x] Escopo de requisição, sessão e aplicação
- [x] Cookies
    - [x] Cookie que dura apenas uma sessão do navegador
    - [x] Cookie com tempo de vida customizado além de uma sessão do navegador
- [x] Controle de erros e exceção via web.xml
    - [x] Tratamento por código de status ou exceção específica
    - [x] Tratamento de erros genérico
- [x] Expression Language (EL) para acessar os objetos de domínio (beans) da camada de modelo do MVC
- [x] JSTL e TagLib
    - [x] forEach
    - [x] if
    - [x] Template com cabeçalho e rodapé
- [x] JavaScript
    - [x] Requisição AJAX
    - [x] Armazenamento no LocalStorage
    - [x] Uso de plugin JQuery
- [x] JPA
    - [x] No mínimo 2 entidades.
    - [x] Operações de CRUD. 
  
