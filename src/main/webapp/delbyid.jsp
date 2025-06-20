<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <!-- 注意：content-type在<meta>标签中通常用于描述内容，而不是设置HTTP响应头。
         对于HTTP响应头，它应该在服务器端设置（例如，在JSP页面的顶部使用page指令）。
         因此，这里的content-type meta标签实际上是多余的，但由于您的要求保持原样。 -->
    <title>删除员工信息</title>
    <style>
        /* 重置浏览器默认样式 */
        body, html {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* 居中表单的容器 */
        .centered-form {
            width: 300px; /* 表单宽度 */
            margin: 50px auto; /* 上下外边距为50px，左右自动（实现居中） */
            text-align: left; /* 表单内文本左对齐 */
        }

        /* 表单内的标签和输入框样式 */
        .centered-form label {
            display: block; /* 标签独占一行 */
            margin-bottom: 5px; /* 标签和输入框之间的间距 */
            font-weight: bold; /* 标签字体加粗 */
        }

        .centered-form input[type="text"] {
            width: calc(100% - 22px); /* 宽度为容器宽度减去左右padding（假设有11px的padding，但这里未设置，仅为示例） */
            padding: 10px; /* 内边距 */
            border: 1px solid #ccc; /* 边框 */
            border-radius: 4px; /* 圆角 */
            box-sizing: border-box; /* 包括padding和border在内的宽度计算 */
        }

        .centered-form input[type="submit"] {
            width: 100%; /* 宽度为容器宽度 */
            padding: 10px; /* 内边距 */
            background-color: #f44336; /* 背景色 */
            color: #fff; /* 文字颜色 */
            border: none; /* 无边框 */
            border-radius: 4px; /* 圆角 */
            cursor: pointer; /* 鼠标悬停时显示手型 */
            font-size: 16px; /* 字体大小 */
            transition: background-color 0.3s; /* 背景色过渡效果 */
        }

        .centered-form input[type="submit"]:hover {
            background-color: #da190b; /* 鼠标悬停时背景色变深 */
        }
    </style>
    <script type="text/javascript">
        // JavaScript函数，用于在点击删除按钮时显示确认对话框
        function confirmDelete() {
            var userConfirmed = confirm("您确定要删除此员工信息吗？");
            return userConfirmed; // 直接返回确认结果
        }
    </script>
</head>
<body>
    <div class="centered-form"> <!-- 使用CSS类来居中表单 -->
        <form action="delbyid" method="post" onsubmit="return confirmDelete();">
            <label for="bh">请输入要删除的员工编号：</label>
            <input type="text" id="bh" name="bh" />
            <input type="submit" value="删除" />
        </form>
    </div>
</body>
</html>