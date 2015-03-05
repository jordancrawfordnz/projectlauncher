import java.io.IOException;


public class Finder implements Launchable{

	String path;
	public Finder(String path)
	{
		this.path = path;
	}
	
	@Override
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("open " + path);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}
