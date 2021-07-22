<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login screen</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>Login screen</h1>
	
	    <form method="post" action="login">

	        Email : 
	        <input name="txtEmail" value="${email}" autofocus />
	        <br/>

            Password : 
            <input name="txtPassword" type="password" value="${password}" />
            <br/> <br/>
	        
	        <input type="submit" value="Connect" />
	        <br/><br/>
	        
            <div class="errorMessage">${errorMessage}</div>
            
	    </form>
	    	
	</body>
</html>