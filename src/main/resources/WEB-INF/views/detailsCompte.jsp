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
    <title><fmt:message key = "title_DetailCompte"/></title>
</head>
<body>
    <div class="col-md-4 offset-md-4">
        <form id="formlangage" method="get">
            <select onchange="this.form.submit()" id="form_langues" name="form_langues" class="form-control">
                <option><fmt:message key = "chooseLange" /></option>
                <option value="fr" id="fr">fr</option>
                <option value="en" id="en">en</option>
            </select>
        </form>
        <h1><fmt:message key = "title_DetailCompte"/></h1>
        <c:forEach items="${utilisateur.comptes}" var="compte">
            <c:if test="${param.idCompte==compte.getId_compte()}">
                <p><fmt:message key = "msg_numCompte"/> ${compte.getId_compte()}</p>
                <p><fmt:message key = "msg_soldeCompte"/>${solde}<fmt:message key = "msg_monnaie"/></p>
                <p><fmt:message key = "msg_dateCompte"/>${compte.getDate_creation()}</p>
                <p><fmt:message key = "msg_typeCompte"/>${compte.getId_type_compte()}</p>
                <h3><fmt:message key = "title_transaction"/></h3>
                <table class="table table-bordered">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col"><fmt:message key = "th_labelle"/></th>
                            <th scope="col"><fmt:message key = "th_montant"/></th>
                            <th scope="col"><fmt:message key = "th_date"/></th>
                            <th scope="col"><fmt:message key = "th_compteDest"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${compte.transactions}" var="transaction">
                            <tr>
                                <td>${transaction.getLebelle()}</td>
                                <td>${transaction.getMontant()}<fmt:message key = "msg_monnaie"/></td>
                                <td>${transaction.getDate()}</td>
                                <td>${transaction.getCompte_destination()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </c:if>
        </c:forEach>
        <br>
        <h3><fmt:message key = "title_Addtransaction"/></h3>
        <form method="post">
            <table>
                <tr>
                    <td><label for="compteId"><fmt:message key = "label_compteId"/></label></td>
                    <td><input type="number" name="compteId" id="compteId" class="form-control" required></td>
                </tr>
                <tr>
                    <td><label for="montant"><fmt:message key = "label_montant"/></label></td>
                    <td><input type="number" name="montant" id="montant" class="form-control" required></td>
                </tr>
                <tr>
                    <td><label for="libelle"><fmt:message key = "label_libelle"/></label></td>
                    <td><input type="text" name="libelle" id="libelle" class="form-control" required></td>
                </tr>
            </table>
            <input type="hidden" value="${param.idCompte}" name="idSource" id="idSource">
            <input class="btn btn-primary" type="submit" value="<fmt:message key = "btn_Addtransaction" />"/>
        </form>
        <c:if test="${requestScope.errorMessageDestination!=null}">
            <div class="alert alert-danger">
                <fmt:message key="errorDest"/>
            </div>
        </c:if>
        <c:if test="${requestScope.errorMessageMontant!=null}">
            <div class="alert alert-danger">
                <fmt:message key="errorMontant"/>
            </div>
        </c:if>
    </div>
</body>
</html>