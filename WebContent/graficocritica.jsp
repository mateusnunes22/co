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
<title>Insert title here</title>
</head>
<body onload="inicio()" >
<f:view>


<div id="CONTENT">
	
<div id="TEXT">


	<a4j:form id="orderModalFormId">

	
	<h:form prependId="false">
	
	<a4j:jsFunction name="inicio" action="#{graficoBean.graficoCritica }" ></a4j:jsFunction>
	
	<h:inputHidden id="positivaV1" value="#{graficoBean.positivaV1}"></h:inputHidden>
	<h:inputHidden id="negativaV1" value="#{graficoBean.negativaV1 }"></h:inputHidden>
	<h:inputHidden id="neutraV1" value="#{graficoBean.neutraV1 }"></h:inputHidden>
	<h:inputHidden id="positivaV2" value="#{graficoBean.positivaV2}"></h:inputHidden>
	<h:inputHidden id="negativaV2" value="#{graficoBean.negativaV2 }"></h:inputHidden>
	<h:inputHidden id="neutraV2" value="#{graficoBean.neutraV2 }"></h:inputHidden>
	<h:inputHidden id="positivaV3" value="#{graficoBean.positivaV3}"></h:inputHidden>
	<h:inputHidden id="negativaV3" value="#{graficoBean.negativaV3 }"></h:inputHidden>
	<h:inputHidden id="neutraV3" value="#{graficoBean.neutraV3 }"></h:inputHidden>
	<h:inputHidden id="positivaV4" value="#{graficoBean.positivaV4}"></h:inputHidden>
	<h:inputHidden id="negativaV4" value="#{graficoBean.negativaV4 }"></h:inputHidden>
	<h:inputHidden id="neutraV4" value="#{graficoBean.neutraV4 }"></h:inputHidden>
	<h:inputHidden id="positivaV5" value="#{graficoBean.positivaV5}"></h:inputHidden>
	<h:inputHidden id="negativaV5" value="#{graficoBean.negativaV5 }"></h:inputHidden>
	<h:inputHidden id="neutraV5" value="#{graficoBean.neutraV5 }"></h:inputHidden>
	<h:inputHidden id="positivaV6" value="#{graficoBean.positivaV6}"></h:inputHidden>
	<h:inputHidden id="negativaV6" value="#{graficoBean.negativaV6 }"></h:inputHidden>
	<h:inputHidden id="neutraV6" value="#{graficoBean.neutraV6 }"></h:inputHidden>
	<h:inputHidden id="positivaV7" value="#{graficoBean.positivaV7}"></h:inputHidden>
	<h:inputHidden id="negativaV7" value="#{graficoBean.negativaV7 }"></h:inputHidden>
	<h:inputHidden id="neutraV7" value="#{graficoBean.neutraV7 }"></h:inputHidden>
	
	<a4j:commandButton value="Atualizar Gráfico" action="#{graficoBean.graficoCritica}"></a4j:commandButton>
	<h:commandButton id="grafico" value="Gerar Grafico" action="#{graficoBean.getGraficoCritica}"></h:commandButton>
	
	
<div id="chart_div">
<div id="codigo_grafico">
		  
		  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script src="Scripts/jquery-1.7.1.js"></script>
    <script type="text/javascript">
    
    
    
    $(document).ready(function(){
	  
    	
	  //ajax para carregar os dados no grafico
	  //$('#codigo_grafico').load('ajax/grafico.php');
	 google.setOnLoadCallback(drawChart);
				
    });
     
     	google.load("visualization", "1", {packages:["corechart"]});
        function drawChart() {
		        var data = new google.visualization.DataTable();
		        var positiva = "POSITIVA";
		        var negativa = "NEGATIVA";
		        var neutra = "NEUTRA";
		        
		        var positivaV1 =  parseFloat(jQuery("#orderModalFormId\\:positivaV1").val());
		        var negativaV1 =  parseFloat(jQuery("#orderModalFormId\\:negativaV1").val());
		        var neutraV1 =  parseFloat(jQuery("#orderModalFormId\\:neutraV1").val());
		        var positivaV2 =  parseFloat(jQuery("#orderModalFormId\\:positivaV2").val());
		        var negativaV2 =  parseFloat(jQuery("#orderModalFormId\\:negativaV2").val());
		        var neutraV2 =  parseFloat(jQuery("#orderModalFormId\\:neutraV2").val());
		        var positivaV3 =  parseFloat(jQuery("#orderModalFormId\\:positivaV3").val());
		        var negativaV3 =  parseFloat(jQuery("#orderModalFormId\\:negativaV3").val());
		        var neutraV3 =  parseFloat(jQuery("#orderModalFormId\\:neutraV3").val());
		        var positivaV4 =  parseFloat(jQuery("#orderModalFormId\\:positivaV4").val());
		        var negativaV4 =  parseFloat(jQuery("#orderModalFormId\\:negativaV4").val());
		        var neutraV4 =  parseFloat(jQuery("#orderModalFormId\\:neutraV4").val());
		        var positivaV5 =  parseFloat(jQuery("#orderModalFormId\\:positivaV5").val());
		        var negativaV5 =  parseFloat(jQuery("#orderModalFormId\\:negativaV5").val());
		        var neutraV5 =  parseFloat(jQuery("#orderModalFormId\\:neutraV5").val());
		        var positivaV6 =  parseFloat(jQuery("#orderModalFormId\\:positivaV6").val());
		        var negativaV6 =  parseFloat(jQuery("#orderModalFormId\\:negativaV6").val());
		        var neutraV6 =  parseFloat(jQuery("#orderModalFormId\\:neutraV6").val());
		        var positivaV7 =  parseFloat(jQuery("#orderModalFormId\\:positivaV7").val());
		        var negativaV7 =  parseFloat(jQuery("#orderModalFormId\\:negativaV7").val());
		        var neutraV7 =  parseFloat(jQuery("#orderModalFormId\\:neutraV7").val());
		        
		        
				
		        
		        
		        data.addColumn('string', 'Legenda');
		        
		        data.addColumn('number', positiva);
		        data.addColumn('number', negativa);
		        data.addColumn('number', neutra);
		        
		        
		        data.addRows([
		         
		          ['01', positivaV1, negativaV1, neutraV1], ['02', positivaV2, negativaV2, neutraV2],
		          ['03', positivaV3, negativaV3, neutraV3], ['04', positivaV4, negativaV4, neutraV4],
		          ['05', positivaV5, negativaV5, neutraV5], ['06', positivaV6, negativaV6, neutraV6],
		          ['07', positivaV7, negativaV7, neutraV7]
		        ]);
		
		        var options = {
		          width: 900, height: 500,
		          title: 'Critica',
		          hAxis: {title: 'Legenda', titleTextStyle: {color: 'BLACK'}}
		          
		        };
		
		        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
		        chart.draw(data, options);
      	}
      
    </script>
    
    </div>
    </div>
		  
		  <h:panelGrid columns="12">
		  
		  <h:outputText value="01-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome1 }"></h:outputText>
		  <h:outputText value="02-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome2 }"></h:outputText>
		  <h:outputText value="03-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome3 }"></h:outputText>
		  <h:outputText value="04-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome4 }"></h:outputText>
		  <h:outputText value="05-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome5 }"></h:outputText>
		  <h:outputText value="06-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome6 }"></h:outputText>
		  <h:outputText value="07-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome7 }"></h:outputText>
		  <h:outputText value="08-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome8 }"></h:outputText>
		  <h:outputText value="09-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome9 }"></h:outputText>
		  <h:outputText value="10-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome10 }"></h:outputText>
		  <h:outputText value="11-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome11 }"></h:outputText>
		  <h:outputText value="12-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome12 }"></h:outputText>
		  <h:outputText value="13-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome13 }"></h:outputText>
		  <h:outputText value="14-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome14 }"></h:outputText>
		  <h:outputText value="15-"></h:outputText>
		  <h:outputText value="#{graficoBean.nome15 }"></h:outputText>
		  
		  </h:panelGrid>
		  
    </h:form>
    
    </a4j:form>
    
	<p>&nbsp;</p>
        <p>&nbsp;</p>
   
</div>
</div>

<div id="FOOTER">
<p>   Desenvolvedores:</p>
<p>  Andre Lara, kenzo Takeshita,</p>
<p>  Raphael Gregg e Renan Mello.  </p>
</div>
</f:view>
</body>
</html>