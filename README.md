# Golf Performance Tracker

Android application built for the Rapsodo Android Assignment.

## Overview

Golf Performance Tracker allows users to browse golf players, analyze performance metrics, view shot statistics, and access data offline.

The application demonstrates modern Android development practices using MVVM architecture, Room persistence, Hilt dependency injection, Retrofit networking, Coroutines, StateFlow, and Jetpack Compose.

---

## Features

### Player Management

* View all golf players
* Search and filter players by name or club
* Display player performance metrics

### Player Details

* Player profile information
* Average ball speed
* Average carry distance
* Handicap information
* Club information

### Shot Analytics

* Recent shots list
* Ball speed
* Carry distance
* Launch angle
* Spin rate
* Club type

### Analytics Dashboard

* Distance Distribution Chart
* Speed vs Distance Analysis
* Club Usage Chart

### Offline Support

* Room database caching
* Offline-first architecture
* Local persistence

### UI Features

* Material Design 3
* Jetpack Compose
* Light Theme
* Dark Theme
* Analytics animations

---

## Tech Stack

### Language

* Kotlin

### Architecture

* MVVM
* Repository Pattern
* Single Source of Truth

### Libraries

* Jetpack Compose
* Hilt
* Retrofit
* Room
* Coroutines
* StateFlow
* Material 3

---

## Project Structure

```text
data
├── local
│   ├── dao
│   ├── database
│   ├── entity
│   └── mapper
│
├── remote
│   ├── adapters
│   └── api
│
└── repository

domain
├── model
└── repository

presentation
├── analytics
├── navigation
├── players
└── playerdetails

di
├── DatabaseModule
├── NetworkModule
└── RepositoryModule
```

---

## Architecture

```text
Presentation Layer
       │
       ▼
    ViewModel
       │
       ▼
    Repository
       │
   ┌───┴────┐
   ▼        ▼
 Remote    Room
   API    Database
```

The Repository acts as the Single Source of Truth and coordinates data between the network and local storage.

---

## Offline First Strategy

The application follows an offline-first architecture.

1. Data is fetched from the remote API.
2. Data is cached locally using Room.
3. UI observes local data through StateFlow.
4. Users can continue using the application without network connectivity.

Benefits:

* Faster loading
* Better user experience
* Reduced network dependency
* Persistent local storage

---

## Screenshots

### Players List

![Players List](./screenshots/01_players_list.png)

### Search & Filter

![Search Filter](./screenshots/02_search_filter.png)

### Player Details

![Player Details](./screenshots/03_player_details.png)

### Recent Shots

![Recent Shots](./screenshots/04_recent_shots.png)

### Analytics Dashboard (Dark Mode)

![Analytics Dashboard](./screenshots/05_analytics_dark_mode.png)

---

## Setup Instructions

### Clone Repository

```bash
git clone https://github.com/prachisinha21/GolfPerformanceTracker.git
```

### Open Project

1. Open Android Studio
2. Select **Open**
3. Choose the cloned project folder
4. Allow Gradle Sync to complete

### Run Application

1. Start an Android Emulator or connect a physical device
2. Click **Run**
3. Launch the application

---

## Assignment Highlights

* MVVM Architecture
* Repository Pattern
* Offline-First Design
* Room Database Integration
* Hilt Dependency Injection
* Retrofit Networking
* Search & Filter Functionality
* Analytics Dashboard
* Dark Theme Support
* Jetpack Compose UI
* Material Design 3

---

## Author

**Prachi Sinha**

GitHub:
https://github.com/prachisinha21
