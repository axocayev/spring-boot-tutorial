package az.atlacademy.valdiations.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductRequest {
    @NotNull(message = "Name required!!!")
    private String name;
    private String description;
    private Double price;
    @Size(max = 100,min = 5, message = "Company name must be between 5 and 100")
    private String company;

    @Max(value = 1, message = "Status must be 0 or 1!!")
    @Min(value = 0, message = "Status must be 0 or 1!!")
    private Integer status;
}
