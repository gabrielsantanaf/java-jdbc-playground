package domain.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Seller {
    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private  Double baseSalary;
    private Integer departmentId;

    public Seller(String name, String email, String birthDate, Double baseSalary, Integer departmentId) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            this.name = name;
            this.email = email;
            this.birthDate = sdf.parse(birthDate);
            this.baseSalary = baseSalary;
            this.departmentId = departmentId;
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }
}
