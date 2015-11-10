package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class ClimaController extends Controller {
	private double pressaoAt;
	private double temperatura;
	
	public static Result previsaoTempo() {
		
		
		
		return ok("Ok");
	}	public static Result previsaoAlagamento() {
		
		return ok("ok");
	}


}
