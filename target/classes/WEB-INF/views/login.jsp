<%@include file="includes/lib.jsp"%>
<%--<!doctype html>--%>
<%--<html lang="fr">--%>
<%--<c:if test="${param.form_langues!=null}">--%>
    <%--<fmt:setLocale value = "${param.form_langues}" scope="session"/>--%>
<%--</c:if>--%>
<%--<fmt:setBundle basename = "langues.projetbanque"/>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<meta name="viewport"--%>
          <%--content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
    <title><fmt:message key = "title_login"/></title>
</head>
<body>
    <form id="formlangage" method="get">
        <select onchange="this.form.submit()" id="form_langues" name="form_langues">
            <option><fmt:message key = "chooseLange" /></option>
            <option value="fr" id="fr">fr</option>
            <option value="en" id="en">en</option>
        </select>
    </form>

    <h1><fmt:message key = "msg_bienvenue"/></h1>

    <h2><fmt:message key = "msg_login" /></h2>
    <form method="post">
        <table>
            <tr>
                <td><label for="login"><fmt:message key = "label_login"/></label></td>
                <td><input type="text" name="login" id="login" required/></td>
            </tr>
            <tr>
                <td><label for="mdp"><fmt:message key = "label_mdp"/></label></td>
                <td><input type="password" name="mdp" id="mdp" required/></td>
            </tr>
        </table>
        <input type="submit" value="<fmt:message key = "btn_connexion" />"/>
    </form>
    <c:if test="${requestScope.errorLogin!=null}">
        <fmt:message key="errorLogin"/>
    </c:if>
</body>
</html>