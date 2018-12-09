<%@include file="inc_header.jsp"%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>
<!-- BEGIN PAGE HEADER-->
<!-- BEGIN PAGE TITLE-->
<h1 class="page-title"> İstatistikler</h1>
<!-- END PAGE TITLE-->
<!-- END PAGE HEADER-->
<!-- BEGIN DASHBOARD STATS 1-->
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <a class="dashboard-stat dashboard-stat-v2 blue" href="/buildings_list/1">
            <div class="visual">
                <i class="fa fa-comments"></i>
            </div>
            <div class="details">
                <div class="number">
                    <span data-counter="counterup" data-value=${buildingsCount}>0</span>
                </div>
                <div class="desc"> Site Sayısı </div>
            </div>
        </a>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <a class="dashboard-stat dashboard-stat-v2 red" href="/apartment_list/1">
            <div class="visual">
                <i class="fa fa-bar-chart-o"></i>
            </div>
            <div class="details">
                <div class="number">
                    <span data-counter="counterup" data-value=${apartmentCount}>0</span>
                </div>
                <div class="desc"> Apartman Sayısı </div>
            </div>
        </a>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <a class="dashboard-stat dashboard-stat-v2 green" href="/unit_list/all/1">
            <div class="visual">
                <i class="fa fa-shopping-cart"></i>
            </div>
            <div class="details">
                <div class="number">
                    <span data-counter="counterup" data-value=${unitCount}>0</span>
                </div>
                <div class="desc"> Daire Sayısı </div>
            </div>
        </a>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <a class="dashboard-stat dashboard-stat-v2 purple" href="/member_list/1">
            <div class="visual">
                <i class="fa fa-database"></i>
            </div>
            <div class="details">
                <div class="number">
                    <span data-counter="counterup" data-value=${memberCount}></span>
                </div>
                <div class="desc"> Üye Sayısı </div>
            </div>
        </a>
    </div>
</div>

<%@include file="inc_footer.jsp"%>

                    