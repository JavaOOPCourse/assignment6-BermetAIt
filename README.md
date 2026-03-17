[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/fidu9KtL)
# 🎓 Student Management System (Java)

This project implements a **Student Management System** using Java
collections and object‑oriented programming concepts.

The goal is to practice working with: - `HashMap` - `Comparable` -
`Comparator` - Custom keys in maps - Sorting and grouping logic


# Deadline:   17.03 (23:59)

------------------------------------------------------------------------

# 📂 Project Structure

    src/
     ├── Student.java
     ├── Course.java
     └── Main.java


------------------------------------------------------------------------


# 📌 Task 1 --- Student Management System (CORE TASK)

Create a system using:

    HashMap<String, Student>

Where:

-   **Key** → `student ID`
-   **Value** → `Student object (name, GPA, age)`

### Requirements

1.  Add **5+ students**
2.  Print all students
3.  Find student by **ID**
4.  Remove a student
5.  Update **GPA**

### Sorting (IMPORTANT)

Sort students by:

-   **GPA** (using `Comparable`)
-   **Name** (using `Comparator`)

------------------------------------------------------------------------

# 📌 Task 2 --- Top K Students

From all students:

Print **Top 3 students by GPA**.

### Hint

1.  Convert:


    map.values() → ArrayList

2.  Sort the list.

------------------------------------------------------------------------

# 📌 Task 3 --- Duplicate GPA Detection

Find students that have the **same GPA**.

### Example Output

    GPA 3.5 → Ali, Bek

### Hint

Use:

    HashMap<Double, List<String>>

------------------------------------------------------------------------

# 📌 Task 4 --- Custom Key

Use a **custom class as a key**.

    class Course {
        String name;
    }

Create:

    HashMap<Course, List<Student>>

### Requirements

-   Override `equals()` and `hashCode()`
-   Add students to courses
-   Print all courses with students

------------------------------------------------------------------------

# 📌 Task 5 --- Comparator Logic Challenge

Sort students by:

1.  **GPA descending**
2.  If GPA is equal → **sort by name**

------------------------------------------------------------------------

# 👨‍💻 Author

Munara eje
