<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Outil d'affichage des comptes</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

</head>
<body>
	<section class="head"></section>
		<section class="account-body">
			<div class="header-account">
				<h1 class="page-title">Liste des comptes de ${client.firstname} ${client.lastname }</h1>
				<div class="transfer-button">
					<a href="transfer.html?id=${id}">
						<button class="button">Faire un virement</button>
					</a>
				</div>
				<div class="transfer-button">
					<a href="withdrawMoney.html?id=${id}">
						<button class="button">Faire un retrait</button>
					</a>
				</div>
				<div class="transfer-button">
					<a href="card.html?id=${id}">
						<button class="button">Commander une carte</button>
					</a>
				</div>
			</div>
		</div>
		<div class="account-list">
			<div class="left-list">
				<h2>Liste des comptes courant</h2>
				<c:if test="${empty currentAccounts}">
					<h4>Aucun compte associ� � ce client.</h4>
				</c:if>
				<c:if test="${not empty currentAccounts}">
					<table>
					<tr>
						<th> Numero de compte </th>
						<th class="balance"> Solde en &#8364</th>
						<th></th>
					</tr>
					<c:forEach var="currentAccount" items="${currentAccounts}">
						<tr class="data">
							<td>${currentAccount.number}</td>
							<td class="balance">${currentAccount.balance}</td>
							<td><button class="button" style="align:right" id= "${currentAccounts}">Retrait ch�quier</button></td>
						</tr>
						
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="right-list">
				<h2>Liste des comptes epargne</h2>
				<c:if test="${empty savingAccounts}">
					<h4>Aucun compte associ� � ce client.</h4>
				</c:if>
				<c:if test="${not empty savingAccounts}">
					<table>
						<tr>
							<th>Numero de compte</th>
							<th class="balance">Solde en &#8364</th>
							<th></th>
						</tr>
						<c:forEach var="saving" items="${savingAccounts }">
							<tr class="data">
								<td>${saving.number}</td>
								<td class="balance">${saving.balance}</td>
								<td><button class="button" style="align:right" id= "${savingAccounts}">Retrait ch�quier</button></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="footer-button">
				<a href="index.html">
					<button class="button">Retour � l'accueil</button>
				</a>
			</div>
		</section>
</body>
</html>