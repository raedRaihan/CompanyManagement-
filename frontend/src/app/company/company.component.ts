import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../current-user.service';
import { Router } from '@angular/router';

interface company{
  id: number,
  name: string,
  description: string
}

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})

export class CompanyComponent implements OnInit {
  selectedCompany : number = -1;
  companies : company[] = [];
  userData: any = null; 

  constructor(private currentUserService: CurrentUserService, private router: Router){}

  ngOnInit(): void {
    if(!this.currentUserService.hasSession()) {
      this.router.navigateByUrl("/");
    }
    this.userData = this.currentUserService.getUserData();
    this.companies = this.userData.companies;
  }

  onCompanyChange(): void{
    this.currentUserService.setCurrentCompany(this.selectedCompany);
    console.log("Company id: " + this.currentUserService.getCurrentCompany());
    this.router.navigateByUrl("/home");
  }
}
