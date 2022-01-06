package day_01;

import java.util.stream.IntStream;

public class Lambda05 {

	public static void main(String[] args) {

	}

	// TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e
	// kadar tamsayilari toplayan bir program yaziniz.
	// Structured Programming
	public static int topla(int x) {
		int toplam = 0;
		for (int i = 0; i <= x; i++) {
			toplam += i;
		}
		return toplam;
	}

	// Functional Programming
	public static int topla1(int x) {

		return IntStream.range(1, x + 1).// 1 2 3 ... x elemanarinin akýsý
				sum();
	}

	// TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
	public static int toplaCift(int x) {

		return IntStream.rangeClosed(1, x).// 1 2 3 ... x elemanarinin akýsý
		// filter(Lambda01::ciftBul).//2 4 6 ... elaman akýsý
				filter(t -> t % 2 == 0).// 2 4 6 ... elaman akýsý
				sum();
	}

	// TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz

	public static int toplaIlkTek(int x) {

		return IntStream.iterate(1, t -> t + 2).// 1 3 5 ... x elemanarinin akýsý
				limit(x).// akýsdaki ilk x elamaný verir
				sum();// akýsdaki ilk x elamaný toplar
	}

	// TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz--> 2 4 8
	// 16
	public static void ikiIlkXkuvvet(int x) {

		IntStream.iterate(2, t -> t * 2).// 2 4 8 16 32 x elemanarinin akýsý
				limit(x).// akýsdaki ilk x elamaný verir
				forEach(Lambda01::printEl);
	}

	// TASK 08 --> Istenilen bir sayinin x. kuvvetini ekrana yazdiran programi
	// yaziniz
	public static int istenenSayiniXincikuvvet(int a, int x) {

		return IntStream.iterate(a, t -> t * a).// a a^2 a^3 a^4... x elemanarinin akýsý
				limit(x).// akýsdaki ilk x elamaný verir
				reduce(0, (t, u) -> u);
		// skip(x-1);//skip den sonra cýkan elemanlarý toList ile yazdirilmali
	}

}
