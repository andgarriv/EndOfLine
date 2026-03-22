# End Of Line

## Running EOL backend locally
EOL is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can run it from the command line:

```
git clone https://github.com/gii-is-DP1/DP1--2023-2024-l4-4
cd DP1--2023-2024-l4-4
./mvnw install
./mvnw spring-boot:run
```

You can then access EOL backend here: [http://localhost:8080/](http://localhost:8080/swagger-ui/index.html)

## Database configuration

In its default configuration, EOL uses an in-memory database (H2) which
gets populated at startup with data. The INSERTs are specified in the file data.sql.

## Working with EOL in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 21 or newer.
* Node.js 18 or newer.
* git command line tool (https://help.github.com/articles/set-up-git).
* Your preferred IDE.

### Steps:

1) On the command line
```
git clone https://github.com/gii-is-DP1/DP1--2023-2024-l4-4
cd DP1--2023-2024-l4-4
mvn install
mvn spring-boot:run
```

2) Inside the IDE

 - A run configuration named `EndOfLineApplication` should have been created for you if you're using a recent Ultimate
 version. Otherwise, run the application by right clicking on the `EndOfLineApplication` main class and choosing
 `Run 'EndOfLineApplication'`.

4) Navigate to EOL
Visit [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) in your browser to see the swagger doc.

## Starting the frontend

The EOL is implemented with a React frontend in the folder named "frontend".
You can start the development server to see frontend using the command (maybe you should use the command npm insall prior to this):
```
npm install
npm start
```

You can then access the EOL frontend at [http://localhost:3000](http://localhost:3000)

## Run Postman collection

To execute the tests made in Postman, you must follow these steps:

1) Have Node.js installed.
2) Install Newman with the following command:

```
npm install -g newman
```
If you encounter an error during the installation of Newman, visit the following link and follow its steps: [[https://www.npmjs.com/package/newman](https://learn.microsoft.com/es-es/troubleshoot/azure/active-directory/cannot-run-scripts-powershell)]

3) Once we have installed Postman, we go to the corresponding folder which is:
```
\DP1--2023-2024-l4-4\src\test\java\us\l4_4\dp1\end_of_line\PostmanTest
```
4) Once in that folder, and with the backend running, we execute the following command:
```
newman run '.\Postman Collection'
```
5) To conclude, once the execution is finished, you will see the results of the tests in the console.

## EOL UML
![UML EOL](https://github.com/gii-is-DP1/DP1--2023-2024-l4-4/assets/91954520/08c31bf0-80dc-4e62-b773-b6fe3df53e88)

