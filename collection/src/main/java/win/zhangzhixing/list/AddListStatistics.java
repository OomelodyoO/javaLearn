package win.zhangzhixing.list;

public class AddListStatistics {
    private Integer num;

    private Statistics first = new Statistics();
    private Statistics other = new Statistics();
    private Statistics last = new Statistics();

    public AddListStatistics(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Statistics getFirst() {
        return first;
    }

    public void setFirst(Statistics first) {
        this.first = first;
    }

    public Statistics getOther() {
        return other;
    }

    public void setOther(Statistics other) {
        this.other = other;
    }

    public Statistics getLast() {
        return last;
    }

    public void setLast(Statistics last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "ListStatistics{" +
                "num=" + num +
                ", first=" + first +
                ", other=" + other +
                ", last=" + last +
                '}';
    }

    public class Statistics {
        private Long array;
        private Long linked;

        public Long getArray() {
            return array;
        }

        public void setArray(Long array) {
            this.array = array;
        }

        public Long getLinked() {
            return linked;
        }

        public void setLinked(Long linked) {
            this.linked = linked;
        }

        @Override
        public String toString() {
            return "Statistics{" +
                    "array=" + array +
                    ", linked=" + linked +
                    '}';
        }
    }
}
