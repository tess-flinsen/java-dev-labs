# Developing Software Using Java - Laboratory Works

## Overview
This repository contains laboratory works for the course "Software developing using Java." Each lab work demonstrates various programming concepts and practices in Java, aimed to deepen the understanding of Java programming language. 

*All labs are done for Variant № 15.*

## Usage
Generally, to run each lab, do the following steps:
1. Clone the repository.
2. Navigate to the project directory.
3. Choose the folder with the lab work needed.
4. Compile and run the Application file of that project.

*For specific usage instructions, see each lab description.*

### Requirements
- Java 8 or higher

--- 
### Lab Work 1: Arrays in Java

#### Overview
The first lab work implements basic matrix operations and is aimed to give understanding of array manipulation in Java.

#### Features
- Multiplication a matrix by a constant value (C5 = 15 % 5 = 0 => C = a * B).
- Finding the sum of the maximum elements in even-indexed rows (C11 = 15 % 11 = 4)
- Finding the sum of the minimum elements in odd-indexed rows. (C11 = 15 % 11 = 4)
- Exceptions handling for invalid inputs and overflow conditions.
- Matrix elements are of type byte (C7 = 15 % 7 = 1)


#### Usage
Change the matrix and the constant in the MatrixApplication file as needed, then save the file, recompile and run again to see the results in CLI.

--- 
### Lab Work 2: Strings in Java

#### Overview
The second lab work implements string processing and enhances the understanding of string manipulation and exception handling in Java.

#### Features
- Replaces words of a specified length in the text with a replacement string. (C17 = 15 % 17 = 15)
- Supports both English and Ukrainian alphabets.
- Counts letters in words excluding numbers and special characters.
- Handles space separation and punctuation.
- Exception handling for:
  - Null inputs for text and replacement strings.
  - Input text length exceeding 1000 characters.
  - Replacement string length exceeding 100 characters.
  - Word length being outside the range of 1 to 30.
- Text type is `StringBuilder` (C3 = 15 % 3 = 0)

#### Usage
Change the input text, word length, and replacement string in the `StringApplication` file as needed. You can check the limits for those values in the `TextProcessor` class constructor.

After making changes, save the file, recompile, and run again to see the results in the command line interface (CLI).

--- 
### Lab Work 3: Classes in Java

#### Overview
The third lab work implements a clothing management system that allows users to create clothing objects, sort them based on specific criteria, and find identical clothing items. It enhances understanding of class management in Java through creating unique classes and using existing ones (Arrays, Comparator).

#### Features
- Creates clothing objects with attributes such as name, size, price, color, brand, and material. (C11 = 15 % 11 = 4)
- Sorts clothing objects primarily by name in ascending order and secondarily by price in descending order.
- Searches for a specific clothing item in an array based on all attributes.
- Exception handling for:
  - Invalid input for clothing attributes.
  - Price limits ranging from 0.01 to 100 000.
  - Character limits for string attributes (1 to 100 characters).
- Includes following classes: Clothing, ClothingManager, ClothingApplication.

#### Usage
Modify the clothing objects in the `ClothingApplication` file to create different clothing items as needed.
Save the file, recompile, and run the application to see the results in the command line interface (CLI).

---
### Lab Work 5: Inheritance and Polymorphism

#### Overview
The fifth lab work implements an electrical appliances management system that allows users to manage various appliances, including washing machines, microwaves, and vacuum cleaners. This project enhances the understanding of object-oriented programming concepts in Java through the creation and manipulation of class hierarchies and the use of inheritance and interfaces.

#### Features
- Creates appliance objects and manages specific appliance types, including **WashingMachine**, **Microwave**, **RobotVacuum** and **HandheldVacuum**. (C13 = 15 % 13 = 2)
- Provides methods to:
  - Turn appliances on and off
  - Calculate the total power consumption of all active appliances.
  - Sort active appliances by power.
  - Find appliances based on electromagnetic radiation levels.
- Implements exception handling.

#### Usage
1. Modify the appliance objects in the `ElectronicsApplication` file to create different appliances as needed.
2. Save the file, recompile, and run the application to see the results in the command line interface (CLI).
3. Interact with the system by turning appliances on, calculating power consumption, and sorting or searching for appliances based on specified criteria.

#### Class Hierarchy
The project features a structured class hierarchy for managing electrical appliances:
- **Appliance**: The abstract base class with common attributes and methods.
  - **Microwave**: Extends `Appliance` with attributes like capacity and max output power.
  - **WashingMachine**: Extends `Appliance`, adding drum size and spin speed.
  - **VacuumCleaner**: An abstract subclass of `Appliance`.
    - **RobotVacuum**: Inherits from `VacuumCleaner` with a battery life attribute.
    - **HandheldVacuum**: Inherits from `VacuumCleaner` with weight and dust container capacity attributes.

- **Apartment**: Manages an array of `Appliance` objects, allowing operations like turning on appliances, calculating total power consumption, sorting appliances, and finding appliances based on radiation levels.

---
### Lab Work 6: Working with Collection in Java programming language

#### Overview
The sixth lab work involves creating a custom collection class that implements the `Set` interface and manages a collection of electrical appliances. This project reinforces understanding of Java collection frameworks, generics, and custom data structures, while building on the appliance management system from the previous lab.

#### Features
- Implements a custom set collection called **ApplianceSet** for storing unique `Appliance` objects from Lab 5.
- Provides three constructors.
- Implements all method of the Set interface. (C2 = 15 % 2 = 1)
- Has internal structure of an array with an initial capacity of 15 elements and an increase in capacity by 30% (C3 = 15 % 3 = 0)

#### Usage
1. Create and modify appliance objects in the `SetApplication` file, such as instances of **WashingMachine**, **Microwave**, and **RobotVacuum**.
2. Use the provided constructors to initialize the `ApplianceSet` with various appliances.
3. Call methods like `add`, `remove`, `addAll`, `retainAll`, and `removeAll` to manipulate the `ApplianceSet`.
4. Recompile and run the `SetApplication` file to see the results in the command line interface (CLI).
5. Observe the effects of each method, including adding or removing elements and checking for containment.

To find out more about the Appliance class and different Appliance types, please refer to Lab 5.