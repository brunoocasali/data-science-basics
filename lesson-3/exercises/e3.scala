// Lendo o arquivo
val rdd = sc.textFile("/data/data/E2/registrosPlacas.txt")

// PARTE 1:

// mapear apenas as placas dos veículos
val vehicles = rdd.map(l => l.split(",")(0))
// somar a cada aparição da placa o valor 1
val vehiclesMapped = vehicles.map(w => (w, 1))
// agrupar pela placa e mostrar os top 5 veículos com mais aparições
val topVehicles = vehiclesMapped.reduceByKey(_ + _).top(5)


// PARTE 2:
// Lendo o arquivo
val rdd = sc.textFile("/data/data/E2/registrosPlacas.txt")

// criar uma lista com placa e velocidade
val lines = rdd.map(l => (l.split(",")(0), l.split("\\t").last.split(" ")(0).toInt))

// verificar qual é o máximo
val topSpeed = lines.reduce((acc, value) => { if(acc._2 < value._2) value else acc })


// PARTE 3:
// Lendo o arquivo
val rdd = sc.textFile("/data/data/E2/registrosPlacas.txt")

// criar uma lista com placa e velocidade
val lines = rdd.map(l => (l.split(",")(0), l.split("\\t").last.split(" ")(0).toInt))
// => (EBN1854, 60), (EBN1854, 50), (ABC1234, 80)

// Agregar as linhas usando as chaves armazenando a quantidade de aparições e a soma de cada value
val avg = lines.aggregateByKey((0, 0))((key, value) => (key._1 + value, key._2 + 1), (key1, key2) => (key1._1 + key2._1, key1._2 + key2._2))
// => (EBN1854, (110, 2)), (ABC1234, (80, 1))

// Mapear apenas sobre o array (value) 
val mappedAverages = avg.mapValues(x => (x._1 / x._2))
// => (EBN1854, 55), (ABC1234, 80)

// verificar qual é a maior média
val topSpeed = mappedAverages.reduce((acc, value) => { if(acc._2 < value._2) value else acc })
