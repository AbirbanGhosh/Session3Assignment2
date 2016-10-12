There are three classes for each task. Each class has its own main method so they can use seperatly. 


Task 4:
Write a java program to list down all the files inside a directory and its sub-directories who have last modified timestamp between the start_ts and end_ts passed as an argument. The default value of start_ts is 0 and for end_ts is infinite.
Class: fileOperation.TaskFour
command line example: 
hadoop jar Session3Assignment2.jar fileOperation.TaskFour /user 1476024611376 1476024611376


Task 5:
Write a Java program to display the content of a file in HDFS on screen.
class: fileOperation.TaskFive
command line example: 
hadoop jar Session3Assignment2.jar fileOperation.TaskFive /user/acadgild/hadoop/test.txt


Task 6:
Write a Java program to copy a file from local filesystem to HDFS.
class: fileOperation.TaskSix
command line example: 
hadoop jar Session3Assignment2.jar fileOperation.TaskSix test.txt /user/acadgild/hadoop/test111.txt