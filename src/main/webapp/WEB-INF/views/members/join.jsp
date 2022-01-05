<%--
  Created by IntelliJ IDEA.
  User: AICT
  Date: 2022-01-05
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join</title>
</head>
<body>
<div class="container">
    <form action="/members/join" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
            <input type="text" id="password" name="password" placeholder="비밀번호를 입력하세요">
            <input type="text" id="nickName" name="nickName" placeholder="별명을 입력하세요">
            <input type="text" id="email" name="email" placeholder="이메일을 입력하세요">
            <input type="int" id="age" name="age" placeholder="나이를 입력하세요">
            <input type="int" id="sex" name="sex" placeholder="성별을 입력하세요">
            <input type="text" id="phoneNumber" name="phoneNumber" placeholder="핸드폰 번호를 입력하세요">
        </div>
        <button type="submit">등록</button>
    </form>
</div> <!-- /container -->
</body>
</html>
