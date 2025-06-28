import {
  ComponentFixture,
  TestBed,
  fakeAsync,
  tick,
} from "@angular/core/testing";
import { NavbarComponent } from "./navbar.component";
import { RouterTestingModule } from "@angular/router/testing";
import { Router } from "@angular/router";
import { By } from "@angular/platform-browser";

describe("NavbarComponent", () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NavbarComponent],
      imports: [RouterTestingModule],
    }).compileComponents();

    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  afterEach(() => {
    localStorage.clear();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });

  it("should display username when logged in", () => {
    localStorage.setItem("username", "Alice");
    component.loadUsername();
    fixture.detectChanges();

    const usernameEl = fixture.debugElement.query(By.css(".username"));
    expect(usernameEl.nativeElement.textContent).toContain("Alice");
  });

  it("should show login link when not logged in", () => {
    localStorage.removeItem("username");
    component.loadUsername();
    fixture.detectChanges();

    const loginLink = fixture.debugElement.query(
      By.css('a[routerLink="/login"]')
    );
    expect(loginLink).toBeTruthy();
  });

  it("should clear username and navigate on logout", fakeAsync(() => {
    localStorage.setItem("username", "Bob");
    spyOn(router, "navigate");
    spyOn(window, "location", "get").and.returnValue({
      reload: jasmine.createSpy("reload"),
    });

    component.logout();

    expect(localStorage.getItem("username")).toBeNull();
    expect(component.username).toBeNull();
    expect(router.navigate).toHaveBeenCalledWith(["/login"]);

    tick(100); // simulate timeout
    expect(window.location.reload).toHaveBeenCalled();
  }));
});
