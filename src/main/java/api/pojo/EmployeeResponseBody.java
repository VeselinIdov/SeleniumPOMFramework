package api.pojo;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class EmployeeResponseBody {
    public String status;
    public String message;
    public ArrayList<Data> data;

    @Getter
    public static class Data {
        public int id;
        public String employee_name;
        public int employee_salary;
        public int employee_age;
        public String profile_image;
    }
}