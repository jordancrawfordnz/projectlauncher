#About#


#Building and Installing#
## Creating a JAR ##
I didn't have any luck with getting ```mvn``` to automatically creat the jar file for me, so in Eclipse I just used:

- Export
- Java/Runnable JAR File


![choose runnable JAR](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/making_jar_1.jpg)

- Library handling should just be "Package required libraries into generated JAR"


![find location and finish](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/making_jar_2.jpg)

- Finish


## Launching globally##
We want to be able to run ```project``` in Terminal from any directory, so:

- Put the JAR from above somewhere easy, like in your applications folder
- ``cd /usr/local/bin``
- ``nano project`` (or your favorite text editor)


![change into local bin and open nano](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/setting_up_1.jpg)

- type: ``java -jar [location of ProjectLauncher.jar] $@``,  in my case: ``java -jar /Applications/ProjectLauncher.jar $@``


![add the required command to project](https://bytebucket.org/jordancrawfordnz/projectlauncher/raw/970cb4fea46547ac8fd542094c57b4befd568252/images/setting_up_2.jpg)

The ``$@`` you see here is so any additional parameters to ``project`` are sent through to the actual JAR file.
		
- We need to be able to execute that command. Do ``chmod +x project``
- Now change directory to somewhere else and try the ``project`` command. If all goes well, you should get a listing of your projects!