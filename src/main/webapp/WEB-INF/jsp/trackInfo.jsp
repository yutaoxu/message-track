<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>消息轨迹查询.</title>
    <meta charset="utf-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery-1.9.1.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>

    <!--  plugin sources -->
    <script src="/js/validator.min.js"></script>

    <script src="/js/msgType.js"></script>
    <style>
        #description {
            min-height: 120px;
            height: 265px;
            width: 1170px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 align="center">消息轨迹</h1>
    <form class="form-horizontal" role="form" data-toggle="validator">
        <div class="form-group">
            <label for="msgType">查询条件</label>
            <input type="text" class="form-control" id="msgType" placeholder="文本输入" required>
        </div>
        <input class="btn btn-default" type="button" value="追踪消息轨迹" onclick="sub_query()">
        <br>
        <br>
        <div class="form-group" style="display: none" id="queryResult">
            <label for="description">查询结果</label>
            <textarea class="form-control" rows="3" id="description"></textarea>
        </div>
    </form>
</div>
</body>
</html>