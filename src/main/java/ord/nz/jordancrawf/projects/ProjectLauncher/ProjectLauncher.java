package ord.nz.jordancrawf.projects.ProjectLauncher;

import java.util.*;
import java.io.*;

import org.json.simple.parser.*;
import org.json.simple.*;

public class ProjectLauncher {
	
	List<Project> projects;
	private ProjectLauncher()
	{
		projects = new ArrayList<Project>();
		// parse
		String homeDir = System.getProperty("user.home"); // this may not work on Windows
		String fileDir = homeDir + "/.projectswitcher.json";
		
		try {
			Object obj = new JSONParser().parse(new FileReader(fileDir));
			JSONArray array = (JSONArray) obj;
			for(Object currentObj : array)
			{
				JSONObject jsonObject = (JSONObject) currentObj;
				String name = (String) jsonObject.get("name");
				String path = (String) jsonObject.get("path");
				JSONArray launch = (JSONArray) jsonObject.get("launch");
				
				List<String> currentLaunchables = new ArrayList<String>();
				for(Object currentLaunchObj : launch)
				{
					String currentLaunchable = (String) currentLaunchObj;
					currentLaunchables.add(currentLaunchable);
				}
				Project thisProject = new Project(name, path, currentLaunchables);
				// path must be defined relative to the entire system!
				projects.add(thisProject);
			}		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
