package controle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import util.HibernateUtil;
import util.SessionUtil;
import entidade.Materia;
import entidade.Usuario;
import entidade.UsuarioHasMateria;
import entidade.UsuarioHasMateriaId;


public class MateriaBean {
	//dev -
	//private String enderecoInternoAudio = "C:/Users/gilberto/Dropbox/Dev/Andre_Lara/Agil/Home/workspace/Co/WebContent/upload/audio/";
	//private String enderecoInternoAudio2 = "C:/Users/gilberto/Dropbox/Dev/Andre_Lara/Agil/Home/workspace/Co/WebContent/upload/audio/";
	//private String enderecoInternoVideo = "C:/Users/gilberto/Dropbox/Dev/Andre_Lara/Agil/Home/workspace/Co/WebContent/upload/video/";
	//private String enderecoInternoVideo2= "C:/Users/gilberto/Dropbox/Dev/Andre_Lara/Agil/Home/workspace/Co/WebContent/upload/video/";
	//prod -
	private String enderecoInternoAudio = "webapps/ROOT/WebContent/upload/audio/";
	private String enderecoInternoAudio2 = "webapps/ROOT/upload/audio/";
	private String enderecoInternoVideo = "webapps/ROOT/WebContent/upload/video/";
	private String enderecoInternoVideo2= "webapps/ROOT/upload/video/";
	private String tabelaVazia = "";
	private String tabelaVazia2 = "";
	private Materia materia = new Materia();
	private Materia materiaEdit = new Materia();
	private Usuario usuario = new Usuario();
	private Materia materiaBusca = new Materia();
	private Date dataInicial = new Date();
	private Date dataFinal = new Date();
	private Materia materiaBusca2 = new Materia();
	private Date dataInicial2 = new Date();
	private Date dataFinal2 = new Date();
	private UsuarioHasMateria usuarioHasMateria = new UsuarioHasMateria();
	private UIData objTabelaMateria;
	private UIData objTabelaMateria2;
	private UploadItem item = new UploadItem("", 0, "", "");
	private String nomeArquivo;
	public List<Materia> lista = new ArrayList<Materia>(); 
	public List<Materia> hasMateriaForgId = new ArrayList<Materia>();
	public List<UsuarioHasMateria> hasMateriaForgIdBoss = new ArrayList<UsuarioHasMateria>();
	public List<UsuarioHasMateria> solicitacaoVideo = new ArrayList<UsuarioHasMateria>();
	public List<SelectItem> listaCombobox =  new ArrayList<SelectItem>();
	private Integer[] usuariosLiberados = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	Usuario u = new Usuario();
	Materia materia2 = new Materia();
	UsuarioHasMateria usuarioHasMateria2 = new UsuarioHasMateria();


	public void download()
	{

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext context = facesContext.getExternalContext();
		HttpServletResponse responseScope = (HttpServletResponse) context.getResponse();

		File arquivoAtual = new File(materia2.getPadrao());




		if(materia2.getPadrao().equalsIgnoreCase(""))
		{
			SessionUtil.addErrorMessage("ArquivoNaoInserido");
		}
		else{
			try{
				ServletOutputStream ouputStream;

				FileInputStream stream = new FileInputStream(arquivoAtual);

				byte[] buf=new byte[1024];
				int bytesread = 0;

				responseScope.setHeader("Content-Disposition", "attachment; filename=\"" + materia2.getNomeDoArquivo() + "" + "\";");  
				responseScope.setContentType(materia2.getExtensao());
				responseScope.setContentLength(Integer.parseInt(Long.toString(arquivoAtual.length())));



				responseScope.setBufferSize(1024);
				// Obtem o tamanho máximo da heap em bytes.

				ouputStream = responseScope.getOutputStream();

				/*long heapSize = Runtime.getRuntime().totalMemory();

				 System.out.println("aaa"+heapSize);// Obtem o tamanho máximo da heap em bytes.

				 long heapMaxSize = Runtime.getRuntime().maxMemory();

				 System.out.println("bbb"+heapMaxSize);// Obtem memória livre na heap. 

				 long heapFreeSize = Runtime.getRuntime().freeMemory();

				 System.out.println("ccc"+heapFreeSize);
				 */
				while( (bytesread = stream.read( buf )) > -1 )
				{
					ouputStream.write( buf, 0, bytesread );


				}


				//ouputStream.write(arquivoBytes);  


				ouputStream.flush();  
				ouputStream.close(); 
				stream.close();


			} catch (IOException e) {
				e.printStackTrace();
			}


			materia2 = new Materia();
			facesContext.responseComplete();  
		}


	}

	public String fileDownloadCliente()
	{


		materia2 =  materiaEdit;

		download();

		/*String nome = "C:/Workspace/Co/WebContent/Upload/Video/" + materiaEdit.getNomeDoArquivo();  
		File f = new File(nome);  
		f.delete();

		String nome2 = "C:/Workspace/Co/WebContent/Upload/Audio/" + materiaEdit.getNomeDoArquivo();  
		File a = new File(nome2);  
		a.delete();*/

		return null;

	}

	public String fileDownload()
	{

		materia2 =  (Materia) objTabelaMateria.getRowData();

		download();

		return null;

	}


	public void fileUploadListener(UploadEvent event) throws Exception{
		File folderAudio = new File(enderecoInternoAudio);//Video
		if (folderAudio.isDirectory()) {
			File[] sun = folderAudio.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
		
		File folderAudio2 = new File(enderecoInternoAudio2);//Audio
		if (folderAudio2.isDirectory()) {
			File[] sun = folderAudio2.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
		
		File folderVideo = new File(enderecoInternoVideo);//Video
		if (folderVideo.isDirectory()) {
			File[] sun = folderVideo.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
		
		File folderVideo2 = new File(enderecoInternoVideo2);//Audio
		if (folderVideo2.isDirectory()) {
			File[] sun = folderVideo2.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
		
		Thread.sleep(900);
		
		item = event.getUploadItem();
		
		setNomeArquivo(item.getFileName());
		
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();	
		String pastaTest = "";
		String pastaTest2 = "";
		try {

			if(item.getFileName().toLowerCase().endsWith(".mp3")){
				pastaTest = enderecoInternoAudio;
				pastaTest2 = enderecoInternoAudio2;

			}else if(item.getFileName().toLowerCase().endsWith(".mp4") || item.getFileName().toLowerCase().endsWith(".avi")
					|| item.getFileName().toLowerCase().endsWith(".mkv") || item.getFileName().toLowerCase().endsWith(".rmvb")){
				pastaTest = enderecoInternoVideo;
				pastaTest2 = enderecoInternoVideo2;

			}else{
				pastaTest = enderecoInternoAudio;
				pastaTest2 = enderecoInternoAudio2;
			}

			File pastaTeste = new File(pastaTest);

			if(pastaTeste.exists())
			{

			}
			else
			{
				pastaTeste.mkdirs();
			}

			String pasta = pastaTest + item.getFileName();

			File fileExist = new File(pasta);

			if(fileExist.exists())
			{
				int i=0;
				int j=0;
				String cpf2="",cpf3="", teste="";


				for(j=0;j<pasta.length();j++)
				{
					teste=String.valueOf(pasta.charAt(j));


					if(teste.equals("."))
					{
						cpf2 = pasta.substring(0, j);
						cpf3 = pasta.substring(j, pasta.length());
						pasta = cpf2+ "(" + i + ")" + cpf3;
						break;
					}


				}

				for(i=1;i<9999999;i++)
				{

					for(j=0;j<pasta.length();j++)
					{
						teste=String.valueOf(pasta.charAt(j));


						if(teste.equals("."))
						{
							cpf2 = pasta.substring(0, j);
							cpf3 = pasta.substring(j, pasta.length());
							pasta = cpf2.substring(0, cpf2.length() - 3) + "(" + i + ")" + cpf3;

							break;
						}


					}

					File fileTemp = new File(pasta);
					if(fileTemp.exists())
					{
						
					}
					else
					{

						break;
					}

					
				}



			}

			File arquivoOrigem = item.getFile();
	        File arquivoDestino = new File(pasta);
	        pasta = pastaTest2 + item.getFileName();
	        File arquivoDestino2 = new File(pasta);
	        
	        try{
			copy(arquivoOrigem, arquivoDestino);
			copy(arquivoOrigem, arquivoDestino2);			
	        } catch (Exception e) {
				
			}
			//DataInputStream dis = new DataInputStream(new FileInputStream(item.getFile()));


			//DataOutputStream fis = new DataOutputStream(new FileOutputStream(pasta));

			/* int buff = Integer.parseInt(Long.toString(arquivoAtual.length()));
		      byte[] buf = new byte[buff];


			  dis.readFully(buf);
		      fis.write(buf);*/

		/*	byte[] buf=new byte[1024];
			int bytesread = 0;

			while( (bytesread = dis.read( buf )) > -1 )
			{
				fis.write( buf, 0, bytesread );
			}

			fis.flush();

			fis.close();
			dis.close();*/
		
			Thread.sleep(7300);
			SessionUtil.addSuccessMessage("OperacaoSucesso");

		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			//pagina = null;
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}


	}

	public String editar() throws Exception{

		String pagina = null;

		materiaEdit =  (Materia) objTabelaMateria.getRowData();
		item = new UploadItem("", 0, "", "");

		if(materiaEdit.getVeiculo().equalsIgnoreCase("Audio"))
		{
			
			File pastaTeste = new File(enderecoInternoAudio);

			if(!pastaTeste.exists())
			{
				pastaTeste.mkdirs();
			}
			
			pastaTeste = new File(enderecoInternoAudio2);

			if(!pastaTeste.exists())
			{
				pastaTeste.mkdirs();
			}
			
			String nome = enderecoInternoAudio + materiaEdit.getNomeDoArquivo();//Audio  
			String nome2 = enderecoInternoAudio2 + materiaEdit.getNomeDoArquivo();//Audio  
			File f = new File(nome);
			File f2 = new File(nome2); 
			f.delete();
			f2.delete();
			
			String pathOrigem = materiaEdit.getPadrao() ;
	        String pathDestino = enderecoInternoAudio + materiaEdit.getNomeDoArquivo();//Audio
	        String pathDestino2 = enderecoInternoAudio2 + materiaEdit.getNomeDoArquivo();//Audio
	        
	        File arquivoOrigem = new File(pathOrigem);
	        File arquivoDestino = new File(pathDestino);
	        File arquivoDestino2 = new File(pathDestino2);
	        
	        try{
			copy(arquivoOrigem, arquivoDestino);
			copy(arquivoOrigem, arquivoDestino2);
	        } catch (Exception e) {
				
			}
	        
	        Thread.sleep(7500);
			pagina="editAud";
		}
		else if(materiaEdit.getVeiculo().equalsIgnoreCase("Impresso"))
		{
			pagina="editImp";
		}
		else if(materiaEdit.getVeiculo().equalsIgnoreCase("Video"))
		{
			
			File pastaTeste = new File(enderecoInternoVideo);

			if(!pastaTeste.exists())
			{
				pastaTeste.mkdirs();
			}
			
			pastaTeste = new File(enderecoInternoVideo2);

			if(!pastaTeste.exists())
			{
				pastaTeste.mkdirs();
			}
			
			String nome = enderecoInternoVideo + materiaEdit.getNomeDoArquivo();//video
			File f = new File(nome);
			String nome2 = enderecoInternoVideo2 + materiaEdit.getNomeDoArquivo();//video
			File f2 = new File(nome2);
			f.delete();
			f2.delete();
			
			String pathOrigem =  materiaEdit.getPadrao();
	        String pathDestino = enderecoInternoVideo + materiaEdit.getNomeDoArquivo();//video
	        String pathDestino2 = enderecoInternoVideo2 + materiaEdit.getNomeDoArquivo();//video
	        
	        File arquivoOrigem = new File(pathOrigem);
	        File arquivoDestino = new File(pathDestino);
	        File arquivoDestino2 = new File(pathDestino2);
	        
	        try{
			copy(arquivoOrigem, arquivoDestino);
			copy(arquivoOrigem, arquivoDestino2);
	        } catch (Exception e) {
				
			}
	        Thread.sleep(7500);
	        
			pagina="editVid";
		}
		
		return pagina;

	}

	public static void copy(File origem, File destino) throws IOException{
		Date date = new Date();
        InputStream in = new FileInputStream(origem);
        OutputStream out = new FileOutputStream(destino);          
        // Transferindo bytes de entrada para saída
        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght= in.read(buffer)) > 0) {
            out.write(buffer, 0, lenght);
        }
        in.close();
        out.close();
        Long time = new Date().getTime() - date.getTime();
        System.out.println("Saiu copy"+time);
		
	}

	public String editarArquivo() throws IllegalStateException {

		String veiculo = "",retorno=null;

		veiculo = materiaEdit.getVeiculo();


		if(veiculo.equalsIgnoreCase("Audio"))
		{
			retorno="funcAud";
		}

		else if(veiculo.equalsIgnoreCase("Impresso"))
		{
			retorno="funcImp";
		}

		else if(veiculo.equalsIgnoreCase("Video"))
		{
			retorno="funcVid";
		}


		return retorno;

	}



	public String editarVeiculo(){

		String veiculo = "", pagina=null;

		veiculo = materiaEdit.getVeiculo();

		if(veiculo.equalsIgnoreCase("Audio"))
		{
			pagina = "editAud";
		}
		else if(veiculo.equalsIgnoreCase("Video"))
		{
			pagina = "editVid";
		}
		else if(veiculo.equalsIgnoreCase("Impresso"))
		{
			pagina = "editImp";
		}

		return pagina;

	}

	public String deletar() throws IllegalStateException{

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		Materia materiaEdit =  (Materia) objTabelaMateria.getRowData();

		String deletar=materiaEdit.getPadrao();

		Criteria q = session.createCriteria(UsuarioHasMateria.class);
		q.add(Restrictions.eq("id.materiaIdMateria", materiaEdit.getIdMateria()));

		List<UsuarioHasMateria> objeto2 = q.list();


		if(objeto2.isEmpty())
		{

			int res = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja" +
					" deletar essa matéria?");


			if(res==0)
			{


				try {

					session.delete(materiaEdit);

					t.commit();

					File fileDelete = new File(deletar);

					fileDelete.delete();

					SessionUtil.addSuccessMessage("OperacaoSucesso");

					materiaEdit = new Materia();

				} catch (Exception e) {
					// se algo errado ocorrer cancela a trasacao
					t.rollback();

					SessionUtil.addErrorMessage("OperacaoFracasso");
				}


			}
			else
			{

			}


		}

		else
		{
			SessionUtil.addErrorMessage("FalhaDeletar");
		}

		session.close();

		return null;

	}

	public String salvarEdit() throws IllegalStateException {
		//cria sessao com banco e transacao
		String pagina = "retorno";

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		if(item.getFileSize()==0)
		{

			try {



				session.merge(materiaEdit);

				t.commit();
				SessionUtil.addSuccessMessage("OperacaoSucesso");

				materiaEdit = new Materia();
				item = new UploadItem("", 0, "", "");

			} catch (Exception e) {
				// se algo errado ocorrer cancela a trasacao
				t.rollback();
				pagina = null;
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}finally{
				//fecha conexao
				session.close();

			}

		}

		else
		{
			try {


				String pastaFinal = materiaEdit.getVeiculo(), deletar = materiaEdit.getPadrao();

				String pastaTest = "C:" + File.separator + "Upload" + File.separator + pastaFinal + File.separator;

				File pastaTeste = new File(pastaTest);

				if(pastaTeste.exists())
				{

				}
				else
				{
					pastaTeste.mkdirs();
				}


				String pasta = pastaTest + getNomeArquivo();



				File fileExist = new File(pasta);

				if(fileExist.exists())
				{
					int i=0;
					int j=0;
					String cpf2="",cpf3="", teste="";


					for(j=0;j<pasta.length();j++)
					{
						teste=String.valueOf(pasta.charAt(j));


						if(teste.equals("."))
						{
							cpf2 = pasta.substring(0, j);
							cpf3 = pasta.substring(j, pasta.length());
							pasta = cpf2+ "(" + i + ")" + cpf3;
							break;
						}


					}

					for(i=1;i<9999999;i++)
					{

						for(j=0;j<pasta.length();j++)
						{
							teste=String.valueOf(pasta.charAt(j));


							if(teste.equals("."))
							{

								cpf2 = pasta.substring(0, j);
								cpf3 = pasta.substring(j, pasta.length());
								pasta = cpf2.substring(0, cpf2.length() - 3) + "(" + i + ")" + cpf3;

								break;
							}


						}

						File fileTemp = new File(pasta);
						if(fileTemp.exists())
						{

						}
						else
						{

							break;
						}

					}



				}

				DataInputStream dis = new DataInputStream(new FileInputStream(item.getFile()));


				DataOutputStream fis = new DataOutputStream(new FileOutputStream(pasta));

				/* int buff = Integer.parseInt(Long.toString(arquivoAtual.length()));
			      byte[] buf = new byte[buff];


				  dis.readFully(buf);
			      fis.write(buf);*/

				byte[] buf=new byte[1024];
				int bytesread = 0;

				while( (bytesread = dis.read( buf )) > -1 )
				{
					fis.write( buf, 0, bytesread );
				}



				fis.flush();


				fis.close();
				dis.close();



				materiaEdit.setPadrao(pasta);
				materiaEdit.setNomeDoArquivo(item.getFileName());
				materiaEdit.setExtensao(item.getContentType());

				session.merge(materiaEdit);

				t.commit();

				File fileDelete = new File(deletar);

				fileDelete.delete();

				materiaEdit = new Materia();
				item = new UploadItem("", 0, "", "");

				SessionUtil.addSuccessMessage("OperacaoSucesso");

			} catch (Exception e) {
				// se algo errado ocorrer cancela a trasacao
				t.rollback();
				pagina = null;
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}finally{
				//fecha conexao
				session.close();

			}
		}




		return pagina;

	}


	public String salvar() throws IllegalStateException {
		//cria sessao com banco e transacao
		String pagina = "retorno";

		if(item.getFileSize()==0)
		{


			Session session = HibernateUtil.getSession();
			Transaction t = session.beginTransaction();	

			try {

				materia.setPadrao("");
				materia.setExtensao("");
				materia.setNomeDoArquivo("");

				session.merge(materia);

				t.commit();
				SessionUtil.addSuccessMessage("OperacaoSucesso");

				materia = new Materia();
				item = new UploadItem("", 0, "", "");

			} catch (Exception e) {
				// se algo errado ocorrer cancela a trasacao
				t.rollback();
				pagina = null;
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}finally{
				//fecha conexao
				session.close();

			}
		}

		else
		{

			Session session = HibernateUtil.getSession();
			Transaction t = session.beginTransaction();	


			try {
				/*FileInputStream stream = new FileInputStream(item.getFile());
		File stream2 = item.getFile();

		System.out.println(stream2.getAbsolutePath());
		byte[] data2 = new byte[stream.available()];
		stream.read(data2);
		stream.close();*/

				String pastaFinal = materia.getVeiculo();

				String pastaTest = "C:" + File.separator + "Upload" + File.separator + pastaFinal + File.separator;

				File pastaTeste = new File(pastaTest);

				if(pastaTeste.exists())
				{

				}
				else
				{
					pastaTeste.mkdirs();
				}


				String pasta = pastaTest + item.getFileName();



				File fileExist = new File(pasta);

				if(fileExist.exists())
				{
					int i=0;
					int j=0;
					String cpf2="",cpf3="", teste="";


					for(j=0;j<pasta.length();j++)
					{
						teste=String.valueOf(pasta.charAt(j));


						if(teste.equals("."))
						{
							cpf2 = pasta.substring(0, j);
							cpf3 = pasta.substring(j, pasta.length());
							pasta = cpf2+ "(" + i + ")" + cpf3;
							break;
						}


					}

					for(i=1;i<9999999;i++)
					{

						for(j=0;j<pasta.length();j++)
						{
							teste=String.valueOf(pasta.charAt(j));


							if(teste.equals("."))
							{
								cpf2 = pasta.substring(0, j);
								cpf3 = pasta.substring(j, pasta.length());
								pasta = cpf2.substring(0, cpf2.length() - 3) + "(" + i + ")" + cpf3;

								break;
							}


						}

						File fileTemp = new File(pasta);
						if(fileTemp.exists())
						{

						}
						else
						{

							break;
						}

					}



				}

				DataInputStream dis = new DataInputStream(new FileInputStream(item.getFile()));


				DataOutputStream fis = new DataOutputStream(new FileOutputStream(pasta));

				/* int buff = Integer.parseInt(Long.toString(arquivoAtual.length()));
	      byte[] buf = new byte[buff];


		  dis.readFully(buf);
	      fis.write(buf);*/

				byte[] buf=new byte[1024];
				int bytesread = 0;

				while( (bytesread = dis.read( buf )) > -1 )
				{
					fis.write( buf, 0, bytesread );
				}



				fis.flush();


				fis.close();
				dis.close();
				
				/*String nome = "C:/Workspace/Co/WebContent/Upload";  
				File f = new File(nome);  
				f.delete();*/

				File folderAudio = new File(enderecoInternoAudio);//Video
				if (folderAudio.isDirectory()) {
					File[] sun = folderAudio.listFiles();
					for (File toDelete : sun) {
						toDelete.delete();
					}
				}
				
				File folderAudio2 = new File(enderecoInternoAudio2);//Audio
				if (folderAudio2.isDirectory()) {
					File[] sun = folderAudio2.listFiles();
					for (File toDelete : sun) {
						toDelete.delete();
					}
				}
				
				File folderVideo = new File(enderecoInternoVideo);//Video
				if (folderVideo.isDirectory()) {
					File[] sun = folderVideo.listFiles();
					for (File toDelete : sun) {
						toDelete.delete();
					}
				}
				
				File folderVideo2 = new File(enderecoInternoVideo2);//Audio
				if (folderVideo2.isDirectory()) {
					File[] sun = folderVideo2.listFiles();
					for (File toDelete : sun) {
						toDelete.delete();
					}
				}

				materia.setPadrao(pasta);
				materia.setNomeDoArquivo(item.getFileName());
				materia.setExtensao(item.getContentType());

				session.merge(materia);

				t.commit();
				SessionUtil.addSuccessMessage("OperacaoSucesso");

				materia = new Materia();
				item = new UploadItem("", 0, "", "");

			} catch (Exception e) {
				// se algo errado ocorrer cancela a trasacao
				t.rollback();
				pagina = null;
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}finally{
				//fecha conexao
				session.close();

			}


		}



		return pagina;

	}


	public String salvarHasMateria() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	

		materia2 =  (Materia) objTabelaMateria.getRowData();

		if(usuario.getIdUsuario()==-1)
		{
			SessionUtil.addErrorMessage("SelecionarCliente");
		}
		else
		{

			try {


				UsuarioHasMateriaId id = new UsuarioHasMateriaId();

				usuarioHasMateria.setEstatus("Desbloqueado");

				usuarioHasMateria.setData(new Date());

				usuarioHasMateria.setSolicitacao("a");

				id.setMateriaIdMateria(materia2.getIdMateria());

				id.setUsuarioIdUsuario(usuario.getIdUsuario());

				//usuarioHasMateria.setMateria(materia2);
				//usuarioHasMateria.setUsuario(usu);
				usuarioHasMateria.setId(id);

				session.merge(usuarioHasMateria);

				t.commit();
				SessionUtil.addSuccessMessage("OperacaoSucesso");
				// limpa objeto materia para novas insercoes
				materia2 = new Materia();
				usuarioHasMateria = new UsuarioHasMateria();

			} catch (Exception e) {
				// se algo errado ocorrer cancela a trasacao
				t.rollback();
				SessionUtil.addErrorMessage("OperacaoFracasso");
			}

		}

		session.close();

		return null;

	}

	public String salvarHasMateriaDes() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	



		usuarioHasMateria2 =  (UsuarioHasMateria) objTabelaMateria2.getRowData();

		materia2 = usuarioHasMateria2.getMateria();

		//HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		//Usuario usu = (Usuario) session2.getAttribute("currentUser");


		try {

			UsuarioHasMateriaId id = new UsuarioHasMateriaId();

			id.setMateriaIdMateria(materia2.getIdMateria());

			id.setUsuarioIdUsuario(usuario.getIdUsuario());

			Date dataDesbloqueio = new Date();

			usuarioHasMateria.setData(dataDesbloqueio);

			usuarioHasMateria.setEstatus("Desbloqueado");
			usuarioHasMateria.setId(id);

			session.merge(usuarioHasMateria);

			t.commit();
			SessionUtil.addSuccessMessage("OperacaoSucesso");
			// limpa objeto materia para novas insercoes
			materia2 = new Materia();
			usuarioHasMateria = new UsuarioHasMateria();

		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}


		return null;

	}

	public String salvarHasMateriaBlo() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	



		usuarioHasMateria2 =  (UsuarioHasMateria) objTabelaMateria2.getRowData();

		materia2 = usuarioHasMateria2.getMateria();

		//HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		//Usuario usu = (Usuario) session2.getAttribute("currentUser");


		try {

			UsuarioHasMateriaId id = new UsuarioHasMateriaId();

			id.setMateriaIdMateria(materia2.getIdMateria());

			id.setUsuarioIdUsuario(usuario.getIdUsuario());

			usuarioHasMateria.setData(new Date());
			usuarioHasMateria.setEstatus("Bloqueado");
			usuarioHasMateria.setId(id);

			session.merge(usuarioHasMateria);

			t.commit();
			SessionUtil.addSuccessMessage("OperacaoSucesso");
			// limpa objeto materia para novas insercoes
			materia2 = new Materia();
			usuarioHasMateria = new UsuarioHasMateria();

		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}


		return null;

	}


	public void salvarHasMateriaBloParam(UsuarioHasMateria materiaTemp) throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	


		try {


			materiaTemp.setEstatus("Bloqueado");


			session.merge(materiaTemp);

			t.commit();
			SessionUtil.addSuccessMessage("OperacaoSucesso");

		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}


	}

	public String salvarHasMateriaSolicitacao() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	

		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		//Usuario usu = (Usuario) session2.getAttribute("currentUser");

		Criteria q = session.createCriteria(UsuarioHasMateria.class);
		q.add(Restrictions.and(Restrictions.eq("id.materiaIdMateria", materiaEdit.getIdMateria()), Restrictions.eq("id.usuarioIdUsuario", usuario.getIdUsuario())));

		List<UsuarioHasMateria> objeto2 = q.list();

		try {

			if(objeto2.get(0).getSolicitacao().equalsIgnoreCase("a"))
			{
				UsuarioHasMateria usuarioHasMateria  = objeto2.get(0);

				usuarioHasMateria.setSolicitacao("t");

				session.merge(usuarioHasMateria);

				t.commit();
				SessionUtil.addSuccessMessage("Solicitacao");
				// limpa objeto materia para novas insercoes

				usuarioHasMateria = new UsuarioHasMateria();

			}
			else
			{
				SessionUtil.addErrorMessage("SolicitacaoJa");
			}

		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}

		return null;

	}

	public String salvarHasMateriaSolicitacaoOk() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 
		Transaction t = session.beginTransaction();	

		UsuarioHasMateria usuarioHasMateria  = (UsuarioHasMateria) objTabelaMateria2.getRowData();


		try {


			if(usuarioHasMateria.getMateria().getNomeDoArquivo().equalsIgnoreCase(""))
			{

				SessionUtil.addErrorMessage("VideoNaoInserido");


			}
			else
			{
				usuarioHasMateria.setSolicitacao("c");

				session.merge(usuarioHasMateria);

				t.commit();
				SessionUtil.addSuccessMessage("Solicitacao");
				// limpa objeto materia para novas insercoes

				usuarioHasMateria = new UsuarioHasMateria();
			}


		} catch (Exception e) {
			// se algo errado ocorrer cancela a trasacao
			t.rollback();
			SessionUtil.addErrorMessage("OperacaoFracasso");
		}finally{
			//fecha conexao
			session.close();

		}


		return null;

	}


	public String selecionarAudio() throws IllegalStateException {

		return "funcAud";


	}

	public String selecionarVideo() throws IllegalStateException {

		return "funcVid";


	}

	public String selecionarImpresso() throws IllegalStateException {

		return "funcImp";


	}

	public String selecionarMateria(){

		String veiculo = "", pagina="";

		veiculo = materia.getVeiculo();

		if(veiculo.equalsIgnoreCase("Audio"))
		{
			pagina = "funcAud";
		}
		else if(veiculo.equalsIgnoreCase("Video"))
		{
			pagina = "funcVid";
		}
		else if(veiculo.equalsIgnoreCase("Impresso"))
		{
			pagina = "funcImp";
		}

		return pagina;

	}

	public String trocar() throws IllegalStateException {

		return "trocar";

	}

	public String atualizar() throws IllegalStateException {

		return null;

	}

	public void bloqueioMensal(){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();

		Calendar c = Calendar.getInstance();

		c.add(Calendar.MONTH, -1);

		Date dataFinal = c.getTime();

		c.add(Calendar.YEAR, -2);

		Date dataInicial = c.getTime();

		Criteria q = session.createCriteria(UsuarioHasMateria.class);
		q.add(Restrictions.and(Restrictions.eq("estatus", "Desbloqueado"), Restrictions.between("data", dataInicial, dataFinal)));


		List<UsuarioHasMateria> objeto2 = q.list();


		for(int i = 0;i<objeto2.size();i++)
		{

			UsuarioHasMateria materiaTemp = objeto2.get(i);

			salvarHasMateriaBloParam(materiaTemp);


		}




	}

	public int solicitacao(){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();

		Criteria q = session.createCriteria(UsuarioHasMateria.class);
		q.add(Restrictions.eq("solicitacao", "t"));

		List<UsuarioHasMateria> objeto2 = q.list();

		session.close();

		return objeto2.size();

	}

	public List<Materia> materiaBuscaInteira(Materia materiaBusca,Date dataInicial,Date dataFinal){

		Session session = HibernateUtil.getSession();
		tabelaVazia="";
		Criteria q = session.createCriteria(Materia.class);
		q.add(Restrictions.and(Restrictions.between("data", dataInicial, dataFinal), Restrictions.like(materiaBusca.getExtensao(), materiaBusca.getAssunto(), MatchMode.ANYWHERE )));
		q.add(Restrictions.like("veiculo", materiaBusca.getVeiculo(), MatchMode.ANYWHERE ));
		q.addOrder(Order.desc("data"));

		List<Materia> objeto = q.list();

		if(objeto.isEmpty())
		{
			tabelaVazia="Nenhum resultado foi encontrado com essas especificações.";
		}

		session.close();

		return objeto;


	}

	public List<Materia> buscarForgId(Integer id, Materia materiaBusca,Date dataInicial,Date dataFinal){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		setTabelaVazia("");
		Criteria q = session.createCriteria(UsuarioHasMateria.class);

		q.add(Restrictions.and(Restrictions.eq("estatus", "Desbloqueado"), Restrictions.eq("id.usuarioIdUsuario", id)));

		List<UsuarioHasMateria> objeto2 = q.list();

		List<Integer> listaMateria2 = new ArrayList<Integer>();

		List<Materia> listaMateria = new ArrayList<Materia>();

		for(int i = 0;i<objeto2.size();i++)
		{

			listaMateria2.add(objeto2.get(i).getMateria().getIdMateria());


		}

		if(listaMateria2.isEmpty())
		{

		}
		else
		{
			Criteria materiaDesbloq = session.createCriteria(Materia.class);
			materiaDesbloq.add(Restrictions.and(Restrictions.and(Restrictions.in("id", listaMateria2), Restrictions.between("data", dataInicial, dataFinal)), Restrictions.like(materiaBusca.getExtensao(), materiaBusca.getAssunto(), MatchMode.ANYWHERE )));
			materiaDesbloq.add(Restrictions.like("veiculo", materiaBusca.getVeiculo(), MatchMode.ANYWHERE ));
			materiaDesbloq.addOrder(Order.desc("data"));

			listaMateria = materiaDesbloq.list();
		}

		if(listaMateria.isEmpty())
		{
			setTabelaVazia("Nenhum resultado foi encontrado com essas especificações.");
		}

		session.close();

		return listaMateria;

	}

	public List<UsuarioHasMateria> buscarForgIdBoss(Integer id, Materia materiaBusca,Date dataInicial,Date dataFinal){
		// Cria sessao com o banco
		Session session = HibernateUtil.getSession();
		setTabelaVazia2("");
		Criteria q = session.createCriteria(UsuarioHasMateria.class);

		q.add( Restrictions.eq("id.usuarioIdUsuario", id));

		List<UsuarioHasMateria> listaMateria = q.list();

		List<Integer> listaMateria2 = new ArrayList<Integer>();

		for(int i = 0;i<listaMateria.size();i++)
		{

			listaMateria2.add(listaMateria.get(i).getMateria().getIdMateria());


		}


		if(listaMateria2.isEmpty())
		{

		}
		else
		{

			Criteria materiaDesbloq = session.createCriteria(Materia.class);
			materiaDesbloq.add(Restrictions.and(Restrictions.and(Restrictions.in("id", listaMateria2), Restrictions.between("data", dataInicial, dataFinal)), Restrictions.like(materiaBusca2.getExtensao(), materiaBusca2.getAssunto(), MatchMode.ANYWHERE )));
			materiaDesbloq.add(Restrictions.like("veiculo", materiaBusca2.getVeiculo(), MatchMode.ANYWHERE ));
			materiaDesbloq.addOrder(Order.desc("data"));
			listaMateria.clear();

			List<Materia> listaMateria3 = materiaDesbloq.list();

			listaMateria2.clear();

			for(int i = 0;i<listaMateria3.size();i++)
			{

				listaMateria2.add(listaMateria3.get(i).getIdMateria());

			}

			if(listaMateria2.isEmpty())
			{

			}
			else
			{


				Criteria materiaHasFinal = session.createCriteria(UsuarioHasMateria.class);

				materiaHasFinal.add( Restrictions.and(Restrictions.in("id.materiaIdMateria", listaMateria2), Restrictions.eq("id.usuarioIdUsuario", id)));
				materiaHasFinal.addOrder(Order.desc("id.materiaIdMateria"));
				listaMateria = materiaHasFinal.list();

			}

		}

		if(listaMateria.isEmpty())
		{
			setTabelaVazia2("Nenhum resultado foi encontrado com essas especificações.");
		}

		session.close();
		return listaMateria;
	}

	public List<UsuarioHasMateria> buscarSolicitacao() throws IllegalStateException {
		// cria sessao com banco e transacao
		Session session = HibernateUtil.getSession(); 


		Criteria q = session.createCriteria(UsuarioHasMateria.class);
		q.add(Restrictions.eq("solicitacao", "t"));


		List<UsuarioHasMateria> objeto2 = q.list();


		return objeto2;

	}

	public void countryLocaleCodeChanged(ValueChangeEvent e){



	}

	public String irParaLiberar(){

		for(int i = 0;i<usuariosLiberados.length;i++)
		{
			usuariosLiberados[i]=0;
		}

		materia2 =  (Materia) objTabelaMateria.getRowData();

		return "lib";

	}

	public String salvarLiberarHasMateria() throws IllegalStateException {

		// cria sessao com banco e transacao
		Session session; 
		Transaction t;	

		UsuarioBean usuarioRepo = new UsuarioBean();

		int usuarioLiberado = 0;		

		for(int i=0;i<usuariosLiberados.length;i++)
		{
			try {

				usuarioLiberado = usuariosLiberados[i];

				// cria sessao com banco e transacao
				session = HibernateUtil.getSession(); 
				t = session.beginTransaction();	

				usuario = usuarioRepo.buscarId(usuarioLiberado).get(0);

				UsuarioHasMateriaId id = new UsuarioHasMateriaId();

				usuarioHasMateria.setEstatus("Desbloqueado");

				usuarioHasMateria.setData(new Date());

				usuarioHasMateria.setSolicitacao("a");

				id.setMateriaIdMateria(materia2.getIdMateria());

				id.setUsuarioIdUsuario(usuario.getIdUsuario());

				//usuarioHasMateria.setMateria(materia2);
				//usuarioHasMateria.setUsuario(usu);
				usuarioHasMateria.setId(id);

				session.merge(usuarioHasMateria);
				t.commit();

				// limpa objeto materia para novas insercoes
				usuario = new Usuario();
				usuarioHasMateria = new UsuarioHasMateria();
				session.close();
			} catch (Exception e) {

				SessionUtil.addSuccessMessage("OperacaoFracasso");
				return "ret";
			}

		}


		SessionUtil.addSuccessMessage("OperacaoSucesso");



		materia2 = new Materia();

		return "ret";

	}

	public List<SelectItem> getUsuarioNome(){

		UsuarioBean usuarioBean = new UsuarioBean();


		listaCombobox.clear();

		SelectItem  s2 = new SelectItem();
		s2.setValue(-1);    
		s2.setLabel("");    
		listaCombobox.add(s2);

		List<Usuario> clientes = usuarioBean.buscarPerfil("cliente");  

		for  (Usuario c : clientes){    
			SelectItem  s = new SelectItem();    
			s.setValue(c.getIdUsuario());    
			s.setLabel( c.getNomeUsuario());    
			listaCombobox.add(s);    


		}


		return listaCombobox;  

	}

	public List<SelectItem> getTipoVeiculo(){

		listaCombobox.clear();

		String veiculo = "", type="";

		veiculo = item.getContentType();

		type=veiculo;

		if(veiculo.length()>2)
		{
			veiculo = veiculo.substring(0, 3);
		}


		if(veiculo.equalsIgnoreCase("aud"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Audio");    
			s.setLabel("Audio");    
			listaCombobox.add(s); 
		}

		else if(veiculo.equalsIgnoreCase("ima"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Impresso");    
			s.setLabel("Impresso");    
			listaCombobox.add(s); 
		}

		else if(veiculo.equalsIgnoreCase("vid"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Video");    
			s.setLabel("Video");    
			listaCombobox.add(s); 
		}

		else if(type.endsWith("word"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Impresso");    
			s.setLabel("Impresso");    
			listaCombobox.add(s); 
		} 

		else if(type.endsWith("document"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Impresso");    
			s.setLabel("Impresso");    
			listaCombobox.add(s); 
		} 

		else if(type.endsWith("pdf"))
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Impresso");    
			s.setLabel("Impresso");    
			listaCombobox.add(s); 
		} 

		else
		{
			SelectItem  s = new SelectItem();    
			s.setValue("Audio");    
			s.setLabel("Audio");    
			listaCombobox.add(s); 
			s = new SelectItem();    
			s.setValue("Impresso");    
			s.setLabel("Impresso");    
			listaCombobox.add(s); 
			s = new SelectItem();    
			s.setValue("Video");    
			s.setLabel("Video");    
			listaCombobox.add(s); 
		}





		return listaCombobox;  

	}

	public List<UsuarioHasMateria> getHasMateriaForgIdBoss() {
		hasMateriaForgIdBoss = buscarForgIdBoss(usuario.getIdUsuario(), materiaBusca2, dataInicial2, dataFinal2);
		return hasMateriaForgIdBoss;
	}

	public void setHasMateriaForgIdBoss(List<UsuarioHasMateria> hasMateriaForgIdBoss) {
		this.hasMateriaForgIdBoss = hasMateriaForgIdBoss;
	}

	public List<UsuarioHasMateria> getSolicitacaoVideo() {
		solicitacaoVideo = buscarSolicitacao();
		return solicitacaoVideo;
	}

	public void setSolicitacaoVideo(List<UsuarioHasMateria> solicitacaoVideo) {
		this.solicitacaoVideo = solicitacaoVideo;
	}


	public List<Materia> getHasMateriaForgId() {
		HttpSession session2 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		//Usuario usu = (Usuario) session2.getAttribute("currentUser");
		hasMateriaForgId = buscarForgId(usuario.getIdUsuario(), materiaBusca, dataInicial, dataFinal);
		return hasMateriaForgId;
	}

	public void setHasMateriaForgId(List<Materia> hasMateriaForgId) {
		this.hasMateriaForgId = hasMateriaForgId;
	}

	public UploadItem getItem() {
		return item;
	}

	public void setItem(UploadItem item) {
		this.item = item;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Materia> getLista() {
		lista = materiaBuscaInteira(materiaBusca, dataInicial, dataFinal);
		return lista;
	}


	public void setLista(List<Materia> lista) {
		this.lista = lista;
	}

	public UIData getObjTabelaMateria() {
		return objTabelaMateria;
	}

	public void setObjTabelaMateria(UIData objTabelaMateria) {
		this.objTabelaMateria = objTabelaMateria;
	}

	public UsuarioHasMateria getUsuarioHasMateria() {
		return usuarioHasMateria;
	}

	public void setUsuarioHasMateria(UsuarioHasMateria usuarioHasMateria) {
		this.usuarioHasMateria = usuarioHasMateria;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Materia getMateriaBusca() {
		return materiaBusca;
	}

	public void setMateriaBusca(Materia materiaBusca) {
		this.materiaBusca = materiaBusca;
	}

	public UIData getObjTabelaMateria2() {
		return objTabelaMateria2;
	}

	public void setObjTabelaMateria2(UIData objTabelaMateria2) {
		this.objTabelaMateria2 = objTabelaMateria2;
	}

	public Materia getMateriaBusca2() {
		return materiaBusca2;
	}

	public void setMateriaBusca2(Materia materiaBusca2) {
		this.materiaBusca2 = materiaBusca2;
	}

	public Date getDataInicial2() {
		return dataInicial2;
	}

	public void setDataInicial2(Date dataInicial2) {
		this.dataInicial2 = dataInicial2;
	}

	public Date getDataFinal2() {
		return dataFinal2;
	}

	public void setDataFinal2(Date dataFinal2) {
		this.dataFinal2 = dataFinal2;
	}

	public Materia getMateriaEdit() {
		return materiaEdit;
	}

	public void setMateriaEdit(Materia materiaEdit) {
		this.materiaEdit = materiaEdit;
	}

	public String getTabelaVazia() {
		return tabelaVazia;
	}

	public void setTabelaVazia(String tabelaVazia) {
		this.tabelaVazia = tabelaVazia;
	}

	public String getTabelaVazia2() {
		return tabelaVazia2;
	}

	public void setTabelaVazia2(String tabelaVazia2) {
		this.tabelaVazia2 = tabelaVazia2;
	}

	public Integer[] getUsuariosLiberados() {
		return usuariosLiberados;
	}


	public void setUsuariosLiberados(Integer[] usuariosLiberados) {
		this.usuariosLiberados = usuariosLiberados;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

}