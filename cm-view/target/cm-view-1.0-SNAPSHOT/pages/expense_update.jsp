<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 22.09.2017
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@include file="inc_header.jsp"%>

<div class="tab-pane" id="tab_2">
    <!-- BEGIN SAMPLE TABLE PORTLET-->
    <div class="portlet">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa icon-plus"></i>Gider Güncelle</div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="expense" class="form-horizontal"
                       action="${pageContext.request.contextPath}/expense_update/${expense.id}">
                <div class="form-body">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-md-3">Gider Tipi</label>
                                <div class="col-md-9">
                                    <form:select class="form-control" path="expenseTypeByExpenseTypeId.id">
                                        <form:option value="1" label="1-Fatura"/>
                                        <form:option value="2" label="2-Maaş"/>
                                        <form:option value="3" label="3-Malzeme"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Site Seç</label>
                                <div class="col-md-9">
                                    <form:select  class="form-control" path="buildingsByBuildingsId.id">
                                        <c:forEach items="${buildingsList}" var="buildings">
                                            <form:option  value="${buildings.id}" label="${buildings.name}"  />
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Tarih</label>
                                <div class="col-md-9">
                                    <form:input class="form-control" type="date" path="date"  required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Miktar</label>
                                <div class="col-md-9">
                                    <form:input path="amount" class="form-control"/>
                                </div>
                            </div>
                        </div>
                </div>
                <div class="form-actions">
                    <div class="m-grid m-grid-responsive-lg">
                        <div class="m-grid-row">
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center"></div>
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center">
                                <button type="submit" class="btn green">Güncelle</button>
                                <button type="submit" href="/expense_list/1" class="btn default">İptal</button>
                            </div>
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center"></div>
                        </div>
                    </div>
                </div>
            </form:form>
            <!-- END FORM-->
        </div>
    </div>
    <!-- END SAMPLE TABLE PORTLET-->
</div>

<%@include file="inc_footer.jsp"%>
