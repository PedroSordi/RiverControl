package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Leitura extends Model {
	private static final long serialVersionUID = 1l;
	
	public static Model.Finder<Long, Leitura> find = new Model.Finder<>(Long.class, Leitura.class);
	
	@Id
	@GeneratedValue
	public long id;

	public double pressaoAt;
	public double temperatura;
	public double umidade;
	public double distancia;

	public Leitura() {
		super();
	}

	public Leitura(long id, double pressaoAt, double temperatura,
			double umidade, double distancia) {
		super();
		this.id = id;
		this.pressaoAt = pressaoAt;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.distancia = distancia;
	}

}
