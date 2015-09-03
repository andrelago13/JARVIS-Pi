package jarvis;

import freetts.TextSynthesizer;
import sound.MP3Player;
import sphinx.SoundListener;

public class InteractorTest {
	public void start() {
		SoundListener listener = null;
		TextSynthesizer synth = null;
		try {
			listener = new SoundListener();
			synth = new TextSynthesizer();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		String message = "";
		while(!message.equals("farewell")) {
			message = listener.listenOnce(true);
			//synth.speakString(message);

			if(message.equals("say my name")) {
				MP3Player.playFileForeground("./resources/sound/heisenberg/youre-heisenberg.mp3");
			} else if (message.equals("you're hi zen berg")) {
				MP3Player.playFileForeground("./resources/sound/heisenberg/youre-goddamn-right.mp3");
			}
		}
		synth.speakString("I'm leaving bitch fucking ass mother fucker");
	}


}
