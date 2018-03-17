package preProcess;

import java.io.IOException;

public class FFMInputOperate {

	public static void main(String [] args) throws IOException{
		WriteFFMInput.writeFFMInput(args[0], args[1], args[2], args[3]);
	}
}
