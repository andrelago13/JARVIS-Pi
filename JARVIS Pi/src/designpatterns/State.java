package designpatterns;

public interface State {
	
	public void activate();
	public void deactivate();
	public void handle(String message);

}
