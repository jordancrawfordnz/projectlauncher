import java.io.IOException;


public class SourceTree implements Launchable{

	Project project;
	public SourceTree(Project project)
	{
		this.project = project;
	}
	
	@Override
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("stree " + project.getPath());
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
