package controllers.admin;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate sdate;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate edate;
}
