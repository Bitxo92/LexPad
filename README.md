# LexPad

## Overview
This Java application implements a simple Notepad with various features such as file operations, text formatting, color themes, and undo/redo functionality. It uses Swing for the GUI components.

## Features
- **File Menu**: Allows creation of new files, opening existing files, saving files, and exiting the application.
- **Edit Menu**: Provides undo and redo functionality.
- **Format Menu**: Options for word wrapping and changing font size and type (Arial, Comic Sans MS, Times New Roman).
- **Color Menu**: Themes available include Light, Dark, and Matrix.
- **Text Area**: Supports key listener for shortcuts and includes undo/redo through `UndoManager`.

## Usage
1. **File Operations**: Use the "File" menu to create new files, open existing ones, save, or save as.
2. **Edit**: Undo or redo changes using the corresponding options under the "Edit" menu.
3. **Format**: Toggle word wrapping, change font type, and adjust font size under the "Format" menu.
4. **Color**: Select different color themes (Light, Dark, Matrix) under the "Color" menu.

## Shortcuts
- **New**: `File > New`
- **Open**: `File > Open` or `Ctrl + O`
- **Save**: `File > Save` or `Ctrl + S`
- **Save As**: `File > Save As`
- **Exit**: `File > Exit`
- **Undo**: `Edit > Undo` or `Ctrl + Z`
- **Redo**: `Edit > Redo` or `Ctrl + R`
- **Word Wrap**: `Format > Word Wrap`
- **Font Type**: Select from `Format > Font`
- **Font Size**: Select from `Format > Font Size`
- **Color Theme**: Select from `Color`

## Implementation
The application is structured with separate classes (`Function_File`, `Function_Format`, `Function_Color`, `Function_Edit`) handling specific functionalities, ensuring modular and maintainable code.

## Notes
- Ensure Java SE Development Kit (JDK) is installed to run the application.
- Modify and extend functionalities as per project requirements.

This Notepad package app provides a foundation for a basic text editor with essential features commonly expected in such applications.
