## Отчет о тестировании приложения для покупки тура

### Краткое описание
> * Отчет о тестировании приложения для покупки тура используя БД и 2 доступные карты.

### Общее количество тест кейсов: 
> * Количество тестов - 24 шт

### Статистика passed/failed

### MYSQL
> * Passed: 41.66% (10 шт.)
> * Failed: 58.34% (14 шт.)
<details>
   <summary>Report</summary>

![report 1](https://user-images.githubusercontent.com/81297207/132939326-80020627-114f-4eeb-8399-18050471712b.png)
  
![report 2](https://user-images.githubusercontent.com/81297207/132939334-db559af5-9218-4cf6-8a6f-fe8c12b80ee0.png)
  
![report 3](https://user-images.githubusercontent.com/81297207/132939344-e5400b97-b1fe-4bc5-987e-9eaf7db6c7b1.png)
  
</details>

### PostgreSQL
> * Passed: 41.66% (10 шт.)
> * Failed: 58.34% (14 шт.)
<details>
   <summary>Report</summary>

</details>

### Общие рекомендации
1. Исправить ошибку на главной странице и название вкладки (https://github.com/AlexandraOwl/netologyDiplomaProject/issues/4, https://github.com/AlexandraOwl/netologyDiplomaProject/issues/3);
2. Исправить баги, связанные с неверными сообщениями об ошибках (https://github.com/AlexandraOwl/netologyDiplomaProject/issues/7);
3. Для поля "Владелец" ввести ограничение на вводимые символы - только латинские буквы (желательно добавить ввод сразу верхним регистром независимо от нажатой клавиши Shift/Caps Lock) (https://github.com/AlexandraOwl/netologyDiplomaProject/issues/1);
4. Сделать кнопку "Продолжить" неактивной, если есть пустые и/или неправильно заполненные поля.

**Полный список багов: https://github.com/AlexandraOwl/netologyDiplomaProject/issues**
