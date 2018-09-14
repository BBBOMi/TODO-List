<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/todoForm.css?ver=1" rel="stylesheet" type="text/css">
<title>TODO 등록</title>
</head>
<body>
<form method="post" action="todoAdd">
    <header>
      <h1>할일 등록</h1>
    </header>
    
    <content>
      <div class="title">
        <span>어떤일인가요?<br></span>
        <input type="text" name="title" placeholder="swift 공부하기(24자까지)" maxlength="24" required style="width: 99%; height: 25px; margin-top: 8px;">
      </div>
      <br>
      <div class="name">
        <span>누가 할일인가요?<br></span>
        <input type="text" name="name" placeholder="홍길동" required style="height: 25px; margin-top: 8px;">
      </div>
      <br>
      <div class="sequence">
        <span>우선순위를 선택하세요<br></span>
        <input type="radio" value="1" name="sequence" style="margin-top: 8px;" required>1순위&nbsp;&nbsp;&nbsp;
        <input type="radio" value="2" name="sequence" style="margin-top: 8px;">2순위&nbsp;&nbsp;&nbsp;
        <input type="radio" value="3" name="sequence" style="margin-top: 8px;">3순위
      </div>
    </content>
    <footer>
     <input type="button" id="before" value="<이전">
      <input type="submit" id="submit" value="제출">
      <input type="reset" id="reset" value="내용지우기">
    <footer>
  </form>
  <script src="js/script.js" type="text/javascript"></script>
</body>
</html>