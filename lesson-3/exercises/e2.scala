// remove directory after starts
import scala.sys.process._
"rm -r /data/data/E2/result" !

// Lendo o arquivo
val rdd = sc.textFile("/data/data/E2/logs.txt")
// transformando as linhas em minúsculas
val lines = rdd.map(_.toLowerCase())
// pegar apenas as linhas com erro
val linesWithErrors = lines.filter { l => l.contains("erro") }
// pegar as linhas com erro no início
val logs = linesWithErrors.filter { _.split("\\s+")(0) == "erro" }

// exiba
logs.saveAsTextFile("/data/data/E2/result")