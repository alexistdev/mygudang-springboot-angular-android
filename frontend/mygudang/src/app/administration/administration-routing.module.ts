import { NgModule } from '@angular/core';
import {RouterModule} from "@angular/router";
import {TransaksiComponent} from "./component/transaksi/transaksi.component";
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {HomeStaffComponent} from "./component/home-staff/home-staff.component";

/**
* Author: AlexistDev
* Email: alexistdev@gmail.com
* github: https://github.com/alexistdev
* date: 09/05/2023
**/

const ADMINISTRATION_PATH = [
  {
    path: 'staff',
    component: HomeStaffComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'transaksi',
        component: TransaksiComponent
      },
    ]
  },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(ADMINISTRATION_PATH)],
  exports: [
    RouterModule
  ],
})

export class AdministrationRoutingModule { }