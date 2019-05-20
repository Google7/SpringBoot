package test.demo.restful.bean;

public class UserInfo {
    private int userId;
    private String userName;
    private String userPwd;
    private int userSex;
    private int userAge;
    private String userCity;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public int getUserSex() {
        return userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
}
