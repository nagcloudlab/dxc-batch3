import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DxcCardComponent } from './dxc-card.component';

describe('DxcCardComponent', () => {
  let component: DxcCardComponent;
  let fixture: ComponentFixture<DxcCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DxcCardComponent]
    });
    fixture = TestBed.createComponent(DxcCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
