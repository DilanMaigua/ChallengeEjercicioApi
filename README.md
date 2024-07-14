#  Challenge de Automatización de Pruebas

## Prerrequisitos

Para ejecutar este proyecto de automatización de pruebas, necesitarás tener instalado lo siguiente en tu máquina local:

- **Sistema Operativo**: Windows 10
- **Maven**: Versión 3.9.6
- **JDK**: Versión 11.0.23
- **IntelliJ IDEA**: Versión 2024.1.3 (Community Edition)

## Comandos de Instalación

1. **Instalar Dependencias del Proyecto**:
   - Abre una terminal y navega al directorio del proyecto.
   - Ejecuta los siguientes comandos para descargar todas las dependencias necesarias:
    ```sh
    mvn clean install
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
   - Selecciona `baseTest`.
   - Verifica que el tag del test sea el mismo que el del feature que desea ejecutar.
   - Ejecuta el test.

## Ejecución de Pruebas desde la Línea de Comandos

Para ejecutar específicamente la clase de prueba `baseTest` desde la línea de comandos utilizando Maven, usar el siguiente comando:

```sh
mvn clean verify -Dtags="@PruebasDemoblaze"
