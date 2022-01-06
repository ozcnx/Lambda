package day_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda04 {

	public static void main(String[] args) {

		TechPro trGunduz = new TechPro("yaz", "TR gunduz", 97, 124);
		TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
		TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
		TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

		List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));

		// bu class ta return type calisacagiz.

		//// task 01--> batch ort'larinin 92 den buyuk oldugu kontrol eden pr create
		//// ediniz.

		System.out.println(batchOrtTekSirali(list));

	}

	public static boolean batchOrt92Byk(List<TechPro> list) {
		return list.stream().allMatch(t -> t.getBatchOrt() > 92);// akýsdaki her eleman batchort field'a gore eslesmesi
																	// kontrol edildi
	}

	// task 02 >>>ogrenci sayilarinin hicbirinin 110 dan az olmadiginni kontrol eden
	// pr create ediniz.

	public static boolean ogrSayisi110Az(List<TechPro> list) {

		return list.stream().noneMatch(t -> t.getOgrcSayisi() < 110);// AllMatch(t->t.getOgrcSayisi()>110);

	}

	// task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini kontrol eden
	// pr create ediniz.
	public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
		return list.stream().anyMatch(t -> t.getBatch().equals("bahar"));

	}

	//
	public static List<TechPro> ogrcSayisiTersSiraliBatch(List<TechPro> list) {
		return list.stream().sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed())
				.collect(Collectors.toList());// collect()->akýsdaki elamanlarý istenen sarta gore toplar
												// Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
	}

	// task 05-->batch'leri batch ort gore b->k siralayip ilk3 'unu yazdiriniz.

	public static List<TechPro> batchOrtTekSirali(List<TechPro> list) {
		return list.stream().sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).// ogrcSayisi parametresine
																							// gore ters siraladi
				limit(3).// akýstadki elemanlarin ilk ucu alindi
				collect(Collectors.toList());// collect()->akýsdaki elamanlarý istenen sarta gore toplar
		// Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
	}
	
	//task 05--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
	
	public static List<TechPro> ogrcSayisiEnAz2Batch(List<TechPro> list) {
	    return list.
	            stream().
	            sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//ogrcSayisi parametresine gore  siraladi
	            limit(2).//ilk iki elelman alindi
	            skip(1).//ilk elelamn atlatildi
	                    collect(Collectors.toList());//collect()->akýsdaki elamanlarý istenen sarta gore toplar

	}
}
