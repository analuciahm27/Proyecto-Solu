import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../model/Producto';
@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  private apiURL='http://localhost:8080/api/productos';
  constructor(
    private http: HttpClient
  ) {}
  cargarProductos():Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.apiURL}/`);
  }
}
