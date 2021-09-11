# Дипломный проект по атоматическому тестированию Netology. 
![Build Status](https://github.com/AlexandraOwl/netologyDiplomaProject/actions/workflows/gradle.yml/badge.svg)

- [Дипломное задание](https://github.com/netology-code/qa-diploma)
- [Тестовый план](https://github.com/AlexandraOwl/netologyDiplomaProject/blob/main/documents/TEST_PLAN.md)
- [Отчет по автоматизированным тестам](https://github.com/AlexandraOwl/netologyDiplomaProject/blob/main/documents/TEST_REPORT.md)

## Для запуска проекта:
1. Склонироват репозиторий проекта;
2. Скачать Docker по ссылке: https://docs.docker.com/get-docker/, установить и запустить;
3. Открыть проект в Intellij Idea;

## Для запуска контейнера Docker с тестовым приложением:
1. В терминале Idea запустить команду: *docker-compose up -d*;
2. В зависимости от желаемой БД запустить команды: 
- для MySQL: *java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar ./artifacts/aqa-shop.jar*
- для Postgre: *java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -jar ./artifacts/aqa-shop.jar*
3. Проверить контейнер командой: *docker ps*;
4. Убедиться, что приложение открывается по адресу **localhost:8080**;

## Для запуска тестов:
1. Запустить в отдельном терминале команду: 
- *gradlew test -Dselenide.headless=true -Durlbd=jdbc:mysql://localhost:3306/app --info* (для MySQL), 
или 
- *gradlew test -Dselenide.headless=true -Durlbd=jdbc:postgresql://localhost:5432/app --info* (для Postgre);
2. По окончаню выполнения тестов запустить отчет двумя последовательными командами:
- *gradlew allureReport*
- *gradlew allureServe*
3. В браузере появится окно с готовым репортом и статистикой по тестам.

## Завершение работы и удаление контейнера:
1. В терминале из предыдущего шага нажать сочетание клавиш: *Ctrl+C*;
2. Остановить контейнер Docker командой: *docker-compose down*.
