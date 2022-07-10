package edu.miu.cs.cs425.eregistrar.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name="student_number")
    @NotEmpty(message = "Student Number is required")
    private String studentNumber;

    @Column(nullable=false, name="first_name")
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Column( name="middle_name")
    private String middleName;

    @Column(nullable=false, name="last_name")
    @NotEmpty(message = "First name is required")
    private String lastName;

    private Double cgpa;

    @Column(name="enrollment_date")
    @NotNull(message = "Enrollment Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @Column(name="is_international")
    @NotNull(message = "International value is required")
    private Boolean isInternational;
}
