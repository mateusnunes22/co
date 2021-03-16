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

public class ClienteBean {


	private Cliente cliente = new Cliente();
	public List<Cliente> listaCliente =  new ArrayList<Cliente>();
	public String desc="";
	public Usuario usuarioLogin = new Usuario();
	public List<SelectItem> ComboboxCliente =  new ArrayList<SelectItem>();


	public List<SelectItem> getComboboxCliente() {
		return ComboboxCliente;
	}


	public void setComboboxCliente(List<SelectItem> comboboxCliente) {
		ComboboxCliente = comboboxCliente;
	}


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
	
	public List<Cliente> buscarId(Integer id){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Cliente u where u.idCliente = :idCliente");
		// Seta o parametro pelo :		
		q.setParameter("idUsuario", id);
		// joga o resultado da pesquisa para uma lista
		List<Cliente> objeto = q.list();
		return objeto;
	} 
	
	public List<Cliente> buscarNome(String nomeCliente){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Cliente u where u.nomeUsuario = :nomeUsuario ");
		// Seta o parametro pelo :		
		q.setParameter("nomeUsuario", nomeCliente);
		// joga o resultado da pesquisa para uma lista
		List<Cliente> objeto = q.list();
		return objeto;
	} 
	
	public List<Cliente> buscarPerfil(String perfil){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		// Cria query de consulta
		Query q = session.createQuery("from Cliente u where u.perfil = :perfil ");
		// Seta o parametro pelo :		
		q.setParameter("perfil", perfil);
		// joga o resultado da pesquisa para uma lista
		List<Cliente> objeto = q.list();
		return objeto;
	} 
	
	
	public String pesquisaUsuario(){
		int y=-1;
		try{
			 y=Integer.parseInt(desc);
				
		}catch(Exception e){
	
			}

		if(desc.equals("") ) {
		    listaCliente = buscaTodos();
		}else if(y>=0){
			System.out.println(y);
			listaCliente = buscarId(y);
		}else{
			listaCliente = buscarNome(desc);
			System.out.println(desc);
		}
	
		return null;		
	}


public List<Cliente> getLista() {
	if(desc.equals("")){
		listaCliente = buscaTodos();
		return listaCliente;
	}else{
		return listaCliente;
	}
}


	public void setLista(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}


public List<Cliente> buscaTodos(){
		
		Session session = HibernateUtil.getSession();
		Query q =  session.createQuery("from Cliente");
		
		List<Cliente> objeto = q.list();
		
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
			
			for(int i=0;i<cliente.getEmail().length();i++)
	        {
	           String teste=String.valueOf(cliente.getEmail().charAt(i));
	           


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

			session.merge(cliente);
			t.commit();
			
			SessionUtil.addSuccessMessage("OperacaoSucesso");
			
			// limpa objeto funcionario para novas insercoes

			cliente = new Cliente();
			
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
	
	
	/*public String logar() {
		
		
		
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
			
		}*/
	
	
	public List<SelectItem> getClienteNome(){
		
	     ClienteBean usuarioBean = new ClienteBean();
	     
	  
	     ComboboxCliente.clear();
	     
	     List<Cliente> clientes = usuarioBean.buscarPerfil("cliente");  
	     
	        for  (Cliente c : clientes){    
	              SelectItem  s = new SelectItem();    
	              s.setValue(c.getIdCliente());    
	              s.setLabel( c.getNomeUsuario());    
	             ComboboxCliente.add(s);    

	             
	       }
	        
	        
	       return ComboboxCliente;  
	     
}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
