package sphinx;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

public class SoundListener {

	ConfigurationManager cm;
	Recognizer recognizer;
	Microphone microphone;

	public SoundListener() throws Exception {
		cm = new ConfigurationManager(SoundListener.class.getResource("myconfig.xml"));
		recognizer = (Recognizer)cm.lookup("recognizer");

		recognizer.allocate();
		microphone = (Microphone)cm.lookup("microphone");
		
		if(!microphone.startRecording()){
			System.out.println("Cannot start microphone.");
			recognizer.deallocate();
			throw new Exception();
		}
	}

	protected void finalize() {
		recognizer.deallocate();
	}

	public String listenOnce() {
		return listenOnce(false);
	}
	
	public String listenOnce(Boolean printResult) {

		Result result = null;
		System.out.println("Start speaking.\n");
		result = recognizer.recognize();

		while(result == null) {
			System.out.println("I can't hear what you said.");
			System.out.println("Speak again.");
			result = recognizer.recognize();
		}

		String resultText = result.getBestFinalResultNoFiller();
		if(printResult) {
			System.out.println("I heard: " + resultText);
			System.out.println("1 " + result.getReferenceText());
			System.out.println("2 " + result.getClass());
		}

		//microphone.stopRecording();
		return resultText;
	}
}
