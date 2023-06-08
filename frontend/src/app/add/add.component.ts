import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServiceCRUDService } from '../service-crud.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Problem } from 'src/Problem';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class HomeComponent {
  error = '';
  success = '';
  problem:Problem={title:'',description:''};
  constructor(private service:ServiceCRUDService,private http: HttpClient ) { }
  onSubmit(f:NgForm){
    
    this.http.post("http://localhost:8080/problems/add",f.value).subscribe((res) => {
      console.log(res);
      

    },
    (err) => {
      this.error = err.error.error;
      console.log(this.error);        
    }
    );
    
    
  }

}
