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
				<a href="arquivo.jsf">Voltar </a></div>
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

<rich:fileUpload id="upload"  maxFilesQuantity="1" required="true" immediateUpload="true" 
requiredMessage="Selecione um arquivo" listHeight="80"  listWidth="500"
fileUploadListener="#{materiaBean.fileUploadListener }"/> 

<h:panelGrid columns="2">

<h:outputText value="Veiculo"></h:outputText>

<h:selectOneMenu id="Veiculo"
         value="#{materiaBean.materia.veiculo }">
        <f:selectItem 
    itemValue="Impresso" itemLabel="Impresso"/>
  
         </h:selectOneMenu> 


<h:outputText value="Nome do jornal"></h:outputText>

<h:selectOneMenu id="assunto" value="#{materiaBean.materia.assunto }"> 
   	<f:selectItems value="#{graficoBean.impresso }"/> </h:selectOneMenu>


<h:outputText value="Indice"></h:outputText>

<h:inputTextarea id="indice" value="#{materiaBean.materia.indice }" rows="5"></h:inputTextarea>


<h:outputText value="Data da materia"></h:outputText>

<rich:calendar popup="true" datePattern="dd/MM/yyyy" requiredMessage="Por favor selecione uma data"
	required="true" value="#{materiaBean.materia.data}">
	
	</rich:calendar>



</h:panelGrid>

<br/>

<h:commandButton id="salvarMateria" value="Salvar Materia" action="#{materiaBean.salvar }" > </h:commandButton>


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