<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 10.09.2017
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i><b>Üye Listesi</b></div>
        <div class="actions">
            <a href="/member_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Üye Ekle</span>
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
                    <th> <b>TCNo</b></th>
                    <th> <b>Adı Soyadı</b> </th>
                    <th> <b>Mail</b> </th>
                    <th> <b>Mesleği</b> </th>
                    <th> <b>Telefon</b> </th>
                    <th> <b>İşlem Yap</b></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="count" value="${0}" />
                <c:forEach items="${Members}" var="Member">
                    <tr>
                        <td> ${Member.tcNo} </td>
                        <td> ${Member.name} ${Member.surname}</td>
                        <td> ${Member.mail} </td>
                        <td> ${Member.job} </td>
                        <td>
                            <table class="table table- table-hover table-advance">
                                <thead>
                                    <tr>
                                        <td>
                                                ${arrayList.get(count).get(0)}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                                ${arrayList.get(count).get(1)}
                                        </td>
                                    </tr>
                                </thead>
                            </table>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/member_update/${Member.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/member_delete/${Member.id}"><button type="button" class="btn red">Sil</button></a>
                        </td>
                    </tr>
                    <c:set var="count" value="${count+1}" />
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END SAMPLE TABLE PORTLET-->

<%@include file="inc_footer.jsp"%>