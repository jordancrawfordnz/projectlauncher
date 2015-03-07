package ord.nz.jordancrawf.projects.ProjectLauncher;

import java.io.IOException;

public class SublimeText implements Launchable{

	Project project;
	public SublimeText(Project project)
	{
		this.project = project;
	}
	
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("subl " + project.getPath());
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}