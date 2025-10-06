public class StudentManagement {
    private Student[] students;
    private int size;

    public StudentManagement() {
        students = new Student[100];
        size = 0;
    }


    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Them sinh vien.
     */
    public void addStudent(Student newStudent) {
        if (size < students.length) {
            students[size] = newStudent;
            size++;
        } else {
            System.out.println("Full");
        }
    }

    /**
     * Goi sinh vien theo group.
     */
    public String studentsByGroup() {
        String result = "";
        boolean[] printed = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!printed[i]) {
                String currentGroup = students[i].getGroup();
                result +=  currentGroup + "\n";
                for (int j = i; j < size; j++) {
                    if (!printed[j] && sameGroup(students[i], students[j])) {
                        result += students[j].getInfo() + "\n";
                        printed[j] = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Xoa sinh vien.
     */
    public void removeStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < size; j++) {
                    students[j] =  students[j + 1];
                }
                students[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        // TODO:
    }
}
