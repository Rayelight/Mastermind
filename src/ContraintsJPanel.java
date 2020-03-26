import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public abstract class ContraintsJPanel extends JPanel {
	
	protected SpringLayout layout;
	
	public ContraintsJPanel(){
		layout = new SpringLayout();
		this.setLayout(layout);
		
	}
	
	abstract void adjustContraints();

	
}
