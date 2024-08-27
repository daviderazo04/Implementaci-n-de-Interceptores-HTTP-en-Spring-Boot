# Implementación de Interceptores HTTP en Spring Boot<br>
Este proyecto demuestra el uso de interceptores HTTP en una aplicación Spring Boot. Los interceptores son herramientas potentes que permiten interceptar y manipular las solicitudes y respuestas HTTP en una aplicación web. 
En este proyecto, se ha implementado un interceptor personalizado llamado LoadingTimeInterceptor, que mide el tiempo de procesamiento de las solicitudes en rutas específicas de la aplicación.
## Características del Proyecto:
### Interceptor HTTP Personalizado:
El LoadingTimeInterceptor se encarga de registrar el tiempo de inicio de la solicitud en el método preHandle() y, posteriormente, calcular el tiempo total de procesamiento en el método postHandle().
Además, se ha incorporado un retraso aleatorio para simular el tiempo de carga en la respuesta del servidor.
### Configuración de Interceptores:
El interceptor se configura en la clase MvcConfig, donde se especifican las rutas (/app/bar y /app/foo) a las que se aplica el interceptor.
### Controladores REST:
Se han creado varios endpoints (/foo, /bar, /baz) dentro del controlador AppController que retornan mensajes simples en formato JSON, demostrando cómo los interceptores pueden actuar sobre distintas rutas.
