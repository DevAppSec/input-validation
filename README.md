# Input Validation API

This project is to ensure that an input is valid.

## Requirements

For building and running the application you need:

- JDK 13
- Gradle

## Running the application locally

1. Open the project in IntelliJ
2. Set up your IntelliJ settings
3. Open the InputValidationApplication class
4. Run the application

## Running the application in a Docker image

1. Open terminal
2. Go to the project directory
3. Run the following command to build the Docker image
```
make docker-build
```
4. Run the following command to run the Docker image
```
make docker-run
```

## Deploying the application to Google Kubernetes Engine

GitHub actions automatically deploys your application to Google Kubernetes Engine

## Contributing
Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request