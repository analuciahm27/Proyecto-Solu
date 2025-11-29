import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../service/producto-service';
import { Router } from '@angular/router';
import { Producto } from '../../model/Producto';

@Component({
  selector: 'app-menu',
  imports: [],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu implements OnInit {

listProductos: Producto[] = [];

constructor(
  private productoService: ProductoService,
  private router: Router
) {}

ngOnInit(): void {
 this.cargarProductos();
}

cargarProductos(): void {
  this.productoService.cargarProductos().subscribe(
    (data) => {
      this.listProductos = data;
      console.log(this.listProductos);
    },
    (error) => {
      console.log(error);
    }
  );
}
}
