<%--
  Created by IntelliJ IDEA.
  User: Fatih
  Date: 10.09.2017
  Time: 13:24
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
                <i class="fa icon-plus"></i>Üye Ekle
            </div>
        </div>
        <div class="portlet-body form">
            <!-- BEGIN FORM-->
            <form:form role="form" method="POST" commandName="member" class="form-horizontal"
                       action="${pageContext.request.contextPath}/member_add">
                <div class="form-body">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-md-4"><b>Üye Rolü Seç</b></label>
                                <div class="col-md-8">
                                    <form:select class="form-control" path="memberRoleByMemberRoleId.id">
                                        <form:option value="1" label="1-Admin"/>
                                        <form:option value="2" label="2-Ev Sahibi"/>
                                        <form:option value="3" label="3-Kiracı"/>
                                    </form:select>
                                    
                                </div>

                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-4"></div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3">Adı</label>
                                <div class="col-md-9">
                                    <form:input path="name" class="form-control" required="true" placeholder="Ahmet"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Soyadı</label>
                                <div class="col-md-9">
                                    <form:input path="surname" class="form-control" required="true" placeholder="Tok"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Kullanıcı Adı</label>
                                <div class="col-md-9">
                                    <form:input path="username" class="form-control" required="true" placeholder="ahmet1971"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Şifre</label>
                                <div class="col-md-9">
                                    <form:input path="password" class="form-control" required="true" placeholder="M4kr156."/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Mail</label>
                                <div class="col-md-9">
                                    <form:input path="mail" class="form-control" required="true" placeholder="ahmet@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Meslek</label>
                                <div class="col-md-9">
                                    <form:input path="job" class="form-control" required="true" placeholder="Öğretmen"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3">TCNo</label>
                                <div class="col-md-9">
                                    <form:input path="tcNo" class="form-control" required="true" placeholder="18574859685" pattern="\d*" maxlength="11"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Cinsiyet</label>
                                <div class="col-md-9">
                                    <form:select class="form-control" path="gender">
                                        <form:option value="0" label="Erkek"/>
                                        <form:option value="1" label="Kadın"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Medeni Durum</label>
                                <div class="col-md-9">
                                    <form:select class="form-control" path="marialStatus">
                                        <form:option value="0" label="Evli"/>
                                        <form:option value="1" label="Bekar"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Birthday</label>
                                <div class="col-md-9">
                                    <form:input class="form-control" type="date" path="birthday" required="true"
                                                placeholder="dd/MM/yyyy"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Telefon1</label>
                                <div class="col-md-9">
                                    <input name="phone1" class="form-control" placeholder="phone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Telefon2</label>
                                <div class="col-md-9">
                                    <input name="phone2" class="form-control" placeholder="phone"/>
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