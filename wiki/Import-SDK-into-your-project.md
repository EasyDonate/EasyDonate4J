Для использования моего SDK в своём проекте вам, для начала, нужно его туда подключить.
Сделать это можно четырьмя описанными ниже способами.
Выбирайте тот, который больше подходит в вашем случае.

# Содержание
* [Использование инструментов сборки](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-using-any-build-tools)
  * [Добавление зависимости в проект с Maven](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-sdk-with-maven)
  * [Добавление зависимости в проект с Gradle](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-sdk-with-gradle)
* [Ручное подключение в вашей IDE](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-into-your-ide)
  * [Подключение зависимости в Eclipse IDE](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-sdk-in-eclipse-ide)
  * [Подключение зависимости в Intellij IDEA](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project#import-sdk-in-intellij-idea)

# Import using any build tools
Наиболее быстрый способ начать использовать SDK - подключить его к проекту как зависимость.
Сделать это вы можете через Maven или Gradle, что вам больше по душе.

## Import SDK with Maven
Сначала необходимо подключить репозиторий JitPack, если он ещё не подключён в вашем проекте:
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```
Затем добавьте зависимость:
```xml
    <dependencies>
        <dependency>
            <groupId>com.github.SoKnight</groupId>
            <artifactId>EasyDonateSDK</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependencies>
```
**ВАЖНО!** Не забудьте заменить `VERSION` на актуальную версию библиотеки: 
[![](https://jitpack.io/v/SoKnight/EasyDonateSDK.svg)](https://jitpack.io/#SoKnight/EasyDonateSDK)

## Import SDK with Gradle
Здесь, как и в случае с Maven, вам нужно иметь подключённый репозиторий JitPack в вашем проекте:
```gradle
    repositories {
        maven { url 'https://jitpack.io' }
    }
```
А также добавьте зависимость:
```gradle
    dependencies {
        implementation 'com.github.SoKnight:EasyDonateSDK:VERSION'
    }
```
**ВАЖНО!** Не забудьте заменить `VERSION` на актуальную версию библиотеки: 
[![](https://jitpack.io/v/SoKnight/EasyDonateSDK.svg)](https://jitpack.io/#SoKnight/EasyDonateSDK)

# Import into your IDE
Если же вы не имеете опыта работы с инструментами сборки выше, или среди них нет вашего, или же по какой-то иной причине вы не можете воспользоваться предложенными выше инструкциями, то вы можете вручную добавить данную библиотеку в ваш проект.

## Import SDK in **Eclipse IDE**
1. Загрузите JAR-файл с суффиксом `-shaded` из последнего актуального релиза [здесь](https://github.com/SoKnight/EasyDonateSDK/releases).
2. Нажмите **ПКМ** по проекту -> **Build Path** -> **Configure Build Path...**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/eclipse-step-2.png)
3. Нажмите **Add External JARs...**, выберите скачанный файл из п.1 и нажмите **Открыть**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/eclipse-step-3.png)
4. Нажмите **Apply and Close**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/eclipse-step-4.png)
5. Убедитесь, что библиотека подключена. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/eclipse-step-5.png)

## Import SDK in **Intellij IDEA**
1. Загрузите JAR-файл с суффиксом `-shaded` из последнего актуального релиза [здесь](https://github.com/SoKnight/EasyDonateSDK/releases).
2. Нажмите **File** в верхнем меню -> **Project Structure...**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-2.png)
3. Перейдите в раздел **Libraries** -> **+** -> **Java**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-3.png)
4. Выберите скачанный файл из п.1 и нажмите **ОК**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-4.png)
5. В появившемся окне **Choose Modules** также нажмите **ОК**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-5.png)
6. В окне структуры проекта нажмите **Apply** -> **ОК**. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-6.png)
7. Убедитесь, что библиотека подключена. [Показать](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/intellij-step-7.png)

