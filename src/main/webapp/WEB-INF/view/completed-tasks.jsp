<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Página inicial">

  <jsp:body>

    <nav class="white">
      <div class="nav">
        <ul class="right">
          <li><a class="blue-text" href="nova-tarefa">Adicionar tarefa</a></li>
          <li><a class="blue-text" href="inicial">Voltar</a></li>
        </ul>
      </div>
    </nav>

    <h2 class="center">Tarefas concluidas</h2>

    <div class="row center">
      <table class="highlight centered col offset-s2 s8">
        <thead>
        <tr>
          <th>Tarefa</th>
          <th>Data de criação</th>
          <th>Concluida em</th>
        </tr>
        </thead>

        <tbody>
        <tr>
          <td>tarefa 1</td>
          <td>11/09/2022</td>
          <td>12/09/2022</td>
        </tr>
        <tr>
          <td>tarefa 2</td>
          <td>12/09/2022</td>
          <td>13/09/2022</td>
        </tr>
        <tr>
          <td>tarefa 3</td>
          <td>13/09/2022</td>
          <td>14/09/2022</td>
        </tr>
        <tr>
          <td>tarefa 4</td>
          <td>14/09/2022</td>
          <td>15/09/2022</td>
        </tr>
        </tbody>
      </table>

    </div>


  </jsp:body>

</t:template>