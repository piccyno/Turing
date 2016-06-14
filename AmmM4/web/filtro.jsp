<%-- 
    Document   : cliente
    Created on : 05-giu-2016, 21.11.57
    Author     : Simone
--%>
 
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="disco" items="${listaDischi}">
        <json:object>
            <json:property name="id" value="${disco.getId()}"/>
            <json:property name="titolo" value="${disco.getTitolo()}"/>
            <json:property name="copertina" value="${disco.getCopertina()}"/>
            <json:property name="disponibilita" value="${disco.getdisponibilita()}"/>
            <json:property name="descrizione" value="${disco.getDescrizione()}"/>
            <json:property name="prezzo" value="${disco.getPrezzo()}"/>
        </json:object>
    </c:forEach>
</json:array>