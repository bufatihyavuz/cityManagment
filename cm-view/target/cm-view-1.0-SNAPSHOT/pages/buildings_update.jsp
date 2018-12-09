<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 12.09.2017
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@include file="inc_header.jsp"%>

<div class="tab-pane" id="tab_2">
    <!-- BEGIN SAMPLE TABLE PORTLET-->
    <div class="portlet">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa icon-plus"></i>Üye Güncelle
            </div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="buildings" class="form-horizontal"
                       action="${pageContext.request.contextPath}/buildings_update/${buildings.id}">
                <div class="form-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3">Site Adı</label>
                                <div class="col-md-9">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Site Adress</label>
                                <div class="col-md-9">
                                    <form:input path="address" class="form-control"/>
                                </div>
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
                                <button type="/buildings_list/1" class="btn default">İptal</button>
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
