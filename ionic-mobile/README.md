# Ionic mobile app (quick start)

To create a mobile shell that reuses your Angular services:

1) Install Ionic CLI (if needed):
   npm i -g @ionic/cli

2) Create a new Ionic Angular app:
   ionic start mobile-app blank --type=angular

3) Copy services from angular-client/src/app/services into mobile-app/src/app/services.
   Copy components/pages you want to reuse (adapt routing and module declarations).

4) Run in browser:
   cd mobile-app
   ionic serve

5) For emulator / device, follow Ionic docs to add platforms (Android/iOS) and run via Capacitor.