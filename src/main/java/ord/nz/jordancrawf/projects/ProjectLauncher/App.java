package ord.nz.jordancrawf.projects.ProjectLauncher;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main(String args[])
	{
		if(args.length == 0 || args.length == 1)
		{
			if(!ProjectLauncher.getInstance().loadProjects())
			{
				System.exit(2);
			}
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
				boolean projectExists = false;
				for(Project currentProject : ProjectLauncher.getInstance().getProjects())
				{
					if(currentProject.getName().equals(args[0]))
					{
						projectExists = true;
						if(currentProject.Launch())
						{
							System.out.println("Cool. Enjoy!");
							System.exit(0);
						}
						else
						{
							System.err.println("Sorry. Something bad happened, am I missing required classes? You may want to check your project configuration.");
							System.exit(1);
						}
						break;
					}
				}
				if(!projectExists)
				{
					System.err.println("Darn! \"" + args[0] + "\" isn't a project I know about. Use 'project' to list all projects I know :)");
				}
				// check project, setup project
				return;
			}
		}
		else
		{
			System.err.print("Invalid argument provided! Use: 'project' to list. or 'project [project_name]' to launch a project. Have a great day.");	
		}
	}	
}
