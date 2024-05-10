package testAppium.teatAppiumTestng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PredefinedActions {
	
	public static void startAVD(String avdName) throws IOException, InterruptedException {
        // Construct the command to start the AVD
        //String command = String.format("emulator -avd %s", avdName);
		String emulatorPath = "C:\\Users\\Vive.Kumar\\AppData\\Local\\Android\\Sdk\\emulator";
		
		String command = String.format("cmd /c cd %s && emulator -avd %s", emulatorPath, avdName);

		// Start the AVD
		Process process = Runtime.getRuntime().exec(command);
		
		//command = String.format("emulator -avd %s", avdName);

        // Start the AVD
        //process = Runtime.getRuntime().exec(command);

        // Read output to check if AVD has started successfully
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (line.contains("Increasing screen off timeout")) {
                System.out.println("AVD started successfully");
                break;
            }
        }
        //process.waitFor();
    }
	
	public static void stopAVD(String avdName) throws IOException, InterruptedException {
		String stopCommand = String.format("adb emu kill");
		Process stopProcess = Runtime.getRuntime().exec(stopCommand);
		stopProcess.waitFor();
	}

}
