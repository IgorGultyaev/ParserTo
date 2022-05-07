public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"firstName\":" + "\"" + firstName + "\"" +
                ",\"lastName\":" + "\"" + lastName + "\"" +
                ",\"country\":" + "\"" + country + "\"" +
                ",\"age\":" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Employee.class)) {
            return false;
        }
        Employee comparedEmployee = (Employee) obj;
        return toString().equals(comparedEmployee.toString());
    }
}
