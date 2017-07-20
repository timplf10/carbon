pwd 

rm bin/Calculator.class
rm bin/CalculatorTest.class
rm bin/birchtest/*.class

javac src/Calculator.java -d bin
#javac test/birchtest/*java -d bin

javac -cp "/code/junit/junit-4.11.jar":bin -d bin test/CalculatorTest.java
javac -cp "/code/junit/junit-4.11.jar":bin -d bin test/birchtest/TestAA.java

java -cp "/code/junit/junit-4.11.jar":"c:/code/hamcrest/hamcrest-all-1.3.jar":bin org.junit.runner.JUnitCore CalculatorTest

java -cp "/code/junit/junit-4.11.jar":"c:/code/hamcrest/hamcrest-all-1.3.jar":jarf/zzz.jar:bin org.junit.runner.JUnitCore birchtest.TestAA
