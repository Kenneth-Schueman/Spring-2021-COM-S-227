package lab2;
	import lab2.RabbitSimApp.RabbitModel;
import plotter.SimulationPlotter;

public class RabbitSimApp {
	public class RabbitModel {

	}

	public static void main(String[] args){
		SimulationPlotter plotter = new SimulationPlotter();
		
		lab2.RabbitModel myModel = new lab2.RabbitModel();
		plotter.simulate(myModel);
	}
}
