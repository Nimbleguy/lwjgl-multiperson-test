package core.gl;

public class RenderMovingObject implements IRenderTask{

	private int prior = 2;

	public RenderMovingObject(int p){
		prior = p;
	}

	public int priority(){
		return prior;
	}

	public boolean remove(){
		return false;
	}

	public void init(){
		
	}
	public void run(long window){
		
	}
}
