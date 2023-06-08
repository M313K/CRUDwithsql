import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ServiceCRUDService } from '../service-crud.service';
import { Component} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Problem } from 'src/Problem';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class AdminComponent {
  error = '';
  success = '';
  problem:Problem={title:'',description:''};
  constructor(private service:ServiceCRUDService,private http: HttpClient,private route:ActivatedRoute  ) { }
  onSubmit(f:NgForm){
    let id=this.route.snapshot.paramMap.get('id');
    
    this.http.put("http://localhost:8080/problems/update/"+id,f.value).subscribe((res) => {
      console.log(res);
    },
    (err) => {
      this.error = err.error.error;
      console.log(this.error);        
    }
    );
    
    
  }
}
