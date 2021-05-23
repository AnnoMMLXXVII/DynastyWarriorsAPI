import { Component, OnInit } from '@angular/core';
import {Mercenary} from './mercenary';
import { MERCENARY } from './mock-mercenaries';

@Component({
  selector: 'app-mercenary',
  templateUrl: './mercenary.component.html',
  styleUrls: ['./mercenary.component.css']
})
export class MercenaryComponent implements OnInit {

  mercenaries = MERCENARY;
  selectedMercenary? : Mercenary;

  onSelect(mercenary : Mercenary) : void {
    this.selectedMercenary = mercenary;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
