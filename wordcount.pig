A = LOAD '/tmp/alice.txt';
B = FOREACH A GENERATE FLATTEN(TOKENIZE((chararray)$0)) AS word;
C = FILTER B BY word matches '\\w+';
D = GROUP C BY word;
E = FOREACH D generate COUNT(C) AS count, group;
F = ORDER E BY count;

dump F; -- STORE F INTO '/tmp/wordcount';
