# One-day Polyglot Scaffold (Java, PHP, Angular, Ionic)

This repository is a minimal scaffold to let you practice and build a small full-stack app in one day using:
- Java (Spring Boot) — REST + SOAP
- PHP — small microservice with REST & SOAP client
- Angular — web client (dev proxy provided)
- Ionic (Angular) — mobile app (instructions to create and reuse Angular services)

What I added for you
- backend/: Spring Boot app with:
  - REST endpoint: GET /api/greet?name=...
  - SOAP endpoint published at http://localhost:8080/ws/Calculator
- php/api/index.php: REST endpoint and SOAP-client example that calls the Java SOAP service on localhost.
- angular-client/proxy.conf.json: simple Angular CLI proxy mapping for development.
- small example Angular service/component snippets you can paste into a generated Angular app.
- .gitignore

Quickstart (complete this in one day)

1) Run Java backend
- From repository root:
  - cd backend
  - mvn spring-boot:run
- Verify:
  - curl "http://localhost:8080/api/greet?name=You"  -> JSON greeting
  - SOAP endpoint is published at: http://localhost:8080/ws/Calculator (endpoint is published; WSDL availability depends on JAX-WS runtime)

2) Run PHP microservice
- From repository root:
  - php -S localhost:8081 -t php/api
- Verify:
  - curl "http://localhost:8081/rest/greet?name=PHP"
  - curl "http://localhost:8081/soap/calc" -> calls Java SOAP add(4,5) and returns result (requires PHP SoapClient enabled)

3) Angular web client (dev)
- Create an Angular app if you don't have one:
  - npm i -g @angular/cli
  - ng new angular-client --routing --style=scss
- Copy `angular-client/proxy.conf.json` from this repo into the generated angular-client folder.
- Add the provided Angular service and component snippets into the generated app (see angular-client/README-instructions.txt inside the folder).
- Start dev server:
  - cd angular-client
  - ng serve --proxy-config proxy.conf.json
- The dev proxy maps /api -> http://localhost:8080 and /php -> http://localhost:8081.

4) Ionic mobile (fast reuse)
- If you want a mobile shell quickly:
  - npm i -g @ionic/cli
  - ionic start mobile-app blank --type=angular
- Reuse Angular services and components you created in angular-client (copy /src/app services and modules into the Ionic project).
- Run in browser: ionic serve

Files to look at and edit first
- backend/src/main/java/.../RestApiController.java (simple REST)
- backend/src/main/java/.../soap/CalculatorServiceImpl.java (simple SOAP)
- php/api/index.php (REST + SOAP client)
- angular-client/proxy.conf.json (dev proxy)

Next steps while you work today
- Implement a simple UI in Angular to call the Java REST and PHP REST endpoints.
- Add tests: JUnit for Java, basic PHPUnit or manual curl checks for PHP, Jasmine/Karma for Angular.
- Add a small "contacts" CRUD if you want persistence practice (H2 in-memory for speed).

If you'd like, I can now:
- Generate the exact Angular service/component files you can paste into `ng new` output.
- Produce a Docker-free run script that opens terminals and runs the three services (Java, PHP, Angular) using cross-platform commands.

Which of those two (Angular snippets or run script) would you like next?