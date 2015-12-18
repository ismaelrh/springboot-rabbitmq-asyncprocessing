# springboot-rabbitmq-asyncprocessing
Proyecto que muestra el uso de RabbitMQ con Spring Boot para procesamiento asíncrono.

* Varias colas
* Un listener por cada cola, que por cada mensaje lanza un thread Worker apoyándose de pool de threads.
* Un pool de threads por cada cola.
* Un proceso periódico por cada cola que va insertando mensajes.
* Diseño modular, es fácil introducir más colas y adaptarlo.
