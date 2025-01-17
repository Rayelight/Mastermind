import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class TimerLabel extends GradientLabel {

	Timer timer;
	int time=0;

	public TimerLabel() {
		timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time+=100;
				repaint();
			}
		});
		timer.start();
	}

	public String getTime() {
		int hours = time/(3600*1000);
		int minutes = (time%(3600*1000))/(60*1000);
		int seconds = (time%(3600*1000))%(60*1000)/1000;
		int millis = (time%(3600*1000))%(60*1000)%1000;
		if(hours>0) {
			return (hours + ":" + format(minutes) + ":" + format(seconds));
		}
		String millisFormat=(millis==0)?"000":millis+"";
		return (format(minutes) + ":" + format(seconds) + ":" + millisFormat);
	}

	public String format(int time) {
		if(time<10) {
			return "0"+time;
		}
		return String.valueOf(time);


	}

	@Override
	public String getText() {
		return "Temps de jeu: "+getTime();
	}

	
	public String stopTimer() {
		timer.stop();
		return getTime();
	}
}