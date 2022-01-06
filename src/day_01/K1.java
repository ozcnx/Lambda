package day_01;

import java.util.stream.IntStream;

public class K1 {

	public static void main(String[] args) {
		
//		System.out.println(topla(10));//55
//		System.out.println(toplaF(10));//55
//		System.out.println(toplaCift1(10));
//		System.out.println(toplaIlkPozCift(10));
//		IkininXKuv(5);
//		System.out.println();
//		IstenenSayininXKuv(2,5);
//		System.out.println();
//		System.out.println(IstenenSayininXKuv2(2,4));
		System.out.println(IstenenSayininFaktoryeli(5));
	}
	// TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e
	// kadar
	// tamsayilari toplayan bir program yaziniz.

	public static int topla(Integer x) {
		int toplam = 0;
		for (int i = 0; i <= x; i++) {
			toplam += i;

		}

		return toplam;
	}
	public static int toplaF(Integer x) {
		
		
		return IntStream.range(0, x+1).sum();
		//IntStream.rangeClosed(0, x).sum(); burada x dahil oluyor +1 demeye gerek kalmaz
		
	}
	 //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
	public static int toplaCift(Integer x) {
		
		
		return IntStream.rangeClosed(1, x).filter(t->t%2==0).sum();
		
	}
	
	public static int toplaCift1(Integer x) {
		return 
				IntStream.
				iterate(2, t->t+2).
				limit(x).
				sum();
		
	}
	//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
	public static int toplaIlkPozCift(Integer x) {
		
		return IntStream.
				iterate(1, t->t+2).
				limit(x).
				sum();
		
		
	}
	
	//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz--> 2 4 8 16
	
	public static void IkininXKuv(Integer x) {
		
		IntStream.
		iterate(2, t->t*2).
		limit(x).
		forEach(t->System.out.print(t+" "));
		
		
	}
	//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
public static void IstenenSayininXKuv(Integer a, Integer x) {
		
		IntStream.
		iterate(a, t->t*a).
		limit(x).
		forEach(t->System.out.print(t+" "));
	
}
//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz

public static int IstenenSayininFaktoryeli(Integer x) {

	return	IntStream.rangeClosed(1, x).reduce(1, (t,u)->t*u);
	
}


//TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi yaziniz


public static int IstenenSayininXKuv2(Integer a, Integer x) {
	
	return 
			IntStream.
	iterate(a, t->t*a).
	limit(x).reduce(0,(t,u)->u);
	
}
}
