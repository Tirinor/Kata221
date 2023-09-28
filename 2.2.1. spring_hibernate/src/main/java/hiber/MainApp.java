package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Harry", "Potter", "hp@mail.ru");
      User user2 = new User("Arthas", "Menethil", "am@mail.ru");
      User user3 = new User("Han", "Solo", "hs@mail.ru");

      Car car1 = new Car("Nimbus", 2000);
      Car car2 = new Car("Invincible", 10000);
      Car car3 = new Car("Falcon", 1000);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      User selectedUser = userService.getUserByModelAndSeries("Nimbus", 2000);
      System.out.println("Result:");
      System.out.println("Id = "+selectedUser.getId());
      System.out.println("First Name = "+selectedUser.getFirstName());
      System.out.println("Last Name = "+selectedUser.getLastName());
      System.out.println("Email = "+selectedUser.getEmail());

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }



      context.close();
   }
}
