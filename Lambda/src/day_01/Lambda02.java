package day_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -68, 42, 15));
		// List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz
//		CiftBulCarp1(list);// Optional[-25635456]
//		CiftBulExpression(list);// 25635456
////		EnKucuk(list);// Optional[-68]
		//EnKucuk4(list);//Optional[-68]
		//OnbestenBuyuk(list);//65
		CiftElKareSirala (list);
	}

	public static void ciftKareMax(List<Integer> list) {
		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

	}
	// Listteki tüm elemanlarin toplamini yazdiriniz

	public static void ToplaEleman1(List<Integer> list) {

		Optional<Integer> toplam = list.stream().reduce((t, u) -> t + u);
		// t herzaman ilk degerini atanan degerden (0) alir
		// u herzaman degerini list,stream() den alir
		// t ilk degerden sonraki degerlerini islemden alir

		System.out.println(toplam);
	}
	// Listteki tüm elemanlarin toplamini yazdirin
	// methot referanca ile

	public static void ToplaEleman2(List<Integer> list) {
		Optional<Integer> toplam = list.stream().reduce(Integer::sum);
		// Optional<Integer> toplam = list.stream().reduce(Math::addExact);
		System.out.println(toplam);

	}

	// Listteki cift elemanlarin carpimini yazdirin.
	public static void CiftBulCarp1(List<Integer> list) {

		Optional<Integer> toplam = list.stream().filter(Lambda01::ciftBul).reduce((Math::multiplyExact));

		System.out.println(toplam);
	}

	// Lambda Expression yapalim
	// Listteki cift elemanlari yazdiriniz
	// Pozitif deger üretiniz

	public static void CiftBulExpression(List<Integer> list) {

		int carpim = list.stream().filter(Lambda01::ciftBul).reduce(-1, (t, u) -> (t * u)); // cikan sayinin pozitif
																							// olmasi icin -1 koyduk
		// Optionali java burada kendi istemedi. bir risk görmedi
		System.out.println(carpim);
	}

	// Listteki elemanlardan en kücügünü 4 farkli yöntemle yazdiriniz
	public static void EnKucuk(List<Integer> list) {

		Optional<Integer> enKucuk = list.stream().reduce(Integer::min);
		System.out.println(enKucuk);

	}

	// 2.yöntem
	public static void EnKucuk2(List<Integer> list) {

		Optional<Integer> enKucuk = list.stream().reduce(Math::min);
		System.out.println(enKucuk);
	}
	// 3.yöntem Methot reference
	public static int EnKucuk3(int x, int y) {
		
	return x<y ? x:y ; //ternery
	
	}
	public static void EnKucuk4(List<Integer> list) {
		
	Optional<Integer>	enKucuk =list.stream().reduce(Lambda02::EnKucuk3);
	System.out.println(enKucuk);
	
	}
	//Listteki 15ten büyük en kücük tek sayiyi yazdiriniz.
	
	public static void OnbestenBuyuk(List<Integer> list) {
	//Optional<Integer> onBes =	list.stream().filter(t->t%2==1).filter(t->t>15 ).reduce(Integer::min);
		System.out.println(
				list.
				stream().
				filter(t->t%2==1).
				filter(t->t>15).
				reduce(Integer::min));
		
	}
	
	//List cift elemanlarinin karelerini büyükten kücüge yazdiriniz
	public static void CiftElKareSirala (List<Integer> list) {
		
		list.stream().filter(Lambda01::ciftBul).map(t->(t*t)).sorted().forEach(t->System.out.println());
	}
	
	
	
////list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz
	public static void TekElKareSirala (List<Integer> list) {
		
		 list.
         stream().
         filter(t->t%2!=0).
         map(t->t*t).sorted(Comparator.reverseOrder()).//akýsa giren elelmanlar ters siralanir
        forEach(Lambda01::printEl);//144 484 1156 1764 3600
	}

}