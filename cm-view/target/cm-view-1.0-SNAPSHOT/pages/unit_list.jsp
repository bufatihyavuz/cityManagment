<%--
  Created by IntelliJ IDEA.
  User: fatih
  Date: 06.09.2017
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc_header.jsp"%>

<!-- BEGIN SAMPLE TABLE PORTLET-->
<div class="portlet">
    <div class="portlet-title">
        <div class="caption"><i class="fa icon-home"></i>Daire Listesi</div>&nbsp;
        <input type="text" id="inputsearchKey">
        <a onclick="searchListele()" id="btn1"  class="btn btn-success">
            <span class="glyphicon glyphicon-search"></span> Search
        </a>
        <div class="actions">
            <a href="/unit_add">
                <button type="button"
                        class="btn green mt-ladda-btn ladda-button btn-circle btn-outline"
                        data-style="slide-left"
                        data-spinner-color="#333">
                    <span class="ladda-label"><i class="icon-plus"></i> Daire Ekle</span>
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
                    <th> Daire Numarasi </th>
                    <th> Daire Sakini</th>
                    <th> Daire Kati </th>
                    <th> Daire Tipi </th>
                    <th> İşlem Yap</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Units}" var="Unit">
                    <tr>
                        <td> ${Unit.unitNo}</td>
                        <td> ${Unit.memberByMemberId.name} </td>
                        <td> ${Unit.floorByFloorId.floorNo} </td>
                        <td> ${Unit.unitTypeByUnitTypeId.unitType} </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/unit_update/${Unit.id}"><button type="button" class="btn green-jungle">Güncelle</button></a>
                            <a href="${pageContext.request.contextPath}/unit_delete/${Unit.id}"><button type="button" class="btn red">Sil</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-2 col-md-offset-5">
        <ul class="pagination">
            <c:if test="${sayfaNo>1}">
                <li class="page-item"><a class="page-link" id="previousButton" href="/unit_list/${searching}/${sayfaNo-1}">Previous</a></li>
            </c:if>
            <c:forEach var="i" begin="1" end="${sayfaSayisi}">
                <li class="page-item"><a class="page-link" id="numberButton" href="/unit_list/${searching}/${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${sayfaNo < sayfaSayisi}">
                <li class="page-item"><a class="page-link" id="nextButton" href="/unit_list/${searching}/${sayfaNo+1}">Next</a></li>
            </c:if>
        </ul>
        </div>
    </div>
<!-- END SAMPLE TABLE PORTLET-->

<%@include file="inc_footer.jsp"%>

<script>

    // search butonuna tıklandıgında ilgili linke git
    function searchListele(){ //search butonu
        /*if(document.getElementById('inputsearchKey').value.isEqual("")){
            document.getElementById('btn1').href="/unit_list/all/1";
        }else*/
        document.getElementById('btn1').href="/unit_list/"+ document.getElementById('inputsearchKey').value + "/1";
    }

    /*entera basınca search yapsın --- ÇALIŞMIYOR ---
    $('#inputsearchKey').keydown(function(e) {
        if (e.keyCode == 13 || e.which == 13) {
           $("#btn1").click();
        }
    });*/

</script>
            