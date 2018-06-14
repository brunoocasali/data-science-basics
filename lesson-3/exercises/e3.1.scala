// sed 's/\t/,/g' /data/data/E2/registrosPlacas.txt > /data/data/E2/fines.txt

val hc = new org.apache.spark.sql.hive.HiveContext(sc)

hc.sql("CREATE TABLE IF NOT EXISTS fines(plate string, code int, city string, created string, speed string) ROW FORMAT DELIMITED FIELDS TERMINATED BY ','")

hc.sql("LOAD DATA LOCAL INPATH '/data/data/E2/fines.txt' INTO TABLE fines")

// pegar quem tem mais registros
val maxQtd = hc.sql("SELECT first(plate), MAX(qtd) FROM (SELECT plate, COUNT(plate) as qtd FROM fines GROUP BY plate) t").collect().foreach(println)

// qual veículo teve a maior velocidade
val max = hc.sql("SELECT first(plate), MAX(CAST(REPLACE(speed, ' km/h', '') AS FLOAT)) AS speed FROM fines").collect().foreach(println)

// qual veículo teve a maior velocidade média
val maxMedia = hc.sql("SELECT first(plate), MAX(speed) FROM (SELECT plate, AVG(CAST(REPLACE(speed, ' km/h', '') AS FLOAT)) AS speed FROM fines GROUP BY plate) t").collect().foreach(println)