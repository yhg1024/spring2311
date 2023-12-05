package exam04;

import lombok.Builder;
import lombok.ToString;

@Builder // 내부의 정적 클래스로
@ToString
public class Book2 {
    private String title;
    private String author;
    private String publisher;
}
