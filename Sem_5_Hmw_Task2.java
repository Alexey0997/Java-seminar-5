import java.util.*;

/*
2.	Пусть дан список сотрудников:
Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,
Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
Для сортировки использовать TreeMap.
 */
public class Sem_5_Hmw_Task2 {
    public static void main(String[] args) {
        String text = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";
        ArrayList<String> names = textSorting(text);                   // Вызов метода выделения имен.
        namesRating(names);                                            // Вызов метода подсчета повторений.
    }

    // МЕТОД ВЫДЕЛЕНИЯ ИМЕН ИЗ СПИСКА
    public static ArrayList<String> textSorting(String text) {         // Аргумент - исходный текст.
        String jsonString = text.replace(",", "");    // Убираем запятые.
        String[] new_string = jsonString.split(" ");             // Создаем массив строк, сплитуя по пробелу.
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < new_string.length; i++) {
            if (i % 2 == 0) {                                          // Четные элементы вносим в новый список.
                names.add(new_string[i]);
            }
        }
        System.out.printf("Все имена: %s", names);
        return names;                                                  // Возвращаем список имен.
    }

    // МЕТОД ПОДСЧЕТА КОЛИЧЕСТВА ПОВТОРЕНИЙ ИМЕН В СПИСКЕ
    public static void namesRating(ArrayList<String> names) {          // Аргумент - список имен.
        TreeMap<String, Integer> rating = new TreeMap<>();             // Используем TreeMap для сортировки.
        for (String name : names) {                                    // Циклом foreach проходим по списку.
            if (rating.containsKey(name)) {                            // Если есть повторение, то добавляем 1.
                int count = rating.get(name) + 1;
                rating.put(name, count);                               // Ключ коллекции - Имя (уникальны),
            } else {                                                   // а количество повторений - значение.
                rating.put(name, 1);                                   // Если у ключа нет повторений, то значение - 1.
            }
        }
        System.out.println("\nРейтинг имен: ");                        // Вывод на печать каждое имя с новой сторки.
        rating.entrySet().stream().sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}



