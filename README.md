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

- data
    - local
        - dao
        - database
        - entity
        - mapper
    - remote
        - adapters
        - api
    - repository
- domain
    - model
    - repository
- presentation
    - analytics
    - navigation
    - players
    - playerdetails
    - components
- di
    - DatabaseModule
    - NetworkModule
    - RepositoryModule

---

## Architecture

- UI Layer: Jetpack Compose screens render the user interface.
- ViewModel Layer: ViewModels manage UI state and expose StateFlow to the UI.
- Repository Layer: Repository acts as the Single Source of Truth.
- Remote Layer: Retrofit API fetches data from the network.
- Local Layer: Room Database stores cached data for offline access.

The Repository coordinates data between the network layer and local database.

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

- Player avatars
- Search functionality
- Player statistics overview
- Performance summaries

### Search & Filter

- Search by player name
- Search by club
- Real-time filtering

### Player Details

- Profile information
- Performance metrics
- Handicap information
- Club information

### Recent Shots

- Shot history
- Ball speed
- Carry distance
- Launch angle
- Spin rate

### Analytics Dashboard

- Distance distribution visualization
- Speed vs distance comparison
- Club usage analytics
- Performance insights

---

## Screenshots

Add screenshots in the repository under a folder named `screenshots`.

Recommended file names:

- `01_players_list.png`
- `02_search_filter.png`
- `03_player_details.png`
- `04_recent_shots.png`
- `05_analytics_dark_mode.png`
- `06_dark_mode.png`

After adding the files, screenshots will be available at:

- screenshots/01_players_list.png
- screenshots/02_search_filter.png
- screenshots/03_player_details.png
- screenshots/04_recent_shots.png
- screenshots/05_analytics_dark_mode.png

---

## Setup Instructions

### Clone Repository

```bash
git clone https://github.com/prachisinha21/GolfPerformanceTracker.git