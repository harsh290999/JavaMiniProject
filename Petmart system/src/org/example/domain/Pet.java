
package org.example.domain;

import java.util.Objects;

public class Pet implements Comparable<Pet>{
	private String species;
	private String breed;
	private String gender;
	private int age;
	private int petId;
	private float price;
	
	public Pet() {	}
	public Pet(String species, String breed, String gender,int age, int petId, float price) {
		this.species = species;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.petId = petId;
		this.price = price;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petid) {
		this.petId = petid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("%-15s%-20s%-15s%-10d%-10d%-10.2f",this.species,this.breed,this.gender,this.age,this.petId,this.price);
	}
	@Override
	public int compareTo(Pet o) {
			return this.petId-o.petId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(petId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return petId == other.petId;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return super.equals(obj);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if( obj != null ) {
//			Book other = (Book) obj;
//			if( this.petid == other.petid )
//				return true;
//		}
//		return false;
//	}
	
}
