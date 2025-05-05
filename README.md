# 🧑‍💻 Job Portal - Spring Boot REST API + React Frontend
This project is a **Job Posting Web Application** built using **Spring Boot (Java)** for the backend and **React.js** for the frontend.
---
### Backend (Spring Boot)
- **RESTful API** built with Java and Spring Boot.
- Stores job postings in memory (use List).
- Exposes endpoints to:
  - View all job posts
  - View a single job post by ID
  - Add a new job post
  - Update an existing job post
  - Delete a job post
### Frontend (React)
- Built using **React.js**.
- Fetches and displays job posts from the backend.
  --> From Github user |

### Backend
- Java 21+
- Spring Boot
- Spring Web
- RESTful APIs

### Frontend
- React.js
- Axios (for API calls)
- Bootstrap or Tailwind CSS (optional for styling)

## 🔗 API Endpoints

| Method | Endpoint             | Description                     |
|--------|----------------------|---------------------------------|
| GET    | `/jobPosts`          | Get all job posts               |
| GET    | `/jobPost/{postId}`  | Get job post by ID              |
| POST   | `/jobPost`           | Add new job post                |
| PUT    | `/jobPost`           | Update existing job post        |
| DELETE | `/jobPost/{postId}`  | Delete job post by ID           |

**Note**: All endpoints support `application/json`. CORS is enabled for React frontend on `http://localhost:3000`.

## 🎥 Demo Video

Watch a short demo of the Job Portal application in action:

