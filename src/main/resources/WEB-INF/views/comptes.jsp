<%@include file="includes/lib.jsp"%>
    <title><fmt:message key = "title_comptes"/></title>
</head>
<body>
    <div class="col-md-6 offset-md-3">
        <form id="formlangage" method="get">
            <select onchange="this.form.submit()" id="form_langues" name="form_langues" class="form-control">
                <option><fmt:message key = "chooseLange" /></option>
                <option value="fr" id="fr">fr</option>
                <option value="en" id="en">en</option>
            </select>
        </form>
        <a href="/deconnexion"><button class="btn btn-secondary"><fmt:message key = "btn_deconnexion"/></button></a>

        <h1><fmt:message key = "msg_listComptes"/></h1>
        <p><fmt:message key = "msg_bonjourMonsieur"/><c:out value=" ${utilisateur.getNom()} ${utilisateur.getPrenom()}"/></p>
        <c:forEach items="${utilisateur.comptes}" var="compte">
            <p><fmt:message key = "account_${compte.getId_type_compte()}"/> <c:out value="${compte.getSolde()}"/> <fmt:message key = "msg_monnaie"/>
                <a href="/detailsCompte?idCompte=${compte.getId_compte()}"><button class="btn btn-info"><fmt:message key = "btn_compte"/></button></a></p>
        </c:forEach>
        <br>
        <h3><fmt:message key = "title_Addcompte"/></h3>
        <form method="post">
            <table>
                <tr>
                    <td><label for="type_compte"><fmt:message key = "label_type_compte"/></label></td>
                    <td><select class="form-control" id="type_compte" name="type_compte">
                        <option value="1"><fmt:message key = "account_1"/></option>
                        <option value="2"><fmt:message key = "account_2"/></option>
                        <option value="3"><fmt:message key = "account_3"/></option>
                    </select></td>
                </tr>
            </table>
            <input class="btn btn-primary" type="submit" value="<fmt:message key = "btn_Addcompte" />"/>
        </form>
        <br>
        <a href="/changemdp"><button class="btn btn-default"><fmt:message key="title_ChangeMDP"/></button></a>
    </div>
</body>
</html>