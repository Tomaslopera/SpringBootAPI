# GlowUpRevenge API

Una API construida con Spring Boot 3 que permite a **Line**, una fashionista, modelo y hacker amateur, llevar un registro épico de sus antiguos bullies... y sus meticulosos planes de venganza.


## Integrantes

- Tomás Lopera
- Pedro Sierra


## Tecnologías usadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 (base de datos en memoria)
- Maven
- Lombok


## Estructura del Proyecto

> controller/

> dao/

> dto/

> models/

> services/

> Trabajo1Application.java

## Entidades principales

### Bully
- `name`, `nickname`, `highSchoolRole`
- Relación: Muchos a Uno con `Clique`
- Relación: Uno a Muchos con `RevengePlan`

### Clique
- `name`, `description`
- Relación: Uno a Muchos con `Bully`

### RevengePlan
- `title`, `description`, `isExecuted`, `successLevel`
- Relación: Muchos a Uno con `Bully`
- Relación: Uno a Muchos con `Media`

### Media
- `type`, `url`, `caption`
- Relación: Muchos a Uno con `RevengePlan`

### MoodTracker
- `date`, `moodLevel`, `note`
- Registro del estado emocional post-venganza
