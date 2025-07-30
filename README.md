# Employee Management System

This is a simple Employee Management System built with Spring Boot.

## Annotations Used

### Spring Framework Annotations

- `@SpringBootApplication`: This is a convenience annotation that adds all of the following:
    - `@Configuration`: Tags the class as a source of bean definitions for the application context.
    - `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
    - `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `com/project/ems` package, allowing it to find and register the controllers.

- `@Service`: Indicates that an annotated class is a "Service". This annotation serves as a specialization of `@Component`, allowing for implementation classes to be autodetected through classpath scanning.

- `@Autowired`: Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.

- `@Override`: A Java annotation that indicates that a method is intended to override a method in a superclass.

- `@Transactional`: A Spring annotation that declares that a method or class should be executed within a database transaction.

- `@Repository`: Indicates that an annotated class is a "Repository". This annotation serves as a specialization of `@Component`, allowing for implementation classes to be autodetected through classpath scanning. It's a good practice to apply this annotation to DAO classes.

- `@RestControllerAdvice`: A specialization of the `@Component` annotation which allows to handle exceptions across the whole application in one global handling component.

- `@RestController`: A convenience annotation that is itself annotated with `@Controller` and `@ResponseBody`. This annotation is applied to a class to mark it as a request handler.

- `@RequestMapping`: An annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.

- `@GetMapping`: A specialized version of `@RequestMapping` that acts as a shortcut for `@RequestMapping(method = RequestMethod.GET)`.

- `@PostMapping`: A specialized version of `@RequestMapping` that acts as a shortcut for `@RequestMapping(method = RequestMethod.POST)`.

- `@DeleteMapping`: A specialized version of `@RequestMapping` that acts as a shortcut for `@RequestMapping(method = RequestMethod.DELETE)`.

- `@PathVariable`: An annotation which indicates that a method parameter should be bound to a URI template variable.

- `@RequestBody`: An annotation indicating a method parameter should be bound to the body of the web request.

### Lombok Annotations

- `@Data`: A convenience annotation that bundles the features of `@ToString`, `@EqualsAndHashCode`, `@Getter` / `@Setter` and `@RequiredArgsConstructor` together.

- `@AllArgsConstructor`: Generates a constructor with 1 parameter for each field in your class.

- `@NoArgsConstructor`: Generates a constructor with no parameters.

- `@Builder`: A helper annotation from Lombok that produces complex builder APIs for your classes.

- `@Getter`: A Lombok annotation to generate the getter methods for all fields.

- `@Setter`: A Lombok annotation to generate the setter methods for all fields.

### JPA Annotations

- `@Entity`: Specifies that the class is an entity. This annotation is applied to the entity class.

- `@Table`: Specifies the table in the database with which this entity is mapped.

- `@Id`: Specifies the primary key of an entity.

- `@GeneratedValue`: Provides for the specification of generation strategies for the values of primary keys.

- `@ManyToOne`: Specifies a single-valued association to another entity class that has many-to-one multiplicity.

- `@JoinColumn`: Specifies a column for joining an entity association or element collection.

- `@Column`: Is used to specify the mapped column for a persistent property or field.

- `@Enumerated`: Specifies that a persistent property or field should be persisted as an enumerated type.

### Jackson Annotations

- `@JsonProperty`: A Jackson annotation used to map property names with JSON keys during serialization and deserialization.
