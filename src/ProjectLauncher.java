import java.util.*;


public class ProjectLauncher {
	
	List<Project> projects;
	private ProjectLauncher()
	{
		projects = new ArrayList<Project>();
		// parse
		
		Project firstProject = new Project("dash", "~/Projects/dash-web");
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
	
	
	public static void main(String args[])
	{
		if(args.length == 0)
		{
			for(Project currentProject : ProjectLauncher.getInstance().getProjects())
			{
				System.out.println(" - " + currentProject);
			}
			return;
		}
		if(args.length == 1)
		{
			for(Project currentProject : ProjectLauncher.getInstance().getProjects())
			{
			
				if(currentProject.getName().equals(args[0]))
				{
					if(currentProject.Launch())
					{
						System.exit(0);
					}
					else
					{
						System.exit(1);
					}
				}
				else
				{
					System.err.println("Darn! \"" + args[0] + "\" isn't a project I know about. Use 'project' to list all projects I know :)");
				}
			}
			// check project, setup project
			return;
		}
		System.err.print("Invalid argument provided! Use: 'project' to list. or 'project [project_name]' to launch a project. Have a great day.");
	}	
}
