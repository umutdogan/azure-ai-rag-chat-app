# Azure AI RAG Chat App

This project is created to demonstrate basic usage of Azure AI services. 
The project is a simple Retrieval-Augmented Generation (RAG) chat app that 
uses Azure AI services endpoint to generate responses to user queries.

Full tutorial can be found [here](https://umutdogan.com/posts/2024-12-17-rag-chat-app-with-azure-ai-studio-spring-boot-react/).

### Modules

There are two modules in this project:
1. UI: A React app that provides a simple chat interface to interact with the chatbot.
2. Backend: A Spring Boot app that provides REST API to interact with Azure AI services.

### Prerequisites
- Java 17+
- Maven
- Node.js
- npm
- Azure AI services account
- Azure AI services endpoint
- Azure AI services key
- Git
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Instructions
1. Clone the repository to your local machine.
2. Open the project in your IDE.
3. Add `AZURE_AI_ENDPOINT` and `AZURE_AI_KEY` environment variables to your system variables. 
> On macOS, you can set the environment variable in your shell profile 
      (e.g., .bash_profile, .zshrc) and Reload the shell profile:
```
    export AZURE_AI_ENDPOINT=your_actual_endpoint
    export AZURE_AI_API_KEY=your_actual_api_key
    source ~/.zshrc  # or source ~/.bash_profile
```
> On Windows, you can set the environment variable in the system settings or using the command line:
```
    setx AZURE_AI_ENDPOINT your_actual_endpoint
    setx AZURE_AI_API_KEY your_actual_api_key    
```
> Ensure the environment variable is available to your application. When running your Spring Boot application, make sure the environment variable is set. If you are using IntelliJ IDEA, you can set environment variables in the run configuration.
4. In the root of the project, run `mvn clean install` from terminal.
5. In the `backend` module, to run the Spring Boot app, run `mvn spring-boot:run` from terminal.
5. In the `ui` module, first run `npm install` and then to run the React app, run `npm start` from terminal.
6. Open the browser and navigate to `http://localhost:3000/`.
7. Start chatting with the chatbot.
8. Enjoy!