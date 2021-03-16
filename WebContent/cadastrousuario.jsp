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
.style1 {
	font-size: 12px
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
			    <img src="images/lOGOMARCA.JPG" alt="" width="240" height="146" /></div>
<div id="heading">
				<div class="head"></div>
<div class="top">
				<a href="cadastrocliente.jsf"> Cadastrar empresa</a><a href="boss.jsf">busca matéria</a><a href="arquivo.jsf">Cadastrar Matéria</a></div>
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

         
         <h:outputText value="Nome de usuário :"></h:outputText>
         <h:inputText id="nomeUsuario" value="#{usuarioBean.usuario.nomeUsuario }" size="20"></h:inputText>
         
         <h:outputText value="Email :"></h:outputText>
         <h:inputText id="email" value="#{usuarioBean.usuario.email }" size="20"></h:inputText>
         
         
         <h:outputText value="Perfil :" />
        <h:selectOneMenu id="perfil"
         value="#{usuarioBean.usuario.perfil }">
        <f:selectItem
    itemValue="funcionari" itemLabel="Funcionario"/>
        <f:selectItem 
    itemValue="cliente" itemLabel="Setor"/>
        
         </h:selectOneMenu>         
         
         <h:outputText value="Empresa :"></h:outputText>
         <h:selectOneMenu id="numeroUsuario" value="#{usuarioBean.usuario.cliente.idCliente }"> 
   	<f:selectItems value="#{clienteBean.clienteNome }"/> </h:selectOneMenu>
         
         <h:outputText value="Senha :"></h:outputText>
         <h:inputText id="senha" value="#{usuarioBean.usuario.senha }" size="20"></h:inputText>
          
       

</h:panelGrid>

<br/>

<h:commandButton id="salvarMateria" value="Salvar Usuario" action="#{usuarioBean.salvar }" > </h:commandButton>


<rich:messages layout="table" infoLabelClass="messageInfo" errorLabelClass="messageError" >

<f:facet name="infoMarker">
<h:graphicImage value="images/sucess.png"/>
</f:facet>

<f:facet name="errorMarker">
<h:graphicImage value="images/error.png"/>
</f:facet>

         </rich:messages>

<br/>
<br/>

<h:panelGrid columns="2">


</h:panelGrid>

<rich:dataTable 
	id="ListaUsuario"  
	onRowMouseOver="this.style.backgroundColor='#F1F1F1'"  
	onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" 
	width="540" border="2" 
	value="#{usuarioBean.lista }" var="u"  
	rows="8"  >
   			  			
	<f:facet name="header">
        <rich:columnGroup>
    	    <rich:column colspan="3">
        	<h:outputText value="Listas de Usuarios"/>
      		</rich:column >
            <rich:column breakBefore="true">
                <h:outputText value="Setor"/>
            </rich:column>
             <rich:column >
                <h:outputText value="Senha"/>
            </rich:column>
             </rich:columnGroup>
    </f:facet>
    

    <rich:column >
    	<h:outputText value="#{u.nomeUsuario}"></h:outputText>
    </rich:column>
    <rich:column >
    	<h:outputText value="#{u.senha}"></h:outputText>
    </rich:column>
    
    <f:facet name="footer">
                <rich:datascroller id="ds" for="ListaUsuario"  renderIfSinglePage="false"></rich:datascroller>
            </f:facet>
</rich:dataTable>



</div>

             
           
             <br />

</h:form>

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