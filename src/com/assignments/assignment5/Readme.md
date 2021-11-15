# Assignment 5 - Due on Nov 14th 2021

Github link : https://github.com/kpavan95/CS5343/blob/main/src/com/assignments/assignment5/

## Requirements
- JDK 8 and above installed

## Zip file
As part of the submission, a zip file will be provided which will have 3 items
- Assignment folder: It's a java project which contains the code . Note: you can also go to the above Github link and look at the code.
- assignment5.jar: It's the executable file to run the program. Instructions to run it are provided below in the Execution Instruction section
- This readme file in pdf format

## Build Program
Note: the executable jar is already provided as part of the assignment submission so the jar can be downloaded and this part can be skipped.

- Download the source folder submitted or download it from the github link.
- Open terminal and change directory to the root folder
- Create a binary folder to store the .class file

> mkdir bin

- Compile the .java files using the following command

> javac src/com/assignments/assignment5/*.java -d bin/

- change directory to bin folder

> cd bin/

- Create a Executable jar file using the .class files

> jar cfe assignment5.jar com/assignments/assignment5/Assignment5 com/assignments/assignment5/*.class

now the executable assignment5.jar is ready to use.

## Execution Instruction
To run the program, enter the following command in terminal where the executable jar is located

> java -jar assignment5.jar

The program starts and will guide the user through the process. Lets look at it in detail below

The screenshot below shows the program's execution in different stages

![Welcome message](Assignment_5_1.png "Welcome message")

Figure 1: Welcome message

![Graph 1 DFS](Assignment_5_2.png "Graph 1 DFS")

Figure 2: Graph 1 DFS

![Graph 1 BFS](Assignment_5_3.png "Graph 1 BFS")

Figure 3: Graph 1 BFS

![Graph 2 DFS](Assignment_5_4.png "Graph 2 DFS")

Figure 4: Graph 2 DFS

![Graph 2 BFS](Assignment_5_5.png "Graph 2 BFS")

Figure 5: Graph 2 BFS