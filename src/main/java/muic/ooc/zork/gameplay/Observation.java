package muic.ooc.zork.gameplay;

public class Observation {

	private StringBuilder observationMessage;
	private String colour;

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public Observation(String message){
		observationMessage = new StringBuilder().append(message);
		this.colour = null;
	}

	public Observation(String message, String colour){
		this.observationMessage = new StringBuilder().append(message);
		this.colour = colour;
	}

	public void addMessage(String message){
		observationMessage.append('\n');
		observationMessage.append(message);
	}

	public Observation concatObservation(Observation anotherObservation){
		if (anotherObservation != null){
			this.addMessage(anotherObservation.getObservationMessage());
		}
		return this;
	}

	public String getObservationMessage() {
		return observationMessage.toString();
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean hasColour(){
		return this.colour != null;
	}

	public static class Builder {

		private StringBuilder sb = new StringBuilder();
		private String colour;

		public Builder addString(String str){
			this.sb.append(str).append('\n');
			return this;
		}

		public Builder setColour(String colour){
			this.colour = colour;
			return this;
		}

		public Observation build(){
			this.sb.deleteCharAt(this.sb.length()-1);
			return new Observation(this.sb.toString(), colour);
		}

	}

}
