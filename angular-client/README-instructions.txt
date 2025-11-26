Paste these snippets into a freshly created Angular app (created with `ng new angular-client`).

1) Add the proxy.conf.json at project root (replace existing if needed).
2) Create a service at src/app/services/greet.service.ts:
   - Inject HttpClient and implement calls to /api/greet and /php/rest/greet.
3) Create a component at src/app/greet/greet.component.{ts,html} that calls the service and displays results.
4) Run:
   - cd angular-client
   - ng serve --proxy-config proxy.conf.json