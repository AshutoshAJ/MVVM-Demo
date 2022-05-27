# MVVM Demo
A single screen app which shows a list of Popular Movies.

## Items used
- Retrofit
- ViewModel
- LiveData

## API
[TMDB](https://www.themoviedb.org/) - The Movie Database (Free)  
Login -> Create API key -> Use in project.  
Get started using the API Docs [API Docs](https://developers.themoviedb.org/3/getting-started/introduction).

## Architecture
**MVVM**  
**Model — View — ViewModel (MVVM)** is a industry-recognized software architecture pattern. It suggests separating the data presentation logic(Views or UI) from the core business logic part of the application.

**The separate code layers of MVVM are:**
-   **Model:**  This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
-   **View:**  The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
-   **ViewModel:**  It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.

[Source](https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/)
![MVVM Diagram](https://github.com/AshutoshAJ/ProjectScreenshots/raw/master/MVVMDemo/MVVM-Diagram.png)

## Directory Structure
![Directory Structure](https://github.com/AshutoshAJ/ProjectScreenshots/raw/master/MVVMDemo/MVVM%20Directory%20Structure.PNG)

## Screenshots
![Screenshot](https://github.com/AshutoshAJ/ProjectScreenshots/raw/master/MVVMDemo/Screenshot.jpg)

Made with ❤️ by AJ
