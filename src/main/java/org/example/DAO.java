package org.example;

import org.hibernate.Session;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DAO {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("rt");


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void insertUser() throws IOException {
        EntityManager manager = factory.createEntityManager();

        System.out.print("Enter user name: ");
        String name = reader.readLine();

        System.out.print("Enter user address: ");
        String address = reader.readLine();

        System.out.print("Enter user phone: ");
        int phone = Integer.parseInt(reader.readLine());

        User user = new User();
        user.setU_name(name);
        user.setU_address(address);
        user.setU_phone(phone);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(user);
        transaction.commit();
    }

    public static void showUsers() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();

        System.out.println("+------+-----------------+------------------+---------------+");
        System.out.println("|  ID  |      Name       |      Address     |     Phone     |");
        System.out.println("+------+-----------------+------------------+---------------+");

        for (User user : users) {
            System.out.printf("| %4d | %15s | %16s | %13s |\n", user.getU_id(), user.getU_name(), user.getU_address(), user.getU_phone());
        }

        System.out.println("+------+-----------------+------------------+---------------+");
    }

    public static void insertBank() throws IOException {
        EntityManager manager = factory.createEntityManager();

        System.out.print("Enter bank name: ");
        String name = reader.readLine();

        System.out.print("Enter bank address: ");
        String address = reader.readLine();

        Bank bank = new Bank();
        bank.setB_name(name);
        bank.setB_address(address);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(bank);
        transaction.commit();
    }

    public static void showBank() {
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Bank> query = manager.createQuery("SELECT b FROM Bank b", Bank.class);
        List<Bank> banks = query.getResultList();

        System.out.println("+------+-----------------+------------------+");
        System.out.println("|  ID  |      Name       |      Address     |");
        System.out.println("+------+-----------------+------------------+");

        for (Bank bank : banks) {
            System.out.printf("| %4d | %15s | %16s |\n", bank.getB_id(), bank.getB_name(), bank.getB_address());
        }

        System.out.println("+------+-----------------+------------------+");
    }

    public static void EnrollBank() throws IOException {
        EntityManager manager = factory.createEntityManager();
        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(reader.readLine());

        System.out.println("Enter bank IDs to add for user with ID " + userId + " (enter 'done' when finished):");
        while (true) {
            System.out.print("Bank ID: ");
            String input = reader.readLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                EntityTransaction transaction = manager.getTransaction();
                transaction.begin();
                int bankId = Integer.parseInt(input);
                Bank bank = manager.find(Bank.class, bankId);
                if (bank != null) {
                    User user = manager.find(User.class, userId);
                    if (user != null) {
                        user.getBanks().add(bank);
                        manager.persist(user);
                        transaction.commit();
                        System.out.println("Bank with ID " + bankId + " added successfully");
                    } else {
                        System.out.println("User with ID " + userId + " not found");
                    }
                } else {
                    System.out.println("Bank with ID " + bankId + " not found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid bank ID format, please enter a valid integer");
            }
        }
    }

    public static void userBank() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Bank> query = manager.createQuery("SELECT b FROM Bank b", Bank.class);
        List<Bank> banks = query.getResultList();
        List<Object[]> results = manager.createQuery(
                "SELECT u.u_id, u.u_name, b.b_name FROM User u JOIN u.banks b"
        ).getResultList();

        System.out.println("User ID\tUser Name\tBank Name");
        for (Object[] result : results) {
            int userId = (int) result[0];
            String userName = (String) result[1];
            String bankName = (String) result[2];
            System.out.println(userId + "\t\t" + userName + "\t\t" + bankName);
        }
    }

    public static void addAccount() throws IOException {
        EntityManager manager = factory.createEntityManager();

        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(reader.readLine());

        System.out.print("Enter bank ID in which you want to open : ");
        int bankId = Integer.parseInt(reader.readLine());

        System.out.print("Enter account type: ");
        String type = reader.readLine();

        System.out.print("Enter GST number: ");
        int gstNo = Integer.parseInt(reader.readLine());

        System.out.print("Enter firm name: ");
        String firmName = reader.readLine();

        System.out.print("Enter opening date (YYYY-MM-DD): ");
        LocalDate openingDate = LocalDate.parse(reader.readLine());

        System.out.print("Enter balance: ");
        long balance = Long.parseLong(reader.readLine());

        System.out.print("Enter status: ");
        String status = reader.readLine();

        User user = manager.find(User.class, userId);
        Bank bank = manager.find(Bank.class, bankId);

        if (user == null) {
            System.out.println("User with ID " + userId + " not found");
        } else if (bank == null) {
            System.out.println("Bank with ID " + bankId + " not found");
        } else {
            // Create a new account instance and set its properties
            Accounts account = new Accounts();
            account.setType(type);
            account.setGst_no(gstNo);
            account.setFirm_name(firmName);
            account.setOpening_date(openingDate);
            account.setBalance(balance);
            account.setStatus(status);
            account.setUser(user);
            account.setBank(bank);


            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(account);
            transaction.commit();


        }
    }

//    public static void allUsersData(){
//        EntityManager manager = factory.createEntityManager();
//        TypedQuery<User> query = manager.createQuery(
//                "SELECT u FROM User u " +
//                        "JOIN FETCH u.banks b " +
//                        "JOIN FETCH b.accounts a", User.class);
//
//        List<User> users = query.getResultList();
//
//        for (User user : users) {
//            System.out.println("User ID: " + user.getU_id() + ", Name: " + user.getU_name());
//
//            for (Bank bank : user.getBanks()) {
//                System.out.println("Bank ID: " + bank.getB_id() + ", Name: " + bank.getB_name());
//
//                for (Accounts account : bank.getAccounts()) {
//                    System.out.println("Account Number: " + account.getA_no() + ", Type: " + account.getType());
//                }
//            }
//        }
//    }
    public static void q1(){
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Join<User, Accounts> accountJoin = root.join("accounts");

        query.select(root).where(builder.lessThan(accountJoin.get("opening_date"),
                LocalDate.of(2023, 1, 1)));

        List<User> users = manager.createQuery(query).getResultList();

        for (User u: users
             ) {
            System.out.println("----------------------");
            System.out.println("id ::" + u.getU_id());
            System.out.println("name ::"+ u.getU_name());
            System.out.println("----------------------");
        }
    }

    public static void q2(){
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaUpdate<Accounts> update = builder.createCriteriaUpdate(Accounts.class);
        Root<Accounts> root = update.from(Accounts.class);

        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
        transaction.begin();

        update.set(root.get("status"), "prime")
                .where(builder.greaterThan(root.get("balance"), 100000L),
                        builder.lessThan((root.get("opening_date")), threeMonthsAgo));

        manager.createQuery(update).executeUpdate();
        transaction.commit();
    }

    public static void q3(){
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Accounts> query = manager.createQuery("SELECT a FROM Accounts a", Accounts.class);
        List<Accounts> accounts = query.getResultList();

        for (Accounts a : accounts) {
            EntityTransaction transaction = manager.getTransaction();
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaUpdate<Accounts> update = cb.createCriteriaUpdate(Accounts.class);
            Root<Accounts> root = update.from(Accounts.class);
            Date today = new Date();
            Expression<Long> monthsBetween = cb.function("months_between", Long.class,
                    cb.literal(root.get("opening_date")),
                    cb.literal(today));

            if (a.getBalance() < 1000 && a.getType().equals("saving")) {
                System.out.println("Save more, 150 deducted from account");

                update.set("balance", cb.diff(root.get("balance"), cb.prod(150L, monthsBetween)))
                        .where(cb.and(
                                cb.equal(root.get("type"), "saving"),
                                cb.lessThan(root.get("balance"), 1000L),
                                cb.equal(root.get("a.user.u_id"), a.getUser().getU_id())
                        ));

                manager.createQuery(update).executeUpdate();
                transaction.commit();
            }

            if (a.getBalance() < 10000 && a.getType().equals("current")) {
                System.out.println("Save more, 250 deducted from account");

                update.set("balance", cb.diff(root.get("balance"), cb.prod(250L, monthsBetween)))
                        .where(cb.and(
                                cb.equal(root.get("type"), "current"),
                                cb.lessThan(root.get("balance"), 10000L),
                                cb.equal(root.get("a.user.u_id"), a.getUser().getU_id())
                        ));

                manager.createQuery(update).executeUpdate();
                transaction.commit();
            }
        }








    }
}
