package madrague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrigitteBardot {

	// Brigitte veut que ses animaux soient classés par Race dans son bureau
	private Map<String,List<? extends Animal>> cheptel = new HashMap<String,List<? extends Animal>>();
	private List<Chien> chiens = new ArrayList<Chien>(); // exemple d'animaux classés par race
	
	
	{ // on ajoute cette liste dans la HashMap, c'est pas joli en block, mais c'est court
		// Et en plus, la Race est directement prise depuis le type contenu dans la liste
		cheptel.put(chiens.getClass().getComponentType().getSimpleName(), chiens);
	}
	
	public String getAllAnimals() {
		StringBuffer sb = new StringBuffer();
		
		// Pour chaque race, on prend la liste d'animaux dedans
		for (Map.Entry<String, List<? extends Animal>> entryToProcess : cheptel.entrySet()) { 
			sb.append(entryToProcess.getKey());
		
			
			// chaque liste peut etre traitée de la même façon, et on est SÛRS de récupérer un animal 
			//quelle que soit la liste!!!!
			for (Animal animal : entryToProcess.getValue()) {
				sb.append(animal.toString());
			}
		}
		return sb.toString();
	}
	

}
