import java.io.IOException;
import java.lang.Throwable.*;
import java.lang.reflect.*;

public class Project {
	
	String name, path;
	
	public Project(String name, String path)
	{
		if(name == null)
		{
			throw new IllegalArgumentException("name is not defined");
		}
		if(path == null)
		{
			throw new IllegalArgumentException("path is not defined");
		}
		this.name = name;
		this.path = path;
	}	
	
	public boolean Launch()
	{
		getInstanceOfLaunchable("Finder").Launch();
		getInstanceOfLaunchable("SourceTree").Launch();
		getInstanceOfLaunchable("SublimeText").Launch();

		return true;
	}
	
	Launchable getInstanceOfLaunchable(String name)
	{
		try
		{
			Class<?> launcherClass;
			launcherClass = Class.forName(name);
			
			if (launcherClass == null)
				return null;
						
			Constructor<?> constructHandler = launcherClass.getDeclaredConstructor(Project.class);
			return (Launchable) constructHandler.newInstance(this);
		}
		catch (InstantiationException e)
		{
			return null;
		}
		catch (NoSuchMethodException e)
		{
			return null;
		}
		catch (IllegalAccessException e)
		{
			return null;
		}
		catch (InvocationTargetException e)
		{
			return null;
		}
		catch(ClassNotFoundException e)
		{
			return null;
		}
	}
		
	@Override public String toString()
	{
		return this.name + ", path: \"" + this.path + "\"";
	}
	
	public String getPath()
	{
		return path;
	}
	
	public String getName()
	{
		return name;
	}
}
