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


									<h:inputHidden id="atualizarPagina"
										value="#{usuarioBean.atualizarPagina }"></h:inputHidden>

									<rich:messages layout="table" infoLabelClass="messageInfo"
										errorLabelClass="messageError">

										<f:facet name="infoMarker">
											<h:graphicImage value="images/sucess.png" />
										</f:facet>

										<f:facet name="errorMarker">
											<h:graphicImage value="images/error.png" />
										</f:facet>

									</rich:messages>

									<h:panelGrid columns="3">
										<h:outputText value="Numero de solicitações de video:" />
										<h:outputText value="#{usuarioBean.solicitacoes }" />
										<p>
											<a href="clientesolicitacao.jsf"><img
												src="images/solicitacao.png" alt="" /></a>
										</p>
										<h:commandLink action="#{graficoBean.getAlimentacao2 }"> 
				Análise	</h:commandLink>
									</h:panelGrid>

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
											<f:selectItem itemValue="assunto" itemLabel="Tema da Materia" />

										</h:selectOneMenu>

										<h:inputText id="busca"
											value="#{materiaBean.materiaBusca.assunto }" size="32"></h:inputText>

										<h:commandButton id="atualizar" value="Atualizar"
											image="images/search.png" action="#{materiaBean.atualizar }"></h:commandButton>

									</h:panelGrid>



									<br /> <br />


									<rich:dataTable id="Liberarr"
										onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
										onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
										width="540" border="2" value="#{materiaBean.lista}" var="d"
										rendered="#{not empty materiaBean.lista}" rows="8"
										binding="#{materiaBean.objTabelaMateria }">

										<f:facet name="header">
											<rich:columnGroup>
												<rich:column colspan="8">
													<h:outputText value="Listas de todas as materias" />
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
													<h:outputText value="Verificar" />
												</rich:column>
												<rich:column>
													<h:outputText value="Download" />
												</rich:column>
												<rich:column>
													<h:outputText value="Liberar" />
												</rich:column>
												<rich:column>
													<h:outputText value="Deletar" />
												</rich:column>
											</rich:columnGroup>
										</f:facet>


										<rich:column>
											<h:outputText value="#{d.assunto}" />
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.data}">
												<f:convertDateTime pattern="dd/MM/yyyy" />
											</h:outputText>
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.apresentador}" />
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.veiculo}" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.editar}"
												image="images/edit.png" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.fileDownload}"
												image="images/download.png" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.irParaLiberar}"
												image="images/unlock.png" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.deletar}"
												image="images/delete.png" />
										</rich:column>

										<f:facet name="footer">
											<rich:datascroller id="ds" for="Liberarr"
												renderIfSinglePage="false"></rich:datascroller>
										</f:facet>

									</rich:dataTable>

									<h:outputText value="#{materiaBean.tabelaVazia }"></h:outputText>


									<br /> <br />


									<h:panelGrid columns="2">



										<h:outputText value="Setor:"></h:outputText>

										<h:selectOneMenu id="numeroUsuario" onchange="submit()"
											valueChangeListener="#{materiaBean.countryLocaleCodeChanged}"
											value="#{materiaBean.usuario.idUsuario }">
											<f:selectItems value="#{materiaBean.usuarioNome }" />
										</h:selectOneMenu>

									</h:panelGrid>

									<h:outputText value="Periodo:" />
									<h:panelGrid columns="4">

										<h:outputText value="inicial: "></h:outputText>

										<rich:calendar id="datin2" popup="true"
											datePattern="dd/MM/yyyy" value="#{materiaBean.dataInicial2}">
										</rich:calendar>

										<h:outputText value="final: "></h:outputText>

										<rich:calendar id="datfi2" popup="true"
											datePattern="dd/MM/yyyy" value="#{materiaBean.dataFinal2}">
										</rich:calendar>
									</h:panelGrid>

									<h:panelGrid columns="2">

										<h:outputText value="Veiculo:"></h:outputText>

										<h:selectOneRadio id="veicul2"
											value="#{materiaBean.materiaBusca2.veiculo}">
											<f:selectItem itemLabel="Todos" itemValue="" />
											<f:selectItem itemLabel="Audio" itemValue="Audio" />
											<f:selectItem itemLabel="Impresso" itemValue="Impresso" />
											<f:selectItem itemLabel="Video" itemValue="Video" />
										</h:selectOneRadio>

									</h:panelGrid>

									<h:panelGrid columns="4">

										<h:outputText value="Buscar por:"></h:outputText>

										<h:selectOneMenu id="buscaProperty2"
											value="#{materiaBean.materiaBusca2.extensao}">
											<f:selectItem itemValue="apresentador"
												itemLabel="Apresentador" />
											<f:selectItem itemValue="assunto" itemLabel="Tema da Materia" />

										</h:selectOneMenu>

										<h:inputText id="busca2"
											value="#{materiaBean.materiaBusca2.assunto }" size="32"></h:inputText>

										<h:commandButton id="atualizar2" value="Atualizar"
											image="images/search.png" action="#{materiaBean.atualizar }"></h:commandButton>

									</h:panelGrid>






									<br /> <br />



									<rich:dataTable id="Desbloquearr"
										onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
										onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
										width="540" border="2"
										value="#{materiaBean.hasMateriaForgIdBoss}" var="d"
										rendered="#{not empty materiaBean.hasMateriaForgIdBoss}"
										rows="8" binding="#{materiaBean.objTabelaMateria2 }">

										<f:facet name="header">
											<rich:columnGroup>
												<rich:column colspan="8">
													<h:outputText value="Listas de materias do usuario" />
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
													<h:outputText value="Desbloquear" />
												</rich:column>
												<rich:column>
													<h:outputText value="Bloquear" />
												</rich:column>
												<rich:column>
													<h:outputText value="Estatus" />
												</rich:column>
											</rich:columnGroup>
										</f:facet>


										<rich:column>
											<h:outputText value="#{d.materia.assunto}" />
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.materia.data}">
												<f:convertDateTime pattern="dd/MM/yyyy" />
											</h:outputText>
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.materia.apresentador}" />
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.materia.veiculo}" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.salvarHasMateriaDes}"
												image="images/unlock.png" />
										</rich:column>
										<rich:column>
											<h:commandButton action="#{materiaBean.salvarHasMateriaBlo}"
												image="images/lock.png" />
										</rich:column>
										<rich:column>
											<h:outputText value="#{d.estatus}" />
										</rich:column>
										<f:facet name="footer">
											<rich:datascroller id="dss" for="Desbloquearr"
												renderIfSinglePage="false"></rich:datascroller>
										</f:facet>


									</rich:dataTable>

									<h:outputText value="#{materiaBean.tabelaVazia2 } "></h:outputText>


								</div>



								<br />

							</h:form>

						</div>
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

	</f:view>
</body>
</html>