package lv.dev.hello_vaadin.service;

import lv.dev.hello_vaadin.model.Company;
import lv.dev.hello_vaadin.model.Contact;
import lv.dev.hello_vaadin.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrmService {

    private final Company smart = new Company("Smart");
    private final Company abc = new Company("ABC");
    private final List<Company> companies = List.of(smart, abc);

    private final List<Contact> smartContacts = new ArrayList<>();
    private final List<Contact> abcContacts = new ArrayList<>();
    private final List<Status> statuses = new ArrayList<>();

    public CrmService() {
        Status junior = new Status("Junior");
        Status senior = new Status("Senior");
        Status expert = new Status("Expert");
        statuses.add(junior);
        statuses.add(senior);
        statuses.add(expert);

        smartContacts.add(new Contact("John", "Blake", "JohnBlake@company.com", junior, smart));
        smartContacts.add(new Contact("Peter", "Jacob", "PeterJacob@company.com", senior, smart));
        smartContacts.add(new Contact("Anna", "Miller", "AnnaMller@company.com", junior, smart));
        smartContacts.add(new Contact("Eliza", "Miles", "ElizeMiles@company.com", senior, smart));
        smartContacts.add(new Contact("Mary", "Miller", "MaryMiller@company.com", junior, smart));
        smartContacts.add(new Contact("Patricia", "Brown", "PatriciaBrown@company.com", junior, smart));
        smartContacts.add(new Contact("David", "Davis", "DavidDavis@company.com", junior, smart));
        smartContacts.add(new Contact("Thomas", "Miles", "ThomasMiles@company.com", junior, smart));
        smartContacts.add(new Contact("Karen", "Lopez", "KarenLopez@company.com", expert, smart));
        smart.addAll(smartContacts);

        abcContacts.add(new Contact("Sarah", "Anderson", "SarahAnderson@company.com", junior, abc));
        abcContacts.add(new Contact("Mark", "Allen", "MarkAllen@company.com", junior, abc));
        abcContacts.add(new Contact("Emily", "Scott", "EmilyScott@company.com", expert, abc));
        abcContacts.add(new Contact("Donna", "Walker", "DonaWallker@company.com", senior, abc));
        abcContacts.add(new Contact("William", "Walker", "WilliamWallker@company.com", senior, abc));
        abc.addAll(abcContacts);
    }

    public List<Contact> findAllContacts(String strFilter) {
        if (strFilter == null || strFilter.isEmpty()) {
            return smartContacts;
        }
        return smartContacts.stream()
                .filter(contact -> contact.getFirstName().startsWith(strFilter))
                .collect(Collectors.toList());
    }

    public void saveContact(Contact contact) {
        smartContacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        smartContacts.remove(contact);
    }

    public List<Company> findAllCompanies() {
        return companies;
    }

    public List<Status> finAllStatuses() {
        return statuses;
    }

    public Integer countContacts() {
        return smartContacts.size();
    }
}
