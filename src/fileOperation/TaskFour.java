package fileOperation;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/*
* Will show the list of files, links and sub-directories for given path 
* who have last modified time within the given given range.
*/
public class TaskFour {
	public static void main (String [] args)throws Exception{
		if(args.length < 1 && args.length > 3){
			System.out.println("Please give proper input");
			System.exit(-1);
		}
		long stTime = 0, endTime = Long.MAX_VALUE;
		System.out.println("Given Path: " + args[0]);
		
		Path path = new Path(args[0]);
		// check whether the start time is given or not.
		if(args.length >= 2){
			stTime = Long.parseLong(args[1]);
			if (stTime < 0){
				System.out.println("Please give proper modified timestamp range. "
						+ "Start time is invalid");
				System.exit(-1);
			}
		}
		//check whether the end time is given or not
		if(args.length == 3){
			
			endTime = Long.parseLong(args[2]);
			if (endTime < 0){
				System.out.println("Please give proper modified timestamp range. "
						+ "End time is invalid");
				System.exit(-1);
			}
		}
		fileStatus(path, stTime, endTime);
	}
	
	//Check the file status and print the file/link/directory accordingly
	private static void fileStatus(Path path, long stTime, long endTime) throws Exception{
		try{
		    
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(path.toUri(), conf);
			FileStatus []arrFSts = fs.listStatus(path);
			
			for(FileStatus eachFSts : arrFSts){
				long ltModifiedTime = eachFSts.getModificationTime();
				
				/*if modified time of the file is not in b/w given (not default) range
				 * then skip the file/dir/link */
				if ((stTime != 0 && ltModifiedTime < stTime) || 
				    (endTime != Long.MAX_VALUE && ltModifiedTime > endTime))
					continue;
				
					
				if(eachFSts.isDirectory() == true){
					System.out.print("Directory: \t" + eachFSts.getPath());
				}
				if(eachFSts.isFile() == true){
					System.out.print("File: \t" + eachFSts.getPath());
				}
				if(eachFSts.isSymlink() == true){
					System.out.print("Link: \t" + eachFSts.getPath());
				}
				System.out.println(" [Last modified timestamp: " + ltModifiedTime + "]");
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}		
	}

}
