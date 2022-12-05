package helperClasses.payment;

import models.User;
import models.UsersData;

import java.sql.SQLException;

public class Wallet implements Payment {
    User user;

    public void initialize(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean pay(double amount) throws Exception {
        if (user.getBalance() >= amount) {
            try {
                var userData = new UsersData();
                userData.updateBalance(user.getEmail(), user.getBalance() - amount);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else
            throw new Exception("Wallet balance is not enough");
        return false;
    }
}
