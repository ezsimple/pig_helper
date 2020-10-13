<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="on_0" value="${param.s0 }" />
<c:set var="on_1" value="${param.s1 }" />

<c:set var="act_0" value="${param.a0 }" />
<c:set var="act_1" value="${param.a1 }" />
<c:set var="act_2" value="${param.a2 }" />
<c:set var="act_3" value="${param.a3 }" />
<c:set var="act_4" value="${param.a4 }" />
<c:set var="act_5" value="${param.a5 }" />
<c:set var="act_6" value="${param.a6 }" />

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/" class="nav-link">Home</a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/" class="brand-link">
      <img src="${sessionScope._adminlte }/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">Old Pig Helper</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview ${on_0 == 'active'?'menu-open':'' }">
            <a href="#" class="nav-link ${on_0 }">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                엑셀업로드
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/yukjongga.do" class="nav-link ${act_0 }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>월요일 육종가</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/sisae.do" class="nav-link ${act_1 }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>매달 시세</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/farm_migration.do" class="nav-link ${act_2 }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>농장 데이터 이관</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/dabi_seangsi_chejung.do" class="nav-link ${act_3 }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>다비육종 생시체중</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/jumjungzaryu_imf.do" class="nav-link ${act_4 }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>검정자료 IMF값</p>
                </a>
              </li>
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/dodram_update.do" class="nav-link ${act_5} }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>도드람 농가 업데이트</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
        
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview ${on_1 == 'active'?'menu-open':'' }">
            <a href="#" class="nav-link ${on_1 }">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                엑셀 다운로드
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/excel/jadondunggi_print.do" class="nav-link ${act_6} }">
                  <i class="far fa-circle nav-icon"></i>
                  <p>자돈등기 파일출력</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
        
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>