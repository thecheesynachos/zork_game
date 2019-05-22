package muic.ooc.zork.gameplay;

public class CommandLinePrinter implements Observer {

	public void presentObservation(Observation observation) {
		if(observation != null) {
			System.out.println(observation.getObservationMessage());
		}
	}

}
