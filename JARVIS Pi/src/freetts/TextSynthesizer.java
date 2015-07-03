package freetts;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TextSynthesizer {

	Synthesizer synthesizer;

	public TextSynthesizer() throws Exception {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		synthesizer.allocate();
		synthesizer.resume();
	}

	public void speakString(String txt) {
		try {
			synthesizer.resume();
			synthesizer.speakPlainText(txt, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to speak text");
		}
	}

	protected void finalize() {
		try {
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synthesizer.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to finalize synthesizer");
		}
	}

	public static void singleSpeech(String text) {
		try {
			System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

			Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
			synthesizer.allocate();
			synthesizer.resume();
			synthesizer.speakPlainText(text, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synthesizer.deallocate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
