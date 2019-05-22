package muic.ooc.zork.gameplay;

import muic.ooc.zork.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputAcceptor {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public Command receiveInput(GameBag gameBag){
		try {
			String inputString = in.readLine();
			for (Command command : gameBag.getCommandsList()){
				if(inputString.startsWith(command.getCommandString())){
					return command;
				}
			}
		} catch(Exception e){
			System.out.println("There is an error in command reading, please try again.");
		}
		return null;
	}

	public Observation processCommand(Command command, GameBag gameBag){
		if(command == null){
			return new Observation("Me no get your command, try again.");
		} else{
			Observation ob = command.doCommand(gameBag);
			return ob;
		}
	}

	public String receiveInputAsString(){
		try{
			String inputString = in.readLine();
			return inputString;
		} catch (Exception e){
			return null;
		}
	}

}
