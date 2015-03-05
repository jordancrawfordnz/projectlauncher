import java.io.IOException;


public class SublimeText implements Launchable {

	String path;
	public SublimeText(String path)
	{
		this.path = path;
	}
	
	@Override
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("subl " + path);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	

}
