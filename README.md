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
    mvn install 
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
   - Entra a la carpeta `com.example`.
   - Selecciona `DemoBlazeRunner`.
   - Y ejecuta el Run del de la clase.
   
4. **Ejecutar los Tests en linea de comandos**:
   - A la terminal del proyecto 
   - Ejecuta el siguiente comando
    ```sh
    mvn -Dtest=KarateTest test
    ```

5. **Localizar los reportes generados**:
   - Navega a la carpeta `target`.
   - Entra a la carpeta `karate-reports`.
   - Selecciona `karate-summary.html`.
 