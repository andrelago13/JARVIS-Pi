package jarvis.interaction.state.mainstate;

import jarvis.interaction.state.MainContext;
import jarvis.interaction.state.MainState;

public class TriggeredState implements MainState {
	
	private static final long command_timeout = 5;
	private Boolean command_received = false;
	private MainContext context = null;
	
	Thread counter_thread = new Thread() {
		public void run(){
			try {
				Thread.sleep(command_timeout);
				if(!command_received) {
					commandTimedOut();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.println("Unable to sleep on command timeout thread");
			}
		}
	};
	
	public TriggeredState(MainContext context) throws IllegalArgumentException {
		setContext(context);
	}

	private void commandTimedOut() {
		this.context.setState(new IdleState(this.context));
		// TODO play sound
	}

	public void activate() {
		this.command_received = false;
		counter_thread.start();
	}

	public void deactivate() {
		counter_thread.interrupt();
	}

	public void handle(String message) {
		this.command_received = true;
		// TODO Auto-generated method stub
	}

	public MainContext getContext() {
		return this.context;
	}

	public void setContext(MainContext context) {
		if(context == null) {
			throw new IllegalArgumentException();
		}

		this.context = context;
	}

}
