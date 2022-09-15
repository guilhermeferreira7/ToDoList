<%--
  Created by IntelliJ IDEA.
  User: guilh
  Date: 14/09/2022
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Template principal" pageEncoding="UTF-8" %>
<%@ attribute name="title"%>

<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <link rel="stylesheet" href="assets/styles/main.css">

</head>
<body>


<div id="header">
    <div class="light-blue lighten-2">
        <header class="center">
            <h1>TO-DO List</h1>
        </header>
    </div>
</div>

<main>
    <div>
        <jsp:doBody></jsp:doBody>
    </div>
</main>

<div id="footer">
    <footer class="page-footer light-blue lighten-2">
        <div class="footer-copyright light-blue lighten-2">
            <div class="container center">
                <em>Projeto para a disciplina Desenvolvimento Web 4</em>
            </div>
        </div>
    </footer>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script src="assets/scripts/main.js"></script>


</body>
</html>
