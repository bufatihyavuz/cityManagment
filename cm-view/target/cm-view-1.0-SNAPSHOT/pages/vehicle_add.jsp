<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 27.09.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="inc_header.jsp" %>


<div class="tab-pane" id="tab_2">
    <!-- BEGIN SAMPLE TABLE PORTLET-->
    <div class="portlet">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa icon-plus"></i>Araç Ekle
            </div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="vehicle" class="form-horizontal"
                       action="${pageContext.request.contextPath}/vehicle_add">
            <div class="form-body">

            </div>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3">Marka</label>
                        <div class="col-md-9">
                            <form:input path="brand" class="form-control" required="true" placeholder="Honda"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">Renk</label>
                        <div class="col-md-9">
                            <form:input path="color" class="form-control" required="true" placeholder="Siyah"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">Plaka</label>
                        <div class="col-md-9">
                            <form:input path="licencePlate" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">Sahip</label>
                        <div class="col-md-9">
                            <form:select  class="form-control"  path="memberByMemberId.id">
                                <c:forEach items="${members}"  var="member">
                                    <form:option  value="${member.id}" label="${member.name}" />
                                </c:forEach>
                            </form:select>
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
                        <button type="submit" class="btn green">Ekle</button>
                        <button type="reset" class="btn default">Temizle</button>
                    </div>
                    <div class="m-grid-col m-grid-col-middle m-grid-col-center"></div>
                </div>
            </div>
        </div>

        </form:form>
        <!-- END FORM-->
        <!-- END FORM-->

    </div>
</div>
<!-- END SAMPLE TABLE PORTLET-->
</div>

<%@include file="inc_footer.jsp" %>