# Proyecto de Pruebas Técnicas

Este proyecto contiene pruebas automatizadas utilizando Selenium, Cucumber, Serenity y Java. Está diseñado para demostrar cómo integrar estas tecnologías para realizar pruebas de aceptación automatizadas.


## Authors

- [@Jaher Rojas](https://github.com/jaherrojas)



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
- Fácil integración con herramientas de CI/CD.

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
## Estructura de proyecto



- `src/test/java/resources/features`: Contiene las clases de prueba y los runners.
- `src/test/java/pages`: Contiene los archivos con la lógica y los métodos.
- `src/test/java/runner`: Contiene la configuración de los reportes generados.
- `serenity.properties`: Archivo de configuración de Serenity.



## Dependencias

Este proyecto utiliza Serenity BDD, JUnit y Cucumber para pruebas automatizadas. Asegúrate de incluir las siguientes dependencias en tu archivo `build.gradle`:

```gradle
plugins {
    id 'java'
    id 'maven'
}

repositories {
    mavenCentral()
}

dependencies {
   // Testing frameworks
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'
    testImplementation 'org.testng:testng:7.10.2'

    // Selenium
    implementation 'org.seleniumhq.selenium:selenium-java:4.22.0'
    implementation 'org.seleniumhq.selenium:selenium-chrome-driver:4.22.0'
    implementation 'org.seleniumhq.selenium:selenium-firefox-driver:4.22.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.9.1'

    // Cucumber
    implementation 'io.cucumber:cucumber-java:7.18.0'
    testImplementation 'io.cucumber:cucumber-junit:7.18.0'

    // Serenity dependencies
    testImplementation "net.serenity-bdd:serenity-core:4.1.20"
    testImplementation "net.serenity-bdd:serenity-junit:4.1.20"
    testImplementation "net.serenity-bdd:serenity-cucumber:4.1.20"

    // Additional dependencies
    implementation 'com.github.javafaker:javafaker:1.0.2'   
}
```