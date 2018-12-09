<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 20.09.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="inc_header.jsp" %>


<div class="tab-pane" id="tab_2">
    <!-- BEGIN SAMPLE TABLE PORTLET-->
    <div class="portlet">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa icon-plus"></i>Personel Güncelle
            </div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="Staff" class="form-horizontal"
                       action="${pageContext.request.contextPath}/staff_update/${Staff.id}">
            <div class="form-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-3">Adı</label>
                            <div class="col-md-9">
                                <form:input path="name" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Soyadı</label>
                            <div class="col-md-9">
                                <form:input path="surname" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Adres</label>
                            <div class="col-md-9">
                                <form:input path="address" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Maaş</label>
                            <div class="col-md-9">
                                <form:input path="salary" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Görev</label>
                            <div class="col-md-9">
                                <form:select class="form-control" path="staffTypeByStaffTypeId.id">
                                    <form:option value="1" label="1-Güvenlik"/>
                                    <form:option value="2" label="2-Bahçıvan"/>
                                    <form:option value="3" label="3-Temizlik Görevlisi"/>
                                    <form:option value="4" label="4-Otopark Görevlisi"/>
                                    <form:option value="5" label="5-Hatırlatıcı"/>
                                    <form:option value="6" label="6-Silici"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Durum</label>
                            <div class="col-md-9">
                                <form:select class="form-control" path="status">
                                    <form:option value="0" label="Aktif"/>
                                    <form:option value="1" label="Pasif"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Başlama Tarihi</label>
                            <div class="col-md-9">
                                <form:input class="form-control" type="date" path="startTime" required="true"
                                            placeholder="dd/MM/yyyy"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Çıkış Tarihi</label>
                            <div class="col-md-9">
                                <form:input class="form-control" type="date" path="endTime" required="true"
                                            placeholder="dd/MM/yyyy"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Çalışma Alanı</label>
                            <div class="col-md-9">
                                <form:select  class="form-control"  path="buildingsByBuildingsId.id">
                                    <c:forEach items="${buildingsList}"  var="buildings">
                                        <form:option  value="${buildings.id}" label="${buildings.name}" />
                                    </c:forEach>
                                </form:select>
                            </div>
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
                        <button type="submit" href="/staff_list/1" class="btn default">Temizle</button>
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