
import java.util.List;
import java.io.*;
import java.util.*;

public class Bank {
    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void readCustomerList(InputStream inputStream) {
        try (Scanner sc = new Scanner(inputStream)) {
            Customer currentCustomer = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue; // bỏ qua dòng rỗng

                String[] parts = line.split("\\s+");

                // Trường hợp: dòng chứa tên + CMND
                if (parts.length >= 2 && parts[parts.length - 1].matches("\\d{9}")) {
                    String fullName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
                    long idNumber = Long.parseLong(parts[parts.length - 1]);
                    currentCustomer = new Customer(fullName, idNumber);
                    customerList.add(currentCustomer);
                }
                // Trường hợp: dòng chứa thông tin tài khoản
                else if (parts.length == 3 && parts[0].matches("\\d{10}")) {
                    long accNum = Long.parseLong(parts[0]);
                    String type = parts[1];
                    double balance = Double.parseDouble(parts[2]);

                    Account acc = null;
                    if (Account.CHECKING.equalsIgnoreCase(type)) {
                        acc = new CheckingAccount(accNum, balance);
                    } else if (Account.SAVINGS.equalsIgnoreCase(type)) {
                        acc = new SavingsAccount(accNum, balance);
                    }

                    if (currentCustomer != null && acc != null) {
                        currentCustomer.addAccount(acc);
                    }
                }
            }
        }
    }

    public String getCustomersInfoByNameOrder() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(customerList, Comparator.comparing(Customer::getFullName));
        for (Customer customer : customerList) {
            sb.append(customer.getCustomerInfo()).append("\n");
        }
        return sb.toString();
    }

    public String getCustomersInfoByIdOrder() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(customerList, Comparator.comparing(Customer::getIdNumber));
        for (Customer customer : customerList) {
            sb.append(customer.getCustomerInfo()).append("\n");
        }
        return sb.toString();
    }
}
