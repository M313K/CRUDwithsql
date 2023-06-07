import { TestBed } from '@angular/core/testing';

import { ServiceCRUDService } from './service-crud.service';

describe('ServiceCRUDService', () => {
  let service: ServiceCRUDService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceCRUDService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
