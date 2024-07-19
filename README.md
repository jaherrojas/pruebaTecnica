# Proyecto de Pruebas Técnicas

Este proyecto contiene pruebas automatizadas utilizando Selenium, Cucumber, Serenity y Java. Está diseñado para demostrar cómo integrar estas tecnologías para realizar pruebas de aceptación automatizadas.


## Authors

- [@Jaher Rojas](https://github.com/jaherrojas/pruebaTecnica)



### Cucumber

**Cucumber** es una herramienta de pruebas que admite la escritura de especificaciones de pruebas en un lenguaje natural (Gherkin). Facilita la comunicación entre los desarrolladores, testers y stakeholders, permitiendo definir el comportamiento esperado del software mediante ejemplos legibles por humanos.
![CucumberLogo](https://i.pinimg.com/originals/dd/be/20/ddbe20664a0e1e16a5706655616ee870.png)


- **Ventajas:**
  - Escritura de pruebas en lenguaje natural.
  - Fomenta la colaboración entre equipos técnicos y no técnicos.
  - Integración con múltiples lenguajes de programación y frameworks de automatización.

- **Ejemplo de un archivo Gherkin:**
  ```gherkin
  Feature: Login Feature

  Scenario: Usuario ingresa con credenciales válidas
    Given El usuario está en la página de inicio de sesión
    When El usuario ingresa su nombre de usuario y contraseña
    Then El usuario debería ser redirigido a la página de inicio
   ```


### Serenity BDD

**Serenity BDD** es un framework para pruebas automatizadas que extiende las capacidades de WebDriver y JUnit. Proporciona herramientas avanzadas para generar informes detallados y visuales sobre la ejecución de las pruebas, facilitando la comprensión del estado del proyecto y la cobertura de las pruebas.

![SerenityLogo](https://serenity-bdd.info/wp-content/uploads/2022/04/serenity-dojo.png)

**Ventajas:**
- Informes detallados y visuales de las pruebas.
- Soporte para pruebas de aceptación y de regresión.
- Integración con Cucumber, JUnit y otros frameworks de pruebas.

**Características clave:**
- Captura de capturas de pantalla durante la ejecución de las pruebas.
- Organización de pruebas en historias y tareas.



### Selenium

**Selenium** es una herramienta de automatización para pruebas de aplicaciones web. Permite controlar navegadores web mediante scripts y automatizar interacciones con la página web, como hacer clic en botones, ingresar texto y navegar entre páginas.

![SeleniumLogo](https://digitronsoftwares.com/assets/uploads/media-uploader/qasnklj71709102260.png)

**Ventajas:**
- Soporte para múltiples navegadores (Chrome, Firefox, Safari, etc.).
- Compatibilidad con diversos lenguajes de programación (Java, C#, Python, etc.).
- Capacidad para ejecutar pruebas en entornos distribuidos.

**Ejemplo de uso de Selenium en Java:**

```java
WebDriver driver = new ChromeDriver();
driver.get("https://www.ejemplo.com");
WebElement usernameField = driver.findElement(By.id("username"));
usernameField.sendKeys("usuario");
WebElement passwordField = driver.findElement(By.id("password"));
passwordField.sendKeys("contraseña");
WebElement loginButton = driver.findElement(By.id("loginButton"));
loginButton.click();

```

## Requisitos

Asegúrate de tener instalados los siguientes programas en tu máquina:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/)
- [Git](https://git-scm.com/)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/tu-repositorio.git
   ```

2. Este proyecto usa JDK 17 y Gradle 8.9 

   ```bash
   https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

   https://gradle.org/next-steps/?version=8.9&format=bin
   ```

3. Variables de entorno 

   ```bash
   Crear una variable de entorno con nombre de : JAVA_HOME 
   Darle ala variable la ruta del JDK : C:\Users\Usuario\Downloads\jdk-17.0.7_windows-x64_bin\jdk-17.0.7
   ```

  ```bash
  En la ruta de PATH para Gradle : C:\Users\Esteban\Desktop\gradle-8.9-bin\gradle-8.9\bin
  windows-x64_bin\jdk-17.0.7\bin
  ``` 
  ```bash
  En la ruta de PATH para JDK: C:\Users\usuario\Downloads\jdk-17.7_windows-x64_bin\jdk-17.0.7\bin
  ``` 


4. Extensiones nescesarias para el correcto Funcionamiento en el Editor de Visual studio Code
 
- Live server
- Cucumber
- Debugger for Java
- Extension pack
- Gradle for Java
- Gradle language support
- LiveServer

5. Como ejecutar las pruebas dentro del proyecto

```
Adentro de la terminarl dentro del proyecto : cd pruebaTecnica
```
```
Una vez dentro del proyecto ejecutar el siguiente comando :  ./gradlew test

Para visualizar el reporte de serenity clic en la ruta que tira la termina la cual es: file:///C:/Users/jaher/Desktop/pruebaTecnica/target/site/serenity/index.html

Luego ejecutamos el index.html con el liveServer
```


## Estructura de proyecto

- `src/test/java/resources/features`: Contiene los archivos de características (features) de Cucumber.
- `src/test/java/pages`: Contiene las clases que implementan el patrón Page Object Model (POM) con la lógica y los métodos para interactuar con las páginas web.
- `src/test/java/runner`: Contiene las clases que configuran la ejecución de pruebas y generación de reportes.
- `serenity.properties`: Archivo de configuración de Serenity. En este archivo ajustamos el navegador con el que queremos ejecutar.

## Como seleccionar navegador para la ejecución

- `serenity.properties`: webdriver.driver = chrome **Puedes cambiarlo por "firefox".**
 

## Dependencias

Este proyecto utiliza Serenity BDD, JUnit y Cucumber para pruebas automatizadas. Asegúrate de incluir las siguientes dependencias en tu archivo `build.gradle`:

```gradle
plugins {
    id 'java'
    id 'application'
    id 'net.serenity-bdd.serenity-gradle-plugin' version '3.9.7'
}

repositories {
    mavenCentral()
}

// Definir la versión de Serenity como una variable
ext {
    serenityVersion = '4.1.20'
}

dependencies {
    // Testing frameworks
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'

    // Selenium
    implementation 'org.seleniumhq.selenium:selenium-java:4.22.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.9.1'

    // Cucumber
    implementation 'io.cucumber:cucumber-java:7.18.0'
    testImplementation 'io.cucumber:cucumber-junit:7.18.0'

   // Serenity dependencies usando la variable de versión
    testImplementation "net.serenity-bdd:serenity-core:$serenityVersion"
    testImplementation "net.serenity-bdd:serenity-junit:$serenityVersion"
    testImplementation "net.serenity-bdd:serenity-cucumber:$serenityVersion"

    // Additional dependencies
    implementation 'com.github.javafaker:javafaker:1.0.2'

    task cleanReports(type: Delete) {
    delete fileTree(dir: 'target/serenity-reports', include: '**/*')
}

test.dependsOn cleanReports
}

```
