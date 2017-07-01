# Fizz Buzz

## Usage

In order to run the application, you should use the following command.
<number> has to be substituted with a real number (10 for example)

```bash
mvn clean package exec:java -Dexec.args="<number>" -DskipTests=true
```

## Test

Launch all the tests:

```bash
mvn clean verify 
```

