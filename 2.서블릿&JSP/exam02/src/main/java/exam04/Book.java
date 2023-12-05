package exam04;

import exam03.B;

public class Book {
    private String title;
    private String author;
    private String publisher;

    private Book(){} // private라 외부에서 접근하지 못한다.

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    protected static class Builder {
        private Book instance = new Book();

        public Builder title(String title) { // instance 안에 title 설정
            instance.title = title;

            return this; // 본인 객체를 참조할 수있게 반환
        }

        public Builder author(String author) {
            instance.author = author;

            return this;
        }

        public Builder publisher(String publisher){
            instance.publisher = publisher;

            return this;
        }
        public Book build() {
            return instance;
        }
    }
}
