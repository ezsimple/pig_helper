<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<%@include file="include/meta.jsp" %>
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <jsp:include page="include/nav.jsp">
  	<jsp:param value="" name="s0"/>
  	<jsp:param value="" name="s1"/>
  </jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">시작하면서 ... </h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">시작하면서</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
        이 프로그램은 피그플랜(구) 운영팀을 위해 제작 되었습니다.
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->

  </div>
  <!-- /.content-wrapper -->
  <%@include file="include/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@include file="include/script.jsp" %>
</body>
</html>