
<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 06.09.2017
  Time: 01:13
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
                <i class="fa icon-plus"></i>Daire Güncelle</div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="unit" class="form-horizontal"
                       action="${pageContext.request.contextPath}/unit_update/${unit.id}">
                <div class="form-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3">Daire Sakini</label>
                                <div class="col-md-9">
                                    <form:select  class="form-control" path="memberByMemberId.id">
                                        <c:forEach items="${memberList}" var="member">
                                            <form:option  value="${member.id}" label="${member.name}"  />
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Daire Kati</label>
                                <div class="col-md-9">
                                    <form:select  class="form-control" path="floorByFloorId.id">
                                        <c:forEach items="${floorList}" var="floor">
                                            <form:option  value="${floor.id}" label="${floor.floorNo}"  />
                                        </c:forEach>
                                    </form:select>
                                    <span class="help-block"> Daire katini giriniz</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3">Daire Numarası</label>
                                <div class="col-md-9">
                                    <form:input path="unitNo" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Daire Tipi</label>
                                <div class="col-md-9">
                                    <form:select  path="unitTypeByUnitTypeId.id" class="form-control">
                                        <c:forEach items="${unitTypeList}" var="unitType">
                                            <form:option value="${unitType[0]}" label="${unitType[1]}"/>
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
                                <button type="submit" class="btn green">Güncelle</button>
                                <button type="submit" href="/member_list/1" class="btn default">İptal</button>
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
