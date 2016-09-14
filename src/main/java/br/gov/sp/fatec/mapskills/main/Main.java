package br.gov.sp.fatec.mapskills.main;

import br.gov.sp.fatec.mapskills.mentor.Institution;

public class Main {
	
	public static void main(String[] args) {
		Institution fatec = new Institution("83237522000139", "Jessen Vidal", "São José");
		System.out.println(fatec.toString());
	}

}
