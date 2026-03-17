import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("S001",new Student("Nazima",3.5,20));
        students.put("S002",new Student("Jaina",3.5,20));
        students.put("S003",new Student("Elenora",3.6,19));
        students.put("S004",new Student("Atabek",3.8,21));
        students.put("S005",new Student("Nurdin",3.9,20));

        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("=== All Students ===");
        for(Map.Entry<String,Student> entry : students.entrySet()){
            System.out.println("ID: " + entry.getKey() + "->" + entry.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println("\n=== Find by ID ===");
        String searchId = "S003";
        Student found = students.get(searchId);
        if(found != null){
            System.out.println("Found " + searchId + ":" + found );
        }else{
            System.out.println("Student with ID " + searchId + "not found " );
        }

        // TODO: Удали одного студента по ID
        System.out.println("\n=== Remove Student ===");
        String removeId = "S004";
        if(students.remove(removeId) != null){
            System.out.println("Removed student with ID:" + removeId);
        }

        // TODO: Обнови GPA у одного студента
        System.out.println("\n=== Update GPA ===");
        String updateId = "S001";
        if(students.containsKey(updateId)){
            students.get(updateId).setGpa(3.8);
            System.out.println("Updated " + updateId + "GPA to 3.8");
        }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> studentList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        System.out.println("\n=== Sorted by GPA (Ascending) ===");
        Collections.sort(studentList);
        studentList.forEach(System.out::println);
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        System.out.println("\n=== Sorted by Name (Ascending) ===");
        studentList.sort(Comparator.comparing(Student::getName));
        studentList.forEach(System.out::println);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> topGpaList = new ArrayList<>(students.values());
        topGpaList.sort(Comparator.comparingDouble(Student::getGpa).reversed());

        int limit = Math.min(3, topGpaList.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(" Top " + (i + 1) + ": " + topGpaList.get(i));
        }
        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaGroups = new HashMap<>();

        for (Student s : students.values()) {
            // computeIfAbsent создаёт новый список, если ключа ещё нет
            gpaGroups.computeIfAbsent(s.getGpa(), k -> new ArrayList<>())
                    .add(s.getName());
        }

        boolean foundDuplicates = false;
        for (Map.Entry<Double, List<String>> entry : gpaGroups.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + " → " +
                        String.join(", ", entry.getValue()));
                foundDuplicates = true;
            }
        }
        if (!foundDuplicates) {
            System.out.println("No duplicate GPAs found.");
        }
        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course java = new Course("Java Programming");
        Course math = new Course("Mathematics");
        Course history = new Course("World History");

        courseMap.computeIfAbsent(java, k -> new ArrayList<>())
                .add(students.get("S001")); // Ali
        courseMap.computeIfAbsent(java, k -> new ArrayList<>())
                .add(students.get("S003")); // Cina

        courseMap.computeIfAbsent(math, k -> new ArrayList<>())
                .add(students.get("S002")); // Bek
        courseMap.computeIfAbsent(math, k -> new ArrayList<>())
                .add(students.get("S005")); // Elena

        courseMap.computeIfAbsent(history, k -> new ArrayList<>())
                .add(students.get("S001")); // Ali (takes multiple courses)


        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.print(entry.getKey() + " → [");
            List<String> names = entry.getValue().stream()
                    .map(Student::getName)
                    .collect(Collectors.toList());
            System.out.println(String.join(", ", names) + "]");
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй

        List<Student> complexSortList = new ArrayList<>(students.values());

        complexSortList.sort(
                Comparator.comparingDouble(Student::getGpa).reversed()  // 1. GPA ↓
                        .thenComparing(Student::getName)              // 2. Name ↑
        );

        complexSortList.forEach(System.out::println);

        System.out.println("\n All Tasks Completed Successfully!");
    }
}



