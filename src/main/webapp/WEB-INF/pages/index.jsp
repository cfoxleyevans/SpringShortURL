<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>
    <jsp:body>

        <style>
            body {
                background-image: url('http://ppcdn.500px.org/83303079/274f709636891ed7db2f4dfc4123447ccaa20918/2048.jpg');
            }
            .spacer {
                height: 250px;
            }

        </style>

        <%--The for to generate new short code--%>
        <div class="row spacer"></div>
        <div class="row">
            <form method="post" role="form" class="form">
                <div class="form-group">
                    <input type="text" name="url" class="form-control"  placeholder="Enter URL">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-default">Shorten</button>
                </div>
            </form>
        </div>
        <%--If we have new short url--%>
        <c:if test="${not empty shortCode}">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center">
                    <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <div class="row">
                            <span>Find your nice URL below.</span>
                        </div>
                        <div class="row">

                            <a href="http://localhost:8080?code=${shortCode}">http://localhost:8080?code=${shortCode}</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

    </jsp:body>
</t:layout>