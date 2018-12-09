<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 15.09.2017
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Personel Listesi</b></div>
        <div class="actions">
            <a href="/staff_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Personel Ekle</span>
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
                    <th> <b>Görev</b></th>
                    <th> <b>Adı Soyadı</b> </th>
                    <th> <b>Adres</b> </th>
                    <th> <b>Maaş</b> </th>
                    <th> <b>Başlama Tarihi</b></th>
                    <th> <b>Çıkış Tarihi</b></th>
                    <th> <b>Durum</b></th>
                    <th> <b>Site Adı</b></th>
                    <th> <b>İşlem Yap</b></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Staffs}" var="Staff">
                    <tr>
                        <td> ${Staff.staffTypeByStaffTypeId.name} </td>
                        <td> ${Staff.name} ${Staff.surname}</td>
                        <td> ${Staff.address} </td>
                        <td> ${Staff.salary} </td>
                        <td> ${Staff.startTime} </td>
                        <td> ${Staff.endTime} </td>
                        <td> ${Staff.status} </td>
                        <td> ${Staff.buildingsByBuildingsId.name} </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/staff_update/${Staff.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/staff_delete/${Staff.id}"><button type="button" class="btn red">Sil</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END SAMPLE TABLE PORTLET-->

<%@include file="inc_footer.jsp"%>