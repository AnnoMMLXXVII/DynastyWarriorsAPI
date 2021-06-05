import { Component, OnInit } from '@angular/core';
import {Hero} from './hero';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  id  = 0;
  name = 'Syntyche the Poison Drinker';

  Hero : Hero = { 
    id : 1,
    name: 'Ovicide The Gentle',
    title : "Mercenary"
};

  constructor() { }

  ngOnInit(): void {
  }

}
