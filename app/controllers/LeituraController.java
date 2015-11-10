package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

import logicaMetereologia.Logica;
import models.Leitura;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class LeituraController extends Controller {

	// lerValores
	public static Result show() {

		List<Leitura> todos = Leitura.find.all();
		Collections.reverse(todos);
		List<Leitura> lastLeituras = new ArrayList<Leitura>();
		Leitura lastLeitura = null;
		Leitura lastButOneLeitura = null;
		if (todos.size() >= 2) {
			lastLeituras = todos.subList(0, 2);
			lastLeitura = lastLeituras.get(0);
			lastButOneLeitura = lastLeituras.get(1);
		}
		Logica logica = new Logica();
		String cidade = "Francisco Beltrão";
		double nivelRio = logica.nivelRio(lastLeitura);
		Date date = new Date();
		String data = new SimpleDateFormat("dd-MM-yyyy").format(date);
		String previsao = logica.metereologia(lastButOneLeitura, lastLeitura);
		return ok(index.render(cidade, data, lastLeitura, previsao, nivelRio));
	}

	// receberValores
	// gravarValores
	public static Result save(String temperatura, String pressao,
			String umidade, String distancia) {
		// final Map<String, String[]> values = request().body()
		// .asFormUrlEncoded();
		//
		// String pressaoAt = values.get("pressaoAt")[0];
		// String temperatura = values.get("temperatura")[0];
		// String umidade = values.get("umidade")[0];
		// String distancia = values.get("distancia")[0];

		Leitura leitura = new Leitura();
		leitura.pressaoAt = (Double.parseDouble(pressao));
		leitura.temperatura = (Double.parseDouble(temperatura));
		leitura.umidade = (Double.parseDouble(umidade));
		leitura.distancia = (Double.parseDouble(distancia));

		leitura.save();
		// Implementar evento de tempo no arduino para envio
		return ok("Ok");
	}
}