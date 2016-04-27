package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Dao.ContatoDao;
import Model.Contato;


@WebServlet("/adicionaContato")
public class AdicionaContato extends HttpServlet {
	private int contador = 0;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando Servlet.");
	}
	
	public void destroy(){
		super.destroy();
		log("Destruindo Servlet.");
	}	
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	contador++;
    	
        PrintWriter out = response.getWriter();
                        
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException | java.text.ParseException e) {
            out.println("Erro de conversão da data");
            return;
        }
        
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        
        
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() + " adicionado com sucesso");
        out.println("contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
		
	}
}
