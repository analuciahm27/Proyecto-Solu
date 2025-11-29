import { Component } from '@angular/core';
import { Carrito } from "../carrito/carrito";
import { Menu } from "../menu/menu";

@Component({
  selector: 'app-principal',
  imports: [Carrito, Menu],
  templateUrl: './principal.html',
  styleUrl: './principal.css',
})
export class Principal {

}
