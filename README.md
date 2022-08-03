## Project Safetynet
Safetynet is a project that loads data from a JSON file in-memory and enables Endpoints for retrieving and editing data.

# Requirements
- JDK 17.0.1
- Apache Maven 3.8.6

# Installation
Use git command to clone the project or download the project as a Zip file.
```bash
git clone https://github.com/tylau-dev/safetynet.git
```

# Usage
1) In a Command Line Interface, move to the directory containing the source code
```bash
cd "CODE_DIRECTORY"
```

2) Run the following command line to run the project
```bash
mvn spring-boot:run
```

3) The Endpoints are ready to use on the port 8080. 
In an API Platform (i.e. Postman), import the Request Collection in the file P05-OC.postman_collection in the directory postman_collection.
The collection contains samples for accessing all the existing requests of the Application.
