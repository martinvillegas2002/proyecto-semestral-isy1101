# Proyecto Semestral: Sistema de Gestión de Ventas y Despachos (ISY1101)

## Descripción del Proyecto
Este proyecto consiste en la orquestación y automatización de una plataforma de gestión financiera y logística. El sistema permite gestionar órdenes de compra y estados de despacho, desplegado en un entorno de nube profesional utilizando microservicios.

## Arquitectura (IE1 - IE2)
El sistema está desplegado en **AWS ECS (Elastic Container Service)** bajo la modalidad **Fargate**, garantizando alta disponibilidad y escalabilidad.

* **Infraestructura:** Clúster ECS con contenedores independientes para Frontend y Backend.
* **Almacenamiento:** Imágenes de contenedores almacenadas y versionadas en **Amazon ECR**.
* **Networking:** Configuración de VPC, subredes privadas y Security Groups para aislamiento seguro de servicios.

## Automatización CI/CD (IE4)
La liberación de software está totalmente automatizada mediante **GitHub Actions**. 
* **Workflow:** Cada vez que se realiza un `git push` a la rama `main`, el pipeline realiza automáticamente el `build` de la imagen, el `push` hacia ECR y el `deploy` forzado (rolling update) en el clúster de ECS.
* **Seguridad:** Las credenciales de AWS se gestionan a través de *Secrets* de GitHub, evitando la exposición de claves en el repositorio (IE5).

## Escalabilidad (IE3)
El servicio cuenta con una política de **Auto Scaling (Target Tracking)**:
* **Métrica:** Utilización de CPU.
* **Umbral:** 70%.
* **Justificación:** Se ha configurado este umbral para maximizar el uso de los recursos de Fargate, manteniendo un margen del 30% para absorber picos de tráfico repentinos sin degradar el rendimiento del servicio.

## Validación y Monitoreo (IE6 - IE7)
* **Logs:** El monitoreo se realiza a través de **CloudWatch Logs**, permitiendo la trazabilidad completa de los errores y tiempos de respuesta.
* **Comunicación:** El Frontend consume los servicios de Backend a través de variables de entorno configuradas dinámicamente en la Task Definition, asegurando una validación funcional robusta (Front → Back).

## Instrucciones de Uso
1. El despliegue es automático vía GitHub Actions.
2. Para realizar cambios, haz un commit y un push a la rama `main`.
3. Verifica el estado del despliegue en la pestaña "Actions" de este repositorio y en la consola de AWS ECS.