# Journaling API

## Overview
The **Journaling API** is a Spring Boot-based application designed for managing clients, sessions, emotions, and related data in the context of therapeutic journaling. This API provides a set of endpoints to create, retrieve, update, and delete resources related to clients, therapists, sessions, and session notes.

## Features
- **Client Management:** Create, retrieve, and delete client records.
- **Emotion Journal Entries:** Create and manage emotional journal entries for clients.
- **Session Management:** Track and manage therapy sessions.
- **Session Notes:** Record and retrieve session notes for therapists.

## Requirements
- Java 17
- Spring Boot 3.4.x
- MySQL (or any other relational database) for data persistence.

## Setup

### Clone the Repository
Clone this repository to your local machine:

```bash
git clone <repository_url>
```

### Build the Project

Make sure you have [Maven](https://maven.apache.org/) installed. Navigate to the project directory and run:

```bash
mvn clean install
```

### Configure Application Properties

Open the `src/main/resources/application.properties` file and configure the database connection settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/journaling
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

Make sure to replace the database URL, username, and password with your actual credentials.

### Running the Application

Once the project is built, you can run the application using Maven:

```bash
mvn spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

Here is a list of the available API endpoints.

### Client API
- **GET /clients**  
  Get all clients.
  
- **GET /clients/{id}**  
  Get a specific client by ID.
  
- **POST /clients**  
  Create a new client.

- **DELETE /clients/{id}**  
  Delete a client by ID.

### Emotion Journal Entry API
- **GET /emotion-journal**  
  Get all emotion journal entries.
  
- **GET /emotion-journal/{id}**  
  Get a specific emotion journal entry by ID.

- **POST /emotion-journal**  
  Create a new emotion journal entry.

- **DELETE /emotion-journal/{id}**  
  Delete an emotion journal entry by ID.

### Session API
- **GET /sessions**  
  Get all sessions.
  
- **GET /sessions/{id}**  
  Get a specific session by ID.
  
- **POST /sessions**  
  Create a new session.

- **DELETE /sessions/{id}**  
  Delete a session by ID.

### Session Note API
- **GET /session-notes**  
  Get all session notes.
  
- **GET /session-notes/{id}**  
  Get a specific session note by ID.
  
- **POST /session-notes**  
  Create a new session note.

- **DELETE /session-notes/{id}**  
  Delete a session note by ID.

### Therapist API
- **GET /therapists**  
  Get all therapists.
  
- **GET /therapists/{id}**  
  Get a specific therapist by ID.

- **POST /therapists**  
  Create a new therapist.

- **DELETE /therapists/{id}**  
  Delete a therapist by ID.

## How It Works

### 1. **Client Management**
The **Client API** allows the management of client records. Clients are the primary users of the journaling system, and they can be added, viewed, or deleted through the respective endpoints.

### 2. **Emotion Journal Entries**
Clients can create emotional journal entries that describe their feelings during therapy sessions. These entries are stored and retrieved through the **Emotion Journal Entry API**.

### 3. **Session Tracking**
The **Session API** allows the creation and tracking of therapy sessions. Sessions can be associated with clients and therapists. Each session can have corresponding session notes and emotions, which are also managed through dedicated APIs.

### 4. **Session Notes**
Therapists can create session notes to track what happens during each session. These notes are private and used for professional reference. The **Session Note API** is used to create, update, or delete these notes.

### 5. **Therapist Management**
The **Therapist API** allows the management of therapist records. Therapists are the professionals working with the clients, and the API allows you to store their details, including their sessions and session notes.

## Data Flow

1. **Create a Client:**  
   A therapist or admin can create a client record by providing client details through the `POST /clients` endpoint.

2. **Create a Session:**  
   Once a client is registered, a new therapy session can be created via the `POST /sessions` endpoint. Each session is linked to a client and therapist.

3. **Add Emotion Journal Entry:**  
   During therapy, the client can add an emotion journal entry via `POST /emotion-journal`. This entry describes how the client feels during the session and helps track emotional progress over time.

4. **Create Session Notes:**  
   After a session, the therapist can record session notes via `POST /session-notes`. This allows the therapist to note key points discussed during the session.

5. **Managing Data:**  
   Clients, sessions, emotion entries, session notes, and therapists can all be managed via their respective `GET`, `POST`, and `DELETE` endpoints.

## Conclusion

The Journaling API is a robust backend system to manage all data related to therapy sessions, including clients, therapists, emotion journals, and session notes. It provides a complete solution for tracking client progress and therapist activities in therapeutic settings.
