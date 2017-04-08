# ProjectLauncher
![preview of operation](/images/preview.gif?raw=true)

## What does it do?
If your switching between projects often there are a lot of different things to open. In my case, this was the projects directory in Sublime Text, SourceTree and Finder. I wanted a command line tool to just launch a project quickly.

These all had command line programs that could be told to open up the required folder.

## What systems does it support
It has only been tested on OS X, but the code is in Java so wouldn't require too much work to get goign on another operating system.

## What launchables does it come with?
#### - ord.nz.jordancrawf.projects.ProjectLauncher.SourceTree
This launches the project's path in SourceTree using the ``stree`` command.

#### - ord.nz.jordancrawf.projects.ProjectLauncher.SublimeText
This launches the project's path in Sublime Text using the ``subl`` command.

#### - ord.nz.jordancrawf.projects.ProjectLauncher.Finder
This launches the project's path in Finder using OS X's ``open`` command.

## How do I make it do my own thing?
There are still many custom 'launchables' that can be added. Just implement the ``Launchable`` interface, compile with your lauchables as part of the project,  and set your launchables full class path in your ``.projectlauncher.json`` file (reflection is used to load the correct classes).

# Making your ``.projectlauncher.json`` file
The JSON file is not yet edited by the program, so it's up to you to define the projects.

This should be located in your home directory, an example is the path of mine which is: ``/Users/Jordan/.projectlauncher.json``

This is an array of objects, each object has a name, path and array of launchables.

name: this is the name used when launching, e.g: use ``project project1`` to launch a project with the name ``project1``

path: this is the full path to the working directory of the project. Full path! i.e.: includes all the ``/User/[username]`` stuff if your files are inside your home directory.

launch: the array of launchable classname strings that run when the project launches. See above for the launchables that come with it.

### Example:

	[
		{
			"name" : "project1",
			"path" : "/Users/username/Sites/project1",
			"launch" :
			[
				"ord.nz.jordancrawf.projects.ProjectLauncher.SublimeText"
			]
		},
		{
			"name" : "project2",
			"path" : "/project2",
			"launch" :
			[
				"ord.nz.jordancrawf.projects.ProjectLauncher.SourceTree",
	            "ord.nz.jordancrawf.projects.ProjectLauncher.SublimeText",
	            "ord.nz.jordancrawf.projects.ProjectLauncher.Finder"
			]
		}

	]

## General usage
In Terminal.app, after following the below to install globally.

- ``project`` lists all current projects that could be found
- ``project [projectname]`` launches the requested project with the launchables defined in configuration.

# Building and Installing
## Creating a JAR
I didn't have any luck with getting ```mvn``` to automatically creat the jar file for me, so in Eclipse I just used:

- Export
- Java/Runnable JAR File


![choose runnable JAR](/images/making_jar_1.jpg?raw=true)

- Library handling should just be "Package required libraries into generated JAR"


![find location and finish](/images/making_jar_2.jpg?raw=true)

- Finish


## Launching globally
We want to be able to run ```project``` in Terminal from any directory, so:

- Put the JAR from above somewhere easy, like in your applications folder
- ``cd /usr/local/bin``
- ``nano project`` (or your favorite text editor)


![change into local bin and open nano](/images/setting_up_1.jpg?raw=true)

- type: ``java -jar [location of ProjectLauncher.jar] $@``,  in my case: ``java -jar /Applications/ProjectLauncher.jar $@``


![add the required command to project](/images/setting_up_2.jpg?raw=true)

The ``$@`` you see here is so any additional parameters to ``project`` are sent through to the actual JAR file.
		
- We need to be able to execute that command. Do ``chmod +x project``
- Now change directory to somewhere else and try the ``project`` command. If all goes well, you should get a listing of your projects!

## TODO:
- make it easier to setup and setup new launchables
- cool things like auto-prediction of project as you type, and maybe some way too only open something if the project isn't already open in that program (not sure how to do this though...?)
