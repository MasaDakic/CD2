# CD2

This project is a Java application using Quarkus and MySQL. It includes comprehensive instructions for setting up and running the application locally and in a Docker container. 

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Starting the MySQL Database with XAMPP](#starting-the-mysql-database-with-xampp)
  - [Running the Application](#running-the-application)
  - [Building and Running with Docker](#building-and-running-with-docker)
- [API Endpoints](#api-endpoints)
- [Built With](#built-with)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed on your machine:

- Java 17
- Maven
- XAMPP for MySQL
- Docker
- Docker Compose

### Starting the MySQL Database with XAMPP

1. Download and install [XAMPP](https://www.apachefriends.org/index.html).
2. Open the XAMPP Control Panel.
3. Start the MySQL module.
4. Access phpMyAdmin at [http://localhost/phpmyadmin](http://localhost/phpmyadmin).

### Running the Application

1. Clone the repository to your local machine:

    ```bash
    git clone <repository-url>
    cd cd2
    ```

2. Navigate to the project directory.
3. Run the application in development mode with live coding:

    ```bash
    ./mvnw compile quarkus:dev
    ```

4. The application will be accessible at [http://localhost:8080](http://localhost:8080).

### Building and Running with Docker

1. **Build the Quarkus Application:**

    ```bash
    ./mvnw package
    ```

    This will create a JAR file in the `target` directory.

2. **Create Docker Image:**

    ```bash
    docker build -f src/main/docker/Dockerfile.jvm -t cd2 .
    ```

    This command builds the Docker image using the `Dockerfile.jvm`.

3. **Run Docker Container:**

    ```bash
    docker run -p 8080:8080 -d --name cd2-container cd2
    ```

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

4. **Pull and Run MySQL Docker Image:**

    To access the MySQL bash console:

    ```bash
    docker run -it mysql /bin/bash
    ```

5. **Inspect Docker Container:**

    ```bash
    docker inspect <container-name>
    ```

    Replace `<container-name>` with the name of the running container.

6. **Connect to MySQL:**

    ```bash
    mysql -h <ip-address> -u root -p
    ```

    Replace `<ip-address>` with the IP address of the MySQL container.

7. **Using Docker Compose:**

    Ensure you have a `docker-compose.yml` file. To build and run all images specified in it:

    ```bash
    docker-compose up --build
    ```

## API Endpoints

Here are some example endpoints you can access:

- `GET /doctors`: Returns a list of all doctors.
- `GET /doctors/{id}`: Returns the doctor with the specified ID.

Please replace `{id}` with the ID of the doctor you want to access or modify.

## Built With

- [Quarkus](https://quarkus.io/) - Supersonic Subatomic Java framework.
- [MySQL](https://www.mysql.com/) - The world's most popular open-source database.
- [XAMPP](https://www.apachefriends.org/index.html) - A free and easy to install Apache distribution containing MySQL, PHP, and Perl.
- [Docker](https://www.docker.com/) - A platform for developing, shipping, and running applications in containers.
