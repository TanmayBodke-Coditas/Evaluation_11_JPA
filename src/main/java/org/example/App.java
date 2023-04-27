package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("rt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;

        do {
            System.out.println("1. Insert User");
            System.out.println("2. Show User");
            System.out.println("3. Inset Bank");
            System.out.println("4. Show Bank");
            System.out.println("5. Enroll into Bank");
            System.out.println("6. User Bank Data");
            System.out.println("7. Open Account");
            System.out.println("8. query1");
            System.out.println("9. query2");
            System.out.println("10. query3");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    DAO.insertUser();
                    break;
                case 2:
                    DAO.showUsers();
                    break;
                case 3:
                    DAO.insertBank();
                    break;
                case 4:
                    DAO.showBank();
                    break;
                case 5:
                    DAO.EnrollBank();
                    break;
                case 6:
                    DAO.userBank();
                    break;
                case 7:
                    DAO.addAccount();
                    break;
                case 8:
                    DAO.q1();
                    break;
                case 9:
                    DAO.q2();
                    break;
                case 10:
                    DAO.q3();
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 0);





    }
}
/*
OUTPUT
 */

/*
"C:\Program Files\Java\jdk1.8.0_131\bin\java.exe" "-javaagent:C:\IntelliJ\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=62654:C:\IntelliJ\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_131\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\rt.jar;C:\Users\Coditas\Desktop\Hibernate Assignments\Evaluation_11\target\classes;C:\Users\Coditas\.m2\repository\mysql\mysql-connector-java\8.0.28\mysql-connector-java-8.0.28.jar;C:\Users\Coditas\.m2\repository\com\google\protobuf\protobuf-java\3.11.4\protobuf-java-3.11.4.jar;C:\Users\Coditas\.m2\repository\org\hibernate\hibernate-core\5.6.5.Final\hibernate-core-5.6.5.Final.jar;C:\Users\Coditas\.m2\repository\org\jboss\logging\jboss-logging\3.4.3.Final\jboss-logging-3.4.3.Final.jar;C:\Users\Coditas\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\Coditas\.m2\repository\net\bytebuddy\byte-buddy\1.12.7\byte-buddy-1.12.7.jar;C:\Users\Coditas\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\Coditas\.m2\repository\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.1.1.Final\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;C:\Users\Coditas\.m2\repository\org\jboss\jandex\2.4.2.Final\jandex-2.4.2.Final.jar;C:\Users\Coditas\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\Coditas\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\Coditas\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.1.2.Final\hibernate-commons-annotations-5.1.2.Final.jar;C:\Users\Coditas\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\Coditas\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.1\jaxb-runtime-2.3.1.jar;C:\Users\Coditas\.m2\repository\org\glassfish\jaxb\txw2\2.3.1\txw2-2.3.1.jar;C:\Users\Coditas\.m2\repository\com\sun\istack\istack-commons-runtime\3.0.7\istack-commons-runtime-3.0.7.jar;C:\Users\Coditas\.m2\repository\org\jvnet\staxex\stax-ex\1.8\stax-ex-1.8.jar;C:\Users\Coditas\.m2\repository\com\sun\xml\fastinfoset\FastInfoset\1.2.15\FastInfoset-1.2.15.jar;C:\Users\Coditas\.m2\repository\org\hibernate\hibernate-annotations\3.5.6-Final\hibernate-annotations-3.5.6-Final.jar;C:\Users\Coditas\.m2\repository\org\hibernate\hibernate-commons-annotations\3.2.0.Final\hibernate-commons-annotations-3.2.0.Final.jar;C:\Users\Coditas\.m2\repository\org\hibernate\javax\persistence\hibernate-jpa-2.0-api\1.0.0.Final\hibernate-jpa-2.0-api-1.0.0.Final.jar;C:\Users\Coditas\.m2\repository\org\slf4j\slf4j-api\1.5.8\slf4j-api-1.5.8.jar" org.example.App
Apr 27, 2023 3:22:11 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
Apr 27, 2023 3:22:11 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
Apr 27, 2023 3:22:12 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Apr 27, 2023 3:22:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
Apr 27, 2023 3:22:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/eval11?createDatabaseIfNotExist=true]
Apr 27, 2023 3:22:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 27, 2023 3:22:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:22:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:22:14 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
Apr 27, 2023 3:22:15 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@2fc07784] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Apr 27, 2023 3:22:15 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 1
Apr 27, 2023 3:22:17 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
Apr 27, 2023 3:22:17 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Apr 27, 2023 3:22:17 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/eval11?createDatabaseIfNotExist=true]
Apr 27, 2023 3:22:17 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
Apr 27, 2023 3:22:17 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:22:17 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:22:17 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
Apr 27, 2023 3:22:17 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@5411dd90] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Apr 27, 2023 3:22:17 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Enter user name: Yash
Enter user address: Agra
Enter user phone: 399
Hibernate:
    insert
    into
        User
        (u_address, u_name, u_phone)
    values
        (?, ?, ?)

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 2
Hibernate:
    select
        user0_.u_id as u_id1_2_,
        user0_.u_address as u_addres2_2_,
        user0_.u_name as u_name3_2_,
        user0_.u_phone as u_phone4_2_
    from
        User user0_
+------+-----------------+------------------+---------------+
|  ID  |      Name       |      Address     |     Phone     |
+------+-----------------+------------------+---------------+
|    1 |          Tanmay |             pune |          3993 |
|    2 |          Aniket |          Wagholi |          3893 |
|    3 |           Aarti |      viman nagar |         34989 |
|    4 |            Yash |             Agra |           399 |
+------+-----------------+------------------+---------------+

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 3
Enter bank name: ICICI
Enter bank address: Band Garden
Hibernate:
    insert
    into
        Bank
        (b_address, b_name)
    values
        (?, ?)

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 4
Hibernate:
    select
        bank0_.b_id as b_id1_1_,
        bank0_.b_address as b_addres2_1_,
        bank0_.b_name as b_name3_1_
    from
        Bank bank0_
+------+-----------------+------------------+
|  ID  |      Name       |      Address     |
+------+-----------------+------------------+
|    1 |             SBI |        navi peth |
|    2 |            HDFC |      Viman nagar |
|    3 |           ICICI |      Band Garden |
+------+-----------------+------------------+

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 5
Enter user ID: 5
Enter bank IDs to add for user with ID 5 (enter 'done' when finished):
Bank ID: 3
Hibernate:
    select
        bank0_.b_id as b_id1_1_0_,
        bank0_.b_address as b_addres2_1_0_,
        bank0_.b_name as b_name3_1_0_
    from
        Bank bank0_
    where
        bank0_.b_id=?
Hibernate:
    select
        user0_.u_id as u_id1_2_0_,
        user0_.u_address as u_addres2_2_0_,
        user0_.u_name as u_name3_2_0_,
        user0_.u_phone as u_phone4_2_0_
    from
        User user0_
    where
        user0_.u_id=?
User with ID 5 not found
Bank ID: done

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 6
Hibernate:
    select
        bank0_.b_id as b_id1_1_,
        bank0_.b_address as b_addres2_1_,
        bank0_.b_name as b_name3_1_
    from
        Bank bank0_
Hibernate:
    select
        user0_.u_id as col_0_0_,
        user0_.u_name as col_1_0_,
        bank2_.b_name as col_2_0_
    from
        User user0_
    inner join
        user_bank banks1_
            on user0_.u_id=banks1_.user_id
    inner join
        Bank bank2_
            on banks1_.bank_id=bank2_.b_id
User ID	User Name	Bank Name
1		Tanmay		SBI
2		Aniket		SBI
3		Aarti		HDFC

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 6
Hibernate:
    select
        bank0_.b_id as b_id1_1_,
        bank0_.b_address as b_addres2_1_,
        bank0_.b_name as b_name3_1_
    from
        Bank bank0_
Hibernate:
    select
        user0_.u_id as col_0_0_,
        user0_.u_name as col_1_0_,
        bank2_.b_name as col_2_0_
    from
        User user0_
    inner join
        user_bank banks1_
            on user0_.u_id=banks1_.user_id
    inner join
        Bank bank2_
            on banks1_.bank_id=bank2_.b_id
User ID	User Name	Bank Name
1		Tanmay		SBI
2		Aniket		SBI
3		Aarti		HDFC

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 5
Enter user ID: 4
Enter bank IDs to add for user with ID 4 (enter 'done' when finished):
Bank ID: 3
Hibernate:
    select
        bank0_.b_id as b_id1_1_0_,
        bank0_.b_address as b_addres2_1_0_,
        bank0_.b_name as b_name3_1_0_
    from
        Bank bank0_
    where
        bank0_.b_id=?
Hibernate:
    select
        user0_.u_id as u_id1_2_0_,
        user0_.u_address as u_addres2_2_0_,
        user0_.u_name as u_name3_2_0_,
        user0_.u_phone as u_phone4_2_0_
    from
        User user0_
    where
        user0_.u_id=?
Hibernate:
    select
        banks0_.user_id as user_id1_3_0_,
        banks0_.bank_id as bank_id2_3_0_,
        bank1_.b_id as b_id1_1_1_,
        bank1_.b_address as b_addres2_1_1_,
        bank1_.b_name as b_name3_1_1_
    from
        user_bank banks0_
    inner join
        Bank bank1_
            on banks0_.bank_id=bank1_.b_id
    where
        banks0_.user_id=?
Hibernate:
    insert
    into
        user_bank
        (user_id, bank_id)
    values
        (?, ?)
Bank with ID 3 added successfully
Bank ID: done

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 6
Hibernate:
    select
        bank0_.b_id as b_id1_1_,
        bank0_.b_address as b_addres2_1_,
        bank0_.b_name as b_name3_1_
    from
        Bank bank0_
Hibernate:
    select
        user0_.u_id as col_0_0_,
        user0_.u_name as col_1_0_,
        bank2_.b_name as col_2_0_
    from
        User user0_
    inner join
        user_bank banks1_
            on user0_.u_id=banks1_.user_id
    inner join
        Bank bank2_
            on banks1_.bank_id=bank2_.b_id
User ID	User Name	Bank Name
1		Tanmay		SBI
2		Aniket		SBI
3		Aarti		HDFC
4		Yash		ICICI

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 7
Enter user ID: 4
Enter bank ID in which you want to open : 3
Enter account type: current
Enter GST number: 0
Enter firm name: --
Enter opening date (YYYY-MM-DD): 2023-04-01
Enter balance: 70000
Enter status: non prime
Hibernate:
    select
        user0_.u_id as u_id1_2_0_,
        user0_.u_address as u_addres2_2_0_,
        user0_.u_name as u_name3_2_0_,
        user0_.u_phone as u_phone4_2_0_
    from
        User user0_
    where
        user0_.u_id=?
Hibernate:
    select
        bank0_.b_id as b_id1_1_0_,
        bank0_.b_address as b_addres2_1_0_,
        bank0_.b_name as b_name3_1_0_
    from
        Bank bank0_
    where
        bank0_.b_id=?
Hibernate:
    insert
    into
        Accounts
        (balance, bank_b_id, firm_name, gst_no, opening_date, status, type, user_u_id)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 8
Hibernate:
    select
        user0_.u_id as u_id1_2_,
        user0_.u_address as u_addres2_2_,
        user0_.u_name as u_name3_2_,
        user0_.u_phone as u_phone4_2_
    from
        User user0_
    inner join
        Accounts accounts1_
            on user0_.u_id=accounts1_.user_u_id
    where
        accounts1_.opening_date<?
----------------------
id ::1
name ::Tanmay
----------------------
----------------------
id ::3
name ::Aarti
----------------------

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice: 9
Hibernate:
    update
        Accounts
    set
        status=?
    where
        balance>100000
        and opening_date<?

1. Insert User
2. Show User
3. Inset Bank
4. Show Bank
5. Enroll into Bank
6. User Bank Data
7. Open Account
8. query1
9. query2
10. query3
0. Exit
Enter your choice:
 */