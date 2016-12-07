package fcu.iecs.oop.pokemon;

import java.util.Random;

public class GYM {

	private static int one = 0, two = 0;

	public static Player fight(Player... players) {
		Random ran = new Random();
		Pokemon[] pkms1 = players[0].getPokemons();
		Pokemon[] pkms2 = players[1].getPokemons();
		int pkmscp1, pkmscp2;
		for (int i = 0; i < 3; i++) {
			if (pkms1[i].getType() == PokemonType.FIRE && pkms2[i].getType() == PokemonType.GRASS)
				one = one + 1;
			else if (pkms1[i].getType() == PokemonType.GRASS && pkms2[i].getType() == PokemonType.FIRE)
				two = two + 1;
			else if (pkms1[i].getType() == PokemonType.GRASS && pkms2[i].getType() == PokemonType.WATER)
				one = one + 1;
			else if (pkms1[i].getType() == PokemonType.WATER && pkms2[i].getType() == PokemonType.GRASS)
				two = two + 1;
			else if (pkms1[i].getType() == PokemonType.WATER && pkms2[i].getType() == PokemonType.FIRE)
				one = one + 1;
			else if (pkms1[i].getType() == PokemonType.FIRE && pkms2[i].getType() == PokemonType.WATER)
				two = two + 1;
			else if (pkms1[i].getType() == pkms2[i].getType()) {
				pkmscp1 = pkms1[i].getCp();
				pkmscp2 = pkms2[i].getCp();
				if (pkmscp1 > pkmscp2)
					one = one + 1;
				else if (pkmscp1 < pkmscp2)
					two = two + 1;
				else {
					if (ran.nextInt(100) % 2 == 1)
						one = one + 1;
					else
						two = two + 1;
				}
			}
		}
		if (one > two)
			return players[0];
		else
			return players[1];
	}
}
