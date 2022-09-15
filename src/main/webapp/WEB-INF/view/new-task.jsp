<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Página inicial">

  <jsp:body>

    <nav class="white">
      <div class="nav">
        <ul class="right">
          <li><a class="blue-text" href="inicial">Voltar</a></li>
        </ul>
      </div>
    </nav>

    <h2 class="center">Nova tarefa</h2>

    <form class="col s12 center" action="/to-do-list/criar-conta" method="post">
      <div class="row center">
        <div class="input-field col offset-s3 s6">
          <input id="task" type="text" class="validate">
          <label for="task">Tarefa</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col offset-s3 s6">
          <input id="note" type="text" class="validate">
          <label for="note">Observações</label>
        </div>
      </div>
      <button class="btn waves-effect waves-light" type="submit" name="action">Adicionar tarefa
        <i class="material-icons right">send</i>
      </button>
    </form>

  </jsp:body>

</t:template>