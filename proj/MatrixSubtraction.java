package proj;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixSubtraction extends Configured implements Tool {

    public static class FirstSubMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String[] cell = value.toString().trim().split("\t");
            context.write(new Text(cell[0]+":"+cell[1]), new Text(cell[2]));
        }
    }

    public static class SecondSubMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            
            String[] cell = value.toString().trim().split("\t");
            double dval=Double.parseDouble(cell[2]);
            dval=dval*-1;
            context.write(new Text(cell[0]+":"+cell[1]), new Text(String.valueOf(dval)));
        }
    }

    public static class SubReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            
            double csum=0;
            for (Text val : values) {
            	String tval=val.toString();
            	csum+= Double.parseDouble(tval);
            }
            String[] cell=key.toString().split(":");
            context.write(new Text(cell[0]+"\t"+cell[1]), new Text(String.valueOf(csum)));
        }
    }

    public int run(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.printf("Usage: %s [generic options] <input> <output>\n", getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        // create a configuration
        Configuration conf = new Configuration();

        // create a job
        Job job = Job.getInstance(conf, "Matrix Subtraction");
        job.setJarByClass(MatrixSubtraction.class);
        job.setReducerClass(SubReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // Multiple input paths: one for each Mapper
        // No need to use job.setMapperClass()
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FirstSubMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, SecondSubMapper.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        return job.waitForCompletion(true)? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new MatrixSubtraction(), args);
        if (exitCode == 1) {
            System.exit(exitCode);
        }
    }
}

