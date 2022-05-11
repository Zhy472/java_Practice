package demo;

public enum Season {
    SPRING("春天","春天来了"),
    SUMMER("夏天","夏天来了"),
    AUTUMN("秋天","秋天来了"),
    WINTER("冬天","冰天来了");

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他需求：根据需要定义
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }


}
