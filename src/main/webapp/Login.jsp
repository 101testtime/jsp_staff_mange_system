<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .login-container h1 {
            margin-bottom: 20px;
        }
        .login-form-group {
            margin-bottom: 15px;
            text-align: left; /* 更改这里的对齐方式 */
        }
        .login-form-group label {
            display: block;
            margin-bottom: 5px;
            text-align: left; /* 确保标签文本左对齐 */
        }
        .login-form-group input {
            width: calc(100% - 22px); /* 减去左右padding和border的宽度，确保输入框填满剩余空间 */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* 确保padding和border包含在宽度内 */
        }
        .login-form-group button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .login-form-group button:hover {
            background-color: #45a049;
        }
        .login-container a {
            display: block;
            margin-top: 10px;
            color: #1a0dab;
            text-decoration: none;
            text-align: center; /* 链接文本居中对齐 */
        }
        .login-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>登录界面</h1>
        <form method="post" action="UserServert" class="login-form">
            <div class="login-form-group">
                <label for="user">用户名：</label>
                <input type="text" id="user" name="user">
            </div>
            <div class="login-form-group">
                <label for="password">密码：</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="login-form-group">
                <button type="submit">登陆</button>
            </div>
            <div class="login-form-group">
                <a href="register.jsp">注册</a>
            </div>
        </form>
    </div>
</body>
</html>