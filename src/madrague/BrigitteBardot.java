package madrague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BrigitteBardot {

	// Brigitte veut que ses animaux soient classés par Race dans son bureau
	private Map<String,List<? extends Animal>> cheptel = new HashMap<String,List<? extends Animal>>();
	
	public String getAllAnimals() {
		StringBuffer sb = new StringBuffer();
		
		// Pour chaque race, on prend la liste d'animaux dedans
		for (Map.Entry<String, List<? extends Animal>> entryToProcess : cheptel.entrySet()) { 
			sb.append(entryToProcess.getKey());
			sb.append("s: ");
		
			
			// chaque liste peut etre traitée de la même façon, et on est SÛRS de récupérer un animal 
			//quelle que soit la liste!!!!
			for (Animal animal : entryToProcess.getValue()) {
				sb.append(animal.toString());
				sb.append("; ");
			}
			
			sb.append(" -- ");
		}
		sb.append(" // ");
		return sb.toString();
	}
	
	public <T extends Animal> void addAnimal(T a) {
		if (cheptel.containsKey(a.getClass().getSimpleName())) {
				// le compilateur fait un warning, il ne peut pas etre sur que ca va marcher
				// mais le programmeur oui, puisqu'il a fait un test pour ça
				List<T> ttype = (List<T>) cheptel.get(a.getClass().getSimpleName());
				ttype.add(a);
			} else {
				// On peut créer et ajouter au cheptel une liste de quelque chose qui étend animal, c'est à dire
				// pile poil le type de list contenu dans la Map cheptel
				List<T> ttype = new ArrayList<T>();
				ttype.add(a);
				cheptel.put(a.getClass().getSimpleName(), ttype);
			}
	}
	
	public String getLists() {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, List<? extends Animal>> lists : cheptel.entrySet()) {
			sb.append(lists.getKey());
			sb.append(" ");
			sb.append(lists.getValue().toString());
			sb.append(" // ");
		}
		return sb.toString();
	}

}
