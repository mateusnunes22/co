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
						<img src="images/lOGOMARCA.JPG" alt="" width="240" height="146" />
					</div>
					<div id="heading">
						<div class="head"></div>
						<div class="top">
							<a href="#"> </a>
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
									<div id="TEXT">


										<h:panelGrid columns="2">


										</h:panelGrid>

										<br />


										<rich:messages layout="table" infoLabelClass="messageInfo"
											errorLabelClass="messageError">

											<f:facet name="infoMarker">
												<h:graphicImage value="images/sucess.png" />
											</f:facet>

											<f:facet name="errorMarker">
												<h:graphicImage value="images/error.png" />
											</f:facet>

										</rich:messages>


										<h:outputText value="Periodo:" />
										<h:panelGrid columns="4">

											<h:outputText value="inicial: "></h:outputText>

											<rich:calendar id="datin" popup="true"
												datePattern="dd/MM/yyyy" value="#{materiaBean.dataInicial}">
											</rich:calendar>

											<h:outputText value="final: "></h:outputText>

											<rich:calendar id="datfi" popup="true"
												datePattern="dd/MM/yyyy" value="#{materiaBean.dataFinal}">
											</rich:calendar>
										</h:panelGrid>

										<h:panelGrid columns="2">

											<h:outputText value="Veiculo:"></h:outputText>

											<h:selectOneRadio id="veicul"
												value="#{materiaBean.materiaBusca.veiculo}">
												<f:selectItem itemLabel="Todos" itemValue="" />
												<f:selectItem itemLabel="Audio" itemValue="Audio" />
												<f:selectItem itemLabel="Impresso" itemValue="Impresso" />
												<f:selectItem itemLabel="Video" itemValue="Video" />
											</h:selectOneRadio>

										</h:panelGrid>

										<h:panelGrid columns="4">

											<h:outputText value="Buscar por:"></h:outputText>

											<h:selectOneMenu id="buscaProperty"
												value="#{materiaBean.materiaBusca.extensao}">

												<f:selectItem itemValue="apresentador"
													itemLabel="Apresentador" />
												<f:selectItem itemValue="assunto"
													itemLabel="Tema da Materia" />

											</h:selectOneMenu>

											<h:inputText id="busca"
												value="#{materiaBean.materiaBusca.assunto }" size="32"></h:inputText>
											<h:commandButton id="atualizar" value="Atualizar"
												image="images/search.png" action="#{materiaBean.atualizar }"></h:commandButton>
										</h:panelGrid>



										<br /> <br />

										<h:outputText value="#{materiaBean.tabelaVazia }"></h:outputText>

										<rich:dataTable id="clientee"
											onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
											onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
											width="540" border="2"
											value="#{materiaBean.hasMateriaForgId}" var="d"
											rendered="#{not empty materiaBean.hasMateriaForgId}"
											rows="15" binding="#{materiaBean.objTabelaMateria }">

											<f:facet name="header">
												<rich:columnGroup>
													<rich:column colspan="5">
														<h:outputText value="Listas de Materias" />
													</rich:column>
													<rich:column breakBefore="true">
														<h:outputText value="Tema da Materia" />
													</rich:column>
													<rich:column>
														<h:outputText value="Data" />
													</rich:column>
													<rich:column>
														<h:outputText value="Apresentador" />
													</rich:column>
													<rich:column>
														<h:outputText value="Veiculo" />
													</rich:column>
													<rich:column>
														<h:outputText value="Materia Inteira" />
													</rich:column>
												</rich:columnGroup>
											</f:facet>


											<h:column>
												<h:outputText value="#{d.assunto}" />
											</h:column>
											<h:column>
												<h:outputText value="#{d.data}">
													<f:convertDateTime pattern="dd/MM/yyyy" />
												</h:outputText>
											</h:column>
											<h:column>
												<h:outputText value="#{d.apresentador}" />
											</h:column>
											<h:column>
												<h:outputText value="#{d.veiculo}" />
											</h:column>
											<h:column>
												<h:commandButton action="#{materiaBean.editar}"
													image="images/plus.png" />
											</h:column>



										</rich:dataTable>

										<rich:datascroller id="sc2" for="clientee"
											renderIfSinglePage="false" />



									</div>



									<br />

								</div>
							</h:form>
							<div class="clear mozclear"></div>
						</div>
					</div>
					<div class="hide" id="nsFooterClear">
						<!-- for NS4's sake -->
					</div>
					<div id="FOOTER" class="gap">
						<p align="right">
							<a href="contromidia.jsf" class="style1"> Sair/Log Out</a>
						</p>
					</div>
				</div>

			</div>

		</div>

	</f:view>
</body>
</html>