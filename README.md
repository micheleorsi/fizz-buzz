# Fizz Buzz

## Usage

In order to run the application, you should use the following command.

```bash
mvn clean package exec:java -Dexec.args="<number>" -DskipTests=true
```
_\<number\> has to be substituted with a real number (10 for example)_

Otherwise you can build the jar and run it
```bash
mvn clean package -DskipTests=true
java -jar target/fizz-buzz-1.0-SNAPSHOT.jar <number>
```
_\<number\> has to be substituted with a real number (10 for example)_

## Test

Launch all the tests:

```bash
mvn clean test 
```

