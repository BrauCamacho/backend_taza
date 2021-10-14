import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TazaService } from './taza/taza/taza.service';
import { VentaService } from './venta/venta/venta.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  tazaForm: FormGroup;
  ventaForm: FormGroup;

  ventas:any
  tazas:any

  constructor(
    public fb:FormBuilder,
    public tazaService:TazaService,
    public ventaService:VentaService
  )
  {}
  ngOnInit(): void {
    this.tazaForm = this.fb.group({
      id_taza:[''],
      calidad:['', Validators.required],
      capacidad:['', Validators.required],
      modelo:['', Validators.required],
      material:['', Validators.required],
      color:['', Validators.required],
      stock:['', Validators.required]
    });;
    this.ventaForm = this.fb.group({
      id_venta:[''],
      id_taza:['', Validators.required],
      cantidad:['', Validators.required]
    });;


    this.tazaService.getAllTazas().subscribe(resp => {
      this.tazas = resp;
    },
      error => { console.error(error) }
    );

    this.ventaService.getAllVentas().subscribe(resp => {
      this.ventas = resp;
    },
      error => { console.error(error) }
    );

  }
  guardarTaza(): void {
    this.tazaService.saveTaza(this.tazaForm.value).subscribe(resp => {
      this.tazaForm.reset();
    },
      error => { console.error(error) }
    )
  }
  guardarVenta(): void {
    
    this.ventaService.saveVenta(this.ventaForm.value).subscribe(resp => {
      this.ventaForm.reset();
      
    },
      error => { console.error(error) }
    )
  }
   

  eliminarTaza(taza){
    this.tazaService.deleteTaza(taza.id_taza).subscribe(resp=>{
      if(resp===true){
        this.tazas.pop(taza)
      }
    })
  }

  editarTaza(taza){
    this.tazaForm.setValue({
      id_taza:taza.id_taza,
      calidad:taza.calidad,
      capacidad:taza.capacidad,
      modelo:taza.modelo,
      material:taza.material,
      color:taza.color,
      stock:taza.stock
    })
  }

}
