package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Result;
import model.GasStation;


@WebServlet("/score")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Controller() {}
    
     
         
/*DO GET*/    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Result result = new Result();
		/*picking up parameters from selection.jsp*/
		String currency = "PLN";
		String station;	
		String price = "4,10";
		String address = "Warszawska 154";
		String date = "14/10/2017";		
		String fuel = request.getParameter("fuel");
		// int rate = result.getRate(Result.SELECT_RATE);
		
		result.setFuelType(fuel);
		
		request.setAttribute("result", result.getResultList(Result.SELECT_ALL));
		
		result.getIdStation(Result.SELECT_CHEAPEST);
		request.setAttribute("idStation", result.getId());
		request.setAttribute("fuel", fuel.toUpperCase());
		request.setAttribute("station", result.getStationBrand());
		request.setAttribute("currency", currency);
		request.setAttribute("price", result.getPrice());
		request.setAttribute("address", result.getAddress());
		request.setAttribute("date", result.getDate());
		request.setAttribute("rate", result.getRate());
		
		System.out.println(result.getStationBrand());

		
		
		
		
		/*request.setAttribute("lower", result.getResultList(Result.SELECT_LOWEST_PRICE).get(1));*/
		
	
				
		/*transfer parameters to Selector.class*/					
		/*setting attributes in chart.jsp*/
		/*request.setAttribute("values", values);		*/
		/*request.setAttribute("chartType", chart);				
		request.setAttribute("dateFrom", dateFrom);
		request.setAttribute("dateTo", dateTo);*/
				
		/*print out*/
		

		
/*DISPATCHER*/				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("fuel.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
