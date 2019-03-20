package com.malik.main;

import com.malik.config.MongoConfig;
import com.mongodb.spark.MongoSpark;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import static java.util.Collections.singletonList;

public class ReadMain {
    public static void main(String[] args) {

        // Instantiate config
        MongoConfig mongoConfig = new MongoConfig(args[0]);

        // Instantiate Spark
        SparkSession sparkSession = SparkSession.builder()
                .appName("ReadMain")
                .config("spark.mongodb.input.uri", mongoConfig.mongoURI())
                .getOrCreate();
        JavaSparkContext sparkContext = new JavaSparkContext(sparkSession.sparkContext());

        // Load data from MongoDB
        MongoSpark.load(sparkContext)
                .withPipeline(singletonList(Document.parse(args[1])))
                .foreach(document -> System.out.println(document.toJson()));
    }
}
