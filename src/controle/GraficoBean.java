package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import javax.faces.model.SelectItem;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import entidade.Materia;
import entidade.Usuario;
import entidade.UsuarioHasMateria;


public class GraficoBean {


public List<SelectItem> listaCombobox =  new ArrayList<SelectItem>();


String alimentacao;

private String nome1;
private String nome2;
private String nome3;
private String nome4;
private String nome5;
private String nome6;
private String nome7;
private String nome8;
private String nome9;
private String nome10;
private String nome11;
private String nome12;
private String nome13;
private String nome14;
private String nome15;
private String positivaV1;
private String negativaV1;
private String neutraV1;
private String positivaV2;
private String negativaV2;
private String neutraV2;
private String positivaV3;
private String negativaV3;
private String neutraV3;
private String positivaV4;
private String negativaV4;
private String neutraV4;
private String positivaV5;
private String negativaV5;
private String neutraV5;
private String positivaV6;
private String negativaV6;
private String neutraV6;
private String positivaV7;
private String negativaV7;
private String neutraV7;
private String positivaV8;
private String negativaV8;
private String neutraV8;
private String positivaV9;
private String negativaV9;
private String neutraV9;
private String positivaV10;
private String negativaV10;
private String neutraV10;
private String positivaV11;
private String negativaV11;
private String neutraV11;
private String positivaV12;
private String negativaV12;
private String neutraV12;
private String positivaV13;
private String negativaV13;
private String neutraV13;
private String positivaV14;
private String negativaV14;
private String neutraV14;
private String positivaV15;
private String negativaV15;
private String neutraV15;

public String getGraficoCritica(){
	
alimentacao ="0";

	int pos=0,neg=0,neu=0;

	System.out.println(111111);
	System.out.println(22222222);
	System.out.println("AAAAAAAAAABBBBBBBBBCCCCCCCCCC");
	
	Calendar c = Calendar.getInstance();
	
	c.set(2013, 0, 1);
	
	Date dataInicial = c.getTime();
	
	c.add(Calendar.YEAR, 1);
	
	Date dataFinal = c.getTime();
	
	
	Session session = HibernateUtil.getSession();
	
	List<Materia> critica = new ArrayList<Materia>();
	Criteria materia = session.createCriteria(Materia.class);
	materia.add(Restrictions.between("data", dataInicial, dataFinal));
	
	critica = materia.list();
	
	for(int w=0;w<critica.size();w++)
	{
		
		String temp="";
		
		temp = critica.get(w).getCritica();
		
		
		if(temp.equalsIgnoreCase("positiva"))
		{
			pos++;
		}
		else if(temp.equalsIgnoreCase("negativa"))
		{
			neg++;
		}
		else if(temp.equalsIgnoreCase("neutra"))
		{
			neu++;
		}
		
	}
	
	this.positivaV1 = String.valueOf(pos);
	
	this.negativaV1 = String.valueOf(neg);
	
	this.neutraV1 = String.valueOf(neu);
	
	
	return null;
}

public String getAlimentacao2(){
	
alimentacao ="0";

	int pos=0,neg=0,neu=0;

	System.out.println(111111);
	System.out.println(22222222);
	System.out.println("AAAAAAAAAABBBBBBBBBCCCCCCCCCC");
	
	Calendar c = Calendar.getInstance();
	
	c.set(2013, 0, 1);
	
	Date dataInicial = c.getTime();
	
	c.add(Calendar.YEAR, 1);
	
	Date dataFinal = c.getTime();
	
	
	Session session = HibernateUtil.getSession();
	
	List<Materia> critica = new ArrayList<Materia>();
	Criteria materia = session.createCriteria(Materia.class);
	materia.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("veiculo", "Audio")));
	materia.addOrder(Order.desc("nomePrograma"));
	
	critica = materia.list();
	
	String nomePrograma=critica.get(0).getNomePrograma(), tempNomePrograma="";
	boolean proximoNomePrograma = false;
	int contadorCriticaValor=1;
	
	for(int w=0;w<critica.size();w++)
	{
		
		tempNomePrograma = critica.get(w).getNomePrograma();
		
		System.out.println(tempNomePrograma);
		
		if(tempNomePrograma.equalsIgnoreCase(nomePrograma))
		{
			
		}
		
		else
		{
			proximoNomePrograma = true;
		}
		
		if(proximoNomePrograma)
		{
			
			if(contadorCriticaValor==1)
			{
				
				this.positivaV1 = String.valueOf(pos);
				
				this.negativaV1 = String.valueOf(neg);
				
				this.neutraV1 = String.valueOf(neu);
				
				this.nome1 = nomePrograma;
				
			}
			else if(contadorCriticaValor==2)
			{
				
				this.positivaV2 = String.valueOf(pos);
				
				this.negativaV2 = String.valueOf(neg);
				
				this.neutraV2 = String.valueOf(neu);

				this.nome2 = nomePrograma;
				
			}
			else if(contadorCriticaValor==3)
			{
				
				this.positivaV3 = String.valueOf(pos);
				
				this.negativaV3 = String.valueOf(neg);
				
				this.neutraV3 = String.valueOf(neu);

				this.nome3 = nomePrograma;
				
			}
			else if(contadorCriticaValor==4)
			{
				
				this.positivaV4 = String.valueOf(pos);
				
				this.negativaV4 = String.valueOf(neg);
				
				this.neutraV4 = String.valueOf(neu);

				this.nome4 = nomePrograma;
				
			}
			else if(contadorCriticaValor==5)
			{
				
				this.positivaV5 = String.valueOf(pos);
				
				this.negativaV5 = String.valueOf(neg);
				
				this.neutraV5 = String.valueOf(neu);

				this.nome5 = nomePrograma;
				
			}
			else if(contadorCriticaValor==6)
			{
				
				this.positivaV6 = String.valueOf(pos);
				
				this.negativaV6 = String.valueOf(neg);
				
				this.neutraV6 = String.valueOf(neu);

				this.nome6 = nomePrograma;
				
			}
			else if(contadorCriticaValor==7)
			{
				
				this.positivaV7 = String.valueOf(pos);
				
				this.negativaV7 = String.valueOf(neg);
				
				this.neutraV7 = String.valueOf(neu);

				this.nome7 = nomePrograma;
				
			}
			else if(contadorCriticaValor==8)
			{
				
				this.positivaV8 = String.valueOf(pos);
				
				this.negativaV8 = String.valueOf(neg);
				
				this.neutraV8 = String.valueOf(neu);

				this.nome8 = nomePrograma;
				
			}
			else if(contadorCriticaValor==9)
			{
				
				this.positivaV9 = String.valueOf(pos);
				
				this.negativaV9 = String.valueOf(neg);
				
				this.neutraV9 = String.valueOf(neu);

				this.nome9 = nomePrograma;
				
			}
			else if(contadorCriticaValor==10)
			{
				
				this.positivaV10 = String.valueOf(pos);
				
				this.negativaV10 = String.valueOf(neg);
				
				this.neutraV10 = String.valueOf(neu);

				this.nome10 = nomePrograma;
				
			}
			else if(contadorCriticaValor==11)
			{
				
				this.positivaV11 = String.valueOf(pos);
				
				this.negativaV11 = String.valueOf(neg);
				
				this.neutraV11 = String.valueOf(neu);

				this.nome11 = nomePrograma;
				
			}
			else if(contadorCriticaValor==12)
			{
				
				this.positivaV12 = String.valueOf(pos);
				
				this.negativaV12 = String.valueOf(neg);
				
				this.neutraV12 = String.valueOf(neu);

				this.nome12 = nomePrograma;
				
			}
			else if(contadorCriticaValor==13)
			{
				
				this.positivaV13 = String.valueOf(pos);
				
				this.negativaV13 = String.valueOf(neg);
				
				this.neutraV13 = String.valueOf(neu);

				this.nome13 = nomePrograma;
				
			}
			else if(contadorCriticaValor==14)
			{
				
				this.positivaV14 = String.valueOf(pos);
				
				this.negativaV14 = String.valueOf(neg);
				
				this.neutraV14 = String.valueOf(neu);

				this.nome14 = nomePrograma;
				
			}
			else if(contadorCriticaValor==15)
			{
				
				this.positivaV15 = String.valueOf(pos);
				
				this.negativaV15 = String.valueOf(neg);
				
				this.neutraV15 = String.valueOf(neu);

				this.nome15 = nomePrograma;
				
			}
			
		}
		
		if(proximoNomePrograma)
		{
			
			nomePrograma = tempNomePrograma;
			proximoNomePrograma = false;
			contadorCriticaValor++;
			pos=0;
			neg=0;
			neu=0;
			
		}
		
		
		String temp="";
		
		temp = critica.get(w).getCritica();
		
		
			if(temp.equalsIgnoreCase("positiva"))
			{
				pos++;
			}
			else if(temp.equalsIgnoreCase("negativa"))
			{
				neg++;
			}
			else if(temp.equalsIgnoreCase("neutra"))
			{
				neu++;
			}
			
			
		
		
	}
	
	
	
	
	return "graf";
}

public List<SelectItem> getRadio(){
    
 
    listaCombobox.clear();
    SelectItem  s2 = new SelectItem();
    s2.setValue("RD ARARA AZUL FM");    
    s2.setLabel("RD ARARA AZUL FM");
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD CBN");    
    s2.setLabel("RD CBN");   
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD CLUBE AM");    
    s2.setLabel("RD CLUBE AM"); 
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("RD CULTURA FM");    
    s2.setLabel("RD CULTURA FM");    
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD GUARANY FM");    
    s2.setLabel("RD GUARANY FM");
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD ITACAIÚNAS AM");    
    s2.setLabel("RD ITACAIÚNAS AM"); 
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("RD LIBERAL FM");    
    s2.setLabel("RD LIBERAL FM");
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD METROPOLITANA FM BELÉM/BARCARENA");    
    s2.setLabel("RD METROPOLITANA FM BELÉM/BARCARENA");  
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD MIX FM 100,9");    
    s2.setLabel("RD MIX FM 100,9");
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("RD O LIBERAL AM - REDE CBN");    
    s2.setLabel("RD O LIBERAL AM - REDE CBN"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD RAULAND FM");    
    s2.setLabel("RD RAULAND FM");  
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD RURAL AM 790 - SANTARÉM");    
    s2.setLabel("RD RURAL AM 790 - SANTARÉM"); 
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("RD SORRISO FM DE SÃO MIGUEL DO GUAMÁ");    
    s2.setLabel("RD SORRISO FM DE SÃO MIGUEL DO GUAMÁ");  
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD SUPER MARAJOARA AM 1130");    
    s2.setLabel("RD SUPER MARAJOARA AM 1130"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD TAPAJÓS 94 FM");    
    s2.setLabel("RD TAPAJÓS 94 FM"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("RD 99 FM");    
    s2.setLabel("RD 99 FM"); 
    listaCombobox.add(s2);
       
      return listaCombobox;  
    
}

public List<SelectItem> getTv(){
    
	 
    listaCombobox.clear();
    SelectItem  s2 = new SelectItem();
    s2.setValue("TV CULTURA");    
   s2.setLabel("TV CULTURA");    
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("TV GLOBO");    
   s2.setLabel("TV GLOBO");    
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV GRÃO PARÁ");    
    s2.setLabel("TV GRÃO PARÁ"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV GUARANY");    
    s2.setLabel("TV GUARANY"); 
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("TV LIBERAL");    
   s2.setLabel("TV LIBERAL");    
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV NAZARÉ");    
    s2.setLabel("TV NAZARÉ"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV RBA");    
    s2.setLabel("TV RBA"); 
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("TV RECORD");    
   s2.setLabel("TV RECORD");    
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV SBT");    
    s2.setLabel("TV SBT"); 
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("TV TAPAJÓS");    
    s2.setLabel("TV TAPAJÓS"); 
    listaCombobox.add(s2);
    
       
      return listaCombobox;  
    
}

public List<SelectItem> getImpresso(){
    
	
	
	
    listaCombobox.clear();
    SelectItem  s2 = new SelectItem();
    s2.setValue("JORNAL AMAZÔNIA");    
   s2.setLabel("JORNAL AMAZÔNIA");    
    listaCombobox.add(s2);
    s2 = new SelectItem();
    s2.setValue("JORNAL DIÁRIO DO PARÁ");    
   s2.setLabel("JORNAL DIÁRIO DO PARÁ");    
    listaCombobox.add(s2);
    s2 = new SelectItem(); 
    s2.setValue("JORNAL O LIBERAL");    
    s2.setLabel("JORNAL O LIBERAL"); 
    listaCombobox.add(s2);
       
      return listaCombobox;  
    
}


/*public String getAlimentacao2(){
	// Cria sessao com o banco
	alimentacao ="0";
	
	System.out.println(1);
	System.out.println(2);
	Calendar c = Calendar.getInstance();
	
	c.set(2013, 0, 1);
	
	Date dataInicial = c.getTime();
	
	c.add(Calendar.YEAR, 1);
	
	Date dataFinal = c.getTime();
	

	HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	Usuario usu = (Usuario) session2.getAttribute("currentUser");
	
	Integer id=usu.getIdUsuario();
	
	Session session = HibernateUtil.getSession();
	
	List<Estilomovimentacao> estiloNome = new ArrayList<Estilomovimentacao>();
	Criteria estiloMovimentacao = session.createCriteria(Estilomovimentacao.class);
	estiloMovimentacao.add(Restrictions.eq("id.usuarioIdUsuario", usu.getIdUsuario()));
	
	Apoio apoio = new Apoio();
	estiloNome = estiloMovimentacao.list();
	List<Relatorio> objeto = new ArrayList<Relatorio>();
	
	
	for(int w=0;w<estiloNome.size();w++)
	{
	Relatorio espelho = new Relatorio();
	String nome="";
	float valor = 0;
	float valorNegativo = 0;
	float saldo = 0;
	
	nome = estiloNome.get(w).getId().getNome();
	
	Criteria bancoEntrada = session.createCriteria(Bancoentrada.class);
	bancoEntrada.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.bancoUsuarioIdUsuario", id)));
	bancoEntrada.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria bancoSaida = session.createCriteria(Bancosaida.class);
	bancoSaida.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.bancoUsuarioIdUsuario", id)));
	bancoSaida.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria caixaEntrada = session.createCriteria(Caixaentrada.class);
	caixaEntrada.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.estiloMovimentacaoUsuarioIdUsuario", id)));
	caixaEntrada.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria caixaSaida = session.createCriteria(Caixasaida.class);
	caixaSaida.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.estiloMovimentacaoUsuarioIdUsuario", id)));
	caixaSaida.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria cartaoEntrada = session.createCriteria(Cartaoentrada.class);
	cartaoEntrada.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.estiloMovimentacaoUsuarioIdUsuario", id)));
	cartaoEntrada.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria cartaoSaida = session.createCriteria(Cartaosaida.class);
	cartaoSaida.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.estiloMovimentacaoUsuarioIdUsuario", id)));
	cartaoSaida.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	Criteria outraMovimentacao = session.createCriteria(Outramovimentacao.class);
	outraMovimentacao.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.eq("id.estiloMovimentacaoUsuarioIdUsuario", id)));
	outraMovimentacao.add(Restrictions.eq("id.estiloMovimentacaoNome", estiloNome.get(w).getId().getNome()));
	
	
	List<Bancoentrada> bancoEValor = bancoEntrada.list();
	List<Bancosaida> bancoSValor = bancoSaida.list();
	List<Caixaentrada> caixaEValor = caixaEntrada.list();
	List<Caixasaida> caixaSValor = caixaSaida.list();
	List<Cartaoentrada> cartaoEValor = cartaoEntrada.list();
	List<Cartaosaida> cartaoSValor = cartaoSaida.list();
	List<Outramovimentacao> outraMValor = outraMovimentacao.list();
	
	
	for(int i=0;i<bancoEValor.size();i++)
	{
	
	Bancoentrada temp = bancoEValor.get(i);
	valor = valor + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<bancoSValor.size();i++)
	{
	
	Bancosaida temp = bancoSValor.get(i);
	valorNegativo = valorNegativo + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<caixaEValor.size();i++)
	{
	
	Caixaentrada temp = caixaEValor.get(i);
	valor = valor + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<caixaSValor.size();i++)
	{
	
	Caixasaida temp = caixaSValor.get(i);
	valorNegativo = valorNegativo + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<cartaoEValor.size();i++)
	{
	
	Cartaoentrada temp = cartaoEValor.get(i);
	valorNegativo = valorNegativo + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<cartaoSValor.size();i++)
	{
	
	Cartaosaida temp = cartaoSValor.get(i);
	valorNegativo = valorNegativo + Float.parseFloat(temp.getValor());

	}
	
	for(int i=0;i<outraMValor.size();i++)
	{
	
	Outramovimentacao temp = outraMValor.get(i);
	valor = valor + Float.parseFloat(temp.getValor());

	}
	
	
	espelho.setNome(nome);
	espelho.setValor(apoio.dinheiroSaida(String.valueOf(valor)));
	espelho.setValorNegativo(apoio.dinheiroSaida(String.valueOf(valorNegativo)));
	float finaltemp = 0;
	finaltemp = valor - valorNegativo;
	espelho.setSaldo(apoio.dinheiroSaida(String.valueOf(finaltemp)));
	
	if(nome.equalsIgnoreCase("Alimentação"))
	{
		this.EstiloM1V = String.valueOf(valorNegativo);
		
	}
	else if(nome.equalsIgnoreCase("Conservação e manutenção"))
	{
		this.EstiloM2V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Doações"))
	{
		this.EstiloM3V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Educação"))
	{
		this.EstiloM4V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Estética"))
	{
		this.EstiloM5V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Higiene"))
	{
		this.EstiloM6V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Lazer"))
	{
		this.EstiloM7V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Limpeza"))
	{
		this.EstiloM8V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Moradia"))
	{
		this.EstiloM9V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Mordomias"))
	{
		this.EstiloM10V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Previdência social"))
	{
		this.EstiloM11V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Saúde"))
	{
		this.EstiloM12V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Serviços domésticos"))
	{
		this.EstiloM13V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Transporte"))
	{
		this.EstiloM14V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Tributos"))
	{
		this.EstiloM15V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Utilidade pública"))
	{
		this.EstiloM16V = String.valueOf(valorNegativo);
	}
	else if(nome.equalsIgnoreCase("Vestuário"))
	{
		this.EstiloM17V = String.valueOf(valorNegativo);
	}
	
	objeto.add(espelho);
	}
	
	System.out.println(3);
	
	System.out.println(4);
	return "analise";

}*/

public List<SelectItem> getListaCombobox() {
	return listaCombobox;
}

public void setListaCombobox(List<SelectItem> listaCombobox) {
	this.listaCombobox = listaCombobox;
}

public String getNome1() {
	return nome1;
}

public void setNome1(String nome1) {
	this.nome1 = nome1;
}

public String getNome2() {
	return nome2;
}

public void setNome2(String nome2) {
	this.nome2 = nome2;
}

public String getNome3() {
	return nome3;
}

public void setNome3(String nome3) {
	this.nome3 = nome3;
}

public String getNome4() {
	return nome4;
}

public void setNome4(String nome4) {
	this.nome4 = nome4;
}

public String getNome5() {
	return nome5;
}

public void setNome5(String nome5) {
	this.nome5 = nome5;
}

public String getNome6() {
	return nome6;
}

public void setNome6(String nome6) {
	this.nome6 = nome6;
}

public String getNome7() {
	return nome7;
}

public void setNome7(String nome7) {
	this.nome7 = nome7;
}

public String getNome8() {
	return nome8;
}

public void setNome8(String nome8) {
	this.nome8 = nome8;
}

public String getNome9() {
	return nome9;
}

public void setNome9(String nome9) {
	this.nome9 = nome9;
}

public String getNome10() {
	return nome10;
}

public void setNome10(String nome10) {
	this.nome10 = nome10;
}

public String getNome11() {
	return nome11;
}

public void setNome11(String nome11) {
	this.nome11 = nome11;
}

public String getNome12() {
	return nome12;
}

public void setNome12(String nome12) {
	this.nome12 = nome12;
}

public String getNome13() {
	return nome13;
}

public void setNome13(String nome13) {
	this.nome13 = nome13;
}

public String getNome14() {
	return nome14;
}

public void setNome14(String nome14) {
	this.nome14 = nome14;
}

public String getNome15() {
	return nome15;
}

public void setNome15(String nome15) {
	this.nome15 = nome15;
}

public String getPositivaV1() {
	return positivaV1;
}

public void setPositivaV1(String positivaV1) {
	this.positivaV1 = positivaV1;
}

public String getNegativaV1() {
	return negativaV1;
}

public void setNegativaV1(String negativaV1) {
	this.negativaV1 = negativaV1;
}

public String getNeutraV1() {
	return neutraV1;
}

public void setNeutraV1(String neutraV1) {
	this.neutraV1 = neutraV1;
}

public String getPositivaV2() {
	return positivaV2;
}

public void setPositivaV2(String positivaV2) {
	this.positivaV2 = positivaV2;
}

public String getNegativaV2() {
	return negativaV2;
}

public void setNegativaV2(String negativaV2) {
	this.negativaV2 = negativaV2;
}

public String getNeutraV2() {
	return neutraV2;
}

public void setNeutraV2(String neutraV2) {
	this.neutraV2 = neutraV2;
}

public String getPositivaV3() {
	return positivaV3;
}

public void setPositivaV3(String positivaV3) {
	this.positivaV3 = positivaV3;
}

public String getNegativaV3() {
	return negativaV3;
}

public void setNegativaV3(String negativaV3) {
	this.negativaV3 = negativaV3;
}

public String getNeutraV3() {
	return neutraV3;
}

public void setNeutraV3(String neutraV3) {
	this.neutraV3 = neutraV3;
}

public String getPositivaV4() {
	return positivaV4;
}

public void setPositivaV4(String positivaV4) {
	this.positivaV4 = positivaV4;
}

public String getNegativaV4() {
	return negativaV4;
}

public void setNegativaV4(String negativaV4) {
	this.negativaV4 = negativaV4;
}

public String getNeutraV4() {
	return neutraV4;
}

public void setNeutraV4(String neutraV4) {
	this.neutraV4 = neutraV4;
}

public String getPositivaV5() {
	return positivaV5;
}

public void setPositivaV5(String positivaV5) {
	this.positivaV5 = positivaV5;
}

public String getNegativaV5() {
	return negativaV5;
}

public void setNegativaV5(String negativaV5) {
	this.negativaV5 = negativaV5;
}

public String getNeutraV5() {
	return neutraV5;
}

public void setNeutraV5(String neutraV5) {
	this.neutraV5 = neutraV5;
}

public String getPositivaV6() {
	return positivaV6;
}

public void setPositivaV6(String positivaV6) {
	this.positivaV6 = positivaV6;
}

public String getNegativaV6() {
	return negativaV6;
}

public void setNegativaV6(String negativaV6) {
	this.negativaV6 = negativaV6;
}

public String getNeutraV6() {
	return neutraV6;
}

public void setNeutraV6(String neutraV6) {
	this.neutraV6 = neutraV6;
}

public String getPositivaV7() {
	return positivaV7;
}

public void setPositivaV7(String positivaV7) {
	this.positivaV7 = positivaV7;
}

public String getNegativaV7() {
	return negativaV7;
}

public void setNegativaV7(String negativaV7) {
	this.negativaV7 = negativaV7;
}

public String getNeutraV7() {
	return neutraV7;
}

public void setNeutraV7(String neutraV7) {
	this.neutraV7 = neutraV7;
}

public String getPositivaV8() {
	return positivaV8;
}

public void setPositivaV8(String positivaV8) {
	this.positivaV8 = positivaV8;
}

public String getNegativaV8() {
	return negativaV8;
}

public void setNegativaV8(String negativaV8) {
	this.negativaV8 = negativaV8;
}

public String getNeutraV8() {
	return neutraV8;
}

public void setNeutraV8(String neutraV8) {
	this.neutraV8 = neutraV8;
}

public String getPositivaV9() {
	return positivaV9;
}

public void setPositivaV9(String positivaV9) {
	this.positivaV9 = positivaV9;
}

public String getNegativaV9() {
	return negativaV9;
}

public void setNegativaV9(String negativaV9) {
	this.negativaV9 = negativaV9;
}

public String getNeutraV9() {
	return neutraV9;
}

public void setNeutraV9(String neutraV9) {
	this.neutraV9 = neutraV9;
}

public String getPositivaV10() {
	return positivaV10;
}

public void setPositivaV10(String positivaV10) {
	this.positivaV10 = positivaV10;
}

public String getNegativaV10() {
	return negativaV10;
}

public void setNegativaV10(String negativaV10) {
	this.negativaV10 = negativaV10;
}

public String getNeutraV10() {
	return neutraV10;
}

public void setNeutraV10(String neutraV10) {
	this.neutraV10 = neutraV10;
}

public String getPositivaV11() {
	return positivaV11;
}

public void setPositivaV11(String positivaV11) {
	this.positivaV11 = positivaV11;
}

public String getNegativaV11() {
	return negativaV11;
}

public void setNegativaV11(String negativaV11) {
	this.negativaV11 = negativaV11;
}

public String getNeutraV11() {
	return neutraV11;
}

public void setNeutraV11(String neutraV11) {
	this.neutraV11 = neutraV11;
}

public String getPositivaV12() {
	return positivaV12;
}

public void setPositivaV12(String positivaV12) {
	this.positivaV12 = positivaV12;
}

public String getNegativaV12() {
	return negativaV12;
}

public void setNegativaV12(String negativaV12) {
	this.negativaV12 = negativaV12;
}

public String getNeutraV12() {
	return neutraV12;
}

public void setNeutraV12(String neutraV12) {
	this.neutraV12 = neutraV12;
}

public String getPositivaV13() {
	return positivaV13;
}

public void setPositivaV13(String positivaV13) {
	this.positivaV13 = positivaV13;
}

public String getNegativaV13() {
	return negativaV13;
}

public void setNegativaV13(String negativaV13) {
	this.negativaV13 = negativaV13;
}

public String getNeutraV13() {
	return neutraV13;
}

public void setNeutraV13(String neutraV13) {
	this.neutraV13 = neutraV13;
}

public String getPositivaV14() {
	return positivaV14;
}

public void setPositivaV14(String positivaV14) {
	this.positivaV14 = positivaV14;
}

public String getNegativaV14() {
	return negativaV14;
}

public void setNegativaV14(String negativaV14) {
	this.negativaV14 = negativaV14;
}

public String getNeutraV14() {
	return neutraV14;
}

public void setNeutraV14(String neutraV14) {
	this.neutraV14 = neutraV14;
}

public String getPositivaV15() {
	return positivaV15;
}

public void setPositivaV15(String positivaV15) {
	this.positivaV15 = positivaV15;
}

public String getNegativaV15() {
	return negativaV15;
}

public void setNegativaV15(String negativaV15) {
	this.negativaV15 = negativaV15;
}

public String getNeutraV15() {
	return neutraV15;
}

public void setNeutraV15(String neutraV15) {
	this.neutraV15 = neutraV15;
}


	

}
