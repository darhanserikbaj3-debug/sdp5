# Notification System (Clean Architecture & Strategy Pattern)

A flexible notification delivery and formatting system implemented in Java using the **Strategy** design pattern, adhering strictly to **Clean Code** principles such as Isolation from Change, the Open-Closed Principle (OCP), and the Dependency Inversion Principle (DIP).

---

## Project Architecture

The project is structured into distinct packages to maintain a clear separation of concerns:

* `Strategies`: Core interfaces defining behavioral contracts (`NotificationStrategy`, `FormattingStrategy`).
* `ConcreteStrategies`: Concrete implementations for formatting (HTML, Markdown, PlainText) and delivery channels (Email, Telegram, SMS).
* `Contexts`: Strategy contexts (`MessageFormattingContext`, `NotificationSenderContext`) enabling dynamic runtime strategy switching.
* `Selector`: Factory selector (`NotificationSelector`) encapsulating conditional logic to eliminate `if`/`switch` statements in client code.
* `ExternalData`: Interfaces and implementations for external data dependencies (`TrafficService`, `SimulatedTrafficService`, `FakeTrafficService` for test isolation).

---

## Key Features

1. **Runtime Strategy Switching:** Allows dynamically altering formatting and delivery algorithms during execution via `setStrategy()` methods.
2. **External Dependency Isolation:** Utilizes test doubles (`FakeTrafficService`) in unit tests to protect core business logic from unstable external dependencies.
3. **Decoupled Client Code:** Completely eliminates conditional logic from `Main` by delegating selection responsibilities to `NotificationSelector`.

---

## Build and Test Execution

### Prerequisites
* **Java:** 11 or higher
* **Build Tool:** Gradle or Maven

UML:

![alt text](<Screenshot 2026-10-21 at 9.29.31 PM.png>)