package data;

import com.github.javafaker.Faker;
import dao.EmployeeDAO;
import model.Employee;

import java.util.Locale;

public class FakeData {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i < 100; i++) {
            Employee e = new Employee();
            e.setFullName(faker.name().nameWithMiddle());
            e.setPhone(faker.phoneNumber().phoneNumber());
            e.setEmail("a" + faker.number().numberBetween(100,1000000) + "bkacad" + faker.number().numberBetween(100,1000000) + "@gmail.com");
            e.setCity(faker.address().cityName());
            e.setGender(faker.number().numberBetween(0, 2));
            e.setSalary(faker.number().numberBetween(1000, 2000));

            employeeDAO.insert(e);
        }

    }
}
