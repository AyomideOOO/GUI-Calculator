# GUICalc - Java GUI Calculator

A simple calculator application built using Java Swing with a graphical user interface.  
Supports basic arithmetic operations: addition, subtraction, multiplication, and division.

## Project Overview

This calculator GUI is designed with user-friendly input buttons for numbers, decimal points, operations, and clear functionality.  
The underlying `Calculator` class includes array-based methods for calculations, but this GUI currently uses dedicated methods for addition, subtraction, multiplication, and division to simplify integration with the interface.

### Why two types of methods?

- **Array-based methods** exist in the `Calculator` class for potential future extensions involving multiple operands or batch calculations.
- The GUI currently uses straightforward single-operation methods (`addition`, `subtraction`, etc.) for simplicity and clarity.
- This separation allows easier maintenance and the possibility to extend the functionality later (e.g., supporting more complex calculations or chaining operations).

## Features

- Clickable buttons for digits (0-9) and decimal point.
- Basic arithmetic operators: `+`, `-`, `x`, `/`.
- Clear button to reset the calculation.
- Displays current input and results in a non-editable text field.
- Prevents invalid decimal input and handles consecutive calculations gracefully.

## How to Run

1. Compile the classes:
2. Run the application:

## Usage Instructions

- Use the number buttons to enter the first operand.
- Select an operation button (`+`, `-`, `x`, `/`).
- Enter the second operand.
- Press `=` to compute and display the result.
- Press `C` to clear and start a new calculation.

## Future Improvements

- Integrate the array-based methods from `Calculator` for multi-operand calculations.
- Add support for chaining multiple operations without pressing equals each time.
- Implement keyboard input support.

## License

This project is open source under the MIT License.

