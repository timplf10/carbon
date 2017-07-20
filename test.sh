pwd 

ls -al bin

rm bin/Calculator.class
rm bin/CalculatorTest.class

javac src/Calculator.java -d bin

javac -cp "/code/junit/junit-4.11.jar":bin -d bin test/CalculatorTest.java

java -cp "/code/junit/junit-4.11.jar":"c:/code/hamcrest/hamcrest-all-1.3.jar":bin org.junit.runner.JUnitCore CalculatorTest
