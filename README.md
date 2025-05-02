# 📊 clojure-iris-sqlite

This project demonstrates how to use the Clojure programming language to:

- Load a dataset (Iris)
- Store the data in a SQLite database
- Compute basic statistics using Incanter
- Plot an interactive scatter chart

---

## 🚀 Requirements

- Java JDK 11 or higher (with GUI support)
- Leiningen installed (https://leiningen.org)
- A Linux system or other OS with AWT/X11 graphics libraries

---

## 📦 Installation

1. Clone the repository:

2. Install dependencies:

```bash
lein deps
```

3. Run the project:

```bash
lein run
```

This will:

- Read the Iris CSV file from the resources/ folder
- Create the SQLite database (iris.db) if it doesn't exist
- Insert the data into the database
- Compute the mean sepal length
- Display a scatter plot window (requires a GUI environment)

---

## 📁 Project Structure

```
clojure-iris-sqlite/
├── project.clj              # Leiningen project config
├── resources/iris.csv       # Dataset with header
├── src/clojure_iris_sqlite/
│   └── core.clj             # Main application logic
└── target/                  # Build output (ignored by git)
```

---

## 🧪 Example Output

```
Mean sepal length: 5.4
```

A scatter plot will be displayed in a new window.

---

## ✅ Recommended .gitignore

```gitignore
/target/
iris.db
*.class
*.log
.DS_Store
```

---

## 📚 Technologies Used

- Clojure
- Incanter
- SQLite JDBC