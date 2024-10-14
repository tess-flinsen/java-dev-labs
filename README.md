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
