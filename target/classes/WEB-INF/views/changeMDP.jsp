<%@include file="includes/lib.jsp"%>
    <title><fmt:message key = "title_ChangeMDP"/></title>
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
        <h1><fmt:message key = "title_ChangeMDP"/></h1>

        <form method="post">
            <table>
                <tr>
                    <td><label for="ancienmdp"><fmt:message key = "label_oldMDP"/></label></td>
                    <td><input name="ancienmdp" id="ancienmdp" type="password" class="form-control" required/></td>
                </tr>
                <tr>
                    <td><label for="newmdp"><fmt:message key = "label_newMDP"/></label></td>
                    <td><input name="newmdp" id="newmdp" type="password" class="form-control" required/></td>
                </tr>
                <tr>
                    <td><label for="secondmdp"><fmt:message key = "label_secondMdp"/></label></td>
                    <td><input name="secondmdp" id="secondmdp" type="password" class="form-control" required/></td>
                </tr>
            </table>
            <input class="btn btn-primary" type="submit" value="<fmt:message key = "btn_changemdp" />"/>
            <c:if test="${requestScope.errorSecondMdp!=null}">
                <div class="alert alert-danger">
                    <fmt:message key="errorSecondMdp"/>
                </div>
            </c:if>
            <c:if test="${requestScope.errorCondtionMdp!=null}">
                <div class="alert alert-danger">
                    <fmt:message key="errorCondtionMdp"/>
                </div>
            </c:if>
            <c:if test="${requestScope.errorOldMdp!=null}">
                <div class="alert alert-danger">
                    <fmt:message key="errorOldMdp"/>
                </div>
            </c:if>
        </form>
    </div>
</body>
</html>