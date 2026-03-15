public class Address {
    private String Country;
    private String State;
    private String City;
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private int floor_ifExist;
    private int room_ifExist;
    //constructors
    Address(){

    }
    Address(String country,String state,String city,int streetNumber,String streetName){
        this.Country=country;
        this.State=state;
        this.City=city;
        this.streetNumber=streetNumber;
        this.streetName=streetName;
    }
    Address(String country,String state,String city,int streetNumber,String streetName,String postalCode,int floor_ifExist,int room_ifExist){
        this.Country=country;
        this.State=state;
        this.City=city;
        this.streetNumber=streetNumber;
        this.streetName=streetName;
        this.postalCode=postalCode;
        this.floor_ifExist=floor_ifExist;
        this.room_ifExist=room_ifExist;
    }
    //setters
    void setCountry(String country){
        this.Country=country;
    }
    void setState(String state){
        this.State=state;
    }
    void setCity(String city){
        this.City=city;
    }
    void setStreetNumber(int streetNumber){
        this.streetNumber=streetNumber;
    }
    void setStreetName(String streetName){
        this.streetName=streetName;
    }
    void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }
    void setFloor_ifExist(int floor_ifExist){
        this.floor_ifExist=floor_ifExist;
    }
    void setRoom_ifExist(int room_ifExist){
        this.room_ifExist=room_ifExist;
    }
    //getters
    String getCountry(){
        return this.Country;
    }
    String getState(){
        return this.State;
    }
    String getCity(){
        return this.City;
    }
    int getStreetNumber(){
        return this.streetNumber;
    }
    String getStreetName(){
        return this.streetName;
    }
    String getPostalCode(){
        return this.postalCode;
    }
    int getFloor_ifExist(){
        return this.floor_ifExist;
    }
    int getRoom_ifExist(){
        return this.room_ifExist;
    }

}
