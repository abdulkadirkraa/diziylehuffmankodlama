package Odev;


public class Main {

	static Huffman[] obj;
	private static Huffman[] kopya;
	static int es=0;
	static int elemanlar;
	
	public static void main(String[] args) {
		
		//sıklık değeri yüksek olan hoca da yukarı(ilk) yazardı diye ona göre yaptım
		obj=new Huffman[8];
		obj[0] = new Huffman("a",27);
		obj[1] = new Huffman("e",26);
		obj[2] = new Huffman("d",21);
		obj[3] = new Huffman("b",20);
		obj[4] = new Huffman("c",15);
		obj[5] = new Huffman("f",14);
		obj[6] = new Huffman("g",12);
		obj[7] = new Huffman("s",11);
		es=obj.length;
		kopya=new Huffman[(obj.length*2)-1];
		
		olusturma(obj);
		//print(kopya);
		ikiliatama(kopya);
		bitleriatama();
		orjinalprint(obj);
		//dizinin yollarını ve yolların değerini görmek isterseniz bakabilirsiniz.elemanın tuttuğu değer agac mnatıgında yukarısına cıkan yolun değeridir
		//System.out.println("===============");
		//orjinalprint(kopya);
		
	}
	
	static void olusturma(Huffman[] arr) {
		
		
		for(int i=0;i<es;i++) {
			kopya[i]=arr[i];
		}	
		selectionsort(kopya);
		
		elemanlar=es;
		while(es>1 && es!=0){
			  String x1=kopya[es-1].karakter;
			  int y1=kopya[es-1].frekans;
			  String x2=kopya[es-2].karakter;
			  int y2=kopya[es-2].frekans; 
			  kopya[elemanlar]=new Huffman(x1+x2,y1+y2);
			  elemanlar++;
			  es++;
			  selectionsort(kopya);
			  es=es-2;
			  //DİZİDE EKENİP KALANLARI GÖRMEK İSTERSENİZ BAKABİLİRİSİZ
			  //print(kopya);
			  //System.out.println();
		}
		//kopya dizisinin oluşmuş halinin tamamını görmek isterseniz bakabilirsiniz
		//orjinalprint(kopya);  
		
	}
	
	static void print(Huffman[] arr) {
		for(int i=0;i<es;i++) {
			System.out.println(arr[i].karakter +"\t"+ arr[i].frekans +"\t"+arr[i].binary);
		}
		System.out.println();
	}
	
	static void selectionsort(Huffman[] arr) {
		for(int i=0;i<elemanlar;i++) {
			int max=i;
			for(int j=i+1;j<elemanlar;j++) {
				if(arr[j].frekans>arr[max].frekans) {
					max=j;
				}
				Huffman temp=new Huffman(arr[max].karakter,arr[max].frekans);
				arr[max]=new Huffman(arr[i].karakter,arr[i].frekans);
				arr[i]=new Huffman(temp.karakter,temp.frekans);
			}
		}
	}

	static void orjinalprint(Huffman[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].karakter +"\t"+ arr[i].frekans +"\t"+arr[i].binary);
		}
		System.out.println();
	}
	
	static void ikiliatama(Huffman[] arr) {
		for(int i=1;i<arr.length;i++) {
			if(i%2==1) {
				arr[i].binary="1";
			}
			else {
				arr[i].binary="0";
			}
		}
	}
	
	static void bitleriatama() {
		for(int i=0;i<obj.length;i++) {
			for(int j=1;j<kopya.length;j++) {
				String elemanKarakteri=kopya[j].karakter;
				for(int k=0;k<elemanKarakteri.length();k++) {
					if(elemanKarakteri.charAt(k)==obj[i].karakter.charAt(0)) {
						obj[i].binary=obj[i].binary + kopya[j].binary;
					}
				}
			}
		}
	}
}
