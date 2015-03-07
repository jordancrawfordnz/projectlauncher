#About#


#Building and Installing#
## Creating a JAR ##
I didn't have any luck with getting ```mvn``` to automatically creat the jar file for me, so in Eclipse I just used:

1. Export
2. Java/Runnable JAR File
![choose runnable JAR](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/making_jar_1.jpg)

3. Library handling should just be "Package required libraries into generated JAR"
![find location and finish](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/making_jar_2.jpg)

4. Finish


## Launching globally##
We want to be able to run ```project``` in Terminal from any directory, so:

1. Put the JAR from above somewhere easy, like in your applications folder
2. ``cd /usr/local/bin```
3. ``nano project`` (or your favorite text editor)
	![change into local bin and open nano](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/setting_up_1.jpg)

4. type: ``java -jar [location of ProjectLauncher.jar] $@``,  in my case: ``java -jar /Applications/ProjectLauncher.jar $@``
		![add the required command to project](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/setting_up_2.jpg)
		The ``$@`` you see here is so any additional parameters to ``project`` are sent through to the actual JAR file.
		
5. We need to be able to execute that command. Do ``chmod +x project``
6. Now change directory to somewhere else and try the ``project`` command. If all goes well, you should get a listing of your projects!