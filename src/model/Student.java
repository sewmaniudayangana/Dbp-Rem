package model;

public class Student {
     private String id;
     private String name;
     private String email;
     private String contact;
     private String address;
     private String NIC;

     public Student() {
     }

     public Student(String id, String name, String email, String contact, String address, String NIC) {
          this.setId(id);
          this.setName(name);
          this.setEmail(email);
          this.setContact(contact);
          this.setAddress(address);
          this.setNIC(NIC);
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getContact() {
          return contact;
     }

     public void setContact(String contact) {
          this.contact = contact;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public String getNIC() {
          return NIC;
     }

     public void setNIC(String NIC) {
          this.NIC = NIC;
     }
}
