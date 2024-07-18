#  Challenge de Automatización de Pruebas Api

## Prerrequisitos

Para ejecutar este proyecto de automatización de pruebas, necesitarás tener instalado lo siguiente en tu máquina local:

- **Sistema Operativo**: Windows 10
- **Maven**: Versión 3.9.6
- **JDK**: Versión 11.0.23
- **IntelliJ IDEA**: Versión 2024.1.3 (Community Edition)

## Comandos de Instalación

1. **Instalar Dependencias del Proyecto**:
   - Abre una terminal y navega al directorio del proyecto.
   - Ejecuta el siguiente comando para descargar todas las dependencias necesarias de maven:
    ```sh
    mvn install -U
    ```

## Instrucciones para Ejecutar los Tests

1. **Abrir el Proyecto en IntelliJ**:
   - Abre IntelliJ IDEA.
   - Selecciona `File` > `Open` y navega hasta el directorio del proyecto para abrirlo.

2. **Verificar la Configuración del JDK y Maven**:
   - Asegúrate de que la versión del JDK configurada en el proyecto sea la 11.
   - Verifica que Maven esté funcionando correctamente. Puedes hacerlo ejecutando `mvn -v` en la terminal integrada de IntelliJ.

3. **Ejecutar los Tests**:
   - Navega a la carpeta `src`.
   - Entra a la carpeta `test`.
   - Entra a la carpeta `java.com.everis.base.runner`.
   - Selecciona `baseTest`.
   - Verifica que el tag de test sea el mismo que el del feature que desea ejecutar.

## Ejecución de Pruebas desde la Línea de Comandos

Para ejecutar las pruebas y que genere los reportes utilizaremos el siguiente comando:

   ```sh
   mvn clean verify 
   ```

Clean limpiara los antiguos reportes en caso de existir y verify generara los nuevos reportes.

## Locacion de los reportes generados

La locacion de los reportes generados esta en la siguientes direcciones:

   - target/surefire-reports/karate-reports/surefire-report.html
   - target/cucumber-reports/index.html

Donde se creo un reporte en cucumber y el surefire-reports para karate.
