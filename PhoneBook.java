import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        book.putIfAbsent(name, new HashSet<>());
        book.get(name).add(phone);
    }

    public List<Map.Entry<String, Set<String>>> getContactsSortedByPhoneCount() {
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(book.entrySet());
        sortedContacts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        return sortedContacts;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Map.Entry<String, Set<String>>> sortedContacts = getContactsSortedByPhoneCount();
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            result.append(entry.getKey()).append(": ").append(String.join(", ", entry.getValue())).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Alice", "1234");
        phoneBook.addContact("Alice", "5678");
        phoneBook.addContact("Bob", "4321");
        phoneBook.addContact("Alice", "1234");  // Дублирующийся телефон не будет добавлен
        phoneBook.addContact("Charlie", "8765");
        phoneBook.addContact("Charlie", "5678");
        phoneBook.addContact("Charlie", "1234");

        System.out.println(phoneBook);
    }
}