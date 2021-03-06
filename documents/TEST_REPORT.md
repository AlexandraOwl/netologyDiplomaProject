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
   
![report 1](https://user-images.githubusercontent.com/81297207/132939676-12a2339d-c4a4-4580-907f-0230b547311e.png)
   
![report 2](https://user-images.githubusercontent.com/81297207/132939680-d800dfb5-4e38-4997-b629-5b9a374d0043.png)
   
![report 3](https://user-images.githubusercontent.com/81297207/132939682-87b6c6f1-0f18-47c0-a00c-00857e5e0c6c.png)

</details>

### Общие рекомендации
1. Исправить ошибку на главной странице и название вкладки ([Ошибка на главное странице](https://github.com/AlexandraOwl/netologyDiplomaProject/issues/4), [Ошибка названия вкладки](https://github.com/AlexandraOwl/netologyDiplomaProject/issues/3));
2. Исправить баги, связанные с неверными сообщениями об ошибках ([Неверные сообщения об ошибках](https://github.com/AlexandraOwl/netologyDiplomaProject/issues/7));
3. Для поля "Владелец" ввести ограничение на вводимые символы - только латинские буквы (желательно добавить ввод сразу верхним регистром независимо от нажатой клавиши Shift/Caps Lock) ([Недопустимые символы в поле "Владелец"](https://github.com/AlexandraOwl/netologyDiplomaProject/issues/1));
4. Сделать кнопку "Продолжить" неактивной, если есть пустые и/или неправильно заполненные поля.

**Полный список багов: https://github.com/AlexandraOwl/netologyDiplomaProject/issues**
