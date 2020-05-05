-------------Projet MASTERMIND-------------
réalisé par BECQUET Simon et GHARBI Reda


Les fichiers .java se situent dans le dossier src. 
Les fichiers .class se situent dans le dossier bin.
La classe main de ce programme est Mastermind.java héritant de JFrame.

Le fichier Mastermind.jar ext un exécutable permettant de lancer le jeu.
Le fichier Mastermind.jardesc permmet de récréer facilement 
une version à jour du jar exécutable via Eclipse. 

bibliographie.txt est une bigraphie exhaustive de l'ensemble des liens utilisés pendant le projet.
UML.gif est une version image de UML.ucls qui est le diagramme UML du projet.

Les fichiers .gitignore, .classpath, .project ainsi que les dossiers .git et .settings
permettent le bon fonctionnement du projet avec Eclipse et GitHub


Le programme comporte les classes suivantes:
Panneaux:
	PanneauAccueil.java		Déclaration du panneau accueil avec ses widgets
	PanneauOptions.java		Déclaration du panneau options avec ses widgets
	PanneauJeu.java			Déclaration du panneau jeu avec ses widgets

Menu:
	BarreMenu.java			Barre contenant les différents widgets à droite du panneau jeu
	HiddenCombiPanel.java		Combinaison cachée en haut de la barre menu
	PaletteCouleurs.java		Palette de couleurs dans le panneau jeu
	StatsPartie.java		Ensemble des résultats du joueur dans le panneau jeu
	TimerLabel.java			Résultat du temps de la partie
	BoutonsJeu.java			Bouton présent en bas du panneau jeu

Plateau de Jeu:
	PlateauJeu.java			Cadre du plateau dans la fenêtre de jeu
	GrilleCouleurs.java		Grilles réunissant l'ensemble des combinaisons
	CarreEval.java			Carré à cote de la grille de jeu qui permet de savoir les indications sur la combinaison
	Combinaison.java		Combinaison de couleurs comportant un tableau de RoundButton
	RoundButton.java		Construction des boutons circulaires

Fenêtre Tiers:
	FenetreFin.java			JDialog de fin pour le joueur
	Regles.java			JDialog pour l'ffichage des règles

Mode Ordinateur
	ModeOrdinateur.java		Classe statique comportant différentes méthodes pour le bon fonctionnnement du mode ordinateur

Esthétiques:
	HSLColor.java			Classe de gestion des couleurs en mode HSL
	GradientPanel.java		Modèle des différents Jpanels
	GradientButton.java		Modèle des différents JButtons
	GradientLabel.java		Modèle des différents JLabels
	
