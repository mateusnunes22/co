package controle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.SessionUtil;
import entidade.*;

public class UsuarioBean {

	private String atualizarPagina ="";
	private Usuario usuario = new Usuario();
	private int solicitacoes = 0;
	public List<Usuario> lista =  new ArrayList<Usuario>();
	public String desc="";
	public Usuario usuarioLogin = new Usuario();
	public List<SelectItem> listaCombobox =  new ArrayList<SelectItem>();
	


public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}


	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}


public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public List<Usuario> buscarId(Integer id){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Usuario u where u.idUsuario = :idUsuario");
		// Seta o parametro pelo :		
		q.setParameter("idUsuario", id);
		// joga o resultado da pesquisa para uma lista
		List<Usuario> objeto = q.list();
		return objeto;
	} 
	
	public List<Usuario> buscarNome(String nomeUsuario){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Usuario u where u.nomeUsuario = :nomeUsuario ");
		// Seta o parametro pelo :		
		q.setParameter("nomeUsuario", nomeUsuario);
		// joga o resultado da pesquisa para uma lista
		List<Usuario> objeto = q.list();
		return objeto;
	} 
	
	public List<Usuario> buscarPerfil(String perfil){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Usuario u where u.perfil = :perfil ");
		// Seta o parametro pelo :		
		q.setParameter("perfil", perfil);
		// joga o resultado da pesquisa para uma lista
		List<Usuario> objeto = q.list();
		return objeto;
	} 
	
	
	public String pesquisaUsuario(){
		int y=-1;
		try{
			 y=Integer.parseInt(desc);
				
		}catch(Exception e){
	
			}

		if(desc.equals("") ) {
		    lista = buscaTodos();
		}else if(y>=0){
			System.out.println(y);
			lista = buscarId(y);
		}else{
			lista = buscarNome(desc);
			System.out.println(desc);
		}
	
		return null;		
	}


public List<Usuario> getLista() {
	if(desc.equals("")){
		lista = buscaTodos();
		return lista;
	}else{
		return lista;
	}
}


	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}


public List<Usuario> buscaTodos(){
		
		Session session = HibernateUtil.getSession();
		Query q =  session.createQuery("from Usuario");
		
		List<Usuario> objeto = q.list();
		
		session.close();
		return objeto;
		
		
	}
	
	
	
	public String salvar() throws IllegalStateException {
		// cria sessao com banco e transacao
		
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();	

		
		boolean salvar3 = false;
		
		try {
			
			
			int cont=0;
			
			for(int i=0;i<usuario.getEmail().length();i++)
	        {
	           String teste=String.valueOf(usuario.getEmail().charAt(i));
	           


	            if(teste.equals("@"))
	            {
	            
	            	cont++;
	           
	            }

	            if(cont==1)
	            {
	            	salvar3=true;
	            }
	            else
	            {
	            	salvar3=false;
	            }


	        }
			

			if(salvar3)
			{
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(1);
			
			
			if(usuario.getPerfil().equalsIgnoreCase("funcionari"))
			{
				usuario.setCliente(cliente);
			}
			//usuario.setCliente(cliente.buscarId(usuario.getCliente().getIdCliente()).get(0));

			session.merge(usuario);
			t.commit();
			
			SessionUtil.addSuccessMessage("OperacaoSucesso");
			
			// limpa objeto funcionario para novas insercoes

			usuario = new Usuario();
			
			}
			else
			{
				SessionUtil.addErrorMessage("EmailInvalido");
			}
			
		} catch (Exception ex) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();

			if(ex.getMessage().equalsIgnoreCase("could not insert: [entidade.Usuario]"))
			{
				SessionUtil.addErrorMessage("UsuarioJaCadastrado");
			}
			else
			{
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}
			
			
		}
		
		finally{
			//fecha conexao
			session.close();
			
		}
		
		
		return null;
					
	}
	
	
	public String logar() {
		
		
		
		try{
			
			usuario.setPerfil(buscarNome(usuario.getNomeUsuario()).get(0).getPerfil());
			
			usuarioLogin.setNomeUsuario(buscarNome(usuario.getNomeUsuario()).get(0).getNomeUsuario());
			usuarioLogin.setSenha(buscarNome(usuario.getNomeUsuario()).get(0).getSenha());
			usuarioLogin.setPerfil(usuario.getPerfil());
			usuarioLogin.setIdUsuario(buscarNome(usuario.getNomeUsuario()).get(0).getIdUsuario());
			
			
			if(usuarioLogin.getSenha().equalsIgnoreCase(usuario.getSenha()))
			{
			    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", usuarioLogin);
			    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dataInicial", new Date());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dataFinal", new Date());
			    
				
				
				if(usuario.getPerfil().equalsIgnoreCase("boss"))
				{
					
					usuario = new Usuario();
					
					MateriaBean bloqueio = new MateriaBean();
					
					bloqueio.bloqueioMensal();
					
					return "logadoBoss";
				}
				
				else if(usuario.getPerfil().equalsIgnoreCase("funcionari"))
				{
					usuario = new Usuario();
					
					return "logadoFunc";
				}
				
				else
				{
					usuario = new Usuario();

					return "logadoClie";
				}
				
			}
			else
			{
				SessionUtil.addErrorMessage("SenhaIncorreta");
			}
			
			
			
			

		}catch (Exception e) {

			if(e.getMessage().equalsIgnoreCase("Index: 0, Size: 0"))
			{
				SessionUtil.addErrorMessage("UsuarioInvalido");
			}
			else{
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}
			
			}

			return null;
			
		}
	
	
	public List<SelectItem> getUsuarioNome(){
		
	     UsuarioBean usuarioBean = new UsuarioBean();
	     
	  
	     listaCombobox.clear();
	     
	     List<Usuario> clientes = usuarioBean.buscarPerfil("cliente");  
	     
	        for  (Usuario c : clientes){    
	              SelectItem  s = new SelectItem();    
	              s.setValue(c.getIdUsuario());    
	              s.setLabel( c.getNomeUsuario());    
	             listaCombobox.add(s);    

	             
	       }
	        
	        
	       return listaCombobox;  
	     
}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public int getSolicitacoes() {
		return solicitacoes;
	}


	public void setSolicitacoes(int solicitacoes) {
		this.solicitacoes = solicitacoes;
	}


	public String getAtualizarPagina() {
		
		MateriaBean bloqueio = new MateriaBean();
		
		solicitacoes = bloqueio.solicitacao();
		
		return atualizarPagina;
	}


	public void setAtualizarPagina(String atualizarPagina) {
		this.atualizarPagina = atualizarPagina;
	}
	
	
}
