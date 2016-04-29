package MVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Contato;

public class AlteraContatoLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();			
        
        contato.setId(id);
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		
		//contato.setDataNascimento(????????);		
		
		System.out.println(req.getParameter("dataNascimento"));
	    
		req.setAttribute("contato", contato);
		return "/WEB-INF/jsp/alteracontato.jsp";
	}
}
