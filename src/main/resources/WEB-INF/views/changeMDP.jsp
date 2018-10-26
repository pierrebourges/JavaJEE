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
    <title><fmt:message key = "title_ChangeMDP"/></title>
</head>
<body>
<form id="formlangage" method="get">
    <select onchange="this.form.submit()" id="form_langues" name="form_langues">
        <option><fmt:message key = "chooseLange" /></option>
        <option value="fr" id="fr">fr</option>
        <option value="en" id="en">en</option>
    </select>
</form>

<h1><fmt:message key = "title_ChangeMDP"/></h1>

<form method="post">
    <table>
        <tr>
            <td><label for="ancienmdp"><fmt:message key = "label_oldMDP"/></label></td>
            <td><input name="ancienmdp" id="ancienmdp" type="password" required/></td>
        </tr>
        <tr>
            <td><label for="newmdp"><fmt:message key = "label_newMDP"/></label></td>
            <td><input name="newmdp" id="newmdp" type="password" required/></td>
        </tr>
        <tr>
            <td><label for="secondmdp"><fmt:message key = "label_secondMdp"/></label></td>
            <td><input name="secondmdp" id="secondmdp" type="password" required/></td>
        </tr>
    </table>
    <input type="submit" value="<fmt:message key = "btn_changemdp" />"/>
    <c:if test="${requestScope.errorSecondMdp!=null}">
        <fmt:message key="errorSecondMdp"/>
    </c:if>
    <c:if test="${requestScope.errorCondtionMdp!=null}">
        <fmt:message key="errorCondtionMdp"/>
    </c:if>
    <c:if test="${requestScope.errorOldMdp!=null}">
        <fmt:message key="errorOldMdp"/>
    </c:if>
</form>
<br>
</body>
</html>