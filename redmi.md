# Проект-презентация по автоматизации для сайта "Rusprofile"



## :pushpin: Содержание:

- <a href="#tools"> Стек используемых технологий</a>
- <a href="#console"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#allureTestOps"> Интеграция с Allure TestOps</a>
- <a href="#jira"> Интеграция с Jira</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>
- <a href="#video"> Видео примера запуска тестов в Selenoid</a>


## Стек используемых технологий

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" alt="java" width="40" height="40"/> </a>
<a href="https://selenide.org/"> <img src="https://ru.selenide.org/images/selenide-logo-big.png" alt="selenide" width="80" height="40"/> </a>
<a href="https://junit.org/junit5/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" alt="junit" width="40" height="40"/> </a>
<a href="https://gradle.org/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" alt="gradle" width="40" height="40"/> </a>
<a href="https://aerokube.com/selenoid-ui/latest/"> <img src="https://aerokube.com/img/aerokube_logo.svg" alt="selenoid" width="40" height="40"/> </a>
<a href="https://docs.qameta.io/allure-testops/"> <img src="https://plugins.jetbrains.com/files/12513/451639/icon/pluginIcon.svg" alt="allure testOps" width="35" height="35"/> </a>
<a href="https://allurereport.org/"> <img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" alt="allure report" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original-wordmark.svg" alt="jira" width="40" height="40"/> </a>
<a href="https://www.jenkins.io/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" alt="jenkins" width="40" height="40"/> </a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки

Автоматизированные тесты

- - Регистрация на Rusprofile
- - Успешный вход
- - Вход с невалидным паролем
- - Вход с невалидной почтой
- - Проверка названия заголовка раздела на Rusprofile
- - Проверка правильности поискового запроса

Для запуска сборки необходимо перейти в раздел ```Build with Parameters```, выбрать необходимые параметры и нажать кнопку ```Build```.
#### :hammer_and_wrench:: Параметры сборки в Jenkins:
- BROWSER (браузер: chrome/firefox, по умолчанию chrome)
- BROWSER_VERSION (версия браузера, по умолчанию 100.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- REMOTE_URL (адрес удаленного сервера для запуска)