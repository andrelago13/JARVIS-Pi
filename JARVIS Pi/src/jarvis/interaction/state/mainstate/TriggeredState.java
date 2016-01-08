package jarvis.interaction.state.mainstate;

import java.io.IOException;

import weather.WUCondition;
import weather.WeatherUnderground;
import configuration.Configuration;
import configuration.language.TextSystem;
import jarvis.interaction.state.MainJarvisContext;
import jarvis.interaction.state.MainJarvisState;

public class TriggeredState implements MainJarvisState {

	private MainJarvisContext context;
	private Configuration config;

	public TriggeredState(MainJarvisContext context) {
		setContext(context);
		try {
			config = Configuration.getInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void activate() {
		context.getUserInput();
	}

	@Override
	public void deactivate() {}

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
		// TODO Auto-generated method stub
		if(TextSystem.isFarewell(message)) {
			context.replyToUser(TextSystem.farewellReply + config.getUserName());
			context.deactivate();
			return;
		}

		context.getUserInput();
	}



}
