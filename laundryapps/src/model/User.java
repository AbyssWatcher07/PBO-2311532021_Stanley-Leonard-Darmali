package model;
public class User {
String id, name, username, password;
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName (String nama) {
this.name = nama;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public static boolean login(String username, String password) {
boolean isLoggin = false;
User user = new User();
user.setId("1");
user.setName("stanley");
user.setUsername("stanley");
user.setPassword("12345");
if(user.getUsername().equalsIgnoreCase(username)
&& user.getPassword().equalsIgnoreCase(password)) {
isLoggin = true;
}else {
isLoggin = false;
}
return isLoggin;
}
}