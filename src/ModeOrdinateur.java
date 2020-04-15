import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class ModeOrdinateur {
	public static HashMap<Color[], Integer> generationCombis(){
		int nbrCouleurs =Mastermind.getNbrCouleurs();
		int tailleCombi =Mastermind.getTailleCombinaison();
		boolean multiColor = Mastermind.multiColor;
		
		//			Initialisation
		LinkedHashMap<Color[], Integer> listeCombi = new LinkedHashMap<>();
		
		int[] combi = new int[tailleCombi];
		Arrays.fill(combi, 0);
		int a=0;
		
		
		//			Création Combinaisons
		while(a<Math.pow(nbrCouleurs, tailleCombi)){
			//		Ajout de la combinaison
			if(multiColor||combi.length==countDistinct(combi))
				listeCombi.put(clone(combi), null);

			
			//		Incrémentation Combinaison
			int b=tailleCombi-1;
			combi[b]++;
			while(b>0){
				if(combi[b]==nbrCouleurs) {
					combi[b]=0;
					combi[b-1]++;
				}
				b--;
			}
			
			a++;
		}
		return listeCombi;
		
	}
	
	public static int countDistinct(int arr[]) { 
 
        HashSet<Integer> hs = new HashSet<Integer>(); 
  
        for(int i = 0; i < arr.length; i++){  
            // add all the elements to the HashSet  
            hs.add(arr[i]); 
        } 
          
        // return the size of hashset as  
        // it consists of all Unique elements  
        return hs.size();      
    } 
	
	public static Color[] clone(int combi[]) { 
		Color[] combiColor = new Color[combi.length]; 
		
		for(int i=0; i<combi.length; i++) {
			combiColor[i] = Mastermind.couleurs[combi[i]];
			System.out.print(combi[i]+" ");
		}  
		System.out.println();
		
		return combiColor; 
    } 
}
