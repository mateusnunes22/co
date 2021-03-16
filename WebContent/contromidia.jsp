<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Contro Midia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="style.css" type="text/css" />
<style type="text/css">
</style>
</head>
<body>
<f:view>

<div id="bodyWrap">
	<div class="pageWrapper">
		<div id="header">
			<div id="logo">
				<h1>Logo &trade;</h1>
			    <img src="images/lOGOMARCA.JPG" alt="" width="240" height="146" /></div>
<div id="heading">
				<div class="head"></div>
<div class="top">
				<a href="empresa.jsf">Sobre a Empresa </a></div>
	      e</div>
		</div>
	</div>
<div class="pageWrapper" id="main">
  <div class="gap">		</div>
  <div class="gap">		</div>

<div id="mainOuter">
			<div id="mainInner">
			  <div class="right">				</div>
  <div class="content">
					<div class="titleMain"></div>
					<h1>&nbsp;</h1>


<h:form>
<div id="TEXT">
             
             <h:panelGrid columns="2">
             
             <h:outputText value="Usuário :"></h:outputText>
             <h:inputText id="email" value="#{usuarioBean.usuario.nomeUsuario}" size="20" ></h:inputText>
             
             <h:outputText value="Senha :"></h:outputText>
             <h:inputSecret redisplay="false" value="#{usuarioBean.usuario.senha}" size="20"></h:inputSecret>
            </h:panelGrid>
            
            <h:commandButton value="Logar" action="#{usuarioBean.logar}"></h:commandButton>
           
            
            <rich:messages layout="table" infoLabelClass="messageInfo" errorLabelClass="messageError" >

<f:facet name="infoMarker">
<h:graphicImage value="images/sucess.png"/>
</f:facet>

<f:facet name="errorMarker">
<h:graphicImage value="images/error.png"/>
</f:facet>
         </rich:messages>
             </div>
             </h:form>
             <br />


<div class="product"></div>
				    <form id="form1" method="post" action="">
			        <p>&nbsp;</p>
			        <p>&nbsp;</p>
			      </form>
				  <p>&nbsp;</p>
			  </div>
			  <div class="clear mozclear"></div>
			</div>
	  </div>
		<div class="hide" id="nsFooterClear"><!-- for NS4's sake --></div>
		<div id="FOOTER" class="gap">
		</div>
	</div>
</div>

</f:view>
</body>
</html>