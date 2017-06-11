package org.global.fairy.bigdata.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.global.fairy.bigdata.type.DataWritable;

public class DataTotalMapReduce {
	// Mpper Class
	static class DataTotalMapper extends
			Mapper<LongWritable, Text, Text, DataWritable> {
		private Text mapOutputKey = new Text();
		private DataWritable dataWritable = new DataWritable();

		@Override
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String lineValue = value.toString();

			// split
			String[] strs = lineValue.split(" ");

			// get Data
			String phoneNum = strs[0];
			int upPackNum = Integer.valueOf(strs[6]);
			int upPayLoad = Integer.valueOf(strs[7]);
			int downPackNum = Integer.valueOf(strs[8]);
			int downPayLoad = Integer.valueOf(strs[9]);

			// set output key /value
			mapOutputKey.set(phoneNum);
			dataWritable.set(upPackNum, upPayLoad, downPackNum, downPayLoad);

			context.write(mapOutputKey, dataWritable);
		}

	}

	// Reducer Class
	static class DataTotalReducer extends
			Reducer<Text, DataWritable, Text, DataWritable> {

		private DataWritable dataWritable = new DataWritable();

		@Override
		protected void reduce(Text key, Iterable<DataWritable> values,
				Context context) throws IOException, InterruptedException {
			int upPackNum = 0;
			int upPayLoad = 0;
			int downPackNum = 0;
			int downPayLoad = 0;
			// iterator
			for (DataWritable data : values) {
				upPackNum += data.getUpPackNum();
				upPayLoad += data.getUpPayLoad();
				downPackNum += data.getDownPackNum();
				downPayLoad += data.getDownPayLoad();
			}

			// set dataWritable
			dataWritable.set(upPackNum, upPayLoad, downPackNum, downPayLoad);

			// reduce/job的output
			context.write(key, dataWritable);
		}

	}

	// DriverCodes
	public int run(String[] args) throws IOException, ClassNotFoundException,
			InterruptedException {
		// get Conf
		Configuration conf = new Configuration();

		// create Job
		Job job = new Job(conf, DataTotalMapReduce.class.getSimpleName());

		// 设置job
		job.setJarByClass(DataTotalMapReduce.class);

		// 1）input
		Path inputPath = new Path(args[0]);
		FileInputFormat.addInputPath(job, inputPath);
		// 2) map
		job.setMapperClass(DataTotalMapReduce.DataTotalMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DataWritable.class);
		// 3) reduce
		job.setReducerClass(DataTotalMapReduce.DataTotalReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DataWritable.class);
		// 4) output
		Path outputPath = new Path(args[1]);
		FileOutputFormat.setOutputPath(job, outputPath);
		// 5) submits
		boolean isSuccess = job.waitForCompletion(true);
		return isSuccess ? 0 : 1;
	}

	// run mapreduce
	public static void main(String[] args) throws ClassNotFoundException,
			IOException, InterruptedException {
		args = new String[] {
				// input path
				"hdfs://hadoop-master:9000/opt/data/testDataTotal",
				// output path
				"hdfs://hadoop-master:9000/opt/data/test3s/output/datatotal1"

		};

		// 运行 job
		int succStatus = new DataTotalMapReduce().run(args);

		// 退出
		System.exit(succStatus);
	}
}
