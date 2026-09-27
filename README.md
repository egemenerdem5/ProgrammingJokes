# Programming Jokes App

A modern Android application built with **Kotlin** and **Jetpack Compose** that fetches and lists programming jokes from the **SV443 JokeAPI**.

---

## 🚀 Features

- 🤖 **Programming Jokes**: Automatically fetches programming-related jokes from the SV443 JokeAPI.
- 🃏 **Multiple Joke Types**: Seamlessly handles both single-line jokes and two-part (setup + delivery) jokes.
- 🔄 **Refresh Capability**: Refresh button to instantly fetch a new batch of jokes.
- 🎨 **Material 3 Design**: Uses modern Material 3 components with edge-to-edge layout support.
- ⚡ **Reactive State Management**: Handles Loading, Success, and Error states gracefully with retry support.

---

## 🛠️ Tech Stack & Architecture

This application strictly follows **Android Best Practices** and **MVVM Architecture**:

- **UI Layer**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3 components (`LazyColumn`, `Scaffold`, `Card`, `CenterAlignedTopAppBar`).
- **Architecture**: **MVVM** (Model-View-ViewModel) using `StateFlow` and `ViewModel`.
- **Networking**: [Retrofit 2](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson) for REST API deserialization.
- **Asynchronous**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for non-blocking network calls.
- **Dependency Management**: Gradle Version Catalog (`libs.versions.toml`).

---

## 📁 Project Structure

```
com.egemenerdem.jokesai
├── data
│   ├── api
│   │   ├── JokeApiService.kt       # Retrofit API interface
│   │   └── RetrofitClient.kt       # Singleton Retrofit client
│   ├── model
│   │   ├── Joke.kt                 # Domain data model
│   │   ├── JokeDto.kt              # API DTO model
│   │   └── JokeResponse.kt         # API response wrapper
│   └── repository
│       └── JokeRepository.kt       # Repository handling data fetching and mapping
├── ui
│   ├── components
│   │   └── JokeCard.kt             # Reusable composable for joke cards
│   ├── screens
│   │   └── JokesScreen.kt          # Main screen composable with LazyColumn
│   ├── theme                       # App colors, typography, and themes
│   └── viewmodel
│       └── JokesViewModel.kt       # ViewModel exposing StateFlow UiState
└── MainActivity.kt                 # Single Activity entry point
```

---

## 💻 Getting Started

### Prerequisites
- **Android Studio**: Ladybug / Hedgehog or newer
- **JDK**: 17 or higher
- **Android Device / Emulator**: Android 7.0 (API level 24) or higher

### Build & Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/JokesAI.git
   ```
2. Open the project in **Android Studio**.
3. Let Gradle sync dependencies automatically.
4. Select an emulator or connected device and press **Run (`Shift + F10`)**.

---

## 🌐 API Reference

Jokes are powered by the open-source **[SV443 JokeAPI](https://v2.jokeapi.dev/)**:
- Endpoint: `GET https://v2.jokeapi.dev/joke/Programming?amount=10`

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
