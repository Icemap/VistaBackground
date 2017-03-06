package com.wqz.vista.pojo;

public class User {
    private Integer id;

    private Integer age;

    private Integer income;

    private String homeaddress;

    private String workaddress;

    private Integer projid;

    private String vistamatrix;

    private String vistaresult;

    private String hold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress == null ? null : workaddress.trim();
    }

    public Integer getProjid() {
        return projid;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public String getVistamatrix() {
        return vistamatrix;
    }

    public void setVistamatrix(String vistamatrix) {
        this.vistamatrix = vistamatrix == null ? null : vistamatrix.trim();
    }

    public String getVistaresult() {
        return vistaresult;
    }

    public void setVistaresult(String vistaresult) {
        this.vistaresult = vistaresult == null ? null : vistaresult.trim();
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold == null ? null : hold.trim();
    }
}