<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "WebPackage.admin.adminInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistics</title>
</head>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
<style>

.circle-tile {
    margin-bottom: 15px;
    text-align: center;
}
.circle-tile-heading {
    border: 3px solid rgba(255, 255, 255, 0.3);
    border-radius: 100%;
    color: #FFFFFF;
    height: 80px;
    margin: 0 auto -40px;
    position: relative;
    transition: all 0.3s ease-in-out 0s;
    width: 80px;
}
.circle-tile-heading .fa {
    line-height: 80px;
}
.circle-tile-content {
    padding-top: 50px;
}
.circle-tile-number {
    font-size: 26px;
    font-weight: 700;
    line-height: 1;
    padding: 5px 0 15px;
}
.circle-tile-description {
    text-transform: uppercase;
}
.circle-tile-footer {
    background-color: rgba(0, 0, 0, 0.1);
    color: rgba(255, 255, 255, 0.5);
    display: block;
    padding: 5px;
    transition: all 0.3s ease-in-out 0s;
}
.circle-tile-footer:hover {
    background-color: rgba(0, 0, 0, 0.2);
    color: rgba(255, 255, 255, 0.5);
    text-decoration: none;
}
.circle-tile-heading.dark-blue:hover {
    background-color: #2E4154;
}
.circle-tile-heading.red:hover {
    background-color: #CF4435;
}
.tile-img {
    text-shadow: 2px 2px 3px rgba(0, 0, 0, 0.9);
}

.dark-blue {
    background-color: #34495E;
}
.red {
    background-color: #E74C3C;

}
.text-faded {
    color: rgba(255, 255, 255, 0.7);
}
.col-lg-2{width:35%}
.col-sm-6{width:35%}
.container{padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}
</style>
<body  style="background-color:lavender;">


<center>
<br><br><br>
<div class="container">
    <div class="col-lg-2 col-sm-6">
      <div class="circle-tile ">
        <div class="circle-tile-heading dark-blue"><i class="fa fa-users fa-fw fa-3x"></i></div>
        <div class="circle-tile-content dark-blue">
          <div class="circle-tile-description text-faded"> Users </div>
          <div class="circle-tile-number text-faded "><%=adInfo.getNumWebUsers()%></div>
        </div>
      </div>
    </div>
<br><br>
     
    <div class="col-lg-2 col-sm-6">
      <div class="circle-tile ">
        <div class="circle-tile-heading red"><i class="fa fa-question fa-fw fa-3x"></i></div>
        <div class="circle-tile-content red">
          <div class="circle-tile-description text-faded"> Quizzes </div>
          <div class="circle-tile-number text-faded "><%=adInfo.getNumWebQuizzes()%></div>
        </div>
      </div>
    </div> 
  </div> 
<br><br>

</body>
</body>
</html>