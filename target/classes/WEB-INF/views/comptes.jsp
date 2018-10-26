<%@include file="includes/lib.jsp"%>
<!doctype html>
<html lang="fr">
<c:if test="${param.form_langues!=null}">
    <fmt:setLocale value = "${param.form_langues}" scope="session"/>
</c:if>
<fmt:setBundle basename = "langues.projetbanque"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key = "title_comptes"/></title>
</head>
<body>
    <form id="formlangage" method="get">
        <select onchange="this.form.submit()" id="form_langues" name="form_langues">
            <option><fmt:message key = "chooseLange" /></option>
            <option value="fr" id="fr">fr</option>
            <option value="en" id="en">en</option>
        </select>
    </form>

    <h1><fmt:message key = "msg_listComptes"/></h1>
    <p><fmt:message key = "msg_bonjourMonsieur"/><c:out value=" ${utilisateur.getNom()} ${utilisateur.getPrenom()}"/></p>
    <c:forEach items="${utilisateur.comptes}" var="compte">
        <p><fmt:message key = "account_${compte.getId_type_compte()}"/> <c:out value="${compte.getSolde()}"/> <button><a href="/detailsCompte?idCompte=${compte.getId_compte()}"><fmt:message key = "btn_compte"/></a></button></p>
    </c:forEach>
    <br>
    <h3><fmt:message key = "title_Addcompte"/></h3>
    <form method="post">
        <table>
            <tr>
                <td><label for="type_compte"><fmt:message key = "label_type_compte"/></label></td>
                <td><select id="type_compte" name="type_compte">
                    <option value="1"><fmt:message key = "account_1"/></option>
                    <option value="2"><fmt:message key = "account_2"/></option>
                    <option value="3"><fmt:message key = "account_3"/></option>
                </select></td>
            </tr>
        </table>
        <input type="submit" value="<fmt:message key = "btn_Addcompte" />"/>
    </form>
    <br>
    <button><a href="/changemdp"><fmt:message key="title_ChangeMDP"/></a></button>
</body>
</html>