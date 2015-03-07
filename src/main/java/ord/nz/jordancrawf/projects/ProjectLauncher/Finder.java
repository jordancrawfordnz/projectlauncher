package ord.nz.jordancrawf.projects.ProjectLauncher;

import java.io.IOException;

public class Finder implements Launchable{

	Project project;
	public Finder(Project project)
	{
		this.project = project;
	}
	
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("open " + project.getPath());
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}