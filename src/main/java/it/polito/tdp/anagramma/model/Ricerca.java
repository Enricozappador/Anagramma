package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ricerca {
	
	private List<String> soluzione; 	
	

	public List<String> anagrammi(String parola) {
		parola=parola.toUpperCase();
		this.soluzione = new ArrayList<String>();
		List<Character> disponibili = new ArrayList<>(); 
		for (int i = 0; i< parola.length(); i++){
			disponibili.add(parola.charAt(i));
		}
		
		cerca("", 0, disponibili); 
		return this.soluzione; 
          }
	
	public void cerca (String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size()==0) { 
			
			this.soluzione.add(parziale);
			
		}
		else {
			for(Character ch : disponibili) {
				String tentativo = parziale + ch ; 
				
				List<Character> rimanenti = new ArrayList<>(disponibili); 
				rimanenti.remove(ch); 
				cerca(tentativo, livello+1, rimanenti); 
				
			}
		}
		
	}
}
