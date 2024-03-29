/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
import {LocalStorageService} from "../../config/service/local-storage.service";
import {Observable, Observer, map} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable, Provider} from "@angular/core";
import {LoginComponent} from "../component/login/login.component";

@Injectable()
export class LoginService {
  private  menuList:[] ;
  constructor(
    private http: HttpClient,
    private localStorageService: LocalStorageService
  ) {
  }

  doUserLogin(userName: string, userPwd: string): Observable<boolean>{
    return new Observable((observer: Observer<any>) => {
      this.http.post('http://localhost:8901/v1/auth/login', {'username': userName , 'password' : userPwd})
        .subscribe({
          next: (res) => {
            if(!res){
              observer.next(false);
            }
            let stringifiedData = JSON.stringify(res);
            let parsedJson = JSON.parse(stringifiedData);
            let data = parsedJson.data;
            this.menuList = data.menuList;
            this.localStorageService.setItem("menu",JSON.stringify( this.menuList));
            this.localStorageService.setItem("userId",data.id);
            observer.next(true);
          },
          error: (e) => {
            observer.next(false);
            console.log(e)
          },
        });
    });
  }
}
