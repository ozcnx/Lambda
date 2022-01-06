package day_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

	public static void main(String[] args) {
		
	List<String> list=new ArrayList<String>
	(Arrays.asList("mehmet","emre","nilgun","yýldýz","kader","emine"
			,"islam","islam","emre","zülfikar", "william"));	
		
	
	//AlfabetikBuyukHarf (list);
	//KarakterSayisiTers (list);
	
	//KarakterSayisiKucuktenBuyuge (list);
	//SonHarfTersten ( list);
	//CiftKarakterTekrarli(list);
//	HarfSayisiYediKontrol (list);
//	WileBaslamaDurumu (list);
//	KarakterSayisiEnBuyuk (list);
//	KarakterSayisiEnBuyuk2 (list);
	 ilkElemanHaricKalanlarPrint (list);
	}
	
	//list elemanlarini alfabetik büyük harf sirasiyla ve tekrarsiz yazdiriniz
	
	public static void AlfabetikBuyukHarf (List<String> list) {
		
	list.
	stream().//akisa girdi
	map(t->t.toUpperCase()).//büyük harf yapildi
	sorted().//alfabetik siralandi
	distinct().//tekrarsiz yapildi
	forEach(System.out::println);//t->System.out.println(t+" ")
		
		
		
	}
	
	//list elemanlarinin karakter sayisini ters sirali tekrarsiz olarak yazdiriization
	public static void KarakterSayisiTers (List<String> list) {
		list.
		stream().
		map(t->t.length()).//string data character sayisina update edildi.
		sorted(Comparator.reverseOrder()).//ters sira yaptik
		distinct().//tekrarsiz
		forEach(Lambda01::printEl);//int oldugu icin printEl calisti
	}
	
	//list elemanlarini karakter sayisina göre kücüge büyüge dogru siralayiniz
	public static void KarakterSayisiKucuktenBuyuge (List<String> list) {
		
		list.stream().
		sorted(Comparator.comparing(t->t.toString().length())).
		forEach(t->System.out.print(t+" "));
	
	}
	
	//list elemanlarinison harfine göre ters sirali olarak yazdirin
	
	public static void SonHarfTersten (List<String> list) {
		list.
		stream().
		sorted(Comparator.
				comparing(t->t.toString().//Karsilastirma methodu
						charAt(t.toString().length()-1)).//son indexe karsilik gelen karakter
				reversed()).//ters siralama
		forEach(t->System.out.print(t+" "));
				
	}
	
	//elemanlarin karelerini hesaplayip, Cift sayili olanlarini tekrarli olanlari sadece bir kere buyukten kucuge dogru
	//yazdiran bir program yaziniz.
	
	public static void CiftKarakterTekrarli(List<String> list) {
		list.stream().
		map(t->t.length()*t.length()).//string elemanlar character sayisina cevrildi
		filter(Lambda01::ciftBul). //t->t.length()%2==0
		distinct().//tekrarsiz
		sorted(Comparator.reverseOrder()).//ters sira 
		forEach(t->System.out.print(t+" "));
		
		
	}
	
	//List elemanlarinin karakter sayisini 7 ve 7den az olma durumunu kontrol ediniz.
	public static void HarfSayisiYediKontrol (List<String> list) {
		
	//>>>>>>>>> allMatch
	
	System.out.println(list.stream().allMatch(t->t.length()<=7)?"List elemanlari 7 harften büyük degil" :"List elemanlari 7 harften büyük");//true
	
		
	}
	
	//List elemanlarinin "w" ile baslamasini kontrol ediniz.
	
	public static void WileBaslamaDurumu (List<String> list) {
		System.out.println(list.stream().noneMatch(t->t.startsWith("W"))?"List elemanlarinda w ile baslayan var" :"\"List elemanlarinda w ile baslayan yok");	
		//System.out.println(list.stream().allMatch(t->t.startsWith("W"))?"List elemanlarinda w ile baslayan yok" :"\"List elemanlarinda w ile baslayan var");	
		//>>>>>noneMatch allMatch'in tersi 
	}
	
	//>>>>>anyMatch en az bir eleman sarti saglarsa true, aksi durmda false döner
	//>>>>>allMatch tüm elemanlar sarti saglarsa true, en az bir eleman sarti saglamazsa false döner
	//>>>>noneMatch hicbir eleman sarti saglamazsa true, en az bir eleman sarti  false döner
	
	
	
	//List elelmanlarinin "x" ile biten en az bir elemaý kontrol ediniz
	
    public static void xbitmeKontrol(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))?"x ile biten isim kimse ayaga kalksin":"AGAM x ile biten isim oluuuurrr ");
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }
    
    //karakter sayisi en büyük elemani yazdiriniz
    public static void KarakterSayisiEnBuyuk (List<String> list){
    	//Karakter sayisina göre ters siralarim, ilk elemani alirim.
    System.out.println(list.
    		stream().
    	sorted(Comparator.comparing(t->t.toString().length()).
    			reversed()).
    	findFirst());//ilk eleman alindi.
    }
    public static void KarakterSayisiEnBuyuk2 (List<String> list){
    Stream<String> sonIsim = list.
		stream().
	sorted(Comparator.comparing(t->t.toString().length()).
			reversed()).limit(1);//ilk elemani alir.
    
    System.out.println(Arrays.toString(sonIsim.toArray()));    
    }
    
    
    //isimleri son harflerine gore siraladiktan sonra ilk eleman haric kalan elemanlari yazdiriniz
    public static void ilkElemanHaricKalanlarPrint (List<String> list){
    	
    	list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.length()-1))).skip(1).forEach(System.out::print);
    }
    
    
}
