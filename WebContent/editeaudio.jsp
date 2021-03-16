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
				<a href="boss.jsf">Voltar </a></div>
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
    <h1>&nbsp;</h1>


<h:form>
<div id="TEXT">
             
<h:panelGrid columns="2">

<h:outputText value="Arquivo: "></h:outputText>
<h:outputText value="#{materiaBean.item.fileName }"></h:outputText>
<h:outputText value="Tamanho: "></h:outputText>
<h:outputText value="#{materiaBean.item.fileSize }"></h:outputText>
<h:outputText value="Tipo: "></h:outputText>
<h:outputText value="#{materiaBean.item.contentType }"></h:outputText>

<h:commandButton id="trocarMateria" value="Trocar Arquivo" action="#{materiaBean.trocar }" > </h:commandButton>

</h:panelGrid>
<h:commandButton id="trocarVeiculo" value="Trocar Veiculo" action="#{materiaBean.editarVeiculo }" > </h:commandButton>
<a4j:loadScript src="Scripts/jquery.maskedinput.js">
<h:panelGrid columns="2">

<h:outputText value="Veiculo"></h:outputText>

<h:selectOneMenu id="Veiculo"
         value="#{materiaBean.materiaEdit.veiculo }">
        <f:selectItem
    itemValue="Audio" itemLabel="Audio"/>
	
       
         </h:selectOneMenu> 

<h:outputText value="Apresentador"></h:outputText>

<h:inputText id="apresentador" value="#{materiaBean.materiaEdit.apresentador }"></h:inputText>


<h:outputText value="Assunto"></h:outputText>

<h:inputText id="assunto" value="#{materiaBean.materiaEdit.assunto }"></h:inputText>


<h:outputText value="Critica"></h:outputText>

<h:selectOneMenu id="critica"
         value="#{materiaBean.materiaEdit.critica }">
        <f:selectItem
    itemValue="positiva" itemLabel="Positiva"/>
        <f:selectItem 
    itemValue="negativa" itemLabel="Negativa"/>
        <f:selectItem 
    itemValue="neutra" itemLabel="Neutra"/>
    
         </h:selectOneMenu>      


<h:outputText value="Nome do programa"></h:outputText>

<h:inputText id="nomeDoPrograma" value="#{materiaBean.materiaEdit.nomePrograma }"></h:inputText>

<h:outputText value="Hora"></h:outputText>

<h:inputText id="hora" value="#{materiaBean.materiaEdit.hora }">
<rich:jQuery selector="#hora" query="mask('99:99')" timing="onload"/>
</h:inputText>

<h:outputText value="Data da materia"></h:outputText>

<rich:calendar popup="true" datePattern="dd/MM/yyyy" requiredMessage="Por favor selecione uma data"
	required="true" value="#{materiaBean.materiaEdit.data}">
	
	</rich:calendar>



</h:panelGrid>
</a4j:loadScript>
<br/>

<h:commandButton id="salvarMateria" value="Editar Materia" action="#{materiaBean.salvarEdit}" > </h:commandButton>


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


			  </div>
			  <div class="clear mozclear"></div>
			</div>
	  </div>
		<div class="hide" id="nsFooterClear"><!-- for NS4's sake --></div>
		<div id="FOOTER" class="gap">
         <p align="right"> <a href="contromidia.jsf" class="style1"> Sair/Log Out</a> </p>  </div>
   </div>
	</div>

</f:view>
</body>
</html>