package core.gl;

public class RenderMovingObject implements IRenderTask{

	private int prior = 2;

	public int priority(){
		return prior;
	}

	public boolean remove(){
		return false;
	}
}
