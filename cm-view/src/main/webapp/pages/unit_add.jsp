<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 06.09.2017
  Time: 01:13
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
                <i class="fa icon-plus"></i>Daire Ekle
            </div>
        </div>
        <div class="portlet-body form">
            <div class="form-body">
                <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <form:form role="form" method="POST" commandName="buildings" class="form-horizontal"
                                           action="${pageContext.request.contextPath}/unit_add/selectBuilds"> <!-- tıklandıgında gidilecek yer -->
                                <label class="control-label col-md-4">Site</label>
                                <div class="col-md-5">
                                    <form:select  id="selBuild"  path="id" class="form-control" title="Eklemek İstediğiniz Siteyi Seçiniz">
                                    <option disabled selected>Site Seçiniz</option>
                                        <c:forEach items="${buildingsList}" var="buildings">
                                            <form:option value="${buildings.id}" label="${buildings.name}"/>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                </form:form>
                            </div>
                            <div class="form-group">
                                <form:form role="form" method="POST" commandName="apartment" class="form-horizontal"
                                           action="${pageContext.request.contextPath}/unit_add/selectApartments">
                                    <label class="control-label col-md-4">Apartman</label>
                                    <div class="col-md-5">
                                        <form:select id="selAp" path="id" class="form-control"
                                                     title="Eklemek İstediğiniz Apartmanı Seçiniz">
                                            <option disabled selected>Apartman Seçiniz</option>
                                        </form:select>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                </div>
                <br>
                <form:form role="form" method="POST" commandName="unit" class="form-horizontal"
                           action="${pageContext.request.contextPath}/unit_add">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-3">Daire Sakini</label>
                            <div class="col-md-9">
                                <form:select  path="memberByMemberId.id" class="form-control">
                                    <c:forEach items="${memberList}" var="member">
                                        <form:option value="${member.id}" label="${member.name}"/>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-3">Daire Numarasi</label>
                            <div class="col-md-9">
                                <form:input path="unitNo" class="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-3">Daire Kati</label>
                            <div class="col-md-9">
                                <form:select id="selfloor" path="floorByFloorId.id" class="form-control"
                                             title="Eklemek İstediğiniz Katı Seçiniz">
                                    <option disabled selected>Kat Seçiniz</option>
                                </form:select>
                                <span class="help-block"> Daire katini giriniz</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
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
                <div class="form-actions">
                    <div class="m-grid m-grid-responsive-lg">
                        <div class="m-grid-row">
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center"></div>
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center">
                                <button type="submit" class="btn green">Ekle</button>
                                <button type="button" class="btn default">Iptal</button>
                            </div>
                            <div class="m-grid-col m-grid-col-middle m-grid-col-center"></div>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>
    <!-- END SAMPLE TABLE PORTLET-->
</div>

<%@include file="inc_footer.jsp" %>

    <script type="text/javascript">
        // seçtiğimiz sitenin apartmanlarını listele.
        $(document).ready(function () {
            $("#selBuild").change(function () {
                var id = $(this).val();
                $("#selAp").empty();
                $.ajax({
                    method:"GET",
                    url:"/unit_add/selectBuilds",
                    data:{"key":id},
                    success:function (result) {
                        //alert(id);
                        $.each(result,function (item,resultDeger) {
                            //alert("apartmentId ->"+resultDeger[0] + "apartmanNo -> "+resultDeger[2]);
                            $("#selAp").append('<option value="' + [resultDeger[0]] + '">' + [resultDeger[2]] + '</option>');
                        })
                    },
                    error: function() {
                        alert("hata oluştu")
                    }
                })

            });
            $("#selAp").change(function () {
                var id = $(this).val();
                $("#selfloor").empty();
                $.ajax({
                    method:"GET",
                    url:"/unit_add/selectApartments",
                    data:{"key":id},
                    success:function (result) {
                        //alert("success "+result);
                        $.each(result,function (item,resultDeger) {

                            $("#selfloor").append("<option value='" + [resultDeger[0]] + "'>" + [resultDeger[2]] + "</option>");
                        })
                    },
                    error: function() {
                        alert("Floorda Hata Oluştu")
                    }
                 })

            });
        });


    </script>


