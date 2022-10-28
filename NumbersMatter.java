import java.util.Calendar;
import java.util.Date;
class Animal {

		static int animalCount = 0;
		
		public Animal() {
			animalCount++;
		}
		
		public int getAnimalCount() {
			return animalCount;
		}
}


class Duck extends Animal{

		static int duckCount = 0;
		
		public Duck() {
		duckCount++;
		}
		
		public int getDuckCount() {
			return duckCount;
		}
}

class Dog extends Animal{

	static int dogCount = 0;
	
	public Dog() {
	dogCount++;
	}
	
	public int getDogCount() {
		return dogCount;
	}
}

public class NumbersMatter {

	public static void main(String[] args) {

		Duck a = new Duck();
		System.out.println("Animal count:" + Animal.animalCount);
		System.out.println("Duck count:" + Duck.duckCount);
		System.out.println("Dog count:" + Dog.dogCount);
		System.out.println("");
		Dog b = new Dog();
		System.out.println("Animal count:" + Animal.animalCount);
		System.out.println("Duck count:" + Duck.duckCount);
		System.out.println("Dog count:" + Dog.dogCount);
		System.out.println("");
		Dog c = new Dog();
		System.out.println("Animal count:" + Animal.animalCount);
		System.out.println("Duck count:" + Duck.duckCount);
		System.out.println("Dog count:" + Dog.dogCount);
		
		
	}


}
