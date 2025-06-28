import { ComponentFixture, TestBed } from "@angular/core/testing";
import {
  HttpClientTestingModule,
  HttpTestingController,
} from "@angular/common/http/testing";
import { AdoptionRequestComponent } from "./adoption-request.component";

describe("AdoptionRequestComponent", () => {
  let component: AdoptionRequestComponent;
  let fixture: ComponentFixture<AdoptionRequestComponent>;
  let httpMock: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdoptionRequestComponent],
      imports: [HttpClientTestingModule],
    }).compileComponents();

    fixture = TestBed.createComponent(AdoptionRequestComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges(); // triggers ngOnInit
  });

  afterEach(() => {
    httpMock.verify();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });

  it("should fetch adoption requests on init", () => {
    const mockData = [
      {
        petName: "Max",
        adopterName: "John",
        adopterEmail: "john@example.com",
        message: "Looking forward to adopting!",
      },
      {
        petName: "Luna",
        adopterName: "Jane",
        adopterEmail: "jane@example.com",
        message: "Can’t wait to meet Luna!",
      },
    ];

    const req = httpMock.expectOne("http://localhost:3000/adoptions");
    expect(req.request.method).toBe("GET");
    req.flush(mockData);

    expect(component.adoptionRequests.length).toBe(2);
    expect(component.adoptionRequests[0].petName).toBe("Max");
    expect(component.adoptionRequests[1].adopterName).toBe("Jane");
  });
});
