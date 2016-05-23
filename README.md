# kata-converter
A springboot project to convert arabic numbers to roman numbers and vice versa.

This project require the following elements :
- JDK 1.8
- Eclipse 4.X
- Maven 3
- Mysql 5.0 (for the database implementation, otherwise it's not required)

All the librairies or dependencies needed are included with the project.

# Configuration files
- application-local.properties : contains the configuration for connecting to a H2 database and viewing the sql generated for debugging.
- application-intgeration.properties : contains the configuration for conneting to the integration database server.

# Packages structure
- com.kata.configuration : contains all the configuration classes needed for the Spring boot application.
- com.kata.controller : contains all the spring controller classes for exposing the rest web services needed.
- com.kata.enums : contains all the enumerations used inside the application.
- com.kata.exception : contains all the specific class exceptions used inside the application.
- com.kata.model : contains all the bean classes for the definition of the data model and the database tables associated. Only used for the database implementation.
- com.kata.repository : contains all the repository classes needed for querying/insert/update a specific bean. Only used for the database implementation.
- com.kata.services : contains all the services classes used for the two different implementations (enums and model). The classes are responsible to compute arabic numbers to roman numbers and vice versa.

# Web Application
- The files used for the web application are stored inside the src/main/ressources/static folder.
