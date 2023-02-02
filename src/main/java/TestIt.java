import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import com.ververica.cdc.connectors.sqlserver.*;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;

public class TestIt {
	
	// localhost port database tableList username password 
	public static void main(String[] args) throws Exception {
	    SourceFunction<String> sourceFunction = SqlServerSource.<String>builder()
	      .hostname(args[0])
	      .port(Integer.parseInt(args[1]))
	      .database(args[2]) // monitor sqlserver database
	      .tableList(args[3]) // monitor products table
	      .username(args[4])
	      .password(args[5])
	      .deserializer(new JsonDebeziumDeserializationSchema()) // converts SourceRecord to JSON String
	      .build();

	    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

	    env
	      .addSource(sourceFunction)
	      .print().setParallelism(1); // use parallelism 1 for sink to keep message ordering

	    env.execute();
	  }
}
