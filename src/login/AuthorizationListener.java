package login;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import controle.UsuarioBean;

import entidade.Usuario;

public class AuthorizationListener implements PhaseListener {

public void afterPhase(PhaseEvent event) {
FacesContext facesContext = event.getFacesContext();
//adiquirindo o FacesContext.
String currentPage = facesContext.getViewRoot().getViewId();
//armazenando a página que fez a requisição. (a string da pág. atual ex: "/pag.jsf")
boolean isLoginPage = (currentPage.lastIndexOf("/contromidia.jsp") > -1);
boolean isSobre = (currentPage.lastIndexOf("/empresa.jsp") > -1);

boolean isAudio = (currentPage.lastIndexOf("/funcionarioaudio.jsp") > -1);
boolean isVideo = (currentPage.lastIndexOf("/funcionariovideo.jsp") > -1);

if(isAudio || isVideo){
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", new UsuarioBean());
}
//fazendo a verificação mais básica de todas... se é a página de login.
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//adquirindo a sessão (essa mesma onde você deverá guardar seu usuário no nível de sessão com descritor currentUser).
Usuario user = (Usuario) session.getAttribute("currentUser");
//apenas recuperando o valor da sessão.



if(isLoginPage)
{
	Usuario user2 = null;
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", user2);
}

if(isSobre)
{
	
}
else if (!isLoginPage && user == null) {
NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
nh.handleNavigation(facesContext, null, "login");
//bem, se não está logado redireciona pra lógica que (navigatio rule) atende a loginPage
} else {
//verificar se o usuario atual tem acesso a página atual.

boolean temAcesso=false;

try {
	temAcesso = user.temAcesso(currentPage, user.getPerfil());
} catch (Exception e) {
	temAcesso=false;
}


if (temAcesso){
	
	
}
else {
	
	//aqui a logica de não ter acesso... redicione novamente? faça algo... ???
	NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
	nh.handleNavigation(facesContext, null, "login");
	
}
}
//caso contrário o jsf passa tranquilamente por aqui!!!

}


public void beforePhase(PhaseEvent event) {

}

public PhaseId getPhaseId() {
return PhaseId.RESTORE_VIEW;
}
}