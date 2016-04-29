package MVC;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Dao.ContatoDao;
import Model.Contato;

public class AdicionaContatoNewLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
	           
	    PrintWriter out = res.getWriter();
	    String nome = req.getParameter("nome");
	    String endereco = req.getParameter("endereco");
	    String email = req.getParameter("email");
	    String dataEmTexto = req.getParameter("dataNascimento");
	    Calendar dataNascimento = null;
	    
	    try {
		    Date date = new SimpleDateFormat("dd/MM/yy").parse(dataEmTexto);
		    dataNascimento = Calendar.getInstance();
		    dataNascimento.setTime(date);
	    } catch (ParseException e) {
	    	out.println("Erro de conversão da data");
	    }
	    
	    Contato contato = new Contato();
	    contato.setNome(nome); 
	    contato.setEndereco(endereco);
	    contato.setEmail(email); 
	    contato.setDataNascimento(dataNascimento); 
	    
	    ContatoDao dao = new ContatoDao();
	    
	    dao.adiciona(contato);
	    
	    return "mvc?logica=ListaContatoLogic";
	}
}
