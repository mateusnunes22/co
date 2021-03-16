<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Contro Midia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="style.css" type="text/css" />
<style type="text/css">
.style1 {
	font-size: 9px
}

.style3 {
	font-size: 12;
	font-weight: bold;
}

.style4 {
	font-family: Verdana, Arial, Helvetica, sans-serif
}

.style6 {
	font-size: 12;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}

.style7 {
	font-size: 12px;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
	<f:view>

		<div id="bodyWrap">
			<div class="pageWrapper">
				<div id="header">
					<div id="logo">
						<h1>Logo &trade;</h1>
						<img src="images/lOGOMARCA.JPG" alt="" width="240" height="146" />
					</div>
					<div id="heading">
						<div class="head"></div>
						<div class="top">
							<a href="cadastrocliente.jsf"> Cadastrar empresa</a><a
								href="boss.jsf">busca matéria</a><a href="arquivo.jsf">Cadastrar
								Matéria</a>
						</div>
						e
					</div>
				</div>
			</div>
			<div class="pageWrapper" id="main">
				<div class="gap"></div>
				<div class="gap"></div>

				<div id="mainOuter">
					<div id="mainInner">
						<div class="right"></div>
						<div class="content">
							<h1>&nbsp;</h1>
							<h:form>
								<div id="TEXT">

									<h:panelGrid columns="3">
										<p>
											<a href="funcionarioaudio.jsf"><img
												src="images/audio.png" alt="" /></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="funcionariovideo.jsf"><img
												src="images/video.png" alt="" /></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="funcionarioimpresso.jsf"><img
												src="images/impresso.png" alt="" /></a>
										</p>
										<p>
											&nbsp;&nbsp;<a href="funcionarioaudio.jsf"><span
												class="style3">Áudio<span class="style4"></span></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
												href="funcionariovideo.jsf"> <span class="style6">Vídeo</span>
											</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
												href="funcionarioimpresso.jsf"><span class="style7">Impresso</span></a>
										</p>

									</h:panelGrid>



								</div>

							</h:form>




						</div>
						<div class="clear mozclear"></div>
					</div>
				</div>
				<div class="right" id="nsFooterClear">
					<!-- for NS4's sake -->
				</div>
				<div id="FOOTER" class="gap">
					<p align="right">
						<a href="contromidia.jsf" class="style1"> Sair/Log Out</a>
					</p>
				</div>
			</div>
		</div>


	</f:view>
</body>
</html>