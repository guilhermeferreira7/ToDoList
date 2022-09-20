<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Tarefas concluidas">

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
      <c:if test="${empty tasks}">
        <h4 class="center">Nenhuma tarefa adicionada</h4>
      </c:if>
      <c:if test="${not empty tasks}">
        <table class="highlight centered col offset-s2 s8">
          <thead>
          <tr>
            <th>Tarefa</th>
            <th>Data de criação</th>
            <th>Concluida em</th>
          </tr>
          </thead>

          <tbody>
            <c:forEach var="task" items="${tasks}">
              <tr>
                <td>${task.taskName}</td>
                <td>${task.dataCreated}</td>
                <td>${task.dataCompleted}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>

    </div>


  </jsp:body>

</t:template>