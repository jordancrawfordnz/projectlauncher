import java.io.IOException;


public class SourceTree implements Launchable{

	String path;
	public SourceTree(String path)
	{
		this.path = path;
	}
	
	@Override
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("stree " + path);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
