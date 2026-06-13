# Golf Performance Tracker ⛳

Android application built for the Rapsodo Android Assignment.

## Overview

Golf Performance Tracker allows users to browse golf players, analyze performance metrics, view shot statistics, and access data offline.

The application demonstrates modern Android development practices using MVVM Architecture, Clean Architecture, Room Persistence, Hilt Dependency Injection, Retrofit Networking, Kotlin Coroutines, StateFlow, Repository Pattern, and Jetpack Compose.

---

## Features

### Player Management

- View all golf players
- Search and filter players by name or club
- Display player avatars
- Display player performance metrics
- Modern card-based UI

### Player Details

- Player profile information
- Average ball speed
- Average carry distance
- Handicap information
- Club information
- Recent shot history

### Shot Analytics

- Recent shots list
- Ball speed analysis
- Carry distance analysis
- Launch angle tracking
- Spin rate tracking
- Club type tracking

### Analytics Dashboard

- Distance Distribution Chart
- Speed vs Distance Analysis
- Club Usage Chart
- Performance Insights

### Offline Support

- Room database caching
- Offline-first architecture
- Local persistence
- Data synchronization

### UI Features

- Material Design 3
- Jetpack Compose
- Light Theme
- Dark Theme
- Analytics animations
- Responsive layouts
- Avatar support
- Modern Material UI

---

## Tech Stack

### Language

- Kotlin

### Architecture

- MVVM Architecture
- Clean Architecture
- Repository Pattern
- Single Source of Truth
- Offline-First Design

### Libraries

- Jetpack Compose
- Hilt
- Retrofit
- Room
- Coroutines
- StateFlow
- Navigation Compose
- Coil
- Gson
- Material 3

---

## Concurrency & State Management

The application leverages Kotlin Coroutines and StateFlow for asynchronous processing and reactive state management.

### Coroutines

Coroutines are used for:

- Network requests
- Database operations
- Background processing
- Repository operations
- Lifecycle-aware execution

Benefits:

- Lightweight compared to Threads
- Structured concurrency
- Better performance
- Improved maintainability
- Simplified asynchronous programming

### StateFlow

StateFlow is used for:

- UI state management
- Search state updates
- Analytics data updates
- Offline cache observation
- Reactive UI rendering

Benefits:

- Lifecycle-aware observation
- Automatic UI updates
- Seamless Jetpack Compose integration
- Efficient state management

### Why Coroutines Instead of Threads?

The application avoids manual Thread management and uses Coroutines because:

- Coroutines are lightweight
- Better Android lifecycle integration
- Reduced memory leak risks
- Structured concurrency support
- Cleaner and more maintainable code

---

## Project Structure

text data ├── local │   ├── dao │   ├── database │   ├── entity │   └── mapper │ ├── remote │   ├── adapters │   └── api │ └── repository  domain ├── model └── repository  presentation ├── analytics ├── navigation ├── players ├── playerdetails └── components  di ├── DatabaseModule ├── NetworkModule └── RepositoryModule

---

## Architecture

text Presentation Layer        │        ▼     ViewModel        │        ▼     Repository        │    ┌───┴────┐    ▼        ▼  Remote    Room    API    Database

The Repository acts as the Single Source of Truth and coordinates data between the network layer and local database.

---

## Offline First Strategy

The application follows an Offline-First Architecture.

### Data Flow

1. Data is fetched from the remote API.
2. Data is cached locally using Room.
3. UI observes local data using StateFlow.
4. Users can continue using the application without network connectivity.
5. Data remains available across app restarts.

### Benefits

- Faster loading times
- Improved user experience
- Reduced network dependency
- Persistent local storage
- Better reliability

---

## Screens

### Players List

Features:

- Player avatars
- Search functionality
- Player statistics overview
- Performance summaries

### Search & Filter

Features:

- Search by player name
- Search by club
- Real-time filtering

### Player Details

Features:

- Profile information
- Performance metrics
- Handicap information
- Club information

### Recent Shots

Features:

- Shot history
- Ball speed
- Carry distance
- Launch angle
- Spin rate

### Analytics Dashboard

Features:

- Distance distribution visualization
- Speed vs distance comparison
- Club usage analytics
- Performance insights

---

## Screenshots

### Players List

Players List

### Search & Filter

Search Filter

### Player Details

Player Details

### Recent Shots

Recent Shots

### Analytics Dashboard (Dark Mode)

Analytics Dashboard

---

## Setup Instructions

### Clone Repository

bash git clone https://github.com/prachisinha21/GolfPerformanceTracker.git

### Open Project

1. Open Android Studio
2. Select Open
3. Choose the cloned project folder
4. Allow Gradle Sync to complete

### Run Application

1. Start an Android Emulator or connect a physical device
2. Click Run
3. Launch the application

---

## Assignment Highlights

- MVVM Architecture
- Clean Architecture
- Repository Pattern
- Single Source of Truth
- Offline-First Design
- Room Database Integration
- Retrofit Networking
- Hilt Dependency Injection
- Kotlin Coroutines
- StateFlow
- Search & Filter Functionality
- Analytics Dashboard
- Dark Theme Support
- Avatar Support
- Jetpack Compose UI
- Material Design 3
- Reactive State Management
- Modern Android Development Practices

---

## Author

Prachi Sinha

GitHub: https://github.com/prachisinha21