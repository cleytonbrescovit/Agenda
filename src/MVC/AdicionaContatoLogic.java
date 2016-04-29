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

public class AdicionaContatoLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{		
		return ("WEB-INF/jsp/adicionacontato.jsp");
	}
}
