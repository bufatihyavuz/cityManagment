<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 27.09.2017
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Araç Listesi</b></div>
        <div class="actions">
            <a href="/vehicle_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Araç Ekle</span>
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
                    <th> <b>Marka</b></th>
                    <th> <b>Renk</b> </th>
                    <th> <b>Plaka</b> </th>
                    <th> <b>Sahibi</b> </th>
                    <th> <b>İşlem Yap</b> </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Vehicles}" var="Vehicle">
                    <tr>
                        <td> ${Vehicle.brand} </td>
                        <td> ${Vehicle.color} </td>
                        <td> ${Vehicle.licencePlate} </td>
                        <td> ${Vehicle.memberByMemberId.name} </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/vehicle_update/${Vehicle.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/vehicle_delete/${Vehicle.id}"><button type="button" class="btn red">Sil</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="inc_footer.jsp"%>