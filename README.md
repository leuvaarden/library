[![Website mephilibrary.herokuapp.com](https://img.shields.io/website-up-down-green-red/http/mephilibrary.herokuapp.com.svg)](https://mephilibrary.herokuapp.com/)

Практическая задача на профессиональной оценке квалификации выпускников. 20.04.2021.

# Содержание
1. [Задание](#Задание)
2. [Приложение](#Приложение)
3. [Заполнение БД](#Заполнение-БД)
4. [CRUD операции](#CRUD-операции)
    1. [Сущность "Книга"](#Сущность-"Книга")
    2. [Сущность "Автор"](#Сущность-"Автор")
    3. [Сущность "Категория"](#Сущность-"Категория")
    4. [Сущность "Отзыв"](#Сущность-"Отзыв")
5. [Бронирование книг](#Бронирование-книг)
6. [Изменение связей](#Изменение-связей)


# Задание

Разработать программу, реализующую картотеку библиотеки: выходные данные книги (автор, название, издательство), раздел библиотеки (спец. литература, беллетристика), наличие книги в данный момент, субъективная оценка. Картотека должна позволять:
1. 	Вывод книг по произвольному запросу (по автору, разделу, наличию)
2. 	Редактирование записи (изменение параметров)
3. 	Добавление/ удаление книги
4. 	Загрузка/сохранение картотеки в файл

# Приложение

Адрес: https://mephilibrary.herokuapp.com/

Приложение развернуто в Heroku Cloud, время ожидания - 30 минут, через которое приложение засыпает до востребования. При запуске приложения заполняется БД. Ключи таблиц в БД могут не соответствовать указанным.

# Заполнение БД

## Авторы

| Id | Name        |
|----|-------------|
| 1  | First A.O.  |
| 2  | Second S.N. |

## Категории

| Id | Name    |
|----|---------|
| 1  | Horror  |
| 2  | Fantasy |

## Отзывы

| Id | Value |
|----|-------|
| 1  | 5/10  |
| 2  | 6/10  |
| 3  | 3/10  |
| 4  | 2/10  |

## Книги

| Id | Name              | Count |
|----|-------------------|-------|
| 1  | Interesting story | 3     |
| 2  | Long novel        | 100   |
| 3  | Love poetry       | 0     |

## Связи

| BookId | AuthorIds | CategoryIds | ReviewIds |
|--------|-----------|-------------|-----------|
| 1      | 1, 2      | 1           | 1         |
| 2      | 1         | 1, 2        | 2         |
| 3      | 2         | 2           | 1, 2      |

# CRUD операции

## Сущность "Книга"

### Create

Создать: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/saveBookUsingPOST

### Read

Найти: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/findAllBookUsingGET

Найти по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/findByIdBookUsingGET

Найти по идентификатору автора: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/findAllByAuthorsIdBookUsingGET

Найти по идентификатору категории: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/findAllByCategoriesIdBookUsingGET

### Update

Обновить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/saveBookUsingPUT

### Delete

Удалить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Book%20Entity/deleteBookUsingDELETE

## Сущность "Автор"

### Create

Создать: https://mephilibrary.herokuapp.com/swagger-ui/#/Author%20Entity/saveAuthorUsingPOST

### Read

Найти: https://mephilibrary.herokuapp.com/swagger-ui/#/Author%20Entity/findAllAuthorUsingGET

Найти по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Author%20Entity/findByIdAuthorUsingGET

### Update

Обновить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Author%20Entity/saveAuthorUsingPUT

### Delete

Удалить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Author%20Entity/deleteAuthorUsingDELETE

## Сущность "Категория"

### Create

Создать: https://mephilibrary.herokuapp.com/swagger-ui/#/Category%20Entity/saveCategoryUsingPOST

### Read

Найти: https://mephilibrary.herokuapp.com/swagger-ui/#/Category%20Entity/findAllCategoryUsingGET

Найти по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Category%20Entity/findByIdCategoryUsingGET

### Update

Обновить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Category%20Entity/saveCategoryUsingPUT

### Delete

Удалить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Category%20Entity/deleteCategoryUsingDELETE

## Сущность "Отзыв"

### Create

Создать: https://mephilibrary.herokuapp.com/swagger-ui/#/Review%20Entity/saveReviewUsingPOST

### Read

Найти: https://mephilibrary.herokuapp.com/swagger-ui/#/Review%20Entity/findAllReviewUsingGET

Найти по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Review%20Entity/findByIdReviewUsingGET

### Update

Обновить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Review%20Entity/saveReviewUsingPUT

### Delete

Удалить по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/Review%20Entity/deleteReviewUsingDELETE

# Бронирование книг

Узнать количество по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/booker/countBookUsingGET

Взять по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/booker/getBookUsingPOST

Вернуть по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/booker/returnBookUsingPOST

# Изменение связей

Добавить автора по идентификатору в книгу по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/addAuthorUsingPOST

Удалить автора по идентификатору из книги по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/removeAuthorUsingPOST

Добавить категорию по идентификатору в книгу по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/addCategoryUsingPOST

Удалить категорию по идентификатору из книги по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/removeCategoryUsingPOST

Добавить отзыв по идентификатору в книгу по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/addReviewUsingPOST

Удалить отзыв по идентификатору из книги по идентификатору: https://mephilibrary.herokuapp.com/swagger-ui/#/book-modifier/removeReviewUsingPOST
