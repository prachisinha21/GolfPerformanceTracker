# Golf Performance Tracker

Android application built for the Rapsodo Android Assignment.

## Overview

Golf Performance Tracker allows users to browse golf players, analyze performance metrics, view shot statistics, and access data offline.

The application demonstrates modern Android development practices using MVVM architecture, Room persistence, Hilt dependency injection, Retrofit networking, Coroutines, and Jetpack Compose.

---

## Features

### Player Management

* View all players
* Search and filter players
* View player performance statistics

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

* Distance Distribution
* Speed vs Distance Analysis
* Club Usage Chart

### Offline Support

* Room database caching
* Offline-first architecture
* Local persistence

### UI Features

* Material Design 3
* Light Theme
* Dark Theme
* Compose-based UI
* Analytics animation

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
API     Room
```

The Repository acts as the Single Source of Truth and coordinates data between the network and local storage.

---

## Offline First Strategy

The application follows an offline-first architecture.

1. Data is fetched from the remote API.
2. Data is cached locally using Room.
3. UI observes Room data through Flow.
4. Users can continue using the application without network connectivity.

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

### Analytics Dashboard

![Analytics](./screenshots/05_analytics_dark_mode.png)

---

## Setup Instructions

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open in Android Studio

3. Sync Gradle

4. Run the application

---

## Assignment Highlights

* MVVM Architecture
* Repository Pattern
* Room Persistence
* Offline-First Design
* Hilt Dependency Injection
* Search & Filter Functionality
* Analytics Dashboard
* Dark Theme Support
* Jetpack Compose UI
* Material Design 3

```
```
