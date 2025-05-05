# CurrencySwapp 💱

CurrencySwapp is a Java-based currency conversion tool that fetches real-time exchange rates from an external API. It allows users to convert currencies, including personalized options.
---
## 🚀 Features

- Convert common currencies (USD, EUR, GBP, JPY, etc.).
- Choose custom currency pairs for conversion.
- Fetch the latest exchange rates from an API.
- Validate user input to prevent incorrect values.
- Handle API errors gracefully.
- Structured logging and exception handling.
---
## 🏗 Project Structure
CurrencySwapp/
│── src/
│   ├── main/
│   │   ├── java/com/currencyswapp/
│   │   │   ├── api/
│   │   │   │   ├── ExchangeRate.java
│   │   │   ├── console/
│   │   │   │   ├── ConsoleUI.java
│   │   │   ├── exception/
│   │   │   │   ├── InvalidAmountException.java
│   │   │   │   ├── UnableToGetConversionRate.java
│   │   │   ├── main/
│   │   │   │   ├── CurrencySwapp.java
│   │   │   ├── model/
│   │   │   │   ├── ConversionResult.java
│   │   │   ├── service/
│   │   │   │   ├── ConverterService.java
│── .gitignore
│── README.md

---
## 🔧 Installation & Setup

1. Clone the repository:
   ```bash
   https://github.com/TomasMoralesR/currency-converter-java.git

2. Open the project in your Java IDE (IntelliJ, Eclipse, VS Code).
3. Ensure Java 17+ is installed.
4. Set up dependencies (e.g., Gson for JSON parsing).
5. Create a .env file in the project root
   API_KEY=YOUR-API-KEY
6. Run CurrencySwapp.java.
---
## 📌 Usage
### Basic Conversion
- Start the application.
- Select an option from the menu (e.g., USD → COP).
- View the converted result.
### Custom Conversion
- Choose "Custom Swap" from the menu.
- Enter the base currency (e.g., USD).
- Enter the target currency (e.g., EUR).
- Enter the amount to convert.
- View the converted result.
---
## Error Handling
- If an invalid amount is entered (negative or non-numeric), the system prompts the user.
- If an invalid currency code is entered, the system displays valid options.
- If the API request fails, a detailed error message is shown.
- If the API key cannot be loaded, an exception (UnableToLoadApiKey) is thrown, prompting users to check their configuration.
##  🛠 Technologies Used
- Java 17 – Core language
- Gson – JSON parsing
- HttpClient – API requests
---
## 🤝 Contributions
Feel free to open a pull request if you want to improve the project. Suggestions and feedback are welcome! 
---
## 🧑‍💻 Autor
Tomás Morales R. para el challenge Alura Latam | ONE

https://github.com/TomasMoralesR



