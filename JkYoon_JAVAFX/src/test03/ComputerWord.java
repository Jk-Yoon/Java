package test03;
/**
 * @class : ComputerWord.java
 * @title : 
 * @author : Yoon
 * @desciption : ´Ü¾îÁý
 */
public class ComputerWord {

	private String [] cpWord 	= 	{
			/*A*/		"apple","aviation","anus",
			/*B*/		"best","book","blood","basic","blast",
			/*C*/		"computer","cigar","cigarlet","cartoon","chopsticks","contract ",
			/*D*/		"desk","display","danger","death","dictionary",
			/*E*/		"evil","earth","eclipse","event","england",
			/*F*/		"flex","future","fool","frog","function",
			/*G*/		"green","glasses","weeds","gray","garments",
			/*H*/		"human","hell","homicide","hide",
			/*I*/		"internet",
			/*J*/		"java","japan","job",
			/*K*/		"korea",
			/*L*/		"love","live","liquid","lawyer","lighting",
			/*M*/	 	"morningmusume", "man","member","method","movie",
			 /*N*/	 "name","narcotic",
			 /*O*/	 "option",
			 /*P*/	 "president","program","picture",
			 /*Q*/	 "queen",
			 /*R*/	 "road","rainbow",
			 /*S*/	 "sex","speed","school","spoon","spy","storm",
			 /*T*/	 "telephone",
			 /*U*/	 "underwear",
			 /*V*/	 "victory","violence",
			 /*W*/	 "women",
			 /*X*/
			 /*Y*/	 "yoshiki"
			 /*Z*/


			 //"Pneumonoultramicroscopicsilicovolcanoconiosis",
		};

	public String getComWord () {
		int index = ( int )( Math.random() * cpWord.length );
		return cpWord [ index ];
	} // end of getComWord

} // end of Class as ComputerWord