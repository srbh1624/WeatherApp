package com.mainlogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class DataFetching
 */
@WebServlet("/DataFetching")
public class DataFetching extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataFetching() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Cityname = request.getParameter("location");
		System.out.println(Cityname);

		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + Cityname
				+ "&appid=ed3a227540df55f856b0d646a6369dee&units=metric");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		BufferedReader Output = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuffer responsefromapi = new StringBuffer();
		while (null != (line = Output.readLine())) {
			responsefromapi.append(line);
		}

		System.out.println(responsefromapi.toString());
		try {
			JSONObject myresponse = new JSONObject(responsefromapi.toString());
			JSONObject mainvalue = myresponse.getJSONObject("main");
			String temp = mainvalue.getString("temp");
			request.setAttribute("Temperature", temp);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
