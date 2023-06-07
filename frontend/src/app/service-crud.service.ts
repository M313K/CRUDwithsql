import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Problem } from 'src/Problem';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServiceCRUDService {

  constructor(private http: HttpClient) { }
  addProblem(pb:Problem)
  {
    return this.http.post("http://localhost:8080/problems/add",pb);
  }
  getProblems()
  {
    return this.http.get("http://localhost:8080/problems/all");
  }
}
