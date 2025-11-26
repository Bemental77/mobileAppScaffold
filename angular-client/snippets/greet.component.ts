// Paste into src/app/greet/greet.component.ts in an Angular app (and add route or selector)
import { Component } from '@angular/core';
import { GreetService } from '../services/greet.service';

@Component({
  selector: 'app-greet',
  templateUrl: './greet.component.html'
})
export class GreetComponent {
  name = 'DayBuilder';
  message = '';
  constructor(private svc: GreetService) {}

  callJava() {
    this.svc.greetJava(this.name).subscribe(res => this.message = res?.message || JSON.stringify(res));
  }

  callPhp() {
    this.svc.greetPhp(this.name).subscribe(res => this.message = res?.message || JSON.stringify(res));
  }
}