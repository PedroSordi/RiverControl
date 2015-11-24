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

import play.data.DynamicForm;
import play.data.Form;

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
	public static Result save() {
		DynamicForm form = Form.form().bindFromRequest();

		if (form.data().size() == 0) {
		  return badRequest("Expceting some data");
		} else {
				Leitura leitura = new Leitura();
				leitura.pressaoAt = (Double.parseDouble(form.get("pressure")));
				leitura.temperatura = (Double.parseDouble(form.get("temperature")));
				leitura.umidade = (Double.parseDouble(form.get("humidity")));
				leitura.distancia = (Double.parseDouble(form.get("distance")));

				leitura.save();
				// Implementar evento de tempo no arduino para envio
				return ok("Ok");
		}
	}
}
