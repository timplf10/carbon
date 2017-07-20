rm bin/birch/*class
rm bin/*class

javac src/*java -d bin
javac src/birch/*java -d bin

jar cf jarf/birchx.jar  bin/birch/*class

ls -al jarf/*

java -classpath bin birch.Main
