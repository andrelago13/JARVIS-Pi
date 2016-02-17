package jarvis.interaction.state;

public class MainJarvisState_TimeoutManager extends Thread {
	
	private MainJarvisState prev_state = null;
	private MainJarvisState next_state = null;
	private MainJarvisContext context = null;
	private int timeout_milis = 0;
	
	public MainJarvisState_TimeoutManager(MainJarvisContext context, MainJarvisState prev_state, int timeout_milis, MainJarvisState next_state) {
		this.context = context;
		this.prev_state = prev_state;
		this.next_state = next_state;
		this.timeout_milis = timeout_milis;
	}
	
    public void run() {
    	if(prev_state == null)
    		return;
    	
        try {
			Thread.sleep(timeout_milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        prev_state.deactivate();
        if(next_state != null && context != null)
        	context.setState(next_state);
    }
}
