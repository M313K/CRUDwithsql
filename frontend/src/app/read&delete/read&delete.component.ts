import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceCRUDService } from '../service-crud.service';
@Component({
  selector: 'app-read&delete',
  templateUrl: './read&delete.component.html',
  styleUrls: ['./read&delete.component.css']
})
export class UserComponent {
  problems:Array<any>=[];
  
  constructor(private http:HttpClient,private router: Router ) { }
  ngOnInit():void{
    this.http.get("http://localhost:8080/problems/all").subscribe(
      (res)=>{
        this.problems=JSON.parse(JSON.stringify(res));
      }
    )
  }
  updateProblem(id:number)
  {
    this.router.navigateByUrl('/update/'+id);
  }
  deleteProblem(id:number){
    this.http.delete('http://127.0.0.1:8080/problems/delete/'+id).subscribe(
      (res)=>
      {
        console.log(res);
        window.location.reload();
      }
    )
  }

}
