# CD2

This project is a Java application using Quarkus and MySQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 17
- Maven
- XAMPP for MySQL

### Starting the MySQL Database with XAMPP

1. Download and install [XAMPP](https://www.apachefriends.org/index.html).
2. Open the XAMPP Control Panel.
3. Start the MySQL module.
4. Access the phpMyAdmin at http://localhost/phpmyadmin.

### Running the Application

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the application in development mode with live coding:

```shell script
./mvnw compile quarkus:dev
```

The application will be accessible at http://localhost:8080.

## API Endpoints

Here are some example endpoints you can access:

- `GET /doctors`: Returns a list of all doctors.
- `GET /doctors/{id}`: Returns the doctor with the specified ID.
- `POST /doctors`: Creates a new doctor. The request body should be a JSON object representing the doctor.
- `PUT /doctors/{id}`: Updates the doctor with the specified ID. The request body should be a JSON object representing the updated doctor.
- `DELETE /doctors/{id}`: Deletes the doctor with the specified ID.

Please replace `{id}` with the ID of the doctor you want to access or modify.

## Built With

- [Quarkus](https://quarkus.io/)
- [MySQL](https://www.mysql.com/)
- [XAMPP](https://www.apachefriends.org/index.html)
