<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 12.09.2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Apartman Listesi</b></div>
        <div class="actions">
            <a href="/apartment_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Apartman Ekle</span>
                </button>
            </a>
            <a href="#">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-printer"></i> Rapor Al</span>
                </button>
            </a>
        </div>
    </div>
    <div class="portlet-body">
        <div class="table-scrollable">
            <table class="table table-hover table-advance">
                <thead>
                <tr>
                    <th> <b>Apartman No</b></th>
                    <th> <b>Site</b> </th>
                    <th> <b>Kat No</b> </th>
                    <th> <b>İşlem Yap</b> </th>
                </tr>
                </thead>
                <tbody>
                <c:set var="count" value="0" scope="page" />
                <c:forEach items="${Apartments}" var="Apartment">
                    <tr>
                        <td> ${Apartment.apartmentNo} </td>
                        <td> ${Apartment.buildingsByBuildingsId.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/floor_delete/${Apartment.id}"><button type="button" class="glyphicon glyphicon-minus"></button></a>
                                ${maxFloorCountList.get(count)}
                            <a href="${pageContext.request.contextPath}/floor_add/${Apartment.id}"><button type="button" class="glyphicon glyphicon-plus"></button></a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/apartment_update/${Apartment.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/apartment_delete/${Apartment.id}"><button type="button" class="btn red">Sil</button></a>
                        </td>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END SAMPLE TABLE PORTLET-->

<%@include file="inc_footer.jsp"%>
