import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MercenaryComponent } from './mercenary.component';

describe('MercenaryComponent', () => {
  let component: MercenaryComponent;
  let fixture: ComponentFixture<MercenaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MercenaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MercenaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
