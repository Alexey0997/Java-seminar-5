import java.util.*;

/*
Задача № 1.
Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Sem_5_Hmw_Task1 {
    public static void main(String[] args) {
        Map<String, List<String>> dictionary = new HashMap<>();
        originContacts(dictionary);

        System.out.print("""
                Добро пожаловать в телефонный справочник!
                посмотреть данные абонента    - нажмите 1
                посмотреть данные справочника - нажмите 2
                добавить новый котнаткт       - нажмите 3
                изменить данные абонента      - нажмите 4
                Ваше решение:\s""");

        Scanner aScanner = new Scanner(System.in);
        int decisionNumber = aScanner.nextInt();
         if (decisionNumber == 1) {
            showContact(dictionary);
        }
        if (decisionNumber == 2) {
            showDictionary(dictionary);
        }
        if (decisionNumber == 3) {
            newContact(dictionary);
        }
        if (decisionNumber == 4) {
            changeContact(dictionary);
        }
    }

    // ИСХОДНЫЕ ДАННЫЕ ТЕЛЕФОННОЙ КНИГИ
    private static void originContacts(Map<String, List<String>> contacts) {
        List<String> myValues = new ArrayList<>();
        myValues.add("+79998887766");
        myValues.add("+7499001100");
        contacts.put("Иванов", myValues);
        contacts.put("Петров", Collections.singletonList("+79997776655"));
        contacts.put("Сидоров", Collections.singletonList("+79996665544"));
    }

    // МЕТОД ВЫВОДА СВЕДЕНИЙ ОБ АБОНЕНТЕ, ИМЕЮЩИХСЯ В СПРАВОЧНИКЕ
    private static void showContact(Map<String, List<String>> contacts) {
        Scanner bScanner = new Scanner(System.in);
        System.out.print("Введите Фамилию абонента: ");
        String surname = bScanner.next();
        bScanner.close();
        if (contacts.containsKey(surname)) {
            System.out.printf("Данные абонента: %s %s", surname, contacts.get(surname));
        } else {
            System.out.printf("Данными по абоненту %s", surname + " не располагаем.");
        }
    }

    // МЕТОД ПРОСМОТРА ДАННЫХ СПРАВОЧНИКА
    private static void showDictionary(Map<String, List<String>> contacts) {
        System.out.println("Данные справочника: ");
        for (String names : contacts.keySet()) {
            System.out.printf(names + ": тел. " + contacts.get(names) + "\n");
        }
    }

    // МЕТОД ДОБАВЛЕНИЯ НОВОГО КОНТАКТА В СПРАВОЧНИК
    private static Map<String, List<String>> newContact(Map<String, List<String>> contacts) {
        List<String> myValues = new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите Фамилию абонента: ");
        String myKey = iScanner.next();
        if (contacts.containsKey(myKey)) {
            System.out.printf("Абонент %s %s", myKey + " имеется в справчнике, его тел.: ", contacts.get(myKey));
        } else {
            System.out.print("Введите мобильный телефон абонента: ");
            myValues.add(iScanner.next());
            System.out.print("Введите рабочий телефон абонента: ");
            myValues.add(iScanner.next());
            iScanner.close();
            System.out.printf("В справочник добавлены данные абонента %s %s", myKey + ": ", myValues);
            contacts.put(myKey, myValues);
        }
        return contacts;
    }

    // МЕТОД ДОБАВЛЕНИЯ НОВОГО КОНТАКТА В СПРАВОЧНИК
    private static Map<String, List<String>> changeContact(Map<String, List<String>> contacts) {
        List<String> myValues = new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите Фамилию абонента, чьи данные хотите изменить: ");
        String myKey = iScanner.next();
        if (!contacts.containsKey(myKey)) {
            System.out.printf("Данных на абонента %s", myKey + " нет в справчнике.");
        } else {
            System.out.printf("Абонент %s %s", myKey + " имеется в справчнике, его тел.: ", contacts.get(myKey));
            System.out.print("\nВведите новый мобильный телефон абонента: ");
            myValues.add(iScanner.next());
            System.out.print("Введите новый рабочий телефон абонента: ");
            myValues.add(iScanner.next());
            iScanner.close();
            System.out.printf("Новые данные абонента %s %s", myKey + ": ", myValues);
            contacts.put(myKey, myValues);
        }
        return contacts;
    }
}







