# MongoSpark
Insert JSON data and query to/from MongoDB using Java and Spark.

<br />
<br />

## Details
### MongoDB
* Database name: test-db
* Collection name: test-collection
* User: admin
* Password: superadmin
* _id: country-city (example: canada-vancouver, united_states-las_vegas)

### Program Arguments
#### Write
args[0]
<pre>
{
  "user": "MongoDB user",
  "password": "MongoDB password",
  "ip": "MongoDB IP address",
  "port": "MongoDB port",
  "database": "Database name",
  "collection": "Collection name"
}
</pre>

args[1]
<pre>/path/city_attributes.json</pre>

#### Read

args[0]
<pre>
{
  "user": "MongoDB user",
  "password": "MongoDB password",
  "ip": "MongoDB IP address",
  "port": "MongoDB port",
  "database": "Database name",
  "collection": "Collection name"
}
</pre>

args[1]
<pre>{ your query }</pre>

<br />
<br />

## How to compile
<pre>mvn install</pre>

<br />
<br />

## Running the program
### Write
<pre>
spark-submit --class com.malik.main.WriteMain --master local[2] malik/engine/MongoSpark-1.0-SNAPSHOT-jar-with-dependencies.jar '{"user":"admin","password":"superadmin","ip":"192.168.20.99","port":"27017","database":"test-db","collection":"test-collection"}' '/home/malik/data/city_attributes.json'
</pre>

### Read
<pre>
spark-submit --class com.malik.main.ReadMain --master local[2] malik/engine/MongoSpark-1.0-SNAPSHOT-jar-with-dependencies.jar '{"user":"admin","password":"superadmin","ip":"192.168.20.99","port":"27017","database":"test-db","collection":"test-collection"}' '{ $match: { country: "Canada" } }'
</pre>
