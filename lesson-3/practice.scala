val hc = new org.apache.spark.sql.hive.HiveContext(sc)

hc.sql("CREATE TABLE IF NOT EXISTS movies(cod int, name string, year int, note float, views int) ROW FORMAT DELIMITED FIELDS TERMINATED BY ','")
hc.sql("LOAD DATA LOCAL INPATH '/data/data/movies.txt' INTO TABLE movies")

val mov = hc.sql("FROM movies SELECT name, year, views")

val mov = hc.sql("SELECT * FROM movies WHERE year=1993").collect().foreach(println)
