// remove directory after starts
import scala.sys.process._
"rm -r /data/data/E1/result" !

// Lendo o arquivo
val rdd = sc.textFile("/data/data/E1/texto.txt")
// quebrando as linhas por vírgula
val words = rdd.flatMap { l => l.split(",") }
// quebrando as "quebras" por espaços
val wordsf = rdd.flatMap(_.split("\\W+"))
// para cada item crie um map de chave e valor
val wordsMap = wordsf.map(w => (w, 1))
// agregue os valores
val wordCounts = wordsMap.reduceByKey(_ + _)
// ordene os valores agregados previamente
val sortData = wordCounts.sortByKey(true).sortBy(_._2, false)

// exiba
//sortData.collect().foreach(println)
sortData.saveAsTextFile("/data/data/E1/result")