<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script src="../js/jquery-3.7.1.min.js"></script>
       <script type="text/javascript">
           function getBackPage(){
               window.history.back();
           }

           function regCarpool(){
               $.ajax({
                   url: "/carpool/regCarpool",
                   data: $("#frm").serialize(),
                   method: "POST",
                   dataType: "text",
                   async: false,
                   cache: "false",
                   success:function(data){
                       $("#frm").attr({"action": "/carpool", "method":"post"}).submit();
                   },
                   error:function(){
                       console.log("error");
                   }
               });
           }
       </script>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카풀 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input,
        .form-group textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group textarea {
            resize: vertical;
        }
        .form-group button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #000000;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #000000;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>카풀 등록</h1>
        <form id="frm" name="frm" method="post">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="cnt" rows="10" required></textarea>
            </div>
            <div class="form-group">
                <button onclick="regCarpool();">등록</button>
            </div>
            <div class="form-group">
                <button onclick="getBackPage();">뒤로가기</button>
            </div>
        </form>
    </div>
</body>
</html>

