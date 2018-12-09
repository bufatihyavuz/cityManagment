<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 11.09.2017
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Site Listesi</b></div>
        <div class="actions">
            <a href="/buildings_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Site Ekle</span>
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
                    <th> <b>Site Adı</b></th>
                    <th> <b>Site Adresi</b> </th>
                    <th> <b>İşlem Yap</b> </th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Buildingss}" var="Buildings">
                    <tr>
                        <td> ${Buildings.name} </td>
                        <td> ${Buildings.address}</td>
                        <td>
                            <a href="#"><button type="button" class="btn green">Gelirleri Göster</button></a>
                            <a href="/expense_list/1"><button type="button" class="btn green">Giderleri Göster</button></a>
                            <a href="/member_list/1"><button type="button" class="btn green">Üyeleri Göster</button></a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/buildings_update/${Buildings.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/buildings_delete/${Buildings.id}"><button type="button" class="btn red">Sil</button></a>
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
