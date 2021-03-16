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
<title>Contro Midia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="style.css" type="text/css" />
<style type="text/css">
</style>
</head>
<body>
<f:view>
<h:form>
<div id="bodyWrap">
	<div class="pageWrapper">
		<div id="header">
			<div id="logo">
				<h1>Logo &trade;</h1>
			    <img src="images/lOGOMARCA.JPG" alt="" width="240" height="145" /></div>
<div id="heading">
				<div class="head"></div>
<div class="top">
				<a href="cadastrousuario.jsf"> Cadastrar usu�rio</a><a href="boss.jsf">busca mat�ria</a><a href="arquivo.jsf">Cadastrar Mat�ria</a></div>
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
<div id="CONTENT">
<div class="style3" id="TEXT">



<rich:dataTable 
	id="Desbloquearr"  
	onRowMouseOver="this.style.backgroundColor='#F1F1F1'"  
	onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
	width="540" border="2" 
	value="#{materiaBean.solicitacaoVideo}" var="d"   rendered="#{not empty materiaBean.solicitacaoVideo}"
	rows="10" binding="#{materiaBean.objTabelaMateria2 }" >
   			  			
	<f:facet name="header">
        <rich:columnGroup>
    	    <rich:column colspan="6">
        	<h:outputText value="Lista de videos solicitados pelo usuario" />
      		</rich:column >
            <rich:column breakBefore="true">
                <h:outputText value="Empresa"/>
            </rich:column>
            <rich:column >
                <h:outputText value="Setor"/>
            </rich:column>
            <rich:column >
                <h:outputText value="Tema da Materia"/>
            </rich:column>
            <rich:column >
                <h:outputText value="Data"/>
            </rich:column>
            <rich:column >
                <h:outputText value="Veiculo"/>
            </rich:column>
            <rich:column >
                <h:outputText value="Video Adicionado"/>
            </rich:column>
             </rich:columnGroup>
    </f:facet>
   

   <h:column>
        <h:outputText value="#{d.usuario.cliente.nomeUsuario}"/>  
   </h:column>
   <h:column>
        <h:outputText value="#{d.usuario.nomeUsuario}"/>  
   </h:column>
   <h:column>
        <h:outputText value="#{d.materia.assunto}"/>  
   </h:column>
    <h:column>
        <h:outputText value="#{d.materia.data}">
        <f:convertDateTime pattern="dd/MM/yyyy"/>
        </h:outputText>  
   </h:column>
    <h:column>
        <h:outputText value="#{d.materia.veiculo}"/>  
   </h:column>
    <h:column>
           <h:commandButton action="#{materiaBean.salvarHasMateriaSolicitacaoOk}" image="images/ok.png"/> 
   </h:column>
   <f:facet name="fooooter">
                <rich:datascroller id="dsss" renderIfSinglePage="true"></rich:datascroller>
            </f:facet>
   
   
</rich:dataTable>

<rich:messages layout="table" infoLabelClass="messageInfo" errorLabelClass="messageError" >

<f:facet name="infoMarker">
<h:graphicImage value="images/sucess.png"/>
</f:facet>

<f:facet name="errorMarker">
<h:graphicImage value="images/error.png"/>
</f:facet>

         </rich:messages>

</div>
</div>

			  <div class="clear mozclear"></div>
			</div>
	  </div>
		<div class="hide" id="nsFooterClear"><!-- for NS4's sake --></div>
		<div id="FOOTER" class="gap">
        <p align="right"> <a href="contromidia.jsf" class="style1"> Sair/Log Out</a> </p>  </div>
   </div>
	</div>
</div>

</h:form>
</f:view>
</body>
</html>