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
          <li><a class="blue-text" href="tarefas-concluidas">Tarefas concluidas</a></li>
          <li><a class="blue-text" href="logout" id="logout">Logout</a></li>
        </ul>
      </div>
    </nav>

    <h2 class="center">Minhas tarefas</h2>

    <p class="center">Total de tarefas adicionadas por todos os usuários no escopo de aplicativo: ${tasksCounter}</p>

    <div class="row center">
      <table class="highlight centered col offset-s2 s8">
        <thead>
        <tr>
          <th>Tarefa</th>
          <th>Data de criação</th>
          <th>Observações</th>
          <th>Marcar como concluída</th>
        </tr>
        </thead>

        <tbody>
        <c:if test="${not empty tasks}">
          <c:forEach var="task" items="${tasks}">
            <tr>
              <td>${task.taskName}</td>
              <td>${task.description}</td>
              <td>${task.dataCreated}</td>
              <td>
                <button id="${task.id}" class="completeTask" class="center btn btn-small waves-effect waves-light">
                  <i class="material-icons">check</i>
                </button>
              </td>
            </tr>
          </c:forEach>
        </c:if>
        </tbody>
      </table>

    </div>

    <script>
      window.onload =  function (){



        $(".completeTask").click(function () {
          const params = {
            id: $(this).attr("id")
          }

          $.post('tarefas-concluidas', $.param(params))
        })

        $("#logout").click(() => {
          localStorage.removeItem("login");
        })
      }
    </script>

  </jsp:body>

</t:template>