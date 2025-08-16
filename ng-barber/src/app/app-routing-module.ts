import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Home } from './components/home/home';

const routes: Routes = [
  // { path:"",
  //   redirectTo: '/home',
  //   pathMatch: 'full',
  //   title: "Home"
  // },

 { path:"home",
    component: Home,
    title: "Home"
  },

  // { path: "**",
  //   redirectTo: '/home',
  //   pathMatch: 'full',
  //   title: "Home" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
