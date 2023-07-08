package employeemanagementsystem;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;

    public Employee(int id, String name, int age, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
