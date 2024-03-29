import {Injectable} from "@angular/core";
/**
* Author: AlexistDev
* Email: alexistdev@gmail.com
* github: https://github.com/alexistdev
* date: 09/05/2023
**/

@Injectable()
export  class LocalStorageService {

  setItem(key:string, val:string):void {
    sessionStorage.setItem(key, val);
  }

  getItem(key:string):string {
    return sessionStorage.getItem(key);
  }

  clearItem():void {
    sessionStorage.clear();
  }
}
