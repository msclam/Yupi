package com.ljw.EnumClass;

/**
 * @author lanjuwen
 * @create 2021-11-18  17:05
 */
public class EnumDefSeason {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season);
        }

        Thread.State[] values = Thread.State.values();
        for (int i = 0; i < values.length; i ++ ) {
            System.out.println(values[i]);
        }

        Season s1 = Season.valueOf("SPRING");
        System.out.println(s1);

        s1.show();
    }
}

interface Info {
    void show();
}

enum Season implements Info {
    SPRING("春天", "SPRING") {
        @Override
        public void show() {
            System.out.println("这是春天季节");
        }
    },
    SUMMER("夏天", "SUMMER") {
        @Override
        public void show() {
            System.out.println("这是夏天季节");
        }
    },
    AUTUMN("秋天", "AUTUMN") {
        @Override
        public void show() {
            System.out.println("这是秋天季节");
        }
    },
    WINTER("冬天", "WINTER") {
        @Override
        public void show() {
            System.out.println("这是冬天季节");
        }
    };

    private String seasonName;
    private String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个方法");
    }
}