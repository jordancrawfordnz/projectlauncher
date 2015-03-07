package ord.nz.jordancrawf.projects.ProjectLauncher;

import java.util.*;

public class ProjectLauncher {
	
	List<Project> projects;
	private ProjectLauncher()
	{
		projects = new ArrayList<Project>();
		// parse
		
		String[] toLaunch = {"ord.nz.jordancrawf.projects.ProjectLauncher.SourceTree",
				"ord.nz.jordancrawf.projects.ProjectLauncher.SublimeText",
				"ord.nz.jordancrawf.projects.ProjectLauncher.Finder"};
		
		Project firstProject = new Project("dash", "/Users/Jordan/Projects/dash-web", toLaunch);
		// path must be defined relative to the entire system!
		projects.add(firstProject);
	}
	
	static ProjectLauncher projectLauncher = null;
	
	public static ProjectLauncher getInstance()
	{
		if(projectLauncher == null)
		{
			projectLauncher = new ProjectLauncher();
		}
		return projectLauncher;
	}
	
	public List<Project> getProjects()
	{
		return projects;
	}
}
