Тестовое задание для Лиги Ставок.

Описание проекта: проект содержит UI-тест со следующим сценарием:
1. Переход на market.yandex.ru
2. Выбор раздела Электроника > Телевизоры
3. Заданы параметры поиска: "по цене" - от 20000 рублей, "по производителю" - Samsung и LG
4. Открытие первого найденного товара из списка по результатам поиска
5. Проверка производителя и цены на соответствие выбранным параметрам поиска

Каждый шаг фиксируется скриншотом и отправляется в отчет Allure.

Основные использованные технологии: Java, Selenium Webdriver, Maven, TestNG, Allure.

Инструкции по запуску проекта:
1. Склонировать репозиторий к себе на компьютер
2. Открыть репозиторий с помощью Intellij IDEA
3. В терминале программы прописать команду "mvn clean install", произойдет билд, запустится тест
4. После выполнения теста для просмотра отчета перейти в плагины TestProjectBettingLeague > Plugins > Maven > allure > запустить allure:serve для отображения отчета по прохождению теста
5. В сформированном отчете для просмотра скриншотов перейти в Suites > Surefire suite > Surefire test > org.example.Tests.MarketTest > Tests on yandex.market.ru. Справа появится отчет, в котором перейти в Test Body и под каждым Step будет содержаться соответствующий шагу скриншот
