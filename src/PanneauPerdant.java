import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class  PanneauPerdant extends JDialog {
	private JLabel perdu;

	public  PanneauPerdant(Mastermind f,String titre,boolean modal){
		this.setResizable(false);
		this.setSize(200,200);
		
		JPanel fin=new JPanel();	
		perdu= new JLabel("Vous avez perdu");
		perdu.setBounds(10,20,5,5);	
		fin.add(perdu);

	}
}
