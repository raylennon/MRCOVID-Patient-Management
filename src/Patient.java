public class Patient {
    public String first;
    public String last;
    public String birth;
    public String address;
    public String city;
    public String state;
    public String email;
    public String phone;
    public Integer zip;
    public Integer sex;
    public Boolean eth;
    public Integer Race;
    public Boolean symptoms;
    public String test;
    public Boolean status;

    public Patient(String first,
                   String last,
                   String birth,
                   String address,
                   String city,
                   String state,
                   String email,
                   String phone,
                   Integer zip,
                   Integer sex,
                   Boolean eth,
                   Integer Race,
                   Boolean symptoms,
                   String test,
                   Boolean status) {
        this.first = first;
        this.last = last;
        this.birth = birth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
        this.sex = sex;
        this.eth = eth;
        this.Race = Race;
        this.symptoms = symptoms;
        this.test = test;
        this.status = status;

    }


}
