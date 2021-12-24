package day_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

	public static void main(String[] args) {

		/*
		 * 1) Lambda "Functional Programming" "Functional Programming" de
		 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
		 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
		 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
		 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
		 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
		 * map'lerde kullanýlmaz. Lambda kullanmak hatasýz code kullanmaktýr.
		 */

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
//		 printStructure(list);//12 13 65 3 7 34 22 60 42 55 
//		 System.out.println("");
//		 printFunktional(list);//12 13 65 3 7 34 22 60 42 55 
//	
//		printFunktional(list);//12 13 65 3 7 34 22 60 42 55 

//		printCiftElStructured1(list);// 12 34 22 60 42
//		System.out.println();
//
//		printCiftElFunction1(list);// 12 34 22 60 42

//		printCiftElFunction2(list);// 12 34 22 60 42
//		System.out.println();
//
//		printCiftAltmisKucuk(list); //12 34 22 42 
//		System.out.println();
//		
//		printTekElFunktion(list);//13 65 3 7 34 22 60 42 55 
		
//		printElCiftKare(list);//144 1156 484 3600 1764 
		
//		 printElTekKüp(list);//2198 274626 28 344 166376 
		
		printElCiftKarekok(list);
//		
//		3.4641016151377544 
//		5.830951894845301 
//		4.69041575982343 
//		7.745966692414834 
//		6.48074069840786 
		maxElfunction(list);//Optional[65]
		
	}
	// structured Programming ile List elemanlarinin tamamini yazdiriniz.

	public static void printStructure(List<Integer> List) {

		for (Integer w : List) {

			System.out.print(w + " ");

		}

	}

	// Funktional Programming ile list elemanlarinin tamamini aralarinda bosluk
	// birakarak yazdiriniz

	public static void printFunktional(List<Integer> list) {
		list.stream().forEach(t -> System.out.print(t + " "));// Lambda Expression

		// Stream: Bu method datalari yukaridan asagiya akis sekline getirir
		// forEach: datanin parametresine göre her bir elemani isler
		// t-> : Lambda operatörü

		// Lambda Expression yapisi cok tavsiye edilmez. daha cok Method Reference
		// kullanilir.

	}

	// Method Reference -> kendi creat ettigimiz veya javadan aldigimiz Method ile
	// Classname: :Methodname bu sekilde yazilir.EZBERLENECEK

	public static void printEl(int t) {// Refere edilecek Method creat edildi

		System.out.print(t + " ");

	}

	public static void printFunktional1(List<Integer> list) {

		list.stream().forEach(Lambda01::printEl);

	}

	// structured programming ile list elemanlarinin cift olanlarini ayni satirda
	// aralarinda bosluk birakarak yazdirin

	public static void printCiftElStructured1(List<Integer> list) {

		for (Integer w : list) {
			if (w % 2 == 0)
				System.out.print(w + " ");

		}
	}

	public static void printCiftElFunction1(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);

		// Filter() bir akis icerinde verilen ya da döndürülen elemanlari istenen sarta
		// göre filtreler.

	}

	public static boolean ciftBul(int i) {// refere edilecek methot creat edldi

		return i % 2 == 0;

	}

	public static void printCiftElFunction2(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);// iki tane method refere

	}

	// FunctionalPrograming ile list elemanlarinin 60dan kücük olanlarini ayni
	// satirda aralarinda bosluk olacak sekilde yazdirin

	public static void printCiftAltmisKucuk(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);
	}
	
	// FunctionalPrograming ile list elemanlarinin tek olanlarini veya 20den büyük olanlarini ayni
	// satirda aralarinda bosluk olacak sekilde yazdirin
	public static void printTekElFunktion(List<Integer> list) {
		
		list.stream().filter(t ->t>20 || t%2==1).forEach(Lambda01::printEl);
	}
	
	// FunctionalPrograming ile list elemanlarinin cift olanlarini karelerini ayni
		// satirda aralarinda bosluk olacak sekilde yazdirin
	
	public static void printElCiftKare(List<Integer> list) {
		
	list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
	
	
}
	
	// FunctionalPrograming ile list elemanlarinin tek olanlarini küplerinin bir fazlasini ayni
			// satirda aralarinda bosluk olacak sekilde yazdirin
	
	public static void printElTekKüp(List<Integer> list) {
		
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);
	}
	
	// FunctionalPrograming ile list elemanlarinin cift olanlarinin kareköklerini ayni
	// satirda aralarinda bosluk olacak sekilde yazdirin
	
	public static void printElCiftKarekok(List<Integer> list) {
	
	list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.println(t+" "));
	}	
	
	
	
	// Listin en büyük elemanini yazdirin 
	public static void maxElfunction(List<Integer> list) {
		
		Optional<Integer>maxEl=list.stream().reduce(Math::max);
		System.out.print(maxEl);
		//reduce metfodu azaltmak anlamina gelir. Bircok atayi tekbir dataya cevirmek icin kullanilir.(max-min-carpma vs. islemlemlerde)
	}
	
}