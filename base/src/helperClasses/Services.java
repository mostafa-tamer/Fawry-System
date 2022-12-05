package helperClasses;

import helperClasses.formAndHandler.*;
import models.Service;
import models.ServicesData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Services {

    private final ServicesData servicesData;
    private List<Service> allServices;

    public Services() {
        try {
            servicesData = new ServicesData();
            allServices = servicesData.index();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Service> getAllServices() {
        updateServices();
        return allServices;
    }

    public void updateServices() {
        try {
            allServices = servicesData.index();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Service> searchServices(String word) {
        var result = new ArrayList<Service>();
        var caseLess = word.toLowerCase();
        for (var s : getAllServices()) {
            if (s.getServiceType().getDatabaseAcronym().toLowerCase().contains(caseLess) || s.getProvider().toLowerCase().contains(caseLess))
                result.add(s);
        }
        return result;
    }

    public Form createForm(Service service) {
        Handler handler;
        handler = switch (service.getServiceType()) {
            case MOBILE_RECHARGE -> new MobileRecharge(service.getPrice());
            case INTERNET_PAYMENT -> new InternetPayment(service.getPrice());
            case LANDLINE -> new Landline(service.getPrice());
            case DONATIONS -> new Donations();
        };
        return new Form(service, handler);
    }
}
