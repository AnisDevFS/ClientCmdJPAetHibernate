<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css"> 
 <link rel="stylesheet" href="css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<div class="container pt-5">
<h3>Details  de la voiture: ${lavoiture.getId_voiture()} !</h3>

<p>Marque :  ${lavoiture.getMarque()}</p>
<p>Réference :  ${lavoiture.getReference()}</p>
<p>Couleur : ${lavoiture.getCouleur()}</p>
	
<div class=" row bg-light p-5"
		style="width: 100%; margin-left: auto; margin-right: auto; margin-top: 50px; text-align: center;">
		<div class="col-11">
			<h3>Liste des proprietaires</h3>
			<table class="table">
				<thead class="thead-dark">
					<tr>			
						<th scope="col">Nom</th>
						<th scope="col">Email</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prop" items="${listeProprietaires}">
								<tr>
									<td><c:out value="${prop.getNom()}" /></td>
									<td><c:out value="${prop.getEmail()}" /></td>
									
								</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		

	</div>	
	
</div>
</body>
</html>