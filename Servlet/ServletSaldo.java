package Servlet;

import To.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class ManterClienteController
* */
@WebServlet("/ManterCliente.do")
public class ServletSaldo extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String cAgencia = request.getParameter("agencia");
		String cConta = request.getParameter("conta");
		String cSenha = request.getParameter("senha");
		String cCodigo = request.getParameter("codigo");

		//String cAgencia, String cConta, String cSenha, String cCodigo

		Conta conta = new Conta(cAgencia, cConta, cSenha, cCodigo);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println( "Agencia: "+conta.getAgencia()+"<br>");
		out.println( "Conta: "+conta.getConta()+"<br>");
		out.println( "Senha: "+conta.getSenha()+"<br>");
		out.println( "Codigo: "+conta.getCodigo()+"<br>");
		out.println("</body></html>");
	}
	
}