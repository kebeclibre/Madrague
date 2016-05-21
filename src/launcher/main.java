package launcher;

import madrague.BrigitteBardot;
import madrague.Chat;
import madrague.Chien;
import madrague.Madrague;

public class main {

	public static void main(String[] args) {
		Madrague ma = new Madrague();
		BrigitteBardot bb = new BrigitteBardot();
		
		Chien chien = new Chien();
		Chat chat = new Chat();
		
		bb.addAnimal(chien);
		bb.addAnimal(chat);
		
		Chien chien2 = new Chien();
		Chat chat2 = new Chat();
		System.out.println(bb.getAllAnimals());
		
		bb.addAnimal(chien2);
		bb.addAnimal(chat2);
		System.out.println(bb.getAllAnimals());
		
		System.out.println(bb.getLists());
	}

}
