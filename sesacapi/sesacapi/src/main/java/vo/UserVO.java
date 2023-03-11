package vo;


//vo => readonly -  set을 쓰면 안된다. get만 쓴다.
public class UserVO {
    private String name;
    private String age;

    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }

}
