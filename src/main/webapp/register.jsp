<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            width: 100%;
            max-width: 400px;
        }
        h3 {
            margin-top: 0;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
        .form-group .login-btn {
            background-color: #2196F3;
        }
        .form-group .login-btn:hover {
            background-color: #1e88e5;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>请注册</h3>

        <form method="POST" action="Userregister">
            <div class="form-group">
                <label for="userName">用户名：</label>
                <input type="text" id="userName" name="userName" required />
            </div>
            <div class="form-group">
                <label for="userPwd">密码：</label>
                <input type="password" id="userPwd" name="userPwd" required />
            </div>
            <div class="form-group">
                <button type="submit">注册</button>
            </div>
            <div class="form-group">
                <button type="submit" formaction="Login.jsp" class="login-btn">我要登录</button>
            </div>
        </form>
    </div>
</body>
</html>