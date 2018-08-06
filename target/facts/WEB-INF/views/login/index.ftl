<@override name="title">登录页面</@override>
<@block name="head">
<style>
    #form-box{display: table; margin: 0 auto; height: 100%;}
    #login-form{width: 500px; margin: 0 auto; display: table-cell; vertical-align: middle;}
</style>
</@block>
<@override name="body">
<div id="form-box">
    <form class="layui-form" id="login-form" action="/login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" value="" required  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" value=""  placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="login">登陆</button>
            </div>
        </div>
    </form>
</div>
</@override>
<@override name="script">

</@override>
<@extends name="/base/base.ftl" />