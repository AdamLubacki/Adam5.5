package com.lubackiadam.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dbName = "jdbc:postgresql://localhost/SpringMvc";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "postgres"; 

        try{
        PrintWriter out = response.getWriter();
        out.println("Ladowanie...... ");
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbName, userName, password);
        out.println("zaladowano !!!!! ");
        //System.out.println("got conection");
        con.close();
        }catch(SQLException e){
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}