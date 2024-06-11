package com.sctpl.admin.g1.crud.dto;

public class CrudDto {

    private Integer id;

    private Integer crudId;
    private String userName;
    private Integer age;
    private Integer phoneNumber;
    private String address;

    public CrudDto(){}

    public CrudDto(Integer crudId, String userName, Integer age, Integer phoneNumber, String address) {
        this.crudId = crudId;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getCrudId() {
        return crudId;
    }

    public void setCrudId(Integer crudId) {
        this.crudId = crudId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "CrudDto{" +
                "id=" + id +
                ", crudId=" + crudId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }

    public static interface CrudIdStep {
        UserNameStep withCrudId(Integer crudId);
    }

    public static interface UserNameStep {
        AgeStep withUserName(String userName);
    }

    public static interface AgeStep {
        PhoneNumberStep withAge(Integer age);
    }

    public static interface PhoneNumberStep {
        AddressStep withPhoneNumber(Integer phoneNumber);
    }

    public static interface AddressStep {
        BuildStep withAddress(String address);
    }

    public static interface BuildStep {
        CrudDto build();
    }

    public static class Builder implements CrudIdStep, UserNameStep, AgeStep, PhoneNumberStep, AddressStep, BuildStep {
        private Integer crudId;
        private String userName;
        private Integer age;
        private Integer phoneNumber;
        private String address;

        private Builder() {
        }

        public static CrudIdStep crudDto() {
            return new Builder();
        }

        @Override
        public UserNameStep withCrudId(Integer crudId) {
            this.crudId = crudId;
            return this;
        }

        @Override
        public AgeStep withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        @Override
        public PhoneNumberStep withAge(Integer age) {
            this.age = age;
            return this;
        }

        @Override
        public AddressStep withPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public BuildStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public CrudDto build() {
            return new CrudDto(
                    this.crudId,
                    this.userName,
                    this.age,
                    this.phoneNumber,
                    this.address
            );
        }
    }
}
