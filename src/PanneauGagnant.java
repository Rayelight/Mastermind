import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class  PanneauGagnant extends JDialog {
	private JLabel gagne;

	public  PanneauGagnant(Mastermind f,String titre,boolean modal){
		this.setResizable(false);
		this.setSize(200,200);
		
		JPanel fin=new JPanel();	
		gagne= new JLabel("Vous avez gagné");
		gagne.setBounds(10,20,5,5);	
		fin.add(gagne);

	}
}
