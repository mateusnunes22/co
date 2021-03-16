package login;

public class Perfil {
	
	private String perf;
	
	private String pag[];
	
	public Perfil(String perfil) {
		
		this.setPerf(perfil);
		
		if(this.getPerf().equalsIgnoreCase("boss"))
		{
			
			String p[] = {"/contromidia.jsp","/boss.jsp","/cliente.jsp","/funcionario.jsp"
					,"/arquivo.jsp","/cadastrousuario.jsp","/graficocritica.jsp",
					"/funcionarioimpresso.jsp","/funcionariovideo.jsp","/funcionarioaudio.jsp"
					,"/editeaudio.jsp","/editevideo.jsp","/editeimpresso.jsp","/arquivoedite.jsp"
					,"/editeveiculo.jsp","/clientesolicitacao.jsp","/cadastrocliente.jsp",
					"/materialiberada.jsp"};
			
			this.setPag(p);
		}
		
		else if(this.getPerf().equalsIgnoreCase("funcionari"))
		{
			String p[] = {"/contromidia.jsp","/funcionario.jsp","/arquivo.jsp",
					"/funcionarioimpresso.jsp","/funcionariovideo.jsp","/funcionarioaudio.jsp"};
			
			this.setPag(p);
		}
		
		else
		{
			
			String p[] = {"/contromidia.jsp","/cliente.jsp","/clientevideo.jsp","/clienteaudio.jsp"
					,"/clienteimpresso.jsp"};
			
			this.setPag(p);
		}
		
		
		
		
		
	}
	
	public boolean temAcesso(String pagina)
	{
		Boolean temAcesso = false;
		String p[] = this.getPag();
		
		
		for(int i = 0;i<p.length;i++)
		{
			if(pagina.endsWith(p[i]))
			{
				temAcesso = true;
			}
		}
		System.out.println(temAcesso);
		return temAcesso;
	}
	
	

	public String[] getPag() {
		return pag;
	}

	public void setPag(String[] pag) {
		this.pag = pag;
	}

	public String getPerf() {
		return perf;
	}

	public void setPerf(String perf) {
		this.perf = perf;
	}

}



/*package login;

public class Perfil {
	
	private String perf;
	
	private String pag;
	private String pag2;
	private String pag3;
	
	public Perfil(String perfil) {
		
		
		
		this.setPerf(perfil);
		
		
		
		if(this.getPerf().equalsIgnoreCase("maximo"))
		{
			this.setPag("/sisconfin.jsp");
			this.setPag2("/planodecontas.jsp");
			this.setPag3("/pessoa.jsp");
			
		}
		else
		{
			this.setPag("/sisconfin.jsp");
			this.setPag2("aaaaaaaa");
			this.setPag3("/pessoa.jsp");
			
		}
		
		
	}
	
	public boolean temAcesso(String pagina)
	{
		Boolean temAcesso = false;
		
		
			if(pagina.endsWith(this.getPag()))
			{
				temAcesso = true;
			}
			
			if(pagina.endsWith(this.getPag2()))
			{
				temAcesso = true;
			}
			
			if(pagina.endsWith(this.getPag3()))
			{
				temAcesso = true;
			}
	
		
		return temAcesso;
	}

	public String getPerf() {
		return perf;
	}

	public void setPerf(String perf) {
		this.perf = perf;
	}

	public String getPag() {
		return pag;
	}

	public void setPag(String pag) {
		this.pag = pag;
	}

	public String getPag2() {
		return pag2;
	}

	public void setPag2(String pag2) {
		this.pag2 = pag2;
	}

	public String getPag3() {
		return pag3;
	}

	public void setPag3(String pag3) {
		this.pag3 = pag3;
	}

}


 */
