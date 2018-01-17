
class Contact {

    Contact(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getMobile() {
        return mobile;
    }

    void setMobile(String mobile) {
        this.mobile = mobile;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }


    public String toString(){
        return String.format("name=%s, mobile=%s, email=%s ", name, mobile, email);
    }

    private String name;
    private String mobile;
    private String email;

}

