package principal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import module.Alumnado;
import module.Ciclo;


public class PruebasHashMap {

	public static void main(String[] args) {
		
		Alumnado riki = new Alumnado("12345678A", "riki", LocalDate.now(), Ciclo.DAM, false);

		HashMap<String, Alumnado> map = new HashMap<String, Alumnado>();
		
		map.put(riki.getNif(), riki);

		System.out.println("Opcion1:");
		for (Alumnado a : map.values()) {
			System.out.println(a.getNif());
		}

		System.out.println("Opcion2:");
		for (Map.Entry<String, Alumnado> entry : map.entrySet()) {
			System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue().getNif());
		}

	}

}