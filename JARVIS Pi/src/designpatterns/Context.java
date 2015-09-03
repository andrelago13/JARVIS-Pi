package designpatterns;

public interface Context {
	
	public State getState();
	public void setState(State state);
	public void handle(String message);

}
