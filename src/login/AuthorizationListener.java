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
//armazenando a p�gina que fez a requisi��o. (a string da p�g. atual ex: "/pag.jsf")
boolean isLoginPage = (currentPage.lastIndexOf("/contromidia.jsp") > -1);
boolean isSobre = (currentPage.lastIndexOf("/empresa.jsp") > -1);

boolean isAudio = (currentPage.lastIndexOf("/funcionarioaudio.jsp") > -1);
boolean isVideo = (currentPage.lastIndexOf("/funcionariovideo.jsp") > -1);

if(isAudio || isVideo){
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", new UsuarioBean());
}
//fazendo a verifica��o mais b�sica de todas... se � a p�gina de login.
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//adquirindo a sess�o (essa mesma onde voc� dever� guardar seu usu�rio no n�vel de sess�o com descritor currentUser).
Usuario user = (Usuario) session.getAttribute("currentUser");
//apenas recuperando o valor da sess�o.



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
//bem, se n�o est� logado redireciona pra l�gica que (navigatio rule) atende a loginPage
} else {
//verificar se o usuario atual tem acesso a p�gina atual.

boolean temAcesso=false;

try {
	temAcesso = user.temAcesso(currentPage, user.getPerfil());
} catch (Exception e) {
	temAcesso=false;
}


if (temAcesso){
	
	
}
else {
	
	//aqui a logica de n�o ter acesso... redicione novamente? fa�a algo... ???
	NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
	nh.handleNavigation(facesContext, null, "login");
	
}
}
//caso contr�rio o jsf passa tranquilamente por aqui!!!

}


public void beforePhase(PhaseEvent event) {

}

public PhaseId getPhaseId() {
return PhaseId.RESTORE_VIEW;
}
}