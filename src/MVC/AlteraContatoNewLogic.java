package MVC;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ContatoDao;
import Model.Contato;

public class AlteraContatoNewLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
			
		long id = Long.parseLong(req.getParameter("id"));
	    String nome = req.getParameter("nome");
	    String email = req.getParameter("email");
	    String endereco = req.getParameter("endereco");
	    String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
         
        } catch (java.text.ParseException e) {
        	System.out.println(e);
		}
	    
	    Contato contato = new Contato();
	    contato.setId(id);
	    contato.setNome(nome);
	    contato.setEmail(email);
	    contato.setEndereco(endereco);
	    contato.setDataNascimento(dataNascimento);
	    
	    ContatoDao contatos = new ContatoDao();
	    
	    contatos.altera(contato);
	    
		return "mvc?logica=ListaContatoLogic";
	}
}
