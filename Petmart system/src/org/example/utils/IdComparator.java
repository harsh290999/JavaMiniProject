package org.example.utils;

import java.util.Comparator;

import org.example.domain.Pet;

public class IdComparator  implements Comparator<Pet>{

	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getPetId()-o2.getPetId();
	}

}
