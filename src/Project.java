import java.lang.Throwable.*;

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
		
		System.out.println("launched successfully");
		return true;
	}
	
	@Override public String toString()
	{
		return this.name + ", path: \"" + this.path + "\"";
	}
	
	public String getName()
	{
		return this.name;
	}
}
