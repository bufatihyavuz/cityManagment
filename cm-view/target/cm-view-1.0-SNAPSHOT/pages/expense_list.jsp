<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 22.09.2017
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Gider Listesi</b></div>
        <div class="actions">
            <a href="/expense_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Gider Ekle</span>
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
                    <th> <b>Site</b></th>
                    <th> <b>Miktar(₺)</b> </th>
                    <th> <b>Tarih</b> </th>
                    <th> <b>Gider Tipi</b> </th>
                    <th> <b>İşlem Yap</b></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Expenses}" var="expense">
                    <tr>
                        <td> ${expense.buildingsByBuildingsId.name} </td>
                        <td> ${expense.amount.intValue()}</td>
                        <td> ${expense.date} </td>
                        <td> ${expense.expenseTypeByExpenseTypeId.name} </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/expense_update/${expense.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/expense_delete/${expense.id}"><button type="button" class="btn red">Sil</button></a>
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
