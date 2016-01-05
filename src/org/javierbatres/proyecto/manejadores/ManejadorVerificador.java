package org.javierbatres.proyecto.manejadores;

public class ManejadorVerificador {
	private int nit;
	private String caracter;
	private int caracteres;
	private int ultimo;
	private int suma;
	private int cara;
	private boolean verdadero = false;
	//private String nits = "3894140-6";
	public void ValidarNit(String nits){
		caracteres = nits.length();
		ultimo = Integer.parseInt(nits.substring(nits.length()-1, nits.length()));
		System.out.println(ultimo);
		cara = caracteres;
		for(int i = 1; i <= nits.length()-2 ; i++){
			caracter = nits.substring(i-1 , i);
			cara = cara - 1;
			if(caracter != "-"){
				nit = Integer.parseInt(caracter);
				System.out.println(cara + "--" + caracter);
				suma += nit * cara;
			}
		}
		System.out.println(suma);
		suma = suma % 11;
		System.out.println(suma);
		suma = 11 - suma;
		System.out.println(suma);
		suma = suma % 11;
		System.out.println(suma);
		System.out.println(ultimo);
		if(suma == ultimo){
			verdadero = true;
			System.out.println("Si es verdadero");
		}else{
			System.out.println("No es verdadero");
		}
	}
}
