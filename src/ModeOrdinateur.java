import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class ModeOrdinateur {
	
	public static LinkedList<Color[]> generationCombis(){
		int nbrCouleurs =Mastermind.getNbrCouleurs();
		int tailleCombi =Mastermind.getTailleCombinaison();
		boolean multiColor = Mastermind.multiColor;
		
		//			Initialisation
		//LinkedHashMap<Color[], Integer> listeCombi = new LinkedHashMap<>();
		LinkedList<Color[]> listeCombi = new LinkedList<>();
		
		int[] combi = new int[tailleCombi];
		Arrays.fill(combi, 0);
		int a=0;
		
		
		//			Création Combinaisons
		//Compteur incrementé de 1 à chaque boucle
		//Les digits de ce derniers vont de 0 à nbrCouleurs-1
		//La boucle est répété autant e fois que de combinaisons possibles
		//Les combinaisons avec plusieurs fois la même couleurs sont comptabilisées
		//(selon l'activation du mode multiColor)
		while(a<Math.pow(nbrCouleurs, tailleCombi)){
			//		Ajout de la combinaison
			if(multiColor||combi.length==countDistinct(combi)) {
				//listeCombi.put(clone(combi), null);
				listeCombi.add(clone(combi));
			}

			
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
	
	
	//Compte le nombre de couleurs distinctes dans une combinaison
	//Permet de déterminer par la suite si la combinaison respecte le mode multiColor
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
	
	
	//Cree une copie de la combinaison numérique sous forme de tableau de couleurs
	public static Color[] clone(int combi[]) { 
		Color[] combiColor = new Color[combi.length]; 
		
		for(int i=0; i<combi.length; i++) {
			combiColor[i] = Mastermind.couleurs[combi[i]];
			System.out.print(combi[i]+" ");
		}  
		System.out.println();
		
		return combiColor; 
    } 
	
	
	//Permet d'éliminer les combinaisons non valides 
	//selon le résultat obtenu en comparant une tentative avec la combiCache
	//Pour se faire on utilise la réciprocité de la méthode de comparaison des combinaisons
	//Les combinaisons valides auront de ce fait le même résultat en les comparant à la dernière tentative
	//que le résultat obtenu en comparant cette dernière avec la combiCache
	public static void eliminerInvalides(LinkedList<Color[]> listeCombi, Color[] prop, int[] evalCombi) { 
		int i=0;
		while(i<listeCombi.size()) {
			if(Combinaison.evalCombi(listeCombi.get(i), prop)!=evalCombi) {
				listeCombi.remove(i);
			}else {
				i++;
			}
		}

    } 
	
	
}
