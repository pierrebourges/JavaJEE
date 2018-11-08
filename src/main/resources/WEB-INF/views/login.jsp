<%@include file="includes/lib.jsp"%>
    <title><fmt:message key = "title_login"/></title>
</head>
<body>
<div class="col-md-6 offset-md-3 bg-light">
    <form id="formlangage" method="post" action="${pageContext.request.contextPath}/langue">
        <select onchange="this.form.submit()" id="form_langues" name="form_langues" class="form-control" style="width: 214px">
            <option><fmt:message key = "chooseLange" /></option>
            <option value="fr" id="fr">fr</option>
            <option value="en" id="en">en</option>
        </select>
        <input name="url" type="text" value="/login" hidden/>
    </form>

    <h1><fmt:message key = "msg_bienvenue"/></h1>

    <h2><fmt:message key = "msg_login" /></h2>
    <form method="post">
        <table>
            <tr>
                <td><label for="login"><fmt:message key = "label_login"/></label></td>
                <td><input type="text" name="login" id="login" class="form-control" required/></td>
            </tr>
            <tr>
                <td><label for="mdp"><fmt:message key = "label_mdp"/></label></td>
                <td><input type="password" name="mdp" id="mdp" class="form-control" required/></td>
            </tr>
        </table>
        <input class="btn btn-primary" type="submit" value="<fmt:message key = "btn_connexion" />"/>
    </form>
    <c:if test="${requestScope.errorLogin!=null}">
        <div class="alert alert-danger">
            <fmt:message key="errorLogin"/>
        </div>
    </c:if>
</div>

</body>
</html>