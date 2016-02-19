package jarvis.interaction.state.mainstate;

import java.io.IOException;

import configuration.Configuration;
import configuration.language.TextSystem;
import jarvis.easter_eggs.EasterEggSystem;
import jarvis.engine.JarvisWeather;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;
import jarvis.interaction.state.MainJarvisState_TimeoutManager;

public class TriggeredState implements MainJarvisState {
	
	private static final int default_timeout = 10 * 1000;	// 10 seconds

	private MainJarvisContext context;
	private Configuration config;
	private Boolean active = false;
	private MainJarvisState_TimeoutManager timeout_thread = null;

	public TriggeredState(MainJarvisContext context) {
		setContext(context);
		try {
			config = Configuration.getInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void activate() {
		if(isActive())
			return;
		
		active = true;
		
		try {
			timeout_thread = new MainJarvisState_TimeoutManager(getContext(), this, default_timeout, new IdleState(getContext()));
		} catch (IllegalArgumentException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		if(timeout_thread != null)
			timeout_thread.start();
	}

	@Override
	public void deactivate() {
		if(!isActive())
			return;
		
		active = false;
	}

	@Override
	public MainJarvisContext getContext() {
		return context;
	}

	@Override
	public void setContext(MainJarvisContext context) {
		this.context = context;
	}

	@Override
	public void handle(String message) {
		if(TextSystem.isGreet(message)) {
			context.replyToUser(TextSystem.getRandomAlreadyHere());
			return;
		} else if(TextSystem.isFarewell(message)) {
			context.replyToUser(TextSystem.getFarewellReply() + config.getUserName());
			context.deactivate();
			return;
		} else if(EasterEggSystem.isEasterEgg(message)) {
			EasterEggSystem.makeEasterEgg(message, getContext());
			return;
		}
		
		String weatherReply = JarvisWeather.replyTo(message);
		if(weatherReply != null) {
			context.replyToUser(weatherReply);
		}
	}

	@Override
	public void execute() {
		if(!isActive())
			return;
		
		handle(context.getUserInput());
	}

	@Override
	public Boolean isActive() {
		return active;
	}

}
