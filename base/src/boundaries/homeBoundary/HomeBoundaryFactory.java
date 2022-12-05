package boundaries.homeBoundary;

import models.User;

public class HomeBoundaryFactory {

    public HomeBoundary getHomeBoundary(User user) throws Exception {

        if (user.isAdmin()) {
            return new AdminHomeBoundary(user);
        }
        return new NormalUserHomeBoundary(user);
    }
}
