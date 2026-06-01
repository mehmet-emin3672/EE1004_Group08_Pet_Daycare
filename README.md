## Project Overview
This project is a **Pet Daycare Management System** developed as part of the EE1004 Java Programming course at Marmara University (Faculty of Engineering, Department of Electrical and Electronics Engineering). The application provides an interactive platform to register pets, monitor their daily meal plans, keep track of feeding schedules, and review localized care instructions.

The software is structured to fully demonstrate the core tenets of Object-Oriented Programming (OOP) in Java and features both a terminal-based interface and an interactive Graphical User Interface (GUI).

---

## Environment Specifications
To ensure perfect reproducibility by the grading team, the application has been built and verified under the following environment configurations:
- **Operating System:** Fedora Linux (compatible across all major POSIX and Windows platforms)
- **Java Development Kit (JDK):** OpenJDK 17 (or higher)
- **Compiler toolchain:** Standard Java Compiler (`javac`)
- **Locale Setting:** `Locale.US` (ensuring dot-separated decimal systems for numeric outputs)

---

## Project Directory Structure
The repository splits functionality cleanly across isolated class files. To prevent repository pollution, compiled `.class` files are hidden using a `.gitignore` profile.


```

```text
README.md generated successfully.

```text
EE1004_Group08_PetCareManager/
 ├── .gitignore                  # Prevents committing compiled bytecode files
 ├── README.md                   # Build, environment, and system documentation
 └── src/                        # Source folder containing clean Java files
      ├── Pet.java               # Abstract base class defining fundamental pet attributes
      ├── Dog.java               # Concrete subclass specifying canine attributes and feeding metrics
      ├── Cat.java               # Concrete subclass specifying feline attributes and feeding metrics
      ├── Bird.java              # Concrete subclass specifying avian attributes and feeding metrics
      ├── PetDaycare.java        # Aggregator/Manager class implementing collection logic
      ├── Main.java              # Command-line menu application interface
      └── DaycareGUI.java        # Graphical User Interface featuring a real-time log terminal

```

---

## How to Build and Run

### 1. Compilation

Navigate to the root directory of your project folder where the `src/` directory is located and compile all files together using the command terminal:

```bash
javac src/*.java

```

This command translates your human-readable source files into cross-platform Java bytecode (`.class` files).

### 2. Launching the GUI Application (Recommended for Bonus)

To execute the application with its full graphical user interface, launch the compiled `DaycareGUI` bytecode:

```bash
java -cp src DaycareGUI

```

### 3. Launching the Console Version

If you prefer to run the application within the traditional command terminal, execute the standard `Main` class instead:

```bash
java -cp src Main

```

---

## OOP Implementation Architecture

The software fulfills the mandatory system design specifications outlined in the project manual:

1. **Abstraction:** Implemented via the `abstract class Pet` which leaves standard actions like `getCareInstructions()` and `toString()` abstract to prevent direct initialization of a generic "Pet".
2. **Inheritance:** `Dog`, `Cat`, and `Bird` extend the `Pet` class to leverage shared base fields (`name`, `age`, `ownerName`) while enforcing subclass-specific constants (e.g., specific weights and daily meal divisions).
3. **Polymorphism:** Leverages runtime binding via an overridden `toString()` model. Additionally, custom anonymous inner implementations are utilized to safely intercept `System.out` routines and format GUI components on the Event Dispatch Thread (EDT).
4. **Encapsulation & Aggregation:** The `PetDaycare` class securely binds components by maintaining a `private List<Pet>` data matrix. Controlled item modification and verification are performed safely via robust conditional methods without exposing raw object arrays.

---

## Authors & Contribution Disclosure

* **Course Title:** Java Programming (EE1004)
* **Academic Institution:** Marmara University
* **Academic Term:** Spring 2025-2026
* *This project code and accompanying documentation are deployed under academic integrity guidelines. Artificial Intelligence tools were referenced for runtime pipeline optimization and GUI stream redirection setups.*

``
