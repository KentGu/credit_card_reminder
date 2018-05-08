import com.kent.pojo.CreditCard;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:ucanaccess://d:/Eclipse Workspace/credit_card_reminder/src/main/resources/credit.accdb";
        Connection connection;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(url);
            ResultSet resultSet = ((PreparedStatement) connection.prepareStatement("SELECT * FROM credit")).executeQuery();
            while (resultSet.next()) {
                CreditCard creditCard = new CreditCard(resultSet.getInt("ID"),
                        resultSet.getString("CARD_NAME"),
                        resultSet.getInt("BILL_DATE"),
                        resultSet.getBoolean("FIX_DATE"),
                        resultSet.getInt("DUE_DATE"));
                System.out.println("=======================");
                System.out.println("Credit Card:\t" + creditCard.getCard_name());
                System.out.println("Bill Date:\t" + creditCard.getActBillDate().toString());
                System.out.println("Due Date:\t" + creditCard.getActDueDate().toString());
            }
            System.out.println("=======================");
        }catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
