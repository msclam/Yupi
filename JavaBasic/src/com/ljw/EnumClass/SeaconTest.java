package com.ljw.EnumClass;

/**
 * @author lanjuwen
 * @create 2021-11-18  16:12
 */
public class SeaconTest {
    public static void main(String[] args) {
        Seacon spring = Seacon.SPRING;
        System.out.println(spring);
    }
}

class Seacon {
    private final String seasonName;
    private final String seasonDesc;
    // 私有化构造器
    private Seacon(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Seacon SPRING = new Seacon("春天", "SPRING");
    public static final Seacon SUMMER = new Seacon("夏天", "SUMMER");
    public static final Seacon AUTUMN = new Seacon("秋天", "AUTUMN");
    public static final Seacon WINTER = new Seacon("冬天", "WINTER");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Seacon{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
