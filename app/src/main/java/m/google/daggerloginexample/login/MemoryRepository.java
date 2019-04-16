package m.google.daggerloginexample.login;

import m.google.daggerloginexample.model.User;

public class MemoryRepository implements LoginActivityRepository {

  private  User user;
    @Override
    public void saveUser(User user) {
         if (user==null){
             user= getUser();
         }
         this.user= user;
    }

    @Override
    public User getUser() {
       if (user==null)
       {
           user= new User("Antonio", "Banderas");
           user.setId(0);
           return user;
       }else return user;
    }
}
