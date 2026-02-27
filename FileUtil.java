import java.io.*;
public class FileUtil {
    public static void saveAccount(BankAccount account) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(account.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving account data.");
        }
    }
}