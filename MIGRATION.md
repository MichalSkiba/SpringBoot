# Upgrade from Spring Boot 2.0.1 to 3.5.16

* Requires Java 21 and Maven 3.9+.
* Uses Jakarta Persistence and Validation, Spring Security 6 filter chains, modern Spring Data PageRequest.
* Uses WAR packaging for JSP templates.
* Requires external database configuration via DB_URL / DB_USERNAME / DB_PASSWORD.
* CSRF protection is enabled. Verify all POST forms, login and logout behavior.
* **Database migration:** make a backup, review Hibernate schema changes, and validate the schema separately before deployment.
* CI compiles and runs isolated unit tests only. Integration tests require an isolated database and must be run before production.
* Further update to Spring Boot 4.x should be a separate, tested migration.
