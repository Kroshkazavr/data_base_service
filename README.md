# test_for_junior
Java 1.8 + JDBC + PostgreSQL

Приложение на Java 1.8, содержащее в себе метод Result findNumber(Integer number), ищущий в 20 разных по составу больших текстовых файлах
(каждый порядка 1 гб) полученное на вход число n. Файлы состоят только из чисел, которые разделены между собой запятой. 
Результат записывается в БД, метод возвращает объект Result.

Скрипт для создания БД:
create table dbwithsearchresult (
id serial,
    code varchar(50),
    number int,
    filenames varchar(100),
    error varchar(100),
    primary key (id));

В приложение добавлено логгирование, оформлены Javadoc, реализован метод генерации текстовых файлов для поиска n.
