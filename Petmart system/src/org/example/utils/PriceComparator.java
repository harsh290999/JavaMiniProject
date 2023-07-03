package org.example.utils;

import java.util.Comparator;

import org.example.domain.Pet;

public class PriceComparator  implements Comparator<Pet>{

	@Override
	public int compare(Pet o1, Pet o2) {
		return (int) (o1.getPrice()-o2.getPrice());
	}

}

