# ChatApp API

## Endpoints Overview

### 1. User Registration
- **`POST /api/user`**  
  Register a new user with a username and password.
  - **Response:** `200 OK`

### 2. User Login
- **`POST /api/login`**  
  Log in to get a JWT token.
  - **Response:** `200 OK` with token  
  - **Failure:** `401 Unauthorized`

### 3. List Chats (Requires Authentication)
- **`GET /api/chats`**  
  List all chats for the logged-in user, sorted by date.
  - **Response:** `200 OK`

### 4. Search User (Requires Authentication)
- **`POST /api/user/{userid}`**  
  Search for a user by their ID.
  - **Response:** `200 OK`  
  - **Failure:** `404 Not Found`

### 5. Start a Chat (Requires Authentication)
- **`POST /api/chats`**  
  Start a new chat or return an existing one.
  - **Response:** `200 OK`

### 6. Send a Message (Requires Authentication)
- **`POST /api/chats/{id}`**  
  Send a message to a specific chat.
  - **Response:** `200 OK`

### 7. Read Messages (Requires Authentication)
- **`GET /api/chats/{id}`**  
  Retrieve all messages from a chat, sorted by date.
  - **Response:** `200 OK`

### 8. Add Participant to Chat (Requires Authentication)
- **`PUT /api/chats/{id}`**  
  Add a new participant to an existing chat.
  - **Response:** `200 OK`


