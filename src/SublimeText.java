import java.io.IOException;


public class SublimeText implements Launchable{

	Project project;
	public SublimeText(Project project)
	{
		this.project = project;
	}
	
	@Override
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("subl " + project.getPath());
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}