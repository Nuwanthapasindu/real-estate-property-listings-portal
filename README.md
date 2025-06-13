# Real Estate Property Listings Portal

## Description

This is a JSP-based web application designed for listing real estate properties. It provides users with the ability to view, search, and manage property listings. The application is built using Java for backend logic, JSP for dynamic web pages, Bootstrap 5 for styling, and JSON files for data storage. A Binary Search Tree is implemented to ensure efficient sorting and searching of property listings.

## Technologies Used

- **Backend:** Java 11, Jakarta Servlet API
- **Frontend:** JSP, Bootstrap 5
- **Data Storage:** File-based JSON (using Jackson library)
- **Data Structures:** Binary Search Tree
- **Build Tool:** Apache Maven
- **Email:** Jakarta Mail (previously JavaMail)

## Features

- Dynamic property listing
- Search functionality with filters
- User-friendly interface with Bootstrap 5
- Efficient sorting and searching using a Binary Search Tree

## Project Structure

- `pom.xml`: Defines project dependencies, plugins, and build settings for Maven.
- `src/main/java/`: Contains the Java source code for the application's backend logic, including servlets, data models, and business logic.
- `src/main/webapp/`: Holds web application resources, including JSP files, CSS stylesheets, JavaScript files, and images.
  - `WEB-INF/`: Contains configuration files like `web.xml` and compiled servlet classes (though classes are typically managed by the build process).
- `LICENSE`: Contains the project's license information.
- `README.md`: This file, providing an overview of the project.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Nuwanthapasindu/real-estate-property-listings-portal.git
   ```

2. Navigate to the project directory:
   ```bash
   cd real-estate-property-listings-portal
   ```

3. Set up the environment:
   - Ensure you have Java installed (JDK 11 or later).

4. Build the project using Maven:
   ```bash
   mvn clean install
   ```
   This will generate a WAR file in the `target` directory.

5. Run the application:
   - Use a servlet container like Apache Tomcat to deploy the `target/real-estate-property-listings-portal.war` file.
   - Alternatively, if using an IDE like Eclipse or IntelliJ IDEA, configure the project and run it directly.

## Contributing

- Nuwanthapasindu
- PCK123-Max
- Janiduloneth
- PamudiManjarie
- ChamikaR04
- chamod778
- chamod778
- rehandesilva

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
