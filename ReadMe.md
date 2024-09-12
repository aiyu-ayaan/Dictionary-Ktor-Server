# Dictionary-Ktor-Server

A simple Dictionary API using Ktor Server and Kotlin Multiplatform Project (KMP). This project fetches word definitions
from an external dictionary API.

## Features

- **Ktor Server** for handling requests.
- **HTTP Client** to fetch word definitions from a third-party API.
- **Timeouts** configured to handle network delays.

## Prerequisites

- [Kotlin](https://kotlinlang.org/) installed on your machine.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) with KMP support.
- [Ktor](https://ktor.io/) for creating the server.

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-github-username/Dictionary-KMP.git
cd Dictionary-KMP
```

### Setting Up the Ktor Server

1. Open the project in IntelliJ IDEA.

### Running the Application

1. Use the following command to run your Ktor server:

   ```bash
   ./gradlew run
   ```

2. The server will be running on `http://localhost:9090/`.

### API Endpoints

#### Get Welcome Message

```http
GET /
```

**Response:**

```json
{
  "message": "Welcome to Dictionary API"
}
```

#### Get Word Definition

```http
GET /word/{word}
```

**Example Request:**

```http
GET /word/example
```

**Response:**

Returns the JSON response from [Dictionary API](https://dictionaryapi.dev/).

```json
[
   {
      "word": "example",
      "phonetic": "/əɡˈzæmpl̩/",
      "phonetics": [
         {
            "text": "/əɡˈzæmpl̩/",
            "audio": ""
         },
         {
            "text": "/ɘɡˈzɐːmpɯ/",
            "audio": ""
         },
         {
            "text": "/ɪɡˈzɑːmpl̩/",
            "audio": ""
         },
         {
            "text": "/əɡˈzæmpl̩/",
            "audio": "https://api.dictionaryapi.dev/media/pronunciations/en/example-us.mp3",
            "sourceUrl": "https://commons.wikimedia.org/w/index.php?curid=267013"
         }
      ],
      "meanings": [
         {
            "partOfSpeech": "noun",
            "definitions": [
               {
                  "definition": "Something that is representative of all such things in a group.",
                  "synonyms": [],
                  "antonyms": []
               },
               {
                  "definition": "Something that serves to illustrate or explain a rule.",
                  "synonyms": [],
                  "antonyms": []
               },
               {
                  "definition": "Something that serves as a pattern of behaviour to be imitated (a good example) or not to be imitated (a bad example).",
                  "synonyms": [],
                  "antonyms": []
               },
               {
                  "definition": "A person punished as a warning to others.",
                  "synonyms": [],
                  "antonyms": []
               },
               {
                  "definition": "A parallel or closely similar case, especially when serving as a precedent or model.",
                  "synonyms": [],
                  "antonyms": []
               },
               {
                  "definition": "An instance (as a problem to be solved) serving to illustrate the rule or precept or to act as an exercise in the application of the rule.",
                  "synonyms": [],
                  "antonyms": []
               }
            ],
            "synonyms": [],
            "antonyms": []
         },
         {
            "partOfSpeech": "verb",
            "definitions": [
               {
                  "definition": "To be illustrated or exemplified (by).",
                  "synonyms": [],
                  "antonyms": []
               }
            ],
            "synonyms": [],
            "antonyms": []
         }
      ],
      "license": {
         "name": "CC BY-SA 3.0",
         "url": "https://creativecommons.org/licenses/by-sa/3.0"
      },
      "sourceUrls": [
         "https://en.wiktionary.org/wiki/example"
      ]
   }
]
```

### Error Handling

If an error occurs (e.g., invalid word or network issue), you'll get the following response:

```json
{
  "error": "An error occurred"
}
```

### Configuration

You can configure the timeouts in the `configureRouting` function:

```kotlin
install(HttpTimeout) {
    requestTimeoutMillis = 30000 // 30 seconds
    connectTimeoutMillis = 30000 // 30 seconds
}
```

### Project Structure

- `Application.kt`: Contains the routing logic and API integration.
- `build.gradle.kts`: The Gradle configuration file.

### Dictionary API

This project uses the [Dictionary API](https://dictionaryapi.dev/) to fetch word meanings.

## License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for more details.

## GitHub

[Dictionary KMP GitHub Repo](https://github.com/aiyu-ayaan/Dictionary-KMP)

```

Make sure to replace the `your-github-username` with your actual GitHub username and update version numbers of the Ktor dependencies accordingly.