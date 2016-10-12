package fileOperation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/* 
 * copy a file from local file system to HDFS
 */
public class TaskSix {
	public static void main(String [] args) throws Exception {
	
		if(args.length != 2){
			System.out.print("Please give the input file path in local "
					+ "directory and out put directory path in HDFS");
			System.exit(0);
		}
		String src = args[0];
		String dst = args[1];
		//InputStream in = new BufferedInputStream(new FileInputStream(src));
		InputStream in = new FileInputStream(src);
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create( new Path (dst));
		IOUtils.copyBytes(in, out, 4000, true);
		
	}
}

