package logicaMetereologia;

import models.Leitura;

public class Logica {

	public String metereologia(Leitura leituraOld, Leitura leituraNew) {
		String msg = "";
		if (leituraOld.pressaoAt < leituraNew.pressaoAt) {
			if (leituraOld.temperatura < leituraNew.temperatura) {
				msg = "TEMPO BOM, COM VENTOS SECOS E QUENTES";
			} else if (leituraOld.temperatura > leituraNew.temperatura) {
				msg = "TEMPO BOM, COM VENTO SUL E SUDESTE FRIOS";
			} else {
				msg = "TEMPO BOM, COM VENTO LESTE MENOS QUENTES";
			}
		} else if (leituraOld.pressaoAt > leituraNew.pressaoAt) {
			if (leituraOld.temperatura < leituraNew.temperatura) {
				msg = "TEMPO INSTÁVEL, COM PROBABILIDADE DE APROXIMAÇÃO DE FRENTE";
			} else if (leituraOld.temperatura > leituraNew.temperatura) {
				msg = "CHUVAS E VENTOS FORTES";
			} else {
				msg = "APROXIMAÇÃO DE FRENTE QUENTE, COM PROBABILIDADE DE CHUVAS";
			}
		} else {
			if (leituraOld.temperatura < leituraNew.temperatura) {
				msg = "MUDANÇA PARA TEMPO BOM, COM VENTO LESTE";
			} else if (leituraOld.temperatura > leituraNew.temperatura) {
				msg = "PROBABILIDADE DE CHUVA, COM VENTOS SUL E SUDESTE";
			} else {
				msg = "TEMPO INCERTO";
			}
		}
		return msg;
	}

	public double nivelRio(Leitura leituraNew) {
		double distanciaPadrao = 400;
		double porc;
		porc = leituraNew.distancia - 200 / distanciaPadrao;
		
		return porc;
	}
}
