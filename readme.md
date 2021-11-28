# Intro to OOP: project

## Outline
Implementation of a crossword puzzle.
The user is given a grid of squares with different colors.
The user should fill the non-black squares with letters, forming words, names or phrases, by solving clues or instructions given.

## Structure

### Board
Holds a matrix of all the squares.
#### Functions
-init:
* read input matrix and create matrix filled with proper squares.
* initializes answer and input variables
-input: click on square and get input dialog for that square
-check: checks AnswerSquares with answer.

### AbstractSquare
Abstract class, inherited by all the other squares.

#### WhiteSquare
Can be used to fill with a letter.

#### BlackSquare
Just appear black in the gui.

#### BlueSquare
Can be used to give a hint.

#### AnswerSquare
Can be used to enter the answer.
Next to an input variable, they should have a way to be checked.


