package ord.nz.jordancrawf.projects.ProjectLauncher;

import java.io.IOException;

public class SourceTree implements Launchable{

	Project project;
	public SourceTree(Project project)
	{
		this.project = project;
	}
	
	public boolean Launch() {
		try {
			Runtime.getRuntime().exec("/usr/local/bin/stree " + project.getPath());
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
