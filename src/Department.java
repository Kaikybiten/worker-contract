public class Department {
    private final String name;

    public Department(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department: " + this.name;
    }
}
