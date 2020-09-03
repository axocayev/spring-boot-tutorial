package atl.acadamey.studentclient.domain;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private String surname;
    private Double fee;
    private String address;
}
