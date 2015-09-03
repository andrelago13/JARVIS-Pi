package sound;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player {

	private Player player;
	private String file;
	private Thread playThread;

	public MP3Player(String filename) {
		this.file = filename;
		playThread = null;
		player = null;
	}

	public void play() {
		try {
			FileInputStream fis     = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch (Exception e) {
			System.out.println("Problem playing file " + file);
			System.out.println(e);
		}

		// run in new thread to play in background
		playThread = (new Thread() {
			public void run() {
				try {
					if(player != null)
						player.play();
				}
				catch (Exception e) { System.out.println(e); }
			}
		});
		playThread.start();
	}

	public void stop() {
		if(player != null)
			player.close();
		if(playThread != null)
			playThread.interrupt();
	}

	public static void playFile(String filename, Boolean foreground) {

		Player player = null;

		try {
			FileInputStream fis     = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}

		final Player fnlPlayer = player;

		if(foreground) {									// run on main thread, blocking program
			try {
				if(fnlPlayer != null)
					fnlPlayer.play();
			}
			catch (Exception e) { System.out.println(e); }
		} else {											// run in new thread to play in background
			new Thread() {
				public void run() {
					try {
						if(fnlPlayer != null)
							fnlPlayer.play();
					}
					catch (Exception e) { System.out.println(e); }
				}
			}.start();
		}
	}

	public static void playFileBackground(String filename) {
		playFile(filename, false);
	}
	
	public static void playFileForeground(String filename) {
		playFile(filename, true);
	}
}
