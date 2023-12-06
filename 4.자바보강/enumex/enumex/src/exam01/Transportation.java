package exam01;

public enum Transportation {
    BUS("버스", 1400) {
        @Override
        public int getTotal(int person) {
            return price * person;
        }
    },
    SUBWAY("지하철", 1450) {
        @Override
        public int getTotal(int person) {
            return price * person;
        }
    },
    TAXI("택시", 4500) {
        @Override
        public int getTotal(int person) {
            return price * person;
        }
    }; // 끝에 ';'를 추가해야 한다.

    private final String title; // 정수를 저장할 필드(인스턴스 변수)를 추가
    protected final int price; // protected로 해야 각 상수에서 접근가능

    Transportation(String title, int price) {
        this.title = title;
        this.price = price;
    } // 생성자를 추가, 접근 제어자 private이 생략됨

    public String getTitle() {
        return title;
    } // 외부에서 이 값을 얻을 수 있도록 추가

    public abstract int getTotal(int person); // 사람 수에 따라 요금을 계산하는 추상 메서드
}
