package src.junit.PageTesting;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/15-09-15-9:23
 * @Description：src.junit.PageTesting
 */
public class User {
    int id;
    String name;
    String gender;
    String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String name, String gender, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
    }
}
