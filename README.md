# Cell Phone Records Management System

## Description
The **Cell Phone Records Management System** is a Java-based application designed for managing and manipulating a collection of cell phone records using a custom linked list implementation. This project is part of an academic assignment for practicing **Linked Lists**, **Object-Oriented Programming**, and **Deep Copying** concepts without relying on Java’s built-in collection frameworks.

The program provides functionality for adding, deleting, replacing, and searching records while ensuring data integrity and unique serial numbers for cell phones.

## Features
- **Custom Linked List**:
  - Implements a `CellList` class with a linked list of `CellPhone` objects.
  - Includes operations such as adding to the start, inserting at a specific index, deleting nodes, replacing data, and searching for records.
  
- **Deep Copy and Cloning**:
  - Ensures deep copies of the linked list and `CellPhone` objects, preventing data leakage.
  - Supports cloning of individual `CellPhone` objects with unique serial numbers.

- **File Integration**:
  - Reads cell phone data from a text file (`Cell_Info.txt`).
  - Handles duplicate records to ensure each serial number is unique.

- **Demonstration and Testing**:
  - Provides comprehensive tests for constructors and methods, including handling special cases like invalid indices and duplicate serial numbers.

## Key Classes
### 1. **CellPhone**
- Represents a cell phone record with attributes:
  - `serialNum`: Unique identifier for the cell phone.
  - `brand`: Brand name of the phone.
  - `price`: Price of the phone.
  - `year`: Manufacturing year.
- Features include:
  - Cloning (`clone()`): Prompts the user to provide a new serial number for the clone.
  - Equality check (`equals()`): Compares phones while ignoring the serial number.
  - String representation (`toString()`): Displays details of the cell phone.

### 2. **CellList**
- Implements a custom linked list for managing `CellPhone` objects.
- Includes:
  - **Inner Class `CellNode`**:
    - Represents a node in the linked list, containing a `CellPhone` object and a reference to the next node.
  - Methods for:
    - Adding and deleting nodes (`addToStart`, `deleteFromStart`, `deleteFromIndex`).
    - Inserting and replacing nodes (`insertAtIndex`, `replaceAtIndex`).
    - Searching the list (`find`, `contains`).
    - Displaying contents (`showContents`).
  - Deep copy constructor to ensure no shallow copies are made.

### 3. **CellListUtilization**
- The main driver class to demonstrate and test the functionality of the `CellList` and `CellPhone` classes.
- Key functionalities:
  - Reads records from `Cell_Info.txt` and adds them to a `CellList`.
  - Tests all methods of the `CellList` class with various scenarios.
  - Demonstrates privacy leakage risks in the `find()` method.

## Input and Output
### Input
- A text file (`Cell_Info.txt`) containing cell phone records in the format:<br>
|serialNum| |brand| |price| |year| <br>
Example:<br>
1111111 Sony 99.99 2000 2222222 Samsung 199.99 2001

### Output
- Displays the contents of the linked list in a user-friendly format.
- Handles errors such as duplicate serial numbers and invalid indices with appropriate messages.

## How to Run
1. Ensure the `Cell_Info.txt` file is present in the project directory with the required format.
2. Compile the Java files:
   ```bash
   javac *.java
3. Run the Program:
   ```bash
   javac CellListUtilization

