package fileOperation;


import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/* print the contains of a file in HDFS on console. */
public class TaskFive {
	
	public static void main(String[] args)throws Exception {
		if (args.length != 1){
			System.out.println("Please insert one argument");
			System.exit(0);
		}
		String uri = args[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		FSDataInputStream in = null;
		try{
			in = fs.open(new Path(uri));
			IOUtils.copyBytes(in, System.out, 4000, false);
		}
		finally{
			IOUtils.closeStream(in);
		}
	}

};
