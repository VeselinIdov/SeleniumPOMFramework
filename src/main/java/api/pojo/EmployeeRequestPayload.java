package api.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestPayload {
    private String name;
    private String salary;
    private String age;
}