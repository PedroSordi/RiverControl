package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

import models.Leitura;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class LeituraController extends Controller {

	// lerValores
	public static Result show() {

		List<Leitura> listaDados = Ebean.createQuery(Leitura.class).findList();

		return ok(index.render(listaDados));
	}

	// receberValores
	// gravarValores
	public static Result save() {
		final Map<String, String[]> values = request().body()
				.asFormUrlEncoded();

		String pressaoAt = values.get("pressaoAt")[0];
		String temperatura = values.get("temperatura")[0];
		String umidade = values.get("umidade")[0];
		String distancia = values.get("distancia")[0];

		Leitura leitura = new Leitura();
		leitura.pressaoAt = (Double.parseDouble(pressaoAt));
		leitura.temperatura = (Double.parseDouble(temperatura));
		leitura.umidade = (Double.parseDouble(umidade));
		leitura.distancia = (Double.parseDouble(distancia));

		leitura.save();
		// Implementar evento de tempo no arduino para envio
		return ok("Ok");
	}
}