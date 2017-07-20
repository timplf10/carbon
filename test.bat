del bin\Calculator.class
del bin\CalculatorTest.class

javac src/Calculator.java -d bin

javac -cp "c:/code/External Java Jars/junit-4.12.jar";bin -d bin test/CalculatorTest.java

java -cp "c:/code/External Java Jars/junit-4.12.jar";"c:/code/External Java Jars/hamcrest-core-1.3.jar";bin org.junit.runner.JUnitCore CalculatorTest
