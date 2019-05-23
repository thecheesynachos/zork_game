package muic.ooc.zork.gameplay;

public class CommandLinePrinter implements Observer {

	public void presentObservation(Observation observation) {
		if(observation != null) {
			if(observation.hasColour()) {
				System.out.println(observation.getColour() +
						observation.getObservationMessage() + Observation.ANSI_RESET);
			} else{
				System.out.println(observation.getObservationMessage());
			}
		}
	}

}
